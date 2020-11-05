package v2;

public class SecretCombination extends Combination {

    public SecretCombination() {
		super(generateRandomString());
    }

	public Result evalueCombination(ProposedCombination proposedCombination){
        
		int blacks = 0;
		int whites = 0;

		for(int p = 0; p < Combination.COMBINATION_LENGTH; p++) {
			for(int c = 0; c < Combination.COMBINATION_LENGTH; c++) {
				if(proposedCombination.colors[p].isSameColorAs(this.colors[c])){
					if(p == c)
						blacks ++;
					else
						whites ++;
				}
			}
		}

        return new Result(blacks, whites);
	}

    private static String generateRandomString() {

		String result = "";
		String availableColors = Color.COLOR_LETTERS;
	    
	    while(result.length() < COMBINATION_LENGTH) {
	    	var randomIndex = randomIndex(availableColors.length());
	    	var electedColor = availableColors.charAt(randomIndex);
	    	result += electedColor;
	        availableColors = availableColors.replaceFirst("" + electedColor, "");
	    }

	    return result;
	}

	private static int randomIndex(int arrayLenght) {
		return (int)(Math.random() * arrayLenght);
	}

}
