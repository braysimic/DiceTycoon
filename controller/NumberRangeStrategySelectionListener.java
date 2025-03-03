package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.NumberRangeStrategy;

public class NumberRangeStrategySelectionListener implements ActionListener {

	private final NumberRangeStrategy selectedRangeStrategy;

	public NumberRangeStrategySelectionListener(NumberRangeStrategy selectedRangeStrategy) {
		this.selectedRangeStrategy = selectedRangeStrategy;
	}

	@Override
	public void actionPerformed(ActionEvent e) {


		App.game.setStrategy(App.game.getStrategy1(), selectedRangeStrategy);

	}

}
