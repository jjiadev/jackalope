package com.parsing;

import java.text.ParseException;
import java.util.GregorianCalendar;

import com.people.Gender;
import com.people.NullPerson;
import com.people.Person;
import com.people.PersonInterface;

public class SpaceParser implements PersonParser {

	@Override
	public PersonInterface parsePerson(String input) {
		String[] split = input.split(" ");
		if (split.length == 6) {
			try {
				String lastName = split[0].trim();
				String firstName = split[1].trim();
				String middleInitial = split[2].trim();
				String genderAsString = split[3].trim();
				Gender gender = ParseHelper
						.parseSingleLetterGender(genderAsString);
				String dateString = split[4].trim();
				GregorianCalendar birthDate = ParseHelper.parseDate(dateString,
						"MM-dd-yyyy");
				String favoriteColor = split[5].trim();
				return new Person(lastName, firstName, middleInitial, gender,
						favoriteColor, birthDate);
			} catch (ParseException e) {
				return NullPerson.NULL;
			}
		}
		return NullPerson.NULL;
	}
}
