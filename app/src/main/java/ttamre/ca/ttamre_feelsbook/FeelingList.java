package ttamre.ca.ttamre_feelsbook;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
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
     * Adds a feeling to the feelingList
     *
     * @param feeling the feeling to be added
     */
    public void addFeeling(Feeling feeling) {
        feelingList.add(feeling);
    }

    /**
     * Edit the comment of an existing feeling if it exists in feelingList
     *
     * @param feeling the feeling to be edited
     * @param newComment the comment that will replace the old comment
     */
    public void editFeeling(Feeling feeling, String newComment) {
        if (feelingList.contains(feeling)) {
            feeling.setComment(newComment);
        } else {
            System.out.println("FeelingList.java -> editFeeling(): Feeling not in FeelingList");
        }
    }

    /**
     * Removes a feeling if it exits in feelingList
     * @param feeling the feeling to remove from the list
     */
    public void removeFeeling(Feeling feeling) {
        if (feelingList.contains(feeling)) {
            feelingList.remove(feeling);
        } else {
            System.out.println("FeelingList.java -> removeFeeling(): Feeling not in FeelingList");
        }
    }

    /**
     * Getter method to get the feelingList
     * @return feelingList: Collection<Feeling>
     */
    public Collection<Feeling> getFeelingList() {
        return feelingList;
    }

    /**
     * Counts the occurences of each feeling in feelingList and returns a Map of the feelings and
     *  their occurences. Uses the name of the feelings to distinguish each feeling,
     *  not the objects themselves.
     *
     * @return counts
     */
    public Map<String, Integer> getFeelingCount() {
        Map<String, Integer> counts = new HashMap<>();

        for (int i = 0; i < feelingList.size(); i++) {
            String name = feelingList.get(i).getName();

            if (!counts.keySet().contains(name)) {
                int occurences = Collections.frequency(feelingList, name);
                counts.put(name, occurences);
            }
        }

        return counts;
    }

    /**
     * Override of the arrayList.size method
     * @return the size of feelingList: int
     */
    public int size() {
        return feelingList.size();
    }

    /**
     * Override of the arrayList.contains method
     * @param feeling the feeling to be checked
     * @return true if the feeling is in feelingList, false otherwise
     */
    public boolean contains(Feeling feeling) {
        return feelingList.contains(feeling);
    }
}
