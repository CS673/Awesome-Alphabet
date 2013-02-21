package edu.bu.cs673.AwesomeAlphabet.controller;
import java.awt.image.BufferedImage;

import edu.bu.cs673.AwesomeAlphabet.model.Alphabet;
import edu.bu.cs673.AwesomeAlphabet.model.IPageObserver;
import edu.bu.cs673.AwesomeAlphabet.model.Letter;
import edu.bu.cs673.AwesomeAlphabet.model.PageName;
import edu.bu.cs673.AwesomeAlphabet.view.LetterPageView;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;


public class LetterPageController extends PageController {

	private LetterPageView m_view;
	private Alphabet m_alphabet;
	
	
	public LetterPageController(IPageObserver pageObserver, LetterPageView view, Alphabet alphabet) {
		super(pageObserver);
		
		m_view = view;
		m_alphabet = alphabet;
		
		m_view.SetController(this);
		
		alphabet.addObserver(m_view);
		alphabet.GetCurrentLetter().addObserver(m_view);
	}

	public void LetterClicked()
	{
		//Play letter sound
		throw new NotImplementedException();
	}
	
	public void PictureClicked()
	{
		Letter letter = m_alphabet.GetCurrentLetter();
		letter.playSound();
	}
	
	public void WordClicked()
	{
		//Play picture/word sound
		throw new NotImplementedException();
	}
	
	public boolean GetNextLetter()
	{
		Letter letter = m_alphabet.GetCurrentLetter();
		Letter nextLetter = m_alphabet.GoToNextLetter();
		
		if(nextLetter == null)
			return false;
		
		letter.deleteObserver(m_view);
		nextLetter.addObserver(m_view);
		return true;
	}
	
	public boolean GetPreviousLetter()
	{
		Letter letter = m_alphabet.GetCurrentLetter();
		Letter prevLetter = m_alphabet.GoToPreviousLetter();
		
		if(prevLetter == null)
			return false;
		
		letter.deleteObserver(m_view);
		prevLetter.addObserver(m_view);
		return true;	
	}
	
	public void GoToAlphabetPage()
	{
		if(GoToPage(PageName.AlphabetPage))
			m_alphabet.GetCurrentLetter().deleteObserver(m_view);
	}
	
	public void GoToTitlePage()
	{
		if(GoToPage(PageName.TitlePage))
			m_alphabet.GetCurrentLetter().deleteObserver(m_view);
	}
	
	public void GetNextExample()
	{
		Letter letter = m_alphabet.GetCurrentLetter();
		letter.nextExample();
	}
	
	public char GetLetterAsChar()
	{
		return m_alphabet.GetCurrentLetter().GetLetterAsChar();
	}
	
	public BufferedImage GetPicture()
	{
		throw new NotImplementedException();
	}
	
	public String GetWord()
	{
		throw new NotImplementedException();	
	}
}
