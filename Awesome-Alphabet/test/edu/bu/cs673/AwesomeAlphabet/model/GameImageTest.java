package edu.bu.cs673.AwesomeAlphabet.model;

import java.awt.Image;
import java.io.InputStream;

import javax.imageio.ImageIO;

import org.junit.*;

import edu.bu.cs673.AwesomeAlphabet.main.AAConfig;
import edu.bu.cs673.AwesomeAlphabet.model.GameImage;
import static org.junit.Assert.*;

/**
 * The class <code>GameImageTest</code> contains tests for the class <code>{@link GameImage}</code>.
 *
 * @generatedBy CodePro at 2/22/13 1:54 AM
 * @author Levi
 * @version $Revision: 1.0 $
 */
public class GameImageTest {
	/**
	 * Run the GameImage() constructor test.
	 *
	 * @generatedBy CodePro at 2/22/13 1:54 AM
	 */
	@Test
	public void testGameImage()
		throws Exception {
		GameImage result = new GameImage();
		assertNotNull(result);
	}

	/**
	 * Run the Image getImage(String) method test.
	 * Verify that the method retruns null for invalid image value
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:54 AM
	 */
	@Test
	public void testGetImageForInvalidImageValue() throws Exception {
		String filename = "";

		Image result = GameImage.getImage(filename);

		assertEquals(null, result);
	}

	/**
	 * Run the Image getImage(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:54 AM
	 */
	@Test
	public void testGetImageForValidImageValue() throws Exception {
		String filename = "frog.jpg";
		Image result = null;

		
		result = GameImage.getImage(filename);

		// verify the method returns an object, not null. TODO update to verify an image object of frog is returned (?)
		assertNotNull(result);
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 2/22/13 1:54 AM
	 */
	@Before
	public void setUp()
		throws Exception {
		// add additional set up code here
	}

	/**
	 * Perform post-test clean-up.
	 *
	 * @throws Exception
	 *         if the clean-up fails for some reason
	 *
	 * @generatedBy CodePro at 2/22/13 1:54 AM
	 */
	@After
	public void tearDown()
		throws Exception {
		// Add additional tear down code here
	}

	/**
	 * Launch the test.
	 *
	 * @param args the command line arguments
	 *
	 * @generatedBy CodePro at 2/22/13 1:54 AM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(GameImageTest.class);
	}
}