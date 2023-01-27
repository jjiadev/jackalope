package com.people;

import com.io.MockFileReader;
import com.parsing.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class PersonParseMapperTest {

    @Test
    public void providesPipeParserWhenFileContainsPipe() {
        MockFileReader mockReader = new MockFileReader();
        mockReader.setFileContentsToReturn("this|has|pipes");

        PersonParseMapper mapper = new PersonParseMapper(mockReader);
        String fileToRead = "this/is/theFile";
        PersonParser parser = mapper.getParser(fileToRead);
        assertEquals(fileToRead, mockReader.getLastFileRead());
        assertEquals(PipeParser.class, parser.getClass());
    }

    @Test
    public void providesCommaParserWhenFileContainsComma() {
        MockFileReader mockReader = new MockFileReader();
        mockReader.setFileContentsToReturn("this,has,commas");

        PersonParseMapper mapper = new PersonParseMapper(mockReader);
        String fileToRead = "this/is/theFile";
        PersonParser parser = mapper.getParser(fileToRead);
        assertEquals(fileToRead, mockReader.getLastFileRead());
        assertEquals(CommaParser.class, parser.getClass());
    }

    @Test
    public void providesSpaceParserWhenFileContainsSpace() {
        MockFileReader mockReader = new MockFileReader();
        mockReader.setFileContentsToReturn("this has a space");

        PersonParseMapper mapper = new PersonParseMapper(mockReader);
        String fileToRead = "this/is/theFile";
        PersonParser parser = mapper.getParser(fileToRead);
        assertEquals(fileToRead, mockReader.getLastFileRead());
        assertEquals(SpaceParser.class, parser.getClass());
    }

    @Test
    public void providesNullParserWhenNoSpecialCharacters() {
        MockFileReader mockReader = new MockFileReader();
        mockReader.setFileContentsToReturn("runonsentence");

        PersonParseMapper mapper = new PersonParseMapper(mockReader);
        String fileToRead = "this/is/theFile";
        PersonParser parser = mapper.getParser(fileToRead);
        assertEquals(fileToRead, mockReader.getLastFileRead());
        assertEquals(NullParser.NULL, parser);

    }
}