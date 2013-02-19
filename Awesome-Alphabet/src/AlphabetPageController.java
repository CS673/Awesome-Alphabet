import java.util.Iterator;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;


public class AlphabetPageController extends PageController {

	private AlphabetPageView m_view;
	private Alphabet m_alphabet;
	
	
	public AlphabetPageController(IPageObserver pageObserver, AlphabetPageView view, Alphabet alphabet) {
		super(pageObserver);

		m_view = view;
		m_alphabet = alphabet;
		
		m_view.SetController(this);
	}
	
	public Iterator<Letter> GetLetterIterator()
	{
		return m_alphabet.GetIterator();
	}
	
	public boolean PlayAlphabetSong()
	{
		//TODO: Implement this method
		throw new NotImplementedException();
	}
	
	public boolean GoToTitlePage()
	{
		return GoToPage(PageName.TitlePage);
	}
	
	public boolean GoToLetterPage(Letter cLetter)
	{
		if (m_alphabet.SetCurrentLetter(cLetter) != null)
			return GoToPage(PageName.LetterPage);
		else
			return false;
	}
}
