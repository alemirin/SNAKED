import java.lang.Math;

public abstract class Player implements Sprite {
	Dot head;
	
	//movement
  int velocityX;
  int velocityY;
	
	public Player(Dot head) {
		this.head = head;
		this.velocityX = 0;
		this.velocityY = 0;
	}
	
	public void move() {
		this.head.setX(this.head.getX() + this.velocityX);
		this.head.setY(this.head.getY() + this.velocityY);
	}
	
	public void setVelocityX(int v) {
		this.velocityX = v;
	}
	
	public void setVelocityY(int v) {
		this.velocityY = v;
	}
	
	public int getVelocityX() {
		return this.velocityX;
	}
	
	public int getVelocityY() {
		return this.velocityY;
	}
	
	public boolean checkCollision(Dot dot1, Dot dot2) {
		return Math.abs(dot1.getX() - dot2.getX()) < GameConstants.DOT_SIZE 
				&& Math.abs(dot1.getY() - dot2.getY()) < GameConstants.DOT_SIZE;
	}
	
}
