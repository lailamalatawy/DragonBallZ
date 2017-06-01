package dragonball.view;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


import dragonball.model.dragon.Dragon;
import dragonball.model.dragon.DragonWish;
import dragonball.model.game.Game;

@SuppressWarnings("serial")
public class DragonFrame extends JFrame{
	
	private JButton senzuBtn;
	private JButton abilityBtn;
	private JButton superAttackBtn;
	private JButton ultimateAttackBtn;
	
	public DragonFrame(Dragon dragon, Game game){
		setLayout(null);
		setSize(1250,700);
        setContentPane(new JLabel(new ImageIcon("dragon_1.jpg")));
        DragonWish[] dragonWishes = dragon.getWishes();
		senzuBtn = new JButton("SenzuBeans");
		senzuBtn.setBounds(300, 480, 150, 50);
		add(senzuBtn);
		senzuBtn.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent arg0) {
			game.getPlayer().chooseWish(dragonWishes[0]);
			dispose();
			}
			
		});
		abilityBtn = new JButton("AblityPoints");
		abilityBtn.setBounds(500, 480, 150, 50);
		add(abilityBtn);
		abilityBtn.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent arg0) {
				game.getPlayer().chooseWish(dragonWishes[1]);
				dispose();
			}
			
		});
		superAttackBtn = new JButton("Super Attack");
		superAttackBtn.setBounds(700, 480, 150, 50);
		add(superAttackBtn);
		superAttackBtn.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent arg0) {
				
				game.getPlayer().chooseWish(dragonWishes[2]);
				dispose();
			}
			
		});
		ultimateAttackBtn = new JButton("Ultimate attack");
		ultimateAttackBtn.setBounds(900, 480, 150, 50);
		add(ultimateAttackBtn);
		ultimateAttackBtn.addActionListener(new ActionListener(){

			
			public void actionPerformed(ActionEvent arg0) {
				game.getPlayer().chooseWish(dragonWishes[3]);
				dispose();
				
			}
			
		});
	}
}
