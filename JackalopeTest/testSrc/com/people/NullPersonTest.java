package com.people;

import java.util.GregorianCalendar;

import org.junit.Test;

import com.utilities.TestHelper;

import static junit.framework.TestCase.*;

public class NullPersonTest {

	@Test
	public void testSingleton() throws Exception {
		assertEquals(0, NullPerson.class.getConstructors().length);
		assertEquals(NullPerson.class, NullPerson.NULL.getClass());
		assertSame(NullPerson.NULL, NullPerson.NULL);
	}

	@Test
	public void testGets() throws Exception {
		assertEquals("", NullPerson.NULL.getLastName());
		assertEquals("", NullPerson.NULL.getFirstName());
		assertEquals("", NullPerson.NULL.getMiddleInitial());
		assertEquals("", NullPerson.NULL.getFavoriteColor());
		assertEquals(Gender.NonBinary, NullPerson.NULL.getGender());
		GregorianCalendar expectedBirthdate = new GregorianCalendar();
		expectedBirthdate.setTimeInMillis(0);
		assertSame(NullPerson.NULL.getDateOfBirth(),
				NullPerson.NULL.getDateOfBirth());
		TestHelper.checkDateDownToTheDay(expectedBirthdate,
				NullPerson.NULL.getDateOfBirth());
	}
}
