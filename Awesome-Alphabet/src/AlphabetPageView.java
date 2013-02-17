import java.util.Observable;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;


public class AlphabetPageView extends PageView {

	private AlphabetPageController m_controller;
	
	
	public AlphabetPageView(String sPageName) {
		super(sPageName);
		
		m_controller = null;
	}
	
	public void SetController(AlphabetPageController controller)
	{
		m_controller = controller;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}
	
	protected void OnLetterButtonClick(char cLetter)
	{
		if(m_controller != null)
			m_controller.GoToLetterPage(cLetter);
	}
	
	protected void OnTitlePageButtonClick()
	{
		if(m_controller != null)
			m_controller.GoToTitlePage();
	}
	
	protected void OnPlayAlphabetSongButtonClick()
	{
		if(m_controller != null)
			m_controller.PlayAlphabetSong();
	}
}
