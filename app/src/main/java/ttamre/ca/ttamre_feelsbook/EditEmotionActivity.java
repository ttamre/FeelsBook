/**
 *   Allows users to edit emotions within the application
 *
 *     Copyright (C) 2018 Tem Tamre
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package ttamre.ca.ttamre_feelsbook;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;
import java.util.GregorianCalendar;

public class EditEmotionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_emotion);

        /* Create our Button and CalendarView objects */
        Button editEmotionButton = findViewById(R.id.editEmotionButton);

        /* Set their listeners
         * Code for displaying a Toast taken from the android developer guide
         *      https://developer.android.com/guide/topics/ui/notifiers/toasts
         */
        editEmotionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context context = getApplicationContext();

                /* Get the feeling that was added as an extra parameter */
                Bundle bundle = getIntent().getExtras();
                int index = bundle.getInt("Index");
                Feeling feeling = MainActivity.feelingList.getFeeling(index);

                /* Set that feeling's comment to the comment that the user inputted */
                EditText inputText = findViewById(R.id.editEmotionInput);
                String newComment = inputText.getText().toString();
                MainActivity.feelingList.editFeeling(feeling, newComment);

                /*
                 * Code for updating the dataset from another activity taken from StackOverflow, from user "Sudarshan Bhat"
                 *      https://stackoverflow.com/users/1866009/dennis
                 *      https://stackoverflow.com/q/13643940
                 */
                Intent intent = new Intent();
                intent.putExtra("updatedComment", newComment);
                setResult(RESULT_OK, intent);
                finish();

                Toast.makeText(context, "Comment edited", Toast.LENGTH_SHORT).show();
            }});

        CalendarView v = findViewById(R.id.editEmotionCalendar);
        v.setOnDateChangeListener( new CalendarView.OnDateChangeListener() {
            public void onSelectedDayChange(CalendarView view, int year, int month, int date) {
                Context context = getApplicationContext();

                /* Get the feeling that was added as an extra parameter */
                Bundle bundle = getIntent().getExtras();
                int index = bundle.getInt("Index");
                Feeling feeling = MainActivity.feelingList.getFeeling(index);

                /* Set that feeling's date to the date that the user inputted */
                Date newDate = new Date(year-1900, month, date);
                MainActivity.feelingList.editFeeling(feeling, newDate);

                /*
                 * Code for updating the dataset from another activity taken from StackOverflow, from user "Sudarshan Bhat"
                 *      https://stackoverflow.com/users/1866009/dennis
                 *      https://stackoverflow.com/q/13643940
                 */
                Intent intent = new Intent();
                intent.putExtra("updatedComment", newDate);
                setResult(RESULT_OK, intent);
                finish();

                Toast.makeText(context, "Date edited", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
