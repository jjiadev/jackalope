package com.people;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class BirthdateSorter implements PersonSorter {

	private class BirthdateComparator implements Comparator<PersonInterface> {

		@Override
		public int compare(PersonInterface arg0, PersonInterface arg1) {
			int dateComparison = arg0.getDateOfBirth().compareTo(
					arg1.getDateOfBirth());
			if (dateComparison == 0) {
				return arg1.getGender().compareTo(arg0.getGender());
			}
			return dateComparison;
		}

	}

	@Override
	public void sortPeople(List<PersonInterface> people) {
		Collections.sort(people, new BirthdateComparator());
	}

}
