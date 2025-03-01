package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.NumberRangeStrategy;
import view.AppWindow;

public class NumberRangeStrategySelectionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		switch (action) {
			case AppWindow.radioButtonActionOneTwo:
				App.game.setStrategy(App.game.getStrategy1(), NumberRangeStrategy.onetotwo);
				break;
			case AppWindow.radioButtonActionThreeFour:
				App.game.setStrategy(App.game.getStrategy1(), NumberRangeStrategy.threetofour);
				break;
			case AppWindow.radioButtonActionFiveSix:
				App.game.setStrategy(App.game.getStrategy1(), NumberRangeStrategy.fivetosix);
				break;
		
		}
	}
	
}
