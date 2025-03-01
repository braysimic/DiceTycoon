package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.DiceRollGame;
import model.GameState;

public class PlayButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		DiceRollGame game = App.game;

		if (!game.isBetPlaced()) {
			System.out.println("Place you bets first");
			return;
		}

		game.rollDice();
		game.calculateWinnings();

		game.setState(GameState.OVER);

		App.win.updateWindow();

	}
}
