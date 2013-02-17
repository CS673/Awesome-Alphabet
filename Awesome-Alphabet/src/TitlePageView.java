import java.util.Observable;


public class TitlePageView extends PageView {

	private TitlePageController m_controller;
	
	
	public TitlePageView(String sPageName) {
		super(sPageName);
		
		m_controller = null;
	}
	
	public void SetController(TitlePageController controller)
	{
		m_controller = controller;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}
	
	protected void OnStartButtonClick()
	{
		if(m_controller != null)
			m_controller.Start();
	}
}
