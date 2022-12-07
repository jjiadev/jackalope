package com.people;

import java.util.GregorianCalendar;

import org.junit.Test;

import junit.framework.TestCase;

public class PersonTest extends TestCase {

	@Test
	public void testImplementsInterface() throws Exception {
		assertEquals(PersonInterface.class, Person.class.getInterfaces()[0]);
	}

	@Test
	public void testConstructor() throws Exception {
		String lastName = "ThisIsTheLastNamerson";
		String firstName = "ThisIsTheFirstName";
		String middleInitial = "MiddleInitial";
		Gender gender = Gender.Male;
		String color = "Red";
		GregorianCalendar dateOfBirth = new GregorianCalendar();
		PersonInterface person = new Person(lastName, firstName, middleInitial,
				gender, color, dateOfBirth);
		assertEquals(lastName, person.getLastName());
		assertEquals(firstName, person.getFirstName());
		assertEquals(middleInitial, person.getMiddleInitial());
		assertEquals(gender, person.getGender());
		assertEquals(color, person.getFavoriteColor());
		assertEquals(dateOfBirth, person.getDateOfBirth());
	}

	@Test
	public void testConstructorAgainSoIDontHardcodeEverything()
			throws Exception {
		String lastName = "LastyMcgee";
		String firstName = "Firsterson";
		String middleInitial = "M";
		Gender gender = Gender.Female;
		String color = "Purple";
		GregorianCalendar dateOfBirth = new GregorianCalendar();
		PersonInterface person = new Person(lastName, firstName, middleInitial,
				gender, color, dateOfBirth);
		assertEquals(lastName, person.getLastName());
		assertEquals(firstName, person.getFirstName());
		assertEquals(middleInitial, person.getMiddleInitial());
		assertEquals(gender, person.getGender());
		assertEquals(color, person.getFavoriteColor());
		assertEquals(dateOfBirth, person.getDateOfBirth());

	}
}
