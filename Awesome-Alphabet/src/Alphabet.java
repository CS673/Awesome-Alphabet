import java.util.Arrays;
import java.util.Iterator;
import java.util.Observable;


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
			notifyObservers();
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
			notifyObservers();
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
			notifyObservers();
			return m_letters[m_iCurLetterIndex];
		}
	}
	
	/*
	public Letter GetLetterObj(char cLetter)
	{
		int iIndex = GetLetterIndex(cLetter);
		
		if(iIndex < 0 || iIndex > m_letters.length - 1)
			return null;
		else
			return m_letters[iIndex];
	}
	
	public Letter GetPreviousLetterObj(char cCurrentLetter)
	{
		int iIndex = GetLetterIndex(cCurrentLetter);
		
		if(iIndex < 0 || iIndex >= m_letters.length - 1)
			return null;
		else
			return m_letters[iIndex + 1];	
	}
	
	public Letter GetNextLetterObj(char cCurrentLetter)
	{
		int iIndex = GetLetterIndex(cCurrentLetter);
		
		if(iIndex <= 0 || iIndex > m_letters.length - 1)
			return null;
		else
			return m_letters[iIndex - 1];	
	}
	*/
}
