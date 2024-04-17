import java.util.Random;

public abstract class Items implements Sprite {
	Dot item;
	
	
	public Items() {
		this.appear();
	}
	
	public Dot getLoc() {
		return this.item;
	}
	
	public void appear() {
		Random rand = new Random();
		
		this.item = new Dot();
		
		int rand_x = rand.nextInt(GameConstants.SCREEN_WIDTH/GameConstants.DOT_SIZE) * GameConstants.DOT_SIZE - GameConstants.DOT_SIZE;
		int rand_y = rand.nextInt(GameConstants.SCREEN_HEIGHT/GameConstants.DOT_SIZE) * GameConstants.DOT_SIZE - (GameConstants.DOT_SIZE*3);
		
		if (rand_x < 0) {
			rand_x = 0;
		}
		if (rand_y < 0) {
			rand_y = 0;
		}
		
		this.item.setX(rand_x);
		this.item.setY(rand_y);
	}
	
	public boolean checkCollision(Dot dot1, Dot dot2) {
		return Math.abs(dot1.getX() - dot2.getX()) < GameConstants.DOT_SIZE 
				&& Math.abs(dot1.getY() - dot2.getY()) < GameConstants.DOT_SIZE;
	}
	
}
