package edu.bu.cs673.AwesomeAlphabet.model;

import javax.swing.ImageIcon;

import org.easymock.EasyMock;
import org.junit.*;
import org.junit.rules.ExpectedException;

import edu.bu.cs673.AwesomeAlphabet.model.WordPictureSound;
import static org.junit.Assert.*;

/**
 * The class <code>WordPictureSoundTest</code> contains tests for the class <code>{@link WordPictureSound}</code>.
 *
 * @generatedBy CodePro at 2/22/13 1:46 AM
 * @author Levi
 * @version $Revision: 1.0 $
 */
public class WordPictureSoundTest {
	
	@Rule
	public ExpectedException exception = ExpectedException.none();

	/**
	 * Run the WordPictureSound(String,String,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testWordPictureSoundObjectIsCreated()
		throws Exception {
		String word = "TestWord";
		String imageFile = "bicycle.jpg";
		String soundFile = "testSound";
		char letter = 'c';
	
		Theme themeMock = EasyMock.createMock(Theme.class);
		
		
		WordPictureSound result = new WordPictureSound(letter, word, imageFile, soundFile, themeMock);

		assertNotNull(result);
		
	}

	/**
	 * Run the ImageIcon GetWordImage(int,int) method test.
	 * Verify that the method returns null when the image object is null
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testGetWordImageForBlankImage()	throws Exception {
		String word = "testWord";
		String imageFile = "testImage";
		String soundFile = "testSound";
		char letter = 'c';
		
		Theme theme = new Theme(ThemeManager.DEFAULT_THEME_NAME);
		
		WordPictureSound fixture = new WordPictureSound(letter, word, imageFile, soundFile, theme);
		
		int width = 1;
		int height = 1;
		
		//exception.expect(IllegalArgumentException.class);
		//exception.expectMessage("input == null!");
		
		ImageIcon result = fixture.GetWordImage(width, height);

		
		assertEquals(null, result);
	}

	/**
	 * Run the ImageIcon GetWordImage(int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testGetWordImagePassesForValidImageValue() throws Exception {
		
		String word = "TestWord";
		String imageFile = "bicycle.jpg";
		String soundFile = "testSound";
		char letter = 'c';
		Theme theme = new Theme(ThemeManager.DEFAULT_THEME_NAME);
		
		WordPictureSound fixture = new WordPictureSound(letter, word, imageFile, soundFile, theme);
		
		int width = 1;
		int height = 1;

		ImageIcon result = fixture.GetWordImage(width, height);

		assertNotNull(result);
	}

	/**
	 * Run the String GetWordString() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testGetWordStringPassesForValidWordValue() throws Exception {
		
		String word = "TestWord";
		String imageFile = "bicycle.jpg";
		String soundFile = "testSound";
		char letter = 'c';
		Theme theme = new Theme(ThemeManager.DEFAULT_THEME_NAME);
		
		WordPictureSound fixture = new WordPictureSound(letter, word, imageFile, soundFile, theme);

		String result = fixture.GetWordString();

		// add additional test code here
		assertEquals(word, result);
	}

	/**
	 * Run the void PlaySound() method test.
	 * Test that the provided sound file is played.
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testPlaySound() throws Exception {
		String word = "TestWord";
		String imageFile = "bicycle.jpg";
		String soundFile = "frog.wav";
		char letter = 'c';
		
		
		Theme themeMock = EasyMock.createMock(Theme.class);
				
		WordPictureSound fixture = new WordPictureSound(letter, word, imageFile, soundFile, themeMock);
		fixture.PlaySound(); // note: cannot verify that the gameSound method got called since it is being call via a private variable
		
		
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
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
	 * @generatedBy CodePro at 2/22/13 1:46 AM
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
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(WordPictureSoundTest.class);
	}
}