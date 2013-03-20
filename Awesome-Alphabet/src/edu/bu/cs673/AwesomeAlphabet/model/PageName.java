package edu.bu.cs673.AwesomeAlphabet.model;

/**
 * This enumeration defines the page names for each view.
 * To get the name as a String, use the toString() method.
 */
public enum PageName {
	
	TitlePage    ("TitlePage"),
	AlphabetPage ("AlphabetPage"),
	LetterPage   ("LetterPage"),
	OptionsPage	 ("OptionsPage");
	
	private final String stringValue;
	private PageName(final String s) { stringValue = s; }
	public String toString() { return stringValue; }
}
