package com.io;

import java.io.File;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DirectoryHelper implements DirectoryHelperInterface {
    @Override
    public List<String> getFilesInDirectory(String directory) {
        return Stream.of(new File(directory).listFiles())
//                .filter(file -> !file.isDirectory())
                .map(File::getName)
                .collect(Collectors.toList());
    }
}
