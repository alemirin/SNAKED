
public class ScoreController implements Controller{
	
	iView view;
	SnakeModel model;
	
	public ScoreController(iView view, SnakeModel model) {
		this.view = view;
		this.model = model;
		this.view.setController(this);
	}
	
	@Override
	public void go() {
		((ScoreView) view).showWindow();	
		
	}

	@Override
	public SnakeModel getModel() {
		return this.model;
	}
	
	public void goToMenu() {
		((ScoreView) view).closeWindow();
		model.reset();
		MenuView mv = new MenuView(model);
		MenuController m = new MenuController(mv, model);
		mv.setController(m);
		m.go();
	}
	
	

}
