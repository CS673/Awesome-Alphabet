package edu.bu.cs673.AwesomeAlphabet.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.awt.image.BufferedImage;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.bu.cs673.AwesomeAlphabet.model.Alphabet;
import edu.bu.cs673.AwesomeAlphabet.model.ThemeManager;
import edu.bu.cs673.AwesomeAlphabet.view.IPageObserver;
import edu.bu.cs673.AwesomeAlphabet.view.LetterPageView;
import edu.bu.cs673.AwesomeAlphabet.view.MainWindow;

/**
 * The class <code>LetterPageControllerTest</code> contains tests for the class <code>{@link LetterPageController}</code>.
 *
 * @generatedBy CodePro at 2/22/13 1:46 AM
 * @author Levi
 * @version $Revision: 1.0 $
 */
public class LetterPageControllerTest {
	/**
	 * Run the LetterPageController(IPageObserver,LetterPageView,Alphabet) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testLetterPageController_1()
		throws Exception {
		IPageObserver pageObserver = new MainWindow();
		LetterPageView view = new LetterPageView("");
		Alphabet alphabet = new Alphabet(new ThemeManager());

		LetterPageController result = new LetterPageController(pageObserver, view, alphabet);

		// add additional test code here
		assertNotNull(result);
		assertEquals('a', result.GetLetterAsChar());
		assertEquals(true, result.GetNextLetter());
		assertEquals(true, result.GetPreviousLetter());
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
		LetterPageController fixture = new LetterPageController(new MainWindow(), new LetterPageView(""), 
				                                                new Alphabet(new ThemeManager()));

		char result = fixture.GetLetterAsChar();

		// add additional test code here
		assertEquals('a', result);
	}

	/**
	 * Run the void GetNextExample() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testGetNextExample_1()
		throws Exception {
		LetterPageController fixture = new LetterPageController(new MainWindow(), new LetterPageView(""), 
				                                                new Alphabet(new ThemeManager()));

		fixture.GetNextExample();

		// add additional test code here
	}

	/**
	 * Run the boolean GetNextLetter() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testGetNextLetter_1()
		throws Exception {
		LetterPageController fixture = new LetterPageController(new MainWindow(), new LetterPageView(""), 
				                                                new Alphabet(new ThemeManager()));

		boolean result = fixture.GetNextLetter();

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean GetNextLetter() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testGetNextLetter_2()
		throws Exception {
		LetterPageController fixture = new LetterPageController(new MainWindow(), new LetterPageView(""), 
				                                                new Alphabet(new ThemeManager()));

		boolean result = fixture.GetNextLetter();

		// add additional test code here
		assertEquals(true, result);
	}


	/**
	 * Run the boolean GetPreviousLetter() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testGetPreviousLetter_1()
		throws Exception {
		LetterPageController fixture = new LetterPageController(new MainWindow(), new LetterPageView(""), 
				                                                new Alphabet(new ThemeManager()));

		boolean result = fixture.GetPreviousLetter();

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean GetPreviousLetter() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testGetPreviousLetter_2()
		throws Exception {
		LetterPageController fixture = new LetterPageController(new MainWindow(), new LetterPageView(""), 
				                                                new Alphabet(new ThemeManager()));

		boolean result = fixture.GetPreviousLetter();

		// add additional test code here
		assertEquals(false, result);
	}


	/**
	 * Run the void GoToAlphabetPage() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testGoToAlphabetPage_1()
		throws Exception {
		LetterPageController fixture = new LetterPageController(new MainWindow(), new LetterPageView(""), 
				                                                new Alphabet(new ThemeManager()));

		fixture.GoToAlphabetPage();

		// add additional test code here
	}

	/**
	 * Run the void GoToAlphabetPage() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testGoToAlphabetPage_2()
		throws Exception {
		LetterPageController fixture = new LetterPageController(new MainWindow(), new LetterPageView(""), 
				                                                new Alphabet(new ThemeManager()));

		fixture.GoToAlphabetPage();

		// add additional test code here
	}

	/**
	 * Run the void GoToTitlePage() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testGoToTitlePage_1()
		throws Exception {
		LetterPageController fixture = new LetterPageController(new MainWindow(), new LetterPageView(""), 
				                                                new Alphabet(new ThemeManager()));

		fixture.GoToTitlePage();

		// add additional test code here
	}

	/**
	 * Run the void GoToTitlePage() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testGoToTitlePage_2()
		throws Exception {
		LetterPageController fixture = new LetterPageController(new MainWindow(), new LetterPageView(""), 
				                                                new Alphabet(new ThemeManager()));

		fixture.GoToTitlePage();

		// add additional test code here
	}

	/**
	 * Run the void LetterClicked() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testLetterClicked_1()
		throws Exception {
		LetterPageController fixture = new LetterPageController(new MainWindow(), new LetterPageView(""), 
				                                                new Alphabet(new ThemeManager()));

		fixture.LetterClicked();

		// add additional test code here
	}

	/**
	 * Run the void PictureClicked() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testPictureClicked_1()
		throws Exception {
		LetterPageController fixture = new LetterPageController(new MainWindow(), new LetterPageView(""), 
				                                                new Alphabet(new ThemeManager()));

		fixture.PictureClicked();

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
		new org.junit.runner.JUnitCore().run(LetterPageControllerTest.class);
	}
}