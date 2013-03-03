
/**
 * Routines to handle sound for Awesome Alphabet.
 */

package edu.bu.cs673.AwesomeAlphabet.model;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineEvent;
import javax.sound.sampled.LineListener;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

import org.apache.log4j.Logger;


public class GameSound {
	static Logger log = Logger.getLogger(GameSound.class);

	private static ClassLoader cl = GameSound.class.getClassLoader();
	private String soundfilepath;
	private final BlockingQueue<String> queue = new ArrayBlockingQueue<String>(1);
	
	/**
	 * Constructor. This prepends the directory to the sound's filename
	 * @param soundfilepath sound's filename
	 */
	public GameSound(String soundfilepath) {
		// TODO: Error handling. File not being present.
		this.soundfilepath = "edu/bu/cs673/AwesomeAlphabet/resources/" + soundfilepath;
		log.info("Adding sound file" + this.soundfilepath);	
	}
	
	/**
	 * Plays the sound for this object. Does not return until the sound has finished playing.
	 * This is limited to short-duration sounds only (2 seconds or less).
	 */
	public void PlaySound() {
		try {
			InputStream is = new BufferedInputStream(cl.getResourceAsStream(soundfilepath));
			AudioInputStream audioIn = AudioSystem.getAudioInputStream(is);
			Clip clip = AudioSystem.getClip();
			
			clip.open(audioIn);
			clip.start();
			LineListener listener = new LineListener() {
				public void update(LineEvent event) {
					if (event.getType() != LineEvent.Type.STOP) {
						return;
					}

					try {
						queue.put("dummy");
						return;
					}
					catch (InterruptedException e) {
						//ignore this
					}
				}
			};

			clip.addLineListener(listener);
			try {
				queue.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnsupportedAudioFileException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LineUnavailableException e) {
			log.error("Sound file '" + soundfilepath + "' is too large to play.");
		}
	}
}
