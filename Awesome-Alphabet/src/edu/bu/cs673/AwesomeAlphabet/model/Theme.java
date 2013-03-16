package edu.bu.cs673.AwesomeAlphabet.model;

import java.util.Observable;

public class Theme extends Observable {

	
	private String m_themeName;
	
	
	/**
	 * Constructor
	 * 
	 * @param themeName  Theme Name
	 */
	public Theme(String themeName)
	{
		m_themeName = themeName;
	}
	
	
	/**
	 * Gets the theme name.
	 * 
	 * @return  The theme name.
	 */
	public String getThemeName()
	{
		return m_themeName;
	}
	
	
	/**
	 * Changes the theme name.
	 * 
	 * @param newThemeName  The new theme name.
	 * @return              True if theme name was changed.
	 */
	public boolean changeThemeName(String newThemeName)
	{
		m_themeName = newThemeName;
		setChanged();
		notifyObservers();
		return true;
	}
}
