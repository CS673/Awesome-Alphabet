import java.awt.Image;
import java.io.InputStream;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;


public abstract class PageView implements Observer {

	private String m_sPageName;
	protected JPanel m_panel;
	static ClassLoader cl = PageView.class.getClassLoader();
	
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
	
	public ImageIcon getIcon(String filename)
	{
		InputStream is = cl.getResourceAsStream("resources/" + filename);
		
		try {
			Image i = ImageIO.read(is);
			return (new ImageIcon(i));
		} catch (Exception e) {
			return null;
		}
	}
}
