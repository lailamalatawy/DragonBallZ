package dragonball.view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import dragonball.model.exceptions.NotEnoughAbilityPointsException;
import dragonball.model.game.Game;

@SuppressWarnings("serial")
public class UpgradeFighterWindow extends JDialog {
	
	
	int abilityPoints;
	int healthPoints;
	int blastDamage;
	int physicalDamage;
	int kiPoints;
	int stamina;
	
	Game game;
	
	JLabel upgradeFighterTitle;
	JLabel abilityPointsTitle;
	
	JLabel abilityPointsValue;
	JLabel healthPointsValue;
	JLabel blastDamageValue;
	JLabel physicalDamageValue;
	JLabel kiPointsValue;
	JLabel staminaValue;
	
	
	JButton healthPointsButton;
	JButton blastDamageButton;
	JButton physicalDamageButton;
	JButton kiPointsButton;
	JButton staminaButton;
	

	JLabel healthPointsLabel;
	JLabel blastDamageLabel;
	JLabel physicalDamageLabel;
	JLabel kiPointsLabel;
	JLabel staminaLabel;
	
	JLabel line;
	
	JPanel mainPanel;
	
	Font f;
	
	
	public UpgradeFighterWindow(Game game) {
		setLayout(null);
		setSize(700,700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		
		f = new Font("Lucida Sans Typewriter", Font.BOLD, 40);
		
		mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image image = new ImageIcon("wp3.jpg").getImage();
                g.drawImage(image, 0, 0, this);
            }
		 };
		mainPanel.setLayout(null);
		mainPanel.setSize(700,700);
		mainPanel.setVisible(true);
		
		
		this.game = game;
		abilityPoints = game.getPlayer().getActiveFighter().getAbilityPoints();
		healthPoints = game.getPlayer().getActiveFighter().getMaxHealthPoints();
		blastDamage = game.getPlayer().getActiveFighter().getBlastDamage();
		physicalDamage = game.getPlayer().getActiveFighter().getPhysicalDamage();
		kiPoints = game.getPlayer().getActiveFighter().getMaxKi();
		stamina = game.getPlayer().getActiveFighter().getMaxStamina();
		
		upgradeFighterTitle = new JLabel(new ImageIcon("upgradefighter.png"));
		upgradeFighterTitle.setBounds(60, 10, 600, 100);
		upgradeFighterTitle.setBorder(BorderFactory.createEmptyBorder());
		mainPanel.add(upgradeFighterTitle);
		
		abilityPointsTitle = new JLabel(new ImageIcon("abilitypoints.png"));
		abilityPointsTitle.setBounds(50, 80, 600, 100);
		abilityPointsTitle.setBorder(BorderFactory.createEmptyBorder());
		mainPanel.add(abilityPointsTitle);
		
		line = new JLabel(new ImageIcon("divline.png"));
		line.setBounds(2, 150, 700, 50);
		line.setBorder(BorderFactory.createEmptyBorder());
		mainPanel.add(line);
		
		abilityPointsValue = new JLabel();
		abilityPointsValue.setText(abilityPoints + "");
		abilityPointsValue.setBounds(530, 80, 600, 100);
		abilityPointsValue.setFont(f);
		mainPanel.add(abilityPointsValue);
		
		healthPointsValue = new JLabel();
		healthPointsValue.setText(healthPoints + "");
		healthPointsValue.setBounds(530, 180, 600, 100);
		healthPointsValue.setFont(f);
		mainPanel.add(healthPointsValue);
		
		blastDamageValue = new JLabel();
		blastDamageValue.setText(blastDamage + "");
		blastDamageValue.setBounds(530, 280, 600, 100);
		blastDamageValue.setFont(f);
		mainPanel.add(blastDamageValue);
		
		physicalDamageValue = new JLabel();
		physicalDamageValue.setText(physicalDamage + "");
		physicalDamageValue.setBounds(530, 380, 600, 100);
		physicalDamageValue.setFont(f);
		mainPanel.add(physicalDamageValue);
		
		kiPointsValue = new JLabel();
		kiPointsValue.setText(kiPoints + "");
		kiPointsValue.setBounds(530, 480, 600, 100);
		kiPointsValue.setFont(f);
		mainPanel.add(kiPointsValue);
		
		staminaValue = new JLabel();
		staminaValue.setText(stamina + "");
		staminaValue.setBounds(530, 580, 600, 100);
		staminaValue.setFont(f);
		mainPanel.add(staminaValue);
		
