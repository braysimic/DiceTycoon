package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import controller.App;
import model.DiceRollGame;

public class AppCanvas extends JPanel{

	public static final int WIDTH = 300;
	public static final int HEIGHT = 300;
	public static final Color initialMessageColor = Color.BLUE;
	public static final Color balanceColor = Color.BLACK;
	final Font balanceFont = new Font("Courier New", Font.BOLD, 14);
	final Font initialMessageFont = new Font("Courier New", Font.BOLD, 17);
	
	
	public AppCanvas() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}

	private void drawTextStrings(Graphics2D g2) {
		DiceRollGame diceRollGame = App.diceRollGame;
		g2.setFont(balanceFont);
		g2.setColor(balanceColor);
		g2.drawString(
			String.format("Balance = $%d", diceRollGame.getBalance()),
		245, 15);

		g2.setColor(initialMessageColor);
		g2.setFont(initialMessageFont);
		g2.drawString(("Welcome to the Dice Roll Game!"), 30, 100);
		g2.drawString(("Press <New Game> to Start"), 30, 130);
		
	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		drawTextStrings(g2);

		

				
			}
		
			

}
