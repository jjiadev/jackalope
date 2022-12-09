package com.people;

import java.util.GregorianCalendar;

public class NullPerson implements PersonInterface {

	public static final NullPerson NULL = new NullPerson();
	private GregorianCalendar dateOfBirth;

	private NullPerson() {
		dateOfBirth = new GregorianCalendar();
		dateOfBirth.setTimeInMillis(0);
	}

	@Override
	public String getFavoriteColor() {
		return "";
	}

	@Override
	public GregorianCalendar getDateOfBirth() {
		return dateOfBirth;
	}

	@Override
	public String getFirstName() {
		return "";
	}

	@Override
	public Gender getGender() {
		return Gender.NonBinary;
	}

	@Override
	public String getLastName() {
		return "";
	}

	@Override
	public String getMiddleInitial() {
		return "";
	}

}
