package edu.bu.cs673.AwesomeAlphabet.controller;

import java.util.Iterator;
import java.util.LinkedList;

import edu.bu.cs673.AwesomeAlphabet.model.PageName;
import edu.bu.cs673.AwesomeAlphabet.model.Theme;
import edu.bu.cs673.AwesomeAlphabet.model.ThemeManager;
import edu.bu.cs673.AwesomeAlphabet.view.IPageObserver;
import edu.bu.cs673.AwesomeAlphabet.view.WordEditView;

public class WordEditController extends PageController {

	WordEditView m_view;
	ThemeManager m_themeMgr;
	// TODO: Model m_model;
	
	public WordEditController(IPageObserver pageObserver, WordEditView view, ThemeManager themeMgr /*, Model model */) {
		super(pageObserver);
		
		m_view = view;
		m_themeMgr = themeMgr;
		// TODO: m_model = model;
	}

	public Iterator<String> getThemeNamesIterator() {
		Iterator<Theme> themes = m_themeMgr.getIterator();
		LinkedList<String> themeNames = new LinkedList<String>();
		Theme theme;
		
		while(themes.hasNext())
		{
			theme = themes.next();
			themeNames.add(theme.getThemeName());
		}
		
		return themeNames.iterator();
	}

	public void CancelEditWord() {
		// TODO: m_model.rollback();
		GoToPage(PageName.WPSPage);
	}
	
	public void SaveEditWord() {
		// TODO: m_model.commit();
		GoToPage(PageName.WPSPage);
	}
}
