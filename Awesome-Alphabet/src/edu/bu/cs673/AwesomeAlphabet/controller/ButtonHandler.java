package edu.bu.cs673.AwesomeAlphabet.controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.Method;

import edu.bu.cs673.AwesomeAlphabet.view.PageView;


public class ButtonHandler implements ActionListener {

	private PageView pv;
	private Method method;
	
	public ButtonHandler(PageView pv, String method) {
		try {
			this.pv = pv;
			this.method = pv.getClass().getMethod(method);
		} catch (Exception e) {
			this.method = null;
		}
	}
	
	public void actionPerformed(ActionEvent ae) {
		if (method != null) {
			try {
				method.invoke(pv);
			} catch (Exception e) {
				// do nothing.
			}
		}
	}
}
