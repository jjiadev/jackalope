package com.people;

import java.text.SimpleDateFormat;

public class PersonFormatter implements PersonFormatterInterface {
	public String getFormattedPersonString(PersonInterface person) {
		String lastName = person.getLastName();
		String firstName = person.getFirstName();
		String gender = person.getGender().toString();
		String favoriteColor = person.getFavoriteColor();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("M/d/yyyy");
		String birthDate = simpleDateFormat.format(person.getDateOfBirth()
				.getTime());
		return lastName + " " + firstName + " " + gender + " " + birthDate
				+ " " + favoriteColor;
	}

}
