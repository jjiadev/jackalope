package com.parsing;

import java.util.GregorianCalendar;

import junit.framework.TestCase;

import com.people.Gender;
import com.people.NullPerson;
import com.people.Person;
import com.people.PersonInterface;
import com.utilities.TestHelper;

public class PipeParserTest extends TestCase {

	public void testImplementsParserInterface() throws Exception {
		assertEquals(PersonParser.class, PipeParser.class.getInterfaces()[0]);
	}

	public void testParsePipeRow_Male() throws Exception {
		String input = "Baker | Tom | S | M | Green | 1-20-1934";
		PersonParser pipeParser = new PipeParser();
		PersonInterface timeLord = pipeParser.parsePerson(input);
		assertEquals(Person.class, timeLord.getClass());
		assertEquals("Baker", timeLord.getLastName());
		assertEquals("Tom", timeLord.getFirstName());
		assertEquals("S", timeLord.getMiddleInitial());
		assertEquals(Gender.Male, timeLord.getGender());
		assertEquals("Green", timeLord.getFavoriteColor());
		int januaryInJava = 0;
		GregorianCalendar expectedDateOfBirth = new GregorianCalendar(1934,
				januaryInJava, 20);
		TestHelper.checkDateDownToTheDay(expectedDateOfBirth,
				timeLord.getDateOfBirth());

	}

	public void testParsePipeRow_Male_DifferentGenderCasing() throws Exception {
		String input = "Baker | Tom | S | m | Green | 1-20-1934";
		PersonParser pipeParser = new PipeParser();
		PersonInterface timeLord = pipeParser.parsePerson(input);
		assertEquals(Person.class, timeLord.getClass());
		assertEquals(Gender.Male, timeLord.getGender());

	}

	public void testParsePipeRow_Female() throws Exception {
		String input = "Sladen | Elisabeth | C | F | Blue | 2-1-1946";
		PersonParser pipeParser = new PipeParser();
		PersonInterface companion = pipeParser.parsePerson(input);
		assertEquals(Person.class, companion.getClass());
		assertEquals("Sladen", companion.getLastName());
		assertEquals("Elisabeth", companion.getFirstName());
		assertEquals("C", companion.getMiddleInitial());
		assertEquals(Gender.Female, companion.getGender());
		assertEquals("Blue", companion.getFavoriteColor());
		int februaryInJava = 1;
		GregorianCalendar expectedDateOfBirth = new GregorianCalendar(1946,
				februaryInJava, 1);
		TestHelper.checkDateDownToTheDay(expectedDateOfBirth,
				companion.getDateOfBirth());

	}

	public void testParsePipeRow_Female_DifferentGenderCasing()
			throws Exception {
		String input = "Sladen | Elisabeth | C | f | Blue | 2-1-1946";
		PersonParser pipeParser = new PipeParser();
		PersonInterface companion = pipeParser.parsePerson(input);
		assertEquals(Person.class, companion.getClass());
		assertEquals(Gender.Female, companion.getGender());

	}

	public void testParsePipeRow_IndeterminateGender() throws Exception {
		String input = "Zorakerson | Zorak | D | X | Red | 3-24-4512";
		PersonParser pipeParser = new PipeParser();
		PersonInterface person = pipeParser.parsePerson(input);
		assertEquals(Person.class, person.getClass());
		assertEquals("Zorakerson", person.getLastName());
		assertEquals("Zorak", person.getFirstName());
		assertEquals("D", person.getMiddleInitial());
		assertEquals(Gender.Undetermined, person.getGender());
		assertEquals("Red", person.getFavoriteColor());
		int marchInJava = 2;
		GregorianCalendar expectedDateOfBirth = new GregorianCalendar(4512,
				marchInJava, 24);
		TestHelper.checkDateDownToTheDay(expectedDateOfBirth,
				person.getDateOfBirth());
	}

	public void testWrongNumberOfPipes() throws Exception {
		String inputNotEnoughPipes = "Zorakerson | Zorak | D | X | Red";
		String inputNotTooManyPipes = "Zorakerson | Zorak | D | X | Red|3-24-4512|3-24-4512|23423|";
		PersonParser pipeParser = new PipeParser();
		assertEquals(NullPerson.NULL,
				pipeParser.parsePerson(inputNotEnoughPipes));
		assertEquals(NullPerson.NULL,
				pipeParser.parsePerson(inputNotTooManyPipes));
	}

	public void testBadDates() throws Exception {
		String inputNotADate = "Zorakerson | Zorak | D | X | Red | imaword";
		String inputBlankDate = "Zorakerson | Zorak | D | X | Red | ";
		String inputDifferentFormatDate = "Zorakerson | Zorak | D | X | Red | 2314/25/1";
		PersonParser pipeParser = new PipeParser();

		assertEquals(NullPerson.NULL, pipeParser.parsePerson(inputNotADate));
		assertEquals(NullPerson.NULL, pipeParser.parsePerson(inputBlankDate));
		assertEquals(NullPerson.NULL,
				pipeParser.parsePerson(inputDifferentFormatDate));
	}
}
