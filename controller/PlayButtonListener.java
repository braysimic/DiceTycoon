package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.DiceRollGame;
import model.GameState;

public class PlayButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		DiceRollGame game = App.game;

		if(game.getbetOddEvenAmount() == 0 && game.getbetRangeAmount() == 0) {

			JOptionPane.showMessageDialog(
				App.win,
				"Please place your bet before playing.",
				"Message",
				JOptionPane.WARNING_MESSAGE
			);
			return;
		}

		if (game.getState() == GameState.PLAYING) {

			game.calculateWinnings();
			game.setState(GameState.OVER);
			App.win.updateWindow();
		}

	}
}
