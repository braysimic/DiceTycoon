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

	public DiceRollGame() {
		key = -1;
		balance = 100;
		showKeyOn = false;
		state = GameState.INIT;
		strategy1 = OddEvenStrategy.Odd;
		strategy2 = NumberRangeStrategy.onetotwo;
	}

	public void start() {
		key = generateNewKey();
				balance = 100;
				state = GameState.PLAYING;
			}
	
	private int generateNewKey() {
		return(int) (Math.random() * MAX_KEY) + 1;
				
	}

	public void placeOddEvenBet(int amount) {
		betOddEvenAmount = amount;
		if(strategy1 == OddEvenStrategy.Odd && key % 2 != 0) {
			balance += amount;
		} else if (strategy1 == OddEvenStrategy.Even && key % 2 == 0) {
			balance += amount;
		} else {
			balance -= amount;
		}
	}

	public void placeRangeBet(int amount) {
		betRangeAmount = amount;
		if ((strategy2 == NumberRangeStrategy.onetotwo && key >= 1 && key <= 2) ||
		(strategy2 == NumberRangeStrategy.threetofour && key >= 3 && key <= 4) ||
		(strategy2 == NumberRangeStrategy.fivetosix && key >= 5 && key <= 6)) {

			balance += amount;
		} else {
			balance -= amount;
		}
	}

	public void checkKey() {

		showKeyOn = true;
	}

	public int getKey() {
		
		if (showKeyOn) {
			return key;
		} else {
			return -1;
		}
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

	public void setbetOddEvenAmount(int amount) {

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
	
		
}
	



