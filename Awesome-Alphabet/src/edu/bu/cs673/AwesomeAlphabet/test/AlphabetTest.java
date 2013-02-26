package edu.bu.cs673.AwesomeAlphabet.test;

import java.util.Iterator;
import java.util.Observable;

import edu.bu.cs673.AwesomeAlphabet.model.Alphabet;
import edu.bu.cs673.AwesomeAlphabet.model.Letter;
import edu.bu.cs673.AwesomeAlphabet.view.AlphabetPageView;
import java.util.Observer;
import java.util.Properties;
import org.junit.*;
import static org.junit.Assert.*;

/**
 * The class <code>AlphabetTest</code> contains tests for the class <code>{@link Alphabet}</code>.
 *
 * @generatedBy CodePro at 2/22/13 1:46 AM
 * @author Levi
 * @version $Revision: 1.0 $
 */
public class AlphabetTest {
	/**
	 * Run the Alphabet() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testAlphabet_1()
		throws Exception {

		Alphabet result = new Alphabet();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.GoToPreviousLetter());
		assertEquals(false, result.hasChanged());
		assertEquals(0, result.countObservers());
	}

	/**
	 * Run the Alphabet() constructor test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testAlphabet_2()
		throws Exception {

		Alphabet result = new Alphabet();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.GoToPreviousLetter());
		assertEquals(false, result.hasChanged());
		assertEquals(0, result.countObservers());
	}

	/**
	 * Run the Letter GetCurrentLetter() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testGetCurrentLetter_1()
		throws Exception {
		Alphabet fixture = new Alphabet();
		fixture.m_iCurLetterIndex = 1;
		fixture.addObserver(new AlphabetPageView(""));

		Letter result = fixture.GetCurrentLetter();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getWord());
		assertEquals('B', result.GetUppercaseLetter());
		assertEquals('b', result.GetLetterAsChar());
		assertEquals(false, result.hasChanged());
		assertEquals(0, result.countObservers());
	}

	/**
	 * Run the Iterator<Letter> GetIterator() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testGetIterator_1()
		throws Exception {
		Alphabet fixture = new Alphabet();
		fixture.m_iCurLetterIndex = 1;
		fixture.addObserver(new AlphabetPageView(""));

		Iterator<Letter> result = fixture.GetIterator();

		// add additional test code here
		assertNotNull(result);
		assertEquals(true, result.hasNext());
	}

	/**
	 * Run the Letter GoToNextLetter() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testGoToNextLetter_1()
		throws Exception {
		Alphabet fixture = new Alphabet();
		fixture.m_iCurLetterIndex = 1;
		fixture.addObserver(new AlphabetPageView(""));

		Letter result = fixture.GoToNextLetter();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getWord());
		assertEquals('C', result.GetUppercaseLetter());
		assertEquals('c', result.GetLetterAsChar());
		assertEquals(false, result.hasChanged());
		assertEquals(0, result.countObservers());
	}

	/**
	 * Run the Letter GoToNextLetter() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testGoToNextLetter_2()
		throws Exception {
		Alphabet fixture = new Alphabet();
		fixture.m_iCurLetterIndex = 1;
		fixture.addObserver(new AlphabetPageView(""));

		Letter result = fixture.GoToNextLetter();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getWord());
		assertEquals('C', result.GetUppercaseLetter());
		assertEquals('c', result.GetLetterAsChar());
		assertEquals(false, result.hasChanged());
		assertEquals(0, result.countObservers());
	}

	/**
	 * Run the Letter GoToPreviousLetter() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testGoToPreviousLetter_1()
		throws Exception {
		Alphabet fixture = new Alphabet();
		fixture.m_iCurLetterIndex = 0;
		fixture.addObserver(new AlphabetPageView(""));

		Letter result = fixture.GoToPreviousLetter();

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Letter GoToPreviousLetter() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testGoToPreviousLetter_2()
		throws Exception {
		Alphabet fixture = new Alphabet();
		fixture.m_iCurLetterIndex = 1;
		fixture.addObserver(new AlphabetPageView(""));

		Letter result = fixture.GoToPreviousLetter();

		// add additional test code here
		assertNotNull(result);
		assertEquals(null, result.getWord());
		assertEquals('A', result.GetUppercaseLetter());
		assertEquals('a', result.GetLetterAsChar());
		assertEquals(false, result.hasChanged());
		assertEquals(0, result.countObservers());
	}

	/**
	 * Run the void LoadResources(Properties) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testLoadResources_1()
		throws Exception {
		Alphabet fixture = new Alphabet();
		fixture.m_iCurLetterIndex = 1;
		fixture.addObserver(new AlphabetPageView(""));
		Properties prop = new Properties();

		fixture.LoadResources(prop);

		// add additional test code here
	}

	/**
	 * Run the void LoadResources(Properties) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testLoadResources_2()
		throws Exception {
		Alphabet fixture = new Alphabet();
		fixture.m_iCurLetterIndex = 1;
		fixture.addObserver(new AlphabetPageView(""));
		Properties prop = new Properties();

		fixture.LoadResources(prop);

		// add additional test code here
	}

	/**
	 * Run the void LoadResources(Properties) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testLoadResources_3()
		throws Exception {
		Alphabet fixture = new Alphabet();
		fixture.m_iCurLetterIndex = 1;
		fixture.addObserver(new AlphabetPageView(""));
		Properties prop = new Properties();

		fixture.LoadResources(prop);

		// add additional test code here
	}

	/**
	 * Run the void LoadResources(Properties) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testLoadResources_4()
		throws Exception {
		Alphabet fixture = new Alphabet();
		fixture.m_iCurLetterIndex = 1;
		fixture.addObserver(new AlphabetPageView(""));
		Properties prop = new Properties();

		fixture.LoadResources(prop);

		// add additional test code here
	}

	/**
	 * Run the void LoadResources(Properties) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testLoadResources_5()
		throws Exception {
		Alphabet fixture = new Alphabet();
		fixture.m_iCurLetterIndex = 1;
		fixture.addObserver(new AlphabetPageView(""));
		Properties prop = new Properties();

		fixture.LoadResources(prop);

		// add additional test code here
	}

	/**
	 * Run the void LoadResources(Properties) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testLoadResources_6()
		throws Exception {
		Alphabet fixture = new Alphabet();
		fixture.m_iCurLetterIndex = 1;
		fixture.addObserver(new AlphabetPageView(""));
		Properties prop = new Properties();

		fixture.LoadResources(prop);

		// add additional test code here
	}

	/**
	 * Run the Letter SetCurrentLetter(Letter) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testSetCurrentLetter_1()
		throws Exception {
		Alphabet fixture = new Alphabet();
		fixture.m_iCurLetterIndex = 1;
		fixture.addObserver(new AlphabetPageView(""));
		Letter cLetter = new Letter('');

		Letter result = fixture.SetCurrentLetter(cLetter);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Letter SetCurrentLetter(Letter) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testSetCurrentLetter_2()
		throws Exception {
		Alphabet fixture = new Alphabet();
		fixture.m_iCurLetterIndex = 1;
		fixture.addObserver(new AlphabetPageView(""));
		Letter cLetter = new Letter('');

		Letter result = fixture.SetCurrentLetter(cLetter);

		// add additional test code here
		assertEquals(null, result);
	}

	/**
	 * Run the Letter SetCurrentLetter(Letter) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testSetCurrentLetter_3()
		throws Exception {
		Alphabet fixture = new Alphabet();
		fixture.m_iCurLetterIndex = 1;
		fixture.addObserver(new AlphabetPageView(""));
		Letter cLetter = new Letter('');

		Letter result = fixture.SetCurrentLetter(cLetter);

		// add additional test code here
		assertEquals(null, result);
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
		new org.junit.runner.JUnitCore().run(AlphabetTest.class);
	}
}