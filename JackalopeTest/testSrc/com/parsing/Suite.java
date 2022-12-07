package com.parsing;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class Suite extends TestCase {

	public static Test suite() {
		TestSuite suite = new TestSuite(Suite.class.getName());
		suite.addTestSuite(CommaParserTest.class);
		suite.addTestSuite(ParseHelperTest.class);
		suite.addTestSuite(PersonLoaderTest.class);
		suite.addTestSuite(PipeParserTest.class);
		suite.addTestSuite(SpaceParserTest.class);
		return suite;
	}

}
