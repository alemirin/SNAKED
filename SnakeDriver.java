/*
 * Name: Alejandro Miranda
 * Class: CS5004 Spring 2024
 * Assignment: Final Project
 */


import javax.swing.*;;

public class SnakeDriver extends JFrame {
    private static final long serialVersionUID = 1L;
		
    public static void main(String[] args) {
    	
    	SnakeModel model = new SnakeModel();
    	iView view = new MenuView(model);
    	Controller controller = new MenuController(view, model);
    	
    	controller.go();
    	
    }

    
}
