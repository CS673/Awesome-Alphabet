package edu.bu.cs673.AwesomeAlphabet.model;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Container;
import java.util.Hashtable;

import javax.swing.JFrame;
import javax.swing.JPanel;

import edu.bu.cs673.AwesomeAlphabet.view.PageView;


public class MainWindow implements IPageObserver {

	private JFrame m_frame;
	private JPanel m_curView;
	private CardLayout m_cl;
	private Hashtable<String, PageView> m_pageHash;
	
	public MainWindow() {
		m_frame = new JFrame("Awesome Alphabet");
		m_frame.setSize(800, 600);
		
		Container content = m_frame.getContentPane();
	    content.setBackground(Color.white);
	    content.setLayout(new BorderLayout()); 

	    m_cl = new CardLayout();
	    m_curView = new JPanel(m_cl);
	    content.add(m_curView, BorderLayout.CENTER);
	    
	    m_pageHash = new Hashtable();
	}
	
	public void registerPage(PageView page)
	{
		m_curView.add(page.getPageName(), page.getPagePanel());
		m_pageHash.put(page.getPageName(),  page);
	}
	
	public void Show()
	{
		m_frame.setVisible(true);
	}

	@Override
	public boolean GoToPage(String sPageName)
	{
		PageView pv = m_pageHash.get(sPageName);
		pv.activated();
		m_cl.show(m_curView, sPageName);
		return true;
	}
}
