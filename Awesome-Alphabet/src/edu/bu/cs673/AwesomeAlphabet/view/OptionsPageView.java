package edu.bu.cs673.AwesomeAlphabet.view;

import java.util.Observable;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import org.apache.log4j.Logger;

import edu.bu.cs673.AwesomeAlphabet.controller.ButtonHandler;
import edu.bu.cs673.AwesomeAlphabet.controller.OptionsPageController;

public class OptionsPageView extends PageView {
	
	private OptionsPageController m_controller;
	static Logger log = Logger.getLogger(OptionsPageView.class);

	public OptionsPageView(String pageName) {
		super(pageName);
		
		m_panel.setLayout(new BoxLayout(m_panel, BoxLayout.PAGE_AXIS));
		m_panel.add(Box.createVerticalGlue());
		
		JButton b;
		
		b = getButtonImage(AA_NAV_BUTTON_MANAGE_WORDS, "Manage Words");
		b.addActionListener(new ButtonHandler(this, "OnManageWordsClick"));
		m_panel.add(b);
		
		m_panel.add(Box.createVerticalStrut(10));
		
		b = getButtonImage(AA_NAV_BUTTON_MANAGE_THEMES, "Manage Themes");
		b.addActionListener(new ButtonHandler(this, "OnManageThemesClick"));
		m_panel.add(b);
		
		m_panel.add(Box.createVerticalStrut(10));
		
		b = getButtonImage(AA_NAV_BUTTON_MANAGE_SETTINGS, "Manage Settings");
		m_panel.add(b);
		
		m_panel.add(Box.createVerticalStrut(10));
		
		b = getButtonImage(AA_NAV_BUTTON_RETURN_HOME, "Return to Main Menu");
		b.addActionListener(new ButtonHandler(this, "OnReturnHomeClick"));
		m_panel.add(b);
		
		m_panel.add(Box.createVerticalGlue());
		
		log.info("Initialized the " + pageName);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// Do nothing.
	}

	@Override
	public void activated() {
		log.info("Activated " + super.getPageName());
	}

	public void OnReturnHomeClick() {
		if (m_controller != null)
			m_controller.GoToTitlePage();
	}
	
	public void OnManageThemesClick() {
		if (m_controller != null)
			m_controller.GoToThemesPage();
	}
	
	public void OnManageWordsClick() {
		if (m_controller != null)
			m_controller.GoToWordEditPage();
	}
	
	/**
	 * Sets the controller associated with this view.
	 * 
	 * @param controller   The controller.
	 */
	public void SetController(OptionsPageController controller)
	{
		m_controller = controller;
	}
}
