package ttamre.ca.ttamre_feelsbook;

import junit.framework.TestCase;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Map;

public class FeelingListTest extends TestCase {

    /**
     * Tests the creation of a FeelingList instance
     * Assertion fails if feelingList is empty (relies on the size() method)
     */
    @Test
    public void testCreate() {
        FeelingList feelingList = new FeelingList();
        assertTrue("AssertionError: Default Constructor for FeelingList", feelingList.size() == 0);
    }

    /**
     * Tests the retrieval of a feeling based on it's index in feelingList
     * Assertions will fail if the feeling isn't able to be retrieved
     */
    @Test
    public void testGetFeeling() {
        Feeling feelingA = new Feeling("FeelingA", "CommentA");
        Feeling feelingB = new Feeling("FeelingB", "CommentB");

        FeelingList feelingList = new FeelingList();
        feelingList.addFeeling(feelingA);
        feelingList.addFeeling(feelingB);

        System.out.println(feelingList.getFeeling(0));
        System.out.println(feelingA);
        System.out.println(feelingList.getFeeling(1));
        System.out.println(feelingB);

        assertEquals("AssertionError: feelingList.getFeeling(), A", feelingList.getFeeling(0), feelingA);
        assertEquals("AssertionError: feelingList.getFeeling(), B", feelingList.getFeeling(1), feelingB);
    }

    /**
     * Tests the addition of a feeling to the feelingList
     * Assertions fail if the feelingList doesn't contain the feeling that was added to it
     */
    @Test
    public void testAddFeeling() {
        FeelingList feelingList = new FeelingList();


        Feeling feelingA = new Feeling("FeelingA", "CommentA");
        feelingList.addFeeling(feelingA);
        assertTrue("AssertionError: feelingList.addFeeling(), feelingList.contains(), feelingA", feelingList.contains(feelingA));

        Feeling feelingB = new Feeling("FeelingB", "CommentB");
        feelingList.addFeeling(feelingB);
        assertTrue("AssertionError: feelingList.addFeeling(), feelingList.contains(), feelingB", feelingList.contains(feelingB));
    }

    /**
     * Tests the editing of feelings in the feelingList
     * Assertions fail if the comment isn't equal to the new comment that was edited in
     */
    @Test
    public void testEditFeeling() {
        Feeling feelingA = new Feeling("FeelingA", "CommentA");
        Feeling feelingB = new Feeling("FeelingB", "CommentB");
        String newCommentA = "newCommentA";
        String newCommentB = "newCommentB";

        FeelingList feelingList = new FeelingList();
        feelingList.addFeeling(feelingA);
        feelingList.addFeeling(feelingB);

        feelingList.editFeeling(feelingA, newCommentA);
        feelingList.editFeeling(feelingB, newCommentB);

        Feeling a = feelingList.getFeeling(0);
        assertEquals("AssertionError: feelingList.editFeeling, A", a.getComment(), newCommentA);

        Feeling b = feelingList.getFeeling(1);
        assertEquals("AssertionError: feelingList.editFeeling, B", b.getComment(), newCommentB);
    }

    /**
     * Tests the removal of feelings from the feelingList
     * Assertions fail if
     *      a) feelingList doesn't contain just 1 item
     *      b) the one item in feelingList isn't the feeling that wasn't removed
     */
    @Test
    public void testRemoveFeeling() {
        Feeling feelingA = new Feeling("FeelingA", "CommentA");
        Feeling feelingB = new Feeling("FeelingB", "CommentB");

        FeelingList feelingList = new FeelingList();
        feelingList.addFeeling(feelingA);
        feelingList.addFeeling(feelingB);

        feelingList.removeFeeling(feelingA);
        assertTrue("AssertionError: feelingList.removeFeeling, size()", feelingList.size() == 1);
        assertTrue("AssertionError: feelingList.removeFeeling, getFeeling()", feelingList.getFeeling(0) == feelingB);
    }

    /**
     * Tests the retrieval of the feelingList
     * Assertion fails if the returned value isn't equal to the expected ArrayList of type Feeling
     */
    @Test
    public void testGetFeelingList() {
        Feeling feelingA = new Feeling("FeelingA", "CommentA");
        Feeling feelingB = new Feeling("FeelingB", "CommentB");

        ArrayList<Feeling> expected = new ArrayList<>();
        expected.add(feelingA);
        expected.add(feelingB);

        FeelingList feelingList = new FeelingList();
        feelingList.addFeeling(feelingA);
        feelingList.addFeeling(feelingB);

        assertEquals("AssertionError: feelingList.getFeelingList()", feelingList.getFeelingList(), expected);
    }


    /**
     * Tests the retrieval of the count of occurrences of each feeling in feelingList
     * Assertion fails if the count isn't equal to the defined expected HashMap
     */
    @Test
    public void testGetFeelingCount() {
        Feeling feelingA = new Feeling("Joy", "CommentA");
        Feeling feelingB = new Feeling("Anger", "CommentB");
        Feeling feelingC = new Feeling("Anger", "CommentC");
        Feeling feelingD = new Feeling("Sadness", "CommentD");
        Feeling feelingE = new Feeling("Sadness", "CommentE");
        Feeling feelingF = new Feeling("Sadness", "CommentF");

        FeelingList feelingList = new FeelingList();
        feelingList.addFeeling(feelingA);
        feelingList.addFeeling(feelingB);
        feelingList.addFeeling(feelingC);
        feelingList.addFeeling(feelingD);
        feelingList.addFeeling(feelingE);
        feelingList.addFeeling(feelingF);

        Map<String, Integer> counts = feelingList.getFeelingCount();

        System.out.println(counts);

        assertTrue("AssertionError: feelingList.getFeelingCount()", counts.get("Joy") == 1);
        assertTrue("AssertionError: feelingList.getFeelingCount()", counts.get("Anger") == 2);
        assertTrue("AssertionError: feelingList.getFeelingCount()", counts.get("Sadness") == 3);
    }

    /**
     * Tests the retrieval of the size of the feelingList
     * Assertion fails if the size isn't the expected value
     */
    @Test
    public void testSize() {
        Feeling feelingA = new Feeling("FeelingA", "CommentA");
        Feeling feelingB = new Feeling("FeelingB", "CommentB");

        FeelingList feelingList = new FeelingList();
        feelingList.addFeeling(feelingA);
        feelingList.addFeeling(feelingB);

        assertTrue("AssertionError: feelingList.size()", feelingList.size() == 2);
    }

    /**
     * Tests the contains() method that checks if an item is in the feelingList
     * Assertions fail if
     *      a) A feeling that is in the feelingList returns false
     *      b) A feeling that is not in the feelingList returns true
     */
    @Test
    public void testContains() {
        Feeling feelingA = new Feeling("FeelingA", "CommentA");
        Feeling feelingB = new Feeling("FeelingB", "CommentB");
        Feeling feelingC = new Feeling("FeelingC", "CommentC");

        FeelingList feelingList = new FeelingList();
        feelingList.addFeeling(feelingA);
        feelingList.addFeeling(feelingB);

        assertTrue("AssertionError: feelingList.contains(), A", feelingList.contains(feelingA));
        assertTrue("AssertionError: feelingList.contains(), B", feelingList.contains(feelingB));
        assertFalse("AssertionError: feelingList.contains(), A", feelingList.contains(feelingC));
    }
}