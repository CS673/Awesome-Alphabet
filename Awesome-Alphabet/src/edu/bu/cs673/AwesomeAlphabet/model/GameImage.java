
/**
 * Routines for retrieving graphics images from a jar or from the filesystem directory.
 */

package edu.bu.cs673.AwesomeAlphabet.model;
import java.awt.Image;
import java.io.InputStream;

import javax.imageio.ImageIO;


public class GameImage {
	
	private static ClassLoader cl = GameImage.class.getClassLoader();
	
	/**
	 * Constructor. This prepends the resource directory to the image's filename.
	 * @param filename the name of the file containing the graphics
	 * @return an Image containing the graphic read from the jar or the filesystem.
	 */
	public static Image getImage(String filename) 
	{
		InputStream is = cl.getResourceAsStream("edu/bu/cs673/AwesomeAlphabet/resources/"+filename);
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
