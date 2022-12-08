package com.output;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;

import com.io.FileReader;
import com.io.FileWriter;
import com.io.MockFileWriter;
import com.output.MockOutputGenerator.OutputGeneratorArgs;
import com.parsing.PersonLoader;
import com.people.BirthdateSorter;
import com.people.GenderAndLastNameSorter;
import com.people.LastNameSorter;
import com.people.MockPersonCompiler;
import com.people.OutputGenerator;
import com.people.PersonCompiler;
import com.people.PersonFormatter;
import com.people.PersonInterface;
import com.utilities.TestHelper;

import org.junit.Test;

import static junit.framework.TestCase.*;

public class ResultGeneratorTest {

	@Test
	public void testConstructor() throws Exception {
		MockOutputGenerator outputGenerator = new MockOutputGenerator();
		MockFileWriter fileWriter = new MockFileWriter();
		MockPersonCompiler personCompiler = new MockPersonCompiler();
		ResultGenerator resultGenerator = new ResultGenerator(outputGenerator,
				fileWriter, personCompiler);
		assertEquals(outputGenerator, resultGenerator.getOutputGenerator());
		assertEquals(fileWriter, resultGenerator.getFileWriter());
		assertEquals(personCompiler, resultGenerator.getPersonCompiler());
	}
	@Test
	public void testPassesCorrectArgumentsToGenerateOutput() throws Exception {
		MockOutputGenerator outputGenerator = new MockOutputGenerator();
		MockFileWriter fileWriter = new MockFileWriter();
		MockPersonCompiler personCompiler = new MockPersonCompiler();

		ArrayList<PersonInterface> allPeopleToReturn = new ArrayList<PersonInterface>();
		personCompiler.setAllPeopleToReturn(allPeopleToReturn);

		ResultGenerator resultGenerator = new ResultGenerator(outputGenerator,
				fileWriter, personCompiler);
		resultGenerator.writeOutput("", "inputPath");

		assertEquals(3, outputGenerator.getOutputGeneratorArgs().size());

		OutputGeneratorArgs outputGeneratorArgs1 = outputGenerator
				.getOutputGeneratorArgs().get(0);
		OutputGeneratorArgs outputGeneratorArgs2 = outputGenerator
				.getOutputGeneratorArgs().get(1);
		OutputGeneratorArgs outputGeneratorArgs3 = outputGenerator
				.getOutputGeneratorArgs().get(2);

		assertSame(allPeopleToReturn, outputGeneratorArgs1.getPeople());
		assertEquals(1, outputGeneratorArgs1.getOutputNumber());
		TestHelper.assertIsOfType(GenderAndLastNameSorter.class,
				outputGeneratorArgs1.getPersonSorter());

		assertSame(allPeopleToReturn, outputGeneratorArgs2.getPeople());
		assertEquals(2, outputGeneratorArgs2.getOutputNumber());
		TestHelper.assertIsOfType(BirthdateSorter.class,
				outputGeneratorArgs2.getPersonSorter());

		assertSame(allPeopleToReturn, outputGeneratorArgs3.getPeople());
		assertEquals(3, outputGeneratorArgs3.getOutputNumber());
		TestHelper.assertIsOfType(LastNameSorter.class,
				outputGeneratorArgs3.getPersonSorter());

	}
	@Test
	public void testConcatsOutputAndSendsToFileWriter() throws Exception {
		MockOutputGenerator outputGenerator = new MockOutputGenerator();
		MockFileWriter fileWriter = new MockFileWriter();
		MockPersonCompiler personCompiler = new MockPersonCompiler();
		String output1 = "Output1";
		String output2 = "Output2";
		String output3 = "Output3";
		outputGenerator.setOutputToReturn(Arrays.asList(output1, output2,
				output3));
		ResultGenerator resultGenerator = new ResultGenerator(outputGenerator,
				fileWriter, personCompiler);
		String path = "thisiswhereIgo.txt";
		String inputFolderPath = "inputPath";
		resultGenerator.writeOutput(path, inputFolderPath);
		assertEquals(inputFolderPath, personCompiler.getPathForGetAllPeople());

		assertEquals(output1 + output2 + output3,
				fileWriter.getFileContentsWritten());
		assertEquals(path, fileWriter.getPathWrittenTo());
	}
	@Test
	public void testIntegrationTest() throws Exception {
		ResultGenerator resultGenerator = new ResultGenerator(
				new OutputGenerator(new PersonFormatter()), new FileWriter(),
				new PersonCompiler(new PersonLoader(new FileReader())));

		String path = "here.txt";
		resultGenerator.writeOutput(path, "./Jackalope/resources/input_files");
		FileInputStream inputStream = new FileInputStream(new File(path));
		byte[] outputFileBytes = new byte[inputStream.available()];
		inputStream.read(outputFileBytes);
		inputStream.close();

		String expectedPath = "./Jackalope/resources/model_output.txt";
		File expectedFile = new File(expectedPath);
		FileInputStream expectedInputStream = new FileInputStream(expectedFile);
		byte[] expectedBytes = new byte[expectedInputStream.available()];
		expectedInputStream.read(expectedBytes);
		expectedInputStream.close();

		assertEquals(new String(expectedBytes), new String(outputFileBytes));

	}
}
