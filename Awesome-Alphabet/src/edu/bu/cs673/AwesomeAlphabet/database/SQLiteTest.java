package edu.bu.cs673.AwesomeAlphabet.database;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import edu.bu.cs673.AwesomeAlphabet.main.AwesomeAlphabetApp;
import edu.bu.cs673.AwesomeAlphabet.main.AAConfig;

public class SQLiteTest {
	static Logger log = Logger.getLogger(AwesomeAlphabetApp.class);
	private static Connection con;
	 
	// http://www.ehow.com/how_8461584_sqlite-java-tutorial.html
	public void InitializeDataBase() throws Exception {
	 
	  // SQLite Driver
	  Class.forName("org.sqlite.JDBC");
	  
	  // database PATH, if it's new database, then it will be created in the project folder
	  // Create a connection to the SQLite database : AwesomeAlphabet.db is the target
	  con = DriverManager.getConnection("jdbc:sqlite:AwesomeAlphabet.db");
	  
	  // Drop the table if its open earlier
	  Statement stat = SQLiteDropTable();
	 
	  stat = SQLiteCreateTables();

	  //SQLiteGetDataFromThemeTable(stat);
	}

	public void runTest() throws Exception {
		Statement theme_stat = con.createStatement();
		Statement word_stat  = con.createStatement();
		
		SQLiteGetDataFromThemeTable(theme_stat);
		
		// wordtable operations
		SQLiteInsertRecordToWordTable();
		SQLiteGetDataFromWordTable(word_stat);
		SQLitedeleteDataFromWordTable(word_stat);
		SQLiteGetDataFromWordTable(word_stat);
	}
	
	public void SQLiteGetDataFromThemeTable(Statement stat) throws SQLException {
		  // Get Data from Theme Table
		  ResultSet res = stat.executeQuery("select * from themeTable");
		  while (res.next()) {
		     System.out.println("id:" + res.getString("id") + " " + "Theme Name:" + res.getString("ThemeName") 
		    		  + " " + "Theme Id:" + res.getString("ThemeId"));
		  }
	}
	
	public void SQLiteGetDataFromWordTable(Statement stat) throws SQLException {
		//System.out.println(" ========================   SQLiteGetDataFromWordTable ==================="); 
		  // Get Data from Word Table
		  ResultSet res = stat.executeQuery("select * from wordTable");

		  while (res.next()) {
		     System.out.println("id:" + res.getString("id") + " " 
		    		 		+ "words:" + res.getString("words") + " " 
		    		 		+ "Theme Id:" + res.getString("ThemeId") + " " 
		    		 		+ "SoundPath:" + res.getString("SoundPath") + " " 
		    		 		+ "PicturePath:" + res.getString("PicturePath") + " " 
		    		 		+ "alphabet:" + res.getString("alphabet"));
		  }
	}
	
	public void SQLitedeleteDataFromWordTable(Statement stat) throws SQLException {
		//System.out.println(" ========================   SQLitedeleteDataFromWordTable ==================="); 
		  // delete Data from Word Table
		PreparedStatement prep = con.prepareStatement("delete from wordTable where words = ?");
		prep.setString(1, "Apple");
	}

	// We need to have a default record in the Theme Table
	public void SQLiteInsertDefaultData() throws SQLException {
		// Insert Data into theameTable
		PreparedStatement prep = con.prepareStatement("insert into themeTable values(?,?,?);");
		prep.setString(1, "1");             // id
		prep.setString(2, "Default-Theme"); // ThemeName
		prep.setString(3, "0");             // ThemeId
		prep.execute();
	}
	
	public void SQLiteInsertRecordToWordTable() throws SQLException {
		// Todo Add this record for test.
		//System.out.println(" ========================   SQLiteInsertRecordToWordTable ==================="); 
		
		// Insert Data into wordTable
		PreparedStatement prep = con.prepareStatement("insert into wordTable values(?,?,?,?,?,?);");
		prep.setString(1, "1");                                 // id
		prep.setString(2, "Apple");                             // words
		prep.setString(3, "1");                                 // TheameId
		prep.setString(4, "/Somepath/to/sound/file");           // Sound Path
		prep.setString(5, "/Somepath/to/picture/file");         // Picture Path
		prep.setString(6, "a");                                 // Alphabet 
		prep.execute();   
	}

	public Statement SQLiteCreateTables() throws SQLException {
		DatabaseMetaData md = con.getMetaData();
		
		// My statement for Awesome-Alphabet
		  Statement stat = con.createStatement();
		  
		  // Create New tables		  
		  stat.executeUpdate("create table themeTable(id INT," +  "ThemeName carchar(80)," + "ThemeId INT," + "primary key (ThemeName));");
		  
		  stat.executeUpdate("create table wordTable(id INT," + "words varchar(45)," + "ThemeId INT," + "SoundPath varchar(80),"
                  + "PicturePath carchar(80)," + "alphabet carchar(1)," + "primary key (words));");
		  
		  // Test if the Tables are created successfully.
		  ResultSet rs = md.getTables(null, null, "%", null);
		  while (rs.next()) {
		    System.out.println(rs.getString(3));
		  }
		  
		return stat;
	}

	public Statement SQLiteDropTable() throws SQLException {
		// My statement for Awesome-Alphabet
		Statement stat = con.createStatement();

		stat.executeUpdate("drop table if exists themeTable");
		stat.executeUpdate("drop table if exists wordTable");
		
		return stat;
	}
	
	// This is a one time operation to load all the records into our database
	// Prepare the Theme table in the DB once.
	public Statement SQLitePopulatePreviousData(int id, char c, String words, String imageName, String soundName) throws SQLException{
		// My statement for Awesome-Alphabet
		Statement stat = con.createStatement();
		String idString = " " + id;
		String charString = "" + c;
		String soundNameWithPAth =  "edu/bu/cs673/AwesomeAlphabet/resources/Sounds" + soundName;
		String imageNameWithPath =  "edu/bu/cs673/AwesomeAlphabet/resources/Sounds" + imageName;
		String themeName = "defaul-theme" ;
		
		// edu/bu/cs673/AwesomeAlphabet/resources/Graphics - lion, monkey - picture path
		// edu/bu/cs673/AwesomeAlphabet/resources/Sounds
		//System.out.println(" ========================   SQLitePopulatePreviousData ==================="); 
		
		// Insert Data into wordTable
		PreparedStatement prep = con.prepareStatement("insert into wordTable values(?,?,?,?,?,?);");
		prep.setString(1, idString);                          // id
		prep.setString(2, words);                             // words
		prep.setString(3, idString);                          // TheameId
		prep.setString(4, soundNameWithPAth);                 // Sound Path
		prep.setString(5, imageNameWithPath);                 // Picture Path
		prep.setString(6, charString);                        // Alphabet 
		prep.execute();   
		
		//PreparedStatement theme_prep = con.prepareStatement("insert into themeTable values(?,?,?);");
		//theme_prep.setString(1, idString);             // id
		//theme_prep.setString(2, themeName);     // ThemeName
		//theme_prep.setString(3, idString);      // ThemeId
		//theme_prep.execute();
		
		//System.out.println(" ========================   SQLitePopulatePreviousData ===================");
		
		// Now retrieve a randomn record to confirm its all loaded.
		//Statement word_stat  = con.createStatement();
		//SQLiteGetDataFromWordTable(word_stat);
		
		
		return stat;
	}
}
