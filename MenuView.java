import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MenuView extends JFrame implements iView {
	private static final long serialVersionUID = 1L;
	Controller c;
	JPanel window;
	
	public MenuView(SnakeModel snake) {
		//Set some default values and actions
		this.setTitle("SNAKED");
		this.setSize(GameConstants.SCREEN_HEIGHT, GameConstants.SCREEN_WIDTH);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
		//JPanel
		window = new JPanel();
		Container cont = this.getContentPane();
		Color background = new Color(193, 225, 193);
		cont.setBackground(background); 
		cont.add(window);
		
		
    setLayout(new GridBagLayout());

    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    gbc.anchor = GridBagConstraints.NORTH;
    gbc.weightx = 0.5;
    
    JLabel title = new JLabel("<html><h1><strong>SNAKED!</strong></h1></html>");
    add(title, gbc);
    
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    gbc.fill = GridBagConstraints.HORIZONTAL;

		JLabel info = new JLabel("Green apples are good, and orange hamburgers are delicious...", SwingConstants.CENTER);
		add(info, gbc);
		JLabel info2 = new JLabel("<html><i>Whose making all this red poison???</i></html>", SwingConstants.CENTER);
		add(info2, gbc);

		
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    
		//Buttons
    JPanel buttons = new JPanel(new GridBagLayout());
    JButton startBtn = new JButton("Classic");
    buttons.add(startBtn, gbc);
    JButton startHardBtn = new JButton("Hard");
    buttons.add(startHardBtn, gbc);
    JButton startInsaneBtn = new JButton("Insane");
    buttons.add(startInsaneBtn, gbc);
    JButton scoresBtn = new JButton("High scores");
    buttons.add(scoresBtn, gbc);
		
    add(buttons,gbc);
		
		//Event Handlers
		
		//Button click to start game
		startBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				((MenuController)c).start();
			}
		});
		
		startHardBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				((MenuController)c).startHard();
			}
		});
		
		startInsaneBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				((MenuController)c).startInsane();
			}
		});
			
		//Button click to show scores
		scoresBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				((MenuController)c).showScores();
			}
		});
	}
	
	//Connection to the host controller
	public void setController(Controller c) {
		this.c = c;
		}
	
	
	public void showWindow() {
		this.setVisible(true);
	}
	
	public void closeWindow() {
		this.setVisible(false);
	}
	
	

}

