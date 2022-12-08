package com.people;

import java.util.ArrayList;
import java.util.GregorianCalendar;

import junit.framework.TestCase;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BirthdateSorterTest {

	@Test
	public void testSort() throws Exception {
		BirthdateSorter birthdateSorter = new BirthdateSorter();
		ArrayList<PersonInterface> people = new ArrayList<PersonInterface>();
		MockPerson mockPerson1 = new MockPerson(new GregorianCalendar(2012, 11,
				23));
		MockPerson mockPerson2 = new MockPerson(new GregorianCalendar(2011, 11,
				23));
		MockPerson mockPerson3 = new MockPerson(new GregorianCalendar(2012, 1,
				23));
		MockPerson mockPerson4 = new MockPerson(new GregorianCalendar(2012, 11,
				3));
		people.add(mockPerson1);
		people.add(mockPerson2);
		people.add(mockPerson3);
		people.add(mockPerson4);
		birthdateSorter.sortPeople(people);

		assertEquals(mockPerson2, people.get(0));
		assertEquals(mockPerson3, people.get(1));
		assertEquals(mockPerson4, people.get(2));
		assertEquals(mockPerson1, people.get(3));
	}

	@Test
	public void testSortWillPutFemaleAfterMaleWithTheSameDate()
			throws Exception {
		BirthdateSorter birthdateSorter = new BirthdateSorter();
		ArrayList<PersonInterface> people = new ArrayList<PersonInterface>();
		MockPerson mockPerson1 = new MockPerson(new GregorianCalendar(2012, 11,
				23), Gender.Female);
		MockPerson mockPerson2 = new MockPerson(new GregorianCalendar(2012, 11,
				23), Gender.Male);
		people.add(mockPerson1);
		people.add(mockPerson2);
		birthdateSorter.sortPeople(people);

		assertEquals(mockPerson2, people.get(0));
		assertEquals(mockPerson1, people.get(1));
	}
}
