package edu.bu.cs673.AwesomeAlphabet.model;

import java.util.Iterator;

/**
 * This class defines the interface to the database.
 * It uses the singleton pattern.
 *
 */
public class Database {

	private static Database m_db = null;
	
	
	
	static Database getDatabaseInstance()
	{
		if(m_db == null)
			m_db = new Database();
		return m_db;
	}
	
	
	
	private Database()
	{
		
	}
	
	public boolean addTheme(String themeName)
	{
		return false;
	}
	
	public boolean deleteTheme(String themeName)
	{
		return false;
	}
	
	public boolean changeThemeName(String oldThemeName, String newThemeName)
	{
		return false;
	}
	
	public Iterator<String> getThemes()
	{
		return null;
	}
	
	public boolean hasTheme(String themeName)
	{
		return false;
	}
}
