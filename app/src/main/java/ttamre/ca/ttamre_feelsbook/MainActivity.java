/**
 * TODO - This week
 *  1) Finish FeelingListController (look at finished StudentPicker code for help)
 *  2) Unit test FeelingListController (look at StudentPicker videos to see if you even need to)
 *  3) Look at the assignment spec and discussion forums to see if you're forgetting anything
 *  4) Build the UI for the app
 *
 * TODO - Next week
 *  5) Add file saving
 *  6) Testing and bug fixes
 *  7) Record video of the app running (read the spec again before recording)
 *  8) Make sure the submission is exactly as the spec says it should be
 */


package ttamre.ca.ttamre_feelsbook;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
