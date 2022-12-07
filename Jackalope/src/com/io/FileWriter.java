package com.io;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileWriter implements FileWriterInterface {

	public void write(String path, String contents) {
		try {
			FileOutputStream outputStream = new FileOutputStream(new File(path));
			outputStream.write(contents.getBytes());
			outputStream.close();
		} catch (IOException e) {
		}
	}

}
