package com.io;

import java.io.File;
import java.io.FileInputStream;

import junit.framework.TestCase;

public class FileWriterTest extends TestCase {

	public void testWrite() throws Exception {
		FileWriter fileWriter = new FileWriter();
		String path = "thisisthepath";
		String contents = "thisisthecontents";
		File file = new File(path);
		try {
			assertFalse(file.exists());
			fileWriter.write(path, contents);
			assertTrue(file.exists());
			FileInputStream fileInputStream = new FileInputStream(file);
			byte[] fileBytes = new byte[fileInputStream.available()];
			fileInputStream.read(fileBytes);
			fileInputStream.close();
			assertEquals(contents, new String(fileBytes));
		} finally {
			file.delete();
			assertFalse(file.exists());
		}
	}

	public void testImplementsInterface() throws Exception {
		assertEquals(FileWriterInterface.class,
				FileWriter.class.getInterfaces()[0]);
	}
}
