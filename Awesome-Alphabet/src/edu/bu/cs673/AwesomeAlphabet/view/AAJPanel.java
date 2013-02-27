package edu.bu.cs673.AwesomeAlphabet.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JPanel;

import edu.bu.cs673.AwesomeAlphabet.model.GameImage;


//This class is partially based on code from
//http://stackoverflow.com/questions/9816079/background-image-jframe-with-content


/**
 * This class defines a customized JPanel.
 * It has the ability to add a background image.
 */
@SuppressWarnings("serial")
public class AAJPanel extends JPanel{

	Image m_originalBackgroundImage;
	Image m_backgroundImage;
	
	/**
	 * Class constructor.
	 */
	public AAJPanel()
	{
		super();
		
		m_backgroundImage = null;
		m_originalBackgroundImage = null;
		
	    addComponentListener(new ComponentAdapter() {
	        public void componentResized(ComponentEvent e) {
	        	
	            int w = getWidth();
	            int h = getHeight();
	            
	            if(m_originalBackgroundImage != null)
	            {
		            m_backgroundImage = w>0 && h>0
		            		? m_originalBackgroundImage.getScaledInstance(
		            				w, h, Image.SCALE_SMOOTH) 
		            		: m_originalBackgroundImage;
	            }
	            repaint();
	        }
	    });
	}
	
	
	/**
	 * Sets the background image.
	 * 
	 * @param filename   The filename of the image.
	 */
	public void SetBackgroundImage(String filename)
	{
		SetBackgroundImage(GameImage.getImage(filename));
	}
	
	
	/**
	 * Sets the background image.
	 * 
	 * @param image   The image.
	 */
	public void SetBackgroundImage(Image image)
	{
	    m_backgroundImage = image;
	    m_originalBackgroundImage = image;
	    setOpaque(image == null);
	    repaint();
	}
	
	
	/**
	 * Overridden paint method.  Paints the background image.
	 */
	@Override
	public void paint(Graphics g) {
	    if (m_backgroundImage != null)
	    	g.drawImage(m_backgroundImage, 0, 0, null);
	    super.paint(g);
	}
}
