package com.parsing;

import java.util.GregorianCalendar;

import com.people.Gender;
import com.people.NullPerson;
import com.people.Person;
import com.people.PersonInterface;
import com.utilities.TestHelper;

import org.junit.Test;
import static junit.framework.TestCase.*;

public class SpaceParserTest {
@Test
	public void testParsePipeRow_Male() throws Exception {
		String input = "Bulkhead Slab T M 1-12-5123 Green";
		PersonParser parser = new SpaceParser();
		PersonInterface timeLord = parser.parsePerson(input);
		assertEquals(Person.class, timeLord.getClass());
		assertEquals("Bulkhead", timeLord.getLastName());
		assertEquals("Slab", timeLord.getFirstName());
		assertEquals("T", timeLord.getMiddleInitial());
		assertEquals(Gender.Male, timeLord.getGender());
		assertEquals("Green", timeLord.getFavoriteColor());
		int januaryInJava = 0;
		GregorianCalendar expectedDateOfBirth = new GregorianCalendar(5123,
				januaryInJava, 12);
		TestHelper.checkDateDownToTheDay(expectedDateOfBirth,
				timeLord.getDateOfBirth());

	}
	@Test
	public void testParsePipeRow_Female() throws Exception {
		String input = "MclargeHuge Big C F 12-21-2946 Blue";
		PersonParser parser = new SpaceParser();
		PersonInterface companion = parser.parsePerson(input);
		assertEquals(Person.class, companion.getClass());
		assertEquals("MclargeHuge", companion.getLastName());
		assertEquals("Big", companion.getFirstName());
		assertEquals("C", companion.getMiddleInitial());
		assertEquals(Gender.Female, companion.getGender());
		assertEquals("Blue", companion.getFavoriteColor());
		int decemberInJava = 11;
		GregorianCalendar expectedDateOfBirth = new GregorianCalendar(2946,
				decemberInJava, 21);
		TestHelper.checkDateDownToTheDay(expectedDateOfBirth,
				companion.getDateOfBirth());

	}
	@Test
	public void testParsePipeRow_Male_differentGenderCasing() throws Exception {
		String input = "Bulkhead Slab T m 1-12-5123 Green";
		PersonParser parser = new SpaceParser();
		PersonInterface timeLord = parser.parsePerson(input);
		assertEquals(Person.class, timeLord.getClass());
		assertEquals("Bulkhead", timeLord.getLastName());
		assertEquals("Slab", timeLord.getFirstName());
		assertEquals("T", timeLord.getMiddleInitial());
		assertEquals(Gender.Male, timeLord.getGender());
		assertEquals("Green", timeLord.getFavoriteColor());
		int januaryInJava = 0;
		GregorianCalendar expectedDateOfBirth = new GregorianCalendar(5123,
				januaryInJava, 12);
		TestHelper.checkDateDownToTheDay(expectedDateOfBirth,
				timeLord.getDateOfBirth());

	}
	@Test
	public void testParsePipeRow_Female_DifferentGenderCasing()
			throws Exception {
		String input = "MclargeHuge Big C f 12-21-2946 Blue";
		PersonParser pipeParser = new SpaceParser();
		PersonInterface companion = pipeParser.parsePerson(input);
		assertEquals(Person.class, companion.getClass());
		assertEquals("MclargeHuge", companion.getLastName());
		assertEquals("Big", companion.getFirstName());
		assertEquals("C", companion.getMiddleInitial());
		assertEquals(Gender.Female, companion.getGender());
		assertEquals("Blue", companion.getFavoriteColor());
		int decemberInJava = 11;
		GregorianCalendar expectedDateOfBirth = new GregorianCalendar(2946,
				decemberInJava, 21);
		TestHelper.checkDateDownToTheDay(expectedDateOfBirth,
				companion.getDateOfBirth());

	}
	@Test
	public void testParsePipeRow_IndeterminateGender() throws Exception {
		String input = "PunchBeef Beat D X 8-22-1242 Red";
		PersonParser parser = new SpaceParser();
		PersonInterface person = parser.parsePerson(input);
		assertEquals(Person.class, person.getClass());
		assertEquals("PunchBeef", person.getLastName());
		assertEquals("Beat", person.getFirstName());
		assertEquals("D", person.getMiddleInitial());
		assertEquals(Gender.NonBinary, person.getGender());
		assertEquals("Red", person.getFavoriteColor());
		int augustInJava = 7;
		GregorianCalendar expectedDateOfBirth = new GregorianCalendar(1242,
				augustInJava, 22);
		TestHelper.checkDateDownToTheDay(expectedDateOfBirth,
				person.getDateOfBirth());
	}
	@Test
	public void testWrongNumberOfSpaces() throws Exception {
		String inputNotEnoughPipes = "BoneMeal Crud D X 3-24-4512";
		String inputNotTooManyPipes = "Deadlift Butch D X 3-24-4512 Red  23423 MoreStuff and more";
		PersonParser parser = new SpaceParser();
		assertEquals(NullPerson.NULL, parser.parsePerson(inputNotEnoughPipes));
		assertEquals(NullPerson.NULL, parser.parsePerson(inputNotTooManyPipes));
	}
	@Test
	public void testBadDates() throws Exception {
		String inputNotADate = "Bulkhead Slab T m impretendingtobeadate Green";
		String inputBlankDate = "Bulkhead Slab T m  Green";
		String inputDifferentFormatDate = "Bulkhead Slab T m 12/22/2355 Green";

		PersonParser parser = new SpaceParser();

		assertEquals(NullPerson.NULL, parser.parsePerson(inputNotADate));
		assertEquals(NullPerson.NULL, parser.parsePerson(inputBlankDate));
		assertEquals(NullPerson.NULL,
				parser.parsePerson(inputDifferentFormatDate));
	}
}
