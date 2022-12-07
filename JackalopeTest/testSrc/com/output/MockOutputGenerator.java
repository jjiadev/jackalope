package com.output;

import java.util.ArrayList;
import java.util.List;

import com.people.OutputGeneratorInterface;
import com.people.PersonInterface;
import com.people.PersonSorter;

public class MockOutputGenerator implements OutputGeneratorInterface {

	public class OutputGeneratorArgs {

		private int outputNumber;
		private List<PersonInterface> people;
		private PersonSorter personSorter;

		public OutputGeneratorArgs(int outputNumber,
				List<PersonInterface> people, PersonSorter personSorter) {
			this.outputNumber = outputNumber;
			this.people = people;
			this.personSorter = personSorter;
		}

		public int getOutputNumber() {
			return outputNumber;
		}

		public List<PersonInterface> getPeople() {
			return people;
		}

		public PersonSorter getPersonSorter() {
			return personSorter;
		}
	}

	private List<OutputGeneratorArgs> outputGeneratorArgs;
	private List<String> outputToReturn;
	private int numberOfCalls;

	public MockOutputGenerator() {
		outputGeneratorArgs = new ArrayList<OutputGeneratorArgs>();
		outputToReturn = new ArrayList<String>();
		numberOfCalls = 0;
	}

	public void setOutputToReturn(List<String> outputToReturn) {
		this.outputToReturn = outputToReturn;
	}

	@Override
	public String createOutput(int outputNumber, List<PersonInterface> people,
			PersonSorter personSorter) {
		this.outputGeneratorArgs.add(new OutputGeneratorArgs(outputNumber,
				people, personSorter));
		if (numberOfCalls >= outputToReturn.size()) {
			return "";
		} else {
			String output = outputToReturn.get(numberOfCalls);
			numberOfCalls++;
			return output;
		}
	}

	public List<OutputGeneratorArgs> getOutputGeneratorArgs() {
		return outputGeneratorArgs;
	}

}
