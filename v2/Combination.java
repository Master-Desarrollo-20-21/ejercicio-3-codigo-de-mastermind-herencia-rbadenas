package v2;

public abstract class Combination {

	public static final int COMBINATION_LENGTH = 4;

	protected Color[] colors;

    protected Combination(String combination){

		this.colors = new Color[COMBINATION_LENGTH];

		for(int i=0; i<COMBINATION_LENGTH; i++){
			this.colors[i] = Color.getColorByLetter(combination.charAt(i));
		}
	}
	
    public static boolean isValid(String proposedColors) {
		
		if (proposedColors.length() != COMBINATION_LENGTH)
			return false;

		if(hasDuplicateColors(proposedColors))
			return false;
		
		for (int i = 0; i < proposedColors.length(); i++) {
			if (!isValidColor(proposedColors.charAt(i)))
				return false;
		}

		return true;
	}
	
	public static void printErrors(String proposedColors) {
		Console console = new Console();
		
		if (proposedColors.length() != COMBINATION_LENGTH) {
			console.out("Wrong proposed combinations length" + "\n");
		}

		if(hasDuplicateColors(proposedColors)) {
			console.out("Wrong proposed combinations duplicate characters" + "\n");
		}
		
		for (int i = 0; i < proposedColors.length(); i++) {
			if (!isValidColor(proposedColors.charAt(i))) {
				console.out("Wrong colors, they must be: " + Color.COLOR_LETTERS + "\n");
				break;
			}
		}

	}

	private static boolean isValidColor(char proposedColor) {
		return Color.isValidLetter(proposedColor);
	}

	private static boolean hasDuplicateColors(String proposedColors) {

		char[] inp = proposedColors.toCharArray();
		
		for (int i = 0; i < proposedColors.length(); i++) {
			for (int j = i + 1; j < proposedColors.length(); j++) {
				if (inp[i] == inp[j]) {
					return true;
				}
			}
		}

		return false;

	}
	
}