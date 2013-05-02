package edu.bu.cs673.AwesomeAlphabet.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import org.apache.log4j.Logger;

import edu.bu.cs673.AwesomeAlphabet.controller.ButtonHandler;
import edu.bu.cs673.AwesomeAlphabet.controller.SettingController;
import edu.bu.cs673.AwesomeAlphabet.main.Settings;

public class SettingPageView extends PageView {

	static Logger log = Logger.getLogger(SettingPageView.class);
	private SettingController m_controller = null; 
	private String[] displayOptionsArray = {"Default","Sorted","Shuffle"};
	private JComboBox displayOderOptions = new JComboBox(displayOptionsArray);
	private JTextField wordsLimitField = new JTextField();
	
	
	public SettingPageView(String sPageName) {
		super(sPageName);
		
		
		m_panel.setLayout(new BorderLayout());
		
		
		
		GridBagConstraints constraints = new GridBagConstraints();
		constraints.fill = GridBagConstraints.HORIZONTAL;

		JPanel inputPanel = new JPanel(new GridBagLayout());
		inputPanel.setBackground(backgroundColor);

		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.gridheight = 1;
		constraints.gridwidth = 1;
		inputPanel.add(new JLabel("Words Limit:"), constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 0;
		inputPanel.add(wordsLimitField, constraints);
		
		constraints.gridx = 0;
		constraints.gridy = 1;
		inputPanel.add(new JLabel("Display Order:"), constraints);
		
		constraints.gridx = 1;
		constraints.gridy = 1;
		inputPanel.add(displayOderOptions, constraints);

	    
	   // add group panel to the main panel
	    m_panel.add(inputPanel, BorderLayout.CENTER);
	   // m_panel.add(radioPanel, BorderLayout.CENTER);
	    
	    
	    JPanel actionPanel = new JPanel(new FlowLayout());
		actionPanel.setBackground(backgroundColor);
		


		
		JButton actionButton = new JButton("Save");
		actionButton.addActionListener(new ButtonHandler(this, "OnSaveClicked"));
		actionPanel.add(actionButton);
		
		m_panel.add(actionPanel, BorderLayout.SOUTH); 
		
		
		actionButton = getButtonImage(AA_NAV_BUTTON_RETURN_HOME, "Cancel");
		actionButton.addActionListener(new ButtonHandler(this, "OnCancelClicked"));
		actionPanel.add(actionButton);
		//m_panel.add(jButton, BorderLayout.SOUTH);*/
		
		log.info("Initialized the " + sPageName);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void activated() {
		// TODO Auto-generated method stub
		log.info("Activated " + super.getPageName());
		
	}
	
	public void OnSaveClicked(){
		
		if(!wordsLimitField.getText().equalsIgnoreCase("")){
			try{
				int limit = Integer.parseInt(wordsLimitField.getText().trim());
				m_controller.updateMaxExamples(limit);
				if(limit < 0){
					JOptionPane.showMessageDialog(getPagePanel(), "Invalid value: Please enter a positive integer. \n Enter 0 to reset default", "Validation Error",
		                    JOptionPane.PLAIN_MESSAGE);
					return;	
				}
			}catch(NumberFormatException nfe){
				JOptionPane.showMessageDialog(getPagePanel(), "Invalid value: Please enter a positive integer. \n Enter 0 to reset default", "Validation Error",
	                    JOptionPane.PLAIN_MESSAGE);
				return;
			}
		}

		if(!Settings.getDisplayOrder().equalsIgnoreCase(displayOderOptions.getSelectedItem().toString())){
			
			m_controller.updateDisplayOrder(displayOderOptions.getSelectedItem().toString());
		}
		
		m_controller.GoToOptionsMenu();
	}

	public void OnCancelClicked() {
		if (m_controller != null)
			m_controller.GoToOptionsMenu();
	}
	/**
	 * Sets the controller associated with the setting page's view.
	 * 
	 * @param controller   The controller.
	 */
	public void SetController(SettingController controller)
	{
		m_controller = controller;
	}

}
