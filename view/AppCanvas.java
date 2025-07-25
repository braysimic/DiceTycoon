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


	if(game.getOddEvenWinnings() != 0) {
		if (game.getOddEvenWinnings() > 0) {
			g2.setColor(Color.BLUE);
			g2.drawString(String.format("Bet on odd/even won: +$%d", game.getOddEvenWinnings()), 50, 245);
		} else {
			g2.setColor(Color.RED);
			g2.drawString(String.format("Bet on odd/even lost: -$%d", -game.getOddEvenWinnings()), 50, 245);
		}
	} else {
		g2.setColor(Color.BLACK);
		g2.drawString("No bet on odd/even", 50, 245);
	}

	if(game.getRangeWinnings() != 0) {
		if (game.getRangeWinnings() > 0) {
			g2.setColor(Color.BLUE);
			g2.drawString(String.format("Bet on range won: +$%d", game.getRangeWinnings()), 50, 270);
		} else {
			g2.setColor(Color.RED);
			g2.drawString(String.format("Bet on range lost: -$%d", -game.getRangeWinnings()), 50, 270);
		} 
	} else {
		g2.setColor(Color.BLACK);
		g2.drawString("No bet on range", 50, 270);
	}

		g2.setColor(Color.YELLOW);
		g2.fillOval(95, 60, 175, 175);
		g2.setColor(Color.BLACK);

		String keyString = String.valueOf(game.getKey()); // Convert key to string
		g2.setFont(new Font("Courier New", Font.BOLD, 85)); // Set font for the key
		g2.drawString(keyString, 155, 170);

	}

	private void drawPlayingCanvas(Graphics2D g2) {

		g2.setFont(new Font("Courier New", Font.BOLD, 16));
		DiceRollGame game = App.game;

		g2.setColor(Color.YELLOW);
		g2.fillOval(95, 60, 175, 175);
		g2.setColor(Color.BLACK);

		g2.setFont(new Font("Courier New", Font.BOLD, 85));
		g2.drawString("?", 155, 170);
		return;

	}

	private void drawInitCanvas(Graphics2D g2) {

		g2.setFont(new Font("Courier New", Font.BOLD, 16));
		g2.setColor(initialMessageColor);
		var message1 = "Press <New Game> Button to start";
		var message2 = "Welcome to the Dice Roll Game!";
		g2.drawString(message1, 30, 150);
		g2.drawString(message2, 30, 130);
	}

}
