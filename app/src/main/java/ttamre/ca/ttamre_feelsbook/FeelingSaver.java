/*
 * Copyright (C) 2018 Tem Tamre
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

import android.content.Context;
import android.util.Log;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FeelingSaver {
    private String filename;
    private Context context;

    public FeelingSaver(Context c) {
        this.context = c;
        this.filename = "data.ser";
    }

    public FeelingSaver(Context c, String fn) {
        this.context = c;
        this.filename = fn;
    }

    public void save(FeelingList feelingList) {
        try {
            File file = new File(context.getFilesDir(), filename);
            FileOutputStream fos = new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(feelingList);
            oos.close();
            Log.d("tagged-ttamre", "FeelingSaver.java -> save(): SUCCESS - Saved to " + file.getAbsolutePath());
        } catch (Exception e) {
            Log.d("tagged-ttamre", "FeelingSaver.java -> save(): ERROR - " + e.toString());
        }
    }

    public FeelingList load() {
        FeelingList object = new FeelingList();
        try {
            File file = new File(context.getFilesDir(), filename);
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            object = (FeelingList) ois.readObject();
            ois.close();
            Log.d("tagged-ttamre", "FeelingSaver.java -> load(): SUCCESS - Load from " + file.getAbsolutePath());

        } catch (Exception e) {
            Log.d("tagged-ttamre", "FeelingSaver.java -> load(): ERROR - " + e.toString());
        }

        return object;
    }

}
