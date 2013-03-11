package edu.bu.cs673.AwesomeAlphabet.test;

import static org.junit.Assert.assertFalse;

import org.junit.Test;

import edu.bu.cs673.AwesomeAlphabet.main.AAConfig;

public class AAConfigTest {

	@Test
	public void configurationStrings() {
		assertFalse("Graphics path is not null", AAConfig.getGraphicsResource("") == null);
		assertFalse("Sound path is not null", AAConfig.getSoundResource("") == null);
		assertFalse("Properties file is readable", AAConfig.getLetterProps() == null);
	}
}
