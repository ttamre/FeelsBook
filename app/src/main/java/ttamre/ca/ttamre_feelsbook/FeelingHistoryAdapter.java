/**
 * Title: Add a list adapter
 * Author: Android
 * Date published: September 25, 2018
 * Date accessed: October 1, 2018
 * Link: https://developer.android.com/guide/topics/ui/layout/recyclerview
 *
 * Copyright Android, Tem Tamre
 */

package ttamre.ca.ttamre_feelsbook;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

public class FeelingHistoryAdapter extends RecyclerView.Adapter<FeelingHistoryAdapter.FeelingListViewHolder> {
    private FeelingList feelingList;

    // Provide a reference to the views for each data item
    // Complex data items may need more than one view per item, and
    // you provide access to all the views for a data item in a view holder
    public static class FeelingListViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public TextView textView;
        public FeelingListViewHolder(TextView v) {
            super(v);
            textView = v;
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public FeelingHistoryAdapter(FeelingList newList) {
        feelingList = newList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public FeelingListViewHolder onCreateViewHolder(ViewGroup parent,
                                                    int viewType) {
        // create a new view
        TextView v = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_view_history, parent, false);
        String info = v.findViewById(R.id.viewHistoryRecycler).toString();
        return new FeelingListViewHolder(v);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(FeelingListViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        holder.textView.setText(feelingList.getFeeling(position).toString());

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return feelingList.size();
    }
}