import java.util.ArrayList;

public class Snake extends Player {
	ArrayList<Dot> body;
	SnakeModel model;

	public Snake(Dot head, SnakeModel model) {
		super(head);
		body = new ArrayList<Dot>();
		this.model = model;
	}
	
	public void move(ArrayList<Items> items) {
		//Check for collision with any item on screen
		for (int i = 0; i < model.getItemList().size(); i++) {
			Items item = model.getItemList().get(i);
			if (checkCollision(head, item.getLoc())) {
				if (item instanceof Apple) {
					model.addPoint();
					body.add(item.getLoc());
					model.getItemList().remove(i);
					model.loadNewItem();
				} else if (item instanceof Hamburger) {
					model.addPoint();
					model.addPoint();
					body.add(item.getLoc());
					body.add(item.getLoc());
					model.getItemList().remove(i);
					model.loadNewItem();
				} else if (item instanceof Poison) {
					if (body.size() < 3 || model.getScore() <= 2) {
						model.GameOver();
					} else {
						model.losePoint();
						model.losePoint();
						body.remove(1);
						body.remove(0);
						model.getItemList().remove(i);
						model.loadNewItem();
					}
				}
			}
		}
		
		//Move snake body
		for (int i = body.size() - 1; i >= 0; i--) {
			Dot bodyPart = body.get(i);
			
			// if we are at the body part right after the head, make it follow the head
			if (i == 0) {
				bodyPart.setX(this.head.getX());
				bodyPart.setY(this.head.getY());
			}
			//else, follow the previous body part
			else {
				Dot prevBodyPart = body.get(i - 1);
				bodyPart.setX(prevBodyPart.getX());
				bodyPart.setY(prevBodyPart.getY());
			}
		}
		
		//move head by resetting value based on velocity
		this.head.setX(this.head.getX() + this.velocityX);
		this.head.setY(this.head.getY() + this.velocityY);
		
		
		//Loss Conditions
		//Checking if snake collided with own body
		for (int i = 0; i < body.size(); i++) {
			Dot bodyPart = body.get(i);
			if (checkCollision(head, bodyPart)) {
				model.GameOver();
			}
		}
		
		//edge of screen check
		if (head.getX() < 0 || 
				head.getY() < 0 || 
				head.getX() > GameConstants.SCREEN_WIDTH - GameConstants.DOT_SIZE ||
				head.getY() > GameConstants.SCREEN_HEIGHT - (GameConstants.DOT_SIZE*3)) {
			model.GameOver();
		}
		
		//check if window is completely filled with dots
		if (model.getSnakeSize() + model.getAmountOfItems() > GameConstants.MAX_SIZE) {
			model.GameOver();
		}
	}
	
	
	
	public Dot getHead() {
		return this.head;
	}
	
	public ArrayList<Dot> getBody() {
		return this.body;
	}
	

}
