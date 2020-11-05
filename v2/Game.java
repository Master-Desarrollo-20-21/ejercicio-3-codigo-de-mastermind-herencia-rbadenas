package v2;

public class Game {

	public static final int MAX_ATTEMPTS = 10;
	private SecretCombination secretCombination;
	private Attempt[] attempts;
	private int attemptCount;

	public Game(){
		secretCombination = new SecretCombination();
		attempts = new Attempt[MAX_ATTEMPTS];
		attemptCount = 0;
	}

    public void play() {

		new Console().out("----- MASTERMIND -----");
		
		do {
			this.newAttempt();
			this.printAttempts();
		}while(!isGameOver());

		this.printGameResult();
	}

	private void newAttempt(){
		this.attempts[attemptCount] = new Attempt(secretCombination);
		this.attemptCount++;
	}

	private void printAttempts() {
		new Console().out("\n\n" + attemptCount + " attempt(s):\nxxxx");
		for(int i=0; i<attemptCount; i++){
			attempts[i].show();
		}
	}

	private void printGameResult() {
		if(lastAttemptIsSuccessful()){ 
			new Console().out("You've won!!! ;-)\n");
		}

		if (this.isMaxAttemptsExceeded()) {
			new Console().out("You've lost!!! :-(\n");
		}
	}
	
	private boolean isGameOver() {
		return this.lastAttemptIsSuccessful() || this.isMaxAttemptsExceeded();
	}

	private boolean isMaxAttemptsExceeded() {
		return this.attemptCount == MAX_ATTEMPTS;
	}

	private boolean lastAttemptIsSuccessful() {
		return this.attempts[attemptCount - 1].isSuccessful();
	}

}