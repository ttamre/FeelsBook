package ttamre.ca.ttamre_feelsbook;

import java.util.Calendar;
import java.util.Date;

public class Feeling {
    protected String name;
    protected Date date;
    protected String comment;

    /**
     * Constructor for the Feeling class
     *
     * the code for setting the date was taken from StackOverflow, from user JeffJack
     *      https://stackoverflow.com/users/149923/jeffjak
     *      https://stackoverflow.com/a/20333576
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
        comment = newComment;
        date = Calendar.getInstance().getTime();
    }

    /**
     * Getter method to return the name or classification of the feeling
     * @return name: String
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method to return the date/date that the class was instantiated on
     * @return date: Date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Getter method to return the comment for the feeling
     * Since comments are optional, feelings with no comment will have a comment value of
     *      <String> "" </String>
     *
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
        comment = newComment;
    }

    /**
     * Setter method to edit the date of an existing date
     * @param newDate the new date that will replace the existing one
     */
    public void setDate(Date newDate) {
        date = newDate;
    }
}
