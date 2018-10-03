/**
 *   The Feeling class, representative of the feelings that the application allows users to record
 *
 *     Copyright (C) 2018 Tem Tamre
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU General Public License for more details.
 *
 *     You should have received a copy of the GNU General Public License
 *     along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

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

        /* Trim comments to the allowed size if they are longer than MAX_LENGTH */
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
        /* Trim comments to the allowed size if they are longer than MAX_LENGTH */
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
        /* Convert Date objects to iso8601 formatted SimpleDateFormat objects */
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.CANADA);

        /* Ignore printing the comment if comment is null */
        if (comment != null) {
            return String.format("%s: %s (%s)", sdf.format(date), name, comment);
        } else {
            return String.format("%s: %s", sdf.format(date), name);
        }
    }
}
