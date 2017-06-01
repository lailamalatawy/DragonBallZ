package dragonball.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import dragonball.model.game.Game;
import dragonball.model.player.Player;

public class CreateFighterPanel extends JPanel {

	JLabel newGameTitle;
	JLabel pickplayer;
	JLabel enterFighterName;
	JLabel characters;
	JButton back;
	JTextFieldLimit fighterNameField;

	JButton earthling;
	JButton namekian;
	JButton majin;
	JButton saiyan;
	JButton frieza;

	JButton okType;
	JButton doneFighterName;
	JButton cancel;

	JLabel earthlingpic;
	JLabel earthlinglogo;
	JLabel earthlingdata;

	JLabel friezapic;
	JLabel friezalogo;
	JLabel friezadata;

	JLabel namekianpic;
	JLabel namekianlogo;
	JLabel namekiandata;

	JLabel majinpic;
	JLabel majinlogo;
	JLabel majindata;

	JLabel saiyanpic;
	JLabel saiyanlogo;
	JLabel saiyandata;

	JLabel fighterNameTyped;
	JLabel fighterTitle;
	
	Player player;
	char typeFighter;
	Game game;
	String fighterName;
	Image image;

	Main mainFrame;
	boolean isClicked;
	Font f;
	
	WorldFrame worldFrame;
	


	private static final long serialVersionUID = 1L;

