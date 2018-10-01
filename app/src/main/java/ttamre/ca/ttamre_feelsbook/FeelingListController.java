package ttamre.ca.ttamre_feelsbook;


import java.util.Date;

public class FeelingListController {

    private static FeelingList feelingList = null;

    /**
     * Returns the feelingList, creating a new one if one doesn't already exist
     * @return feelingList
     */
    private FeelingList getFeelingList() {
        if (feelingList == null) { feelingList = new FeelingList(); }
        return feelingList;
    }


    /**
     * Retrieves a feeling from the feelingList at the given index
     * @param index the index of the item to retrieve
     * @return the feeling at the given index
     */
    public Feeling getFeeling(int index) {
        return getFeelingList().getFeeling(index);
    }


    /**
     * Adds a feeling to the feelingList
     * @param feeling the feeling to be added
     */
    public void addFeeling(Feeling feeling) {
        getFeelingList().addFeeling(feeling);
    }


    /**
     * Edits the comment of an existing feeling
     * @param feeling the feeling to edit
     * @param newComment the new comment to add to the feeling
     */
    public void editFeeling(Feeling feeling, String newComment) {
        getFeelingList().editFeeling(feeling, newComment);
    }

    /**
     * Edits the date of an existing feeling
     * @param feeling the feeling to edit
     * @param newDate the new date to add to the feeling
     */
    public void editFeeling(Feeling feeling, Date newDate) {
        getFeelingList().editFeeling(feeling, newDate);
    }

    /**
     * Removes a feeling from the feelingList
     * @param feeling the feeling to remove
     */
    public void removeFeeling(Feeling feeling) {
        getFeelingList().removeFeeling(feeling);
    }
}
