package dragonball.view;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dragonball.model.game.Game;

@SuppressWarnings("serial")
public class BattleCongratsPanel extends JPanel {
	
	JLabel playerName;
	JButton doubleArrow;
	
	Font f3;
	Game game;

	public BattleCongratsPanel(Game game) {
		setLayout(null);
		setSize(800,700);
		setOpaque(false);
		
		f3 = new Font("Lucida Sans Typewriter", Font.BOLD, 80);
		this.game = game;
		
		
		playerName = new JLabel(game.getPlayer().getName());
		playerName.setBounds(22, 220, 700, 100);
		playerName.setVerticalAlignment(SwingConstants.CENTER);
		playerName.setHorizontalAlignment(SwingConstants.CENTER);
		playerName.setFont(f3);
		playerName.setForeground(Color.WHITE);
		add(playerName);
		
		
		
		doubleArrow = new JButton(new ImageIcon("doublearrow.png"));
		doubleArrow.setBounds(650, 495, 100, 100);
		doubleArrow.setBorder(BorderFactory.createEmptyBorder());
		add(doubleArrow);		
		
	}
	
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = new ImageIcon("congrats.png").getImage();
        g.drawImage(image, 0, 0, this);
    }
}
