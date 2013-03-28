package edu.bu.cs673.AwesomeAlphabet.controller;

import java.util.Iterator;

import edu.bu.cs673.AwesomeAlphabet.model.PageName;
import edu.bu.cs673.AwesomeAlphabet.view.IPageObserver;
import edu.bu.cs673.AwesomeAlphabet.view.WPSView;
import edu.bu.cs673.AwesomeAlphabet.model.Alphabet;;

public class WPSController extends PageController {

	private WPSView m_view;
	private Alphabet m_model;
	
	public WPSController(IPageObserver pageObserver, WPSView wpsView , Alphabet model) {
		super(pageObserver);
		m_view = wpsView;
		m_model = model;
	}
	
	public Iterator<String> getWords() {
		// TODO: model.getWords(); convert to list of strings; return iterator
		return m_model.GetWordCacheIterator();
	}

	public void GoToOptionsMenu() {
		GoToPage(PageName.OptionsPage);
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

	public void SubstringSearch(String newText) {
		// TODO: Iterator<String> i = model.searchForWords(newText);
		Iterator<String> i = null;
		m_view.updateWordList(i);
	}

}
