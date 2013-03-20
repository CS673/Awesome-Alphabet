package edu.bu.cs673.AwesomeAlphabet.model;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Observable;
import java.util.Properties;

import org.apache.log4j.Logger;


/**
 * The class defines the Alphabet model.  It creates and
 * maintains references to 26 Letter objects; one for each
 * letter of the English alphabet.  It also maintains the
 * current letter selection and has methods for getting
 * the Letter object, changing the letter selection, and
 * loading resources.
 */
public class Alphabet extends Observable {

	protected static final int AA_ALPHABET_SIZE	= 26;
	protected static Logger log = Logger.getLogger(Alphabet.class);
	
	private Letter[] m_letters = new Letter[AA_ALPHABET_SIZE];
	public int m_iCurLetterIndex;
	private GameSound m_alphabetsong;
	private ThemeManager m_themeMgr;
	
	
	/**
	 * Class constructor.  
	 */
	public Alphabet(ThemeManager themeMgr)
	{
		m_themeMgr = themeMgr;
		Initialize();
	}
	
	
	/**
	 * Responsible for creating the Letter objects.
	 */
	public void Initialize()
	{
		for(int i=0; i<AA_ALPHABET_SIZE; i++)
			m_letters[i] = new Letter((char)((int)'a' + i), m_themeMgr);
	}
	
	
	/**
	 * Gets the array index of the specified letter.
	 * 
	 * @param c   The letter, represented as a char.
	 * @return    The index of the letter in the array or
	 *            -1 if the letter is invalid.
	 */
	private int GetLetterIndex(char c)
	{
		char cTemp = Character.toLowerCase(c);
		
		if(cTemp < 'a' || cTemp > 'z')
			return -1;
		else
			return (int)cTemp - (int)'a';		
	}
	
	
	/**
	 * Gets an iterator to the list of Letter objects.
	 * 
	 * @return   An iterator to the list of Letter objects. 
	 */
	public Iterator<Letter> GetIterator()
	{
		return Arrays.asList(m_letters).iterator();
	}
	
	
	
	/**
	 * Sets the letter selection.
	 * 
	 * @param letter   The letter to select.
	 * @return         A reference to the newly selected Letter
	 *                 object or null if the selection was invalid.
	 */
	public Letter SetCurrentLetter(Letter letter)
	{
		int iIndex;
		
		if(letter == null)
			return null;
		
		iIndex = GetLetterIndex(letter.GetLetterAsChar());
		
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
	
	
	/**
	 * Returns the selected letter.
	 * 
	 * @return   The selected letter.
	 */
	public Letter GetCurrentLetter()
	{
		//log.info("Current Letter set to " + m_letters[m_iCurLetterIndex]);
		return m_letters[m_iCurLetterIndex];
	}
	
	
	/**
	 * Changes letter selection to previous letter.
	 * 
	 * @return   The previous letter object or null
	 *           if there are no previous letters.
	 */
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
	
	
	/**
	 * Changes letter selection to next letter.
	 * 
	 * @return   The next letter object or null
	 *           if there are no more letters.
	 */
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
	
	
	
	/**
	 * Loads word, picture, and sound resources into Letter objects.
	 * 
	 * @param prop   The property list containing resource information.
	 */
	public void LoadResources(Properties prop) {
		
		if(m_themeMgr == null)
			return;
		
		for (char c = 'a'; c <= 'z'; c++) {
			for (int i = 1; i <= 10; i++) {
				String propName = "letter." + c + "." + i + ".";
				try {
					String wordText = prop.getProperty(propName + "word");
					if (wordText == null)
						break;
					String imageName = wordText + ".jpg";
					String soundName = wordText + ".wav";
					String themeName = prop.getProperty(propName + "theme");
					
					if(themeName == null)
						m_letters[GetLetterIndex(c)].addResource(imageName, soundName, wordText,
								new Theme(ThemeManager.DEFAULT_THEME_NAME));
					else
					{
						if(!m_themeMgr.addTheme(themeName))
							throw new Exception("Error adding theme.");
						m_letters[GetLetterIndex(c)].addResource(imageName, soundName, wordText, 
								m_themeMgr.getTheme(themeName));
					}
				} catch (Exception e) {
					log.error("An exception occurred while loading properties for leter "+c);
					log.error(e.getMessage());
					e.printStackTrace();
				}
			}
			// log.info("Add Letter Sound");
			try {
				//String propName = "letter." + c + ".lettersound";
				//String letterSoundName = prop.getProperty(propName);
				String letterSoundName = c + ".wav";
				if (letterSoundName != null)
					m_letters[GetLetterIndex(c)].addLetterSoundResource(letterSoundName);
			} catch (Exception e) {
				log.error("An exception occurred while getting the letter sound for letter " + c);
				log.error(e.getMessage());
				e.printStackTrace();
			}
			// log.info("Add Phonic Sound");
			try {
				String phonicSoundName = c + "phonics.wav";
				if (phonicSoundName != null)
					m_letters[GetLetterIndex(c)].addPhonicSoundResource(phonicSoundName);
			} catch (Exception e) {
				log.error("An exception occurred while getting the phonice sound for letter " + c);
				log.error(e.getMessage());
				e.printStackTrace();
			}
		}
		
		// log.info("Load alphabet song");
		try {
			String soundName = prop.getProperty("alphabetsong");
			if (soundName != null) {
				m_alphabetsong = new GameSound(soundName);
			}
		} catch (Exception e) {
			log.error("An exception occurred while loading the alphabet song ");
			log.error(e.getMessage());
			e.printStackTrace();
		}
		
	}
	public void PlayAlphabetSong() {
		m_alphabetsong.PlaySound();
	}
	
	public void StopAlphabetSound() {
		m_alphabetsong.StopSound();
	}
}
