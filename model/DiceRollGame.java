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
	private int oddEvenWinnings;
	private int rangeWinnings;
	private boolean oddEvenBetPlaced;
	private boolean rangeBetPlaced;

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
		if (!oddEvenBetPlaced && !rangeBetPlaced) {
			System.out.println("No bets placed, skipping calculation");
			return;
		}

		int oddEvenWinnings = 0;
		int rangeWinnings = 0;

		if(oddEvenBetPlaced) {
		if ((strategy1 == OddEvenStrategy.Odd && key % 2 != 0) ||
				(strategy1 == OddEvenStrategy.Even && key % 2 == 0)) {
			oddEvenWinnings += betOddEvenAmount * 2;
		} else {
			oddEvenWinnings = -betOddEvenAmount;
		}
	} else {
		System.out.println("No be on odd/even");
	}

	if(rangeBetPlaced) {
		if ((strategy2 == NumberRangeStrategy.onetotwo && key >= 1 && key <= 2) ||
				(strategy2 == NumberRangeStrategy.threetofour && key >= 3 && key <= 4) ||
				(strategy2 == NumberRangeStrategy.fivetosix && key >= 5 && key <= 6)) {
			rangeWinnings += betRangeAmount * 3;
		} else {
			rangeWinnings = -betRangeAmount;
		}
	} else {
		System.out.println("No bet on range");
	}

		balance += (oddEvenWinnings + rangeWinnings);

		this.oddEvenWinnings = oddEvenWinnings;
		this.rangeWinnings = rangeWinnings;

		betOddEvenAmount = 0;
		betRangeAmount = 0;
		betPlaced = false;
		rangeBetPlaced = false;
		oddEvenBetPlaced = false;
	}

	public void start() {
		key = generateNewKey();
		state = GameState.PLAYING;
		betPlaced = false;
		betOddEvenAmount = 0;
		betRangeAmount = 0;
	}

	private int generateNewKey() {
		return (int) (Math.random() * MAX_KEY) + 1;

	}

	public void placeOddEvenBet(int amount) {
		betOddEvenAmount = amount;
		oddEvenBetPlaced = (amount > 0);
		betPlaced = true;
	}

	public void placeRangeBet(int amount) {
		betRangeAmount = amount;
		rangeBetPlaced = (amount > 0);
		betPlaced = true;
	}

	public int getOddEvenWinnings() {
		return oddEvenWinnings;
	}

	public int getRangeWinnings() {
		return rangeWinnings;
	}

	public void setShowKeyOn(boolean showKeyOn) {

		this.showKeyOn = showKeyOn;
	}

	public int getKey() {

		return key;
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
