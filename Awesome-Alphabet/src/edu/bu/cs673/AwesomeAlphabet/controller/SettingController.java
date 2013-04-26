package edu.bu.cs673.AwesomeAlphabet.controller;

import org.apache.log4j.Logger;

import edu.bu.cs673.AwesomeAlphabet.main.Settings;
import edu.bu.cs673.AwesomeAlphabet.model.Alphabet;
import edu.bu.cs673.AwesomeAlphabet.model.PageName;
import edu.bu.cs673.AwesomeAlphabet.view.IPageObserver;

public class SettingController extends PageController {

	static Logger log = Logger.getLogger(SettingController.class);
	Alphabet alphabet;
	
	public SettingController(Alphabet pAlphabet, IPageObserver pageObserver) {
		super(pageObserver);
		alphabet = pAlphabet;
	}

	public void GoToOptionsMenu() {
		GoToPage(PageName.OptionsPage);
	}

	public void updateDisplayOrder(String displayOder) {
		log.info("updating the display order");
		Settings.props.setProperty(Settings.DISPLAY_ORDER, displayOder);
		if(Settings.getDisplayOrder().equalsIgnoreCase("Sorted")){
			alphabet.sortLetterExamples();
		}else if(Settings.getDisplayOrder().equalsIgnoreCase("Shuffle")){
			alphabet.shuffleExamples();
		}else{
			alphabet.resetListOrder();
		}
		
		Settings.saveSettingProperties();
	}

	public void updateMaxExamples(int limit) {
		
		log.info("updating number of examples to display");
		if(limit == 0){
			limit = Integer.MAX_VALUE;
		}
		
		String limitStringValue = String.valueOf(limit);
		Settings.props.setProperty(Settings.MAXIMUM_EXAMPLES, limitStringValue);
		
		Settings.saveSettingProperties();
	}
}
