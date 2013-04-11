package edu.bu.cs673.AwesomeAlphabet.view;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Observable;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.apache.log4j.Logger;

import edu.bu.cs673.AwesomeAlphabet.controller.ButtonHandler;
import edu.bu.cs673.AwesomeAlphabet.controller.OptionsPageController;

public class OptionsPageView extends PageView {
	
	private OptionsPageController m_controller;
	private static Logger log = Logger.getLogger(OptionsPageView.class);
	
	private final int m_iUnlockResponseCount = 3;
	
	private boolean m_bOptionsLocked;
	
	private JButton m_manageWordsBtn;
	private JButton m_manageThemesBtn;
	private JButton m_manageSettingsBtn;
	private JButton m_mainMenuBtn;
	
	private Box          m_lockUnlockControlsBox;
	private JButton      m_lockUnlockBtn;
	private JLabel       m_unlockInstructionsLbl;
	private JTextField[] m_unlockAnswerTextField = new JTextField[3];
	private String[]     m_sExpectedUnlockResponse = new String[3];
	

	public OptionsPageView(String pageName) {
		super(pageName);
		
		//Create Option Buttons at Top
		m_panel.setLayout(new BoxLayout(m_panel, BoxLayout.PAGE_AXIS));
		m_panel.add(Box.createVerticalGlue());
		m_panel.add(Box.createVerticalStrut(75));
		
		m_manageWordsBtn = getButtonImage(AA_NAV_BUTTON_MANAGE_WORDS, "Manage Words");
		m_manageWordsBtn.addActionListener(new ButtonHandler(this, "OnManageWordsClick"));
		m_panel.add(m_manageWordsBtn);
		
		m_panel.add(Box.createVerticalStrut(10));
		
		m_manageThemesBtn = getButtonImage(AA_NAV_BUTTON_MANAGE_THEMES, "Manage Themes");
		m_manageThemesBtn.addActionListener(new ButtonHandler(this, "OnManageThemesClick"));
		m_panel.add(m_manageThemesBtn);
		
		m_panel.add(Box.createVerticalStrut(10));
		
		m_manageSettingsBtn = getButtonImage(AA_NAV_BUTTON_MANAGE_SETTINGS, "Manage Settings");
		m_panel.add(m_manageSettingsBtn);
		
		m_panel.add(Box.createVerticalStrut(10));
		
		m_mainMenuBtn = getButtonImage(AA_NAV_BUTTON_RETURN_HOME, "Return to Main Menu");
		m_mainMenuBtn.addActionListener(new ButtonHandler(this, "OnReturnHomeClick"));
		m_panel.add(m_mainMenuBtn);
		
		m_panel.add(Box.createVerticalStrut(75));
		
		
		//Create Lock/Unlock Controls
		m_lockUnlockControlsBox = Box.createHorizontalBox();
		
		m_unlockInstructionsLbl = new JLabel();
		m_lockUnlockControlsBox.add(Box.createHorizontalStrut(5));
		m_lockUnlockControlsBox.add(m_unlockInstructionsLbl);
		
		for(int i=0; i<m_iUnlockResponseCount; i++)
		{
			m_unlockAnswerTextField[i] = new JTextField(10);
			
			//Prevent text field from becoming too tall
			m_unlockAnswerTextField[i].setMaximumSize(m_unlockAnswerTextField[i].getPreferredSize());
			
			m_lockUnlockControlsBox.add(Box.createHorizontalStrut(5));
			m_lockUnlockControlsBox.add(m_unlockAnswerTextField[i]);
		}
		
		m_lockUnlockBtn = new JButton();
		m_lockUnlockBtn.setText("Unlock");
		m_lockUnlockBtn.addActionListener(new ButtonHandler(this, "OnLockUnlockBtnClick"));
		m_lockUnlockControlsBox.add(Box.createHorizontalStrut(5));
		m_lockUnlockControlsBox.add(m_lockUnlockBtn);
		
		m_lockUnlockControlsBox.add(Box.createHorizontalStrut(5));
		m_panel.add(m_lockUnlockControlsBox);
		m_panel.add(Box.createVerticalGlue());
		
		EnableOptionControls(false);
		
		log.info("Initialized the " + pageName);
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// Do nothing.
	}

	@Override
	public void activated() {

		EnableOptionControls(!m_bOptionsLocked);
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
	
	public void OnLockUnlockBtnClick() {
		
		if(m_bOptionsLocked)
		{
			if(    GetUnlockResponse(0).compareToIgnoreCase(m_sExpectedUnlockResponse[0]) == 0
				&& GetUnlockResponse(1).compareToIgnoreCase(m_sExpectedUnlockResponse[1]) == 0
				&& GetUnlockResponse(2).compareToIgnoreCase(m_sExpectedUnlockResponse[2]) == 0)
			{
				EnableOptionControls(true);
			}
		}
		else
			EnableOptionControls(false);
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
	
	private void EnableOptionControls(boolean bEnable)
	{
		m_manageWordsBtn.setEnabled(bEnable);
		m_manageThemesBtn.setEnabled(bEnable);
		m_manageSettingsBtn.setEnabled(bEnable);
		
		if(bEnable)
			m_lockUnlockBtn.setText("Lock Options");
		else
		{
			m_lockUnlockBtn.setText("Unlock Options");
			m_unlockInstructionsLbl.setText(GetUnlockQuestion());
			for(int i=0; i<m_iUnlockResponseCount; i++)
				m_unlockAnswerTextField[i].setText("");
		}	
		
		for(int i=0; i<m_iUnlockResponseCount; i++)
			m_unlockAnswerTextField[i].setEnabled(!bEnable);
		
		m_bOptionsLocked = !bEnable;
	}
	
	private String GetUnlockQuestion()
	{
		int iNum1 = (int)(Math.random() * 10);
		int iNum2 = (int)(Math.random() * 10);
		int iNum3 = (int)(Math.random() * 10);
		
		m_sExpectedUnlockResponse[0] = GetNumberWord(iNum1);
		m_sExpectedUnlockResponse[1] = GetNumberWord(iNum2);
		m_sExpectedUnlockResponse[2] = GetNumberWord(iNum3);
		
		return "Spell the numbers " + iNum1 + ", " + iNum2 + " and " + iNum3 + ":";
	}
	
	private String GetNumberWord(int iNum)
	{
		switch(iNum)
		{
		case 0: return "zero";
		case 1: return "one";
		case 2: return "two";
		case 3: return "three";
		case 4: return "four";
		case 5: return "five";
		case 6: return "six";
		case 7: return "seven";
		case 8: return "eight";
		case 9: return "nine";
		default:
			throw new IllegalArgumentException();
		}
	}
	
	public String GetUnlockResponse(int iIndex)
	{
		if(iIndex < 0 || iIndex >= m_iUnlockResponseCount)
			throw new IllegalArgumentException();
		
		return m_unlockAnswerTextField[iIndex].getText().trim().toLowerCase();
	}
}
