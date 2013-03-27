package edu.bu.cs673.AwesomeAlphabet.controller;

import edu.bu.cs673.AwesomeAlphabet.model.PageName;
import edu.bu.cs673.AwesomeAlphabet.view.IPageObserver;
import edu.bu.cs673.AwesomeAlphabet.view.OptionsPageView;

public class OptionsPageController extends PageController {

	OptionsPageView m_view;
	
	public OptionsPageController(IPageObserver pageObserver, OptionsPageView view) {
		super(pageObserver);
		
		m_view = view;
	}

	public void GoToTitlePage() {
		GoToPage(PageName.TitlePage);
	}

	public void GoToThemesPage() {
		GoToPage(PageName.ThemePage);
	}

	public void GoToWordEditPage() {
		GoToPage(PageName.WPSPage);
	}

}
