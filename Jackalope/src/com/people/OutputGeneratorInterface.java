package com.people;

import java.util.List;

public interface OutputGeneratorInterface {

	public abstract String createOutput(int outputNumber,
			List<PersonInterface> people, PersonSorter personSorter);

}