package edu.bu.cs673.AwesomeAlphabet.model;
import java.awt.Image;
import java.util.Comparator;

import javax.swing.ImageIcon;

import org.apache.log4j.Logger;



public class WordPictureSound implements Comparable<Object>{
	private String m_word;
	private GameSound m_sound;
	private Image m_image;
	private Theme m_theme;
	private char m_cLetter;
	Integer id;
	protected static Logger log = Logger.getLogger(WordPictureSound.class);

	
	public WordPictureSound(char Letter, String word, String imageFile, String soundFile, Theme theme, int id) {
		m_cLetter = Letter;
		this.id = id;
		this.m_word = word;
		m_sound = new GameSound(soundFile);
		m_image = GameImage.getImage(imageFile);
		m_theme = theme;
		m_theme.incRefCount();
	}
	
	public void PlaySound() {
		m_sound.PlaySound();
	}
	
	public void StopSound() {
		m_sound.StopSound();
	}
	
	public String GetWordString() {
		return m_word;
	}
	
	public ImageIcon GetWordImage(int width, int height) {
		if (m_image == null)
			log.info("Vivek:GetWordImage(): m_image is null ");
		if (m_image == null || width == 0 || height == 0) 
			return null;
		return new ImageIcon(m_image.getScaledInstance(width, height, Image.SCALE_SMOOTH));
	}
	
	/**
	 * Gets the current theme associated with this object.
	 * 
	 * @return  The current theme.
	 */
	public Theme getTheme()
	{
		return m_theme;
	}
	
	/**
	 * Changes the theme associated with this object.
	 * 
	 * @param newTheme  The new theme.
	 */
	public void changeTheme(Theme newTheme)
	{
		if (m_theme != null)
			m_theme.decRefCount();
		m_theme = newTheme;
		if (m_theme != null)
			m_theme.incRefCount();
	}
	
	/**
	 * Get the letter associated with this word.
	 * 
	 * @param wps  The word we want letter for
	 * @return returns char word is associated with
	 */
	public char getWordLetter()
	{
		return m_cLetter;
	}
	
	/**
	 * Compare two objects of type  WordPictureSound
	 * @param anotherWordPictureSoundObject
	 * @return
	 */
	@Override
	public int compareTo(Object o) {
		WordPictureSound anotherWordPictureSoundObject = (WordPictureSound) o;
		return m_word.compareTo(anotherWordPictureSoundObject.m_word);
	}
	
	/**
	 * Compare objects by id
	 */
	public static Comparator<WordPictureSound> compareById = new Comparator<WordPictureSound>() {
        public int compare(WordPictureSound one, WordPictureSound other) {
            return one.id.compareTo(other.id);
        }
    };

}
