package com.people;

import java.util.ArrayList;

import junit.framework.TestCase;
import org.junit.Test;
import static junit.framework.TestCase.*;

public class GenderAndLastNameSorterTest {

	@Test
	public void testSort() throws Exception {
		GenderAndLastNameSorter sorter = new GenderAndLastNameSorter();
		ArrayList<PersonInterface> people = new ArrayList<PersonInterface>();
		MockPerson person1 = new MockPerson("Socrates", Gender.Male);
		MockPerson person2 = new MockPerson("Sartre", Gender.Male);
		MockPerson person3 = new MockPerson("de Beauvoir", Gender.Female);
		MockPerson person4 = new MockPerson("Zegzebski", Gender.Female);
		MockPerson person5 = new MockPerson("Diogenes", Gender.Undetermined);

		people.add(person1);
		people.add(person2);
		people.add(person3);
		people.add(person4);
		people.add(person5);

		sorter.sortPeople(people);

		assertEquals(person3, people.get(0));
		assertEquals(person4, people.get(1));
		assertEquals(person2, people.get(2));
		assertEquals(person1, people.get(3));
		assertEquals(person5, people.get(4));

	}
}
