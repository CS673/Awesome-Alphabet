import java.awt.Font;
import java.util.Observer;

import javax.swing.JPanel;


public abstract class PageView implements Observer {

	private String m_sPageName;
	protected JPanel m_panel;
	protected Font letterFont = new Font("Sans-Serif", Font.PLAIN, 32);
	protected Font wordFont = new Font("Sans-Serif", Font.PLAIN, 24);

	
	public PageView(String sPageName)
	{
		m_sPageName = sPageName;
		m_panel = new JPanel();
	}
	
	public String getPageName()
	{
		return m_sPageName;
	}
	
	public JPanel getPagePanel()
	{
		return m_panel;
	}

}
