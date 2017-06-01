package dragonball.view;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;

import dragonball.model.attack.PhysicalAttack;
import dragonball.model.battle.Battle;
import dragonball.model.battle.BattleEvent;
import dragonball.model.battle.BattleEventType;
import dragonball.model.cell.Collectible;
import dragonball.model.character.fighter.NonPlayableFighter;
import dragonball.model.character.fighter.PlayableFighter;
import dragonball.model.character.fighter.Saiyan;
import dragonball.model.exceptions.NotEnoughKiException;
import dragonball.model.exceptions.NotEnoughSenzuBeansException;
import dragonball.model.game.Game;

@SuppressWarnings("serial")
public class BattlePanel extends JLayeredPane {

	JProgressBar hp1Bar;
	JProgressBar stamina1Bar;
	JProgressBar ki1Bar;

	JProgressBar hp2Bar;
	JProgressBar stamina2Bar;
	JProgressBar ki2Bar;

	JLabel mePlayerNameTyped;
	JLabel foeFighterNameTyped;
	
	ImageIcon meFighterImage;
	ImageIcon foeFighterImage;
	
	JLabel meFighter;
	JLabel foeFighter;
	
	char foeType;
	char meType;
	
	JLabel arrowRight;
	JLabel arrowLeft;
	
	JLabel meTurnIndicator;
	JLabel foeTurnIndicator;
	
	Font f;
	Image image;
	Game game;
	Battle battle;
	PlayableFighter me;
	NonPlayableFighter foe;
	BattleFrame battleFrame;
	WorldFrame worldFrame;
	
	BattleStartPanel startPanel;
	BattleMeInfoPanel meInfoPanel;
	BattleFoeInfoPanel foeInfoPanel;
	
	BattleOptionsPanel optionsPanel;
	BattleAttackPopUp attackPopUp;
	BattleSenzuPopUp senzuPopUp;
	
	BattleSorryPanel sorryPanel;
	BattleCongratsPanel congratsPanel;
	BattleAfterWinPanel afterWinPanel;
	BattleLevelUpPanel levelUpPanel;
	
	
	int newLevelValue;
	int newTargetXpValue;
	int newAbiltyPointsValue;
	int newXpValue;
	
	int initialXp;
	int initialAbilityPoints;
	int initialLevel;
	int finalXp;
	int finalAbilityPoints;
	int finalLevel;
	int gainedXpValue;
	
	String gainedSkillName;
	boolean levelUp;
	


