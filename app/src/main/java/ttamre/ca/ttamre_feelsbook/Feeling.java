package ttamre.ca.ttamre_feelsbook;

import java.util.Calendar;
import java.util.Date;

public class Feeling {
    protected String name;
    protected final Date timestamp;
    protected String comment;

    /**
     * Constructor for the Feeling class
     *
     * the code for setting the timestamp was taken from StackOverflow, from user JeffJack
     *      https://stackoverflow.com/users/149923/jeffjak
     *      https://stackoverflow.com/a/20333576
     *
     * @param feelingName name or category of the feeling
     */
    public Feeling(String feelingName) {
        name = feelingName;
        timestamp = Calendar.getInstance().getTime();
    }

    /**
     * Constructor for the Feeling class
     *
     * the code for setting the timestamp was taken from StackOverflow, from user JeffJack
     *      https://stackoverflow.com/users/149923/jeffjak
     *      https://stackoverflow.com/a/20333576
     *
     * @param feelingName name or category of the feeling
     * @param newComment the comment to be added to the feeling
     */
    public Feeling(String feelingName, String newComment) {
        name = feelingName;
        comment = newComment;
        timestamp = Calendar.getInstance().getTime();
    }

    /**
     * Getter method to return the name or classification of the feeling
     * @return name: String
     */
    public String getName() {
        return this.name;
    }

    /**
     * Getter method to return the date/timestamp that the class was instantiated on
     * @return timestamp: Date
     */
    public Date getTimestamp() {
        return this.timestamp;
    }

    /**
     * Getter method to return the comment for the feeling
     * Since comments are optional, feelings with no comment will have a comment value of
     *      <String> "" </String>
     *
     * @return comment: String
     */
    public String getComment() {
        return this.comment;
    }

    /**
     * Setter method to edit the comment of an existing feeling
     * @param newComment the new comment that will replace the existing one
     */
    public void setComment(String newComment) {
        comment = newComment;
    }
}
