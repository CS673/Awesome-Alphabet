import java.awt.Image;
import java.io.InputStream;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;


public class GameImage {
	
	private static ClassLoader cl = GameImage.class.getClassLoader();
	
	public static Image getImage(String filename)
	{
		InputStream is = cl.getResourceAsStream("resources/" + filename);
		
		try {
			return (ImageIO.read(is));
		} catch (Exception e) {
			return null;
		}
	}

}
