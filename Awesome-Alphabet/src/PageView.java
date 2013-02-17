import java.util.Observable;
import java.util.Observer;


public abstract class PageView implements Observer {

	private String m_sPageName;
	
	
	public PageView(String sPageName)
	{
		m_sPageName = sPageName;
	}
	
	public String getPageName()
	{
		return m_sPageName;
	}
}
