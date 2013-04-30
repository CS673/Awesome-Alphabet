package edu.bu.cs673.AwesomeAlphabet.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.Iterator;
import java.util.Observable;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import org.apache.log4j.Logger;

import edu.bu.cs673.AwesomeAlphabet.controller.ButtonHandler;
import edu.bu.cs673.AwesomeAlphabet.controller.WPSController;
import edu.bu.cs673.AwesomeAlphabet.value.WPSViewData;

public class WPSView extends PageView {
	
//	private JList m_wordList = new JList();
//	private DefaultListModel m_wordModel = new DefaultListModel();
	private JTable m_wordTable = new JTable();
	private WPSTableModel m_wordModel = new WPSTableModel();
	private JTextField m_textField = new JTextField();
	
	private WPSController m_controller;
	static Logger log = Logger.getLogger(WPSView.class);

	public WPSView(String pageName) {
		super(pageName);
		
		m_textField.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				updateText(m_textField.getText());
			}
			public void removeUpdate(DocumentEvent e) {
				updateText(m_textField.getText());
			}
			public void insertUpdate(DocumentEvent e) {
				updateText(m_textField.getText());
			}
			public void updateText(String newText) {
				if (newText != null && m_controller != null)
					m_controller.SubstringSearch(newText);
			}
		});
		
		m_panel.setLayout(new BorderLayout());
		
		JPanel centerPanel = new JPanel();
		centerPanel.setBackground(backgroundColor);
		centerPanel.setLayout(new GridBagLayout());
		
		JLabel l = new JLabel("Word Editor");
		l.setFont(headingFont);
		l.setAlignmentX(Component.CENTER_ALIGNMENT);
		JPanel p = new JPanel();
		p.setLayout(new BoxLayout(p, BoxLayout.Y_AXIS));
		p.setBackground(headingBackground);
		p.add(l);
		p.add(new JSeparator(SwingConstants.HORIZONTAL));
		m_panel.add(p, BorderLayout.NORTH);
		
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		
		p = new JPanel(new GridBagLayout());
		p.setBackground(backgroundColor);
		c.gridx = 0;
		c.gridy = 0;
		c.insets = new Insets(0, 20, 0, 0);
		p.add(new JLabel("Search:"), c);
		
		c.gridx = 1;
		c.weightx = 0.9;
		c.insets = new Insets(0, 0, 0, 20);
		p.add(m_textField, c);
		
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.5;
		c.insets = new Insets(0, 0, 0, 0);
		centerPanel.add(p, c);
		
		p = new JPanel(new GridBagLayout());
		p.setBackground(backgroundColor);
		
		m_wordTable.setModel(m_wordModel);
		m_wordTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		JScrollPane scroll = new JScrollPane();
		scroll.setViewportView(m_wordTable);
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.9;
		c.weighty = 0.9;
		p.add(scroll);
		
		JPanel buttonPanel = new JPanel();
		buttonPanel.setBackground(backgroundColor);
		buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.PAGE_AXIS));
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 0.0;
		c.weighty = 0.0;
		p.add(buttonPanel, c);
		
		JButton b = new JButton("Add");
		b.addActionListener(new ButtonHandler(this, "OnWordAddClicked"));
		buttonPanel.add(b);
		
		b = new JButton("Delete");
		b.addActionListener(new ButtonHandler(this, "OnWordDeleteClicked"));
		buttonPanel.add(b);
		
		b = new JButton("Edit");
		b.addActionListener(new ButtonHandler(this, "OnWordEditClicked"));
		buttonPanel.add(b);
		
		c.gridx = 0;
		c.gridy = 1;
		c.weighty = 0.5;
		c.fill = GridBagConstraints.BOTH;
		c.anchor = GridBagConstraints.NORTH;
		centerPanel.add(p, c);

		m_panel.add(centerPanel, BorderLayout.CENTER);
		
		b = getButtonImage(AA_NAV_BUTTON_RETURN_HOME, "Return to Options Menu");
		b.addActionListener(new ButtonHandler(this, "OnReturnHomeClicked"));
		m_panel.add(b, BorderLayout.SOUTH);
				
		log.info("Initialized the " + pageName);
	}
	
	private void refreshWordList() {
		Iterator<WPSViewData> words = m_controller.getWords();
		
		updateWordList(words);
	}

	public void updateWordList(Iterator<WPSViewData> words) {
		if (words != null) {
			m_wordModel.removeAllElements();
			while (words.hasNext()) {
				m_wordModel.addElement(words.next());
			}
		}
		m_wordModel.sort();
		m_wordModel.fireTableDataChanged();
	}
	
	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub

	}

	@Override
	public void activated() {
		m_textField.setText("");
		refreshWordList();
	}
	
	public void OnWordAddClicked() {
		if (m_controller != null) {
			m_controller.CreateNewWord();
			refreshWordList();
		}
	}
	
	public void OnWordEditClicked() {
		String word = m_wordModel.getSelectedWord(m_wordTable.getSelectedRow());
		if (m_controller != null && word != null) {
			m_controller.EditWord(word);
			refreshWordList();
		}
	}
	
	public void OnWordDeleteClicked() {
		String word = m_wordModel.getSelectedWord(m_wordTable.getSelectedRow());
		if (m_controller != null && word != null) {
			m_controller.DeleteWord(word);
			refreshWordList();
		}
	}
	
	public void OnReturnHomeClicked() {
		if (m_controller != null)
			m_controller.GoToOptionsMenu();
	}
	
	/**
	 * Sets the controller associated with this view.
	 * 
	 * @param controller   The controller.
	 */
	public void SetController(WPSController controller)
	{
		m_controller = controller;
	}

}
