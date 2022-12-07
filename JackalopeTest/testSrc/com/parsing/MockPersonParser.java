package com.parsing;

import java.util.HashMap;

import com.people.MockPerson;
import com.people.PersonInterface;

public class MockPersonParser implements PersonParser {

	private HashMap<String, PersonInterface> inputToPerson;

	public MockPersonParser() {
		inputToPerson = new HashMap<>();
	}

	public void addPersonForInput(String input, PersonInterface person) {
		inputToPerson.put(input, person);
	}

	@Override
	public PersonInterface parsePerson(String input) {
		if (inputToPerson.containsKey(input)) {
			return inputToPerson.get(input);
		}
		return new MockPerson();
	}

}
