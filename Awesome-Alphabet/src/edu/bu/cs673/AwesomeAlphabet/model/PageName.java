package edu.bu.cs673.AwesomeAlphabet.model;

public enum PageName {
	
	TitlePage    ("TitlePage"),
	AlphabetPage ("AlphabetPage"),
	LetterPage   ("LetterPage");
	
	private final String stringValue;
	private PageName(final String s) { stringValue = s; }
	public String toString() { return stringValue; }
}