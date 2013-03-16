package edu.bu.cs673.AwesomeAlphabet.test;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Test;

import edu.bu.cs673.AwesomeAlphabet.model.Theme;
import edu.bu.cs673.AwesomeAlphabet.model.ThemeManager;

public class ThemeManagerTest {
	
	
	/**
	 * Tests getIterator method in ThemeManager class.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetIterator()
		throws Exception
	{
		ThemeManager themeMgr = new ThemeManager();
		assertNotNull(themeMgr.getIterator());
	}
	
	
	/**
	 * Tests getTheme method in ThemeManager class.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetTheme()
		throws Exception
	{
		ThemeManager themeMgr = new ThemeManager();
		String themeName = "Animals";
		
		assertTrue(themeMgr.addTheme(themeName));
		assertNotNull(themeMgr.getTheme(themeName));
	}
	
	
	/**
	 * Tests hasTheme method in ThemeManager class.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testHasTheme()
		throws Exception
	{
		String themeName = "Colors";
		ThemeManager themeMgr = new ThemeManager();
		
		assertTrue(themeMgr.addTheme(themeName));
		assertTrue(themeMgr.hasTheme(themeName));
	}
	
	
	/**
	 * Tests addTheme method in ThemeManager class.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testAddTheme()
		throws Exception
	{
		String themeName = "Transportation";
		ThemeManager themeMgr = new ThemeManager();
		Iterator<Theme> themeIterator;
		Theme theme;
		int iThemeCount;
		
		//Add the theme
		assertTrue(themeMgr.addTheme(themeName));
		
		//Verify that theme was added one time
		iThemeCount = 0;
		themeIterator = themeMgr.getIterator();
		while(themeIterator.hasNext())
		{
			theme = themeIterator.next();
			if(theme.getThemeName() == themeName)
				iThemeCount++;
		}
		if(iThemeCount != 1)
			fail("Failed to add theme."); //Error adding theme
		
		//Verify that re-adding theme has no effect
		assertTrue(themeMgr.addTheme(themeName));
		iThemeCount = 0;
		themeIterator = themeMgr.getIterator();
		while(themeIterator.hasNext())
		{
			theme = themeIterator.next();
			if(theme.getThemeName() == themeName)
				iThemeCount++;
		}
		if(iThemeCount != 1)
			fail("Incorrect theme Count (" + iThemeCount + ")."); //Incorrect theme count
	}
	
	
	/**
	 * Tests deleteTheme method in ThemeManager class.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testDeleteTheme()
		throws Exception
	{
		String themeName = "Vehicles";
		ThemeManager themeMgr = new ThemeManager();
		
		assertTrue(themeMgr.addTheme(themeName));
		assertTrue(themeMgr.hasTheme(themeName));
		assertTrue(themeMgr.deleteTheme(themeName));
		assertFalse(themeMgr.hasTheme(themeName));
	}
	
	
	/**
	 * Tests changeThemeName method in ThemeManager class.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testChangeThemeName()
		throws Exception
	{
		String oldThemeName = "Cats";
		String newThemeName = "Animals";
		ThemeManager themeMgr = new ThemeManager();
		
		//Add "old" theme
		assertTrue(themeMgr.addTheme(oldThemeName));
		
		//Verify that only "old" theme name exists
		assertTrue(themeMgr.hasTheme(oldThemeName));
		assertFalse(themeMgr.hasTheme(newThemeName));
		
		//Change "old" theme name to "new" theme
		assertTrue(themeMgr.changeThemeName(oldThemeName, newThemeName));
		
		//Verify that only "new" theme name exists
		assertFalse(themeMgr.hasTheme(oldThemeName));
		assertTrue(themeMgr.hasTheme(newThemeName));
		
		//Verify that we cannot change the name of theme that does not exist
		assertFalse(themeMgr.changeThemeName("Cars", "Transportation"));
	}
	
	
	/**
	 * Tests setCurrentTheme and getCurrentTheme methods
	 * in ThemeManager class.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testSetAndGetCurrentTheme()
		throws Exception
	{
		String themeName1 = "Transportation";
		String themeName2 = "Animals";
		ThemeManager themeMgr = new ThemeManager();
		
		//Add the themes
		assertTrue(themeMgr.addTheme(themeName1));
		assertTrue(themeMgr.addTheme(themeName2));
		
		//Verify that themes have been added
		assertTrue(themeMgr.hasTheme(themeName1));
		assertTrue(themeMgr.hasTheme(themeName2));
		
		//Set the current theme to theme #1
		assertTrue(themeMgr.setCurrentTheme(themeName1));
		
		//Verify that theme is properly set
		assertEquals(themeMgr.getCurrentTheme().getThemeName(), themeName1);
		
		//Set the current theme to theme #2
		assertTrue(themeMgr.setCurrentTheme(themeName2));
		
		//Verify that theme is properly set
		assertEquals(themeMgr.getCurrentTheme().getThemeName(), themeName2);	
	}
}
