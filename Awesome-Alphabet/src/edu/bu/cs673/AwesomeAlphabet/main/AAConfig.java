package edu.bu.cs673.AwesomeAlphabet.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class AAConfig {

	private static final String CONFIG_PROPS = "config.properties";
	private static final String BASE_DIR = "dir.location";
	private static final String GRAPHICS_DIR = "dir.graphics";
	private static final String SOUNDS_DIR = "dir.sounds";
	private static final String DEFAULT_LETTERS = "prop.letters";
	
	private static final ClassLoader loader = AAConfig.class.getClassLoader();
	
	private static String baseDirName;
	private static String graphicsSubDir;
	private static String soundsSubDir;
	private static String letterPropsName;
	
	private static Properties letterProps = null;
	
	static {
		InputStream stream = loader.getResourceAsStream(CONFIG_PROPS);
		Properties prop = new Properties();
		try {
			prop.load(stream);
			baseDirName = prop.getProperty(BASE_DIR);
			graphicsSubDir = prop.getProperty(GRAPHICS_DIR);
			soundsSubDir = prop.getProperty(SOUNDS_DIR);
			letterPropsName = prop.getProperty(DEFAULT_LETTERS);
			stream.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.exit(1);
		}
	}
	

	public static InputStream getGraphicsResource(String filename) {
		return loader.getResourceAsStream(baseDirName + "/" + graphicsSubDir + "/" + filename);
	}


	public static InputStream getSoundResource(String filename) {
		return loader.getResourceAsStream(baseDirName + "/" + soundsSubDir + "/" + filename);
	}


	public static Properties getLetterProps() {
	
		if (letterProps == null) {
			try {
				letterProps = new Properties();
				InputStream is = loader.getResourceAsStream(letterPropsName);
				letterProps.load(is);
			} catch (IOException ioe) {
				ioe.printStackTrace();
				System.exit(1);
			}
		}
		
		return letterProps;
	}

}
