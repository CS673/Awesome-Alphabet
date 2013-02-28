package edu.bu.cs673.AwesomeAlphabet.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Method;

import org.apache.log4j.Logger;

import edu.bu.cs673.AwesomeAlphabet.view.PageView;

/**
 */
public class LabelClickHandler implements MouseListener {

	private PageView pv;
	private Method method;
	static Logger log = Logger.getLogger(LabelClickHandler.class);
	
	/**
	 * Constructor for LabelClickHandler.
	 * @param pv PageView
	 * @param method String
	 */
	public LabelClickHandler(PageView pv, String method) {
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
	 * Method mouseClicked.
	 * @param e MouseEvent
	 * @see java.awt.event.MouseListener#mouseClicked(MouseEvent)
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		if (method != null) {
			try {
				method.invoke(pv);
			} catch (Exception ex) {
				log.error("An exception occurred while invoking the page view method for "+pv.getPageName());
				log.error(ex.getMessage());
				ex.printStackTrace();
			}
		}
	}

	/**
	 * Method mouseEntered.
	 * @param e MouseEvent
	 * @see java.awt.event.MouseListener#mouseEntered(MouseEvent)
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// Do Nothing	
	}

	/**
	 * Method mouseExited.
	 * @param e MouseEvent
	 * @see java.awt.event.MouseListener#mouseExited(MouseEvent)
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// Do Nothing
	}

	/**
	 * Method mousePressed.
	 * @param e MouseEvent
	 * @see java.awt.event.MouseListener#mousePressed(MouseEvent)
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// Do Nothing
	}

	/**
	 * Method mouseReleased.
	 * @param e MouseEvent
	 * @see java.awt.event.MouseListener#mouseReleased(MouseEvent)
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// Do Nothing
	}
}
