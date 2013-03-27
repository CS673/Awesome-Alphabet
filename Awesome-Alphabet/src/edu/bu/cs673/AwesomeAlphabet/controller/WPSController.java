package edu.bu.cs673.AwesomeAlphabet.controller;

import java.util.Iterator;

import edu.bu.cs673.AwesomeAlphabet.model.PageName;
import edu.bu.cs673.AwesomeAlphabet.view.IPageObserver;
import edu.bu.cs673.AwesomeAlphabet.view.WPSView;

public class WPSController extends PageController {

	private WPSView m_view;
	// TODO: private Model m_model;
	
	public WPSController(IPageObserver pageObserver, WPSView wpsView /*, Model model */) {
		super(pageObserver);
		m_view = wpsView;
		// TODO: m_model = model;
	}
	
	public Iterator<String> getWords() {
		// TODO: model.getWords(); convert to list of strings; return iterator
		return null;
	}

	public void GoToMainMenu() {
		GoToPage(PageName.TitlePage);
	}

	public void CreateNewWord() {
		// TODO: model.getReadyToCreateNewWord()
		GoToPage(PageName.WordEditPage);
	}

	public void EditWord(String word) {
		// TODO: model.selectWordToEdit(word);
		GoToPage(PageName.WordEditPage);
	}

	public void DeleteWord(String word) {
		// TODO: model.deleteWord(word);
	}

}
