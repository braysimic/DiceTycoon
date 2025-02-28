package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import controller.App;
import model.DiceRollGame;
import model.GameState;

public class AppCanvas extends JPanel {

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
		DiceRollGame diceRollGame = App.game;
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

		// g2.setColor(Color.WHITE);
		// g2.fillRect(0,0,WIDTH, HEIGHT);
		// drawTextStrings(g2);

		// DiceRollGame diceRollGame = App.game;
		// if (diceRollGame.getState() == GameState.PLAYING) {

		// 	g2.setColor(Color.BLACK);
		// 	g2.fillOval(WIDTH / 2 - 50, HEIGHT /2 - 50, 100, 100);
		// 	g2.setColor(Color.WHITE);
		// 	g2.setFont(new Font("Arial", Font.BOLD, 30));
		// 	g2.drawString("?", WIDTH / 2 - 10, HEIGHT / 2 + 10);
		// }

		// if (diceRollGame.getState() == GameState.PLAYING && diceRollGame.getKey() != -1) {

		// 	g2.setColor(Color.BLACK);
		// 	g2.setFont(new Font("Arial", Font.BOLD, 20));
		// 	g2.drawString("Key: " + diceRollGame.getKey(), WIDTH / 2 - 30, HEIGHT / 2 + 60);
		// }



	}


}
