package v2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Console {

    public Console() { }
    
	public String askForString(String promptMessage) {

        String result = "";
        this.out(promptMessage);

        try
        {
            InputStreamReader in = new InputStreamReader(System.in);
            BufferedReader br = new BufferedReader(in);
            result = br.readLine();
        }
        catch(Exception e){ }
        
        return result;
	}

    public void out(String promptMessage){
        System.out.println(promptMessage);
    }
    
}