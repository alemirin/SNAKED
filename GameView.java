import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class GameView extends JFrame implements iView, ActionListener, KeyListener {
	private static final long serialVersionUID = 1L;
	Controller c;
	SnakeModel model;
	GamePanel window;
	
	//Loop for game
  Timer timer;
	
	public GameView(SnakeModel model, int delay) {
		this.model = model;
		//Set some default values and actions
		this.setTitle("SNAKED!");
		this.setSize(GameConstants.SCREEN_HEIGHT, GameConstants.SCREEN_WIDTH);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBackground(Color.black);
				
		//JPanel
		window = new GamePanel();
		window.setModel(this.model);
		window.setBackground(Color.black);
		window.setPreferredSize(new Dimension(GameConstants.SCREEN_HEIGHT, GameConstants.SCREEN_WIDTH));
		add(window);
		
		window.setLayout(null);
		
		
		//allows view to interpret key presses
		addKeyListener(this);
		
		//want the game view to listen to key presses
		setFocusable(true);
		
		JButton menuBtn = new JButton("Menu");
		add(menuBtn,BorderLayout.SOUTH);
		
		//Button click to go to menu
		menuBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				((GameController)c).goToMenu();
			}
		});
		
		
		timer = new Timer(delay, this);
			
	}
	
	
	
	public void showWindow() {
		this.setVisible(true);
		timer.start();
	}

	@Override
	public void setController(Controller controller) {
		this.c = controller;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		model.getSnake().move(model.getItemList());
		repaint();
		if (model.checkGameOver()) {
			timer.stop();
		}
	}


	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_UP && model.getSnake().getVelocityY() != 1 * GameConstants.DOT_SIZE) {
			model.getSnake().setVelocityX(0);
			model.getSnake().setVelocityY(-1 * GameConstants.DOT_SIZE);
		}
		else if (e.getKeyCode() == KeyEvent.VK_DOWN && model.getSnake().getVelocityY() != -1 * GameConstants.DOT_SIZE) {
			model.getSnake().setVelocityX(0);
			model.getSnake().setVelocityY(1 * GameConstants.DOT_SIZE);
		}
		else if (e.getKeyCode() == KeyEvent.VK_LEFT && model.getSnake().getVelocityX() != 1 * GameConstants.DOT_SIZE) {
			model.getSnake().setVelocityX(-1 * GameConstants.DOT_SIZE);
			model.getSnake().setVelocityY(0);
		}
		else if (e.getKeyCode() == KeyEvent.VK_RIGHT && model.getSnake().getVelocityX() != -1 * GameConstants.DOT_SIZE) {
			model.getSnake().setVelocityX(1 * GameConstants.DOT_SIZE);
			model.getSnake().setVelocityY(0);
		}
		
	}
	
	public void closeWindow() {
		this.window.setVisible(false);
		this.setVisible(false);
	}


	//Not necessary for snake game
	@Override
	public void keyTyped(KeyEvent e) {}
	@Override
	public void keyReleased(KeyEvent e) {}
	
	
}
