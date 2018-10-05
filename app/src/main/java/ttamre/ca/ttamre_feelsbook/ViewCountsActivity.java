/*
 * The activity for ttamre-FeelsBook that allows users to view the counts of their recorded feelings.
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
 */

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

        for (int i = 0; i < MainActivity.feelingList.uniqueSize(); i++) {
            String key = countsMapKeys.get(i);
            Integer val = countsMapValues.get(i);
            countsArray.add(key + ": " + val.toString());
        }

        /* Displays the listView */
        final ArrayAdapter<String> feelingAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, countsArray);
        listView.setAdapter(feelingAdapter);
    }
}
