package com.io;

import java.io.FileInputStream;
import java.io.IOException;

public class FileReader implements FileReaderInterface {

	@Override
	public String readFileContents(String absolutePath) {
		FileInputStream fileInputStream;
		try {
			fileInputStream = new FileInputStream(absolutePath);
			byte[] fileContents = new byte[fileInputStream.available()];
			fileInputStream.read(fileContents);
			fileInputStream.close();
			return new String(fileContents);
		} catch (IOException e) {
			return "";
		}

	}
}
