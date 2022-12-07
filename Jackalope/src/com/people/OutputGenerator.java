package com.people;

import java.util.List;

public class OutputGenerator implements OutputGeneratorInterface {

	private PersonFormatterInterface personFormatter;

	public OutputGenerator(PersonFormatterInterface personFormatter) {
		this.personFormatter = personFormatter;
	}

	public PersonFormatterInterface getPersonFormatter() {
		return personFormatter;
	}

	public String createOutput(int outputNumber, List<PersonInterface> people,
			PersonSorter personSorter) {
		personSorter.sortPeople(people);
		String output = "Output " + outputNumber + ":\n";
		for (PersonInterface person : people) {
			output += personFormatter.getFormattedPersonString(person) + "\n";
		}
		output += "\n";
		return output;

	}
}
