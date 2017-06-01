package dragonball.view;

import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;

import dragonball.model.character.fighter.Earthling;
import dragonball.model.character.fighter.Frieza;
import dragonball.model.character.fighter.Majin;
import dragonball.model.character.fighter.Namekian;
import dragonball.model.character.fighter.PlayableFighter;
import dragonball.model.character.fighter.Saiyan;
import dragonball.model.game.Game;

@SuppressWarnings("serial")
public class SwitchFighterWindow extends JDialog {
	
	ImageIcon saiyan;
	ImageIcon earthling;
	ImageIcon namekian;
	ImageIcon majin;
	ImageIcon frieza;
	
	Game game;
	String nameFighter;
	char type;
	JButton tempButton;
	
	WorldFrame worldFrame;
	
	JPanel titlePanel;
	JLabel title;
	JPanel fightersPanel;
	
	JPanel mainPanel;
	
	
	public SwitchFighterWindow(Game game, WorldFrame worldFrame) {
		setLayout(null);
		setSize(500,400);
		setLocationRelativeTo(null);
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
		mainPanel.setSize(500,400);
		mainPanel.setVisible(true);
		
		title = new JLabel(new ImageIcon("switchfighter.png"));
		title.setBounds(0, 10, 500, 80);
		
		titlePanel = new JPanel();
		titlePanel.setLayout(null);
		titlePanel.setOpaque(false);
		titlePanel.add(title);
		titlePanel.revalidate();
		titlePanel.repaint();
		titlePanel.setVisible(true);
		
		fightersPanel = new JPanel();
		fightersPanel.setLayout(new FlowLayout());
		fightersPanel.setOpaque(false);
		fightersPanel.setVisible(true);
		
	
		this.game = game;
		this.worldFrame = worldFrame;
		
		saiyan = new ImageIcon("saiyanmap.png");
		earthling = new ImageIcon("earthlingmap.png");
		namekian = new ImageIcon("namekianmap.png");
		majin = new ImageIcon("majinmap.png");
		frieza = new ImageIcon("friezamap.png");

		type = '\u0000';
		for( PlayableFighter fighter: game.getPlayer().getFighters()) {
			nameFighter = fighter.getName();
		    tempButton = new JButton(); 

			if(fighter instanceof Saiyan)
				type = 'S';
			else if(fighter instanceof Earthling)
				type = 'E';
			else if(fighter instanceof Namekian)
				type = 'N';
			else if(fighter instanceof Majin)
				type = 'M';
			else if(fighter instanceof Frieza)
				type = 'F';

			switch(type) {
			case 'S' : tempButton = new JButton(nameFighter, saiyan); break;
			case 'E' : tempButton = new JButton(nameFighter, earthling); break;
			case 'N' : tempButton = new JButton(nameFighter, namekian); break;
			case 'M' : tempButton = new JButton(nameFighter, majin); break;
			case 'F' : tempButton = new JButton(nameFighter, frieza); break;
			}
			
			//temp.setBorder(BorderFactory.createEmptyBorder());
			tempButton.addActionListener((ActionEvent e)->{
				System.out.println(fighter);
				this.game.getPlayer().setActiveFighter(fighter);
				worldFrame.gridPanel.mapFormation();
				worldFrame.infoPanel.fighterNameTyped.setText(game.getPlayer().getActiveFighter().getName() + "");
				this.dispose();
			});
			
			fightersPanel.add(tempButton);
		}
		
		titlePanel.setBounds(0, 0, 500, 80);
		mainPanel.add(titlePanel);
		fightersPanel.setBounds(50, 90, 400, 340);
		mainPanel.add(fightersPanel);
		
		add(mainPanel);
	}
}
