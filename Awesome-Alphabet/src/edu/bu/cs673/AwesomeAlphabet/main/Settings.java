package edu.bu.cs673.AwesomeAlphabet.main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class Settings {
	private static Logger log = Logger.getLogger(Settings.class);
	public static final String DISPLAY_ORDER = "Display_Order";
	public static final String MAXIMUM_EXAMPLES = "Maximum_Examples";
	private static final String SettingPropertiesFile = "settings.properties";
	private static final ClassLoader loader = Settings.class.getClassLoader();
	public static Properties props = new Properties();

	
	/**
	 * Read and load setting properties from the file
	 */
	public void loadSettingProperties(){
		
		log.info("Loading setting properties from the file");
		props = new Properties();
		InputStream inputStream = null;
	
		inputStream = loadFileFromPersitentDirectory();

		if(inputStream == null){
			inputStream = loadFileFromClassPath();
		}
		if(inputStream == null)
			return;
		
		
		try {
			props.load(inputStream);
			
			log.info("display order: "+props.getProperty(DISPLAY_ORDER));
			log.info("max examples: "+props.getProperty(MAXIMUM_EXAMPLES));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Read the default setting properties from the classpath
	 * @return
	 */
	private InputStream loadFileFromClassPath() {
		InputStream inputStream = null;
		try{
			inputStream = loader.getResourceAsStream(SettingPropertiesFile);
		}catch(Exception e){
			e.printStackTrace();
		}
		return inputStream;
	}

	/**
	 * Read the user setting properties from the current directory
	 * @return
	 */
	private InputStream loadFileFromPersitentDirectory() {
		InputStream inputStream;
		File file;
		try {
			file = new File(AAConfig.getResourceDirPersistentAbs()+SettingPropertiesFile);
			inputStream = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			inputStream = null;
			//e1.printStackTrace();
		}
		return inputStream;
	}
	
	/**
	 * Write setting properties to the files
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 */
	public static void saveSettingProperties() {
		log.info("display order saved: "+ getDisplayOrder());
		log.info("max examples saved: "+ getMaxExamples());
		
		props.setProperty(MAXIMUM_EXAMPLES, Integer.toString(getMaxExamples()));
		props.setProperty(DISPLAY_ORDER, getDisplayOrder());
		
		try {
			props.store(new FileOutputStream(AAConfig.getResourceDirPersistentAbs()+SettingPropertiesFile), "Setting properties updated");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/**
	 * Return value of display order
	 */
	public static String getDisplayOrder()
	{	
		String result = props.getProperty(DISPLAY_ORDER);
		
		if(result == null)
			return "Default";
		else
			return props.getProperty(DISPLAY_ORDER);
	}
	
	/**
	 * Return value of display order
	 */
	public static int getMaxExamples()
	{	
		String limitStr = props.getProperty(MAXIMUM_EXAMPLES);
		
		if(limitStr == null)
			return Integer.MAX_VALUE;
		
		try
		{
			return Integer.parseInt(limitStr);
			
		} catch (NumberFormatException e) {
			
			return Integer.MAX_VALUE;
		}
	}
}
