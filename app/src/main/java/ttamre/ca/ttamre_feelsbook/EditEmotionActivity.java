/*
 * The activity for ttamre-FeelsBook that allows users to edit their feelings.
 *  Allows for date and comment editing, as well as deletion of the feeling.
 *
 *  Copyright (C) 2018 Tem Tamre
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
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;

public class EditEmotionActivity extends AppCompatActivity {
    public static int time[] = new int[3];

    /**
     * Override of android's onCreate method
     *
     * Upon creation, we'll create objects to reference the buttons and calendar that appear
     * on screen, then we'll set their listeners
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("onCreate EditEmotionActivity");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_emotion);

        /* Create our Buttons and Calendar, and set their listeners */
        Button editEmotionSubmit = findViewById(R.id.editEmotionSubmit);
        Button editEmotionDelete = findViewById(R.id.editEmotionDelete);
        CalendarView editEmotionCalendar = findViewById(R.id.editEmotionCalendar);

        editEmotionSubmit.setOnClickListener(editEmotionListener);
        editEmotionDelete.setOnClickListener(editEmotionListener);
        editEmotionCalendar.setOnDateChangeListener(editEmotionDateListener);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     * Each button will use the same OnClickListener, which will perform a different operation
     * based on the ID of the button
     *
     * Code taken from StackOverflow, from user "Nguyen Minh Binh"
     *      https://stackoverflow.com/users/523325/nguyen-minh-binh
     *      https://stackoverflow.com/a/9989541
     *
     * Code for displaying a Toast taken from the android developer guide
     *      https://developer.android.com/guide/topics/ui/notifiers/toasts
     *
     * Code for adding an extra parameter to an intent taken from StackOverflow, from user "DavGin"
     *      https://stackoverflow.com/users/460426/davgin
     *      https://stackoverflow.com/a/3913735
     */
    private View.OnClickListener editEmotionListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Context context = getApplicationContext();
            Feeling feeling;

            /* Get the feeling that was added as an extra parameter */
            Bundle bundle = getIntent().getExtras();
            int index = bundle.getInt("Index");
            feeling = MainActivity.feelingList.getFeeling(index);

            switch (v.getId()) {
                case R.id.editEmotionSubmit:
                    /* Set that feeling's comment to the comment that the user inputted */
                    EditText inputText = findViewById(R.id.editEmotionInput);
                    String newComment = inputText.getText().toString();
                    MainActivity.feelingList.editFeeling(feeling, newComment);


                    Toast.makeText(context, "Comment edited", Toast.LENGTH_SHORT).show();
                    break;

                case R.id.editEmotionDelete:
                    MainActivity.feelingList.removeFeeling(feeling);

                    /* Save the change and let the user know */
                    MainActivity.saver.save(MainActivity.feelingList);
                    Toast.makeText(context, "Emotion deleted", Toast.LENGTH_SHORT).show();
                    break;
            }
            MainActivity.saver.save(MainActivity.feelingList);
            finish();
        }
    };


    /**
     * Creating the calendar's OnDateChangeListener object
     *
     * Code for displaying a Toast taken from the android developer guide
     *      https://developer.android.com/guide/topics/ui/notifiers/toasts
     */
    private CalendarView.OnDateChangeListener editEmotionDateListener = new CalendarView.OnDateChangeListener() {
        public void onSelectedDayChange(CalendarView view, int year, int month, int date) {
            Context context = getApplicationContext();

            /* Get the feeling that was added as an extra parameter */
            Bundle bundle = getIntent().getExtras();
            int index = bundle.getInt("Index");
            Feeling feeling = MainActivity.feelingList.getFeeling(index);

            /* Start EditTimeActivity so we can get the new time as well */
            startActivity(new Intent(EditEmotionActivity.this, EditTimeActivity.class));

            /* Set that feeling's date to the date that the user inputted */
            /* The -1900 is because the year parameter adds 1900 to the passed int */
            Date newDate = new Date(year - 1900, month, date, time[0], time[1], time[2]);
            MainActivity.feelingList.editFeeling(feeling, newDate);

            /* Save the change and let the user know */
            MainActivity.saver.save(MainActivity.feelingList);
            Toast.makeText(context, "Date edited", Toast.LENGTH_SHORT).show();
            finish();
        }
    };
}
