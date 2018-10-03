package ttamre.ca.ttamre_feelsbook;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Feeling {
    protected String name;
    protected Date date;
    protected String comment;
    protected final int MAX_LENGTH = 100;  // maximum length for a comment

    /**
     * Constructor for the Feeling class
     *
     * The code for setting the date in iso8601 was taken from Mincong Huang's blog
     *      https://mincong-h.github.io/2017/02/16/convert-date-to-string-in-java/
     *
     * @param feelingName name or category of the feeling
     */
    public Feeling(String feelingName) {
        name = feelingName;
        date = Calendar.getInstance().getTime();
    }

    /**
     * Constructor for the Feeling class
     *
     * the code for setting the date was taken from StackOverflow, from user JeffJack
     *      https://stackoverflow.com/users/149923/jeffjak
     *      https://stackoverflow.com/a/20333576
     *
     * @param feelingName name or category of the feeling
     * @param newComment the comment to be added to the feeling
     */
    public Feeling(String feelingName, String newComment) {
        name = feelingName;
        date = Calendar.getInstance().getTime();

        if (newComment.length() > 100) {
            newComment = newComment.substring(0, MAX_LENGTH);
        }
        comment = newComment;
    }

    /**
     * Getter method to return the name or classification of the feeling
     * @return name: String
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method to return the date (in iso8601) that the class was instantiated on
     * @return date: String
     */
    public Date getDate() {
        return date;
    }

    /**
     * Getter method to return the comment for the feelings
     * @return comment: String
     */
    public String getComment() {
        return comment;
    }

    /**
     * Setter method to edit the comment of an existing feeling
     * @param newComment the new comment that will replace the existing one
     */
    public void setComment(String newComment) {
        if (newComment.length() > 100) {
            newComment = newComment.substring(0, MAX_LENGTH);
        }
        comment = newComment;
    }


    /**
     * Setter method to edit the date of an existing date
     * @param newDate the new date that will replace the existing one
     */
    public void setDate(Date newDate) {
        date = newDate;
    }

    public String toString() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.CANADA);
        if (comment != null) {
            return String.format("%s: %s (%s)", sdf.format(date), name, comment);
        } else {
            return String.format("%s: %s", sdf.format(date), name);
        }
    }
}
