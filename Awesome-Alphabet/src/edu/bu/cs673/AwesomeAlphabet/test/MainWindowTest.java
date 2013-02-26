package edu.bu.cs673.AwesomeAlphabet.test;

import org.junit.*;

import edu.bu.cs673.AwesomeAlphabet.model.MainWindow;
import edu.bu.cs673.AwesomeAlphabet.view.PageView;
import edu.bu.cs673.AwesomeAlphabet.view.AlphabetPageView;
import static org.junit.Assert.*;

/**
 * The class <code>MainWindowTest</code> contains tests for the class <code>{@link MainWindow}</code>.
 *
 * @generatedBy CodePro at 2/22/13 1:46 AM
 * @author Levi
 * @version $Revision: 1.0 $
 */
public class MainWindowTest {
	/**
	 * Run the MainWindow() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testMainWindow_1()
		throws Exception {

		MainWindow result = new MainWindow();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the MainWindow() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testMainWindow_2()
		throws Exception {

		MainWindow result = new MainWindow();

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the boolean GoToPage(String) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testGoToPage_1()
		throws Exception {
		MainWindow fixture = new MainWindow();
		String sPageName = "";

		boolean result = fixture.GoToPage(sPageName);

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the void Show() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testShow_1()
		throws Exception {
		MainWindow fixture = new MainWindow();

		fixture.Show();

		// add additional test code here
	}

	/**
	 * Run the void registerPage(PageView) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testRegisterPage_1()
		throws Exception {
		MainWindow fixture = new MainWindow();
		PageView page = new AlphabetPageView("");

		fixture.registerPage(page);

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
		new org.junit.runner.JUnitCore().run(MainWindowTest.class);
	}
}