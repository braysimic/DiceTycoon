package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
// import java.awt.font.NumericShaper.Range;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
// import javax.swing.border.Border;
import javax.swing.JPanel;
// import javax.swing.border.Border;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

import controller.App;
import controller.NumberRangeStrategySelectionListener;
import controller.OddEvenStrategySelectionListener;
// import controller.PlayButtonButtonListener;
import model.GameState;
import model.NumberRangeStrategy;
import model.OddEvenStrategy;

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
	
	private JButton playButton;
	private JRadioButton oddButton;
	private JRadioButton evenButton;
	private JComboBox<String> oddEvenBetAmount;
	private JRadioButton oneToTwoButton;
	private JRadioButton threeToFourButton;
	private JRadioButton fiveToSixButton;
	private JButton newGameButton;
	private JButton quitButton;
	private JComboBox<String> numberRangeBetAmount;
	private JCheckBox showKeyButton;

	public void init() {



		var cp = getContentPane();
		cp.add(this.canvas, BorderLayout.CENTER);

		JPanel southPanel = new JPanel();
		cp.add(southPanel, BorderLayout.SOUTH);

		southPanel.setLayout(new GridLayout(4,1));

		JPanel OddEvenPanel = new JPanel();
		oddButton = new JRadioButton(radioButtonActionOdd,
			App.game.getStrategy1() == OddEvenStrategy.Odd
		);
		evenButton = new JRadioButton(radioButtonActionEven,
			App.game.getStrategy1() == OddEvenStrategy.Even
		);
		oddEvenBetAmount = new JComboBox<>(bettingAmounts);
		OddEvenPanel.add(oddButton);
		OddEvenPanel.add(evenButton);
		OddEvenPanel.add(oddEvenBetAmount);
		OddEvenStrategySelectionListener oddEvenStrategySelectionListener = new OddEvenStrategySelectionListener();
		oddButton.addActionListener(oddEvenStrategySelectionListener);
		evenButton.addActionListener(oddEvenStrategySelectionListener);

		ButtonGroup oddEvenGroup = new ButtonGroup();
		oddEvenGroup.add(oddButton);
		oddEvenGroup.add(evenButton);

		southPanel.add(OddEvenPanel);
		OddEvenPanel.setBorder(new TitledBorder("Bet on Odd/Even (2x Winnings)"));

		JPanel RangePanel = new JPanel();
		oneToTwoButton = new JRadioButton(radioButtonActionOneTwo, 
			App.game.getStrategy2() == NumberRangeStrategy.onetotwo
			);
		threeToFourButton = new JRadioButton(radioButtonActionThreeFour,
			App.game.getStrategy2() == NumberRangeStrategy.threetofour
			);
		fiveToSixButton = new JRadioButton(radioButtonActionFiveSix,
			App.game.getStrategy2() == NumberRangeStrategy.fivetosix
			);
		numberRangeBetAmount = new JComboBox<>(bettingAmounts);

		RangePanel.add(oneToTwoButton);
		RangePanel.add(threeToFourButton);
		RangePanel.add(fiveToSixButton);
		RangePanel.add(numberRangeBetAmount);
		southPanel.add(RangePanel);
		NumberRangeStrategySelectionListener numberRangeStrategySelectionListener = new NumberRangeStrategySelectionListener();
		oneToTwoButton.addActionListener(oddEvenStrategySelectionListener);
		threeToFourButton.addActionListener(oddEvenStrategySelectionListener);
		fiveToSixButton.addActionListener(oddEvenStrategySelectionListener);

		ButtonGroup rangeGroup = new ButtonGroup();
        rangeGroup.add(oneToTwoButton);
        rangeGroup.add(threeToFourButton);
        rangeGroup.add(fiveToSixButton);
		RangePanel.setBorder(new TitledBorder("Bet on Number Range (3x Winnings)"));


		JPanel PlayNewGamePanel = new JPanel();
		playButton = new JButton(buttonActionPlay);
		newGameButton = new JButton(buttonActionNewGame);
		quitButton = new JButton(buttonActionQuit);
		PlayNewGamePanel.add(playButton);
		PlayNewGamePanel.add(newGameButton);
		PlayNewGamePanel.add(quitButton);
		quitButton.addActionListener(e -> System.exit(0));
		southPanel.add(PlayNewGamePanel);
		PlayNewGamePanel.setBorder(new TitledBorder("Play / New Game"));

		JPanel ShowKeyPanel = new JPanel();
		JCheckBox showKeyButton = new JCheckBox(checkButtonActionShowKey);
		ShowKeyPanel.add(showKeyButton);
		southPanel.add(ShowKeyPanel);
		ShowKeyPanel.setBorder(new TitledBorder("Show Key"));


	}
}
