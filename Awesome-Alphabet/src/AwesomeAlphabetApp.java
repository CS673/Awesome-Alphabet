import java.util.LinkedList;


public class AwesomeAlphabetApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		MainWindow mainWindow = new MainWindow();
		
		//Create Models
		Alphabet alphabet = new Alphabet();
		
		//Create Views
		TitlePageView titlePageView = new TitlePageView(PageName.TitlePage.toString());
		AlphabetPageView alphabetPageView = new AlphabetPageView(PageName.AlphabetPage.toString());
		LetterPageView letterPageView = new LetterPageView(PageName.LetterPage.toString());
		
		//Create Controllers
		titlePageView.SetController(new TitlePageController(mainWindow, titlePageView));
		alphabetPageView.SetController(new AlphabetPageController(mainWindow, alphabetPageView, alphabet));
		letterPageView.SetController(new LetterPageController(mainWindow, letterPageView, alphabet));
		
		// Register views with main controlling window
		mainWindow.registerPage(titlePageView);
		mainWindow.registerPage(alphabetPageView);
		mainWindow.registerPage(letterPageView);
		
		mainWindow.GoToPage(PageName.TitlePage.toString());
		mainWindow.Show();
	}
}
