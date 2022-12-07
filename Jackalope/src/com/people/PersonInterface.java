package com.people;

import java.util.GregorianCalendar;

public interface PersonInterface {

	public abstract String getFavoriteColor();

	public abstract GregorianCalendar getDateOfBirth();

	public abstract String getFirstName();

	public abstract Gender getGender();

	public abstract String getLastName();

	public abstract String getMiddleInitial();

}