	public CreateFighterPanel(WorldFrame worldFrame, final Game game){
		setSize(1250,700);
		setLayout(null);
		this.worldFrame = worldFrame;
		this.game = game;

		isClicked = false;
		f = new Font("Lucida Sans Typewriter", Font.BOLD, 30);
		image = new ImageIcon("bggg.jpg").getImage();
		
		
		newGameTitle = new JLabel(new ImageIcon("createnewfighter.png"));
		newGameTitle.setBounds(50, 50, 700, 100);
		newGameTitle.setBorder(BorderFactory.createEmptyBorder());
		//logo.setContentAreaFilled(false);
		add(newGameTitle);
		
		back = new JButton(new ImageIcon("backbtn.png"));
		back.setBounds(10, 10, 50, 50);
		back.setBorder(BorderFactory.createEmptyBorder());
		add(back);
		back.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				worldFrame.mainPanel.setVisible(true);
			}
		});
		


		pickplayer = new JLabel(new ImageIcon("pickAFighter.png"));
		pickplayer.setBounds(80, 150, 430, 63);
		pickplayer.setBorder(BorderFactory.createEmptyBorder());
		//logo.setContentAreaFilled(false);
		add(pickplayer);
		

		enterFighterName = new JLabel(new ImageIcon("enterFighterName.png"));
		enterFighterName.setBounds(80, 420, 628, 63);
		enterFighterName.setBorder(BorderFactory.createEmptyBorder());
		//logo.setContentAreaFilled(false);
		
		
		fighterTitle = new JLabel(new ImageIcon("fighter2.png"));
		fighterTitle.setBounds(750, 530, 200, 60);
		fighterTitle.setBorder(BorderFactory.createEmptyBorder());


		fighterNameTyped = new JLabel("FighterName");
		fighterNameTyped.setBounds(950, 535, 300, 53);
		fighterNameTyped.setFont(f);

		

		fighterNameField = new JTextFieldLimit(13);
		fighterNameField.setHorizontalAlignment(JTextFieldLimit.CENTER);
		fighterNameField.setBounds(90, 490, 400, 60);
		Border roundedBorder = new LineBorder(Color.black, 1, false);
		fighterNameField.setBorder(roundedBorder);
		fighterNameField.setText("Fighter Name");
		fighterNameField.setFont(f);
		fighterNameField.setForeground(Color.BLACK);
		fighterNameField.getDocument().addDocumentListener(new MyDocumentListener(fighterNameTyped));


		characters = new JLabel(new ImageIcon("characfinal.gif"));
		characters.setBounds(700, 70, 479, 570);
		characters.setBorder(BorderFactory.createEmptyBorder());
		//logo.setContentAreaFilled(false);
		add(characters);




		okType = new JButton("OK");
		okType.setBounds(256, 375, 70, 70);
		//ok.setBackground(Color.MAGENTA);
		okType.addMouseListener(new  MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				remove(saiyanpic);
				remove(saiyanlogo);
				remove(saiyandata);
				remove(majinpic);
				remove(majinlogo);
				remove(majindata);
				remove(namekianpic);
				remove(namekianlogo);
				remove(namekiandata);
				remove(friezapic);
				remove(friezalogo);
				remove(friezadata);
				remove(earthlingpic);
				remove(earthlinglogo);
				remove(earthlingdata);

				remove(okType);
				
				add(enterFighterName);
				add(fighterNameField);
				add(fighterTitle);
				add(fighterNameTyped);
				add(doneFighterName);
				add(cancel);

				if(typeFighter == 'E')
					add(earthlingpic);

				else if(typeFighter == 'F') 
					add(friezapic);

				else if(typeFighter == 'N') 
					add(namekianpic);

				else if(typeFighter == 'M')
					add(majinpic);

				else if(typeFighter == 'S')
					add(saiyanpic);

				earthling.setEnabled(false);
				frieza.setEnabled(false);
				majin.setEnabled(false);
				namekian.setEnabled(false);
				saiyan.setEnabled(false);

				image = new ImageIcon("bgs.jpg").getImage();
				revalidate();
				repaint();

			}
		});




		doneFighterName = new JButton("Done");
		doneFighterName.setBounds(200, 550, 90, 70);
		//ok.setBackground(Color.MAGENTA);
		doneFighterName.addMouseListener(new  MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				fighterName = fighterNameField.getText();
				game.getPlayer().createFighter(typeFighter, fighterName);
				setVisible(false);
				worldFrame.mainPanel.setVisible(true);
			}	
		});




		cancel = new JButton("Cancel");
		cancel.setBounds(300, 550, 90, 70);
		cancel.addMouseListener(new  MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {

			}

			@Override
			public void mouseEntered(MouseEvent e) {

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				remove(saiyanpic);		
				remove(majinpic);			
				remove(namekianpic);		
				remove(friezapic);
				remove(earthlingpic);
		
				
				typeFighter = '\u0000';
				fighterName = "";

				remove(enterFighterName);
				remove(fighterNameField);
				
				remove(fighterTitle);
				remove(fighterNameTyped);

				remove(doneFighterName);
				remove(cancel);

				add(characters);

				image = new ImageIcon("bggg.jpg").getImage();
				revalidate();
				repaint();

				earthling.setEnabled(true);
				frieza.setEnabled(true);
				majin.setEnabled(true);
				namekian.setEnabled(true);
				saiyan.setEnabled(true);
			}
		});






		// EARTHLING

		earthlingpic = new JLabel(new ImageIcon("earthlingfinal.png"));
		earthlingpic.setBounds(810, 100, 270, 430);
		earthlingpic.setBorder(BorderFactory.createEmptyBorder());
		//logo.setContentAreaFilled(false);

		earthlinglogo = new JLabel(new ImageIcon("earthlinglogo.png"));
		earthlinglogo.setBounds(850, 350, 277, 441);
		earthlinglogo.setBorder(BorderFactory.createEmptyBorder());
		//logo.setContentAreaFilled(false);


		earthlingdata = new JLabel(new ImageIcon("earthlingdata.png"));
		earthlingdata.setBounds(90, 340, 600, 441);
		earthlingdata.setBorder(BorderFactory.createEmptyBorder());
		//logo.setContentAreaFilled(false);


		earthling = new JButton("Earthling");
		earthling.setBounds(90, 220, 130, 70);
		add(earthling);
		earthling.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				if(earthling.isEnabled() == true && !(isClicked)) {
					remove(earthlingpic);
					remove(earthlinglogo);
					remove(earthlingdata);
					add(characters);
					revalidate();
					repaint();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if(earthling.isEnabled() == true && !(isClicked)) {
					remove(characters);
					add(earthlingpic);
					add(earthlinglogo);
					add(earthlingdata);
					revalidate();
					repaint();
				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				isClicked = true;

				if(earthling.isEnabled()) {
					remove(saiyanpic);
					remove(saiyanlogo);
					remove(saiyandata);
					remove(majinpic);
					remove(majinlogo);
					remove(majindata);
					remove(namekianpic);
					remove(namekianlogo);
					remove(namekiandata);
					remove(friezapic);
					remove(friezalogo);
					remove(friezadata);

					remove(characters);
					add(earthlingpic);
					add(earthlinglogo);
					add(earthlingdata);
					add(okType);
					revalidate();
					repaint();
					typeFighter = 'E';
				}
			}
		});




		// FRIEZA

		friezapic = new JLabel(new ImageIcon("friezafinal10.png"));
		friezapic.setBounds(850, 100, 275, 430);
		friezapic.setBorder(BorderFactory.createEmptyBorder());
		//logo.setContentAreaFilled(false);

		friezalogo = new JLabel(new ImageIcon("friezalogo.png"));
		friezalogo.setBounds(850, 350, 277, 441);
		friezalogo.setBorder(BorderFactory.createEmptyBorder());
		//logo.setContentAreaFilled(false);


		friezadata = new JLabel(new ImageIcon("friezadata.png"));
		friezadata.setBounds(90, 340, 600, 441);
		friezadata.setBorder(BorderFactory.createEmptyBorder());
		//logo.setContentAreaFilled(false);

		frieza = new JButton("Frieza");
		frieza.setBounds(225, 220, 130, 70);
		add(frieza);
		frieza.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				if(frieza.isEnabled() == true && !(isClicked)) {
					remove(friezapic);
					remove(friezalogo);
					remove(friezadata);
					add(characters);
					revalidate();
					repaint();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if(frieza.isEnabled() == true && !(isClicked)) {
					remove(characters);
					add(friezapic);
					add(friezalogo);
					add(friezadata);
					revalidate();
					repaint();
				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				isClicked = true;

				if(earthling.isEnabled()) {
					remove(saiyanpic);
					remove(saiyanlogo);
					remove(saiyandata);
					remove(majinpic);
					remove(majinlogo);
					remove(majindata);
					remove(namekianpic);
					remove(namekianlogo);
					remove(namekiandata);
					remove(earthlingpic);
					remove(earthlinglogo);
					remove(earthlingdata);

					remove(characters);
					add(friezapic);
					add(friezalogo);
					add(friezadata);
					add(okType);
					revalidate();
					repaint();
					typeFighter = 'F';
				}
			}
		});




		// NAMEKIAN

		namekianpic = new JLabel(new ImageIcon("namekianfinal10.png"));
		namekianpic.setBounds(860, 100, 260, 430);
		namekianpic.setBorder(BorderFactory.createEmptyBorder());
		//logo.setContentAreaFilled(false);

		namekianlogo = new JLabel(new ImageIcon("namekianlogo.png"));
		namekianlogo.setBounds(850, 350, 277, 441);
		namekianlogo.setBorder(BorderFactory.createEmptyBorder());
		//logo.setContentAreaFilled(false);


		namekiandata = new JLabel(new ImageIcon("namekiandata.png"));
		namekiandata.setBounds(90, 340, 600, 441);
		namekiandata.setBorder(BorderFactory.createEmptyBorder());
		//logo.setContentAreaFilled(false);


		namekian = new JButton("Namekian");
		namekian.setBounds(295, 300, 130, 70);
		add(namekian);
		namekian.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				if(namekian.isEnabled() == true && !(isClicked)) {
					remove(namekianpic);
					remove(namekianlogo);
					remove(namekiandata);
					revalidate();
					repaint();
					add(characters);
				}

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if(namekian.isEnabled() == true && !(isClicked)) {
					remove(characters);
					add(namekianpic);
					add(namekianlogo);
					add(namekiandata);
					revalidate();
					repaint();
				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				isClicked = true;

				if(earthling.isEnabled()) {
					remove(saiyanpic);
					remove(saiyanlogo);
					remove(saiyandata);
					remove(majinpic);
					remove(majinlogo);
					remove(majindata);
					remove(friezapic);
					remove(friezalogo);
					remove(friezadata);
					remove(earthlingpic);
					remove(earthlinglogo);
					remove(earthlingdata);

					remove(characters);
					add(namekianpic);
					add(namekianlogo);
					add(namekiandata);
					add(okType);
					revalidate();
					repaint();
					typeFighter = 'N';
				}
			}
		});




		// MAJIN

		majinpic = new JLabel(new ImageIcon("majinfinal10.png"));
		majinpic.setBounds(830, 100, 304, 430);
		majinpic.setBorder(BorderFactory.createEmptyBorder());
		//logo.setContentAreaFilled(false);

		majinlogo = new JLabel(new ImageIcon("majinlogo.png"));
		majinlogo.setBounds(850, 350, 277, 441);
		majinlogo.setBorder(BorderFactory.createEmptyBorder());
		//logo.setContentAreaFilled(false);


		majindata = new JLabel(new ImageIcon("majindata.png"));
		majindata.setBounds(90, 340, 600, 441);
		majindata.setBorder(BorderFactory.createEmptyBorder());
		//logo.setContentAreaFilled(false);


		majin = new JButton("Majin");
		majin.setBounds(360, 220, 130, 70);
		add(majin);
		majin.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				if(majin.isEnabled() == true && !(isClicked)) {
					remove(majinpic);
					remove(majinlogo);
					remove(majindata);
					add(characters);
					revalidate();
					repaint();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if(majin.isEnabled() == true && !(isClicked)) {
					remove(characters);
					add(majinpic);
					add(majinlogo);
					add(majindata);
					revalidate();
					repaint();
				}
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				isClicked = true;

				if(earthling.isEnabled()) {
					remove(saiyanpic);
					remove(saiyanlogo);
					remove(saiyandata);
					remove(namekianpic);
					remove(namekianlogo);
					remove(namekiandata);
					remove(friezapic);
					remove(friezalogo);
					remove(friezadata);
					remove(earthlingpic);
					remove(earthlinglogo);
					remove(earthlingdata);

					remove(characters);
					add(majinpic);
					add(majinlogo);
					add(majindata);
					add(okType);
					revalidate();
					repaint();	
					typeFighter = 'M';
				}
			}
		});




		// Saiyan

		saiyanpic = new JLabel(new ImageIcon("saiyanfinal10.png"));
		saiyanpic.setBounds(830, 100, 361, 430);
		saiyanpic.setBorder(BorderFactory.createEmptyBorder());
		//logo.setContentAreaFilled(false);

		saiyanlogo = new JLabel(new ImageIcon("saiyanlogo.png"));
		saiyanlogo.setBounds(850, 350, 277, 441);
		saiyanlogo.setBorder(BorderFactory.createEmptyBorder());
		//logo.setContentAreaFilled(false);


		saiyandata = new JLabel(new ImageIcon("saiyandata.png"));
		saiyandata.setBounds(90, 340, 600, 441);
		saiyandata.setBorder(BorderFactory.createEmptyBorder());
		//logo.setContentAreaFilled(false);



		saiyan = new JButton("Saiyan");
		saiyan.setBounds(160, 300, 130, 70);
		add(saiyan);
		saiyan.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {

			}

			@Override
			public void mousePressed(MouseEvent e) {

			}

			@Override
			public void mouseExited(MouseEvent e) {
				if(saiyan.isEnabled() == true && !(isClicked)) {
					remove(saiyanpic);
					remove(saiyanlogo);
					remove(saiyandata);
					add(characters);
					revalidate();
					repaint();
				}
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				if(saiyan.isEnabled() == true && !(isClicked)) {
					remove(characters);
					add(saiyanpic);
					add(saiyanlogo);
					add(saiyandata);
					revalidate();
					repaint();
				}

			}

			@Override
			public void mouseClicked(MouseEvent e) {
				isClicked = true;

				if(earthling.isEnabled()) {
					remove(majinpic);
					remove(majinlogo);
					remove(majindata);
					remove(namekianpic);
					remove(namekianlogo);
					remove(namekiandata);
					remove(friezapic);
					remove(friezalogo);
					remove(friezadata);
					remove(earthlingpic);
					remove(earthlinglogo);
					remove(earthlingdata);

					remove(characters);
					add(saiyanpic);
					add(saiyanlogo);
					add(saiyandata);
					add(okType);
					revalidate();
					repaint();
					typeFighter = 'S';

				}
			}
		});

	}


	// To paint the background
	protected void paintComponent(Graphics G){
		super.paintComponent(G);
		//Image image = new ImageIcon("drgaonballs.jpg").getImage();
		repaint();
		revalidate();
		G.drawImage(image, 0, 0, this);
	}
}
