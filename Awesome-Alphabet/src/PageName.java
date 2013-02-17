
public enum PageName {
	
	TitlePage   ("TitlePage"),
	AphabetPage ("AlphabetPage"),
	LetterPage  ("LetterPage");
	
	private final String stringValue;
	private PageName(final String s) { stringValue = s; }
	public String toString() { return stringValue; }
}
