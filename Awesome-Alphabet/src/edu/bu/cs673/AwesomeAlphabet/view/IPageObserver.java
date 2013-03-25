package edu.bu.cs673.AwesomeAlphabet.view;


/**
 *  This interface defines a Page Observer.  It is used 
 *  to to help manage page transitions without requiring
 *  classes to have knowledge of the user interface.
 */
public interface IPageObserver {
	
	
	/**
	 * Commands a page to be shown.
	 * 
	 * @param sPageName   The name of the page.
	 * @return            True if page is able to be shown.
	 */
	public boolean GoToPage(String sPageName);
	
}
