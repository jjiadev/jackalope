package com.people;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import junit.framework.TestCase;

import com.parsing.CommaParser;
import com.parsing.PipeParser;
import com.parsing.SpaceParser;
import com.people.MockPeopleLoader.LoadPeopleArgs;
import com.utilities.TestHelper;
import org.junit.Test;
import static junit.framework.TestCase.*;

public class PersonCompilerTest {

	@Test
	public void testImplementsInterface() throws Exception {
		assertEquals(PersonCompilerInterface.class,
				PersonCompiler.class.getInterfaces()[0]);
	}
	@Test
	public void testConstructor() throws Exception {
		MockPeopleLoader peopleLoader = new MockPeopleLoader();
		PersonCompiler personCompiler = new PersonCompiler(peopleLoader);
		assertEquals(peopleLoader, personCompiler.getPeopleLoader());
	}
	@Test
	public void testLoadAllPeople() throws Exception {
		MockPeopleLoader peopleLoader = new MockPeopleLoader();
		PersonCompiler personCompiler = new PersonCompiler(peopleLoader);

		String path = "thisiswherethepathgoes";
		personCompiler.getAllPeople(path);

		List<LoadPeopleArgs> loadPeopleArguments = peopleLoader
				.getLoadPeopleArguments();
		assertEquals(3, loadPeopleArguments.size());
		assertEquals(path + "/space.txt", loadPeopleArguments.get(0)
				.getFilePath());
		TestHelper.assertIsOfType(SpaceParser.class, loadPeopleArguments.get(0)
				.getPersonParser());

		assertEquals(path + "/pipe.txt", loadPeopleArguments.get(1)
				.getFilePath());
		TestHelper.assertIsOfType(PipeParser.class, loadPeopleArguments.get(1)
				.getPersonParser());

		assertEquals(path + "/comma.txt", loadPeopleArguments.get(2)
				.getFilePath());
		TestHelper.assertIsOfType(CommaParser.class, loadPeopleArguments.get(2)
				.getPersonParser());

	}
	@Test
	public void testLoadAllPeople_ReturnsTheResultsOfAllThreeLoadCalls()
			throws Exception {
		MockPeopleLoader peopleLoader = new MockPeopleLoader();
		PersonCompiler personCompiler = new PersonCompiler(peopleLoader);

		ArrayList<List<? extends PersonInterface>> peopleToReturn = new ArrayList<List<? extends PersonInterface>>();
		MockPerson mockPerson1 = new MockPerson();
		MockPerson mockPerson2 = new MockPerson();
		MockPerson mockPerson3 = new MockPerson();
		MockPerson mockPerson4 = new MockPerson();
		MockPerson mockPerson5 = new MockPerson();
		MockPerson mockPerson6 = new MockPerson();
		MockPerson mockPerson7 = new MockPerson();
		MockPerson mockPerson8 = new MockPerson();

		List<MockPerson> list1 = Arrays.asList(mockPerson1, mockPerson2,
				mockPerson3);
		List<MockPerson> list2 = Arrays.asList(mockPerson4);
		List<MockPerson> list3 = Arrays.asList(mockPerson5, mockPerson6,
				mockPerson7, mockPerson8);
		peopleToReturn.add(list1);
		peopleToReturn.add(list2);
		peopleToReturn.add(list3);
		peopleLoader.setPeopleToReturn(peopleToReturn);
		List<PersonInterface> allPeople = personCompiler.getAllPeople("");

		assertEquals(8, allPeople.size());
		assertEquals(mockPerson1, allPeople.get(0));
		assertEquals(mockPerson2, allPeople.get(1));
		assertEquals(mockPerson3, allPeople.get(2));
		assertEquals(mockPerson4, allPeople.get(3));
		assertEquals(mockPerson5, allPeople.get(4));
		assertEquals(mockPerson6, allPeople.get(5));
		assertEquals(mockPerson7, allPeople.get(6));
		assertEquals(mockPerson8, allPeople.get(7));

	}
}
