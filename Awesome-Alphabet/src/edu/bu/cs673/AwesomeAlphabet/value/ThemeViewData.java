package edu.bu.cs673.AwesomeAlphabet.value;

public class ThemeViewData {
	
	private final String themeName;
	private final boolean editable;
	private final int count;
	
	public ThemeViewData(String themeName, boolean editable, int count) {
		this.themeName = themeName;
		this.editable = editable;
		this.count = count;
	}
	
	public String name() {
		return themeName;
	}

	public boolean editable() {
		return editable;
	}
	
	public int count() {
		return count;
	}
}
