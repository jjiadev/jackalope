package com.people;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class GenderAndLastNameSorter implements PersonSorter {

	private class GenderAndLastNameComparator implements
			Comparator<PersonInterface> {

		@Override
		public int compare(PersonInterface arg0, PersonInterface arg1) {
			int genderCompare = arg0.getGender().compareTo(arg1.getGender());
			if (genderCompare == 0) {
				return arg0.getLastName().toUpperCase().compareTo(arg1.getLastName().toUpperCase());
			}
			return genderCompare;
		}

	}

	@Override
	public void sortPeople(List<PersonInterface> people) {
		Collections.sort(people, new GenderAndLastNameComparator());
	}

}
