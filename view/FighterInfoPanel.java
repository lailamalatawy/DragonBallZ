package dragonball.view;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;


import dragonball.model.game.Game;


@SuppressWarnings("serial")
public class FighterInfoPanel extends JPanel {
	
	JLabel fighterTitle;
	JLabel fighterNameTyped;
	
	JLabel sepLine;
	JLabel sepLine2;
	JLabel sepLine3;
	
	JLabel senzuBeanPic;
	JLabel dragonBallPic;
	JLabel fighterLevelPic;
	
	public JLabel senzuBeanNum;
	public JLabel dragonBallNum;
	JLabel fighterLevelNum;

	Font f;

	public FighterInfoPanel(Game game) {
		setSize(1000, 150);
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);
		
		f = new Font("Lucida Sans Typewriter", Font.BOLD, 25);
		
		fighterTitle = new JLabel(new ImageIcon("fighter2.png"));
		fighterTitle.setBounds(20, 20, 242, 60);
		fighterTitle.setBorder(BorderFactory.createEmptyBorder());
		add(fighterTitle);


		fighterNameTyped = new JLabel(game.getPlayer().getActiveFighter().getName());
		fighterNameTyped.setBounds(20, 60, 242, 50);
		fighterNameTyped.setVerticalAlignment(SwingConstants.CENTER);
		fighterNameTyped.setHorizontalAlignment(SwingConstants.CENTER);
		fighterNameTyped.setFont(f);
		add(fighterNameTyped);
		
		
		sepLine = new JLabel(new ImageIcon("divline3.png"));
		sepLine.setBounds(300, 15, 1, 100);
		sepLine.setBorder(BorderFactory.createEmptyBorder());
		add(sepLine);
		
		
		senzuBeanPic = new JLabel(new ImageIcon("senzubean.png"));
		senzuBeanPic.setBounds(380, 15, 50, 50);
		senzuBeanPic.setBorder(BorderFactory.createEmptyBorder());
		add(senzuBeanPic);
		
		
		senzuBeanNum = new JLabel(game.getPlayer().getSenzuBeans() + "");
		senzuBeanNum.setBounds(380, 70, 50, 50);
		senzuBeanNum.setVerticalAlignment(SwingConstants.CENTER);
		senzuBeanNum.setHorizontalAlignment(SwingConstants.CENTER);
		senzuBeanNum.setFont(f);
		add(senzuBeanNum);
		
		sepLine2 = new JLabel(new ImageIcon("divline3.png"));
		sepLine2.setBounds(510, 15, 1, 100);
		sepLine2.setBorder(BorderFactory.createEmptyBorder());
		add(sepLine2);
		
		
		dragonBallPic = new JLabel(new ImageIcon("ball.png"));
		dragonBallPic.setBounds(590, 15, 50, 50);
		dragonBallPic.setBorder(BorderFactory.createEmptyBorder());
		add(dragonBallPic);
		
		
		dragonBallNum = new JLabel(game.getPlayer().getDragonBalls() + "");
		dragonBallNum.setBounds(590, 70, 50, 50);
		dragonBallNum.setVerticalAlignment(SwingConstants.CENTER);
		dragonBallNum.setHorizontalAlignment(SwingConstants.CENTER);
		dragonBallNum.setFont(f);
		add(dragonBallNum);
		
		sepLine3 = new JLabel(new ImageIcon("divline3.png"));
		sepLine3.setBounds(720, 15, 1, 100);
		sepLine3.setBorder(BorderFactory.createEmptyBorder());
		add(sepLine3);
		
		
		
		fighterLevelPic = new JLabel(new ImageIcon("level.png"));
		fighterLevelPic.setBounds(745, 20, 242, 60);
		fighterLevelPic.setBorder(BorderFactory.createEmptyBorder());
		add(fighterLevelPic);
		
		
		fighterLevelNum = new JLabel(game.getPlayer().getActiveFighter().getLevel() + "");
		fighterLevelNum.setBounds(745, 70, 242, 50);
		fighterLevelNum.setVerticalAlignment(SwingConstants.CENTER);
		fighterLevelNum.setHorizontalAlignment(SwingConstants.CENTER);
		fighterLevelNum.setFont(f);
		add(fighterLevelNum);
		

	}

}
