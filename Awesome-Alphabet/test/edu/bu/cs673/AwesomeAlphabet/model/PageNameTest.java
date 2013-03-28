package edu.bu.cs673.AwesomeAlphabet.model;

import org.junit.*;

import edu.bu.cs673.AwesomeAlphabet.model.PageName;
import static org.junit.Assert.*;

/**
 * The class <code>PageNameTest</code> contains tests for the class <code>{@link PageName}</code>.
 *
 * @generatedBy CodePro at 2/22/13 1:54 AM
 * @author Levi
 * @version $Revision: 1.0 $
 */
public class PageNameTest {
	/**
	 * Run the String toString() method test.
	 * Verify the method returns the string AlphabetPage
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:54 AM
	 */
	@Test
	public void testToStringAlphabetPage()
		throws Exception {
		PageName fixture = PageName.AlphabetPage;

		String result = fixture.toString();

		// add additional test code here
		assertEquals("AlphabetPage", result);
	}

	/**
	 * Run the String toString() method test.
	 * Verify the method returns the string TitlePage
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:54 AM
	 */
	@Test
	public void testToStringTitlePage()
		throws Exception {
		PageName fixture = PageName.TitlePage;

		String result = fixture.toString();

		assertEquals("TitlePage", result);
	}
	/**
	 * Run the String toString() method test.
	 * Verify the method returns the string LetterPage
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:54 AM
	 */
	@Test
	public void testToStringLetterPage()
		throws Exception {
		PageName fixture = PageName.LetterPage;

		String result = fixture.toString();

		assertEquals("LetterPage", result);
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
		new org.junit.runner.JUnitCore().run(PageNameTest.class);
	}
}