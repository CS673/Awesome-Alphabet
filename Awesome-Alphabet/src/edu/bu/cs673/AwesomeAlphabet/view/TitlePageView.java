
package edu.bu.cs673.AwesomeAlphabet.view;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import edu.bu.cs673.AwesomeAlphabet.controller.TitlePageController;
import edu.bu.cs673.AwesomeAlphabet.model.Version;


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
		
		JButton button;
		m_controller = null;

		//Set Background Image and Main Panel Layout
		m_panel.SetBackgroundImage("Graphics/TitlePage.png");
		m_panel.setLayout(new BorderLayout());
		
		
		//Create Center Panel and Buttons
		JPanel centerPanel = new JPanel();
		Box box = Box.createVerticalBox(); 

		box.add(Box.createVerticalStrut(300));
		button = getButtonImage(NAV_BUTTON_START, "Start");
		button.addActionListener(this);
		box.add(button);

		centerPanel.setOpaque(false);
		centerPanel.add(box);
	
		m_panel.add(centerPanel, BorderLayout.CENTER);
		
		
		//Add Version Label
		JLabel versionLabel = new JLabel("Version " + Version.sVersionNum);
		versionLabel.setFont(new Font("Sans-Serif", Font.BOLD, 14));
		versionLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		m_panel.add(versionLabel, BorderLayout.SOUTH);
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
	
	public void activated() {
		// Do nothing
	}
}