package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.DiceRollGame;
import model.GameState;

public class PlayButtonListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		DiceRollGame game = App.game;
		// GameWindow window = App.win;

		if (game.getState() == GameState.PLAYING) {
            
            game.setState(GameState.OVER); 
			game.calculateWinnings();
            App.win.updateWindow(); 
        }

	}
}
