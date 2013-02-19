import java.util.Observable;


public class Letter extends Observable {

	private char m_cLetter;
	
	public Letter(char cLetter) {
	
		m_cLetter = Character.toLowerCase(cLetter);
	}

	public char GetLetterAsChar()
	{
		return m_cLetter;
	}
	
	public char GetUppercaseLetter()
	{
		return Character.toUpperCase(m_cLetter);
	}
}
