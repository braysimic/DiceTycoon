package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.OddEvenStrategy;
import view.AppWindow;

public class OddEvenStrategySelectionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		switch (action) {
			case AppWindow.radioButtonActionOdd:
				App.game.setStrategy(OddEvenStrategy.Odd, App.game.getStrategy2());
				break;
			case AppWindow.radioButtonActionEven:
				App.game.setStrategy(OddEvenStrategy.Even, App.game.getStrategy2());
				break;
		
		}
	}
	
}
