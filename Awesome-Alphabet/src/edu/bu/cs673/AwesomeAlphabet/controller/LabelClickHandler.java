package edu.bu.cs673.AwesomeAlphabet.controller;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.lang.reflect.Method;

import edu.bu.cs673.AwesomeAlphabet.view.PageView;

public class LabelClickHandler implements MouseListener {

	private PageView pv;
	private Method method;
	
	public LabelClickHandler(PageView pv, String method) {
		try {
			this.pv = pv;
			this.method = pv.getClass().getMethod(method);
		} catch (Exception e) {
			this.method = null;
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if (method != null) {
			try {
				method.invoke(pv);
			} catch (Exception ex) {
				// do nothing.
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Do Nothing	
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// Do Nothing
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// Do Nothing
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// Do Nothing
	}
}
