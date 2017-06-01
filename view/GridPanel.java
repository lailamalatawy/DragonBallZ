package dragonball.view;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import dragonball.model.exceptions.MapIndexOutOfBoundsException;
import dragonball.model.game.Game;

@SuppressWarnings("serial")
public class GridPanel extends JPanel implements KeyListener {
	
	Game game;
	char typeFighter;
	WorldFrame worldFrame;
	
	
	public GridPanel(Game game, WorldFrame worldFrame) {
		setLayout(new GridLayout(10, 10));

		this.game = game;
		this.worldFrame = worldFrame;

		addKeyListener(this);
		setFocusable(true);
		mapFormation();
	}


	public void mapFormation() {
		removeAll();
		
		typeFighter = game.getPlayer().getActiveFighter().getClass().getSimpleName().charAt(0);
		JLabel cellLabel;
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				cellLabel = new JLabel();
				cellLabel.setBorder((BorderFactory.createLineBorder(Color.black)));
				if (i == 0 && j == 0) {
					cellLabel.setIcon(new ImageIcon("bossFoeIcon.png"));
					cellLabel.setHorizontalAlignment(SwingConstants.CENTER);
				}
					
				if (i == game.getWorld().getPlayerRow() && j == game.getWorld().getPlayerColumn()) {
					ImageIcon playerImage = (typeFighter == 'N') ? new ImageIcon("namekianmap.png") :
						                    (typeFighter == 'M') ? new ImageIcon("majinmap.png") :
						                	(typeFighter == 'E') ? new ImageIcon("earthlingmap.png") :
								            (typeFighter == 'S') ? new ImageIcon("saiyanmap.png") :
									                               new ImageIcon("friezamap.png");
								
					cellLabel.setIcon(playerImage);
					cellLabel.setHorizontalAlignment(SwingConstants.CENTER);
				}
				add(cellLabel);
			}
		}
		revalidate();
		repaint();
	}

	@Override
	public void keyPressed(KeyEvent e) {
		int prevRow=game.getWorld().getPlayerRow();
		int prevCol=game.getWorld().getPlayerColumn();
		String position= ""+prevRow+prevCol;
		int oldLocation=Integer.parseInt(position);
		try {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_UP:
				game.getWorld().moveUp();
				break;
			case KeyEvent.VK_DOWN:
				game.getWorld().moveDown();
				break;
			case KeyEvent.VK_RIGHT:
				game.getWorld().moveRight();
				break;
			case KeyEvent.VK_LEFT:
				game.getWorld().moveLeft();
				break;
			}	
		} catch(MapIndexOutOfBoundsException a) {
			this.getComponent(oldLocation).setVisible(true);
		}
		mapFormation();
	}


	public void keyReleased(KeyEvent arg0) {

	}


	@Override
	public void keyTyped(KeyEvent arg0) {

	}
	

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		Image image = new ImageIcon("bgmap.png").getImage();
		int x = (this.getWidth() - image.getWidth(null)) / 2;
		int y = (this.getHeight() - image.getHeight(null)) / 2;
		g2d.drawImage(image, x, y, null);
	}


}

