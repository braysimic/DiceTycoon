package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

public class OddEvenAmountSelectionListener implements ActionListener{


	private JComboBox<String> oddEvenBetAmount;

    // Constructor that accepts the combo box as a parameter
    public OddEvenAmountSelectionListener(JComboBox<String> oddEvenBetAmount) {
        this.oddEvenBetAmount = oddEvenBetAmount;
    }

	@Override
	public void actionPerformed(ActionEvent e) {
		
		String selectedAmount = (String) oddEvenBetAmount.getSelectedItem();
		System.out.println("Odd/Even Bet Amount Selected: " + selectedAmount);
	}
	
}
