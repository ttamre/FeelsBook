package ttamre.ca.ttamre_feelsbook;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.Date;

public class FeelingTest extends TestCase {
    @Test
    public void testCreate() {
        String feelingName = "Joy";
        String feelingComment = "I finished some unit tests today!";

        Feeling feeling = new Feeling(feelingName, feelingComment);

        assertTrue("AssertionError: feeling.getName()", feeling.getName().equals(feelingName));
        assertTrue("AssertionError: feeling.getComment()", feeling.getComment().equals(feelingComment));
        System.out.println(feeling.getDate());
    }

    @Test
    public void testEditComment() {
        String feelingName = "Joy";
        String feelingComment = "I finished some unit tests today!";
        Feeling feeling = new Feeling(feelingName, feelingComment);
        assertTrue("AssertionError: feeling.getName()", feeling.getName().equals(feelingName));
        assertTrue("AssertionError: feeling.getComment()", feeling.getComment().equals(feelingComment));

        String newComment = "Edit: I remembered something that I need to add to my unit test";
        feeling.setComment(newComment);
        assertTrue("AssertionError: feeling.getComment()", feeling.getComment().equals(newComment));
    }

    @Test
    public void testEditDate() {
        String feelingName = "Joy";
        Feeling feeling = new Feeling(feelingName);
        assertTrue("AssertionError: feeling.getName()", feeling.getName().equals(feelingName));

        Date newDate = new Date();
        feeling.setDate(newDate);
        assertTrue("AssertionError: feeling.getDate()", feeling.getDate().equals(newDate));
    }

}
