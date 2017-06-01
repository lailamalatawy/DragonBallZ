package dragonball.view;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dragonball.model.attack.SuperAttack;
import dragonball.model.attack.UltimateAttack;
import dragonball.model.exceptions.DuplicateAttackException;
import dragonball.model.exceptions.MaximumAttacksLearnedException;
import dragonball.model.exceptions.NotASaiyanException;
import dragonball.model.game.Game;

@SuppressWarnings("serial")
public class AssignAttackWindow extends JDialog {
	
	JLabel superAttacks;
	JLabel ultimateAttacks;
	JLabel assignedAttacksSuper;
	JLabel availableAttacksSuper;
	JLabel assignedAttacksUltimate;
	JLabel availableAttacksUltimate;
	
	JButton switchUltimate;
	JButton assignUltimate;
	JButton switchSuper;
	JButton assignSuper;
	
	
	@SuppressWarnings("rawtypes")
	JComboBox availableUltimateCombo;
	@SuppressWarnings("rawtypes")
	JComboBox assignedUltimateCombo;
	@SuppressWarnings("rawtypes")
	JComboBox availableSuperCombo;
	@SuppressWarnings("rawtypes")
	JComboBox assignedSuperCombo;
	
	JPanel mainPanel;
	
	Game game;
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public AssignAttackWindow(Game game) {
		this.game = game;
		setLayout(null);
		setSize(700,600);
		setLocationRelativeTo(null);
		setResizable(false);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image image = new ImageIcon("wp3.jpg").getImage();
                g.drawImage(image, 0, 0, this);
            }
		 };
		mainPanel.setLayout(null);
		mainPanel.setSize(700,600);
		mainPanel.setVisible(true);
		
		superAttacks = new JLabel(new ImageIcon("superattacks.png"));
		superAttacks.setBounds(60, 10, 600, 100);
		superAttacks.setBorder(BorderFactory.createEmptyBorder());
		mainPanel.add(superAttacks);
		
		assignedAttacksSuper = new JLabel(new ImageIcon("assigned2.png"));
		assignedAttacksSuper.setBounds(80, 80, 200, 50);
		assignedAttacksSuper.setBorder(BorderFactory.createEmptyBorder());
		mainPanel.add(assignedAttacksSuper);

		availableAttacksSuper = new JLabel(new ImageIcon("available2.png"));
		availableAttacksSuper.setBounds(430, 80, 200, 50);
		availableAttacksSuper.setBorder(BorderFactory.createEmptyBorder());
		mainPanel.add(availableAttacksSuper);
		
		assignedSuperCombo = new JComboBox<String>();
		assignedSuperCombo.setBounds(80, 120, 200, 50);
		for(SuperAttack attack : game.getPlayer().getActiveFighter().getSuperAttacks())
			assignedSuperCombo.addItem(attack.getName());
		mainPanel.add(assignedSuperCombo);
		
		availableSuperCombo = new JComboBox();
		availableSuperCombo.setBounds(430, 120, 200, 50);
		for(SuperAttack attack : game.getPlayer().getSuperAttacks())
			availableSuperCombo.addItem(attack.getName());
		mainPanel.add(availableSuperCombo);
		
		assignSuper = new JButton("Assign");
		assignSuper.setBounds(300, 170, 100, 50);
		assignSuper.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String attackName = (String) availableSuperCombo.getSelectedItem();
				for(SuperAttack attack : game.getPlayer().getSuperAttacks())
					if(attack.getName().equals(attackName)){
						assignedSuperCombo.addItem(attackName);
							try {
								game.getPlayer().assignAttack(game.getPlayer().getActiveFighter(), attack, null);
							} catch (MaximumAttacksLearnedException e1) {
								JOptionPane.showMessageDialog(null, "You reached maximum number of attacks.");
							} catch (DuplicateAttackException e1) {
								JOptionPane.showMessageDialog(null, "Attack is already there.");
								e1.printStackTrace();
							} catch (NotASaiyanException e1) {
								JOptionPane.showMessageDialog(null, "Fighter is not of type Saiyan!");
							}
					
					}
			}
			
			
		});
		mainPanel.add(assignSuper);
		
		switchSuper = new JButton("Switch");
		switchSuper.setBounds(300, 220, 100, 50);
		switchSuper.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String availableAttackName = (String) availableSuperCombo.getSelectedItem();
				String assignedAttackName = (String) assignedSuperCombo.getSelectedItem();
				SuperAttack oldAttack = null;
				SuperAttack newAttack = null;
				
				for(SuperAttack attack : game.getPlayer().getSuperAttacks()){
					if(attack.getName().equals(availableAttackName))
						newAttack = attack;
					if(attack.getName().equals(assignedAttackName))
						oldAttack = attack;
				}
				try 
				{
					game.getPlayer().assignAttack(game.getPlayer().getActiveFighter(), newAttack, oldAttack);
				} catch (MaximumAttacksLearnedException e1) {
					JOptionPane.showMessageDialog(null, "You reached maximum number of attacks.");
				} catch (DuplicateAttackException e1) {
					JOptionPane.showMessageDialog(null, "Attack is already there.");
					e1.printStackTrace();
				} catch (NotASaiyanException e1) {
					JOptionPane.showMessageDialog(null, "Fighter is not of type Saiyan!");
				}
				assignedSuperCombo.addItem(availableAttackName);
			}
		});
		mainPanel.add(switchSuper);
		
			
		
		
		
		ultimateAttacks = new JLabel(new ImageIcon("ultimateattacks.png"));
		ultimateAttacks.setBounds(60, 300, 600, 50);
		ultimateAttacks.setBorder(BorderFactory.createEmptyBorder());
		mainPanel.add(ultimateAttacks);
		
		assignedAttacksUltimate = new JLabel(new ImageIcon("assigned2.png"));
		assignedAttacksUltimate.setBounds(80, 350, 200, 50);
		assignedAttacksUltimate.setBorder(BorderFactory.createEmptyBorder());
		mainPanel.add(assignedAttacksUltimate);
		
		availableAttacksUltimate = new JLabel(new ImageIcon("available2.png"));
		availableAttacksUltimate.setBounds(430, 350, 200, 50);
		availableAttacksUltimate.setBorder(BorderFactory.createEmptyBorder());
		mainPanel.add(availableAttacksUltimate);
		
		assignedUltimateCombo = new JComboBox();
		assignedUltimateCombo.setBounds(80, 390, 200, 50);
		for(UltimateAttack attack : game.getPlayer().getActiveFighter().getUltimateAttacks())
			assignedUltimateCombo.addItem(attack.getName());
		mainPanel.add(assignedUltimateCombo);
		
		availableUltimateCombo = new JComboBox();
		availableUltimateCombo.setBounds(430, 390, 200, 50);
		for(UltimateAttack attack : game.getPlayer().getUltimateAttacks())
			availableUltimateCombo.addItem(attack.getName());
		mainPanel.add(availableUltimateCombo);
		
		assignUltimate = new JButton("Assign");
		assignUltimate.setBounds(300, 440, 100, 50);
		assignUltimate.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String attackName = (String) availableUltimateCombo.getSelectedItem();
				for(UltimateAttack attack : game.getPlayer().getUltimateAttacks())
					if(attack.getName().equals(attackName)){
						assignedUltimateCombo.addItem(attackName);
						try {
							game.getPlayer().assignAttack(game.getPlayer().getActiveFighter(), attack, null);
						} catch (MaximumAttacksLearnedException e1) {
							JOptionPane.showMessageDialog(null, "You reached maximum number of attacks.");
						} catch (DuplicateAttackException e1) {
							JOptionPane.showMessageDialog(null, "Attack is already there.");
							e1.printStackTrace();
						} catch (NotASaiyanException e1) {
							JOptionPane.showMessageDialog(null, "Fighter is not of type Saiyan!");
						}
					}
			}
			
			
		});
		mainPanel.add(assignUltimate);
		
		switchUltimate = new JButton("Switch");
		switchUltimate.setBounds(300, 490, 100, 50);
		switchUltimate.addActionListener(new ActionListener() { 

			@Override
			public void actionPerformed(ActionEvent e) {
				String availableAttackName = (String) availableUltimateCombo.getSelectedItem();
				String assignedAttackName = (String) assignedUltimateCombo.getSelectedItem();
				UltimateAttack oldAttack = null;
				UltimateAttack newAttack = null;
				
				for(UltimateAttack attack : game.getPlayer().getUltimateAttacks())
					if(attack.getName().equals(availableAttackName))
						newAttack = attack;
					else if(attack.getName().equals(assignedAttackName))
						oldAttack = attack;
				try 
				{
					game.getPlayer().assignAttack(game.getPlayer().getActiveFighter(), newAttack, oldAttack);
				} catch (MaximumAttacksLearnedException e1) {
					JOptionPane.showMessageDialog(null, "You reached maximum number of attacks.");
				} catch (DuplicateAttackException e1) {
					JOptionPane.showMessageDialog(null, "Attack is already there.");
					e1.printStackTrace();
				} catch (NotASaiyanException e1) {
					JOptionPane.showMessageDialog(null, "Fighter is not of type Saiyan!");
				}
				assignedUltimateCombo.addItem(availableAttackName);
			}
		});
		mainPanel.add(switchUltimate);
		
		add(mainPanel);
	}
	

}
