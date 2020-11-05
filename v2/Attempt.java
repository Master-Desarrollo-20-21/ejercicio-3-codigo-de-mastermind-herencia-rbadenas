package v2;

public class Attempt {

    private ProposedCombination proposedCombination;
    private Result result;

    public Attempt(SecretCombination secret) {
        this.proposedCombination = askForCombination();
        this.result = secret.evalueCombination(proposedCombination);
    }

    public boolean isSuccessful(){
        return this.result.hasAllBlacks();
    }

    public void show(){
        Console console = new Console();
        console.out(proposedCombination.toString() + " --> " + result);
    }

    private ProposedCombination askForCombination(){
        
        String answer ="";
		do{
            answer = new Console().askForString("Propose a combination:\n").toLowerCase();
			if(!Combination.isValid(answer)){
                Combination.printErrors(answer);
			}
		}
		while(!Combination.isValid(answer));
        
        return new ProposedCombination(answer);
    }

}