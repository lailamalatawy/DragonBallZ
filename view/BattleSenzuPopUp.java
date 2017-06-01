package dragonball.view;


import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dragonball.model.game.Game;

@SuppressWarnings("serial")
public class BattleSenzuPopUp extends JPanel {
	
	JLabel senzuString;
	Font f2;
	Game game;
	
	public BattleSenzuPopUp(Game game) {
		setLayout(null);
		setSize(150,150);
		setOpaque(false);
		
		f2 = new Font("Lucida Sans Typewriter", Font.BOLD, 30);
		this.game = game;
		
		
		senzuString = new JLabel(game.getPlayer().getSenzuBeans() + "");

		senzuString.setBounds(18, 65, 100, 50);
		senzuString.setVerticalAlignment(SwingConstants.CENTER);
		senzuString.setHorizontalAlignment(SwingConstants.CENTER);
		senzuString.setFont(f2);
		senzuString.setForeground(Color.WHITE);
		add(senzuString);
	}
	
	

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = new ImageIcon("usepopup.png").getImage();
        g.drawImage(image, 0, 0, this);
    }
}
