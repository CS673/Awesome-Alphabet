import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JPanel;


public class LetterPageView extends PageView {

	LetterPageController m_controller;
	
	
	public LetterPageView(String sPageName) {
		super(sPageName);

		JPanel panel = new JPanel(new BorderLayout());
		JPanel buttons = new JPanel(new FlowLayout());
		panel.add(buttons, BorderLayout.PAGE_END);
		
		buttons.add(new JButton("< Previous Letter"));
		buttons.add(new JButton("Next Letter >"));
		buttons.add(new JButton("Title Page"));
		buttons.add(new JButton("Alphabet Page"));
		
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
