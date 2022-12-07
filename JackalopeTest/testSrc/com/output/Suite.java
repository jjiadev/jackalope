package com.output;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Suite extends TestCase {

	public static Test suite() {
		TestSuite suite = new TestSuite(Suite.class.getName());
		suite.addTestSuite(ResultGeneratorTest.class);
		return suite;
	}

}
