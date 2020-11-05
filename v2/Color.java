package v2;

public enum Color 
{
    RED('r'), GREEN('g'), BLUE ('b'), YELLOW('y'), ORANGE('o'), PINK('p');

    private char letter;

    Color(char letter) 
    {
        this.letter = letter;
    }

    public static final String COLOR_LETTERS = Color.valuesToString();

    public static Color getColorByLetter(final char letter)
    {
        for (Color color : Color.values())
            if (color.letter == letter)
                return color;

        return null;
    }

    public static boolean isValidLetter(char letter)
    {
        return null != Color.getColorByLetter(letter);
    }

    public boolean isSameColorAs(Color other){
        return this.letter == other.letter;
    }

    public String toString(){ return ""+letter; }
    
    private static String valuesToString(){

        String result = "";
        for (Color color : Color.values()) {
            result += color.letter;
        }
        return result;
    }

}