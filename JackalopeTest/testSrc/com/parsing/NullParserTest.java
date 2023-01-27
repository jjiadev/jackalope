package com.parsing;

import com.people.NullPerson;
import org.junit.Test;

import static org.junit.Assert.*;

public class NullParserTest {

    @Test
    public void providesNullPerson() {
        assertEquals(NullPerson.NULL, NullParser.NULL.parsePerson(""));
    }
}