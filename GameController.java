

public class GameController implements Controller{
	
	iView view;
	SnakeModel model;
	
	public GameController(iView view, SnakeModel model) {
		this.view = view;
		this.model = model;
		this.view.setController(this);
	}

	@Override
	public void go() {
		((GameView) view).showWindow();	
	}
	
	public SnakeModel getModel() {
		return this.model;
	}
	
	public void goToMenu() {
		((GameView) view).closeWindow();
		model.reset();
		MenuView mv = new MenuView(model);
		MenuController m = new MenuController(mv, model);
		mv.setController(m);
		m.go();
	}

}
