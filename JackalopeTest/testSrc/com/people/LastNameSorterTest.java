package com.people;

import java.util.ArrayList;

import junit.framework.TestCase;

public class LastNameSorterTest extends TestCase {

	public void testImplementsInterface() throws Exception {
		assertEquals(PersonSorter.class,
				LastNameSorter.class.getInterfaces()[0]);
	}

	public void testSortsByLastNameDescending_ZtoA() throws Exception {
		LastNameSorter sorter = new LastNameSorter();
		ArrayList<PersonInterface> people = new ArrayList<PersonInterface>();
		MockPerson mockPerson1 = new MockPerson("Abernathy");
		MockPerson mockPerson2 = new MockPerson("aslan");
		MockPerson mockPerson3 = new MockPerson("Zoroaster");
		MockPerson mockPerson4 = new MockPerson("Aldous");
		MockPerson mockPerson5 = new MockPerson("Ninny");
		
		people.add(mockPerson1);
		people.add(mockPerson2);
		people.add(mockPerson3);
		people.add(mockPerson4);
		people.add(mockPerson5);

		sorter.sortPeople(people);

		assertEquals(mockPerson3, people.get(0));
		assertEquals(mockPerson5, people.get(1));
		assertEquals(mockPerson2, people.get(2));
		assertEquals(mockPerson4, people.get(3));
		assertEquals(mockPerson1, people.get(4));
	}
}
