package view;

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
	
	public AppCanvas() {
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
	}

	private void drawTextStrings(Graphics2D g2) {
		DiceRollGame diceRollGame = App.diceRollGame;
		g2.drawString(
			String.format("Balance = %dc", diceRollGame.getBalance()),
		200, 15);
		g2.drawString(
			String.format("Welcome to the Dice Roll Game!"), 
		50, 100
		);
		g2.drawString(String.format("Press <New Game> to Start"), 
		50, 150
		);
		
	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		drawTextStrings(g2);

		

				
			}
		
			

}
