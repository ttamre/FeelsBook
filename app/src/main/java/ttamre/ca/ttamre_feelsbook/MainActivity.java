/*
 * The launcher activity for the ttamre-FeelsBook android application
 *  Users can add feelings (and edit them immediately), view their feeling history,
 *  or view the counts of each type of feeling.
 *
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
 *
 *
 *  TODO
 *      - Time editing
 *      - Device testing
 *      - Record video
 *      - Upload APK
 *      - Submit (re-read specs and entire forum)
 */

package ttamre.ca.ttamre_feelsbook;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    public static FeelingList feelingList;
    public static FeelingSaver saver;

    /**
     * When the view is created, create all of our button objects and attach listeners to them
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        saver = new FeelingSaver(getApplicationContext());
        feelingList = saver.load();

        /* Create all the Button objects */
        Button loveButton = findViewById(R.id.loveButton);
        Button joyButton = findViewById(R.id.joyButton);
        Button surpriseButton = findViewById(R.id.surpriseButton);
        Button angerButton = findViewById(R.id.angerButton);
        Button sadnessButton = findViewById(R.id.sadnessButton);
        Button fearButton = findViewById(R.id.fearButton);
        Button viewCountsButton = findViewById(R.id.viewCountsButton);
        Button viewHistoryButton = findViewById(R.id.viewHistoryButton);

        /* Set all the listeners for the buttons we just created */
        loveButton.setOnClickListener(mainActivityListener);
        joyButton.setOnClickListener(mainActivityListener);
        surpriseButton.setOnClickListener(mainActivityListener);
        angerButton.setOnClickListener(mainActivityListener);
        sadnessButton.setOnClickListener(mainActivityListener);
        fearButton.setOnClickListener(mainActivityListener);
        viewCountsButton.setOnClickListener(mainActivityListener);
        viewHistoryButton.setOnClickListener(mainActivityListener);
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
    private View.OnClickListener mainActivityListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Context context = getApplicationContext();
            Feeling feeling;
            Intent intent;

            /* TODO make this switch-case a little cleaner (too much repeat code) */
            switch(v.getId()) {
                case R.id.loveButton:
                    /* Create a feeling and add it to the feelingList */
                    feeling = new Feeling("Love");
                    feelingList.addFeeling(feeling);
                    Toast.makeText(context, "Recorded " + feeling.getName(), Toast.LENGTH_SHORT).show();

                    /* Create a new intent, give it the index of the feeling to be edited, then start it */
                    intent = new Intent(MainActivity.this, EditEmotionActivity.class);
                    intent.putExtra("Index", feelingList.getIndex(feeling));
                    break;

                case R.id.joyButton:
                    /* Create a feeling and add it to the feelingList */
                    feeling = new Feeling("Joy");
                    feelingList.addFeeling(feeling);
                    Toast.makeText(context, "Recorded " + feeling.getName(), Toast.LENGTH_SHORT).show();

                    /* Create a new intent, give it the index of the feeling to be edited, then start it */
                    intent = new Intent(MainActivity.this, EditEmotionActivity.class);
                    intent.putExtra("Index", feelingList.getIndex(feeling));
                    break;

                case R.id.surpriseButton:
                    /* Create a feeling and add it to the feelingList */
                    feeling = new Feeling("Surprise");
                    feelingList.addFeeling(feeling);
                    Toast.makeText(context, "Recorded " + feeling.getName(), Toast.LENGTH_SHORT).show();

                    /* Create a new intent, give it the index of the feeling to be edited, then start it */
                    intent = new Intent(MainActivity.this, EditEmotionActivity.class);
                    intent.putExtra("Index", feelingList.getIndex(feeling));
                    break;

                case R.id.angerButton:
                    /* Create a feeling and add it to the feelingList */
                    feeling = new Feeling("Anger");
                    feelingList.addFeeling(feeling);
                    Toast.makeText(context, "Recorded " + feeling.getName(), Toast.LENGTH_SHORT).show();

                    /* Create a new intent, give it the index of the feeling to be edited, then start it */
                    intent = new Intent(MainActivity.this, EditEmotionActivity.class);
                    intent.putExtra("Index", feelingList.getIndex(feeling));
                    break;

                case R.id.sadnessButton:
                    /* Create a feeling and add it to the feelingList */
                    feeling = new Feeling("Sadness");
                    feelingList.addFeeling(feeling);
                    Toast.makeText(context, "Recorded " + feeling.getName(), Toast.LENGTH_SHORT).show();

                    /* Create a new intent, give it the index of the feeling to be edited, then start it */
                    intent = new Intent(MainActivity.this, EditEmotionActivity.class);
                    intent.putExtra("Index", feelingList.getIndex(feeling));
                    break;

                case R.id.fearButton:
                    /* Create a feeling and add it to the feelingList */
                    feeling = new Feeling("Fear");
                    feelingList.addFeeling(feeling);
                    Toast.makeText(context, "Recorded " + feeling.getName(), Toast.LENGTH_SHORT).show();

                    /* Create a new intent, give it the index of the feeling to be edited, then start it */
                    intent = new Intent(MainActivity.this, EditEmotionActivity.class);
                    intent.putExtra("Index", feelingList.getIndex(feeling));
                    break;

                case R.id.viewHistoryButton:
                    intent = new Intent(MainActivity.this, ViewHistoryActivity.class);
                    break;

                case R.id.viewCountsButton:
                    intent = new Intent(MainActivity.this, ViewCountsActivity.class);
                    break;

                default:
                    intent = new Intent(MainActivity.this, MainActivity.class);
                    break;
            }

            /* Saves data when a feeling is first created (redundant when ViewCounts or ViewHistory is launched) */
            saver.save(feelingList);
            startActivity(intent);
        }
    };
}
