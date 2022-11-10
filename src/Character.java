
import java.util.*;

public class Character {
    // The data members
    private String name;
    private String team;
    private String universe;
    private String homePlanet;
    private Stats s ;
    private static int numCharacters = 0;
    
public Character(){
    numCharacters+=1;
}
// the method with parameters
public Character(String name, String team, String universe, String homePlanet, Stats s){
    this.name = name;
    this.team = team;
    this.universe = universe;
    this.homePlanet = homePlanet;
    this.s = s;
    numCharacters+=1;
}
// getters and setters
    public Stats getS() {
        return s;
    }
// getters and setters
    public void setS(Stats s) {
        this.s = s;
    }
// getters and setters
    public String getName() {
        return name;
    }
// getters and setters
    public void setName(String name) {
        this.name = name;
    }
// getters and setters
    public String getTeam() {
        return team;
    }
// getters and setters
    public void setTeam(String team) {
        this.team = team;
    }
// getters and setters
    public String getUniverse() {
        return universe;
    }
// getters and setters
    public void setUniverse(String universe) {
        this.universe = universe;
    }
// getters and setters
    public String getHomePlanet() {
        return homePlanet;
    }
// getters and setters
    public void setHomePlanet(String homePlanet) {
        this.homePlanet = homePlanet;
    }
// getters and setters
    public static int getNumCharacters() {
        return numCharacters;
    }
// getters and setters
    public  void setNumCharacters(int numCharacters) {
        this.numCharacters = numCharacters;
    }
    
    // to string
   @Override
   public String toString(){
       String info = "";
       info += String.format("   Name:         %s\n", getName());
       info += String.format("   Team:         %s\n", getTeam());
       info += String.format("   Universe:     %s\n", getUniverse());
       info += String.format("   Home Planet:  %s\n", getHomePlanet());
       info += s.toString();
       
       return info;
   }
    
    
    
}



