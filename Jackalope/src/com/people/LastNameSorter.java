package com.people;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LastNameSorter implements PersonSorter {

	private class LastNameComparator implements Comparator<PersonInterface> {

		@Override
		public int compare(PersonInterface arg0, PersonInterface arg1) {
			return arg1.getLastName().toUpperCase().compareTo(arg0.getLastName().toUpperCase());
		}

	}

	@Override
	public void sortPeople(List<PersonInterface> people) {
		Collections.sort(people, new LastNameComparator());
	}

}
