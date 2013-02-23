
package edu.bu.cs673.AwesomeAlphabet.main;
import org.apache.log4j.Logger;
import org.apache.log4j.BasicConfigurator;


import java.io.InputStream;
import java.util.Properties;

import edu.bu.cs673.AwesomeAlphabet.controller.LetterPageController;
import edu.bu.cs673.AwesomeAlphabet.controller.TitlePageController;
import edu.bu.cs673.AwesomeAlphabet.model.Alphabet;
import edu.bu.cs673.AwesomeAlphabet.controller.AlphabetPageController;
import edu.bu.cs673.AwesomeAlphabet.view.AlphabetPageView;
import edu.bu.cs673.AwesomeAlphabet.model.MainWindow;
import edu.bu.cs673.AwesomeAlphabet.model.PageName;
import edu.bu.cs673.AwesomeAlphabet.view.LetterPageView;
import edu.bu.cs673.AwesomeAlphabet.view.TitlePageView;


/**
 * This class contains the application's main() method.
 */
public class AwesomeAlphabetApp {

	static Logger log = Logger.getLogger(AwesomeAlphabetApp.class);
	
	/**
	 * Main entry point into the application.  It is responsible
	 * for creating the models, views, controllers, and main
	 * window.  In addition, it processes the resource file and
	 * causes the Title Page to be shown.
	 * 
	 * @param args 			Application arguments.
	 * @throws Exception 
	 */
	public static void main(String[] args)  {
		BasicConfigurator.configure();

		MainWindow mainWindow = new MainWindow();
		
		log.info("Creating the Models");
		Alphabet alphabet = new Alphabet();
		
		log.info("Creating the views");
		TitlePageView titlePageView = new TitlePageView(PageName.TitlePage.toString());
		AlphabetPageView alphabetPageView = new AlphabetPageView(PageName.AlphabetPage.toString());
		LetterPageView letterPageView = new LetterPageView(PageName.LetterPage.toString());
		
		log.info("Creating the controllers");
		titlePageView.SetController(new TitlePageController(mainWindow, titlePageView));
		alphabetPageView.SetController(new AlphabetPageController(mainWindow, alphabetPageView, alphabet));
		letterPageView.SetController(new LetterPageController(mainWindow, letterPageView, alphabet));
		
		log.info("Registering views with the main controlling window"); 
		mainWindow.registerPage(titlePageView);
		mainWindow.registerPage(alphabetPageView);
		mainWindow.registerPage(letterPageView);
		
		log.info("Processing the resource file");
		Properties prop = new Properties();
		ClassLoader loader = Thread.currentThread().getContextClassLoader();           
		InputStream stream = loader.getResourceAsStream("letter.properties");
		try {
			prop.load(stream);
			alphabet.LoadResources(prop);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		mainWindow.GoToPage(PageName.TitlePage.toString());
		mainWindow.Show();
	}
}
