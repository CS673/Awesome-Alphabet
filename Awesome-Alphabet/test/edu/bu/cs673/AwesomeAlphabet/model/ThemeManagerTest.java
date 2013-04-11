package edu.bu.cs673.AwesomeAlphabet.model;

import static org.junit.Assert.*;

import java.util.Iterator;
import org.junit.Test;


public class ThemeManagerTest {
	
	
	/**
	 * Tests ReloadThemesFromDatabase method in ThemeManager class.
	 * 
	 * @throws Exception
	 */
	@Test
	public void testReloadThemesFromDatabase()
		throws Exception
	{
		ThemeManager themeMgr = new ThemeManager();
		Database db = Database.getDatabaseInstance();
		String themeName = "UnitTest_TMReloadFromDB";
		
		
		//Delete theme from DB if it exists
		if(db.hasTheme(themeName) == 1)
			assertTrue(db.deleteTheme(themeName));
		
		//Reload theme manager and verify that theme does not exist
		assertTrue(themeMgr.ReloadThemesFromDatabase());
		assertFalse(themeMgr.hasTheme(themeName));
		
		//Add theme to DB, reload theme manager, and verify the theme exists
		assertTrue(db.addTheme(themeName));
		assertTrue(themeMgr.ReloadThemesFromDatabase());
		assertTrue(themeMgr.hasTheme(themeName));	
		
		//Remove theme from DB, reload theme manager, and Verify theme does not exist
		assertTrue(db.deleteTheme(themeName));
		assertTrue(themeMgr.ReloadThemesFromDatabase());
		assertFalse(themeMgr.hasTheme(themeName));	
	}
	
	
	
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
		Database db = Database.getDatabaseInstance();
		String themeName = "UnitTest_TMGetTheme";
		
		
		//Delete theme from DB if it exists
		if(db.hasTheme(themeName) == 1)
			assertTrue(db.deleteTheme(themeName));
		
		//Reload from DB and verify that theme does not exist (null is returned)
		assertTrue(themeMgr.ReloadThemesFromDatabase());
		assertNull(themeMgr.getTheme(themeName));
		
		//Add theme to database
		assertTrue(db.addTheme(themeName));
		
		//Reload from DB and verify that theme exists (valid reference is returned)
		assertTrue(themeMgr.ReloadThemesFromDatabase());
		assertNotNull(themeMgr.getTheme(themeName));
		
		//Remove theme from database
		assertTrue(db.deleteTheme(themeName));
		
		//Reload from DB and verify that theme does not exist (null is returned)
		assertTrue(themeMgr.ReloadThemesFromDatabase());
		assertNull(themeMgr.getTheme(themeName));
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
		ThemeManager themeMgr = new ThemeManager();
		Database db = Database.getDatabaseInstance();
		String themeName = "UnitTest_TMHasTheme";

		
		//Delete theme from DB if it exists
		if(db.hasTheme(themeName) == 1)
			assertTrue(db.deleteTheme(themeName));
		
		//Reload from DB and verify that theme does not exist
		assertTrue(themeMgr.ReloadThemesFromDatabase());
		assertFalse(themeMgr.hasTheme(themeName));
		
		//Add theme to database
		assertTrue(db.addTheme(themeName));
		
		//Reload from DB and verify that theme exists
		assertTrue(themeMgr.ReloadThemesFromDatabase());
		assertTrue(themeMgr.hasTheme(themeName));
		
		//Remove theme from database
		assertTrue(db.deleteTheme(themeName));
		
		//Reload from DB and verify that theme does not exist
		assertTrue(themeMgr.ReloadThemesFromDatabase());
		assertFalse(themeMgr.hasTheme(themeName));
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
		ThemeManager themeMgr = new ThemeManager();
		Database db = Database.getDatabaseInstance();
		String themeName = "UnitTest_TMAddTheme";
		Iterator<Theme> themeIterator;
		Theme theme;
		int iThemeCount;
		
		
		//Delete theme from DB if it exists
		if(db.hasTheme(themeName) == 1)
			assertTrue(db.deleteTheme(themeName));
		
		//Reload from DB and verify that theme does not exist
		assertTrue(themeMgr.ReloadThemesFromDatabase());
		assertFalse(themeMgr.hasTheme(themeName));
		
		
		//Add theme to Theme Manager and Database
		assertTrue(themeMgr.addTheme(themeName));
		
		//Verify that theme exists in both DB and Theme Manager
		assertEquals(db.hasTheme(themeName), 1);
		assertTrue(themeMgr.hasTheme(themeName));
		
		
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

		
		//Remove theme from database
		assertTrue(db.deleteTheme(themeName));
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
		ThemeManager themeMgr = new ThemeManager();
		Database db = Database.getDatabaseInstance();
		String themeName = "UnitTest_TMDeleteTheme";
		Iterator<Theme> themeIterator;
		Theme theme;
		int iThemeCount;
		
		
		//Add theme to DB if it does not exist
		if(db.hasTheme(themeName) == 0)
			assertTrue(db.addTheme(themeName));
		
