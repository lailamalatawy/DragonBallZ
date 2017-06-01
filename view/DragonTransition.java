package dragonball.view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import dragonball.model.dragon.Dragon;
import dragonball.model.game.Game;

@SuppressWarnings("serial")
public class DragonTransition extends JFrame{
   public DragonTransition(Dragon dragon,Game game){
	   setLayout(null);
	   setSize(1250,700);
	   setContentPane(new JLabel(new ImageIcon("dragonTransition-resize.gif")));
	  JButton Continue = new JButton("Continue");
	  Continue.setBounds(600,200,150,150);
	  add(Continue);
	  Continue.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			DragonFrame d = new DragonFrame(dragon,game);
			d.setVisible(true);
			dispose();
		}
	     
	   });
	   setVisible(true);
	   
   }
}

