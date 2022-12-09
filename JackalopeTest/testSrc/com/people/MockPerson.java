package com.people;

import java.util.GregorianCalendar;

public class MockPerson implements PersonInterface {

	private GregorianCalendar dateOfBirth;
	private String lastName;
	private Gender gender;

	public MockPerson(String lastName, Gender gender) {
		this.lastName = lastName;
		this.gender = gender;
	}

	public MockPerson() {
		dateOfBirth = new GregorianCalendar();
		lastName = "";
		gender = Gender.NonBinary;
	}

	public MockPerson(String lastName) {
		this.lastName = lastName;
	}

	public MockPerson(GregorianCalendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public MockPerson(GregorianCalendar dateOfBirth, Gender gender) {
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		
	}

	@Override
	public String getFavoriteColor() {
		return null;
	}

	@Override
	public GregorianCalendar getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(GregorianCalendar dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	@Override
	public String getFirstName() {
		return null;
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
		return null;
	}

}
