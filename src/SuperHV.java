
import java.util.*;

public class SuperHV extends Character{
    // the data members
    private ArrayList <String> powers = new ArrayList<>();
    private static int numOfSups = 0;
    
    public SuperHV(){
        numOfSups +=1;

    }
    //parameter with method
    public SuperHV(ArrayList <String> powers){
        this.powers = powers;
        numOfSups += 1;

    }
// parameter with method, with the super class as well
    public SuperHV(String name, String team, String universe, String homePlanet, Stats s, ArrayList<String> power) {
        super(name, team, universe, homePlanet, s);
        this.powers = power;
        numOfSups +=1;
    }
    // getters and setters
    public ArrayList<String> getPowers() {
        return powers;
    }
// getters and setters
    public void setPowers(ArrayList<String> powers) {
        this.powers = powers;
    }
    // to string with the super to string as well
    public String toString(){
        String info = "";
        info += super.toString();
        String sup = getPowers().toString();
        info += String.format("   Powers:       %s\n", sup.substring(1,sup.length()-1));

        return info;
    }
    
}


