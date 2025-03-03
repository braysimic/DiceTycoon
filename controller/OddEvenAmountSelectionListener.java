package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import model.OddEvenStrategy;

public class OddEvenAmountSelectionListener implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox<String> comboBox = (JComboBox<String>) e.getSource();
        String selectedAmount = (String) comboBox.getSelectedItem();
        int amount = parseBetAmount(selectedAmount);
        App.game.placeOddEvenBet(amount);
    }

    private int parseBetAmount(String amountStr) {
        if (amountStr.equals("Choose Amount"))
            return 0;
        return Integer.parseInt(amountStr.replace("$", ""));
    }
}
