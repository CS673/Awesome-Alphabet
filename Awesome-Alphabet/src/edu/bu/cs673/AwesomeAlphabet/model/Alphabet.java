package edu.bu.cs673.AwesomeAlphabet.model;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Observable;
import java.util.Properties;


public class Alphabet extends Observable {

	private Letter[] m_letters = new Letter[26];
	int m_iCurLetterIndex;
	
	
	public Alphabet()
	{
		for(int i=0; i<26; i++)
			m_letters[i] = new Letter((char)((int)'a' + i));
	}
	
	private int GetLetterIndex(char c)
	{
		char cTemp = Character.toLowerCase(c);
		
		if(cTemp < 'a' || cTemp > 'z')
			return -1;
		else
			return (int)cTemp - (int)'a';		
	}
	
	public Iterator<Letter> GetIterator()
	{
		return Arrays.asList(m_letters).iterator();
	}
	
	public Letter SetCurrentLetter(Letter cLetter)
	{
		int iIndex = GetLetterIndex(cLetter.GetLetterAsChar());
		
		if(iIndex < 0 || iIndex > m_letters.length - 1)
			return null;
		else
		{
			m_iCurLetterIndex = iIndex;
			setChanged();
			notifyObservers(m_letters[m_iCurLetterIndex]);
			return m_letters[m_iCurLetterIndex];
		}
	}
	
	public Letter GetCurrentLetter()
	{
		return m_letters[m_iCurLetterIndex];
	}
	
	public Letter GoToPreviousLetter()
	{
		if(m_iCurLetterIndex <= 0)
			return null;
		else
		{
			m_iCurLetterIndex -= 1;
			setChanged();
			notifyObservers(m_letters[m_iCurLetterIndex]);
			return m_letters[m_iCurLetterIndex];
		}
	}
	
	public Letter GoToNextLetter()
	{
		if(m_iCurLetterIndex >= m_letters.length - 1)
			return null;
		else
		{
			m_iCurLetterIndex += 1;
			setChanged();
			notifyObservers(m_letters[m_iCurLetterIndex]);
			return m_letters[m_iCurLetterIndex];
		}
	}
	
	public void LoadResources(Properties prop) {
		for (char c = 'a'; c <= 'z'; c++) {
			for (int i = 1; i <= 10; i++) {
				String propName = "letter." + c + "." + i + ".";
				try {
					String imageName = prop.getProperty(propName + "image");
					String soundName = prop.getProperty(propName + "sound");
					String wordText = prop.getProperty(propName + "word");
					if (imageName == null && soundName == null && wordText == null)
						break;
					m_letters[GetLetterIndex(c)].addResource(imageName, soundName, wordText);
				} catch (Exception e) {
					i = 10;
				}
			}
		}
	}
}
