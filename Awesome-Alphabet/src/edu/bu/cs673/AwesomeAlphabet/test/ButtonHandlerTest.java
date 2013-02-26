package edu.bu.cs673.AwesomeAlphabet.test;

import java.awt.event.ActionEvent;

import edu.bu.cs673.AwesomeAlphabet.controller.ButtonHandler;
import edu.bu.cs673.AwesomeAlphabet.view.AlphabetPageView;
import org.junit.*;
import edu.bu.cs673.AwesomeAlphabet.view.PageView;
import static org.junit.Assert.*;

/**
 * The class <code>ButtonHandlerTest</code> contains tests for the class <code>{@link ButtonHandler}</code>.
 *
 * @generatedBy CodePro at 2/22/13 1:54 AM
 * @author Levi
 * @version $Revision: 1.0 $
 */
public class ButtonHandlerTest {
	/**
	 * Run the ButtonHandler(PageView,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:54 AM
	 */
	@Test
	public void testButtonHandler_1()
		throws Exception {
		PageView pv = new AlphabetPageView("");
		String method = "";

		ButtonHandler result = new ButtonHandler(pv, method);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the ButtonHandler(PageView,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:54 AM
	 */
	@Test
	public void testButtonHandler_2()
		throws Exception {
		PageView pv = new AlphabetPageView("");
		String method = "";

		ButtonHandler result = new ButtonHandler(pv, method);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the ButtonHandler(PageView,String) constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:54 AM
	 */
	@Test
	public void testButtonHandler_3()
		throws Exception {
		PageView pv = new AlphabetPageView("");
		String method = "";

		ButtonHandler result = new ButtonHandler(pv, method);

		// add additional test code here
		assertNotNull(result);
	}

	/**
	 * Run the void actionPerformed(ActionEvent) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:54 AM
	 */
	@Test
	public void testActionPerformed_1()
		throws Exception {
		ButtonHandler fixture = new ButtonHandler(new AlphabetPageView(""), "");
		ActionEvent ae = new ActionEvent(new Object(), 1, "");

		fixture.actionPerformed(ae);

		// add additional test code here
	}

	/**
	 * Run the void actionPerformed(ActionEvent) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:54 AM
	 */
	@Test
	public void testActionPerformed_2()
		throws Exception {
		ButtonHandler fixture = new ButtonHandler(new AlphabetPageView(""), "");
		ActionEvent ae = new ActionEvent(new Object(), 1, "");

		fixture.actionPerformed(ae);

		// add additional test code here
	}

	/**
	 * Run the void actionPerformed(ActionEvent) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:54 AM
	 */
	@Test
	public void testActionPerformed_3()
		throws Exception {
		ButtonHandler fixture = new ButtonHandler(new AlphabetPageView(""), "");
		ActionEvent ae = new ActionEvent(new Object(), 1, "");

		fixture.actionPerformed(ae);

		// add additional test code here
	}

	/**
	 * Run the void actionPerformed(ActionEvent) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:54 AM
	 */
	@Test
	public void testActionPerformed_4()
		throws Exception {
		ButtonHandler fixture = new ButtonHandler(new AlphabetPageView(""), "");
		ActionEvent ae = new ActionEvent(new Object(), 1, "");

		fixture.actionPerformed(ae);

		// add additional test code here
	}

	/**
	 * Run the void actionPerformed(ActionEvent) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:54 AM
	 */
	@Test
	public void testActionPerformed_5()
		throws Exception {
		ButtonHandler fixture = new ButtonHandler(new AlphabetPageView(""), "");
		ActionEvent ae = new ActionEvent(new Object(), 1, "");

		fixture.actionPerformed(ae);

		// add additional test code here
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
		new org.junit.runner.JUnitCore().run(ButtonHandlerTest.class);
	}
}