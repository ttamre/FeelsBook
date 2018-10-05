/*
 * Test class for the Feeling class
 *
 *  Copyright (C) 2018 Tem Tamre
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 3 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package ttamre.ca.ttamre_feelsbook;

import junit.framework.TestCase;

import org.junit.Test;

import java.util.Date;

public class FeelingTest extends TestCase {
    @Test
    public void testCreate() {
        String nameA = "Joy";
        String nameB = "Sadness";
        String commentA = "I finished some unit tests today!";

        Feeling feelingA = new Feeling(nameA, commentA);
        Feeling feelingB = new Feeling(nameB);

        assertTrue("AssertionError: feeling.getName()", feelingA.getName().equals(nameA));
        assertTrue("AssertionError: feeling.getName()", feelingB.getName().equals(nameB));
        assertTrue("AssertionError: feeling.getComment()", feelingA.getComment().equals(commentA));
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
        String comment = "testEditDate() A";
        Feeling feeling = new Feeling(feelingName, comment);
        assertTrue("AssertionError: feeling.getName()", feeling.getName().equals(feelingName));

        Date newDate = new Date(118, 8, 1, 18, 30, 0);
        feeling.setDate(newDate);
        assertTrue("AssertionError: feeling.getDate(), Date", feeling.getDate().equals(newDate));
    }

}
