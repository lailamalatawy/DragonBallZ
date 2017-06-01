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

import dragonball.model.character.fighter.PlayableFighter;

@SuppressWarnings("serial")
public class BattleMeInfoPanel extends JPanel {
	
	JButton closeButton;
	
	JLabel name;
	JLabel maxHP;
	JLabel hp;
	JLabel maxStamina;
	JLabel stamina;
	JLabel maxKi;
	JLabel ki;
	
	Font f1;
	PlayableFighter me;
	
	public BattleMeInfoPanel(PlayableFighter me) {
		
		setLayout(null);
		setSize(500,500);
		setOpaque(false);
		
		f1 = new Font("Lucida Sans Typewriter", Font.BOLD, 25);
		this.me = me;
		
		
		name = new JLabel(me.getName());
		name.setBounds(200, 50, 242, 50);
		name.setVerticalAlignment(SwingConstants.CENTER);
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setFont(f1);
		name.setForeground(Color.WHITE);
		add(name);
		
		
		maxHP = new JLabel(me.getMaxHealthPoints() + "");
		maxHP.setBounds(250, 150, 242, 50);
		maxHP.setVerticalAlignment(SwingConstants.CENTER);
		maxHP.setHorizontalAlignment(SwingConstants.CENTER);
		maxHP.setFont(f1);
		maxHP.setForeground(Color.WHITE);
		add(maxHP);
		
		
		hp = new JLabel(me.getHealthPoints() + "");
		hp.setBounds(250, 188, 242, 50);
		hp.setVerticalAlignment(SwingConstants.CENTER);
		hp.setHorizontalAlignment(SwingConstants.CENTER);
		hp.setFont(f1);
		hp.setForeground(Color.WHITE);
		add(hp);
		
		
		maxStamina = new JLabel(me.getMaxStamina() + "");
		maxStamina.setBounds(250, 250, 242, 50);
		maxStamina.setVerticalAlignment(SwingConstants.CENTER);
		maxStamina.setHorizontalAlignment(SwingConstants.CENTER);
		maxStamina.setFont(f1);
		maxStamina.setForeground(Color.WHITE);
		add(maxStamina);
		
		
		stamina = new JLabel(me.getStamina() + "");
		stamina.setBounds(250, 288, 242, 50);
		stamina.setVerticalAlignment(SwingConstants.CENTER);
		stamina.setHorizontalAlignment(SwingConstants.CENTER);
		stamina.setFont(f1);
		stamina.setForeground(Color.WHITE);
		add(stamina);
		
		
		maxKi = new JLabel(me.getMaxKi() + "");
		maxKi.setBounds(250, 350, 242, 50);
		maxKi.setVerticalAlignment(SwingConstants.CENTER);
		maxKi.setHorizontalAlignment(SwingConstants.CENTER);
		maxKi.setFont(f1);
		maxKi.setForeground(Color.WHITE);
		add(maxKi);
		
		
		ki = new JLabel(me.getKi() + "");
		ki.setBounds(250, 388, 242, 50);
		ki.setVerticalAlignment(SwingConstants.CENTER);
		ki.setHorizontalAlignment(SwingConstants.CENTER);
		ki.setFont(f1);
		ki.setForeground(Color.WHITE);
		add(ki);
		
		
		closeButton = new JButton(new ImageIcon("closebutton.png"));
		closeButton.setBounds(425, 10, 20, 20);
		closeButton.setBorder(BorderFactory.createEmptyBorder());
		add(closeButton);
	}
	
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = new ImageIcon("foefighterinfo.png").getImage();
        g.drawImage(image, 0, 0, this);
    }

}
