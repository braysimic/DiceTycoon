package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.DiceRollGame;

public class PlayButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		DiceRollGame game = App.game;

		if(!game.isBetPlaced()) {
			System.out.println("place your bets first");
			return;
		}

		game.rollDice();
		game.calculateWinnings();
		App.win.updateWindow();
	}
	
}
