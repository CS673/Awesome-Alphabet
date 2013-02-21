package edu.bu.cs673.AwesomeAlphabet.controller;
import edu.bu.cs673.AwesomeAlphabet.model.IPageObserver;
import edu.bu.cs673.AwesomeAlphabet.model.PageName;


public abstract class PageController {

	private IPageObserver m_pageObserver;
	
	
	public PageController(IPageObserver pageObserver) {
		
		m_pageObserver = pageObserver;
	}
	
	protected boolean GoToPage(PageName page)
	{
		return m_pageObserver.GoToPage(page.toString());
	}
}
