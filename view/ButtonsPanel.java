package dragonball.view;


import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dragonball.model.game.Game;
import dragonball.view.AssignAttackWindow;
import dragonball.view.CreateFighterPanel;
import dragonball.view.GridPanel;
import dragonball.view.SwitchFighterWindow;
import dragonball.view.UpgradeFighterWindow;
import dragonball.view.WorldFrame;

@SuppressWarnings("serial")
public class ButtonsPanel extends JPanel {

	JButton createNewFighter;
	JButton switchFighter;
	JButton assignAttack;
	JButton upgradeActiveFighter;

	JLabel playerTitle;
	JLabel playerNameTyped;

	Font f;
	Game game;
	WorldFrame worldFrame;
	GridPanel gridPanel;
	ButtonsPanel buttonsPanel;


	public ButtonsPanel(Game game, WorldFrame worldFrame, GridPanel gridPanel) {
		setSize(250, 700);
		setLayout(null);
		setBackground(Color.LIGHT_GRAY);

		this.game = game;
		this.worldFrame = worldFrame;
		this.gridPanel = gridPanel;
		buttonsPanel = this;
		f = new Font("Lucida Sans Typewriter", Font.BOLD, 25);

		playerTitle = new JLabel(new ImageIcon("player.png"));
		playerTitle.setBounds(6, 20, 242, 60);
		playerTitle.setBorder(BorderFactory.createEmptyBorder());
		add(playerTitle);


		playerNameTyped = new JLabel(game.getPlayer().getName());
		playerNameTyped.setBounds(6, 70, 242, 50);
		playerNameTyped.setVerticalAlignment(SwingConstants.CENTER);
		playerNameTyped.setHorizontalAlignment(SwingConstants.CENTER);
		playerNameTyped.setFont(f);
		add(playerNameTyped);


		JLabel line = new JLabel(new ImageIcon("line3.png"));
		line.setBounds(0,0,5,700);
		add(line);



		// CREATE NEW FIGHTER BUTTON
		createNewFighter = new JButton("Create New Fighter");
		createNewFighter.setFocusable(false);
		createNewFighter.setBounds(6,123, 242, 140);
		add(createNewFighter);
		createNewFighter.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				CreateFighterPanel newCreateFighterPanel = new CreateFighterPanel(worldFrame, game);
				worldFrame.mainPanel.setVisible(false);
				worldFrame.add(newCreateFighterPanel);
				newCreateFighterPanel.setVisible(true);
				repaint();
				revalidate();
			}
		});




		// SWITCH PLAYER BUTTON
		switchFighter = new JButton("Switch Fighter");
		switchFighter.setFocusable(false);
		switchFighter.setBounds(6,260, 242, 140);
		add(switchFighter);
		switchFighter.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				SwitchFighterWindow switchFighterWindow = new SwitchFighterWindow(game, worldFrame);
				switchFighterWindow.setVisible(true);
				switchFighterWindow.repaint();
				switchFighterWindow.revalidate();
			}
		});





		// ASSIGN ATTACK BUTTON
		assignAttack = new JButton("Assign Attack");
		assignAttack.setFocusable(false);
		assignAttack.setBounds(6,397, 242, 140);
		add(assignAttack);
		assignAttack.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				AssignAttackWindow assignAttackWindow = new AssignAttackWindow(game);
				assignAttackWindow.setVisible(true);
				assignAttackWindow.repaint();
				assignAttackWindow.revalidate();
			}
		});




		// UNPGRADE ACTIVE FIGHTER BUTTON
		upgradeActiveFighter = new JButton("Upgrade Active Fighter");
		upgradeActiveFighter.setFocusable(false);
		upgradeActiveFighter.setBounds(6,534, 242, 140);
		add(upgradeActiveFighter);
		upgradeActiveFighter.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				UpgradeFighterWindow upgradeFighter = new UpgradeFighterWindow(game);
				upgradeFighter.setVisible(true);
				upgradeFighter.repaint();
				upgradeFighter.revalidate();
			}

		});




		revalidate();
		repaint();
		setVisible(true);

	}

}

