package com.people;

import java.util.ArrayList;
import java.util.List;

import com.parsing.CommaParser;
import com.parsing.PeopleLoaderInterface;
import com.parsing.PipeParser;
import com.parsing.SpaceParser;

public class PersonCompiler implements PersonCompilerInterface {

	private PeopleLoaderInterface peopleLoader;

	public PersonCompiler(PeopleLoaderInterface peopleLoader) {
		this.peopleLoader = peopleLoader;

	}

	public PeopleLoaderInterface getPeopleLoader() {
		return peopleLoader;
	}

	public List<PersonInterface> getAllPeople(String path) {
		ArrayList<PersonInterface> allPeople = new ArrayList<PersonInterface>();
		allPeople.addAll(peopleLoader.loadPeople(path + "/space.txt",
				new SpaceParser()));
		allPeople.addAll(peopleLoader.loadPeople(path + "/pipe.txt",
				new PipeParser()));
		allPeople.addAll(peopleLoader.loadPeople(path + "/comma.txt",
				new CommaParser()));
		return allPeople;

	}
}
