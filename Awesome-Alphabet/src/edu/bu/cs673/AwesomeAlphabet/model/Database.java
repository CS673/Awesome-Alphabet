package edu.bu.cs673.AwesomeAlphabet.model;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Struct;
import java.util.Collections;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Properties;

import org.apache.log4j.Logger;

/**
 * This class defines the interface to the database.
 * It uses the singleton pattern.
 *
 */
public class Database {

	private static Database m_db = null;
	protected static Logger log = Logger.getLogger(Database.class);
	
	private Connection m_con;
	private final int m_iDefThemeId = 0;
	
	
	
	/**
	 * This method returns the Database object.
	 * It is part of the singleton pattern.
	 * 
	 * @return The database object.
	 */
	public static Database getDatabaseInstance()
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
			  
			stat.executeUpdate("CREATE TABLE IF NOT EXISTS Word(" +
					           		"name TEXT PRIMARY KEY," + 
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
	
	
	
	// ***** Theme Table Functions *****
	
	
	
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
	
	
	
	/**
	 * Gets the theme ID based on the theme name.
	 * 
	 * @param themeName Theme Name
	 * @return >=0: Theme ID
	 *          <0:  Error querying database
	 */
	private int getThemeId(String themeName)
	{
		if(m_con == null)
			return -1;
		
		try
		{
			PreparedStatement prep = m_con.prepareStatement(
					"SELECT id FROM Theme WHERE name = ?;");
			prep.setString(1, themeName);

			ResultSet rs = prep.executeQuery();
			if(rs.next())
				return rs.getInt(1);
			else
				return -1;
		}
		catch(Exception ex)
		{
			return -1;
		}
	}
	
	
	
	/**
	 * Gets the theme name based on the theme ID.
	 * 
	 * @param themeID Theme ID
	 * @return The theme name or null if theme ID not found.
	 */
	private String getThemeName(int themeId)
	{
		if(m_con == null)
			return null;
		
		try
		{
			PreparedStatement prep = m_con.prepareStatement(
					"SELECT name FROM Theme WHERE id = ?;");
			prep.setInt(1, themeId);

			ResultSet rs = prep.executeQuery();
			if(rs.next())
				return rs.getString(1);
			else
				return null;
		}
		catch(Exception ex)
		{
			return null;
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
	
	
	
	//**** Word Table Functions *****
	
	
	
	/**
	 * Adds a Word entry to the database.
	 * 
	 * @param word The word.
	 * @param picturePath The picture path name.
	 * @param soundPath The sound path name
	 * @param letter The letter that the word is associated with.
	 * @param themeName The theme name. Must be a valid theme name.
	 * @return
	 */
	public boolean addWord(String wordName, String picturePath, String soundPath, char letter, String themeName)
	{
		int ret;
		
		log.info("addWord Called for:"+wordName);	
		
		if(m_con == null || wordName == "" || hasWord(wordName) == 1 || themeName == "" ||
		    letter < 'a' || letter > 'z')
		{
			return false;
		}
		
		try
		{
			int iThemeId = getThemeId(themeName);
			if(iThemeId < 0) {
				return false;
			}
			PreparedStatement prep = m_con.prepareStatement(
					"INSERT INTO Word (name, ThemeId, SoundPath, PicturePath, letter) " +
			        "VALUES (?,?,?,?,?);");
			prep.setString(1, wordName);
			prep.setInt(2, iThemeId);
			prep.setString(3, soundPath);
			prep.setString(4, picturePath);
			prep.setString(5, Character.toString(letter));
			
			ret = prep.executeUpdate();
			
			if (ret > 0)
				return true;
			else {
				log.error("prep.executeUpdate failed");
				return false;
			}
		}
		catch(Exception ex)
		{
			log.error("An exception occurred while adding word to database");
			log.error(ex.getMessage());
			ex.printStackTrace();
			return false;
		}
	}
	
	
	
	/**
	 * Deletes a word from the Word table
	 * 
	 * @param wordName Word Name
	 * @return True if word was deleted successfully; otherwise false.
	 */
	public boolean deleteWord(String wordName)
	{
		if(m_con == null)
			return false;
		
		try
		{
			PreparedStatement prep = m_con.prepareStatement(
					"DELETE FROM Word WHERE name = ?;");
			prep.setString(1, wordName);
			
			return prep.executeUpdate() > 0;
		}
		catch(Exception ex)
		{
			return false;
		}	
	}
	
	
	
	/**
	 * Changes the name of an existing word in the Word table.
	 * 
	 * @param oldWordName Old word name.
	 * @param newWordName New word name.
	 * @return True if word name was changed successfully; otherwise false.
	 */
	public boolean changeWordName(String oldWordName, String newWordName)
	{
		if(m_con == null || hasWord(newWordName) == 1)
			return false;
		
		try
		{
			PreparedStatement prep = m_con.prepareStatement(
					"UPDATE Word SET name = ? WHERE name = ?;");
			prep.setString(1, newWordName);
			prep.setString(2, oldWordName);
			
			return prep.executeUpdate() > 0;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	

	
	/**
	 * Modified all fields of an existing word
	 * @param oldWordName Old word name
	 * @param newWordName New word name. May be the same as the old word name
	 * @param picturePath The picture path name.
	 * @param soundPath The sound path name.
	 * @param letter The letter word is associated with.
	 * @param themeName The theme name.
	 * @return True if word data was changed successfully; otherwise false.
	 */
	public boolean changeWordData(String oldWordName, String newWordName, String picturePath,
			                      String soundPath, char letter, String themeName)
	{
		if(   m_con == null || oldWordName == "" || hasWord(oldWordName) == 0 || themeName == "" ||
		    letter < 'a' || letter > 'z' || (oldWordName != newWordName && hasWord(newWordName) == 1))
		{
			return false;
		}
		
		try
		{
			int iThemeId = getThemeId(themeName);
			if(iThemeId < 0)
				return false;
			
			PreparedStatement prep = m_con.prepareStatement(
					"UPDATE Word " +
			        "SET name = ?, ThemeId = ?, PicturePath = ?, SoundPath = ?, letter = ? " +
					"WHERE name = ?;");
			
			prep.setString(1, newWordName);
			prep.setInt(2, iThemeId);
			prep.setString(3, picturePath);
			prep.setString(4, soundPath);
			prep.setString(5, Character.toString(letter));
			prep.setString(6, oldWordName);
			
			return prep.executeUpdate() > 0;
		}
		catch(Exception ex)
		{
			return false;
		}
	}
	
	
	
	/**
	 * Checks if word exists in database
	 * 
	 * @param word The word.
	 * @return 1 = Word exists,
	 *         0 = Word does not exist,
	 *         -1 = Error querying database
	 */
	public int hasWord(String wordName)
	{
		if(m_con == null)
			return -1;
		
		try
		{
			PreparedStatement prep = m_con.prepareStatement(
					"SELECT name FROM Word WHERE name = '?';");
			prep.setString(1, wordName);

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
	
	
	
	/**
	 * Retrieves an iterator to a collection of word names
	 * that are stored in the database.
	 * 
	 * @return The iterator.
	 */
	public Iterator<String> getWordNames()
	{
		if(m_con == null)
			return null;
		
		try
		{
			LinkedList<String> list = new LinkedList<String>();
			PreparedStatement prep = m_con.prepareStatement(
					"SELECT name FROM Words;");
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
	 * Retrieves an iterator to a collection of row data retrieved
	 * form the Word table based on the specified letter.
	 * 
	 * @return The iterator.
	 */
	public Iterator<WordData> getWordData(char letter)
	{
		if(m_con == null)
			return null;
		
		try
		{
			LinkedList<WordData> list = new LinkedList<WordData>();
			PreparedStatement prep = m_con.prepareStatement(
					"SELECT name, ThemeId, SoundPath, PicturePath, letter FROM Words Where letter=?;");
			prep.setString(1, Character.toString(letter));
			ResultSet rs = prep.executeQuery();
			String themeName;
			
			while(rs.next())
			{
				themeName = getThemeName(rs.getInt(2));
				if(themeName != null)
				{
					list.add(new WordData(rs.getString(1),
							              rs.getString(3),
							              rs.getString(4),
							              rs.getString(5).charAt(0),
							              themeName));
				}
			}
			return list.iterator();
		}
		catch(Exception ex)
		{
			return null;
		}
	}
	
	
	
	/**
	 * Inner class that defines row data returned by
	 * Word query functions.
	 */
	public class WordData
	{
		public String word;
		public String picturePath;
		public String soundPath;
		public char letter;
		public String theme;
		
		public WordData(String word, String picturePath, String soundPath, char letter, String theme)
		{
			this.word = word;
			this.picturePath = picturePath;
			this.soundPath = soundPath;
			this.letter = letter;
			this.theme = theme;
		}
	}
}
