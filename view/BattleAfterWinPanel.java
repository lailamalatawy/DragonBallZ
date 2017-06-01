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
public class BattleAfterWinPanel extends JPanel {
	
	JLabel gainedXp;
	JLabel newXp;
	JLabel gainedSkill;
	
	JButton closeButton;
	JButton doubleArrow;
	
	Font f4;
	Boolean levelUp;
	Game game;
	
	int gainedXpValue;
	int newXpValue;
	String gainedSkillName;
	
	
	public BattleAfterWinPanel(Boolean levelUp, Game game, int gainedXpValue, int newXpValue, String gainedSkillName ) {
		setLayout(null);
		setSize(800,700);
		setOpaque(false);
		f4 = new Font("Lucida Sans Typewriter", Font.BOLD, 60);
		this.levelUp = levelUp;
		this.game = game;
		this.gainedXpValue = gainedXpValue;
		this.newXpValue = newXpValue;
		this.gainedSkillName = gainedSkillName;
		
		
		gainedXp = new JLabel("+" + gainedXpValue);
		gainedXp.setBounds(460, 58, 300, 100);
		gainedXp.setVerticalAlignment(SwingConstants.CENTER);
		gainedXp.setHorizontalAlignment(SwingConstants.CENTER);
		gainedXp.setFont(f4);
		gainedXp.setForeground(Color.WHITE);
		add(gainedXp);
		
		newXp = new JLabel(newXpValue + "");
		newXp.setBounds(460, 160, 300, 100);
		newXp.setVerticalAlignment(SwingConstants.CENTER);
		newXp.setHorizontalAlignment(SwingConstants.CENTER);
		newXp.setFont(f4);
		newXp.setForeground(Color.WHITE);
		add(newXp);
		
		
		gainedSkill = new JLabel(gainedSkillName);
		gainedSkill.setBounds(20, 410, 700, 100);
		gainedSkill.setVerticalAlignment(SwingConstants.CENTER);
		gainedSkill.setHorizontalAlignment(SwingConstants.CENTER);
		gainedSkill.setFont(f4);
		gainedSkill.setForeground(Color.WHITE);
		add(gainedSkill);
		
		
		
		doubleArrow = new JButton(new ImageIcon("doublearrow.png"));
		doubleArrow.setBounds(650, 495, 100, 100);
		doubleArrow.setBorder(BorderFactory.createEmptyBorder());		
		
		
		closeButton = new JButton(new ImageIcon("closebutton.png"));
		closeButton.setBounds(725, 15, 20, 20);
		closeButton.setBorder(BorderFactory.createEmptyBorder());

		if(levelUp)
			add(doubleArrow);
		else
			add(closeButton);
		
		
	}
	
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = new ImageIcon("afterwin.png").getImage();
        g.drawImage(image, 0, 0, this);
    }

}
