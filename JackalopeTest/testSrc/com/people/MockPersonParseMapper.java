package com.people;

import com.parsing.PersonParser;

public class MockPersonParseMapper implements PersonParseMapperInterface {
    @Override
    public PersonParser getParser(String filePath) {
        return null;
    }
}
