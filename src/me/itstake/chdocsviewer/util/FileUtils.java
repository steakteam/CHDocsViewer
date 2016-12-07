package me.itstake.chdocsviewer.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;

/**
 * Created by deide on 2016-10-27.
 */
public class FileUtils {
    public static String readText(File file) {
        String contents = "";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String temp;

            while ((temp = reader.readLine()) != null) {
                contents += temp;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return contents;
    }
}
