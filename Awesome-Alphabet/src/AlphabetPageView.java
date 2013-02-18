import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class AlphabetPageView extends PageView {

	private AlphabetPageController m_controller;
	
	class BackButtonHandler implements ActionListener {
		private AlphabetPageView apv;
		public BackButtonHandler(AlphabetPageView apv) {
			this.apv = apv;
		}
		public void actionPerformed(ActionEvent ae) {
			apv.OnTitlePageButtonClick();
		}
	}
	
	public AlphabetPageView(String sPageName) {
		super(sPageName);
		
		m_controller = null;
		
		JButton backButton = new JButton("<-- Back");
		backButton.addActionListener(new BackButtonHandler(this));
		
		m_panel.setLayout(new BorderLayout());
		m_panel.add(new JLabel("Alphabet Page", JLabel.CENTER), BorderLayout.PAGE_START);
		m_panel.add(backButton, BorderLayout.PAGE_END);
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
