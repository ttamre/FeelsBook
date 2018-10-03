package ttamre.ca.ttamre_feelsbook;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Calendar;
import java.util.Date;

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

                /* Get the feeling */
                Bundle bundle = getIntent().getExtras();
                int index = bundle.getInt("Index");
                Feeling feeling = MainActivity.feelingList.getFeeling(index);

                /* Set that feeling's comment to the comment that the user inputted */
                EditText inputText = findViewById(R.id.editEmotionInput);
                String newComment = inputText.getText().toString();
                MainActivity.feelingList.editFeeling(feeling, newComment);

                Toast.makeText(context, "Comment edited", Toast.LENGTH_SHORT).show();
                }});
    }
}
