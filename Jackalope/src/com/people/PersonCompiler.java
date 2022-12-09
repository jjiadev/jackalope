package com.people;

import java.util.ArrayList;
import java.util.List;

import com.parsing.*;

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
		allPeople.addAll(peopleLoader.loadPeople(path + "/tricky_pipe.txt",
				new TrickyPipeParser()));
		return allPeople;

	}
}
