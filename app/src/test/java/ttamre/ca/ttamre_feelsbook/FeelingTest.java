package ttamre.ca.ttamre_feelsbook;

import junit.framework.TestCase;

import org.junit.Test;

public class FeelingTest extends TestCase {
    @Test
    public void testCreate() {
        String feelingName = "Joy";
        String feelingComment = "I finished some unit tests today!";

        Feeling feeling = new Feeling(feelingName, feelingComment);

        assertTrue("AssertionError: feeling.getName()", feeling.getName().equals(feelingName));
        assertTrue("AssertionError: feeling.getComment()", feeling.getComment().equals(feelingComment));
        System.out.println(feeling.getTimestamp());
    }

    @Test
    public void testEdit() {
        String feelingName = "Joy";
        String feelingComment = "I finished some unit tests today!";

        Feeling feeling = new Feeling(feelingName, feelingComment);

        assertTrue("AssertionError: feeling.getName()", feeling.getName().equals(feelingName));
        assertTrue("AssertionError: feeling.getComment()", feeling.getComment().equals(feelingComment));

        String newComment = "Edit: I remembered something that I need to add to my unit test";
        feeling.setComment(newComment);

        assertTrue("AssertionError: feeling.getComment()", feeling.getComment().equals(newComment));
    }

}
