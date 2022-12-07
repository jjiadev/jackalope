package com.parsing;

import java.util.ArrayList;
import java.util.List;

import com.io.FileReaderInterface;
import com.people.NullPerson;
import com.people.PersonInterface;

public class PersonLoader implements PeopleLoaderInterface {

	private FileReaderInterface fileReader;

	public PersonLoader(FileReaderInterface fileReader) {
		this.fileReader = fileReader;
	}

	public FileReaderInterface getFileReader() {
		return fileReader;
	}

	public List<PersonInterface> loadPeople(String filePath,
			PersonParser personParser) {
		String fileContents = fileReader.readFileContents(filePath);
		String[] lines = fileContents.split("\n");
		ArrayList<PersonInterface> people = new ArrayList<PersonInterface>();
		for (String line : lines) {
			PersonInterface person = personParser.parsePerson(line.trim());
			if (!NullPerson.NULL.equals(person)) {
				people.add(person);
			}
		}
		return people;

	}

}
