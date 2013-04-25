package edu.bu.cs673.AwesomeAlphabet.model;

import org.junit.*;

import edu.bu.cs673.AwesomeAlphabet.model.Version;
import static org.junit.Assert.*;

/**
 * The class <code>VersionTest</code> contains tests for the class <code>{@link Version}</code>.
 *
 * @generatedBy CodePro at 2/22/13 1:54 AM
 * @author Levi
 * @version $Revision: 1.0 $
 */
public class VersionTest {
	/**
	 * Run the getVersion() constructor test.
	 *Verify that the method returns the application version
	 *
	 * @generatedBy CodePro at 2/22/13 1:54 AM
	 */
	@Test
	public void testGetVersion()
		throws Exception {
		Version result = new Version();
		assertNotNull(result);
		
		assertTrue(!result.getVersion().isEmpty());
	}

	/**
	 * Run the getVersion() constructor test.
	 * Verify that the method returns the application name
	 * 
	 * @throws Exception
	 */
	@Test
	public void testGetAppName()
		throws Exception {
		Version result = new Version();
		assertNotNull(result);
		
		assertEquals("Awesome Alphabet", result.getAppName());
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
		new org.junit.runner.JUnitCore().run(VersionTest.class);
	}
}