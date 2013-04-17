package edu.bu.cs673.AwesomeAlphabet.view;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import javax.swing.table.AbstractTableModel;

import edu.bu.cs673.AwesomeAlphabet.value.WPSViewData;

public class WPSTableModel extends AbstractTableModel {
	private static final long serialVersionUID = -6728415049308133929L;
	
	private static final String[] columnNames = new String[] { "Word", "Letter", "Theme" };
	ArrayList<WPSViewData> m_words = new ArrayList<WPSViewData>();

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}
	
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return m_words.size();
	}

	@Override
	public Object getValueAt(int row, int col) {
		WPSViewData data = m_words.get(row);
		switch (col) {
		case 0: return data.m_word;
		case 1: return data.m_letter;
		case 2: return data.m_themeName;
		}
		return null;
	}
	
	public void sort() {
		Collections.sort(m_words, new Comparator<WPSViewData>() {
			public int compare(WPSViewData a, WPSViewData b) {
				int wordCompare = a.m_letter.compareToIgnoreCase(b.m_letter);
				if (wordCompare == 0)
					wordCompare = a.m_word.compareToIgnoreCase(b.m_word);
				return wordCompare;
			}
		});
	}
	
	public void removeAllElements() {
		m_words = new ArrayList<WPSViewData>();
	}

	public void addElement(WPSViewData wpsViewData) {
		m_words.add(wpsViewData);
	}

	public String getSelectedWord(int selectedRow) {
		return m_words.get(selectedRow).m_word;
	}

}
