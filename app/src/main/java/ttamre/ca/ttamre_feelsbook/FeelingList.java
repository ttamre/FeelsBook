package ttamre.ca.ttamre_feelsbook;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FeelingList extends ArrayList{

    protected ArrayList<Feeling> feelingList = null;

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
            return feelingList.get(index);
        } catch (IndexOutOfBoundsException e) {
            e.printStackTrace();
            return getFeeling(0);
        }
    }


    /**
     * Adds a feeling to the feelingList
     * @param feeling the feeling to be added
     */
    public void addFeeling(Feeling feeling) {
        feelingList.add(feeling);
        System.out.println("Added " + feeling.toString() + " to feelingList");
    }


    /**
     * Edit the comment of an existing feeling if it exists in feelingList
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
     * Edit the date of an existing feeling if it exists in feelingList
     * @param feeling the feeling to be edited
     * @param newDate the date that will replace the old date
     */
    public void editFeeling(Feeling feeling, Date newDate) {
        if (feelingList.contains(feeling)) {
            feeling.setDate(newDate);
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

        return counts;
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
