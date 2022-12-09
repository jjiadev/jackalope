package com.parsing;

import java.util.GregorianCalendar;

import com.people.Gender;
import com.people.NullPerson;
import com.people.Person;
import com.people.PersonInterface;
import com.utilities.TestHelper;
import org.junit.Test;

import static junit.framework.TestCase.*;

public class CommaParserTest {

	@Test
	public void testParseCommaRow_Male() throws Exception {
		String input = "Shabadoo , Joeyjojo , Male , Yellow, 5/15/1994";
		PersonParser commaParser = new CommaParser();
		PersonInterface dude = commaParser.parsePerson(input);
		assertEquals(Person.class, dude.getClass());
		assertEquals("Shabadoo", dude.getLastName());
		assertEquals("Joeyjojo", dude.getFirstName());
		assertEquals("", dude.getMiddleInitial());
		assertEquals(Gender.Male, dude.getGender());
		assertEquals("Yellow", dude.getFavoriteColor());
		int mayInJava = 4;
		GregorianCalendar expectedDateOfBirth = new GregorianCalendar(1994,
				mayInJava, 15);
		TestHelper.checkDateDownToTheDay(expectedDateOfBirth,
				dude.getDateOfBirth());
	}
	@Test
	public void testParseCommaRow_Male_DifferentCapitalization()
			throws Exception {
		String input = "Shabadoo , Joeyjojo , male , Yellow, 5/15/1994";
		String input2 = "Shabadoo , Joeyjojo , mAle , Yellow, 5/15/1994";
		String input3 = "Shabadoo , Joeyjojo , MALE , Yellow, 5/15/1994";
		PersonParser commaParser = new CommaParser();
		PersonInterface dude = commaParser.parsePerson(input);
		PersonInterface dude2 = commaParser.parsePerson(input2);
		PersonInterface dude3 = commaParser.parsePerson(input3);
		assertEquals(Gender.Male, dude.getGender());
		assertEquals(Gender.Male, dude2.getGender());
		assertEquals(Gender.Male, dude3.getGender());

	}
	@Test
	public void testParseCommaRow_Female() throws Exception {
		String input = "McLadyson , Girly, Female , Mauve, 7/22/1983";
		PersonParser commaParser = new CommaParser();
		PersonInterface person = commaParser.parsePerson(input);
		assertEquals(Person.class, person.getClass());
		assertEquals("McLadyson", person.getLastName());
		assertEquals("Girly", person.getFirstName());
		assertEquals("", person.getMiddleInitial());
		assertEquals(Gender.Female, person.getGender());
		assertEquals("Mauve", person.getFavoriteColor());
		int julyInJava = 6;
		GregorianCalendar expectedDateOfBirth = new GregorianCalendar(1983,
				julyInJava, 22);
		TestHelper.checkDateDownToTheDay(expectedDateOfBirth,
				person.getDateOfBirth());

	}
	@Test
	public void testParseCommaRow_Female_DifferentCapitalization()
			throws Exception {
		String input = "Shabadoo , Joeyjojo , female , Yellow, 5/15/1994";
		String input2 = "Shabadoo , Joeyjojo , fEmAle , Yellow, 5/15/1994";
		String input3 = "Shabadoo , Joeyjojo , FEMALE , Yellow, 5/15/1994";
		PersonParser commaParser = new CommaParser();
		PersonInterface lady = commaParser.parsePerson(input);
		PersonInterface lady2 = commaParser.parsePerson(input2);
		PersonInterface lady3 = commaParser.parsePerson(input3);
		assertEquals(Gender.Female, lady.getGender());
		assertEquals(Gender.Female, lady2.getGender());
		assertEquals(Gender.Female, lady3.getGender());

	}
	@Test
	public void testParseCommaRow_IndeterminateGender() throws Exception {
		String input = "Hardcheese, Blast ,  Nope , Red , 11/23/2012";
		PersonParser commaParser = new CommaParser();
		PersonInterface person = commaParser.parsePerson(input);
		assertEquals(Person.class, person.getClass());
		assertEquals("Hardcheese", person.getLastName());
		assertEquals("Blast", person.getFirstName());
		assertEquals("", person.getMiddleInitial());
		assertEquals(Gender.NonBinary, person.getGender());
		assertEquals("Red", person.getFavoriteColor());
		int novemberInJava = 10;
		GregorianCalendar expectedDateOfBirth = new GregorianCalendar(2012,
				novemberInJava, 23);
		TestHelper.checkDateDownToTheDay(expectedDateOfBirth,
				person.getDateOfBirth());
	}
	@Test
	public void testWrongNumberOfCommas() throws Exception {
		String inputNotEnoughCommas = "Bibity , Blabity , X  Red";
		String inputTooManyCommas = "Bibity , Blabity , Male,  Red, 2/12/1235, 412541,12412,gvsd, more stuff";
		PersonParser commaParser = new CommaParser();
		assertEquals(NullPerson.NULL,
				commaParser.parsePerson(inputNotEnoughCommas));
		assertEquals(NullPerson.NULL,
				commaParser.parsePerson(inputTooManyCommas));
	}
	@Test
	public void testBadDates() throws Exception {
		String inputNotADate = "Bibity , Blabity , Male,  Red, notadate";
		String inputBlankDate = "Bibity , Blabity , Male,  Red, ";
		String inputDifferentFormatDate = "Bibity , Blabity , Male,  Red, 11.22.2231";
		;
		PersonParser commaParser = new CommaParser();

		assertEquals(NullPerson.NULL, commaParser.parsePerson(inputNotADate));
		assertEquals(NullPerson.NULL, commaParser.parsePerson(inputBlankDate));
		assertEquals(NullPerson.NULL,
				commaParser.parsePerson(inputDifferentFormatDate));
	}
}
