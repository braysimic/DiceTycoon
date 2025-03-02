package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class NumberRangeAmountSelectionListener implements ActionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		
		JComboBox<String> comboBox = (JComboBox<String>) e.getSource();
        String selectedAmount = (String) comboBox.getSelectedItem();
        int amount = parseBetAmount(selectedAmount); // Convert "$10" to 10, etc.
        App.game.placeRangeBet(amount);
    }

    private int parseBetAmount(String amountStr) {
        if (amountStr.equals("Choose Amount")) return 0;
        return Integer.parseInt(amountStr.replace("$", ""));
    }
}
	

	

