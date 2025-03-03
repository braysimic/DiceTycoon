package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
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
import controller.NewGameButtonListener;
import controller.NumberRangeAmountSelectionListener;
import controller.NumberRangeStrategySelectionListener;
import controller.OddEvenAmountSelectionListener;
import controller.OddEvenStrategySelectionListener;
import controller.PlayButtonListener;
import controller.ShowKeyButtonListener;
import model.NumberRangeStrategy;
import model.OddEvenStrategy;

public class AppWindow extends JFrame {

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

	public static final String[] bettingAmounts = { "Choose Amount", "$10", "$20", "$30" };

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

		southPanel.setLayout(new GridLayout(4, 1));

		JPanel OddEvenPanel = new JPanel();
		oddButton = new JRadioButton(radioButtonActionOdd,
				App.game.getStrategy1() == OddEvenStrategy.Odd);
		evenButton = new JRadioButton(radioButtonActionEven,
				App.game.getStrategy1() == OddEvenStrategy.Even);
		oddEvenBetAmount = new JComboBox<>(bettingAmounts);
		OddEvenPanel.add(oddButton);
		OddEvenPanel.add(evenButton);
		OddEvenPanel.add(oddEvenBetAmount);

		oddEvenBetAmount.addActionListener(new OddEvenAmountSelectionListener());
		oddButton.addActionListener(new OddEvenStrategySelectionListener(OddEvenStrategy.Odd));
		evenButton.addActionListener(new OddEvenStrategySelectionListener(OddEvenStrategy.Even));

		ButtonGroup oddEvenGroup = new ButtonGroup();
		oddEvenGroup.add(oddButton);
		oddEvenGroup.add(evenButton);
		southPanel.add(OddEvenPanel);

		OddEvenPanel.setBorder(new TitledBorder("Bet on Odd/Even (2x Winnings)"));

		JPanel RangePanel = new JPanel();
		oneToTwoButton = new JRadioButton(radioButtonActionOneTwo,
				App.game.getStrategy2() == NumberRangeStrategy.onetotwo);
		threeToFourButton = new JRadioButton(radioButtonActionThreeFour,
				App.game.getStrategy2() == NumberRangeStrategy.threetofour);
		fiveToSixButton = new JRadioButton(radioButtonActionFiveSix,
				App.game.getStrategy2() == NumberRangeStrategy.fivetosix);
		numberRangeBetAmount = new JComboBox<>(bettingAmounts);

		RangePanel.add(oneToTwoButton);
		RangePanel.add(threeToFourButton);
		RangePanel.add(fiveToSixButton);
		RangePanel.add(numberRangeBetAmount);
		// numberRangeBetAmount.addActionListener(new
		// NumberRangeAmountSelectionListener(numberRangeBetAmount));
		southPanel.add(RangePanel);

		oneToTwoButton.addActionListener(new NumberRangeStrategySelectionListener(NumberRangeStrategy.onetotwo));
		threeToFourButton.addActionListener(new NumberRangeStrategySelectionListener(NumberRangeStrategy.threetofour));
		fiveToSixButton.addActionListener(new NumberRangeStrategySelectionListener(NumberRangeStrategy.fivetosix));

		ButtonGroup rangeGroup = new ButtonGroup();
		rangeGroup.add(oneToTwoButton);
		rangeGroup.add(threeToFourButton);
		rangeGroup.add(fiveToSixButton);
		RangePanel.setBorder(new TitledBorder("Bet on Number Range (3x Winnings)"));
		numberRangeBetAmount.addActionListener(new NumberRangeAmountSelectionListener());

		JPanel PlayNewGamePanel = new JPanel();
		playButton = new JButton(buttonActionPlay);
		newGameButton = new JButton(buttonActionNewGame);
		quitButton = new JButton(buttonActionQuit);
		PlayNewGamePanel.add(playButton);
		playButton.addActionListener(new PlayButtonListener());
		PlayNewGamePanel.add(newGameButton);
		newGameButton.addActionListener(new NewGameButtonListener());
		PlayNewGamePanel.add(quitButton);
		quitButton.addActionListener(e -> System.exit(0));
		southPanel.add(PlayNewGamePanel);
		PlayNewGamePanel.setBorder(new TitledBorder("Play / New Game"));

		JPanel ShowKeyPanel = new JPanel();
		showKeyButton = new JCheckBox(checkButtonActionShowKey);
		ShowKeyPanel.add(showKeyButton);
		southPanel.add(ShowKeyPanel);
		ShowKeyPanel.setBorder(new TitledBorder("Show Key"));
		showKeyButton.addItemListener(new ShowKeyButtonListener());

		updateWindow();

	}

	public void setDefaultSelections() {

		oddButton.setSelected(true);
		evenButton.setSelected(false);

		oneToTwoButton.setSelected(true);
		threeToFourButton.setSelected(false);
		fiveToSixButton.setSelected(false);

		oddEvenBetAmount.setSelectedIndex(0);
		numberRangeBetAmount.setSelectedIndex(0);
	}

	public void updateWindow() {
		switch (App.game.getState()) {
			case INIT:
			case OVER:
				newGameButton.setEnabled(true);
				playButton.setEnabled(false);
				oddButton.setEnabled(false);
				evenButton.setEnabled(false);
				oneToTwoButton.setEnabled(false);
				threeToFourButton.setEnabled(false);
				fiveToSixButton.setEnabled(false);
				showKeyButton.setEnabled(false);
				numberRangeBetAmount.setEnabled(false);
				oddEvenBetAmount.setEnabled(false);
				break;
			case PLAYING:
				newGameButton.setEnabled(false);
				playButton.setEnabled(true);
				oddButton.setEnabled(true);
				evenButton.setEnabled(true);
				oneToTwoButton.setEnabled(true);
				threeToFourButton.setEnabled(true);
				fiveToSixButton.setEnabled(true);
				showKeyButton.setEnabled(true);
				numberRangeBetAmount.setEnabled(true);
				oddEvenBetAmount.setEnabled(true);
				break;

		}

		canvas.repaint();
	}
}
