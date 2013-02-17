import java.util.Observable;


public class LetterPageView extends PageView {

	LetterPageController m_controller;
	
	
	public LetterPageView(String sPageName) {
		super(sPageName);

		
	}
	
	public void SetController(LetterPageController controller)
	{
		m_controller = controller;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub

	}

	public void OnLetterClick()
	{
		if(m_controller != null)
			m_controller.LetterClicked();
	}
	
	public void OnPictureClick()
	{
		if(m_controller != null)
			m_controller.PictureClicked();
	}
	
	public void OnWordClick()
	{
		if(m_controller != null)
			m_controller.WordClicked();
	}
	
	public void OnNextLetterButtonClick()
	{
		if(m_controller != null)
			m_controller.GetNextLetter();
	}
	
	public void OnPreviousLetterButtonClick()
	{
		if(m_controller != null)
			m_controller.GetPreviousLetter();
	}
	
	public void OnAlphabetPageButtonClick()
	{
		if(m_controller != null)
			m_controller.GoToAlphabetPage();
	}
	
	public void OnTitlePageButtonClick()
	{
		if(m_controller != null)
			m_controller.GoToTitlePage();
	}
	
	public void OnGetNextExampleButtonClick()
	{
		if(m_controller != null)
			m_controller.GetNextExample();
	}
}
