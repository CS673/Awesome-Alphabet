package edu.bu.cs673.AwesomeAlphabet.main;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStream;

public class AAConfig {

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
			is.close();
			return props;
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.exit(1);
		}
		return null;
	}
	
	/** copy file
	 * @param srcFileName: Full path to source file
	 * @param dstFileName : Full path to dest file
	 */
	private static int copy_file(String srcFileName, String destFileName)
	{
		InputStream inStream = null;
		OutputStream outStream = null;
		
    	try {
    		 
    		File sfile = new File(srcFileName);
    		File dfile = new File(destFileName);
 
    		inStream = new FileInputStream(sfile);
    		outStream = new FileOutputStream(dfile);
 
    	    byte[] buffer = new byte[1024];
 
    	    int length;
    	    
    	    //copy the file content in bytes 
    	    while ((length = inStream.read(buffer)) > 0) {
    	    	outStream.write(buffer, 0, length);
    	    }
 
    	    inStream.close();
    	    outStream.close();
 
    	} catch(IOException e) {
    		e.printStackTrace();
    	}
		return 0;
	}
	
	/** Add a sound resource file.
	 * @param srcFileName: Full path name to source sound file
	 * @param destFileName: file name (no path info) of dest file
	 * @return
	 */
	public static int addSoundResource(String srcFileName, String destFileName) {
		return copy_file(srcFileName, baseDir + "/" + soundsSubDir + "/" + destFileName);
	}
	
	/** Add a word image file.
	 * @param srcFileName: Full path name to source image file
	 * @param destFileName: file name (no path info) of dest file
	 * @return
	 */
	public static int addImageResource(String srcFileName, String destFileName) {
		return copy_file(srcFileName, baseDir + "/" + graphicsSubDir + "/" + destFileName);
	}

	/** Add a word to letter.properties file
	 * @param srcFileName: Full path name to source image file
	 * @param destFileName: file name (no path info) of dest file
	 * @return
	 */
	public static int addWordToIndex(char letter, String wordText, String Theme) {
		int i = 1;
	
		try {
			Properties props = getLetterProps();
			File outputFile = new File(letterProps + "temp");
			File destFile = new File(letterProps);
			OutputStream outStream = new FileOutputStream(outputFile);
			
			while (true) {
				if (props.getProperty("letter." + letter + "." + i + ".word") == null)
					break;
				i++;
			}
			
			props.setProperty("letter." + letter + "." + i + ".word", wordText);
			props.setProperty("letter." + letter + "." + i + ".theme", Theme);
			props.store(outStream, null);
			outStream.close();
			outputFile.renameTo(destFile);
		} catch(IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	/** Remove a sound resource file.
	 * @param srcFileName: file name to source sound file (no dir)
	 * @return 0 on success.
	 */
	public static int removeSoundResource(String srcFileName) {
		int ret = 0;
		boolean rc;
		
		try {
			File file = new File(baseDir + "/" + soundsSubDir + "/" + srcFileName);
			rc = file.delete();
			if (!rc)
				ret = 1;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	/** Remove a image resource file.
	 * @param srcFileName: file name to source sound file (no dir)
	 * @return 0 on success.
	 */
	public static int removeImageResource(String srcFileName) {
		int ret = 0;
		boolean rc;
		
		try {
			File file = new File(baseDir + "/" + graphicsSubDir + "/" + srcFileName);
			rc = file.delete();
			if (!rc)
				ret = 1;
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return ret;
	}
	
	/** Remove a word from letter.properties file
	 * @param letter char word belongs to
	 * @param actual word string
	 * @return 0 on success
	 */
	public static int removeWordFromIndex(char letter, String wordText) {
		int i = 1;
	
		try {
			Properties props = getLetterProps();
			File outputFile = new File(letterProps + "temp");
			File destFile = new File(letterProps);
			OutputStream outStream = new FileOutputStream(outputFile);
			int tablesize = props.size();
			boolean found = false;
			
			while (true) {
				if (props.getProperty("letter." + letter + "." + i + ".word") == wordText) {
					found = true;
					break;
				}
				
				i++;
				if (i > tablesize)
					break;
			}
			
			if (!found)
				return 1;
			
			props.remove("letter." + letter + "." + i + ".word");
			props.remove("letter." + letter + "." + i + ".theme");
			
			props.store(outStream, null);
			outStream.close();
			outputFile.renameTo(destFile);
		} catch(IOException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
