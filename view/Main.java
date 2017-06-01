package dragonball.view;

import javax.swing.*;

@SuppressWarnings("serial")
public class Main extends JFrame{
	MainMenu mainMenu;
	
	public Main(){
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);	// place it in the middle of the screen
		setSize(1250,700);
		setResizable(false);			// because of the null layout
		
		mainMenu = new MainMenu(this);
		add(mainMenu);
		mainMenu.setVisible(true);
		mainMenu.revalidate();
		mainMenu.repaint();
		
		revalidate();
		repaint();
		setVisible(true);
	}
	
	public static void main(String[] args) {
	
		new Main();
	}
}
