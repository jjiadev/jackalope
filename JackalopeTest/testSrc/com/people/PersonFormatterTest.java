package com.people;

import java.util.GregorianCalendar;

import junit.framework.TestCase;

public class PersonFormatterTest extends TestCase {

	public void testImplementsInterface() throws Exception {
		assertEquals(PersonFormatterInterface.class,
				PersonFormatter.class.getInterfaces()[0]);
	}

	public void testFormatPerson() throws Exception {
		Person person = new Person("Slamchest", "Crunch",
				"MiddleInitialDoesntMatter", Gender.Male, "Black",
				new GregorianCalendar(2013, 11, 15));
		PersonFormatter personFormatter = new PersonFormatter();
		String expectedFormattedPerson = "Slamchest Crunch Male 12/15/2013 Black";
		assertEquals(expectedFormattedPerson,
				personFormatter.getFormattedPersonString(person));

	}

	public void testFormatPerson_Female() throws Exception {
		Person person = new Person("McRunfast", "Thick",
				"MiddleInitialDoesntMatter", Gender.Female, "Green",
				new GregorianCalendar(1892, 3, 5));
		PersonFormatter personFormatter = new PersonFormatter();
		String expectedFormattedPerson = "McRunfast Thick Female 4/5/1892 Green";
		assertEquals(expectedFormattedPerson,
				personFormatter.getFormattedPersonString(person));

	}

	public void testFormatPerson_Undetermined() throws Exception {
		Person person = new Person("Thickneck", "Blast",
				"MiddleInitialDoesntMatter", Gender.Undetermined, "Blue",
				new GregorianCalendar(1992, 5, 7));
		PersonFormatter personFormatter = new PersonFormatter();
		String expectedFormattedPerson = "Thickneck Blast Undetermined 6/7/1992 Blue";
		assertEquals(expectedFormattedPerson,
				personFormatter.getFormattedPersonString(person));

	}
}
