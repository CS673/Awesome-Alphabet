
package edu.bu.cs673.AwesomeAlphabet.main;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

import edu.bu.cs673.AwesomeAlphabet.controller.AlphabetPageController;
import edu.bu.cs673.AwesomeAlphabet.controller.LetterPageController;
import edu.bu.cs673.AwesomeAlphabet.controller.OptionsPageController;
import edu.bu.cs673.AwesomeAlphabet.controller.SettingController;
import edu.bu.cs673.AwesomeAlphabet.controller.ThemeController;
import edu.bu.cs673.AwesomeAlphabet.controller.TitlePageController;
import edu.bu.cs673.AwesomeAlphabet.controller.WPSController;
import edu.bu.cs673.AwesomeAlphabet.controller.WordEditController;
import edu.bu.cs673.AwesomeAlphabet.model.Alphabet;
import edu.bu.cs673.AwesomeAlphabet.model.PageName;
import edu.bu.cs673.AwesomeAlphabet.model.ThemeManager;
import edu.bu.cs673.AwesomeAlphabet.view.AlphabetPageView;
import edu.bu.cs673.AwesomeAlphabet.view.LetterPageView;
import edu.bu.cs673.AwesomeAlphabet.view.MainWindow;
import edu.bu.cs673.AwesomeAlphabet.view.OptionsPageView;
import edu.bu.cs673.AwesomeAlphabet.view.SettingPageView;
import edu.bu.cs673.AwesomeAlphabet.view.ThemePageView;
import edu.bu.cs673.AwesomeAlphabet.view.TitlePageView;
import edu.bu.cs673.AwesomeAlphabet.view.WPSView;
import edu.bu.cs673.AwesomeAlphabet.view.WordEditView;

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
		try {
		    for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
		        if ("Nimbus".equals(info.getName())) {
		            UIManager.setLookAndFeel(info.getClassName());
		            break;
		        }
		    }
		} catch (Exception e) {
		    e.printStackTrace();
		}
		
		BasicConfigurator.configure();
		String workingDir = System.getProperty("user.dir");
		log.info("CWD is:" + workingDir);
		
		MainWindow mainWindow = new MainWindow();
		
		log.info("Creating the Models");
		ThemeManager themeMgr = new ThemeManager();
		Alphabet alphabet = new Alphabet(themeMgr);
		
		log.info("Creating the views");
		TitlePageView titlePageView = new TitlePageView(PageName.TitlePage.toString());
		AlphabetPageView alphabetPageView = new AlphabetPageView(PageName.AlphabetPage.toString());
		LetterPageView letterPageView = new LetterPageView(PageName.LetterPage.toString());
		OptionsPageView optionsPageView = new OptionsPageView(PageName.OptionsPage.toString());
		ThemePageView themePageView = new ThemePageView(PageName.ThemePage.toString());
		SettingPageView settingPageView = new SettingPageView(PageName.SettingPage.toString());
		WPSView wpsView = new WPSView(PageName.WPSPage.toString());
		WordEditView wordEditView = new WordEditView(PageName.WordEditPage.toString());
		
		log.info("Creating the controllers");
		titlePageView.SetController(new TitlePageController(mainWindow, titlePageView));
		alphabetPageView.SetController(new AlphabetPageController(mainWindow, alphabet));
		letterPageView.SetController(new LetterPageController(mainWindow, letterPageView, alphabet));
		optionsPageView.SetController(new OptionsPageController(mainWindow, optionsPageView));
		themePageView.SetController(new ThemeController(mainWindow, themePageView, themeMgr));
		wpsView.SetController(new WPSController(mainWindow, wpsView, alphabet));
		wordEditView.SetController(new WordEditController(mainWindow, wordEditView, themeMgr, alphabet));
		settingPageView.SetController(new SettingController(alphabet, mainWindow));
		
		log.info("Registering views with the main controlling window"); 
		mainWindow.registerPage(titlePageView);
		mainWindow.registerPage(alphabetPageView);
		mainWindow.registerPage(letterPageView);
		mainWindow.registerPage(optionsPageView);
		mainWindow.registerPage(themePageView);
		mainWindow.registerPage(wpsView);
		mainWindow.registerPage(wordEditView);
		mainWindow.registerPage(settingPageView);
		
		log.info("Processing the resource file");
		alphabet.LoadResources(AAConfig.getLetterProps());
		
		mainWindow.GoToPage(PageName.TitlePage.toString());
		mainWindow.Show();
	}
}
