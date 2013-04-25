package edu.bu.cs673.AwesomeAlphabet.controller;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.easymock.EasyMock;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import edu.bu.cs673.AwesomeAlphabet.view.IPageObserver;
import edu.bu.cs673.AwesomeAlphabet.view.TitlePageView;

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
	public void testTitlePageController() 	throws Exception {
		IPageObserver pageObserver = EasyMock.createMock(IPageObserver.class);
		TitlePageView view =  EasyMock.createMock(TitlePageView.class);

		TitlePageController result = new TitlePageController(pageObserver, view);
		
		
		assertNotNull(result);

	}

	/**
	 * Run the boolean Start() method test.
	 *
	 * @throws Exception
	 *
	 * @generatedBy CodePro at 2/22/13 1:46 AM
	 */
	@Test
	public void testStartForValidValue() throws Exception {
		IPageObserver pageObserver = EasyMock.createMock(IPageObserver.class);
		TitlePageView view =  EasyMock.createMock(TitlePageView.class);

		EasyMock.expect(pageObserver.GoToPage("AlphabetPage")).andReturn(true);
		
		//alphabet.StopAlphabetSound();
		//EasyMock.expectLastCall().atLeastOnce();
		
		EasyMock.replay(pageObserver);
		//EasyMock.replay(alphabet);
		
		TitlePageController fixture = new TitlePageController(pageObserver, view);

		boolean result = fixture.Start();

		// add additional test code here
		EasyMock.verify(pageObserver);
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
	public void testStartForInvalidValue()	throws Exception {
		IPageObserver pageObserver = EasyMock.createMock(IPageObserver.class);
		TitlePageView view =  EasyMock.createMock(TitlePageView.class);

		EasyMock.expect(pageObserver.GoToPage("AlphabetPage")).andReturn(false);
		
		//alphabet.StopAlphabetSound();
		//EasyMock.expectLastCall().atLeastOnce();
		
		EasyMock.replay(pageObserver);
		//EasyMock.replay(alphabet);
		
		TitlePageController fixture = new TitlePageController(pageObserver, view);

		boolean result = fixture.Start();

		// add additional test code here
		EasyMock.verify(pageObserver);
		assertEquals(false, result);
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