package com.io;

public class MockFileReader implements FileReaderInterface {

	private String lastFileRead;
	private String fileContents;

	@Override
	public String readFileContents(String absolutePath) {
		this.lastFileRead = absolutePath;
		return fileContents;
	}

	public String getLastFileRead() {
		return lastFileRead;
	}

	public void setFileContentsToReturn(String fileContents) {
		this.fileContents = fileContents;

	}

}
