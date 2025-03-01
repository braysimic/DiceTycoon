package controller;

import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JCheckBox;

import model.DiceRollGame;

public class ShowKeyButtonListener implements ItemListener{

	@Override
	public void itemStateChanged(ItemEvent e) {
		
		JCheckBox option = (JCheckBox) e.getSource();

		boolean checked = option.isSelected();
		App.game.setShowKeyOn(checked);
		App.win.updateWindow();
		
		
	}
	
}
