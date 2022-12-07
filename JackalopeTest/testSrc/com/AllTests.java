package com;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class AllTests extends TestCase {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		suite.addTest(com.io.Suite.suite());
		suite.addTest(com.output.Suite.suite());
		suite.addTest(com.parsing.Suite.suite());
		suite.addTest(com.people.Suite.suite());
		return suite;
	}

}
