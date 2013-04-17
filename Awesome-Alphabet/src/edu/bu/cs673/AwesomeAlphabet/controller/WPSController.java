package edu.bu.cs673.AwesomeAlphabet.controller;

import java.util.Iterator;

import edu.bu.cs673.AwesomeAlphabet.model.Alphabet;
import edu.bu.cs673.AwesomeAlphabet.model.PageName;
import edu.bu.cs673.AwesomeAlphabet.value.WPSViewData;
import edu.bu.cs673.AwesomeAlphabet.view.IPageObserver;
import edu.bu.cs673.AwesomeAlphabet.view.WPSView;

public class WPSController extends PageController {

	private WPSView m_view;
	private Alphabet m_model;
	
	public WPSController(IPageObserver pageObserver, WPSView wpsView , Alphabet model) {
		super(pageObserver);
		m_view = wpsView;
		m_model = model;
	}
	
	public Iterator<WPSViewData> getWords() {
		return m_model.getWords();
	}

	public void GoToOptionsMenu() {
		GoToPage(PageName.OptionsPage);
	}

	public void CreateNewWord() {
		// TODO: model.getReadyToCreateNewWord()
		GoToPage(PageName.WordEditPage);
	}

	public void EditWord(String word) {
		m_model.setCurrentWordEditing(word);
		GoToPage(PageName.WordEditPage);
	}

	public void DeleteWord(String word) {
		m_model.deleteWord(word);
	}

	public void SubstringSearch(String newText) {
		Iterator<WPSViewData> i = m_model.getWords(newText);
		m_view.updateWordList(i);
	}

}
