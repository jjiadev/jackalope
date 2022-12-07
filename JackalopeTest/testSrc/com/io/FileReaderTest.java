package com.io;

import java.io.File;
import java.io.FileOutputStream;

import junit.framework.TestCase;

import org.junit.Test;

import com.io.FileReader;
import com.io.FileReaderInterface;

public class FileReaderTest extends TestCase {

	public void testImplementsInterface() throws Exception {
		assertEquals(FileReaderInterface.class,
				FileReader.class.getInterfaces()[0]);
	}

	@Test
	public void testReadsFileContents() throws Exception {
		FileReaderInterface fileReader = new FileReader();
		File file = new File("stuff.stuff");
		FileOutputStream fileOutputStream = new FileOutputStream(file);
		try {
			String fileContents = "this is going to be the content of the file";
			fileOutputStream.write(fileContents.getBytes());
			fileOutputStream.close();
			assertEquals(fileContents,
					fileReader.readFileContents(file.getAbsolutePath()));
		} finally {
			file.delete();
			assertFalse(file.exists());
		}
	}

	@Test
	public void testIOException() throws Exception {
		FileReaderInterface fileReader = new FileReader();
		File file = new File("stuff.stuff");
		try {
			assertEquals("",
					fileReader.readFileContents(file.getAbsolutePath()));
		} finally {
			assertFalse(file.exists());
		}
	}
}