		//Reload from DB and verify that theme exists
		assertTrue(themeMgr.ReloadThemesFromDatabase());
		assertTrue(themeMgr.hasTheme(themeName));
		
		
		//Delete theme from Theme Manager and Database
		assertTrue(themeMgr.deleteTheme(themeName));
		
		//Verify that theme does not exist in both DB and Theme Manager
		assertEquals(db.hasTheme(themeName), 0);
		assertFalse(themeMgr.hasTheme(themeName));
		
		
		//Verify that theme does not appear in theme list
		iThemeCount = 0;
		themeIterator = themeMgr.getIterator();
		while(themeIterator.hasNext())
		{
			theme = themeIterator.next();
			if(theme.getThemeName() == themeName)
				iThemeCount++;
		}
		if(iThemeCount != 0)
			fail("Failed to delete theme."); //Error deleting theme
		
		
		//Verify that re-deleting theme has no effect
		assertTrue(themeMgr.deleteTheme(themeName));
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
		ThemeManager themeMgr = new ThemeManager();
		Database db = Database.getDatabaseInstance();
		String oldThemeName = "UnitTest_TMChangeTheme1";
		String newThemeName = "UnitTest_TMChangeTheme2";
		
		
		//Prepare Database
		if(db.hasTheme(oldThemeName) == 0)
			assertTrue(db.addTheme(oldThemeName));	
		if(db.hasTheme(newThemeName) == 1)
			assertTrue(db.deleteTheme(newThemeName));
		
		//Reload from DB and verify that old theme exists
		//and new theme does not exist
		assertTrue(themeMgr.ReloadThemesFromDatabase());
		assertTrue(themeMgr.hasTheme(oldThemeName));
		assertFalse(themeMgr.hasTheme(newThemeName));
		assertEquals(db.hasTheme(oldThemeName), 1);
		assertEquals(db.hasTheme(newThemeName), 0);
		
		//Change Theme Name
		assertTrue(themeMgr.changeThemeName(oldThemeName, newThemeName));
		
		//Verify that new theme exists and old theme does not exist
		assertTrue(themeMgr.hasTheme(newThemeName));
		assertFalse(themeMgr.hasTheme(oldThemeName));
		assertEquals(db.hasTheme(newThemeName), 1);
		assertEquals(db.hasTheme(oldThemeName), 0);
		
		//Verify that we cannot change the name of a theme that does not exist
		assertFalse(themeMgr.changeThemeName(oldThemeName, newThemeName));
		assertTrue(themeMgr.hasTheme(newThemeName));
		assertFalse(themeMgr.hasTheme(oldThemeName));
		assertEquals(db.hasTheme(newThemeName), 1);
		assertEquals(db.hasTheme(oldThemeName), 0);
		
		//Cleanup Database
		assertTrue(db.deleteTheme(newThemeName));
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
		ThemeManager themeMgr = new ThemeManager();
		Database db = Database.getDatabaseInstance();
		String themeName1 = "UnitTest_TMSetTheme1";
		String themeName2 = "UnitTest_TMSetTheme2";
		String themeName3 = "UnitTest_TMSetTheme3";
		
		
		//Prepare Database
		if(db.hasTheme(themeName1) == 0)
			assertTrue(db.addTheme(themeName1));	
		if(db.hasTheme(themeName2) == 0)
			assertTrue(db.addTheme(themeName2));
		if(db.hasTheme(themeName3) == 1)
			assertTrue(db.deleteTheme(themeName3));
		
		//Reload from DB and verify that the appropriate themes exist
		assertTrue(themeMgr.ReloadThemesFromDatabase());
		assertTrue(themeMgr.hasTheme(themeName1));
		assertTrue(themeMgr.hasTheme(themeName2));
		assertFalse(themeMgr.hasTheme(themeName3));
		assertEquals(db.hasTheme(themeName1), 1);
		assertEquals(db.hasTheme(themeName2), 1);
		assertEquals(db.hasTheme(themeName3), 0);
		
		
		//Verify that current theme is set to null (No Theme) by default
		assertNull(themeMgr.getCurrentTheme());
		
		//Set the current theme to theme #1 and verify that it is properly set
		assertTrue(themeMgr.setCurrentTheme(themeName1));
		assertEquals(themeMgr.getCurrentTheme().getThemeName().compareTo(themeName1), 0);
		
		//Set the current theme to theme #2 and verify that it is properly set
		assertTrue(themeMgr.setCurrentTheme(themeName2));
		assertEquals(themeMgr.getCurrentTheme().getThemeName().compareTo(themeName2), 0);
		
		//Set the current theme to null (No Theme) and verify that it is properly set
		assertTrue(themeMgr.setCurrentTheme(null));
		assertNull(themeMgr.getCurrentTheme());
		
		//Verify that we cannot set the current theme to a non-existent theme
		assertFalse(themeMgr.setCurrentTheme(themeName3));
		assertNull(themeMgr.getCurrentTheme());
		
		
		//Cleanup Database
		assertTrue(db.deleteTheme(themeName1));
		assertTrue(db.deleteTheme(themeName2));
	}
}
