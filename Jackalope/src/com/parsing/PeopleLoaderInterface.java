package com.parsing;

import java.util.List;

import com.people.PersonInterface;

public interface PeopleLoaderInterface {

	public abstract List<? extends PersonInterface> loadPeople(String filePath, PersonParser personParser);

}