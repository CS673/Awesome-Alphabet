package edu.bu.cs673.AwesomeAlphabet.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import edu.bu.cs673.AwesomeAlphabet.view.PageView;


/**
 * This Class handles user actions on the buttons on the GUI
 */
public class ButtonHandler implements ActionListener {

	private PageView pv;
	private Method method;
	static Logger log = Logger.getLogger(ButtonHandler.class);
	
	/**
	 * Constructor for ButtonHandler.
	 * @param pv PageView
	 * @param method String
	 */
	public ButtonHandler(PageView pv, String method) {
		try {
			this.pv = pv;
			this.method = pv.getClass().getMethod(method);
		} catch (Exception e) {
			this.method = null;
			log.error("An exception occurred while setting the page view method for "+pv.getPageName());
			log.error(e.getMessage());
			e.printStackTrace();
		}
	}
	
	/**
	 * Method actionPerformed.
	 * @param ae ActionEvent
	 * @see java.awt.event.ActionListener#actionPerformed(ActionEvent)
	 */
	public void actionPerformed(ActionEvent ae) {
		if (method != null) {
			try {
				method.invoke(pv);
			} catch (Exception e) {
				log.error("An exception occurred while invoking the " + method + " method for "+pv.getPageName());
				log.error(e.getMessage());
				e.printStackTrace();
			}
		}
	}
}
