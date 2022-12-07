package com.people;

import java.util.GregorianCalendar;

public class Person implements PersonInterface {

	private String lastName;
	private String firstName;
	private String middleInitial;
	private Gender gender;
	private String color;
	private GregorianCalendar dateOfBirth;

	public Person(String lastName, String firstName, String middleInitial,
			Gender gender, String color, GregorianCalendar dateOfBirth) {
		this.lastName = lastName;
		this.firstName = firstName;
		this.middleInitial = middleInitial;
		this.gender = gender;
		this.color = color;
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String getFavoriteColor() {
		return color;
	}

	@Override
	public GregorianCalendar getDateOfBirth() {
		return dateOfBirth;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public Gender getGender() {
		return gender;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public String getMiddleInitial() {
		return middleInitial;
	}

}
