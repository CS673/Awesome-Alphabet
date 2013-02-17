import java.util.List;

import javax.swing.JFrame;


public class MainWindow implements IPageObserver {

	JFrame m_frame;
	
	public MainWindow() {
		m_frame = new JFrame("Awesome Alphabet");
		m_frame.setSize(800, 600);
	}
	
	public void SetPages(List<PageView> pages)
	{
		
	}
	
	public void Show()
	{
		m_frame.setVisible(true);
	}

	@Override
	public boolean GoToPage(String sPageName) {
		// TODO Auto-generated method stub
		return false;
	}
}
