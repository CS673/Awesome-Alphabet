package edu.bu.cs673.AwesomeAlphabet.controller;
import edu.bu.cs673.AwesomeAlphabet.model.PageName;
import edu.bu.cs673.AwesomeAlphabet.view.IPageObserver;


/**
 * This class defines the Page Controller.  It is the abstract
 * parent class of all page controller classes, including
 * AlphabetPageController, LetterPageController, etc.
 * It manages a Page Observer so that page transitions may
 * be requested.
 */
public abstract class PageController {

	private IPageObserver m_pageObserver;
	
	
	/**
	 * Class constructor.
	 * 
	 * @param pageObserver   A page observer reference so that page
	 *                       transitions may be requested.  For example,
	 *                       this may refer to the main window.
	 */
	public PageController(IPageObserver pageObserver) {
		
		m_pageObserver = pageObserver;
	}
	
	
	/**
	 * Commands a page to be shown.
	 * 
	 * @param page   The name of the page.
	 * @return       True if page is able to be shown.
	 */
	protected boolean GoToPage(PageName page)
	{
		return m_pageObserver.GoToPage(page.toString());
	}
}
