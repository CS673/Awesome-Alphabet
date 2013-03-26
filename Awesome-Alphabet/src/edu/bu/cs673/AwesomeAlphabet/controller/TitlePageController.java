package edu.bu.cs673.AwesomeAlphabet.controller;
import edu.bu.cs673.AwesomeAlphabet.model.PageName;
import edu.bu.cs673.AwesomeAlphabet.view.IPageObserver;
import edu.bu.cs673.AwesomeAlphabet.view.TitlePageView;


/**
 * This class defines the Title Page Controller.
 */
public class TitlePageController extends PageController {

	private TitlePageView m_view;
	
	
	/**
	 * Class constructor.
	 * 
	 * @param pageObserver   A page observer reference so that page
	 *                       transitions may be requested.  For example,
	 *                       this may refer to the main window.
	 * @param view           The view.
	 */
	public TitlePageController(IPageObserver pageObserver, TitlePageView view) {
		super(pageObserver);

		m_view = view;
	}
	
	
	/**
	 * This method is used to notify the controller that the
	 * Start button was clicked.  This will cause the Alphabet
	 * Page to be shown.
	 * 
	 * @return   True if Alphabet Page is able to be shown.
	 */
	public boolean Start()
	{
		return GoToPage(PageName.AlphabetPage);
	}


	public boolean Options() {
		return GoToPage(PageName.OptionsPage);
	}
}
