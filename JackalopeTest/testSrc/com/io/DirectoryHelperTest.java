package com.io;

import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Arrays;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.*;

public class DirectoryHelperTest {


    @Test
    public void getsListOfFileNamesInDirectory() throws Exception {
        DirectoryHelper directoryHelper = new DirectoryHelper();
        File directory = new File("./testStuff/");
        directory.mkdir();
        File file = new File("./testStuff/stuff.stuff");
        File file2 = new File("./testStuff/stuff2.stuff2");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        FileOutputStream fileOutputStream2 = new FileOutputStream(file2);
        try {
            String fileContents = "this is going to be the content of the file";
            fileOutputStream.write(fileContents.getBytes());
            fileOutputStream2.write(fileContents.getBytes());

            fileOutputStream.close();
            fileOutputStream2.close();
            assertEquals(Arrays.asList("stuff.stuff", "stuff2.stuff2"),
                    directoryHelper.getFilesInDirectory("./testStuff/"));
        } finally {
            file.delete();
            file2.delete();
            directory.delete();
            assertFalse(file.exists());
            assertFalse(file2.exists());
            assertFalse(directory.exists());
        }
    }
}