package edu.bu.cs673.AwesomeAlphabet.model;
import java.awt.Image;

import javax.swing.ImageIcon;



public class WordPictureSound {
	private String m_word;
	private GameSound m_sound;
	private Image m_image;
	private Theme m_theme;
	
	public WordPictureSound(String word, String imageFile, String soundFile) {
		this.m_word = word;
		m_sound = new GameSound(soundFile);
		m_image = GameImage.getImage(imageFile);
		m_theme = null;
	}
	
	public WordPictureSound(String word, String imageFile, String soundFile, Theme theme) {
		this.m_word = word;
		m_sound = new GameSound(soundFile);
		m_image = GameImage.getImage(imageFile);
		m_theme = theme;
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
		m_theme = newTheme;
	}
}
