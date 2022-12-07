package com.utilities;

import java.util.GregorianCalendar;

import org.junit.Assert;

public class TestHelper {
	public static void checkDateDownToTheDay(
			GregorianCalendar expectedDateOfBirth, GregorianCalendar dateOfBirth) {
		Assert.assertEquals("Years were off",
				expectedDateOfBirth.get(GregorianCalendar.YEAR),
				dateOfBirth.get(GregorianCalendar.YEAR));
		Assert.assertEquals("Months were off",
				expectedDateOfBirth.get(GregorianCalendar.MONTH),
				dateOfBirth.get(GregorianCalendar.MONTH));
		Assert.assertEquals("Days were off",
				expectedDateOfBirth.get(GregorianCalendar.DAY_OF_MONTH),
				dateOfBirth.get(GregorianCalendar.DAY_OF_MONTH));

	}

	public static <T> void assertIsOfType(T expectedtype, Object actual) {
		Assert.assertEquals(expectedtype, actual.getClass());
	}
}
