package edu.bu.cs673.AwesomeAlphabet.model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Collections;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.Properties;

/**
 * This class defines the interface to the database.
 * It uses the singleton pattern.
 *
 */
public class Database {

	private static Database m_db = null;
	
	private Connection m_con;
	private final int m_iDefThemeId = 0;
	
	
	
	/**
	 * This method returns the Database object.
	 * It is part of the singleton pattern.
	 * 
	 * @return The database object.
	 */
	static Database getDatabaseInstance()
	{
		if(m_db == null)
			m_db = new Database();
		return m_db;
	}
	
	
	
	/**
	 * Constructor.
	 */
	private Database()
	{
		initializeDatabase();
	}
	
	
	
	/**
	 * Initializes the database. As part of this, all tables and 
	 * default records are created if they do not already exist.
	 */
	private void initializeDatabase()
	{
		try
		{
			// SQLite Driver
			Class.forName("org.sqlite.JDBC");
			
			// database PATH, if it's new database, then it will be created in the project folder
			// Create a connection to the SQLite database : AwesomeAlphabet.db is the target
			m_con = DriverManager.getConnection("jdbc:sqlite:AwesomeAlphabet.db");
		}
		catch(Exception ex)
		{
			m_con = null;
		}
		
		createTables();
		createDefaultTheme();
	}
	
	
	
	/**
	 * Creates all tables in the database if they do not already exist.
	 */
	private void createTables()
	{
		if(m_con == null)
			return;
		try
		{
			Statement stat = m_con.createStatement();
			  
			// Create new tables if they do not already exist	  
			stat.executeUpdate("CREATE TABLE IF NOT EXISTS Theme(" +
							   		"id INTEGER PRIMARY KEY AUTOINCREMENT," +  
							   		"name TEXT UNIQUE);");
			  
			stat.executeUpdate("CREATE TABLE IF NOT EXISTS word(" +
					           		"Word TEXT PRIMARY KEY," + 
					                "ThemeId INTEGER DEFAULT 0," + 
					           		"SoundPath TEXT," +
					           		"PicturePath TEXT," + 
					           		"letter TEXT NOT NULL," +
					           		"CONSTRAINT Word_ThemeID_FK" +
					           		"  FOREIGN KEY (ThemeId) REFERENCES Theme(id) ON DELETE SET DEFAULT);");
		}
		catch(Exception ex)
		{
			//Do Nothing
		}
	}
	
	
	
	/**
	 * Creates the default theme record if it does not already exist.
	 */
	private void createDefaultTheme()
	{
		if(m_con == null)
			return;
		try
		{
			PreparedStatement prep = m_con.prepareStatement(
					"INSERT INTO Theme (id, name) VALUES (?,?);");
			prep.setInt(1,  m_iDefThemeId);
			prep.setString(2, Theme.DEFAULT_THEME_NAME);
			prep.executeUpdate();
		}
		catch(Exception ex)
		{
			//Do Nothing
		}	
	}
	
	
	
	/**
	 * Adds a theme to the database.
	 * 
	 * @param themeName The name of the theme.
	 * @return True if theme was added successfully; false otherwise.
	 */
	public boolean addTheme(String themeName)
	{
		if(m_con == null || hasTheme(themeName) != 0)
			return false;
		
		try
		{
			PreparedStatement prep = m_con.prepareStatement(
					"INSERT INTO Theme (name) VALUES (?);");
			prep.setString(1, themeName);
			
			return prep.executeUpdate() > 0;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	
	
	
	/**
	 * Deletes a theme from the database.
	 * 
	 * @param themeName The theme name.
	 * @return True if theme was successfully deleted; false otherwise.
	 */
	public boolean deleteTheme(String themeName)
	{
		if(m_con == null || hasTheme(themeName) != 1)
			return false;
		
		try
		{
			PreparedStatement prep = m_con.prepareStatement(
					"DELETE FROM Theme WHERE name = ?;");
			prep.setString(1, themeName);
			
			return prep.executeUpdate() > 0;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	
	
	
	/**
	 * Changes the name of the theme in the database.
	 * 
	 * @param oldThemeName Old theme name.
	 * @param newThemeName New theme name.
	 * @return True if theme name was changed successfully; otherwise false.
	 */
	public boolean changeThemeName(String oldThemeName, String newThemeName)
	{
		if(m_con == null || newThemeName == Theme.DEFAULT_THEME_NAME)
			return false;
		
		try
		{
			PreparedStatement prep = m_con.prepareStatement(
					"UPDATE Theme SET name = ? WHERE name = ?;");
			prep.setString(1, newThemeName);
			prep.setString(2, oldThemeName);
			
			return prep.executeUpdate() > 0;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	
	
	
	/**
	 * Retrieves an iterator to a collection of theme names
	 * that are stored in the database.
	 * 
	 * @return The iterator.
	 */
	public Iterator<String> getThemes()
	{
		if(m_con == null)
			return null;
		
		try
		{
			ArrayList<String> list = new ArrayList<String>();
			PreparedStatement prep = m_con.prepareStatement(
					"SELECT name FROM Theme;");
			ResultSet rs = prep.executeQuery();
			
			while(rs.next())
				list.add(rs.getString(1));
			Collections.sort(list, String.CASE_INSENSITIVE_ORDER);
			return list.iterator();
		}
		catch(Exception ex)
		{
			return null;
		}
	}
	
	
	
	/**
	 * Checks if theme exists in database.
	 * 
	 * @param themeName
	 * @return 1 = Theme exists,
	 *         0 = Theme does not exist,
	 *         -1 = Error querying database
	 */
	public int hasTheme(String themeName)
	{
		if(m_con == null)
			return -1;
		
		try
		{
			PreparedStatement prep = m_con.prepareStatement(
					"SELECT id FROM Theme WHERE name = ?;");
			prep.setString(1, themeName);

			ResultSet rs = prep.executeQuery();
			if(rs.next()) //check if number of rows returned is non-zero
				return 1;
			else
				return 0;
		}
		catch(Exception ex)
		{
			return -1;
		}
	}
}
