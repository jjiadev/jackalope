package com.parsing;

import java.text.ParseException;
import java.util.GregorianCalendar;

import com.people.Gender;
import com.utilities.TestHelper;
import org.junit.Test;
import static junit.framework.TestCase.*;

public class ParseHelperTest {
    @Test
    public void testParseSingleLetterGender() throws Exception {
        assertEquals(Gender.Male, ParseHelper.parseSingleLetterGender("m"));
        assertEquals(Gender.Male, ParseHelper.parseSingleLetterGender("M"));
        assertEquals(Gender.Female, ParseHelper.parseSingleLetterGender("F"));
        assertEquals(Gender.Female, ParseHelper.parseSingleLetterGender("f"));
        assertEquals(Gender.NonBinary,
                ParseHelper.parseSingleLetterGender("x"));
        assertEquals(Gender.NonBinary,
                ParseHelper.parseSingleLetterGender("t"));
        assertEquals(Gender.NonBinary,
                ParseHelper.parseSingleLetterGender("56t"));

    }

    @Test
    public void testParseDate() throws Exception {
        GregorianCalendar actualBirthDate = ParseHelper.parseDate(
                "11/23/2033", "MM/dd/yyyy");
        TestHelper.checkDateDownToTheDay(new GregorianCalendar(2033, 10, 23),
                actualBirthDate);
        GregorianCalendar actualBirthDate2 = ParseHelper.parseDate(
                "2255-01-14", "yyyy-MM-dd");
        TestHelper.checkDateDownToTheDay(new GregorianCalendar(2255, 0, 14),
                actualBirthDate2);
    }

    @Test
    public void testParseDateThrowsParseExceptionWithImproperFormat()
            throws Exception {
        try {
            ParseHelper.parseDate("11/23/2033", "yyyy-mm-dd");
            fail("should have thrown the exception instead of swallowing it");

        } catch (ParseException e) {

        }
    }
}
