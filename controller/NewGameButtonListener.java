package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.GameState;

public class NewGameButtonListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {

		App.game.start();
		App.game.setState(GameState.PLAYING);
		App.win.setDefaultSelections();
		App.win.updateWindow();
	}

}
