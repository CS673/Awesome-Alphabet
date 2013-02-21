package edu.bu.cs673.AwesomeAlphabet.model;
import java.awt.Image;

import javax.swing.ImageIcon;



public class WordPictureSound {
	private String m_word;
	private GameSound m_sound;
	private Image m_image;
	
	public WordPictureSound(String word, String imageFile, String soundFile) {
		this.m_word = word;
		m_sound = new GameSound(soundFile);
		m_image = GameImage.getImage(imageFile);
	}
	
	public void PlaySound() {
		m_sound.PlaySound();
	}
	
	public String GetWordString() {
		return m_word;
	}
	
	public ImageIcon GetWordImage(int width, int height) {
		if (m_image == null)
			return null;
		return new ImageIcon(m_image.getScaledInstance(width, height, Image.SCALE_SMOOTH));
	}
}
