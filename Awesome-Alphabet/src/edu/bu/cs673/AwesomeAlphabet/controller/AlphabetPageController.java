package edu.bu.cs673.AwesomeAlphabet.controller;
import java.util.Iterator;

import edu.bu.cs673.AwesomeAlphabet.model.Alphabet;
import edu.bu.cs673.AwesomeAlphabet.model.IPageObserver;
import edu.bu.cs673.AwesomeAlphabet.model.Letter;
import edu.bu.cs673.AwesomeAlphabet.model.PageName;
import edu.bu.cs673.AwesomeAlphabet.view.AlphabetPageView;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;


/**
 * This class defines the Alphabet Page Controller.
 */
public class AlphabetPageController extends PageController {

	private AlphabetPageView m_view;
	private Alphabet m_alphabet;
	
	
	/**
	 * Class constructor.
	 * 
	 * @param pageObserver   A page observer reference so that page
	 *                       transitions may be requested.  For example,
	 *                       this may refer to the main window.
	 * @param view           The view.
	 * @param alphabet       The Alphabet model.
	 */
	public AlphabetPageController(IPageObserver pageObserver, AlphabetPageView view, Alphabet alphabet) {
		super(pageObserver);

		m_view = view;
		m_alphabet = alphabet;
		
		m_view.SetController(this);
	}
	
	
	/**
	 * Gets a Letter iterator from the Alphabet model.
	 * 
	 * @return   Letter Iterator.
	 */
	public Iterator<Letter> GetLetterIterator()
	{
		return m_alphabet.GetIterator();
	}
	
	
	/**
	 * Plays the alphabet song.
	 * 
	 * @return   True if song was played successfully.
	 */
	public boolean PlayAlphabetSong()
	{
		//TODO: Implement this method
		throw new NotImplementedException();
	}
	
	
	/**
	 * Causes the Title Page to be shown.
	 * 
	 * @return   True if Title Page is able to be shown.
	 */
	public boolean GoToTitlePage()
	{
		return GoToPage(PageName.TitlePage);
	}
	
	
	/**
	 * Causes the Letter Page to be shown.
	 * 
	 * @param cLetter   The letter to be shown on the Letter Page.
	 * @return          True if Letter Page is able to be shown.
	 */
	public boolean GoToLetterPage(Letter cLetter)
	{
		if (m_alphabet.SetCurrentLetter(cLetter) != null)
			return GoToPage(PageName.LetterPage);
		else
			return false;
	}
}
