package com.parsing;

import java.util.GregorianCalendar;
import java.util.List;

import junit.framework.TestCase;

import com.io.FileReader;
import com.io.MockFileReader;
import com.people.Gender;
import com.people.MockPerson;
import com.people.NullPerson;
import com.people.PersonInterface;
import com.utilities.TestHelper;
import org.junit.Test;
import static junit.framework.TestCase.*;

public class PersonLoaderTest {
	@Test
	public void testConstructorArgs() throws Exception {
		MockFileReader mockFileReader = new MockFileReader();
		PersonLoader personLoader = new PersonLoader(mockFileReader);
		assertEquals(mockFileReader, personLoader.getFileReader());
	}

	@Test
	public void testLoadPeople() throws Exception {
		MockPersonParser mockPersonParser = new MockPersonParser();
		MockFileReader mockFileReader = new MockFileReader();
		PersonLoader fileParser = new PersonLoader(mockFileReader);
		String filePath = "thisisthefilepath";

		mockFileReader.setFileContentsToReturn("line1\nline2 \n line3\n line4");
		MockPerson person1 = new MockPerson();
		MockPerson person2 = new MockPerson();
		MockPerson person3 = new MockPerson();
		MockPerson person4 = new MockPerson();

		mockPersonParser.addPersonForInput("line1", person1);
		mockPersonParser.addPersonForInput("line2", person2);
		mockPersonParser.addPersonForInput("line3", person3);
		mockPersonParser.addPersonForInput("line4", person4);

		List<PersonInterface> people = fileParser.loadPeople(filePath,
				mockPersonParser);
		assertEquals(filePath, mockFileReader.getLastFileRead());

		assertEquals(4, people.size());
		assertEquals(person1, people.get(0));
		assertEquals(person2, people.get(1));
		assertEquals(person3, people.get(2));
		assertEquals(person4, people.get(3));
	}

	public void testLoadPeople_WillNotCollectNullPeople() throws Exception {
		MockPersonParser mockPersonParser = new MockPersonParser();
		MockFileReader mockFileReader = new MockFileReader();
		PersonLoader fileParser = new PersonLoader(mockFileReader);
		String filePath = "thisisthefilepath";

		mockFileReader.setFileContentsToReturn("line1\nline2 \n line3\n line4");
		MockPerson person1 = new MockPerson();
		MockPerson person2 = new MockPerson();

		mockPersonParser.addPersonForInput("line1", person1);
		mockPersonParser.addPersonForInput("line2", NullPerson.NULL);
		mockPersonParser.addPersonForInput("line3", NullPerson.NULL);
		mockPersonParser.addPersonForInput("line4", person2);

		List<PersonInterface> people = fileParser.loadPeople(filePath,
				mockPersonParser);
		assertEquals(filePath, mockFileReader.getLastFileRead());

		assertEquals(2, people.size());
		assertEquals(person1, people.get(0));
		assertEquals(person2, people.get(1));

	}

	public void testIntegrationTest_Space() throws Exception {
		PersonLoader fileParser = new PersonLoader(new FileReader());
		String filePath = "../Jackalope/resources/input_files/space.txt";
		List<PersonInterface> spacePeople = fileParser.loadPeople(filePath,
				new SpaceParser());
		assertEquals(3, spacePeople.size());
		checkPerson("Kournikova", "Anna", "F", Gender.Female, "Red",
				new GregorianCalendar(1975, 5, 3), spacePeople.get(0));
		checkPerson("Hingis", "Martina", "M", Gender.Female, "Green",
				new GregorianCalendar(1979, 3, 2), spacePeople.get(1));
		checkPerson("Seles", "Monica", "H", Gender.Female, "Black",
				new GregorianCalendar(1973, 11, 2), spacePeople.get(2));

	}

	public void testIntegrationTest_Pipe() throws Exception {
		PersonLoader fileParser = new PersonLoader(new FileReader());
		String filePath = "../Jackalope/resources/input_files/pipe.txt";
		List<PersonInterface> pipePeople = fileParser.loadPeople(filePath,
				new PipeParser());
		assertEquals(3, pipePeople.size());
		checkPerson("Smith", "Steve", "D", Gender.Male, "Red",
				new GregorianCalendar(1985, 2, 3), pipePeople.get(0));
		checkPerson("Bonk", "Radek", "S", Gender.Male, "Green",
				new GregorianCalendar(1975, 5, 3), pipePeople.get(1));
		checkPerson("Bouillon", "Francis", "G", Gender.Male, "Blue",
				new GregorianCalendar(1975, 5, 3), pipePeople.get(2));

	}

	public void testIntegrationTest_Comma() throws Exception {
		PersonLoader fileParser = new PersonLoader(new FileReader());
		String filePath = "../Jackalope/resources/input_files/comma.txt";
		List<PersonInterface> commaPeople = fileParser.loadPeople(filePath,
				new CommaParser());
		assertEquals(3, commaPeople.size());
		checkPerson("Abercrombie", "Neil", "", Gender.Male, "Tan",
				new GregorianCalendar(1943, 1, 13), commaPeople.get(0));
		checkPerson("Bishop", "Timothy", "", Gender.Male, "Yellow",
				new GregorianCalendar(1967, 3, 23), commaPeople.get(1));
		checkPerson("Kelly", "Sue", "", Gender.Female, "Pink",
				new GregorianCalendar(1959, 6, 12), commaPeople.get(2));

	}

	private void checkPerson(String lastName, String firstName,
			String middleInitial, Gender gender, String favoriteColor,
			GregorianCalendar birthDate, PersonInterface person) {
		assertEquals(lastName, person.getLastName());
		assertEquals(firstName, person.getFirstName());
		assertEquals(middleInitial, person.getMiddleInitial());
		TestHelper.checkDateDownToTheDay(birthDate, person.getDateOfBirth());
		assertEquals(gender, person.getGender());
		assertEquals(favoriteColor, person.getFavoriteColor());
	}
}
