package com.people;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Suite extends TestCase {

	public static Test suite() {
		TestSuite suite = new TestSuite(Suite.class.getName());
		suite.addTestSuite(BirthdateSorterTest.class);
		suite.addTestSuite(GenderAndLastNameSorterTest.class);
		suite.addTestSuite(GenderTest.class);
		suite.addTestSuite(LastNameSorterTest.class);
		suite.addTestSuite(NullPersonTest.class);
		suite.addTestSuite(OutputGeneratorTest.class);
		suite.addTestSuite(PersonCompilerTest.class);
		suite.addTestSuite(PersonFormatterTest.class);
		suite.addTestSuite(PersonTest.class);
		return suite;
	}

}
