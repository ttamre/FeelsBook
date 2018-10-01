/**
 *  TODO Monday
 *      - Build the rest of the UI
 *
 *  TODO Tuesday
 *      - Finish basic functionality (file saving is last priority)
 *      - Run tests
 *
 *  TODO Wednesday
 *      - Run any tests and fix any bugs that still exist
 *      - Test build on lab machines
 *      - Update UML, README, and any other docs
 *
 *  TODO Thursday
 *      - Record video of the app running (read spec before recording)
 *      - Submit assignment (read spec and forums before recording)
 *
 *  NOTE
 *      - Date will be converted to iso8601 when it is about to be rendered, not when instantiated
 *          * this allows for date methods to be used (comparisons, etc) *
 */


package ttamre.ca.ttamre_feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.util.Date;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final FeelingList feelingList = new FeelingList();

        Button loveButton = findViewById(R.id.loveButton);
        Button joyButton = findViewById(R.id.joyButton);
        Button surpriseButton = findViewById(R.id.surpriseButton);
        Button angerButton = findViewById(R.id.angerButton);
        Button sadnessButton = findViewById(R.id.sadnessButton);
        Button fearButton = findViewById(R.id.fearButton);

        Button viewCountsButton = findViewById(R.id.viewCountsButton);
        Button viewHistoryButton = findViewById(R.id.viewHistoryButton);



        loveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feelingList.addFeeling(new Feeling("Love"));
            }
        });

        joyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feelingList.addFeeling(new Feeling("Joy"));
            }
        });

        surpriseButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feelingList.addFeeling(new Feeling("Surprise"));
            }
        });

        angerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feelingList.addFeeling(new Feeling("Anger"));
            }
        });

        sadnessButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feelingList.addFeeling(new Feeling("Sadness"));
            }
        });

        fearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feelingList.addFeeling(new Feeling("Fear"));
            }
        });

        /*
         * Code taken from StackOverflow users "Gilad Haimov" and "Dominik"
         * https://stackoverflow.com/users/605111/gilad-haimov
         * https://stackoverflow.com/users/4443105/dominik
         *
         * Comment code was taken from:
         * https://stackoverflow.com/a/24610673
         */
        viewCountsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // startActivity(new Intent(MainActivity.this, ViewCountsActivity.class));
            }
        });

        /*
         * Code taken from StackOverflow users "Gilad Haimov" and "Dominik"
         * https://stackoverflow.com/users/605111/gilad-haimov
         * https://stackoverflow.com/users/4443105/dominik
         *
         * Comment code was taken from:
         * https://stackoverflow.com/a/24610673
         */
        viewHistoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // startActivity(new Intent(MainActivity.this, ViewHistoryActivity.class));
            }
        });


    }

}
