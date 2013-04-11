
package edu.bu.cs673.AwesomeAlphabet.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Observable;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import org.apache.log4j.Logger;

import edu.bu.cs673.AwesomeAlphabet.controller.ButtonHandler;
import edu.bu.cs673.AwesomeAlphabet.controller.TitlePageController;
import edu.bu.cs673.AwesomeAlphabet.model.Version;


/**
 * This class defines the Title Page View. From this view,
 * the user is able to see the application's name and version
 * and go to the Alphabet Page.
 */
public class TitlePageView extends PageView {

	private TitlePageController m_controller;
	
	static Logger log = Logger.getLogger(TitlePageView.class);
	
	/**
	 * Class constructor.
	 * 
	 * @param sPageName   The page name associated with this view.
	 */
	public TitlePageView(String sPageName)  {
		super(sPageName);
		
		JButton button;
		Component component;
		m_controller = null;

		//Set Background Image and Main Panel Layout
		m_panel.SetBackgroundImage("TitlePage.png");
		m_panel.setLayout(new BorderLayout());
		
		
		//Create Center Panel and Buttons
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.PAGE_AXIS));
		
		component = Box.createRigidArea(new Dimension(10, 150));
		component.setMinimumSize(new Dimension(10, 80));
		centerPanel.add(component);
		
		centerPanel.add(Box.createVerticalGlue());
		centerPanel.add(Box.createVerticalStrut(10));
		centerPanel.add(Box.createVerticalGlue());

		//Add "Start" Button
		button = getButtonImage(AA_NAV_BUTTON_START, "Start");
		button.addActionListener(new ButtonHandler(this, "OnStartButtonClick"));
		button.setAlignmentX(Component.CENTER_ALIGNMENT);
		centerPanel.add(button);
		
		//centerPanel.add(Box.createVerticalStrut(10)); //Spacing between buttons

		centerPanel.add(Box.createVerticalGlue());
		centerPanel.setOpaque(false);
	
		m_panel.add(centerPanel, BorderLayout.CENTER);
		
		
		//Create Bottom Panel
		JPanel bottomPanel = new JPanel();
		bottomPanel.setLayout(new BorderLayout());
		bottomPanel.setOpaque(false);
		
		//Add Version Label
		JLabel versionLabel = new JLabel("Version " + Version.sVersionNum);
		versionLabel.setFont(new Font("Sans-Serif", Font.BOLD, 14));
		versionLabel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		versionLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		bottomPanel.add(versionLabel, BorderLayout.WEST);
		
		//Add "Options" Button
		button = getButtonImage(AA_NAV_BUTTON_OPTIONS, "Options");
		button.addMouseListener(new MouseListener() {
			
			//Create button action on double-click
			public void mouseClicked(MouseEvent arg0) {
				  if (arg0.getClickCount() == 2)
					  OnOptionsButtonClick();
			}
			public void mouseEntered(MouseEvent arg0)  {}
			public void mouseExited(MouseEvent arg0)   {}
			public void mousePressed(MouseEvent arg0)  {}
			public void mouseReleased(MouseEvent arg0) {}
		});
		button.setOpaque(false);
		button.setContentAreaFilled(false);
		button.setBorderPainted(false);
		bottomPanel.add(button, BorderLayout.EAST);
		
		//Add Bottom Panel to Main Panel
		m_panel.add(bottomPanel, BorderLayout.SOUTH);
		
		
		log.info("Initialized the TitlePageView " + sPageName);
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
		log.info("update called for " + o.getClass());
	}
	
	
	/**
	 * Called when the Start Button is clicked
	 * and causes the Alphabet Page to be shown.
	 */
	public void OnStartButtonClick()
	{
		log.info("Start button is clicked..");
		
		if (m_controller != null)
			m_controller.Start();
	}
	
	/**
	 *  Called when the Options button is clicked and
	 *  causes the options page to be shown.
	 */
	public void OnOptionsButtonClick()
	{
		if (m_controller != null)
			m_controller.Options();
	}
	
	public void activated() {
		// Do nothing
		log.info("Activated " + super.getPageName());
	}
}
