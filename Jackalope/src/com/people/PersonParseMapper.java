package com.people;

import com.io.FileReaderInterface;
import com.parsing.*;

public class PersonParseMapper implements PersonParseMapperInterface {
    private FileReaderInterface fileReader;

    public PersonParseMapper(FileReaderInterface fileReader) {

        this.fileReader = fileReader;
    }


    @Override
    public PersonParser getParser(String filePath) {
        String fileContents = this.fileReader.readFileContents(filePath);
        if (fileContents.contains("|")) {
            return new PipeParser();
        } else if (fileContents.contains(",")) {
            return new CommaParser();
        } else if (fileContents.contains(" ")) {
            return new SpaceParser();
        }
        return NullParser.NULL;
    }
}
