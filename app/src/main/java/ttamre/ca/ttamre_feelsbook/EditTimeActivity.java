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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

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

            /* Regex string from https://stackoverflow.com/a/25873711 */
            String regex = "(?:[01]\\d|2[0123]):(?:[012345]\\d):(?:[012345]\\d)";

            EditText inputText = findViewById(R.id.editTimeInput);
            String timeString = inputText.getText().toString();


            /* The user's input will be used if it is valid */
            if (timeString.matches(regex)) {
                EditEmotionActivity.time[0] = Integer.parseInt(timeString.substring(0, 2));
                EditEmotionActivity.time[1] = Integer.parseInt(timeString.substring(3, 5));
                EditEmotionActivity.time[2] = Integer.parseInt(timeString.substring(6, 8));
            } else {
                /* These values will be used if the user attempts an invalid input */
                Calendar now = Calendar.getInstance();
                EditEmotionActivity.time[0] = now.get(Calendar.HOUR_OF_DAY);
                EditEmotionActivity.time[1] = now.get(Calendar.MINUTE);
                EditEmotionActivity.time[2] = now.get(Calendar.SECOND);
                Toast.makeText(getApplicationContext(), "Invalid input, using current time instead", Toast.LENGTH_SHORT).show();
            }
            finish();
        }
    };
}
