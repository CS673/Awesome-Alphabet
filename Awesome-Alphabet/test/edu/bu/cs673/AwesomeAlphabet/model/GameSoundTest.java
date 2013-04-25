package edu.bu.cs673.AwesomeAlphabet.model;

import org.junit.*;
import org.junit.rules.ExpectedException;

import edu.bu.cs673.AwesomeAlphabet.model.GameSound;
import static org.junit.Assert.*;

/**
 * The class <code>GameSoundTest</code> contains tests for the class <code>{@link GameSound}</code>.
 *
 * @generatedBy CodePro at 2/22/13 1:38 AM
 * @author Levi
 * @version $Revision: 1.0 $
 */
public class GameSoundTest {
	/**
	 * Run the GameSound(String) constructor test.
	 * Verify that the constructor creates an object
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:38 AM
	 */
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test
	public void testGameSoundConstructor()
		throws Exception {
		String soundfilepath = "testSoundPath";

		GameSound result = new GameSound(soundfilepath);

		assertNotNull(result);
	}

	/**
	 * Run the void PlaySound() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:38 AM
	 */
	@Test
	public void testPlaySoundForInvalidParameter()throws Exception {
		GameSound fixture = new GameSound("");

		//TODO modify the code to have this error thrown? It's currently being caught and written to the log
		
		//exception.expect(UnsupportedAudioFileException.class);  
		
		fixture.PlaySound();
	}

	/**
	 * Run the void PlaySound() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:38 AM
	 */
	@Test
	public void testPlaySoundInvalidSoundFile()	throws Exception {
		
		GameSound fixture = new GameSound("testSound");
		
		//exception.expect(NullPointerException.class);
		
		fixture.PlaySound();
	}

	/**
	 * Run the void PlaySound() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:38 AM
	 */
	@Test
	public void testPlaySound_1()
		throws Exception {
		GameSound fixture = new GameSound("");

		fixture.PlaySound();

		// add additional test code here
	}

	/**
	 * Perform pre-test initialization.
	 *
	 * @throws Exception
	 *         if the initialization fails for some reason
	 *
	 * @generatedBy CodePro at 2/22/13 1:38 AM
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
	 * @generatedBy CodePro at 2/22/13 1:38 AM
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
	 * @generatedBy CodePro at 2/22/13 1:38 AM
	 */
	public static void main(String[] args) {
		new org.junit.runner.JUnitCore().run(GameSoundTest.class);
	}
}