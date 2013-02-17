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
		AlphabetPageView alphabetPageView = new AlphabetPageView(PageName.AphabetPage.toString());
		LetterPageView letterPageView = new LetterPageView(PageName.LetterPage.toString());
		
		//Create Controllers
		new TitlePageController(mainWindow, titlePageView);
		new AlphabetPageController(mainWindow, alphabetPageView, alphabet);
		new LetterPageController(mainWindow, letterPageView, alphabet);
		
		//Setup and Show Main Window
		LinkedList<PageView> pageViewList = new LinkedList<PageView>();
		pageViewList.add(titlePageView);
		pageViewList.add(alphabetPageView);
		pageViewList.add(letterPageView);
		
		mainWindow.SetPages(pageViewList);
		mainWindow.GoToPage(PageName.TitlePage.toString());
		mainWindow.Show();
	}
}
