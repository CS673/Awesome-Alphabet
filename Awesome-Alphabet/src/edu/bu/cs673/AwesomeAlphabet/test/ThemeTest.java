package edu.bu.cs673.AwesomeAlphabet.test;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.bu.cs673.AwesomeAlphabet.model.Theme;

public class ThemeTest {

	/**
	 * Tests getThemeName method in Theme class.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetThemeName()
		throws Exception
	{
		String themeName = "Animals";
		Theme theme = new Theme(themeName);
		assertEquals(themeName, theme.getThemeName());
	}
	
	
	/**
	 * Tests changeThemeName method in Theme class.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testChangeThemeName()
		throws Exception
	{
		String oldThemeName = "Dogs";
		String newThemeName = "Animals";
		
		Theme theme = new Theme(oldThemeName);
		assertEquals(oldThemeName, theme.getThemeName());
		assertTrue(theme.changeThemeName(newThemeName));
		assertEquals(newThemeName, theme.getThemeName());
	}
}
