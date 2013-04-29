package edu.bu.cs673.AwesomeAlphabet.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.Iterator;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.bu.cs673.AwesomeAlphabet.model.Alphabet;
import edu.bu.cs673.AwesomeAlphabet.model.Letter;
import edu.bu.cs673.AwesomeAlphabet.view.IPageObserver;
import edu.bu.cs673.AwesomeAlphabet.view.MainWindow;

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
	public void testAlphabetPageController() throws Exception {
		IPageObserver pageObserver = EasyMock.createMock(MainWindow.class);
		Alphabet alphabet = EasyMock.createMock(Alphabet.class);

		AlphabetPageController result = new AlphabetPageController(pageObserver, alphabet);
		

		// verify the result
		assertNotNull(result);
		
	
		
	}

	/**
	 * Run the Iterator<Letter> GetLetterIterator() method test.
	 * Verify an iterator object is returned
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:54 AM
	 */
	@SuppressWarnings("unchecked")
	@Test
	public void testGetLetterIterator()	throws Exception {
		MainWindow mainWindow = EasyMock.createMock(MainWindow.class);
		Alphabet alphabet = EasyMock.createMock(Alphabet.class);
		Iterator<Letter> testIterator = EasyMock.createMock(Iterator.class);
		
		EasyMock.expect(alphabet.GetIterator()).andReturn(testIterator);
		EasyMock.replay(alphabet);
		
		AlphabetPageController fixture = new AlphabetPageController(mainWindow, alphabet);
		Iterator<Letter> result = fixture.GetLetterIterator();

		assertNotNull(result);
		EasyMock.verify(alphabet);
	}

	/**
	 * Run the boolean GoToLetterPage(Letter) method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:54 AM
	 */
	@Test
	public void testGoToLetterPageForLetterNull() throws Exception {
		// create mock objects for dependency classes
				MainWindow mainWindow = EasyMock.createMock(MainWindow.class);
				Alphabet alphabet = EasyMock.createMock(Alphabet.class);
				Letter cLetter = EasyMock.createMock(Letter.class);
				
				// set expectation
				EasyMock.expect(alphabet.SetCurrentLetter(cLetter)).andReturn(null);
				EasyMock.replay(alphabet);
				
				
				AlphabetPageController fixture = new AlphabetPageController(mainWindow, alphabet);
				
				

				boolean result = fixture.GoToLetterPage(cLetter);

				// verify results
				EasyMock.verify(alphabet);
				assertEquals(false, result);
	}

	/**
	 * Run the boolean GoToLetterPage(Letter) method test.
	 * Verify that the method return false if page name is not the letter page
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:54 AM
	 */
	@Test
	public void testGoToLetterPageIsFalseIfRequestedPageIsNotLetterPage() throws Exception {
		MainWindow mainWindow = EasyMock.createMock(MainWindow.class);
		Alphabet alphabet = EasyMock.createMock(Alphabet.class);
		
		Letter cLetter = EasyMock.createMock(Letter.class);
		
		EasyMock.expect(alphabet.SetCurrentLetter(cLetter)).andReturn(cLetter);
		EasyMock.expect(mainWindow.GoToPage("LetterPage")).andReturn(false);
		
		
		EasyMock.replay(mainWindow);
		EasyMock.replay(alphabet);
	
		AlphabetPageController fixture = new AlphabetPageController(mainWindow, alphabet);
		
		

		boolean result = fixture.GoToLetterPage(cLetter);

		// add additional test code here
		EasyMock.verify(alphabet);
		EasyMock.verify(mainWindow);
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
	public void testGoToLetterPageReturnTrueForValidLetter()throws Exception {
		MainWindow mainWindow = EasyMock.createMock(MainWindow.class);
		Alphabet alphabet = EasyMock.createMock(Alphabet.class);
		
		Letter cLetter = EasyMock.createMock(Letter.class);
		
		EasyMock.expect(alphabet.SetCurrentLetter(cLetter)).andReturn(cLetter);
		EasyMock.expect(mainWindow.GoToPage("LetterPage")).andReturn(true);
		
		alphabet.StopAlphabetSound();
		cLetter.playSoundLetter();
		EasyMock.expectLastCall().atLeastOnce();
		
		EasyMock.replay(mainWindow);
		EasyMock.replay(alphabet);
	
		AlphabetPageController fixture = new AlphabetPageController(mainWindow, alphabet);
		
		

		boolean result = fixture.GoToLetterPage(cLetter);

		
		EasyMock.verify(alphabet);
		EasyMock.verify(mainWindow);
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
	public void testGoToTitlePageReturnTrueForValidPage()	throws Exception {
		MainWindow mainWindow = EasyMock.createMock(MainWindow.class);
		Alphabet alphabet = EasyMock.createMock(Alphabet.class);
		
		
		EasyMock.expect(mainWindow.GoToPage("TitlePage")).andReturn(true);
		
		alphabet.StopAlphabetSound();
		EasyMock.expectLastCall().atLeastOnce();
		
		EasyMock.replay(mainWindow);
		EasyMock.replay(alphabet);
	
		AlphabetPageController fixture = new AlphabetPageController(mainWindow, alphabet);
		
		

		boolean result = fixture.GoToTitlePage(); //.GoToTitlePage(cLetter);

		
		EasyMock.verify(alphabet);
		EasyMock.verify(mainWindow);
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
	public void testGoToTitlePageReturnFalseForInvalidPage()	throws Exception {
		MainWindow mainWindow = EasyMock.createMock(MainWindow.class);
		Alphabet alphabet = EasyMock.createMock(Alphabet.class);
		
		
		EasyMock.expect(mainWindow.GoToPage("TitlePage")).andReturn(false);
		
		alphabet.StopAlphabetSound();
		EasyMock.expectLastCall().atLeastOnce();
		
		EasyMock.replay(mainWindow);
		EasyMock.replay(alphabet);
	
		AlphabetPageController fixture = new AlphabetPageController(mainWindow, alphabet);
		
		

		boolean result = fixture.GoToTitlePage(); //.GoToTitlePage(cLetter);

		
		EasyMock.verify(alphabet);
		EasyMock.verify(mainWindow);
		assertEquals(false, result);
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