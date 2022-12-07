package com.people;

import java.util.ArrayList;
import java.util.List;

import com.parsing.PeopleLoaderInterface;
import com.parsing.PersonParser;

public class MockPeopleLoader implements PeopleLoaderInterface {

	public class LoadPeopleArgs {

		private PersonParser personParser;
		private String filePath;

		public LoadPeopleArgs(String filePath, PersonParser personParser) {
			this.filePath = filePath;
			this.personParser = personParser;
		}

		public String getFilePath() {
			return filePath;
		}

		public PersonParser getPersonParser() {
			return personParser;
		}

	}

	private List<LoadPeopleArgs> loadPeopleArguments;
	private List<List<? extends PersonInterface>> peopleToReturn;
	private int index;

	public MockPeopleLoader() {
		loadPeopleArguments = new ArrayList<LoadPeopleArgs>();
		peopleToReturn = new ArrayList<List<? extends PersonInterface>>();
		index = 0;
	}

	public void setPeopleToReturn(
			List<List<? extends PersonInterface>> peopleToReturn) {
		this.peopleToReturn = peopleToReturn;
	}

	@Override
	public List<? extends PersonInterface> loadPeople(String filePath,
			PersonParser personParser) {
		this.loadPeopleArguments
				.add(new LoadPeopleArgs(filePath, personParser));
		if (index >= peopleToReturn.size()) {
			return new ArrayList<PersonInterface>();
		} else {
			List<? extends PersonInterface> people = peopleToReturn.get(index);
			index++;
			return people;
		}
	}

	public List<LoadPeopleArgs> getLoadPeopleArguments() {
		return loadPeopleArguments;
	}

}
