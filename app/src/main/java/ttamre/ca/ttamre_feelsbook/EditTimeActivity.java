/*
 * Copyright (C) 2018 Tem Tamre
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package ttamre.ca.ttamre_feelsbook;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class EditTimeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_time);

        Button editTimeSubmit = findViewById(R.id.editTimeSubmit);
        editTimeSubmit.setOnClickListener(editTimeListener);

        /* These values will be used if the user doesn't attempt an input */
        Calendar now = Calendar.getInstance();
        EditEmotionActivity.time[0] = now.get(Calendar.HOUR_OF_DAY);
        EditEmotionActivity.time[1] = now.get(Calendar.MINUTE);
        EditEmotionActivity.time[2] = now.get(Calendar.SECOND);
    }

    private View.OnClickListener editTimeListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Bundle bundle = getIntent().getExtras();
            Context context = getApplicationContext();

            /* Regex string from https://stackoverflow.com/a/25873711 */
            String regex = "(?:[01]\\d|2[0123]):(?:[012345]\\d):(?:[012345]\\d)";

            EditText inputText = findViewById(R.id.editTimeInput);
            String timeString = inputText.getText().toString();

            int index = bundle.getInt("Index");
            int year = bundle.getInt("Year");
            int month = bundle.getInt("Month");
            int date = bundle.getInt("Date");
            int time[] = new int[3];


            /* The user's input will be used if it is valid */
            if (timeString.matches(regex)) {
                time[0] = Integer.parseInt(timeString.substring(0, 2));
                time[1] = Integer.parseInt(timeString.substring(3, 5));
                time[2] = Integer.parseInt(timeString.substring(6, 8));
            } else {
                /* These values will be used if the user attempts an invalid input */
                Calendar now = Calendar.getInstance();
                time[0] = now.get(Calendar.HOUR_OF_DAY);
                time[1] = now.get(Calendar.MINUTE);
                time[2] = now.get(Calendar.SECOND);
                Toast.makeText(getApplicationContext(), "Invalid input, using current time instead", Toast.LENGTH_SHORT).show();
            }

            /* Set that feeling's date to the date that the user inputted */
            /* The -1900 is because the year parameter adds 1900 to the passed int */
            Date newDate = new Date(year - 1900, month, date, time[0], time[1], time[2]);
            Feeling feeling = MainActivity.feelingList.getFeeling(index);
            MainActivity.feelingList.editFeeling(feeling, newDate);

            /* Save the change and let the user know */
            MainActivity.saver.save(MainActivity.feelingList);
            Toast.makeText(context, "Date edited", Toast.LENGTH_SHORT).show();
            finish();
        }
    };
}
