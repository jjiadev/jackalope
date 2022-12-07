package com.parsing;

import java.text.ParseException;
import java.util.GregorianCalendar;

import com.people.Gender;
import com.people.NullPerson;
import com.people.Person;
import com.people.PersonInterface;

public class PipeParser implements PersonParser {

	public PersonInterface parsePerson(String input) {

		String[] split = input.split("\\|");
		if (split.length == 6) {
			try {
				String lastName = split[0].trim();
				String firstName = split[1].trim();
				String middleInitial = split[2].trim();
				Gender gender = ParseHelper.parseSingleLetterGender(split[3]
						.trim());
				String favoriteColor = split[4].trim();
				GregorianCalendar dateOfBirth = new GregorianCalendar();
				dateOfBirth = ParseHelper.parseDate(split[5].trim(),
						"MM-dd-yyyy");
				return new Person(lastName, firstName, middleInitial, gender,
						favoriteColor, dateOfBirth);
			} catch (ParseException e) {
				return NullPerson.NULL;
			}
		}
		return NullPerson.NULL;
	}

}
