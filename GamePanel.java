import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

public class GamePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	SnakeModel m;
	
	public void setModel(SnakeModel m) {
		this.m = m;
	}
	
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	
	public void draw(Graphics g) {
		//Draw snake
		g.setColor(Color.WHITE);
		g.fillRect(m.getSnake().getHead().getX(),
							m.getSnake().getHead().getY(), 
							GameConstants.DOT_SIZE, GameConstants.DOT_SIZE);
		for (int i = 0; i < m.getSnake().getBody().size(); i++) {
			Dot bodyPart = m.getSnake().getBody().get(i);
			g.fillRect(bodyPart.getX(), bodyPart.getY(), GameConstants.DOT_SIZE, GameConstants.DOT_SIZE);
		}
		
		//Draw food
		for (int i = 0; i < m.getItemList().size(); i++) {
			Items item = m.getItemList().get(i);
			if (item instanceof Apple) {
				g.setColor(Color.green);
				g.fillRect(item.getLoc().getX(),
									item.getLoc().getY(), 
									GameConstants.DOT_SIZE, GameConstants.DOT_SIZE);
			}
			else if (item instanceof Hamburger) {
				g.setColor(Color.orange);
				g.fillRect(item.getLoc().getX(),
									item.getLoc().getY(), 
									GameConstants.DOT_SIZE, GameConstants.DOT_SIZE);
			} 
			else if (item instanceof Poison) {
				g.setColor(Color.red);
				g.fillRect(item.getLoc().getX(),
									item.getLoc().getY(), 
									GameConstants.DOT_SIZE, GameConstants.DOT_SIZE);
			}
		}
		
		//Score
		g.setFont(new Font("Courier", Font.PLAIN, 24));
		if (m.checkGameOver()) {
			g.setColor(Color.red);
			g.drawString("GAME OVER! Score: " + String.valueOf(m.getScore()),
										GameConstants.SCREEN_WIDTH / 4, GameConstants.DOT_SIZE);
		}
		else {
			g.setColor(Color.green);
			g.drawString("Score: " + String.valueOf(m.getScore()), 
					GameConstants.SCREEN_WIDTH / 3, GameConstants.DOT_SIZE);
		}
	}
}
