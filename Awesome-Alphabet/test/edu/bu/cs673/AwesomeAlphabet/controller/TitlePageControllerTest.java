package edu.bu.cs673.AwesomeAlphabet.controller;

import org.junit.*;

import edu.bu.cs673.AwesomeAlphabet.controller.TitlePageController;
import edu.bu.cs673.AwesomeAlphabet.model.IPageObserver;
import edu.bu.cs673.AwesomeAlphabet.view.TitlePageView;
import edu.bu.cs673.AwesomeAlphabet.model.MainWindow;
import static org.junit.Assert.*;

/**
 * The class <code>TitlePageControllerTest</code> contains tests for the class <code>{@link TitlePageController}</code>.
 *
 * @generatedBy CodePro at 2/22/13 1:46 AM
 * @author Levi
 * @version $Revision: 1.0 $
 */
public class TitlePageControllerTest {
	/**
	 * Run the TitlePageController(IPageObserver,TitlePageView) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testTitlePageController_1()
		throws Exception {
		IPageObserver pageObserver = new MainWindow();
		TitlePageView view = new TitlePageView("");

		TitlePageController result = new TitlePageController(pageObserver, view);

		// add additional test code here
		assertNotNull(result);
		assertEquals(true, result.Start());
	}

	/**
	 * Run the boolean Start() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testStart_1()
		throws Exception {
		TitlePageController fixture = new TitlePageController(new MainWindow(), new TitlePageView(""));

		boolean result = fixture.Start();

		// add additional test code here
		assertEquals(true, result);
	}

	/**
	 * Run the boolean Start() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testStart_2()
		throws Exception {
		TitlePageController fixture = new TitlePageController(new MainWindow(), new TitlePageView(""));

		boolean result = fixture.Start();

		// add additional test code here
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
		new org.junit.runner.JUnitCore().run(TitlePageControllerTest.class);
	}
}