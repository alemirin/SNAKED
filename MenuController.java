

public class MenuController implements Controller {
	
	iView view;
	SnakeModel model;
	
	public MenuController(iView view, SnakeModel model) {
		this.view = view;
		this.model = model;
		//You've got to make a connection to pass communication between event controllers
		this.view.setController(this);
	}
	
	
	
	@Override
	public void go() {
		((MenuView) view).showWindow();	
	}
	
	//for start button
	public void start() {
		((MenuView) view).closeWindow();
		GameView gv = new GameView(model, GameConstants.DELAY);
		GameController g = new GameController(gv, model);
		gv.requestFocus();
		g.go();
	}
	
	public void startHard() {
		((MenuView) view).closeWindow();
		GameView gv = new GameView(model, GameConstants.FAST_DELAY);
		GameController g = new GameController(gv, model);
		gv.requestFocus();
		g.go();
	}
	
	public void startInsane() {
		((MenuView) view).closeWindow();
		GameView gv = new GameView(model, GameConstants.INSANE_DELAY);
		GameController g = new GameController(gv, model);
		gv.requestFocus();
		g.go();
	}
	
	
	//to access score page
	public void showScores() {
		((MenuView) view).closeWindow();
		ScoreView sv = new ScoreView(model);
		ScoreController s = new ScoreController(sv, model);
		sv.setController(s);
		s.go();
	}

	@Override
	public SnakeModel getModel() {
		return this.model;
	}
}


