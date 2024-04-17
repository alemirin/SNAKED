import java.awt.Color;
import java.awt.Container;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class ScoreView extends JFrame implements iView {
	private static final long serialVersionUID = -4419653645986152154L;
	Controller c;
	JPanel window;
	
	public ScoreView(SnakeModel model) {
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
		
		//Set grid layout for screen
		setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.gridwidth = GridBagConstraints.REMAINDER;
    gbc.anchor = GridBagConstraints.NORTH;
    gbc.weightx = 0.5;
    
    JLabel title = new JLabel("<html><h1><strong>HIGH SCORES</strong></h1></html>");
    add(title, gbc);
    
    gbc.anchor = GridBagConstraints.CENTER;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    
		//Scores
    ArrayList<Integer> scoreList = model.getScores();
    if (scoreList.size() != 0) {
	    Collections.sort(scoreList, Collections.reverseOrder());
	    
	    for (int i = 0; i < scoreList.size(); i++) {
	    	JLabel score = new JLabel(String.valueOf(i + 1) + ": " + String.valueOf(scoreList.get(i)), SwingConstants.CENTER);
	    	add(score, gbc);
	    	if (i == 25) {
	    		break;
	    	}
	    }
    }
    
    //Menu Button
    gbc.anchor = GridBagConstraints.SOUTH;
    gbc.fill = GridBagConstraints.HORIZONTAL;
    
    JButton menuBtn = new JButton("Menu");
		add(menuBtn, gbc);
		
		//Button click to go to menu
		menuBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				((ScoreController)c).goToMenu();
			}
		});
	}

	@Override
	public void setController(Controller controller) {
		this.c = controller;
	}
	
	public void showWindow() {
		this.setVisible(true);
	}
	
	public void closeWindow() {
		this.setVisible(false);
	}

}