	public BattlePanel(Game game, Battle battle, BattleFrame battleFrame, WorldFrame worldFrame) {
		setLayout(null);
		setSize(1250,700);
		
		me = (PlayableFighter) battle.getMe();
		foe = (NonPlayableFighter) battle.getFoe();
		
		
//		finalXp = newXpValue;
//		finalAbilityPoints = newAbiltyPointsValue;
//		finalLevel = newLevelValue;
//		
//		gainedXpValue = finalXp - initialXp;
		gainedSkillName = getSkill();
		
		
		this.game = game;
		this.battle = battle;
		this.battleFrame = battleFrame;
		this.worldFrame = worldFrame;
	

		f = new Font("Lucida Sans Typewriter", Font.BOLD, 25);
		image = new ImageIcon("bgbattleempty.jpg").getImage();

		
		startPanel = new BattleStartPanel(me, foe);
		startPanel.setLocation(250, 75);
		startPanel.closeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				image = new ImageIcon("battlebg.jpg").getImage();
				
				remove(startPanel);
				
				add(meFighter, new Integer(0), 0);
				add(foeFighter, new Integer(0), 0);
				
				add(hp1Bar);
				add(stamina1Bar);
				add(ki1Bar);
				add(hp2Bar);
				add(stamina2Bar);
				add(ki2Bar);
				
				add(arrowRight, new Integer(0), 0);
				add(arrowLeft, new Integer(0), 0);
				add(meTurnIndicator);
				
				//add(optionsPanel);
				
				revalidate();
				repaint();
			}
		});
		
		
		
		meInfoPanel = new BattleMeInfoPanel(me);
		meInfoPanel.setLocation(20, 200);
		meInfoPanel.closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(meInfoPanel);
				add(arrowRight);
				
				if(!foeInfoPanel.isShowing()) {
					optionsPanel.setVisible(true);
					attackPopUp.setVisible(true);
				}
				
				revalidate();
				repaint();
			}
		});
		
		
		
		foeInfoPanel = new BattleFoeInfoPanel(foe);
		foeInfoPanel.setLocation(775, 200);
		foeInfoPanel.closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(foeInfoPanel);
				arrowLeft.setVisible(true);;
				
				if(!meInfoPanel.isShowing()) {
				optionsPanel.setVisible(true);
				attackPopUp.setVisible(true);
				}
				revalidate();
				repaint();
			}
		});
		
		
		
		optionsPanel = new BattleOptionsPanel();
		optionsPanel.setLocation(342, 540);
		optionsPanel.attack.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!startPanel.isShowing()) {
					if(attackPopUp.isShowing())
						remove(attackPopUp);
					else {
						senzuPopUp.setVisible(false);
						attackPopUp.setVisible(true);
						add(attackPopUp, new Integer(2), 0);
					}
					revalidate();
					repaint();
				}
			}
		});
		
		optionsPanel.use.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				if(!startPanel.isShowing()) {
					if(senzuPopUp.isShowing())
						remove(senzuPopUp);
					else  {
						attackPopUp.setVisible(false);
						senzuPopUp.setVisible(true);
						add(senzuPopUp, new Integer(2), 0);
						try 
						{
							battle.use(game.getPlayer(), Collectible.SENZU_BEAN);
						} catch (NotEnoughSenzuBeansException e1) {
							JOptionPane.showMessageDialog(null, "You don't have enough senzu beans.");
							senzuPopUp.setVisible(false);
						}
					}
					
					revalidate();
					repaint();
				}
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		optionsPanel.block.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if(!startPanel.isShowing()) {
					senzuPopUp.setVisible(false);
					battle.block();
					attackPopUp.setVisible(false);
				}
			}
		});
		
		
		
		attackPopUp = new BattleAttackPopUp(game, battle);
		attackPopUp.setLocation(255, 190);
		
		senzuPopUp = new BattleSenzuPopUp(game);
		senzuPopUp.setLocation(720, 393);
		
		
		
		sorryPanel = new BattleSorryPanel(game);
		sorryPanel.setLocation(250, 75);
		sorryPanel.closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				battleFrame.dispose();
				worldFrame.setVisible(true);
				worldFrame.revalidate();
				worldFrame.repaint();
			}
		});
		
		
		
		congratsPanel = new BattleCongratsPanel(game);
		congratsPanel.setLocation(250, 75);
		congratsPanel.doubleArrow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				congratsPanel.setVisible(false);
				remove(congratsPanel);
				//add(afterWinPanel, new Integer(2), 0);
				afterWin();
				revalidate();
				repaint();
			}
		});
		
		
		
