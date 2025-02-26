package controller;

import javax.swing.JFrame;

import model.DiceRollGame;
import view.AppWindow;

public class App {
	
	public static final AppWindow win = new AppWindow();
	public static final DiceRollGame diceRollGame = new DiceRollGame();

	public static void main(String[] args) {
		
		// win.init();
		win.setTitle("Betting Dice Roll Game");
		win.init();
		win.setLocation(300, 200);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		win.pack();
		win.setVisible(true);
		
	}
}
