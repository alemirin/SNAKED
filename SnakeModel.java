import java.util.ArrayList;
import java.util.Random;
import java.util.stream.Stream;

public class SnakeModel {
  private ArrayList<Items> items;
  private boolean gameOver;
  private Snake snakeHead;
  private int score;
  static ArrayList<Integer> scores;
  
  
  
  public SnakeModel() {
    this.gameOver = false;
    int x = GameConstants.SCREEN_WIDTH/2 - GameConstants.DOT_SIZE;
    int y = GameConstants.SCREEN_HEIGHT/2 - GameConstants.DOT_SIZE;
    this.snakeHead = new Snake(new Dot(x, y), this);
    this.items = new ArrayList<Items>();
    scores = new ArrayList<Integer>();
    loadNewItem();
  }
  
  public Snake getSnake() {
  	return this.snakeHead;
  }
  
  public void addPoint() {
  	this.score++;
  }
  
  public void losePoint() {
  	this.score--;
  }
  
  public ArrayList<Items> getItemList() {
  	return this.items;
  }
  
  public void loadNewItem() {
  	Random rand = new Random();
  	int rand_item = rand.nextInt(3);
		switch (rand_item) {
		case 0:
			Items item = new Apple();
			for (int i = 0; i < snakeHead.getBody().size(); i++) {
				if (snakeHead.checkCollision(snakeHead.getBody().get(i), item.getLoc())) {
					loadNewItem();
					break;
				}
			}
			this.items.add(item);
			break;
		case 1:
			Items item1 = new Hamburger();
			for (int i = 0; i < snakeHead.getBody().size(); i++) {
				if (snakeHead.checkCollision(snakeHead.getBody().get(i), item1.getLoc())){
					loadNewItem();
					break;
				}
			}
			this.items.add(item1);
			break;
		case 2:
			Items item2 = new Poison();
			for (int i = 0; i < snakeHead.getBody().size(); i++) {
				if (snakeHead.checkCollision(snakeHead.getBody().get(i), item2.getLoc())){
					loadNewItem();
					break;
				}
			}
			this.items.add(item2);
			Items item3 = new Apple();
			for (int i = 0; i < snakeHead.getBody().size(); i++) {
				if (snakeHead.checkCollision(snakeHead.getBody().get(i), item3.getLoc())){
					loadNewItem();
					break;
				}
			}
			this.items.add(item3);
			break;
		default:
			Items item4 = new Apple();
			for (int i = 0; i < snakeHead.getBody().size(); i++) {
				if (snakeHead.checkCollision(snakeHead.getBody().get(i), item4.getLoc())){
					loadNewItem();
					break;
				}
			}
			this.items.add(item4);
			break;
		}
  }
  
  public void GameOver() {
  	this.gameOver = true;
  	scores.add(this.score);
  }
  
  public boolean checkGameOver() {
  	return this.gameOver;
  }
  
  public int getScore() {
  	return this.score;
  }
  
  public void reset() {
  	this.score = 0;
  	gameOver = false;
    int x = GameConstants.SCREEN_WIDTH/2 - GameConstants.DOT_SIZE;
    int y = GameConstants.SCREEN_HEIGHT/2 - GameConstants.DOT_SIZE;
    snakeHead = new Snake(new Dot(x, y), this);
    items = new ArrayList<Items>();
    loadNewItem();
  }
  
  public ArrayList<Integer> getScores() {
  	if (scores == null) {
  		return new ArrayList<Integer>();
  	} else {
  		return scores;
  	}
  }
  
  public int getSnakeSize() {
  	Stream<Dot> intStream = snakeHead.getBody().stream();
		return intStream.map(e -> 1).reduce(0,(a,b)->a+b);
	}
  
  public int getAmountOfItems() {
  	Stream<Items> intStream = this.items.stream();
		return intStream.map(e -> 1).reduce(0,(a,b)->a+b);
  }
  
}

