package edu.bu.cs673.AwesomeAlphabet.controller;

import java.util.Iterator;
import java.util.LinkedList;

import edu.bu.cs673.AwesomeAlphabet.model.Alphabet;
import edu.bu.cs673.AwesomeAlphabet.model.Database;
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
	private Alphabet m_alphabet;
	private Database m_db;
	
	/**
	 * Constructor
	 * 
	 * @param pageObserver   A page observer reference so that page
	 *                       transitions may be requested.  For example,
	 *                       this may refer to the main window.
	 * @param view           The view.
	 * @param themeMgr       The Theme Manager.
	 * @param alphabet       The alphabet.
	 */
	public ThemeController(IPageObserver pageObserver, IThemeControllerView view,
			               ThemeManager themeMgr, Alphabet alphabet) 
	{
		super(pageObserver);

		m_view = view;
		m_themeMgr = themeMgr;
		m_alphabet = alphabet;
		
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


	public void GoToOptionsPage() {
		GoToPage(PageName.OptionsPage);
	}
}
