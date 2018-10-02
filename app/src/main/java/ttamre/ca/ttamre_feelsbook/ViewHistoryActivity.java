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

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class ViewHistoryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_history);
        RecyclerView recyclerView = findViewById(R.id.viewHistoryRecycler);

        // Since the layout won't change size based on the amount of items in view, we can set the
        // size to be fixed, which should improve performance
        recyclerView.setHasFixedSize(true);

        // Create a recyclerManager and attach it to the recyclerView
        RecyclerView.LayoutManager recyclerManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(recyclerManager);

        // Create a recyclerAdapter and attach it to the recyclerView
        RecyclerView.Adapter recyclerAdapter = new FeelingHistoryAdapter(MainActivity.feelingList);
        recyclerView.setAdapter(recyclerAdapter);
    }
}
