package dragonball.view;


import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import dragonball.model.attack.SuperAttack;
import dragonball.model.battle.Battle;
import dragonball.model.battle.BattleEvent;
import dragonball.model.battle.BattleEventType;
import dragonball.model.cell.Collectible;
import dragonball.model.dragon.Dragon;
import dragonball.model.exceptions.MissingFieldException;
import dragonball.model.exceptions.UnknownAttackTypeException;
import dragonball.model.game.Game;
import dragonball.model.game.GameListener;

@SuppressWarnings("serial")
public class WorldFrame extends JFrame implements GameListener {


	
	GridPanel gridPanel;
	ButtonsPanel buttonsPanel;
	public FighterInfoPanel infoPanel;
	JSplitPane splitPane;
	JPanel gridInfoPanel;

	BattleFrame battleFrame;
	WorldFrame worldFrame;
	Game game;
	
	JPanel mainPanel;
	



	public WorldFrame(Game game) throws MissingFieldException, UnknownAttackTypeException {
		setSize(1250,700);
		setLayout(null);
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		mainPanel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Image image = new ImageIcon("wp3.jpg").getImage();
                g.drawImage(image, 0, 0, this);
            }
		 };
		mainPanel.setLayout(new BorderLayout());
		mainPanel.setSize(1250,700);
		mainPanel.setVisible(true);

		
		this.game = game;
		game.setListener(this);
		game.getPlayer().setDragonBalls(6);
		this.worldFrame = this;
		
		infoPanel = new FighterInfoPanel(game);
		infoPanel.setOpaque(false);
		infoPanel.setBounds(120, 0, 1000, 130);
		infoPanel.setVisible(true);
		
		gridPanel = new GridPanel(game, null);
		gridPanel.setOpaque(false);
		gridPanel.setBounds(12, 130, 1220, 530);
		gridPanel.setVisible(true);

		
		gridInfoPanel = new JPanel();
		gridInfoPanel.setLayout(null);
		gridInfoPanel.setOpaque(false);
		gridInfoPanel.setSize(1250, 700);
		
		gridInfoPanel.add(infoPanel);
		gridInfoPanel.add(gridPanel);
		gridInfoPanel.revalidate();
		gridInfoPanel.repaint();
		gridInfoPanel.setVisible(true);
		

	/*	game.getPlayer().getSuperAttacks().add(new SuperAttack("Laila", 300));
		game.getPlayer().getSuperAttacks().add(new SuperAttack("Ay 7aga", 500));
		game.getPlayer().getActiveFighter().getSuperAttacks().add(new SuperAttack("MET", 800));
		game.getPlayer().getActiveFighter().getSuperAttacks().add(new SuperAttack("Slim", 99));*/
	

		buttonsPanel = new ButtonsPanel(game, worldFrame, gridPanel);
		buttonsPanel.setOpaque(false);
		buttonsPanel.addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				splitPane.setDividerLocation(990);
				
				infoPanel.setBounds(8, 0, 1000, 130);
				gridPanel.setBounds(12, 130, 970, 530);
				gridInfoPanel.revalidate();
				gridInfoPanel.repaint();

			}

			@Override
			public void mouseDragged(MouseEvent e) {

			}
		});

		buttonsPanel.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				if(splitPane.getDividerLocation() == 990)
					splitPane.setDividerLocation(1237);
				infoPanel.setBounds(120, 0, 1000, 130);
				gridPanel.setBounds(12, 130, 1220, 530);
				gridInfoPanel.revalidate();
				gridInfoPanel.repaint();
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				
			}

		});



		splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, gridInfoPanel, buttonsPanel);
		splitPane.setOpaque(false);
		splitPane.setSize(1250, 700);
		splitPane.setDividerLocation(1237);
		mainPanel.add(splitPane);


		add(mainPanel);

	}

	@Override
	public void onDragonCalled(Dragon dragon) {
		DragonTransition d = new DragonTransition(dragon, game);
		d.setVisible(true);
	}

	@Override
	public void onCollectibleFound(Collectible collectible) {
		if(collectible == Collectible.SENZU_BEAN)
			infoPanel.senzuBeanNum.setText(game.getPlayer().getSenzuBeans() + "");
		else if(collectible == Collectible.DRAGON_BALL)
			infoPanel.dragonBallNum.setText(game.getPlayer().getDragonBalls() + "");
		
	}

	@Override
	public void onBattleEvent(BattleEvent e) {
		if(e.getType().equals(BattleEventType.STARTED)){
			battleFrame = new BattleFrame(game, (Battle) e.getSource(), worldFrame);
			worldFrame.setVisible(false);
			battleFrame.setVisible(true);
		}
		
		
		battleFrame.battlePanel.battleListenerHelper(e);
		
		
	}



}