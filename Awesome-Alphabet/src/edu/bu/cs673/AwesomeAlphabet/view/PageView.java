package edu.bu.cs673.AwesomeAlphabet.view;
import java.awt.Font;
import java.util.Observer;

import javax.swing.JPanel;


/**
 * This class defines the Page View.  It is the abstract
 * parent class of all page view classes, including
 * AlphabetPageView, LetterPageView, etc.  It manages
 * the page name and panel.
 */
public abstract class PageView implements Observer {

	private String m_sPageName;
	protected JPanel m_panel;
	protected Font letterFont = new Font("Sans-Serif", Font.PLAIN, 32);
	protected Font wordFont = new Font("Sans-Serif", Font.PLAIN, 24);

	
	/**
	 * Class constructor.
	 * 
	 * @param sPageName   The name of the page associated with this view.
	 */
	public PageView(String sPageName)
	{
		m_sPageName = sPageName;
		m_panel = new JPanel();
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


	abstract public void activated();
}
