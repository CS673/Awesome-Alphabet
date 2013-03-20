package edu.bu.cs673.AwesomeAlphabet.view;

import java.util.Observable;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;

import edu.bu.cs673.AwesomeAlphabet.controller.ButtonHandler;

public class OptionsPageView extends PageView {

	public OptionsPageView(String pageName) {
		super(pageName);
		
		m_panel.setLayout(new BoxLayout(m_panel, BoxLayout.PAGE_AXIS));
		m_panel.add(Box.createVerticalGlue());
		
		JButton b;
		
		b = getButtonImage(AA_NAV_BUTTON_MANAGE_WORDS, "Manage Words");
		m_panel.add(b);
		
		b = getButtonImage(AA_NAV_BUTTON_MANAGE_THEMES, "Manage Themes");
		m_panel.add(b);
		
		b = getButtonImage(AA_NAV_BUTTON_MANAGE_SETTINGS, "Manage Settings");
		m_panel.add(b);
		
		b = getButtonImage(AA_NAV_BUTTON_RETURN_HOME, "Return to Main Menu");
		b.addActionListener(new ButtonHandler(this, "OnReturnHomeClick"));
		m_panel.add(b);
		
		m_panel.add(Box.createVerticalGlue());
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void activated() {
		// TODO Auto-generated method stub

	}

}
