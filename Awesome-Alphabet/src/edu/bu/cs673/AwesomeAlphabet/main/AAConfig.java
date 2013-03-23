package edu.bu.cs673.AwesomeAlphabet.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

import edu.bu.cs673.AwesomeAlphabet.model.GameImage;

public class AAConfig {
	static Logger log = Logger.getLogger(GameImage.class);
	
	private static final String CONFIG_PROPS = "config.properties";
	private static final String BASE_DIR = "dir.location";
	private static final String GRAPHICS_DIR = "dir.graphics";
	private static final String SOUNDS_DIR = "dir.sounds";
	private static final String DEFAULT_LETTERS = "prop.letters";
	
	private static final ClassLoader loader = AAConfig.class.getClassLoader();
	
	private static String baseDir;
	private static String graphicsSubDir;
	private static String soundsSubDir;
	private static String letterProps;
	
	static {
		InputStream stream = loader.getResourceAsStream(CONFIG_PROPS);
		Properties prop = new Properties();
		try {
			prop.load(stream);
			baseDir = prop.getProperty(BASE_DIR);
			graphicsSubDir = prop.getProperty(GRAPHICS_DIR);
			soundsSubDir = prop.getProperty(SOUNDS_DIR);
			letterProps = prop.getProperty(DEFAULT_LETTERS);
			
			log.info("baseDir: " + baseDir);
			
			stream.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.exit(1);
		}
	}
	

	public static InputStream getGraphicsResource(String filename) {
		return loader.getResourceAsStream(baseDir + "/" + graphicsSubDir + "/" + filename);
	}


	public static InputStream getSoundResource(String filename) {
		return loader.getResourceAsStream(baseDir + "/" + soundsSubDir + "/" + filename);
	}


	public static Properties getLetterProps() {
		try {
			Properties props = new Properties();
			InputStream is = loader.getResourceAsStream(letterProps);
			props.load(is);
			return props;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.exit(1);
		}
		return null;
	}

}
