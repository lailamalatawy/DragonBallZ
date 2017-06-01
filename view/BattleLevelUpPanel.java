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
public class BattleLevelUpPanel extends JPanel {
	
	JLabel playerName;
	JLabel newLevel;
	JLabel newTargetXp;
	JLabel gainedAbiltyPoints;
	JLabel newAbiltyPoints;
	
	JButton closeButton;
	
	int newLevelValue;
	int newTargetXpValue;
	int newAbiltyPointsValue;
	Game game;
	
	Font f3;
	Font f5;
	Font f6;
	
	public BattleLevelUpPanel(Game game, int newLevelValue, int newTargetXpValue, int newAbiltyPointsValue) {
		setLayout(null);
		setSize(800,700);
		setOpaque(false);
		
		
		f3 = new Font("Lucida Sans Typewriter", Font.BOLD, 80);
		f5 = new Font("Lucida Sans Typewriter", Font.BOLD, 35);
		f6 = new Font("Lucida Sans Typewriter", Font.BOLD, 45);


		this.newLevelValue = newLevelValue;
		this.newTargetXpValue = newTargetXpValue;
		this.newAbiltyPointsValue = newAbiltyPointsValue;
		this.game = game;
		
		
		
		playerName = new JLabel(game.getPlayer().getName());
		playerName.setBounds(480, 45, 400, 100);
		playerName.setVerticalAlignment(SwingConstants.CENTER);
		playerName.setHorizontalAlignment(SwingConstants.LEFT);
		playerName.setFont(f5);
		playerName.setForeground(Color.WHITE);
		add(playerName);
		
		
		newLevel = new JLabel(newLevelValue +  "");
		newLevel.setBounds(225, 235, 300, 100);
		newLevel.setVerticalAlignment(SwingConstants.CENTER);
		newLevel.setHorizontalAlignment(SwingConstants.CENTER);
		newLevel.setFont(f3);
		newLevel.setForeground(Color.WHITE);
		add(newLevel);
		
		
		newTargetXp = new JLabel(newTargetXpValue + "");
		newTargetXp.setBounds(570, 322, 200, 100);
		newTargetXp.setVerticalAlignment(SwingConstants.CENTER);
		newTargetXp.setHorizontalAlignment(SwingConstants.CENTER);
		newTargetXp.setFont(f6);
		newTargetXp.setForeground(Color.WHITE);
		add(newTargetXp);
		
		
		gainedAbiltyPoints = new JLabel("+2");
		gainedAbiltyPoints.setBounds(622, 387, 100, 100);
		gainedAbiltyPoints.setVerticalAlignment(SwingConstants.CENTER);
		gainedAbiltyPoints.setHorizontalAlignment(SwingConstants.CENTER);
		gainedAbiltyPoints.setFont(f6);
		gainedAbiltyPoints.setForeground(Color.WHITE);
		add(gainedAbiltyPoints);
		
		
		newAbiltyPoints = new JLabel(newAbiltyPointsValue + "");
		newAbiltyPoints.setBounds(622, 450, 100, 100);
		newAbiltyPoints.setVerticalAlignment(SwingConstants.CENTER);
		newAbiltyPoints.setHorizontalAlignment(SwingConstants.CENTER);
		newAbiltyPoints.setFont(f6);
		newAbiltyPoints.setForeground(Color.WHITE);
		add(newAbiltyPoints);
		
		
		
		closeButton = new JButton(new ImageIcon("closebutton.png"));
		closeButton.setBounds(725, 15, 20, 20);
		closeButton.setBorder(BorderFactory.createEmptyBorder());
		add(closeButton);
	}
	
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = new ImageIcon("levelup.png").getImage();
        g.drawImage(image, 0, 0, this);
    }

}
