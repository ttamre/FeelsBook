/**
 *   Displays each feeling that is stored in the application
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
 */

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

        /* Get the feelingList, prepare it, then display */
        ListView listView = findViewById(R.id.viewHistoryListView);
        ArrayList<Feeling> list = MainActivity.feelingList.getFeelingList();
        final ArrayAdapter<Feeling> feelingAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, list);
        listView.setAdapter(feelingAdapter);

        /* Executes when a list item is pressed */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ViewHistoryActivity.this, EditEmotionActivity.class);

                /* Get the string representation of the feeling selected, search for it in the feelingList, and then pass the index
                 * to the next activity as an extra parameter */
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
