
public class Stats {
    // the data members
    private int intelligence;
    private int strength;
    private int stamina;
    private int speed;
    private int skills;
    
    // no parameter method
    public Stats(){
        
    }
    // parameter with method
    public Stats(int intelligence, int strength, int stamina, int speed, int skills){
        this.intelligence = intelligence;
        this.strength = strength;
        this.stamina = stamina;
        this.speed = speed;
        this.skills = skills;
                
    }
// getters and setters
    public int getIntelligence() {
        return intelligence;
    }
// getters and setters
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }
// getters and setters
    public int getStrength() {
        return strength;
    }
// getters and setters
    public void setStrength(int strength) {
        this.strength = strength;
    }
// getters and setters
    public int getStamina() {
        return stamina;
    }
// getters and setters
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }
// getters and setters
    public int getSpeed() {
        return speed;
    }
// getters and setters
    public void setSpeed(int speed) {
        this.speed = speed;
    }
// getters and setters
    public int getSkills() {
        return skills;
    }
// getters and setters
    public void setSkills(int skills) {
        this.skills = skills;
    }
    // to string
    @Override
    public String toString(){
        String info = "";
        
        info += String.format("   Stats:        Intelligence: %d\n", getIntelligence());
        info += String.format("                 Strength:     %d\n", getStrength());
        info += String.format("                 Stamina:      %d\n", getStamina());
        info += String.format("                 Speed:        %d\n", getSpeed());
        info += String.format("                 Skills:       %d\n", getSkills());
        
        return info;
        
    }
    
    
}
