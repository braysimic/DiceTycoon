package model;

public class DiceRollGame {

	public static final int MAX_KEY = 6;

	private int key;
	private int balance;
	private boolean showKeyOn;
	private int betOddEvenAmount;
	private int betRangeAmount;
	private GameState state;
	private OddEvenStrategy strategy1;
	private NumberRangeStrategy strategy2;
	private boolean betPlaced = false;

	public DiceRollGame() {
		key = -1;
		balance = 100;
		showKeyOn = false;
		state = GameState.INIT;
		strategy1 = OddEvenStrategy.Odd;
		strategy2 = NumberRangeStrategy.onetotwo;
	}

	public void rollDice() {
		key = generateNewKey();
		state = GameState.PLAYING;
	}

	public void calculateWinnings() {
		if (!betPlaced) {
			return;
		}

		int winnings = 0;

		if(betOddEvenAmount > 0) {
			if((strategy1 == OddEvenStrategy.Odd && key % 2 != 0) ||
			(strategy1 == OddEvenStrategy.Even && key % 2 == 0)) {
				winnings += betOddEvenAmount * 2;
			} else {
				winnings -= betOddEvenAmount;
			}
		}

		if (betRangeAmount > 0) {
			if ((strategy2 == NumberRangeStrategy.onetotwo && key >= 1 && key <= 2) ||
			(strategy2 == NumberRangeStrategy.threetofour && key >= 3 && key <= 4) ||
			(strategy2 == NumberRangeStrategy.fivetosix && key >= 5 && key <= 6)) {
				winnings += betRangeAmount * 3;
			} else {
				winnings -= betRangeAmount;
			}
		}

		balance += winnings;
		betPlaced = false;
		betOddEvenAmount = 0;
		betRangeAmount = 0;
	}

	public void start() {
		key = generateNewKey();
		state = GameState.PLAYING;
		betPlaced = false;
	}

	private int generateNewKey() {
		return (int) (Math.random() * MAX_KEY) + 1;

	}

	public void placeOddEvenBet(int amount) {
		betOddEvenAmount = amount;
		betPlaced = true;
	}

	public void placeRangeBet(int amount) {
		betRangeAmount = amount;
		betPlaced = true;
	}

	public void setShowKeyOn(boolean showKeyOn) {

		this.showKeyOn = showKeyOn;
	}

	public int getKey() {

		if (showKeyOn) {
			return key;
		} else {
			return -1;
		}
	}

	public boolean isShowKeyOn() {
		return showKeyOn;
	}

	public int getBalance() {

		return balance;
	}

	public GameState getState() {

		return state;
	}

	public OddEvenStrategy getStrategy1() {

		return strategy1;
	}

	public NumberRangeStrategy getStrategy2() {

		return strategy2;
	}

	public int getbetOddEvenAmount() {

		return betOddEvenAmount;
	}

	public int getbetRangeAmount() {

		return betRangeAmount;
	}

	public void setBetOddEvenAmount(int amount) {

		this.betOddEvenAmount = amount;
	}

	public void setBetRangeAmount(int amount) {

		this.betRangeAmount = amount;
	}

	public void setState(GameState state) {

		this.state = state;
	}

	public void setStrategy(OddEvenStrategy strategy1, NumberRangeStrategy strategy2) {

		this.strategy1 = strategy1;
		this.strategy2 = strategy2;
	}

	public boolean isBetPlaced() {
		
		return betPlaced;
	}

}
