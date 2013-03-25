package edu.bu.cs673.AwesomeAlphabet.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

import edu.bu.cs673.AwesomeAlphabet.controller.AlphabetPageController;
import edu.bu.cs673.AwesomeAlphabet.controller.ButtonHandler;
import edu.bu.cs673.AwesomeAlphabet.model.Letter;


/**
 * This class defines the Alphabet Page View.  From this view,
 * the user can play the alphabet song, go to the Title Page,
 * or click on a letter button to go to a specific Letter Page.
 */
public class AlphabetPageView extends PageView {

	private AlphabetPageController m_controller;
	
	private JPanel letterPanel;
	
	static Logger log = Logger.getLogger(AlphabetPageView.class);

	/**
	 * Class constructor.
	 * 
	 * @param sPageName   The page name associated with this view.
	 */
	public AlphabetPageView(String sPageName) {
		super(sPageName);
		
		m_controller = null;
		
		JButton titlePageButton = getButtonImage(AA_NAV_BUTTON_TITLE_PAGE, "Title Page");
		titlePageButton.addActionListener(new ButtonHandler(this, "OnTitlePageButtonClick"));
		
		JButton alphabetSongButton = getButtonImage(AA_NAV_BUTTON_ALPHABET_SONG, "Alphabet Song");
		alphabetSongButton.addActionListener(new ButtonHandler(this, "OnPlayAlphabetSongButtonClick"));
		
		m_panel.setLayout(new BorderLayout());
		m_panel.add(new JLabel("Alphabet Page", JLabel.CENTER), BorderLayout.PAGE_START);
		
		JPanel navBar = new JPanel(new FlowLayout());
		m_panel.add(navBar, BorderLayout.PAGE_END);
		
		navBar.add(titlePageButton);
		navBar.add(alphabetSongButton);
		
		letterPanel = new JPanel(new GridLayout(5, 6));
		m_panel.add(letterPanel, BorderLayout.CENTER);
		
		//Set Background Color
		navBar.setBackground(backgroundColor);
		letterPanel.setBackground(backgroundColor);
	}
	
	
	/**
	 * Sets the controller associated with this view
	 * and creates the letter buttons.
	 * 
	 * @param controller   The controller.
	 */
	public void SetController(AlphabetPageController controller)
	{
		if (m_controller == null) {
			m_controller = controller;
			

			// we can now build the letters
			Iterator<Letter> iter = m_controller.GetLetterIterator();
			while (iter.hasNext()) {
				final Letter l = iter.next();
				JButton b = new JButton("" + l.GetUppercaseLetter() + " " + l.GetLetterAsChar());
				b.setFont(letterFont);
				b.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent ae) {
						OnLetterButtonClick(l);
					}
				});
				letterPanel.add(b);
			}
		}
	}
	
	
	/**
	 * Causes the view to be updated when the model changes.
	 * Currently this method does nothing.  It is required
	 * for the observer pattern.
	 */
	@Override
	public void update(Observable o, Object arg) {
		// Do Nothing
	}
	
	
	/**
	 * Called when a letter button is clicked and
	 * causes the Letter Page to be shown.
	 * 
	 * @param cLetter   The letter to show.
	 */
	public void OnLetterButtonClick(Letter cLetter)
	{
		log.info("Letter button is clicked..");
		
		if (m_controller != null)
			m_controller.GoToLetterPage(cLetter);
	}
	
	
	/**
	 * Called when the Title Page button is clicked
	 * and causes the Title Page to be shown.
	 */
	public void OnTitlePageButtonClick()
	{
		log.info("Title Page button is clicked..");
		
		if (m_controller != null)
			m_controller.GoToTitlePage();
	}
	
	
	/**
	 * Called when the Alphabet Song button is clicked
	 * and causes the alphabet song to be played.
	 */
	public void OnPlayAlphabetSongButtonClick()
	{
		log.info("Alphabet Song button is clicked..");
		
		if (m_controller != null)
			m_controller.PlayAlphabetSong();
	}
	
	public void activated() {
		// do nothing
	}
}
