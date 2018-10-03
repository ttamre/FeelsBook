/**
 * Title: Add RecyclerView to your layout
 * Author: Android
 * Date published: September 25, 2018
 * Date accessed: October 1, 2018
 * Link: https://developer.android.com/guide/topics/ui/layout/recyclerview
 *
 * Copyright Android, Tem Tamre
 */

package ttamre.ca.ttamre_feelsbook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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
        ArrayAdapter<Feeling> feelingAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(feelingAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ViewHistoryActivity.this, EditEmotionActivity.class);
                String feelingString = ((TextView) view).getText().toString();
                Feeling targetFeeling = MainActivity.feelingList.searchFeelingList(feelingString);
                int index = MainActivity.feelingList.getIndex(targetFeeling);

                intent.putExtra("Index", index);
                startActivity(intent);
            }
        });
    }
}
