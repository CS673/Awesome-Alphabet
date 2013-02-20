import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;


public class TitlePageView extends PageView implements ActionListener {

	private TitlePageController m_controller;
	
	
	public TitlePageView(String sPageName) {
		super(sPageName);
		
		m_controller = null;
		m_panel.setLayout(new BorderLayout());
		m_panel.add(new JLabel("Welcome to the Awesome Alphabet!", JLabel.CENTER), BorderLayout.PAGE_START);
		
		ImageIcon icon = new ImageIcon(GameImage.getImage("APictureAlphabet.gif"));
		m_panel.add(new JLabel(icon), BorderLayout.CENTER);
		
		JButton startButton = new JButton("Start!");
		m_panel.add(startButton, BorderLayout.PAGE_END);
		
		startButton.addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		this.OnStartButtonClick();
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
		if (m_controller != null)
			m_controller.Start();
	}
}
