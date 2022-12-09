package com.parsing;

import com.people.Gender;
import com.people.NullPerson;
import com.people.Person;
import com.people.PersonInterface;
import com.utilities.TestHelper;
import org.junit.Test;

import java.util.Date;
import java.util.GregorianCalendar;

import static junit.framework.TestCase.assertEquals;
import static org.junit.Assert.*;

public class TrickyPipeParserTest {

    @Test
    public void parseTrickyPipeRow() {
        String input =  "Bouillon, Francis | G | M | Blue | 6-3-1975";
        TrickyPipeParser parser = new TrickyPipeParser();
        PersonInterface dude = parser.parsePerson(input);
        assertEquals(Person.class, dude.getClass());
        assertEquals("Bouillon", dude.getLastName());
        assertEquals("Francis", dude.getFirstName());
        assertEquals("G", dude.getMiddleInitial());
        assertEquals(Gender.Male, dude.getGender());
        assertEquals("Blue", dude.getFavoriteColor());
        int juneInJava = 5;
        GregorianCalendar expectedDateOfBirth = new GregorianCalendar(1975,
                juneInJava, 3);
        TestHelper.checkDateDownToTheDay(expectedDateOfBirth,
                dude.getDateOfBirth());
    }

    @Test
    public void wrongNumberOfFields(){
        String input =  "Bouillon, Francis | G | M | Blue";
        TrickyPipeParser parser = new TrickyPipeParser();
        PersonInterface dude = parser.parsePerson(input);
        assertEquals(NullPerson.NULL, dude);
    }

    @Test
    public void wrongNumberOfFieldsForName(){
        String input =  "Bouillon | G | M | Blue | 6-3-1975";
        TrickyPipeParser parser = new TrickyPipeParser();
        PersonInterface dude = parser.parsePerson(input);
        assertEquals(NullPerson.NULL, dude);
    }

    @Test
    public void badDates(){
        String input =  "Monkey, Dead | G | M | Blue | 6/3/1975";
        TrickyPipeParser parser = new TrickyPipeParser();
        PersonInterface dude = parser.parsePerson(input);
        assertEquals(NullPerson.NULL, dude);
    }
}