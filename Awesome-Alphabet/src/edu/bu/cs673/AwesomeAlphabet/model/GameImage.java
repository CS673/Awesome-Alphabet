package edu.bu.cs673.AwesomeAlphabet.model;
import java.awt.Image;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.apache.log4j.Logger;


public class GameImage {
	
	private static ClassLoader cl = GameImage.class.getClassLoader();
	static Logger log = Logger.getLogger(GameImage.class);
	
	public static Image getImage(String filename) 
	{
		InputStream is = cl.getResourceAsStream("edu/bu/cs673/AwesomeAlphabet/resources/"+filename);
		if(is==null){
			System.out.println("Input stream is null");
		}
		
		try {
			return (ImageIO.read(is));
		} catch (Exception e) {
			log.error("An exception occurred while reading the file: "+filename);
			log.error(e.getMessage());
			e.printStackTrace();
			return null;
		}
	}

}
