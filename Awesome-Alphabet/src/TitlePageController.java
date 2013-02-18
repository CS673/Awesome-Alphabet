
public class TitlePageController extends PageController {

	private TitlePageView m_view;
	
	
	public TitlePageController(IPageObserver pageObserver, TitlePageView view) {
		super(pageObserver);

		m_view = view;
		view.SetController(this);
	}
	
	public boolean Start()
	{
		return GoToPage(PageName.AlphabetPage);
	}
}
