package com.people;

import java.util.List;

public class MockPersonCompiler implements PersonCompilerInterface {

	private List<PersonInterface> allPeopleToReturn;
	private String pathForGetAllPeople;

	public void setAllPeopleToReturn(List<PersonInterface> allPeopleToReturn) {
		this.allPeopleToReturn = allPeopleToReturn;
	}

	@Override
	public List<PersonInterface> getAllPeople(String path) {
		this.pathForGetAllPeople = path;
		return allPeopleToReturn;
	}

	public String getPathForGetAllPeople() {
		return pathForGetAllPeople;
	}

}
