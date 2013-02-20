import java.awt.Image;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class GameImage {
	
	private static ClassLoader cl = GameImage.class.getClassLoader();
	
	public static Image getImage(String filename) 
	{
		InputStream is = cl.getResourceAsStream("resources/"+filename);
		if(is==null){
			System.out.println("Input stream is null");
		}
		
		try {
			return (ImageIO.read(is));
		} catch (Exception e) {
			return null;
		}
	}

}
