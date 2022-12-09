package com.parsing;

import java.text.ParseException;
import java.util.GregorianCalendar;

import com.people.Gender;
import com.people.NullPerson;
import com.people.Person;
import com.people.PersonInterface;

public class CommaParser implements PersonParser {
	@Override
	public PersonInterface parsePerson(String input) {
		String[] split = input.split(",");
		if (split.length == 5) {
			try {

				String lastName = split[0].trim();
				String firstName = split[1].trim();
				String favoriteColor = split[3].trim();
				String dateString = split[4];
				GregorianCalendar birthDate = ParseHelper.parseDate(dateString,
						"MM/dd/yyyy");
				Gender gender = parseGender(split);
				return new Person(lastName, firstName, "", gender,
						favoriteColor, birthDate);
			} catch (ParseException e) {
				return NullPerson.NULL;
			}
		}
		return NullPerson.NULL;
	}

	private Gender parseGender(String[] split) {
		String genderString = split[2].trim().toLowerCase();
		if (genderString.equals("male")) {
			return Gender.Male;
		}
		if (genderString.equals("female")) {
			return Gender.Female;
		}
		return Gender.NonBinary;
	}

}
