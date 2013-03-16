package edu.bu.cs673.AwesomeAlphabet.test;

import java.util.Iterator;

import edu.bu.cs673.AwesomeAlphabet.controller.AlphabetPageController;
import edu.bu.cs673.AwesomeAlphabet.model.IPageObserver;
import edu.bu.cs673.AwesomeAlphabet.view.AlphabetPageView;
import edu.bu.cs673.AwesomeAlphabet.model.MainWindow;
import edu.bu.cs673.AwesomeAlphabet.model.Letter;
import edu.bu.cs673.AwesomeAlphabet.model.ThemeManager;

import org.junit.*;
import edu.bu.cs673.AwesomeAlphabet.model.Alphabet;
import static org.junit.Assert.*;

/**
 * The class <code>AlphabetPageControllerTest</code> contains tests for the class <code>{@link AlphabetPageController}</code>.
 *
 * @generatedBy CodePro at 2/22/13 1:54 AM
 * @author Levi
 * @version $Revision: 1.0 $
 */
public class AlphabetPageControllerTest {
	/**
	 * Run the AlphabetPageController(IPageObserver,AlphabetPageView,Alphabet) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:54 AM
	 */
	@Test
	public void testAlphabetPageController_1()
		throws Exception {
		IPageObserver pageObserver = new MainWindow();
		AlphabetPageView view = new AlphabetPageView("");
		Alphabet alphabet = new Alphabet(new ThemeManager());

		AlphabetPageController result = new AlphabetPageController(pageObserver, view, alphabet);

		// add additional test code here
		assertNotNull(result);
		assertEquals(true, result.GoToTitlePage());
	}

	/**
	 * Run the Iterator<Letter> GetLetterIterator() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:54 AM
	 */
	@Test
	public void testGetLetterIterator_1()
		throws Exception {
		AlphabetPageController fixture = new AlphabetPageController(new MainWindow(), new AlphabetPageView(""), 
				                                                    new Alphabet(new ThemeManager()));

		Iterator<Letter> result = fixture.GetLetterIterator();

		// add additional test code here
		assertNotNull(result);
		assertEquals(true, result.hasNext());
	}

	/**
	 * Run the boolean GoToLetterPage(Letter) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:54 AM
	 */
	@Test
	public void testGoToLetterPage_1()
		throws Exception {
		
		ThemeManager themeMgr = new ThemeManager();
		AlphabetPageController fixture = new AlphabetPageController(new MainWindow(), new AlphabetPageView(""), 
				                                                    new Alphabet(themeMgr));
		Letter cLetter = new Letter('', themeMgr);

		boolean result = fixture.GoToLetterPage(cLetter);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean GoToLetterPage(Letter) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:54 AM
	 */
	@Test
	public void testGoToLetterPage_2()
		throws Exception {
		ThemeManager themeMgr = new ThemeManager();
		AlphabetPageController fixture = new AlphabetPageController(new MainWindow(), new AlphabetPageView(""), 
				                                                    new Alphabet(themeMgr));
		Letter cLetter = new Letter('', themeMgr);

		boolean result = fixture.GoToLetterPage(cLetter);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean GoToLetterPage(Letter) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:54 AM
	 */
	@Test
	public void testGoToLetterPage_3()
		throws Exception {
		ThemeManager themeMgr = new ThemeManager();
		AlphabetPageController fixture = new AlphabetPageController(new MainWindow(), new AlphabetPageView(""), 
				                                                    new Alphabet(themeMgr));
		Letter cLetter = new Letter('', themeMgr);

		boolean result = fixture.GoToLetterPage(cLetter);

		// add additional test code here
		assertEquals(false, result);
	}

	/**
	 * Run the boolean GoToTitlePage() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:54 AM
	 */
	@Test
	public void testGoToTitlePage_1()
		throws Exception {
		AlphabetPageController fixture = new AlphabetPageController(new MainWindow(), new AlphabetPageView(""), 
				                                                    new Alphabet(new ThemeManager()));

		boolean result = fixture.GoToTitlePage();

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean GoToTitlePage() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:54 AM
	 */
	@Test
	public void testGoToTitlePage_2()
		throws Exception {
		AlphabetPageController fixture = new AlphabetPageController(new MainWindow(), new AlphabetPageView(""), 
				                                                    new Alphabet(new ThemeManager()));

		boolean result = fixture.GoToTitlePage();

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean PlayAlphabetSong() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:54 AM
	 */
	@Test(expected = sun.reflect.generics.reflectiveObjects.NotImplementedException.class)
	public void testPlayAlphabetSong_1()
		throws Exception {
		AlphabetPageController fixture = new AlphabetPageController(new MainWindow(), new AlphabetPageView(""), 
				                                                    new Alphabet(new ThemeManager()));

		boolean result = fixture.PlayAlphabetSong();

		// add additional test code here
		assertTrue(result);
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
		new org.junit.runner.JUnitCore().run(AlphabetPageControllerTest.class);
	}
}