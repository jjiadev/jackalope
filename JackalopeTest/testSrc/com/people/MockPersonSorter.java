package com.people;

import java.util.List;

public class MockPersonSorter implements PersonSorter {

	private List<PersonInterface> peopleToSort;

	@Override
	public void sortPeople(List<PersonInterface> people) {
		this.peopleToSort = people;
	}

	public List<PersonInterface> getPeopleSorted() {
		return peopleToSort;
	}

}
