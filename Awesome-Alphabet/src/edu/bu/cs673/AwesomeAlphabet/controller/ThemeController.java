package edu.bu.cs673.AwesomeAlphabet.controller;

import java.util.Iterator;
import java.util.LinkedList;

import edu.bu.cs673.AwesomeAlphabet.model.PageName;
import edu.bu.cs673.AwesomeAlphabet.model.Theme;
import edu.bu.cs673.AwesomeAlphabet.model.ThemeManager;
import edu.bu.cs673.AwesomeAlphabet.value.ThemeViewData;
import edu.bu.cs673.AwesomeAlphabet.view.IPageObserver;
import edu.bu.cs673.AwesomeAlphabet.view.IThemeControllerView;

/**
 * This class defines the Themes Page Controller.
 */
public class ThemeController extends PageController {

	
	private IThemeControllerView m_view;
	private ThemeManager m_themeMgr;
	
	/**
	 * Constructor
	 * 
	 * @param pageObserver   A page observer reference so that page
	 *                       transitions may be requested.  For example,
	 *                       this may refer to the main window.
	 * @param view           The view.
	 * @param themeMgr       The Theme Manager.
	 */
	public ThemeController(IPageObserver pageObserver, IThemeControllerView view,
			               ThemeManager themeMgr) 
	{
		super(pageObserver);

		m_view = view;
		m_themeMgr = themeMgr;
		
		themeMgr.addObserver(m_view);
	}


	/**
	 * Gets a theme name iterator.
	 * 
	 * @return  A theme name iterator.
	 */
	public Iterator<ThemeViewData> getThemeNamesIterator()
	{
		Iterator<Theme> themes = m_themeMgr.getIterator();
		LinkedList<ThemeViewData> themeNames = new LinkedList<ThemeViewData>();
		
		while(themes.hasNext())
		{
			Theme theme = themes.next();
			themeNames.add(new ThemeViewData(theme.getThemeName(), theme.isEditable(), theme.getCount()));
		}
		
		return themeNames.iterator();
	}
	
	
	
	/**
	 * Adds a new theme.
	 * 
	 * @param themeName   The name of the theme.
	 * @return            True if theme was added.  False if theme already exists or other error.
	 */
	public boolean addTheme(String themeName)
	{
		if(m_themeMgr.hasTheme(themeName))
			return false;
					
		return m_themeMgr.addTheme(themeName);
	}
	
	
	
	/**
	 * Adds a new theme.
	 * 
	 * @param themeName   The name of the theme.
	 * @return            True if theme was added.  False if theme already exists or other error.
	 */
	public boolean deleteTheme(String themeName)
	{
		if (themeName.matches(Theme.DEFAULT_THEME_NAME) ||
				themeName.matches(Theme.ALL_THEMES))
			return false;
		
		if(m_themeMgr.hasTheme(themeName) == false)
			return false;
			
		return m_themeMgr.deleteTheme(themeName);
	}
	
	
	
	/**
	 * Changes the name of a theme.
	 * 
	 * @param oldThemeName   Old theme name.
	 * @param newThemeName   New theme name.
	 * @return               True if theme name was changed.
	 */
	public boolean changeThemeName(String oldThemeName, String newThemeName)
	{
		return m_themeMgr.changeThemeName(oldThemeName, newThemeName);
	}
	
	
	
	/**
	 * Sets the current theme.
	 * 
	 * @param themeName  The theme name.
	 * @return  True if current theme was set; false otherwise.
	 *          This function will return false if themeName does
	 *          not specify an existing theme and is not null.
	 */
	public boolean setCurrentTheme(String themeName)
	{
		return m_themeMgr.setCurrentTheme(themeName);
	}

	/**
	 * Finds the current theme.
	 * 
	 * @return	The name of the current theme, or a string indicating that no theme is currently active.
	 */
	public String getCurrentTheme() {
		Theme t = m_themeMgr.getCurrentTheme();
		if (t == null)
			return "No theme selected.";
		return t.getThemeName();
	}

	public void GoToOptionsPage() {
		GoToPage(PageName.OptionsPage);
	}
}
