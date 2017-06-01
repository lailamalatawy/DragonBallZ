package dragonball.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dragonball.model.attack.Attack;
import dragonball.model.attack.PhysicalAttack;
import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.UltimateAttack;
import dragonball.model.battle.Battle;
import dragonball.model.exceptions.NotEnoughKiException;
import dragonball.model.game.Game;

@SuppressWarnings("serial")
public class BattleAttackPopUp extends JPanel {
	
	JButton superAttacks;
	JButton ultimateAttacks;
	JButton physicalAttack;
	
	JComboBox<String> fighterSuperCombo;
	JComboBox<String> fighterUltimateCombo;
	
	Game game;
	Battle battle;
	
	
	public BattleAttackPopUp(Game game, Battle battle) {
		setLayout(null);
		setSize(400,400);
		setOpaque(false);
		
		this.game = game;
		this.battle = battle;
		
		
		
		superAttacks = new JButton(new ImageIcon("sa3.png"));
		superAttacks.setBounds(25, 20, 350, 50);
		superAttacks.setBorder(BorderFactory.createEmptyBorder());
		add(superAttacks);
		superAttacks.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				add(fighterSuperCombo, new Integer(2), 0);
				revalidate();
				repaint();
			}
		});
		
		
		
		ultimateAttacks = new JButton(new ImageIcon("ua3.png"));
		ultimateAttacks.setBounds(25, 120, 350, 50);
		ultimateAttacks.setBorder(BorderFactory.createEmptyBorder());
		add(ultimateAttacks);
		ultimateAttacks.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				add(fighterUltimateCombo, new Integer(2), 0);
				revalidate();
				repaint();
			}
		});
		
		
		
		physicalAttack = new JButton(new ImageIcon("pa3.png"));
		physicalAttack.setBounds(25, 240, 350, 50);
		physicalAttack.setBorder(BorderFactory.createEmptyBorder());
		add(physicalAttack);
		physicalAttack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					battle.attack(new PhysicalAttack());
				} catch (NotEnoughKiException e1) {
					JOptionPane.showMessageDialog(null, "You don't have enough ki.");
				}
			}
		});
		
		
		
		fighterSuperCombo = new JComboBox<String>();
		fighterSuperCombo.setBounds(100, 60, 200, 50);
		
		for(SuperAttack attack : game.getPlayer().getActiveFighter().getSuperAttacks())
			fighterSuperCombo.addItem(attack.getName());
		
		fighterSuperCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Attack performedAttack = null;
				for(SuperAttack attack : game.getPlayer().getSuperAttacks())
					if(attack.getName().equals(fighterSuperCombo.getSelectedItem()))
						performedAttack = attack;
				
				try {
					battle.attack(performedAttack);
				} catch (NotEnoughKiException e1) {
					JOptionPane.showMessageDialog(null, "You don't have enough ki.");
				}
			}
		});

		
		
		
		fighterUltimateCombo = new JComboBox<String>();
		fighterUltimateCombo.setBounds(100, 160, 200, 50);
		
		for(UltimateAttack attack : game.getPlayer().getActiveFighter().getUltimateAttacks())
			fighterUltimateCombo.addItem(attack.getName());
		
		fighterUltimateCombo.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Attack performedAttack = null;
				for(UltimateAttack attack : game.getPlayer().getUltimateAttacks())
					if(attack.getName().equals(fighterUltimateCombo.getSelectedItem()))
						performedAttack = attack;
				
				try {
					battle.attack(performedAttack);
				} catch (NotEnoughKiException e1) {
					JOptionPane.showMessageDialog(null, "You don't have enough ki.");
				}
			}
		});
		
		revalidate();
		repaint();
	}
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = new ImageIcon("popup.png").getImage();
        g.drawImage(image, 0, 0, this);
    }

}