		healthPointsButton = new JButton("+ 50");
		healthPointsButton.setBounds(370, 200, 80, 60);
		healthPointsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try 
				{
					game.getPlayer().upgradeFighter(game.getPlayer().getActiveFighter(), 'H');
				} catch (NotEnoughAbilityPointsException e1) {
					JOptionPane.showMessageDialog(null, "You don't have enough ability points.");
				}
				healthPointsValue.setText(game.getPlayer().getActiveFighter().getMaxHealthPoints() + "");
				abilityPointsValue.setText(game.getPlayer().getActiveFighter().getAbilityPoints() + "");
				
			}
			
		});
		mainPanel.add(healthPointsButton);
		
		blastDamageButton = new JButton("+ 50");
		blastDamageButton.setBounds(370, 300, 80, 60);
		blastDamageButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try 
				{
					game.getPlayer().upgradeFighter(game.getPlayer().getActiveFighter(), 'B');
				} catch (NotEnoughAbilityPointsException e1) {
					JOptionPane.showMessageDialog(null, "You don't have enough ability points.");
				}
				blastDamageValue.setText(game.getPlayer().getActiveFighter().getBlastDamage() + "");
				abilityPointsValue.setText(game.getPlayer().getActiveFighter().getAbilityPoints() + "");
				
			}
			
		});
		mainPanel.add(blastDamageButton);
		
		physicalDamageButton = new JButton("+ 50");
		physicalDamageButton.setBounds(370, 400, 80, 60);
		physicalDamageButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try 
				{
					game.getPlayer().upgradeFighter(game.getPlayer().getActiveFighter(), 'P');
				} catch (NotEnoughAbilityPointsException e1) {
					JOptionPane.showMessageDialog(null, "You don't have enough ability points.");
				}
				physicalDamageValue.setText(game.getPlayer().getActiveFighter().getPhysicalDamage() + "");
				abilityPointsValue.setText(game.getPlayer().getActiveFighter().getAbilityPoints() + "");
			}
			
		});
		mainPanel.add(physicalDamageButton);
		
		kiPointsButton = new JButton("+ 1");
		kiPointsButton.setBounds(370, 500, 80, 60);
		kiPointsButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					game.getPlayer().upgradeFighter(game.getPlayer().getActiveFighter(), 'K');
				} catch (NotEnoughAbilityPointsException e1) {
					JOptionPane.showMessageDialog(null, "You don't have enough ability points.");
				}
				kiPointsValue.setText(game.getPlayer().getActiveFighter().getMaxKi() + "");
				abilityPointsValue.setText(game.getPlayer().getActiveFighter().getAbilityPoints() + "");
			}
			
		});
		mainPanel.add(kiPointsButton);
		
		staminaButton = new JButton("+ 1");
		staminaButton.setBounds(370, 600, 80, 60);
		staminaButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try 
				{
					game.getPlayer().upgradeFighter(game.getPlayer().getActiveFighter(), 'S');
				} catch (NotEnoughAbilityPointsException e1) {
					JOptionPane.showMessageDialog(null, "You don't have enough ability points.");
				}
				staminaValue.setText(game.getPlayer().getActiveFighter().getMaxStamina() + "");
				abilityPointsValue.setText(game.getPlayer().getActiveFighter().getAbilityPoints() + "");
			}
			
		});
		mainPanel.add(staminaButton);
		


		
		
		healthPointsLabel = new JLabel(new ImageIcon("healthpoints.png"));
		healthPointsLabel.setBounds(20, 200, 300, 50);
		mainPanel.add(healthPointsLabel);
		
		blastDamageLabel = new JLabel(new ImageIcon("blastdamage.png"));
		blastDamageLabel.setBounds(20, 300, 300, 50);
		mainPanel.add(blastDamageLabel);
		
		physicalDamageLabel = new JLabel(new ImageIcon("physicaldamage.png"));
		physicalDamageLabel.setBounds(20, 400, 320, 50);
		mainPanel.add(physicalDamageLabel);
		
		kiPointsLabel = new JLabel(new ImageIcon("kipoints.png"));
		kiPointsLabel.setBounds(20, 500, 300, 50);
		mainPanel.add(kiPointsLabel);
		
		staminaLabel = new JLabel(new ImageIcon("stamina.png"));
		staminaLabel.setBounds(20, 600, 300, 50);
		mainPanel.add(staminaLabel);
		
		add(mainPanel);
		

	}

}
