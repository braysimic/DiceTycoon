package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class NumberRangeAmountSelectionListener implements ActionListener{


	private JComboBox<String> numberRangeBetAmount;

    // Constructor that accepts the combo box as a parameter
    public NumberRangeAmountSelectionListener(JComboBox<String> numberRangeBetAmount) {
        this.numberRangeBetAmount = numberRangeBetAmount;
    }

	@Override
	public void actionPerformed(ActionEvent e) {

		String selectedAmount = (String) numberRangeBetAmount.getSelectedItem();
		
		System.out.println("Range Bet Amount Selected: " + selectedAmount);
	}
	
}
