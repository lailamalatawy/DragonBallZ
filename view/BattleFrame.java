package dragonball.view;

import javax.swing.JFrame;

import dragonball.model.battle.Battle;
import dragonball.model.game.Game;

@SuppressWarnings("serial")
public class BattleFrame extends JFrame {
	
	BattlePanel battlePanel;
	BattleFrame battleFrame;
	WorldFrame worldFrame;
	
	public BattleFrame(Game game, Battle battle, WorldFrame worldFrame) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);	
		setSize(1250,700);
		setResizable(false);
		
		battleFrame = this;
		this.worldFrame = worldFrame;

		battlePanel = new BattlePanel(game, battle, this, worldFrame);
		add(battlePanel);
		battlePanel.setVisible(true);
		battlePanel.revalidate();
		battlePanel.repaint();
		
		revalidate();
		repaint();
		setVisible(true);
		
	}
	
/*	public static void main (String[] args) {
		BattleNewFrame b = new BattleNewFrame();
	}*/
	
	

}
