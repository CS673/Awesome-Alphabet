package edu.bu.cs673.AwesomeAlphabet.view;

import java.util.Observer;
import edu.bu.cs673.AwesomeAlphabet.controller.ThemeController;



/**
 *  This interface defines a Theme Controller View.
 *  Any view that wants to use the ThemeController must
 *  implement this interface.
 */
public interface IThemeControllerView extends Observer {

	public void SetController(ThemeController controller);
}
