package com.people;

import junit.framework.TestCase;

public class GenderTest extends TestCase {

	public void testCompare() throws Exception {

		assertEquals(-1, Gender.Female.compareTo(Gender.Male));
		assertEquals(-2, Gender.Female.compareTo(Gender.Undetermined));
		assertEquals(0, Gender.Female.compareTo(Gender.Female));

		assertEquals(1, Gender.Male.compareTo(Gender.Female));
		assertEquals(-1, Gender.Male.compareTo(Gender.Undetermined));
		assertEquals(0, Gender.Male.compareTo(Gender.Male));

		assertEquals(1, Gender.Undetermined.compareTo(Gender.Male));
		assertEquals(2, Gender.Undetermined.compareTo(Gender.Female));
		assertEquals(0, Gender.Undetermined.compareTo(Gender.Undetermined));
	}
}
