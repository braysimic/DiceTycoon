package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import model.OddEvenStrategy;

public class OddEvenStrategySelectionListener implements ActionListener {

	private final OddEvenStrategy selectedOddEvenStrategy;

	public OddEvenStrategySelectionListener(OddEvenStrategy seleceOddEvenStrategy) {
		this.selectedOddEvenStrategy = seleceOddEvenStrategy;
	}

	@Override
	public void actionPerformed(ActionEvent e) {


		App.game.setStrategy(selectedOddEvenStrategy, App.game.getStrategy2());

	}
}
