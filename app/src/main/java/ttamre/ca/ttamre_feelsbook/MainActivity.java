/**
 *  TODO Monday
 *      - All of ViewHistory
 *          1) Get recycler to update properly
 *          2) Add ability to tap to edit
 *          3) Add ability to swipe to delete
 *  TODO Tuesday
 *      - All of ViewCounts
 *      - Run any tests and fix any bugs that still exist
 *
 *  TODO Wednesday
 *      - Update UML, README, and any other docs
 *      - Test build on lab machines
 *      - Record video of the app running (read spec before recording)
 *      - Submit assignment (read spec and forums before recording)
 *
 *  NOTE
 *      - Date will be converted to iso8601 when it is about to be rendered, not when instantiated
 *          * this allows for date methods to be used (comparisons, etc) *
 */


package ttamre.ca.ttamre_feelsbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

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
     */
    private View.OnClickListener ocl = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch(v.getId()) {
                case R.id.loveButton: feelingList.addFeeling(new Feeling("Love"));
                    break;
                case R.id.joyButton: feelingList.addFeeling(new Feeling("Joy"));
                    break;
                case R.id.surpriseButton: feelingList.addFeeling(new Feeling("Surprise"));
                    break;
                case R.id.angerButton: feelingList.addFeeling(new Feeling("Anger"));
                    break;
                case R.id.sadnessButton: feelingList.addFeeling(new Feeling("Sadness"));
                    break;
                case R.id.fearButton: feelingList.addFeeling(new Feeling("Fear"));
                    break;
                case R.id.viewHistoryButton: startActivity(new Intent(MainActivity.this, ViewHistoryActivity.class));
                    break;
                case R.id.viewCountsButton: startActivity(new Intent(MainActivity.this, ViewHistoryActivity.class));
                    break;
            }}};
}
