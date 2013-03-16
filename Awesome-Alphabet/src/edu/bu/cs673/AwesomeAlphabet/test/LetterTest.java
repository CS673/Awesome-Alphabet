package edu.bu.cs673.AwesomeAlphabet.test;

import javax.swing.Icon;

import edu.bu.cs673.AwesomeAlphabet.model.Letter;
import edu.bu.cs673.AwesomeAlphabet.model.ThemeManager;
import edu.bu.cs673.AwesomeAlphabet.view.AlphabetPageView;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>LetterTest</code> contains tests for the class <code>{@link Letter}</code>.
 *
 * @generatedBy CodePro at 2/22/13 1:46 AM
 * @author Levi
 * @version $Revision: 1.0 $
 */
public class LetterTest {
	/**
	 * Run the Letter(char) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testLetter_1()
		throws Exception {
		char cLetter = '';

		Letter result = new Letter(cLetter, new ThemeManager());

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getWord());
		assertEquals('', result.GetUppercaseLetter());
		assertEquals('', result.GetLetterAsChar());
		assertEquals(false, result.hasChanged());
		assertEquals(0, result.countObservers());
	}

	/**
	 * Run the char GetLetterAsChar() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testGetLetterAsChar_1()
		throws Exception {
		Letter fixture = new Letter('', new ThemeManager());
		fixture.addObserver(new AlphabetPageView(""));

		char result = fixture.GetLetterAsChar();

		// add additional test code here
		assertEquals('', result);
	}

	/**
	 * Run the char GetUppercaseLetter() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testGetUppercaseLetter_1()
		throws Exception {
		Letter fixture = new Letter('', new ThemeManager());
		fixture.addObserver(new AlphabetPageView(""));

		char result = fixture.GetUppercaseLetter();

		// add additional test code here
		assertEquals('', result);
	}

	/**
	 * Run the void addResource(String,String,String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testAddResource_1()
		throws Exception {
		Letter fixture = new Letter('', new ThemeManager());
		fixture.addObserver(new AlphabetPageView(""));
		String imageName = "";
		String soundName = "";
		String wordText = "";

		fixture.addResource(imageName, soundName, wordText);

		// add additional test code here
	}

	/**
	 * Run the Icon getIcon(int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testGetIcon_1()
		throws Exception {
		Letter fixture = new Letter('', new ThemeManager());
		fixture.addObserver(new AlphabetPageView(""));
		int width = 1;
		int height = 1;

		Icon result = fixture.getIcon(width, height);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Icon getIcon(int,int) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testGetIcon_2()
		throws Exception {
		Letter fixture = new Letter('', new ThemeManager());
		fixture.addObserver(new AlphabetPageView(""));
		int width = 1;
		int height = 1;

		Icon result = fixture.getIcon(width, height);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the String getWord() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testGetWord_1()
		throws Exception {
		Letter fixture = new Letter('', new ThemeManager());
		fixture.addObserver(new AlphabetPageView(""));

		String result = fixture.getWord();

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the String getWord() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testGetWord_2()
		throws Exception {
		Letter fixture = new Letter('', new ThemeManager());
		fixture.addObserver(new AlphabetPageView(""));

		String result = fixture.getWord();

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the void nextExample() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testNextExample_1()
		throws Exception {
		Letter fixture = new Letter('', new ThemeManager());
		fixture.addObserver(new AlphabetPageView(""));

		fixture.nextExample();

		// add additional test code here
	}

	/**
	 * Run the void nextExample() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testNextExample_2()
		throws Exception {
		Letter fixture = new Letter('', new ThemeManager());
		fixture.addObserver(new AlphabetPageView(""));

		fixture.nextExample();

		// add additional test code here
	}

	/**
	 * Run the void playSound() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testPlaySound_1()
		throws Exception {
		Letter fixture = new Letter('', new ThemeManager());
		fixture.addObserver(new AlphabetPageView(""));

		fixture.playSound();

		// add additional test code here
	}

	/**
	 * Run the void playSound() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testPlaySound_2()
		throws Exception {
		Letter fixture = new Letter('', new ThemeManager());
		fixture.addObserver(new AlphabetPageView(""));

		fixture.playSound();

		// add additional test code here
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
		new org.junit.runner.JUnitCore().run(LetterTest.class);
	}
}