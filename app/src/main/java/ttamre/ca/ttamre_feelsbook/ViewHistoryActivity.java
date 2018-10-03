package ttamre.ca.ttamre_feelsbook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class ViewHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_history);

        ListView listView = findViewById(R.id.viewHistoryListView);
        ArrayList<Feeling> list = MainActivity.feelingList.getFeelingList();
        final ArrayAdapter<Feeling> feelingAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(feelingAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ViewHistoryActivity.this, EditEmotionActivity.class);
                String feelingString = ((TextView) view).getText().toString();
                Feeling targetFeeling = MainActivity.feelingList.searchFeelingList(feelingString);
                int index = MainActivity.feelingList.getIndex(targetFeeling);

                /*
                 * Code for adding an extra parameter to an intent taken from StackOverflow, from user "DavGin"
                 *      https://stackoverflow.com/users/460426/davgin
                 *      https://stackoverflow.com/a/3913735
                 *
                 * Code for starting an activity for a result taken from StackOverflow, from user "Sudarshan Bhat"
                 *      https://stackoverflow.com/users/1866009/dennis
                 *      https://stackoverflow.com/q/13643940
                 */
                intent.putExtra("Index", index);
                startActivityForResult(intent, 0);
            }
        });
    }
}
