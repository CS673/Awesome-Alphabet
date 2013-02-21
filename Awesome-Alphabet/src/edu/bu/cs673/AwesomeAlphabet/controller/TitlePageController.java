package edu.bu.cs673.AwesomeAlphabet.controller;
import edu.bu.cs673.AwesomeAlphabet.model.IPageObserver;
import edu.bu.cs673.AwesomeAlphabet.model.PageName;
import edu.bu.cs673.AwesomeAlphabet.view.TitlePageView;


public class TitlePageController extends PageController {

	private TitlePageView m_view;
	
	
	public TitlePageController(IPageObserver pageObserver, TitlePageView view) {
		super(pageObserver);

		m_view = view;
		m_view.SetController(this);
	}
	
	public boolean Start()
	{
		return GoToPage(PageName.AlphabetPage);
	}
}
