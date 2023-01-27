package com.parsing;

import com.people.NullPerson;
import com.people.PersonInterface;

public class NullParser implements PersonParser {
    public static final NullParser NULL = new NullParser();

    private NullParser() {

    }

    @Override
    public PersonInterface parsePerson(String input) {
        return NullPerson.NULL;
    }
}
