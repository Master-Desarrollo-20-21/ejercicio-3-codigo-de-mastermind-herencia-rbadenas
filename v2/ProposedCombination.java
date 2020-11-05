package v2;

public class ProposedCombination extends Combination {

    public ProposedCombination(String proposed) {
        super(proposed);
    }

    public String toString(){
        String result = "";
        for (Color color : this.colors) {
            result += color.toString();
        }
        return result;
    }
}