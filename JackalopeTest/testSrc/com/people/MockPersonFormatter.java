package com.people;

import java.util.HashMap;

public class MockPersonFormatter implements PersonFormatterInterface {

	private HashMap<PersonInterface, String> formattedPeople;

	public MockPersonFormatter() {
		formattedPeople = new HashMap<>();
	}

	@Override
	public String getFormattedPersonString(PersonInterface person) {
		if (formattedPeople.containsKey(person)) {
			return formattedPeople.get(person);
		}
		return "";
	}

	public void addFormattedPerson(PersonInterface person,
			String formattedPerson) {
		formattedPeople.put(person, formattedPerson);
	}

}
