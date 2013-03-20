package edu.bu.cs673.AwesomeAlphabet.view;
import java.awt.Component;
import java.awt.Font;
import java.awt.Image;
import java.util.Observer;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import edu.bu.cs673.AwesomeAlphabet.model.GameImage;


/**
 * This class defines the Page View.  It is the abstract
 * parent class of all page view classes, including
 * AlphabetPageView, LetterPageView, etc.  It manages
 * the page name and panel.
 */
public abstract class PageView implements Observer {

	private String m_sPageName;
	protected AAJPanel m_panel;
	
	protected static Font letterFont = new Font("Sans-Serif", Font.PLAIN, 32);
	protected static Font wordFont = new Font("Sans-Serif", Font.PLAIN, 24);
	protected static Border border = BorderFactory.createEmptyBorder();

	protected static final String AA_NAV_BUTTON_TITLE_PAGE		= "Home.png";
	protected static final String AA_NAV_BUTTON_ALPHABET_SONG	= "Music.png";
	protected static final String AA_NAV_BUTTON_HOME			= "Home.png";
	protected static final String AA_NAV_BUTTON_NEXT_LETTER	    = "NextArrow.png";
	protected static final String AA_NAV_BUTTON_PREV_LETTER	    = "PreviousArrow.png";
	protected static final String AA_NAV_BUTTON_NEXT_EXAMPLE	= "NextExample.png";
	protected static final String AA_NAV_BUTTON_ALPHABET_PAGE	= "AlphabetPage.png";
	protected static final String AA_NAV_BUTTON_START			= "StartButton.png";
	protected static final String AA_NAV_BUTTON_OPTIONS			= "Options.png";
	protected static final String AA_NAV_BUTTON_MANAGE_THEMES	= "ManageThemes.png";
	protected static final String AA_NAV_BUTTON_MANAGE_WORDS	= "ManageWords.png";
	protected static final String AA_NAV_BUTTON_MANAGE_SETTINGS	= "ManageOptions.png";
	protected static final String AA_NAV_BUTTON_RETURN_HOME		= "ReturnHome.png";

	/**
	 * Class constructor.
	 * 
	 * @param sPageName   The name of the page associated with this view.
	 */
	public PageView(String sPageName)
	{
		m_sPageName = sPageName;
		m_panel = new AAJPanel();
	}
	
	
	/**
	 * Gets the page name.
	 * 
	 * @return   The page name as a String.
	 */
	public String getPageName()
	{
		return m_sPageName;
	}
	
	
	/**
	 * Gets the panel.
	 * 
	 * @return  The panel as a JPanel.
	 */
	public JPanel getPagePanel()
	{
		return m_panel;
	}
	
	/**
	 * Gets a button image from the graphics code. If the image could not be loaded,
	 * then it creates text button using the default text.
	 * @param filename		the graphics file to read
	 * 
	 * @param defaultName	the name of the text button used as a fall-back
	 * @return				a button ready for displaying
	 */
	public JButton getButtonImage(String filename, String defaultName) {
		Image i = GameImage.getImage(filename);
		JButton b;
		if (i == null) {
			b = new JButton(defaultName);
			b.setAlignmentX(Component.CENTER_ALIGNMENT);
		} else {
			b = new JButton(new ImageIcon(i));
			b.setBorder(border);
			b.setAlignmentX(Component.CENTER_ALIGNMENT);
		}
		return b;
	}

	abstract public void activated();
}
