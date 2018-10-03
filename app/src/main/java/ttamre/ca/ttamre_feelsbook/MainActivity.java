/**
 *   The launcher activity for the ttamre-FeelsBook android application
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
 *
 *     TODO Wednesday
 *          - Test on lab machines
 *          - Update UML (add activities)
 *          - ViewHistoryActivity (delete)
 *
 *     TODO Thursday
 *          - Add persistence and date editing
 *          - Record video (re-read entire spec and forums beforehand)
 *          - Submit assignment
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
    public static final FeelingList feelingList = new FeelingList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
        loveButton.setOnClickListener(ocl);
        joyButton.setOnClickListener(ocl);
        surpriseButton.setOnClickListener(ocl);
        angerButton.setOnClickListener(ocl);
        sadnessButton.setOnClickListener(ocl);
        fearButton.setOnClickListener(ocl);
        viewCountsButton.setOnClickListener(ocl);
        viewHistoryButton.setOnClickListener(ocl);
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
    private View.OnClickListener ocl = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Context context = getApplicationContext();
            Feeling feeling;
            Intent intent;

            switch(v.getId()) {
                case R.id.loveButton:
                    /* Create a feeling and add it to the feelingList */
                    feeling = new Feeling("Love");
                    feelingList.addFeeling(feeling);
                    Toast.makeText(context, "Recorded Love", Toast.LENGTH_SHORT).show();

                    /* Create a new intent, give it the index of the feeling to be edited, then start it */
                    intent = new Intent(MainActivity.this, EditEmotionActivity.class);
                    intent.putExtra("Index", feelingList.getIndex(feeling));
                    startActivity(intent);

                    break;
                case R.id.joyButton:
                    /* Create a feeling and add it to the feelingList */
                    feeling = new Feeling("Joy");
                    feelingList.addFeeling(feeling);
                    Toast.makeText(context, "Recorded Joy", Toast.LENGTH_SHORT).show();

                    /* Create a new intent, give it the index of the feeling to be edited, then start it */
                    intent = new Intent(MainActivity.this, EditEmotionActivity.class);
                    intent.putExtra("Index", feelingList.getIndex(feeling));
                    startActivity(intent);

                    break;
                case R.id.surpriseButton:
                    /* Create a feeling and add it to the feelingList */
                    feeling = new Feeling("Surprise");
                    feelingList.addFeeling(feeling);
                    Toast.makeText(context, "Recorded Surprise", Toast.LENGTH_SHORT).show();

                    /* Create a new intent, give it the index of the feeling to be edited, then start it */
                    intent = new Intent(MainActivity.this, EditEmotionActivity.class);
                    intent.putExtra("Index", feelingList.getIndex(feeling));
                    startActivity(intent);

                    break;
                case R.id.angerButton:
                    /* Create a feeling and add it to the feelingList */
                    feeling = new Feeling("Anger");
                    feelingList.addFeeling(feeling);
                    Toast.makeText(context, "Recorded Anger", Toast.LENGTH_SHORT).show();

                    /* Create a new intent, give it the index of the feeling to be edited, then start it */
                    intent = new Intent(MainActivity.this, EditEmotionActivity.class);
                    intent.putExtra("Index", feelingList.getIndex(feeling));
                    startActivity(intent);

                    break;
                case R.id.sadnessButton:
                    /* Create a feeling and add it to the feelingList */
                    feeling = new Feeling("Sadness");
                    feelingList.addFeeling(feeling);
                    Toast.makeText(context, "Recorded Sadness", Toast.LENGTH_SHORT).show();

                    /* Create a new intent, give it the index of the feeling to be edited, then start it */
                    intent = new Intent(MainActivity.this, EditEmotionActivity.class);
                    intent.putExtra("Index", feelingList.getIndex(feeling));
                    startActivity(intent);

                    break;
                case R.id.fearButton:
                    /* Create a feeling and add it to the feelingList */
                    feeling = new Feeling("Fear");
                    feelingList.addFeeling(feeling);
                    Toast.makeText(context, "Recorded Fear", Toast.LENGTH_SHORT).show();

                    /* Create a new intent, give it the index of the feeling to be edited, then start it */
                    intent = new Intent(MainActivity.this, EditEmotionActivity.class);
                    intent.putExtra("Index", feelingList.getIndex(feeling));
                    startActivity(intent);

                    break;
                case R.id.viewHistoryButton: startActivity(new Intent(MainActivity.this, ViewHistoryActivity.class));
                    break;
                case R.id.viewCountsButton: startActivity(new Intent(MainActivity.this, ViewCountsActivity.class));
                    break;
            }}};
}
