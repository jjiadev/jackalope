package com.people;

import org.junit.Test;
import static junit.framework.TestCase.*;

public class GenderTest {

	@Test
	public void testCompare() throws Exception {

		assertEquals(-1, Gender.Female.compareTo(Gender.Male));
		assertEquals(-2, Gender.Female.compareTo(Gender.NonBinary));
		assertEquals(0, Gender.Female.compareTo(Gender.Female));

		assertEquals(1, Gender.Male.compareTo(Gender.Female));
		assertEquals(-1, Gender.Male.compareTo(Gender.NonBinary));
		assertEquals(0, Gender.Male.compareTo(Gender.Male));

		assertEquals(1, Gender.NonBinary.compareTo(Gender.Male));
		assertEquals(2, Gender.NonBinary.compareTo(Gender.Female));
		assertEquals(0, Gender.NonBinary.compareTo(Gender.NonBinary));
	}
}
