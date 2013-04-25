package edu.bu.cs673.AwesomeAlphabet.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import edu.bu.cs673.AwesomeAlphabet.view.AlphabetPageView;
import edu.bu.cs673.AwesomeAlphabet.view.MainWindow;
import edu.bu.cs673.AwesomeAlphabet.view.PageView;

/**
 * The class <code>MainWindowTest</code> contains tests for the class <code>{@link MainWindow}</code>.
 *
 * @generatedBy CodePro at 2/22/13 1:46 AM
 * @author Levi
 * @version $Revision: 1.0 $
 */
public class MainWindowTest {
	@Rule
	public ExpectedException exception = ExpectedException.none();
	/**
	 * Run the MainWindow() constructor test.
	 * Verify that the constructor creates an object
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testMainWindowConstructor()
		throws Exception {

		MainWindow result = new MainWindow();

		assertNotNull(result);
	}


	/**
	 * Run the boolean GoToPage(String) method test.
	 * Verify that a NullPointerException error is thrown for invalid page request
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testGoToPageForPageNotRegistered() throws Exception {
		
		MainWindow fixture = new MainWindow();
		String sPageName = "LetterPage";

		boolean result = fixture.GoToPage(sPageName);

		assertEquals(false, result);
	}

	/**
	 * Run the void Show() method test.
	 * 
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testShow()
		throws Exception {
		MainWindow fixture = new MainWindow();
		
		fixture.Show(); //Note: I am not quite sure how to verify this test.
		
		
	}

	/**
	 * Run the void registerPage(PageView) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testRegisterAndGoToPagePassesForValidPageValue()
		throws Exception {
		MainWindow fixture = new MainWindow();
		PageView page = new AlphabetPageView("LetterPage");

		fixture.registerPage(page);

		String sPageName = "LetterPage";

		boolean result = fixture.GoToPage(sPageName);
		assertEquals(true, result);
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
		new org.junit.runner.JUnitCore().run(MainWindowTest.class);
	}
}