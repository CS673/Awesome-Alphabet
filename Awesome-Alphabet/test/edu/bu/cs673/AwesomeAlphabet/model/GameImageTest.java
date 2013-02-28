package edu.bu.cs673.AwesomeAlphabet.model;

import java.awt.Image;
import org.junit.*;

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
	public void testGameImage_1()
		throws Exception {
		GameImage result = new GameImage();
		assertNotNull(result);
		// add additional test code here
	}

	/**
	 * Run the Image getImage(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:54 AM
	 */
	@Test
	public void testGetImage_1()
		throws Exception {
		String filename = "";

		Image result = GameImage.getImage(filename);

		// add additional test code here
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
	public void testGetImage_2()
		throws Exception {
		String filename = "";

		Image result = GameImage.getImage(filename);

		// add additional test code here
		assertEquals(null, result);
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