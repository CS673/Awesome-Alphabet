package edu.bu.cs673.AwesomeAlphabet.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import org.apache.log4j.Logger;

import edu.bu.cs673.AwesomeAlphabet.controller.ButtonHandler;
import edu.bu.cs673.AwesomeAlphabet.controller.LabelClickHandler;
import edu.bu.cs673.AwesomeAlphabet.controller.LetterPageController;


/**
 * This class defines the Letter Page View.  From this view,
 * the user is able to see the current letter; see words and
 * pictures associated with the letter; and play letter
 * and word sounds.  The user is also able to go to the
 * Title and Alphabet pages and see the previous and next
 * letters.
 */
public class LetterPageView extends PageView {

	LetterPageController m_controller;
	
	JButton m_uppercase = new JButton("");
	JButton m_lowercase = new JButton("");
	JButton m_image = new JButton("");
	JLabel m_word = new JLabel("-", JLabel.CENTER);
	
	
	static Logger log = Logger.getLogger(LetterPageView.class);
	/**
	 * Class constructor.
	 * 
	 * @param sPageName   The page name associated with this view.
	 */
	public LetterPageView(String sPageName) {
		super(sPageName);
		
		m_image.setBorder(border);

		m_panel.setLayout(new BorderLayout());
		JPanel buttonBar = new JPanel(new BorderLayout());
		m_panel.add(buttonBar, BorderLayout.SOUTH);
				
		JPanel buttons = new JPanel(new FlowLayout());
		buttonBar.add(buttons, BorderLayout.CENTER);
		JButton b;
				
		b = getButtonImage(AA_NAV_BUTTON_TITLE_PAGE, "Title Page");
		b.addActionListener(new ButtonHandler(this, "OnTitlePageButtonClick"));
		buttons.add(b);
		
		b = getButtonImage(AA_NAV_BUTTON_ALPHABET_PAGE, "Alphabet Page");
		b.addActionListener(new ButtonHandler(this, "OnAlphabetPageButtonClick"));
		buttons.add(b);

		b = getButtonImage(AA_NAV_BUTTON_NEXT_EXAMPLE, "Next Example");
		b.addActionListener(new ButtonHandler(this, "OnGetNextExampleButtonClick"));
		buttons.add(b);

		b = getButtonImage(AA_NAV_BUTTON_PREV_LETTER, "Previous Letter");
		b.addActionListener(new ButtonHandler(this, "OnPreviousLetterButtonClick"));
		b.setOpaque(false);
		b.setContentAreaFilled(false);
		b.setBorderPainted(false);
		buttonBar.add(b, BorderLayout.WEST);
		
		b = getButtonImage(AA_NAV_BUTTON_NEXT_LETTER, "Next Letter");
		b.addActionListener(new ButtonHandler(this, "OnNextLetterButtonClick"));
		b.setOpaque(false);
		b.setContentAreaFilled(false);
		b.setBorderPainted(false);
		buttonBar.add(b, BorderLayout.EAST);

		JPanel mid = new JPanel(new GridLayout(2, 3, 0, 30));
		mid.add(m_uppercase);
		mid.add(m_lowercase);
		mid.add(m_image);
		mid.add(new JLabel());
		mid.add(new JLabel());
		mid.add(m_word);
		m_panel.add(mid, BorderLayout.CENTER);
		
		m_uppercase.setFont(letterFont);
		m_lowercase.setFont(letterFont);
		m_word.setFont(wordFont);
		
		m_word.setVerticalAlignment(JLabel.TOP);
		
		m_image.addActionListener(new ButtonHandler(this, "OnPictureClick"));
		m_uppercase.addActionListener(new ButtonHandler(this, "OnLetterClick"));
		m_lowercase.addActionListener(new ButtonHandler(this, "OnLetterClick"));
		m_word.addMouseListener(new LabelClickHandler(this, "OnPictureClick"));
		
		//Set Background Color
		mid.setBackground(backgroundColor);
		buttons.setBackground(backgroundColor);
		buttonBar.setBackground(backgroundColor);
	}
	
	
	/**
	 * Sets the controller associated with this view.
	 * 
	 * @param controller   The controller.
	 */
	public void SetController(LetterPageController controller)
	{
		m_controller = controller;
	}

	
	/**
	 * Causes the view to be updated when the model changes.
	 * It is required for the observer pattern.
	 */
	@Override
	public void update(Observable o, Object arg) {

		if(m_controller != null)
		{
			m_uppercase.setText("" + m_controller.GetUppercaseLetterAsChar());
			m_lowercase.setText("" + m_controller.GetLowercaseLetterAsChar());
			m_image.setIcon(m_controller.GetIcon(m_image.getWidth(), m_image.getHeight()));
			m_word.setText(m_controller.GetWord());
		}
	}

	
	/**
	 * Called when the letter text/image is clicked
	 * and causes the controller to play a phonetic
	 * letter sound.
	 */
	public void OnLetterClick()
	{
		log.info("The letter text/image is clicked..");
		
		if(m_controller != null)
			m_controller.LetterClicked();
	}
	
	
	/**
	 * Called when the word's picture is clicked and
	 * causes the controller to play the word's sound.
	 */
	public void OnPictureClick()
	{
		log.info("The picture is clicked for sound..");
		
		if(m_controller != null)
			m_controller.PictureClicked();
	}
	
	/**
	 * Called when the Next Letter button is clicked
	 * and causes the next letter to be displayed
	 * (if available). 
	 */
	public void OnNextLetterButtonClick()
	{
		log.info("Next Letter button is clicked");
		
		if(m_controller != null)
			m_controller.GetNextLetter();
	}
	
	
	/**
	 * Called when the Previous Letter button is clicked
	 * and causes the previous letter to be displayed
	 * (if available). 
	 */
	public void OnPreviousLetterButtonClick()
	{
		log.info("Previous Letter button is clicked");
		
		if(m_controller != null)
			m_controller.GetPreviousLetter();
	}
	
	
	/**
	 * Called when the Alphabet Page button is clicked
	 * and causes the Alphabet Page to be shown.
	 */
	public void OnAlphabetPageButtonClick()
	{
		log.info("Alphabet Page button is clicked");
		
		if(m_controller != null)
			m_controller.GoToAlphabetPage();
	}
	
	
	/**
	 * Called when the Title Page button is clicked
	 * and causes the Title Page to be shown.
	 */
	public void OnTitlePageButtonClick()
	{
		log.info("Title Page button is clicked");
		
		if(m_controller != null)
			m_controller.GoToTitlePage();
	}
	
	
	/**
	 * Called when the Get Next Example button is clicked
	 * and causes the next word and picture to be shown
	 * for the current letter.
	 */
	public void OnGetNextExampleButtonClick()
	{
		log.info("Next Example button is clicked");
		
		if (m_controller != null)
			m_controller.GetNextExample();
	}
	
	/**
	 * Lets the controller know that this view has become active.
	 */
	public void activated() {
		m_controller.ObserveCurrentLetter();
	}

}
