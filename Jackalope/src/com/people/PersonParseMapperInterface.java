package com.people;

import com.parsing.PersonParser;

public interface PersonParseMapperInterface {
    public PersonParser getParser(String filePath);
}
