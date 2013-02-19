import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JPanel;


public class LetterPageView extends PageView {

	LetterPageController m_controller;
	
	
	public LetterPageView(String sPageName) {
		super(sPageName);

		m_panel.setLayout(new BorderLayout());
		JPanel buttons = new JPanel(new FlowLayout());
		m_panel.add(buttons, BorderLayout.PAGE_END);
		
		JButton b;
		
		b = new JButton("Previous Letter");
		b.addActionListener(new ButtonHandler(this, "OnPreviousLetterButtonClick"));
		buttons.add(b);
		
		b = new JButton("Next Letter");
		b.addActionListener(new ButtonHandler(this, "OnNextLetterButtonClick"));
		buttons.add(b);
		
		b = new JButton("Title Page");
		b.addActionListener(new ButtonHandler(this, "OnTitlePageButtonClick"));
		buttons.add(b);
		
		b = new JButton("Alphabet Page");
		b.addActionListener(new ButtonHandler(this, "OnAlphabetPageButtonClick"));
		buttons.add(b);
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
