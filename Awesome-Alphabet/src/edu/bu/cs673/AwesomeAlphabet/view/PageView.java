package edu.bu.cs673.AwesomeAlphabet.view;
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

	protected static final String AA_NAV_BUTTON_TITLE_PAGE		= "Graphics/Home.png";
	protected static final String AA_NAV_BUTTON_ALPHABET_SONG	= "Graphics/Music.png";
	protected static final String AA_NAV_BUTTON_HOME			= "Graphics/Home.png";
	protected static final String AA_NAV_BUTTON_NEXT_LETTER	    = "Graphics/NextArrow.png";
	protected static final String AA_NAV_BUTTON_PREV_LETTER	    = "Graphics/PreviousArrow.png";
	protected static final String AA_NAV_BUTTON_NEXT_EXAMPLE	= "Graphics/NextExample.png";
	protected static final String AA_NAV_BUTTON_ALPHABET_PAGE	= "Graphics/AlphabetPage.png";
	protected static final String AA_NAV_BUTTON_START			= "Graphics/StartButton.png";


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
		if (i == null) {
			return new JButton(defaultName);
		}
		JButton b = new JButton(new ImageIcon(i));
		b.setBorder(border);
		return b;
	}

	abstract public void activated();
}
