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

import dragonball.model.character.fighter.NonPlayableFighter;
import dragonball.model.character.fighter.PlayableFighter;

@SuppressWarnings("serial")
public class BattleStartPanel extends JPanel {

	JLabel meMaxHP;
	JLabel meMaxStamina;
	JLabel meMaxKi;
	JLabel foeMaxHP;
	JLabel foeMaxStamina;
	JLabel foeMaxKi;
	
	JButton closeButton;
	
	Font f1;
	
	PlayableFighter me;
	NonPlayableFighter foe;

	public BattleStartPanel(PlayableFighter me, NonPlayableFighter foe) {
		setLayout(null);
		setSize(900,500);
		setOpaque(false);
		
		f1 = new Font("Lucida Sans Typewriter", Font.BOLD, 25);
		this.me = me;
		this.foe = foe;
		
		
		meMaxHP = new JLabel(me.getMaxHealthPoints() + "");
		meMaxHP.setBounds(230, 165, 242, 50);
		meMaxHP.setVerticalAlignment(SwingConstants.CENTER);
		meMaxHP.setHorizontalAlignment(SwingConstants.CENTER);
		meMaxHP.setFont(f1);
		meMaxHP.setForeground(Color.WHITE);
		add(meMaxHP);
		
		
		
		meMaxStamina = new JLabel(me.getMaxStamina() + "");
		meMaxStamina.setBounds(230, 238, 242, 50);
		meMaxStamina.setVerticalAlignment(SwingConstants.CENTER);
		meMaxStamina.setHorizontalAlignment(SwingConstants.CENTER);
		meMaxStamina.setFont(f1);
		meMaxStamina.setForeground(Color.WHITE);
		add(meMaxStamina);
		
		
		
		meMaxKi = new JLabel(me.getMaxKi() + "");
		meMaxKi.setBounds(230, 312, 242, 50);
		meMaxKi.setVerticalAlignment(SwingConstants.CENTER);
		meMaxKi.setHorizontalAlignment(SwingConstants.CENTER);
		meMaxKi.setFont(f1);
		meMaxKi.setForeground(Color.WHITE);
		add(meMaxKi);
		
		
		
		foeMaxHP = new JLabel(foe.getMaxHealthPoints() + "");
		foeMaxHP.setBounds(650, 165, 242, 50);
		foeMaxHP.setVerticalAlignment(SwingConstants.CENTER);
		foeMaxHP.setHorizontalAlignment(SwingConstants.CENTER);
		foeMaxHP.setFont(f1);
		foeMaxHP.setForeground(Color.WHITE);
		add(foeMaxHP);
		
		
		
		foeMaxStamina = new JLabel(foe.getMaxStamina() + "");
		foeMaxStamina.setBounds(650, 238, 242, 50);
		foeMaxStamina.setVerticalAlignment(SwingConstants.CENTER);
		foeMaxStamina.setHorizontalAlignment(SwingConstants.CENTER);
		foeMaxStamina.setFont(f1);
		foeMaxStamina.setForeground(Color.WHITE);
		add(foeMaxStamina);
		
		
		
		foeMaxKi = new JLabel(foe.getMaxKi() + "");
		foeMaxKi.setBounds(650, 312, 242, 50);
		foeMaxKi.setVerticalAlignment(SwingConstants.CENTER);
		foeMaxKi.setHorizontalAlignment(SwingConstants.CENTER);
		foeMaxKi.setFont(f1);
		foeMaxKi.setForeground(Color.WHITE);
		add(foeMaxKi);
		
		
		closeButton = new JButton(new ImageIcon("closebutton.png"));
		closeButton.setBounds(800, 12, 20, 20);
		closeButton.setBorder(BorderFactory.createEmptyBorder());
		add(closeButton);
		
	}
	
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = new ImageIcon("startpopup.png").getImage();
        g.drawImage(image, 0, 0, this);
    }

}

