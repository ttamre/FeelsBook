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

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
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
            textView = v.findViewById(R.id.viewHistoryRecycler);
        }
    }

    // Provide a suitable constructor (depends on the kind of dataset)
    public FeelingHistoryAdapter(FeelingList newList) {
        feelingList = newList;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public FeelingListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create a new view

        Log.d("tagged-ttamre", "FeelingHistoryAdapter.java -> onCreateViewHolder(): Entered function");

        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        TextView textView = (TextView) inflater.inflate(android.R.layout.activity_list_item, parent, false);

        Log.d("tagged-ttamre", "FeelingHistoryAdapter.java -> onCreateViewHolder(): Returning a FeelingListViewHolder");

        return new FeelingListViewHolder(textView);
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(FeelingListViewHolder holder, int position) {
        // - get element from your dataset at this position
        // - replace the contents of the view with that element
        System.out.println("Holder: " + holder.toString());
        Log.d("tagged-ttamre", "FeelingHistoryAdapter.java -> onBindViewHolder(): Attempting to set item in RecyclerView: " + feelingList.getFeeling(position).toString());
        String feelingText = feelingList.getFeeling(position).toString();
        holder.textView.setText(feelingText);
        Log.d("tagged-ttamre", "FeelingHistoryAdapter.java -> onBindViewHolder(): Successfully set item in RecyclerView: " + feelingList.getFeeling(position).toString());
    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return feelingList.size();
    }
}