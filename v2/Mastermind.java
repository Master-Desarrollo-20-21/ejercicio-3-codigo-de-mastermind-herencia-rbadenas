package v2;

public class Mastermind {

    private Game game;

	public Mastermind() { }

	public void play() {
		
		do {
			this.newGameInitialization();
            this.game.play();
		}while(!this.isResumed());

	}

	public static void main(String[] args) {
		new Mastermind().play();
	}

	private void newGameInitialization(){
		this.game = new Game();
	}
	
    private boolean isResumed(){
		String answer ="";

		do{
			answer = new Console().askForString("RESUME? (y/n): ").toLowerCase();
		}
		while(!answer.equals("y") && !answer.equals("n"));

        return answer.equals("y");
	}

}