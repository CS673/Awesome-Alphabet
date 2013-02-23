
package edu.bu.cs673.AwesomeAlphabet.view;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import edu.bu.cs673.AwesomeAlphabet.controller.TitlePageController;
import edu.bu.cs673.AwesomeAlphabet.model.GameImage;


/**
 * This class defines the Title Page View. From this view,
 * the user is able to see the application's name and version
 * and go to the Alphabet Page.
 */
public class TitlePageView extends PageView implements ActionListener {

	private TitlePageController m_controller;
	
	
	/**
	 * Class constructor.
	 * 
	 * @param sPageName   The page name associated with this view.
	 */
	public TitlePageView(String sPageName)  {
		super(sPageName);
		
		m_controller = null;
		m_panel.setLayout(new BorderLayout());
		m_panel.add(new JLabel("Welcome to the Awesome Alphabet!", JLabel.CENTER), BorderLayout.PAGE_START);
		
		ImageIcon icon = new ImageIcon(GameImage.getImage("APictureAlphabet.gif"));
		m_panel.add(new JLabel(icon), BorderLayout.CENTER);
		
		JButton startButton = new JButton("Start!");
		m_panel.add(startButton, BorderLayout.PAGE_END);
		
		startButton.addActionListener(this);
	}
	
	
	/**
	 * Handles button click events.
	 */
	public void actionPerformed(ActionEvent ae)
	{
		this.OnStartButtonClick();
	}
	
	
	/**
	 * Sets the controller associated with this view.
	 * 
	 * @param controller   The controller.
	 */
	public void SetController(TitlePageController controller)
	{
		m_controller = controller;
	}


	/**
	 * Causes the view to be updated when the model changes.
	 * Currently this method does nothing.  It is required
	 * for the observer pattern.
	 */
	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * Called when the Start Button is clicked
	 * and causes the Alphabet Page to be shown.
	 */
	protected void OnStartButtonClick()
	{
		if (m_controller != null)
			m_controller.Start();
	}
}