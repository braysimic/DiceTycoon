package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import controller.App;
import model.DiceRollGame;
import model.NumberRangeStrategy;
import model.OddEvenStrategy;

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
	}

	@Override
	public void paintComponent(Graphics g) {

		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;
		drawTextStrings(g2);

		if (App.game.isShowKeyOn()) {

			var keyString = String.format("Key: %d", App.game.getKey());
			g2.drawString(keyString, 10, 20);
		}

		switch (App.game.getState()) {
			case INIT:
				drawInitCanvas(g2);
				break;
			case PLAYING:
				drawPlayingCanvas(g2);
				break;
			case OVER:
				drawOverCanvas(g2);
				break;
		}
	}

	private void drawOverCanvas(Graphics2D g2) {

		g2.setFont(new Font("Courier New", Font.BOLD, 16));
		DiceRollGame game = App.game;

		if ((game.getStrategy1() == OddEvenStrategy.Odd && game.getKey() % 2 != 0) ||
				(game.getStrategy1() == OddEvenStrategy.Even && game.getKey() % 2 == 0)) {
			g2.setColor(Color.GREEN);
			g2.drawString(String.format("Bet on odd/even won: +$%d", game.getbetOddEvenAmount() * 2), 50, 245);
		} else {
			g2.setColor(Color.RED);
			g2.drawString(String.format("Bet on odd/even lost: -$%d", game.getbetOddEvenAmount()), 50, 245);
		}

	
		if ((game.getStrategy2() == NumberRangeStrategy.onetotwo && game.getKey() >= 1 && game.getKey() <= 2) ||
				(game.getStrategy2() == NumberRangeStrategy.threetofour && game.getKey() >= 3 && game.getKey() <= 4) ||
				(game.getStrategy2() == NumberRangeStrategy.fivetosix && game.getKey() >= 5 && game.getKey() <= 6)) {
			g2.setColor(Color.GREEN);
			g2.drawString(String.format("Bet on range won: +$%d", game.getbetRangeAmount() * 3), 50, 270);
		} else {
			g2.setColor(Color.RED);
			g2.drawString(String.format("Bet on range lost: -$%d", game.getbetRangeAmount()), 50, 270);
		}
	

		g2.setColor(Color.YELLOW);
		g2.fillOval(95, 60, 175, 175);
		g2.setColor(Color.BLACK);

		String keyString = String.valueOf(game.getKey()); // Convert key to string
		g2.setFont(new Font("SansSerif", Font.BOLD, 75)); // Set font for the key
		g2.drawString(keyString, 155, 170);

		// g2.setFont(new Font("Arial", Font.PLAIN, 50));
		// g2.drawString(getKey(), 175, 175);

		// Display the updated balance
		// g2.setColor(Color.BLACK);
		// g2.drawString(String.format("Current Balance: $%d", game.getBalance()), 50, y
		// + 20);
	}

	private void drawPlayingCanvas(Graphics2D g2) {

		g2.setFont(new Font("Courier New", Font.BOLD, 16));
		DiceRollGame game = App.game;

		g2.setColor(Color.YELLOW);
		g2.fillOval(95, 60, 175, 175);
		g2.setColor(Color.BLACK);

		g2.setFont(new Font("SansSerif", Font.BOLD, 75));
		g2.drawString("?", 165, 170);
		return;

	}

	private void drawInitCanvas(Graphics2D g2) {

		g2.setFont(new Font("Courier New", Font.BOLD, 16));
		g2.setColor(initialMessageColor);
		var message1 = "Welcome to the Dice Roll Game!";
		var message2 = "Press <New Game> Button to start";
		g2.drawString(message1, 30, 150);
		g2.drawString(message2, 30, 130);
	}

}
