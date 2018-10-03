package ttamre.ca.ttamre_feelsbook;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Map;

public class ViewCountsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_history);
        ListView listView = findViewById(R.id.viewHistoryListView);

        /* Get the Map<String, Integer> of the counts, then separate the keys and values into
         *  their own ArrayLists. Then, concatenate each key and value into a pair and put them in
         *  a master ArrayList, and render that in the view */
        Map<String, Integer> countsMap = MainActivity.feelingList.getFeelingCount();
        ArrayList<String> countsArray = new ArrayList<>();

        ArrayList<String> countsMapKeys = new ArrayList<>(countsMap.keySet());
        ArrayList<Integer> countsMapValues = new ArrayList<>(countsMap.values());

        System.out.println(MainActivity.feelingList.size());
        System.out.println(countsMapKeys.size());
        System.out.println(countsMapValues.size());
        for (int i = 0; i < MainActivity.feelingList.uniqueSize(); i++) {
            String key = countsMapKeys.get(i);
            Integer val = countsMapValues.get(i);
            countsArray.add(key + ": " + val.toString());
        }

        final ArrayAdapter<String> feelingAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countsArray);
        listView.setAdapter(feelingAdapter);
    }
}
