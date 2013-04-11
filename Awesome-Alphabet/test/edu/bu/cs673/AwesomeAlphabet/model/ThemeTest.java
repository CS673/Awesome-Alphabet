package edu.bu.cs673.AwesomeAlphabet.model;

import static org.junit.Assert.*;
import org.junit.Test;

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
		String themeName = "UnitTest_Theme1";
		Theme theme = new Theme(themeName);
		assertEquals(theme.getThemeName().compareTo(themeName), 0);
	}
	
	
	
	/**
	 * Tests isEditable method in Theme class.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testIsEditable()
		throws Exception
	{
		Theme newTheme = new Theme("UnitTest_Theme1");
		Theme defTheme = new Theme(Theme.DEFAULT_THEME_NAME);
		Theme allTheme = new Theme(Theme.ALL_THEMES);
		
		assertTrue(newTheme.isEditable());
		assertFalse(defTheme.isEditable());
		assertFalse(allTheme.isEditable());
	}
	
	
	
	/**
	 * Tests incRefCount, decRefCount, and  getCount 
	 * methods in Theme class.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testRefCounts()
		throws Exception
	{
		Theme theme = new Theme("UnitTest_Theme1");
		
		assertEquals(theme.getCount(), 0);
		theme.incRefCount();
		theme.incRefCount();
		assertEquals(theme.getCount(), 2);
		theme.decRefCount();
		theme.decRefCount();
		assertEquals(theme.getCount(), 0);
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
		String oldThemeName = "UnitTest_ThemeChange1";
		String newThemeName = "UnitTest_ThemeChange2";
		Database db = Database.getDatabaseInstance();
		
		//Prepare Database
		if(db.hasTheme(oldThemeName) == 0)
			assertTrue(db.addTheme(oldThemeName));	
		if(db.hasTheme(newThemeName) == 1)
			assertTrue(db.deleteTheme(newThemeName));
		
		//Change Theme Name
		Theme theme = new Theme(oldThemeName);
		assertEquals(theme.getThemeName().compareTo(oldThemeName), 0);
		assertTrue(theme.changeThemeName(newThemeName));
		assertEquals(theme.getThemeName().compareTo(newThemeName), 0);
		
		//Cleanup Database
		assertTrue(db.deleteTheme(newThemeName));
		assertFalse(db.deleteTheme(oldThemeName));
	}
}
