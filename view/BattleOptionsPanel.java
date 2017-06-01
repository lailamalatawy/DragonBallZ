package dragonball.view;


import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class BattleOptionsPanel extends JPanel {
	
	JButton attack;
	JButton block;
	JButton use;

	
	public BattleOptionsPanel() {
		setLayout(null);
		setSize(700,200);
		setOpaque(false);
		
		
		attack = new JButton(new ImageIcon("attack.png"));
		attack.setBounds(58, 15, 100, 100);
		attack.setBorder(BorderFactory.createEmptyBorder());
		add(attack);

		
		block = new JButton(new ImageIcon("block.png"));
		block.setBounds(230, 15, 100, 100);
		block.setBorder(BorderFactory.createEmptyBorder());
		add(block);

		
		
		use = new JButton(new ImageIcon("use2.png"));
		use.setBounds(400, 15, 100, 100);
		use.setBorder(BorderFactory.createEmptyBorder());
		add(use);
	}
	
	
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Image image = new ImageIcon("attackblockuse.png").getImage();
        g.drawImage(image, 0, 0, this);
    }

}
