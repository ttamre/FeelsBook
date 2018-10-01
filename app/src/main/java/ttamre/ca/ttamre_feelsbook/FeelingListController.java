package ttamre.ca.ttamre_feelsbook;


public class FeelingListController {

    private static FeelingList feelingList = null;

    public FeelingList getFeelingList() {
        if (feelingList == null) {
            feelingList = new FeelingList();
        }

        return feelingList;
    }


    public Feeling getFeeling(int index) {
        return getFeelingList().getFeeling(index);
    }

    public void addFeeling(Feeling feeling) {
        getFeelingList().addFeeling(feeling);
    }

    public void editFeeling(Feeling feeling, String newComment) {
        getFeelingList().editFeeling(feeling, newComment);
    }

    public void removeFeeling(Feeling feeling) {
        getFeelingList().removeFeeling(feeling);
    }
}
