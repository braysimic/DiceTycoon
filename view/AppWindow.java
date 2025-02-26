package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.font.NumericShaper.Range;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
// import javax.swing.border.Border;
import javax.swing.JPanel;
// import javax.swing.border.Border;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

public class AppWindow extends JFrame{

	public static final String radioButtonActionOdd = "Odd";
	public static final String radioButtonActionEven = "Even";
	public static final String comboBoxActionAmount1 = "Choose Amount";

	public static final String radioButtonActionOneTwo = "1-2";
	public static final String radioButtonActionThreeFour = "3-4";
	public static final String radioButtonActionFiveSix = "5-6";
	public static final String comboBoxActionAmount2 = "Choose Amount";

	public static final String buttonActionPlay = "Play";
	public static final String buttonActionNewGame = "New Game";
	public static final String buttonActionQuit = "QUIT";

	public static final String checkButtonActionShowKey = "Show Key";

	public static final String[] bettingAmounts = {"Choose Amount","$10", "$20" , "$30"};




	private AppCanvas canvas = new AppCanvas();
	
	public void init() {



		var cp = getContentPane();
		cp.add(this.canvas, BorderLayout.CENTER);

		JPanel southPanel = new JPanel();
		cp.add(southPanel, BorderLayout.SOUTH);

		southPanel.setLayout(new GridLayout(4,1));

		JPanel OddEvenPanel = new JPanel();
		JRadioButton oddButton = new JRadioButton(radioButtonActionOdd);
		JRadioButton evenButton = new JRadioButton(radioButtonActionEven);
		JComboBox<String> oddEvenBetAmount = new JComboBox<>(bettingAmounts);
		// JComboBox chooseAmountButton = new JComboBox(comboBoxActionAmount1);
		OddEvenPanel.add(oddButton);
		OddEvenPanel.add(evenButton);
		OddEvenPanel.add(oddEvenBetAmount);
		southPanel.add(OddEvenPanel);
		OddEvenPanel.setBorder(new TitledBorder("Bet on Odd/Even (2x Winnings)"));

		JPanel RangePanel = new JPanel();
		JRadioButton oneToTwoButton = new JRadioButton(radioButtonActionOneTwo);
		JRadioButton threeToFourButton = new JRadioButton(radioButtonActionThreeFour);
		JRadioButton fiveToSixButton = new JRadioButton(radioButtonActionFiveSix);
		JComboBox<String> numberRangeBetAmount = new JComboBox<>(bettingAmounts);
		RangePanel.add(oneToTwoButton);
		RangePanel.add(threeToFourButton);
		RangePanel.add(fiveToSixButton);
		RangePanel.add(numberRangeBetAmount);
		southPanel.add(RangePanel);
		RangePanel.setBorder(new TitledBorder("Bet on Number Range (3x Winnings)"));


		JPanel PlayNewGamePanel = new JPanel();
		JButton playButton = new JButton(buttonActionPlay);
		JButton newGameButton = new JButton(buttonActionNewGame);
		JButton quitButton = new JButton(buttonActionQuit);
		PlayNewGamePanel.add(playButton);
		PlayNewGamePanel.add(newGameButton);
		PlayNewGamePanel.add(quitButton);
		southPanel.add(PlayNewGamePanel);
		PlayNewGamePanel.setBorder(new TitledBorder("Play / New Game"));

		JPanel ShowKeyPanel = new JPanel();
		JCheckBox showKeyButton = new JCheckBox(checkButtonActionShowKey);
		ShowKeyPanel.add(showKeyButton);
		southPanel.add(ShowKeyPanel);
		ShowKeyPanel.setBorder(new TitledBorder("Show Key"));

	}
}
