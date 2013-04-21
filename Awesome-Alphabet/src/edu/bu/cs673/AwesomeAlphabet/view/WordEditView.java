package edu.bu.cs673.AwesomeAlphabet.view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.util.Iterator;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

import org.apache.log4j.Logger;

import edu.bu.cs673.AwesomeAlphabet.controller.ButtonHandler;
import edu.bu.cs673.AwesomeAlphabet.controller.WordEditController;
import edu.bu.cs673.AwesomeAlphabet.model.WordPictureSound;

public class WordEditView extends PageView {
	
	private WordEditController m_controller = null;
	private JTextField m_wordField = new JTextField();
	private JComboBox<String> m_themeChoice = new JComboBox<String>();
	private JTextField m_imageFileField = new JTextField();
	private JTextField m_soundFileField = new JTextField();
	private static final JFileChooser chooser = new JFileChooser();
	private String[] letters = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j",
			"k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"
	};
	private String m_sUnselectedThemeName = "--none--";
	private JComboBox<String> m_letterChoice = new JComboBox<String>(letters);
	protected static Logger log = Logger.getLogger(WordEditView.class);
	
	public WordEditView(String pageName) {
		super(pageName);
		
		m_imageFileField.setEditable(false);
		m_soundFileField.setEditable(false);
		
		JButton selectImage = new JButton("Select");
		selectImage.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				chooser.removeChoosableFileFilter(chooser.getFileFilter());
				chooser.setFileFilter(new FileNameExtensionFilter("JPEG Files (*.jpg)", "jpg"));
				int result = chooser.showOpenDialog(WordEditView.this.m_panel);
				if (result == JFileChooser.APPROVE_OPTION) {
					File f = chooser.getSelectedFile();
					m_imageFileField.setText(f.getAbsolutePath());
				}
			}
		});

		JButton selectSound = new JButton("Select");
		selectSound.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				chooser.removeChoosableFileFilter(chooser.getFileFilter());
				chooser.setFileFilter(new FileNameExtensionFilter("WAV Files (*.wav)", "wav"));
				int result = chooser.showOpenDialog(WordEditView.this.m_panel);
				if (result == JFileChooser.APPROVE_OPTION) {
					File f = chooser.getSelectedFile();
					m_soundFileField.setText(f.getAbsolutePath());
				}
			}
		});

		m_themeChoice.addItem(m_sUnselectedThemeName);
		
		m_panel.setLayout(new BorderLayout());
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		JPanel centerPanel = new JPanel(new GridBagLayout());
		centerPanel.setBackground(backgroundColor);

		c.gridx = 0;
		c.gridy = 0;
		c.gridheight = 1;
		c.gridwidth = 1;
		centerPanel.add(new JLabel("Word:"), c);
		
		c.gridx = 1;
		c.gridy = 0;
		centerPanel.add(m_wordField, c);

		c.gridx = 0;
		c.gridy = 1;
		centerPanel.add(new JLabel("Theme:"), c);
		
		c.gridx = 1;
		c.gridy = 1;
		centerPanel.add(m_themeChoice, c);
		
		c.gridx = 0;
		c.gridy = 2;
		centerPanel.add(new JLabel("Associated Letter:"), c);
		
		c.gridx = 1;
		c.gridy = 2;
		centerPanel.add(m_letterChoice, c);
		
		c.gridx = 0;
		c.gridy = 3;
		centerPanel.add(new JLabel("Image file:"), c);
		
		c.gridx = 1;
		c.gridy = 3;
		centerPanel.add(m_imageFileField, c);
		
		c.gridx = 2;
		c.gridy = 3;
		centerPanel.add(selectImage, c);
		
		c.gridx = 0;
		c.gridy = 4;
		centerPanel.add(new JLabel("Sound file:"), c);
		
		c.gridx = 1;
		c.gridy = 4;
		centerPanel.add(m_soundFileField, c);
		
		c.gridx = 2;
		c.gridy = 4;
		centerPanel.add(selectSound, c);
		
		m_panel.add(centerPanel, BorderLayout.CENTER);
		
		
		JPanel p = new JPanel(new FlowLayout());
		p.setBackground(backgroundColor);

		JButton b = new JButton("Cancel");
		b.addActionListener(new ButtonHandler(this, "OnCancelClicked"));
		p.add(b);
		
		b = new JButton("Save");
		b.addActionListener(new ButtonHandler(this, "OnSaveClicked"));
		p.add(b);
		
		m_panel.add(p, BorderLayout.SOUTH);
		
		
	}
	
	public void OnCancelClicked() {
		if (m_controller != null)
			m_controller.CancelEditWord();
	}
	
	public void OnSaveClicked() {
		
		WordPictureSound wps = m_controller.getCurrentWordEditing();
		String sWord = m_wordField.getText().trim();
		String sCharacter = (String) m_letterChoice.getSelectedItem();
		char letter_c = sCharacter.charAt(0);
		String sAbsImageFilePath = m_imageFileField.getText();
		String sAbsSoundFilePath = m_soundFileField.getText();
		
		if(m_controller == null)
			return;
		
		//Verify Word
		if(m_wordField.getText().compareTo("") == 0)
		{
			JOptionPane.showMessageDialog(getPagePanel(), "Please enter a word.", "Validation Error",
                    JOptionPane.PLAIN_MESSAGE);
			return;
		}
		else if(    m_controller.wordExists(sWord)
				&& (wps == null || wps.GetWordString().compareToIgnoreCase(sWord) != 0))
		{
			JOptionPane.showMessageDialog(getPagePanel(), "The specified word already exists.\n" +
		                                                  "Please enter another word or edit the existing word.", 
		                                                  "Validation Error", JOptionPane.PLAIN_MESSAGE);
			return;
		}
		else if(!sWord.matches("([a-zA-Z]+([- ][a-zA-Z]+)*)"))
		{
			JOptionPane.showMessageDialog(getPagePanel(), "The specified word contains invalid characters.\n" +
                    									  "Please enter a valid word.", 
                    									  "Validation Error", JOptionPane.PLAIN_MESSAGE);
			return;
		}
		
		//Verify Theme Selection
		if(m_themeChoice.getSelectedItem().toString().compareTo(m_sUnselectedThemeName) == 0)
		{
			JOptionPane.showMessageDialog(getPagePanel(), "Please select a valid theme.", "Validation Error",
					                      JOptionPane.PLAIN_MESSAGE);
			return;
		}
		
		//Verify that image file exists
		if( !(new File(sAbsImageFilePath)).isFile() || !sAbsImageFilePath.toLowerCase().endsWith(".jpg"))
		{
			JOptionPane.showMessageDialog(getPagePanel(), "Please select a valid \".jpg\" image file.", 
					                      "Validation Error", JOptionPane.PLAIN_MESSAGE);
			return;		
		}
		
		//Verify that sound file exists
		if( !(new File(sAbsSoundFilePath)).isFile() || !sAbsSoundFilePath.toLowerCase().endsWith(".wav"))
		{
			JOptionPane.showMessageDialog(getPagePanel(), "Please select a valid \".wav\" sound file.", 
					                      "Validation Error", JOptionPane.PLAIN_MESSAGE);
			return;		
		}
		
		
		//Save Values
		if (wps == null) {
			/* It is new word being added */
			m_controller.SaveNewWord(sWord, letter_c, sAbsImageFilePath,
					sAbsSoundFilePath, m_themeChoice.getSelectedItem().toString());
		} else {
			m_controller.SaveEditWord(sWord, letter_c, sAbsImageFilePath,
					sAbsSoundFilePath, m_themeChoice.getSelectedItem().toString());
		}
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void activated() {
		int i;
		
		if (m_controller != null) {
			Iterator<String> themes = m_controller.getThemeNamesIterator();
			WordPictureSound wps = m_controller.getCurrentWordEditing();
			
			m_themeChoice.removeAllItems();
			m_themeChoice.addItem(m_sUnselectedThemeName);
			while (themes.hasNext()) {
				String s = themes.next();
				m_themeChoice.addItem(s);
			}
			
			if (wps == null) //If "Add" mode: Initialize controls
			{
				m_wordField.setText("");
				
				if(m_themeChoice.getItemCount() > 0)
					m_themeChoice.setSelectedIndex(0);  //Select "--none--"
				
				if(m_letterChoice.getItemCount() > 0)
					m_letterChoice.setSelectedIndex(0); //Select "a"
				
				m_imageFileField.setText("");
				m_soundFileField.setText("");
				
			}
			else //"Edit" mode: Populate controls
			{
				m_wordField.setText(wps.GetWordString());
				log.info("word theme is:" + wps.getTheme().getThemeName());
				
				for (i = 0; i < m_themeChoice.getItemCount(); i++) {
					if (m_themeChoice.getItemAt(i).toString().equals(wps.getTheme().getThemeName())) {
						m_themeChoice.setSelectedIndex(i);
						break;
					}
				}
				
				m_letterChoice.setSelectedIndex(m_controller.getLetterIndex(wps.getWordLetter()));
				m_imageFileField.setText(m_controller.getAbsImageFilePath(wps.GetWordString()));
				m_soundFileField.setText(m_controller.getAbsSoundFilePath(wps.GetWordString()));
			}
		}
	}

	
	/**
	 * Sets the controller associated with this view.
	 * 
	 * @param controller   The controller.
	 */
	public void SetController(WordEditController controller)
	{
		m_controller = controller;
	}
}