/*		afterWinPanel = new BattleAfterWinPanel(levelUp, game, gainedXpValue, newXpValue, gainedSkillName);
		afterWinPanel.setLocation(250, 75);
		afterWinPanel.closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				battleFrame.dispose();
				worldFrame.setVisible(true);
				worldFrame.revalidate();
				worldFrame.repaint();
			}
		});
		
		afterWinPanel.doubleArrow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(afterWinPanel);
				add(levelUpPanel);
				
				revalidate();
				repaint();
			}
		});
		*/
		// PLAYER 1
	
		mePlayerNameTyped = new JLabel(game.getPlayer().getName());
		mePlayerNameTyped.setBounds(248, 20, 242, 50);
		mePlayerNameTyped.setVerticalAlignment(SwingConstants.CENTER);
		mePlayerNameTyped.setHorizontalAlignment(SwingConstants.CENTER);
		mePlayerNameTyped.setFont(f);

		hp1Bar = new JProgressBar();
		hp1Bar.setBounds(280, 45, 200, 100);
		hp1Bar.setMaximum(me.getMaxHealthPoints());
		hp1Bar.setMinimum(0);
		hp1Bar.setValue(me.getHealthPoints());
		hp1Bar.setStringPainted(false);
	
		stamina1Bar = new JProgressBar();
		stamina1Bar.setBounds(280, 80, 200, 100);
		stamina1Bar.setMaximum(me.getMaxStamina());
		stamina1Bar.setMinimum(0);
		stamina1Bar.setValue(me.getStamina());
		stamina1Bar.setStringPainted(false);
	
		ki1Bar = new JProgressBar();
		ki1Bar.setBounds(280, 115, 200, 100);
		ki1Bar.setMaximum(me.getMaxKi());
		ki1Bar.setMinimum(0);
		ki1Bar.setValue(me.getKi());
		ki1Bar.setStringPainted(false);

		meType = me.getClass().getSimpleName().charAt(0); // WHEN TRANSFORMED HANDLE
		
		if(meType == 'S' && ((Saiyan) me).isTransformed())
			meType = 'T';

		meFighterImage = (meType == 'N') ? new ImageIcon("n4 copy.png") :
			             (meType == 'M') ? new ImageIcon("m2 copy.png") :
				         (meType == 'E') ? new ImageIcon("e5 copy.png") :
					     (meType == 'T') ? new ImageIcon("ss1 copy.png") :
					     (meType == 'S') ? new ImageIcon("s5 copy.png") :
						                   new ImageIcon("f1 copy.png");
   
		meFighter = new JLabel(meFighterImage);
		meFighter.setBounds(5, 300, 350, 350);




		// PLAYER 2
		
		foeFighterNameTyped = new JLabel(foe.getName());
		foeFighterNameTyped.setBounds(990, 22, 242, 50);
		foeFighterNameTyped.setVerticalAlignment(SwingConstants.CENTER);
		foeFighterNameTyped.setHorizontalAlignment(SwingConstants.CENTER);
		foeFighterNameTyped.setFont(f);

		hp2Bar = new JProgressBar();
		hp2Bar.setBounds(1025, 45, 200, 100);
		hp2Bar.setMaximum(foe.getMaxHealthPoints());
		hp2Bar.setMinimum(0);
		hp2Bar.setValue(foe.getHealthPoints());
		hp2Bar.setStringPainted(false);
		
		stamina2Bar = new JProgressBar();
		stamina2Bar.setBounds(1025, 80, 200, 100);
		stamina2Bar.setMaximum(foe.getMaxHealthPoints());
		stamina2Bar.setMinimum(0);
		stamina2Bar.setValue(foe.getStamina());
		stamina2Bar.setStringPainted(false);

		ki2Bar = new JProgressBar();
		ki2Bar.setBounds(1025, 115, 200, 100);
		ki2Bar.setMaximum(foe.getMaxHealthPoints());
		ki2Bar.setMinimum(0);
		ki2Bar.setValue(foe.getKi());
		ki2Bar.setStringPainted(false);

		if(!(foe.isStrong())) {
			int rand = generateRandom(3, 15);
			foeFighterImage = new ImageIcon("foe" + rand + ".png");
		}
		else 
			foeFighterImage = new ImageIcon("bossFoe.png");
		
		foeFighter = new JLabel(foeFighterImage);
		foeFighter.setBounds(860, 290, 400, 350);
		

		
		
		// ME
		
		meTurnIndicator = new JLabel(new ImageIcon("turnarrow.png"));
		meTurnIndicator.setBounds(125, 200, 120, 100);
		meTurnIndicator.setBorder(BorderFactory.createEmptyBorder());
		
		
		arrowRight = new JLabel(new ImageIcon("arrowright.png"));
		arrowRight.setBounds(5, 350, 50, 50);
		arrowRight.setBorder(BorderFactory.createEmptyBorder());
		arrowRight.addMouseListener(new MouseListener() {
			
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
				add(meInfoPanel, new Integer(2), 0);
				optionsPanel.setVisible(false);
				attackPopUp.setVisible(false);
				remove(arrowRight);
				repaint();
				revalidate();
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
	
		
		// FOE
		
		foeTurnIndicator = new JLabel(new ImageIcon("turnarrow.png"));
		foeTurnIndicator.setBounds(1000, 190, 120, 100);
		foeTurnIndicator.setBorder(BorderFactory.createEmptyBorder());
		
		
		
		arrowLeft = new JLabel(new ImageIcon("arrowleft.png"));
		arrowLeft.setBounds(1195, 350, 50, 50);
		arrowLeft.setBorder(BorderFactory.createEmptyBorder());
		
		arrowLeft.addMouseListener(new MouseListener() {
			
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
				add(foeInfoPanel, new Integer(1), 0);
				optionsPanel.setVisible(false);
				attackPopUp.setVisible(false);
				arrowLeft.setVisible(false);
				repaint();
				revalidate();
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
			}
		});
		
		
		
		
		
		// ENGINE:
		
		add(mePlayerNameTyped);
		add(foeFighterNameTyped);		
		add(startPanel);
		add(optionsPanel);
		//add(meTurnIndicator);
		meTurnIndicator.setVisible(false);
		add(foeTurnIndicator);
		foeTurnIndicator.setVisible(false);
	}
	
	
	// METHODS
	
	public void battleListenerHelper(BattleEvent e) {
		if(e.getType().equals(BattleEventType.STARTED)) {
			initialXp = me.getXp();
			initialAbilityPoints = me.getAbilityPoints();
			initialLevel = me.getLevel();
		}
		
		
		
		if(e.getType().equals(BattleEventType.NEW_TURN)) {
			meInfoPanel.hp.setText(me.getHealthPoints() + "");
			meInfoPanel.stamina.setText(me.getStamina() + "");
			meInfoPanel.ki.setText(me.getKi() + "");
			
			foeInfoPanel.hp.setText(foe.getHealthPoints() + "");
			foeInfoPanel.stamina.setText(foe.getStamina() + "");
			foeInfoPanel.stamina.setText(foe.getKi() + "");
			
			hp1Bar.setValue(me.getHealthPoints());
			stamina1Bar.setValue(me.getStamina());
			ki1Bar.setValue(me.getKi());
			
			hp2Bar.setValue(foe.getHealthPoints());
			stamina2Bar.setValue(foe.getStamina());
			ki2Bar.setValue(foe.getKi());
			
			senzuPopUp.senzuString.setText(game.getPlayer().getSenzuBeans() + "");
	
			if(me.equals(battle.getAttacker())) {
				foeTurnIndicator.setVisible(false);
				meTurnIndicator.setVisible(true);
			}
			else {
/*				meTurnIndicator.setVisible(false);
				foeTurnIndicator.setVisible(true);
				try {
					battle.play();
				} catch (NotEnoughKiException e1) {
					try {
						battle.attack(new PhysicalAttack());
					} catch (NotEnoughKiException e2) {
						e2.printStackTrace();
					}
				}*/
				delayTurn(2);
			}
			
		}
		
		else if(e.getType().equals(BattleEventType.ENDED)) {
			
			newLevelValue = me.getLevel();
			newTargetXpValue = me.getTargetXp();
			newAbiltyPointsValue = me.getAbilityPoints();
			newXpValue = me.getXp();
			worldFrame.infoPanel.dragonBallNum.setText(game.getPlayer().getDragonBalls() + "");
			worldFrame.infoPanel.senzuBeanNum.setText(game.getPlayer().getSenzuBeans()+"");
			worldFrame.infoPanel.fighterLevelNum.setText(game.getPlayer().getActiveFighter().getLevel()+"");
			
			image = new ImageIcon("bgbattleempty.jpg").getImage();
			
			remove(arrowLeft);
			remove(arrowRight);
			remove(meTurnIndicator);
			remove(foeTurnIndicator);
			remove(optionsPanel);
			remove(attackPopUp);
			remove(hp1Bar);
			remove(hp2Bar);
			remove(stamina1Bar);
			remove(stamina2Bar);
			remove(ki1Bar);
			remove(ki2Bar);
			
			if(e.getWinner() == me) {
				congratsPanel.setVisible(true);
				add(congratsPanel, new Integer(1), 0);
			}
			else if(e.getWinner() == foe) {
				add(sorryPanel, new Integer(1), 0);
				worldFrame.gridPanel.mapFormation();
			}
			
			revalidate();
			repaint();
		}
		

		
	}
	
	
	
	public static int generateRandom(int lowerLimit, int upperLimit) {
		return lowerLimit + (int) (Math.random() * (upperLimit - lowerLimit +1));
	}
	
	
	
	
	private String getSkill() {
		if(foe.getSuperAttacks().size() > 0)
			return foe.getSuperAttacks().get(0).getName();
		else if (foe.getUltimateAttacks().size() > 0)
			return foe.getUltimateAttacks().get(0).getName();
		return null;
	} 
	
	
	protected void paintComponent(Graphics G) {
		super.paintComponent(G);
		G.drawImage(image, 0, 0, this);
	}
	
	public void afterWin(){
		levelUp = (finalLevel - initialLevel) != 0;
		afterWinPanel = new BattleAfterWinPanel(levelUp, game, (me.getXp() + (foe.getLevel() * 5)), newXpValue, gainedSkillName);
		afterWinPanel.setLocation(250, 75);
		afterWinPanel.closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				battleFrame.dispose();
				worldFrame.setVisible(true);
				worldFrame.revalidate();
				worldFrame.repaint();
			}
		});
		levelUpPanel = new BattleLevelUpPanel(game, newLevelValue, newTargetXpValue, newAbiltyPointsValue);
		levelUpPanel.setLocation(250, 75);
		levelUpPanel.closeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				battleFrame.dispose();
				worldFrame.setVisible(true);
				worldFrame.revalidate();
				worldFrame.repaint();
			}
		});
		
		afterWinPanel.doubleArrow.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				remove(afterWinPanel);
				add(levelUpPanel, new Integer(2), 0);
				
				revalidate();
				repaint();
			}
		});
		add(afterWinPanel, new Integer(2), 0);
	}
	
	
	public void delayTurn(int time) {
		Timer timer = new Timer();
		timer.scheduleAtFixedRate(new TimerTask() {
			int i = time;
			@Override
			public void run() {
				i--;
				if(i < 0) {
					timer.cancel();
					meTurnIndicator.setVisible(false);
					foeTurnIndicator.setVisible(true);
					try {
						battle.play();
					} catch (NotEnoughKiException e1) {
						try {
							battle.attack(new PhysicalAttack());
						} catch (NotEnoughKiException e2) {
							e2.printStackTrace();
						}
					}
				}
				
			}
		},0,1000);
	}

}
