package edu.bu.cs673.AwesomeAlphabet.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.log4j.Logger;

import edu.bu.cs673.AwesomeAlphabet.main.AwesomeAlphabetApp;

public class SQLiteTest {
	static Logger log = Logger.getLogger(AwesomeAlphabetApp.class);
	private static Connection con;
	 
	// http://www.ehow.com/how_8461584_sqlite-java-tutorial.html
	public void InitializeDataBase() throws Exception {
	 
	  // SQLite Driver
	  // Direct Java to the JAR code with the following syntax: "Class.forName("org.sqlite.JDBC");" 
	  // at the beginning of your main function. load the driver somewhere.
	  Class.forName("org.sqlite.JDBC");
	  
	  // database PATH, if it's new database, then it will be created in the project folder
	  // Create a connection to the SQLite database : AwesomeAlphabet.db is the target
	  //con = DriverManager.getConnection("jdbc:sqlite:mydb.db");
	  con = DriverManager.getConnection("jdbc:sqlite:AwesomeAlphabet.db");
	  
	  // Drop the table if its open earlier
	  Statement stat = SQLiteDropTable();
	 
	  stat = SQLiteCreateTables();

	  //SQLiteGetDataFromTheameTable(stat);
	}

	public void runTest() throws Exception {
		Statement theme_stat = con.createStatement();
		Statement word_stat  = con.createStatement();
		
		SQLiteGetDataFromTheameTable(theme_stat);
	}
	
	public void SQLiteGetDataFromTheameTable(Statement stat) throws SQLException {
		  // Get Data from Theame Table
		  ResultSet res = stat.executeQuery("select * from themeTable");
		  while (res.next()) {
		     System.out.println("id:" + res.getString("id") + " " + "Theme Name:" + res.getString("ThemeName") 
		    		  + " " + "Theme Id:" + res.getString("ThemeId"));
		  }
	}

	public void SQLiteInsertDefaultData() throws SQLException {
		// Insert Data into theameTable
		PreparedStatement prep = con.prepareStatement("insert into themeTable values(?,?,?);");
		prep.setString(1, "1");
		prep.setString(2, "Default-Theme");
		prep.setString(3, "0");
		prep.execute();
	}

	public Statement SQLiteCreateTables() throws SQLException {
		// My statement for Awesome-Alphabet
		  Statement stat = con.createStatement();
		  
		  // Create New tables		  
		  stat.executeUpdate("create table themeTable(id INT," +  "ThemeName carchar(80)," + "ThemeId INT," + "primary key (ThemeName));");
		  
		  stat.executeUpdate("create table wordTable(id INT," + "words varchar(45)," + "ThemeId INT," + "SoundPath varchar(80),"
                  + "PicturePath carchar(80)," + "alphabet carchar(1)," + "primary key (words));");
		  
		return stat;
	}

	public Statement SQLiteDropTable() throws SQLException {
		// My statement for Awesome-Alphabet
		Statement stat = con.createStatement();

		stat.executeUpdate("drop table if exists themeTable");
		stat.executeUpdate("drop table if exists wordTable");
		
		return stat;
	}
}
