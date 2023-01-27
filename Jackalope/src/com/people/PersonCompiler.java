package com.people;

import java.util.ArrayList;
import java.util.List;

import com.io.DirectoryHelper;
import com.io.DirectoryHelperInterface;
import com.parsing.CommaParser;
import com.parsing.PeopleLoaderInterface;
import com.parsing.PipeParser;
import com.parsing.SpaceParser;

public class PersonCompiler implements PersonCompilerInterface {

    private PeopleLoaderInterface peopleLoader;
    private PersonParseMapper parseMapper;

    public PersonCompiler(PeopleLoaderInterface peopleLoader, PersonParseMapper parseMapper, DirectoryHelperInterface directoryHelper) {
        this.peopleLoader = peopleLoader;
        this.parseMapper = parseMapper;
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
