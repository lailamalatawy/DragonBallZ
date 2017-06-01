package dragonball.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class MainMenu extends JPanel{
	
	JButton newGame;
	JButton loadGame;
	JButton exit;
	JLabel logo;
	Main mainFrame;
	
	public MainMenu(final Main mainFrame){
		setLayout(null);
		setSize(1250,700);
		this.mainFrame = mainFrame;
		
		
		newGame = new JButton("New Game");
		newGame.setBounds(265, 345, 300, 60);
		add(newGame);
		newGame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				NewGamePanel newGame = new NewGamePanel(mainFrame);
				removeAll();
				add(newGame);
				newGame.setVisible(true);
				newGame.revalidate();
				newGame.repaint();
				
			}
		});
		
		
		loadGame = new JButton("Load Game");
		loadGame.setBounds(265, 420, 300, 60);
		add(loadGame);
		
		exit = new JButton("Exit");
		exit.setBounds(265, 495, 300, 60);
		add(exit);
		exit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "Are you sure you want to exit the game?", "Warning", dialogButton);
				if(dialogResult == JOptionPane.YES_OPTION)
					System.exit(0);
			}
			
		});
		
		
		logo = new JLabel(new ImageIcon("D1.png"));
		logo.setBounds(100, 10, 600, 400);
		logo.setBorder(BorderFactory.createEmptyBorder());
		//logo.setContentAreaFilled(false);
		add(logo);
		
		
	}
	
	protected void paintComponent(Graphics G){
		super.paintComponent(G);
		Image image = new ImageIcon("bg.jpg").getImage();
		
		G.drawImage(image, 0, 0, this);
	}

}
