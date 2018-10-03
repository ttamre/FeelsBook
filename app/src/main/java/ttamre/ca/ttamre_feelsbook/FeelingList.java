package ttamre.ca.ttamre_feelsbook;

import android.content.res.Resources;
import android.util.Log;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FeelingList extends ArrayList{

    protected ArrayList<Feeling> feelingList;

    /**
     * Constructor method for the FeelingList class
     * Instantiates a new ArrayList to be used for storing all of our feelings
     */
    public FeelingList() {
       feelingList = new ArrayList<>();
    }


    /**
     * Returns the feeling at a given index
     * @param index the index of the feeling to retrieve
     * @return the Feeling at the given index
     */
    public Feeling getFeeling(int index) {
        try {
            Log.d("tagged-ttamre","FeelingList.java -> getFeeling(): Successfully retrieved " + feelingList.get(index) + " feelingList");
            return feelingList.get(index);
        } catch (IndexOutOfBoundsException e) {
            Log.e("tagged-ttamre", "FeelingList.java -> getFeeling(): Index out of bounds", e);
            return getFeeling(0);
        }
    }

    /**
     * Return the index of a feeling in the feelingList if it exists
     * @param feeling the feeling to search for
     * @return the index of that feeling (-1 on NotFoundException)
     */
    public int getIndex(Feeling feeling) {
        int index;

        try {
            index = feelingList.indexOf(feeling);
            Log.d("tagged-ttamre","FeelingList.java -> getIndex(): Successfully retrieved index: " + feeling + " at " + index);
        } catch (Resources.NotFoundException e) {
            Log.e("tagged-ttamre", "FeelingList.java -> getIndex(): Feeling not in FeelingList", e);
            index = -1;
        }

        return index;
    }


    /**
     * Adds a feeling to the feelingList
     * @param feeling the feeling to be added
     */
    public void addFeeling(Feeling feeling) {
        feelingList.add(feeling);
        Log.d("tagged-ttamre", "FeelingList.java -> addFeeling(): Successfully added " + feeling.toString());
    }


    /**
     * Edit the comment of an existing feeling if it exists in feelingList
     * @param feeling the feeling to be edited
     * @param newComment the comment that will replace the old comment
     */
    public void editFeeling(Feeling feeling, String newComment) {
        try {
            feeling.setComment(newComment);
            Log.d("tagged-ttamre","FeelingList.java -> editFeeling(): Successfully edited feelingList comment");
        } catch(Resources.NotFoundException e) {
            Log.e("tagged-ttamre","FeelingList.java -> editFeeling(): Feeling not in FeelingList", e);
        }
    }

    /**
     * Edit the date of an existing feeling if it exists in feelingList
     * @param feeling the feeling to be edited
     * @param newDate the date that will replace the old date
     */
    public void editFeeling(Feeling feeling, Date newDate) {
        try {
            feeling.setDate(newDate);
            Log.d("tagged-ttamre","FeelingList.java -> editFeeling(): Successfully edited feelingList date");
        } catch (Resources.NotFoundException e) {
            Log.e("tagged-ttamre", "FeelingList.java -> editFeeling(): Feeling not in FeelingList", e);
        }
    }

    /**
     * Removes a feeling if it exits in feelingList
     * @param feeling the feeling to remove from the list
     */
    public void removeFeeling(Feeling feeling) {
        try {
            feelingList.remove(feeling);
            Log.d("tagged-ttamre","FeelingList.java -> removeFeeling(): Successfully removed " + feeling + " from feelingList");
        } catch (Resources.NotFoundException e) {
            Log.e("tagged-ttamre", "FeelingList.java -> removeFeeling(): Feeling not in FeelingList", e);
        }
    }


    /**
     * Getter method to get the feelingList
     * @return feelingList: Collection<Feeling>
     */
    public ArrayList<Feeling> getFeelingList() {
        return feelingList;
    }


    /**
     * Counts the occurrences of each feeling in feelingList and returns a Map of the feelings and
     *  their occurrences. Uses the name of the feelings to distinguish each feeling,
     *  not the objects themselves.
     *
     *  The code used to update the counts was taken from JavaConceptOfTheDay, from user pramodbablad
     *      https://javaconceptoftheday.com/author/pramodbablad/
     *      https://javaconceptoftheday.com/count-occurrences-of-each-element-in-an-array/
     *
     * @return Occurrence count of the format {feelingName: String, count: Integer}
     */
    public Map<String, Integer> getFeelingCount() {
        Map<String, Integer> counts = new HashMap<>();

        for (Feeling feeling: feelingList) {
            String name = feeling.getName();

            if (counts.keySet().contains(name)) {
                counts.put(name, counts.get(name) + 1);
            } else {
                counts.put(name, 1);
            }
        }

        Log.d("tagged-ttamre","FeelingList.java -> getFeelingList(): Successfully retrieved counts: " + counts.toString());
        return counts;
    }

    public Feeling searchFeelingList(String targetString) {
        Feeling targetFeeling = null;
        for (Feeling feeling: feelingList) {
            if (feeling.toString().equals(targetString)) { targetFeeling = feeling; }
        }

        return targetFeeling;
    }

    /**
     * Gets the amount of unique feeling types in the feelingList (max 6)
     * @return
     */
    public int uniqueSize() {
        ArrayList<String> feelingTypes = new ArrayList<>();

        for (Feeling feeling: feelingList) {
            if (!feelingTypes.contains(feeling.getName())) { feelingTypes.add(feeling.getName()); }
        }

        return feelingTypes.size();
    }

    /**
     * Override of the arrayList.size() method
     * @return the size of feelingList: int
     */
    public int size() {
        return feelingList.size();
    }

    /**
     * Override of the arrayList.contains() method
     * @param feeling the feeling to be checked
     * @return true if the feeling is in feelingList, false otherwise
     */
    public boolean contains(Feeling feeling) {
        return feelingList.contains(feeling);
    }
}
