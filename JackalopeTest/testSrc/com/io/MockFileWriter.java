package com.io;

public class MockFileWriter implements FileWriterInterface {

	private String fileContentsWritten;
	private String pathWrittenTo;

	@Override
	public void write(String path, String contents) {
		this.pathWrittenTo = path;
		this.fileContentsWritten = contents;

	}

	public String getFileContentsWritten() {
		return fileContentsWritten;
	}

	public String getPathWrittenTo() {
		return pathWrittenTo;
	}

}
