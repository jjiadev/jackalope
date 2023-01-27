package com.io;

import java.util.List;

public class MockDirectoryHelper implements DirectoryHelperInterface {
    private String directoryToGetFilesFrom;
    private List<String> filesToReturn;

    @Override
    public List<String> getFilesInDirectory(String directory) {
        this.directoryToGetFilesFrom = directory;
        return this.filesToReturn;
    }

    public void setFilesToReturn(List<String> filesToReturn) {
        this.filesToReturn = filesToReturn;
    }

    public String getDirectoryToGetFilesFrom() {
        return directoryToGetFilesFrom;
    }
}
