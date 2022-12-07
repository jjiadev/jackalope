package com.people;

import java.util.ArrayList;

import junit.framework.TestCase;

public class OutputGeneratorTest extends TestCase {

	public void testImplementsInterface() throws Exception {
		assertEquals(OutputGeneratorInterface.class,
				OutputGenerator.class.getInterfaces()[0]);
	}

	public void testConstructor() throws Exception {
		MockPersonFormatter personFormatter = new MockPersonFormatter();
		OutputGenerator outputGenerator = new OutputGenerator(personFormatter);
		assertEquals(personFormatter, outputGenerator.getPersonFormatter());
	}

	public void testGenerateOutput() throws Exception {
		MockPersonFormatter personFormatter = new MockPersonFormatter();
		MockPersonSorter mockPersonSorter = new MockPersonSorter();
		OutputGenerator outputGenerator = new OutputGenerator(personFormatter);
		ArrayList<PersonInterface> people = new ArrayList<PersonInterface>();
		MockPerson person1 = new MockPerson();
		MockPerson person2 = new MockPerson();
		MockPerson person3 = new MockPerson();
		MockPerson person4 = new MockPerson();

		people.add(person1);
		people.add(person2);
		people.add(person3);
		people.add(person4);

		String formattedPerson1 = "Rip Slagcheek";
		String formattedPerson2 = "Punch Sideiron";
		String formattedPerson3 = "Touch Rustrod";
		String formattedPerson4 = "Smoke Manmuscle";
		personFormatter.addFormattedPerson(person1, formattedPerson1);
		personFormatter.addFormattedPerson(person2, formattedPerson2);
		personFormatter.addFormattedPerson(person3, formattedPerson3);
		personFormatter.addFormattedPerson(person4, formattedPerson4);

		int outputNumber = 1;
		String expectedOutput = "Output " + outputNumber + ":\n";
		expectedOutput += formattedPerson1 + "\n";
		expectedOutput += formattedPerson2 + "\n";
		expectedOutput += formattedPerson3 + "\n";
		expectedOutput += formattedPerson4 + "\n";
		expectedOutput += "\n";

		String output = outputGenerator.createOutput(outputNumber, people,
				mockPersonSorter);
		assertEquals(people, mockPersonSorter.getPeopleSorted());
		assertEquals(expectedOutput, output);

	}

	public void testGenerateOutput_AnotherCase() throws Exception {
		MockPersonFormatter personFormatter = new MockPersonFormatter();
		MockPersonSorter mockPersonSorter = new MockPersonSorter();
		OutputGenerator outputGenerator = new OutputGenerator(personFormatter);
		ArrayList<PersonInterface> people = new ArrayList<PersonInterface>();
		MockPerson person1 = new MockPerson();
		MockPerson person2 = new MockPerson();
		MockPerson person3 = new MockPerson();

		people.add(person1);
		people.add(person2);
		people.add(person3);

		String formattedPerson1 = "Crud Bonemeal";
		String formattedPerson2 = "Smash Lampjaw";
		String formattedPerson3 = "Buff Drinklots";
		personFormatter.addFormattedPerson(person1, formattedPerson1);
		personFormatter.addFormattedPerson(person2, formattedPerson2);
		personFormatter.addFormattedPerson(person3, formattedPerson3);

		int outputNumber = 3;
		String expectedOutput = "Output " + outputNumber + ":\n";
		expectedOutput += formattedPerson1 + "\n";
		expectedOutput += formattedPerson2 + "\n";
		expectedOutput += formattedPerson3 + "\n";
		expectedOutput += "\n";

		String output = outputGenerator.createOutput(outputNumber, people,
				mockPersonSorter);
		assertEquals(people, mockPersonSorter.getPeopleSorted());
		assertEquals(expectedOutput, output);

	}
}
