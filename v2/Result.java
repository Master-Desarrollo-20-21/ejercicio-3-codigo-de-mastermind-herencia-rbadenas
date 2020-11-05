package v2;

public class Result {

    private int blacks;
    private int whites;

	public Result(int blacks, int whites) {
        this.blacks = blacks;
        this.whites = whites;
    }
    
    public boolean hasAllBlacks(){
        return this.blacks == Combination.COMBINATION_LENGTH;
    }

    public String toString(){
        return blacks + " blacks and " + whites + " whites";
    }
}
