// Brandon Wilson
// 4-6-22
// Program 4 - Marvel vs DC - add heroes and villains and imitate them fighting 


//“I will practice academic and personal integrity and excellence of character and expect the same from others.”
import java.util.*;
//import javax.print.attribute.AttributeSetUtilities;
public class Marvel_vs_DC {
    
    // adding characters to the system(nonsuper)
    public static void addNPC(ArrayList<Character> chars, String [] line){
        System.out.print("Command: ADDCHARACTER\n");
        // getting all the numbers from the user
        Stats attributes = new Stats(Integer.parseInt(line[5]),Integer.parseInt(line[6]),Integer.parseInt(line[7]),Integer.parseInt(line[8]),Integer.parseInt(line[9]));
        //////////////////////////////////////name,    team,  universe,home planet, stats
        Character npc = new Character(line[1], line[2], line[3], line[4], attributes);
        // adds the newly created character to the character class
        chars.add(npc);
        // prints out the to string of the character
        System.out.println(npc.toString());
        
    }
    
    // adding characters to the system(super)
    public static void addSuperHero(ArrayList<Character> chars, String [] line){
        System.out.print("Command: ADDCHARACTER\n");
        // getting all the powers from the user starting from index 11
        ArrayList<String> temp = new ArrayList<>();
        int i;
        for ( i = 11; i < line.length; i ++){
           temp.add( line[i]);
        }
        // the stats of the super hero
        Stats attributes = new Stats(Integer.parseInt(line[6]),Integer.parseInt(line[7]),Integer.parseInt(line[8]),Integer.parseInt(line[9]),Integer.parseInt(line[10]));
        ////////////////////////////////////////////name,    team,  universe,home planet, stats, superpowers
        SuperHV superHero = new SuperHV(line[2], line[3], line[4], line[5], attributes, temp);
        // adds the newly created character to the character class
        chars.add(superHero);
        // prints out the to string of the character
        System.out.println(superHero.toString());
    }
    
    // searching for a specific character
    public static void searchCharacter(ArrayList<Character> chars, String [] line){
        System.out.print("Command: SEARCHCHARACTER\n");
        // no characters are in the system
        if (Character.getNumCharacters() == 0){
            System.out.println("   ERROR: cannot execute command. There are no characters currently in the system.\n");
        }
        else{// there are characters in the system
            String search = line[1];
            boolean name = false;
            int i;
            // loop over all the characters in the system
            for (i = 0; i < Character.getNumCharacters(); i ++){
                // if the searched name matches with one in the system
                if(chars.get(i).getName().equalsIgnoreCase(search)){
                    name = true;
                    // to string of the character found
                    System.out.println(chars.get(i).toString());
                    break;
                }
            }
            // name isnt found
                if (!name){
                    System.out.printf("   ERROR: %s is not a character currently in the system.\n",search);
                }
          
        }
            
    }
    
    // adding a power to a specific character
    public static void addPower(ArrayList<Character> chars, String [] line){
        System.out.print("Command: ADDPOWER\n");
        // there are no characters in the system
        if(Character.getNumCharacters() == 0){
                System.out.println("   ERROR: cannot execute command. There are no characters currently in the system.\n");
        }
        else{ // there are characters in the system
            String search = line[1];
            String newPower = line[2];
            boolean name = false;
            int i;
            // loop over all the characters in the system
            for (i = 0; i < Character.getNumCharacters(); i ++){
                // if the searched name matches with one in the system
                if(chars.get(i).getName().equalsIgnoreCase(search)){
                    name = true;
                    // loops over the length of the array (might be a redundant for loop but oh well it still works)
                    for( int j = 0; j < line.length; j++){
                        // if a character went through the superhv class
                        if(chars.get(i) instanceof SuperHV){
                            // creates an arraylist of that characters powers
                            ArrayList<String> old = ((SuperHV) chars.get(i)).getPowers();
                            // the new power is already in the system
                            if(old.contains(newPower)){
                                System.out.printf("   ERROR: %s already has the superpower of %s.\n",search, newPower);
                                break;
                                
                            }
                            else{// the new power isnt in the system so it then gets added to the character
                                System.out.printf("    %s now has the new superpower of %s.\n",search,newPower);
                                old.add(newPower);
                                break;
                            }
                        }
                        
                    }
                }
            }
            // name isn't found
                if (!name){
                    System.out.printf("   ERROR: %s is not a character currently in the system.\n",search);
                }
        }
    }
    
    // getting two characters to fight
    public static void fight(ArrayList<Character> chars, String [] line){
        System.out.print("Command: FIGHT\n");
        // there are no characters in the system
        if(Character.getNumCharacters() == 0){
                System.out.println("   ERROR: cannot execute command. There are no characters currently in the system.\n");
        }
        else{ // there are characters in the system
            String fighter1 = line[1];
            String fighter2 = line[2];
            // both fighters are found in the system so then they can regurally fight
            if(fighterSearch(chars, line, fighter1) == true && fighterSearch(chars, line, fighter2) == true){
                // booleans for automatic win
                boolean automaticWinFor1 = false;
                boolean automaticWinFor2 = false;
                // index of the fighters
                int fight1Index = indexOfFighter(chars, line, fighter1);
                int fight2Index = indexOfFighter(chars, line, fighter2);
                
               // for loop to see if the first fighter has a super
                for(int i = 0; i < line.length; i++){
                    if(chars.get(fight1Index) instanceof SuperHV){
                        automaticWinFor1 = true;
                    }
                }
                // if the second fighter has a for loop
                for(int i = 0; i < line.length; i++){
                    if(chars.get(fight2Index) instanceof SuperHV){
                        automaticWinFor2 = true;
                    }
                    
                }
                // the print statements for the beginning part of the fight
                System.out.printf("   %s vs %s\n\n",fighter1,fighter2);
                System.out.println("   Fighter #1:");
                System.out.println(chars.get(fight1Index).toString());
                System.out.println("   Fighter #2:");
                System.out.println(chars.get(fight2Index).toString());
                
                // The main portion for the actual fighting of code
                if((automaticWinFor1 == true && automaticWinFor2 == true) || (automaticWinFor1 == false && automaticWinFor2 == false)){
                    //power for the first character
                    int totalPower1 = 0;
                    // adding the total power for the first cometitor
                    totalPower1 += chars.get(fight1Index).getS().getIntelligence();
                    totalPower1 += chars.get(fight1Index).getS().getSkills();
                    totalPower1 += chars.get(fight1Index).getS().getSpeed();
                    totalPower1 += chars.get(fight1Index).getS().getStamina();
                    totalPower1 += chars.get(fight1Index).getS().getStrength();
                    // if the character has super powers
                    if(chars.get(fight1Index) instanceof  SuperHV){
                        // if they do it creates an arraylist of the powers
                        ArrayList<String> p1powers = ((SuperHV) chars.get(fight1Index)).getPowers();
                        // loops over the list of powers and adds 10 for each power
                        for(int i = 0; i < p1powers.size(); i++){
                            totalPower1 += 10;
                        }
                    }
                    //power for the first character
                    int totalPower2 = 0;
                    // adding the total power for the first cometitor
                    totalPower2 += chars.get(fight2Index).getS().getIntelligence();
                    totalPower2 += chars.get(fight2Index).getS().getSkills();
                    totalPower2 += chars.get(fight2Index).getS().getSpeed();
                    totalPower2 += chars.get(fight2Index).getS().getStamina();
                    totalPower2 += chars.get(fight2Index).getS().getStrength();
                    // if the character has super powers
                    if(chars.get(fight2Index) instanceof  SuperHV){
                        // if they do it creates an arraylist of the powers
                        ArrayList<String> p2powers = ((SuperHV) chars.get(fight2Index)).getPowers();
                        // loops over the list of powers and adds 10 for each power
                        for(int i = 0; i < p2powers.size(); i++){
                            totalPower2 += 10;
                        }
                    }
                    // the print statements for the results of the fight
                    System.out.println("   Fight Results:");
                    System.out.printf("      %s's total attack power: %s\n",fighter1,totalPower1);
                    System.out.printf("      %s's total attack power: %s\n",fighter2,totalPower2);
                    // first fighter has more power
                    if(totalPower1 > totalPower2){
                        System.out.printf("      Winner: %s\n\n",fighter1);
                    }
                    // second fighter has more power
                    else if(totalPower1 < totalPower2){
                        System.out.printf("      Winner: %s\n\n",fighter2);
                    }
                    else{// the powers are equal to eachother
                        System.out.println("      There was a tie between the fighters.\n");
                    }
                }// the first fighter has superpowers and the other doesn't
                else if(automaticWinFor1 == true && automaticWinFor2 == false){
                    System.out.println("\nFight Results:\n");
                    System.out.printf("%s has no superpowers. Thus, %s wins every time.\n",fighter2,fighter1);
                }// the second fighter has super powers and the second one doesnt
                else{
                    System.out.println("\nFight Results:\n");
                    System.out.printf("%s has no superpowers. Thus, %s wins every time.\n",fighter1,fighter2);
                }
            }
            // fighter 1 gets print statemenft for not existing
            else if (fighterSearch(chars, line, fighter2) == true && fighterSearch(chars, line, fighter1) == false){
                System.out.println("   ERROR: cannot execute command. One or more characters cannot be found.\n");
                System.out.printf("      %s is not a character currently in the system.\n",fighter1);
            }// fighter 2 gers print statement for not existing
            else if (fighterSearch(chars, line, fighter1) == true && fighterSearch(chars, line, fighter2) == false){
                System.out.println("   ERROR: cannot execute command. One or more characters cannot be found.\n");
                System.out.printf("      %s is not a character currently in the system.\n",fighter2);
            }
            else{// no one exists in the system
                // this might be redundant but oh well since its my first line of code
                System.out.println("   ERROR: cannot execute command. One or more characters cannot be found.\n");
                System.out.printf("      %s is not a character currently in the system.\n",fighter1);
                 System.out.printf("      %s is not a character currently in the system.\n",fighter2);
            }
        }
    }
    
    // returning the index of the fighter for "fight" in its own method
    public static int indexOfFighter(ArrayList<Character> chars, String [] line, String fighter){
        // loops over all the characters and returns the index of the match
        // knows the character is in the system
        for (int i = 0; i < Character.getNumCharacters(); i ++){
            if(chars.get(i).getName().equalsIgnoreCase(fighter)){
                return i;
            }
    }
        return 0;
    }
    
    // searching for the fighter for "fight" in its own method
    public static boolean fighterSearch(ArrayList<Character> chars, String [] line, String fighter){
        // checks to see if the character is apart of the system
        // not known if character is in the system
        for (int i = 0; i < Character.getNumCharacters(); i ++){
            if(chars.get(i).getName().equalsIgnoreCase(fighter)){
                return true;
            }
        }
       return false;
    }
    
    // displays all the heroes in the system
    public static void displayHeroes(ArrayList<Character> chars, String [] line){
        System.out.print("Command: DISPLAYHEROES\n");
        // no characters in the program
        if(Character.getNumCharacters() == 0){
            System.out.println("   ERROR: cannot execute command. There are no characters currently in the system.");
        }
        else{// there are competitors found in the program
            // loops over all the characters in the system
            for(int i = 0; i < Character.getNumCharacters();i++){
                // if their team equals heroes than they get printed
                if(chars.get(i).getTeam().equals("Heroes")){
                    System.out.println("   -----------------------------------------");
                    System.out.println(chars.get(i).toString());
                }
            }
        }
    
    }
    // displays all the Villains in the system
    public static void displayVillans(ArrayList<Character> chars, String [] line){
        System.out.print("Command: DISPLAYVILLAINS\n");
        // no characters in the program
        if(Character.getNumCharacters() == 0){
            System.out.println("   ERROR: cannot execute command. There are no characters currently in the system.");
        }
        else{// there are competitors found in the program
            // loops over all the characters in the system
            for(int i = 0; i < Character.getNumCharacters();i++){
                // if their team equals villains than they get printed
                if(chars.get(i).getTeam().equals("Villains")){
                    System.out.println("   -----------------------------------------");
                    System.out.println(chars.get(i).toString());
                }
            }
        }
    }
    
    // displays all the marvel characters in the system
    public static void displayMarvel(ArrayList<Character> chars, String [] line){
        System.out.print("Command: DISPLAYMARVEL\n");
         // no characters in the program
        if(Character.getNumCharacters() == 0){
            System.out.println("   ERROR: cannot execute command. There are no characters currently in the system.");
        }
        else{// there are competitors found in the program
            // loops over all the characters in the system
            for(int i = 0; i < Character.getNumCharacters();i++){
                // if their universe equals Marvel than they get printed
                if(chars.get(i).getUniverse().equals("Marvel")){
                    System.out.println("   -----------------------------------------");
                    System.out.println(chars.get(i).toString());
                }
            }
        }
    }
    
    // displays all the DC characters in the system
    public static void displayDC(ArrayList<Character> chars, String [] line){
        System.out.print("Command: DISPLAYDC\n");
         // no characters in the program
        if(Character.getNumCharacters() == 0){
            System.out.println("   ERROR: cannot execute command. There are no characters currently in the system.");
        }
        else{// there are competitors found in the program
            // loops over all the characters in the system
            for(int i = 0; i < Character.getNumCharacters();i++){
               // if their universe equals DC than they get printed
                if(chars.get(i).getUniverse().equals("DC")){
                    System.out.println("   -----------------------------------------");
                    System.out.println(chars.get(i).toString());
                }
            }
        }
    }
    
    // function to display all the stats of all the characters
    public static void displayStats(ArrayList<Character> chars, String [] line){
        System.out.print("Command: DISPLAYSTATS\n");
        // no characters in the program
        if(Character.getNumCharacters() == 0){
            System.out.println("   ERROR: cannot execute command. There are no characters currently in the system.");
        }
        else{// there are competitors found in the program
            //Array lists of strings for the 4 itterations in the way and spelling for it to work
            String[] mDC ={"Marvel","Marvel","DC","DC"};
            String[] HV = {"Heroes","Villains","Heroes","Villains"};
            String[] littleHV = {"Hero","Villain","Hero","Villain"};
            // to repeat the code 4 times for the 4 possibilities
            for( int x = 0; x < 4; x++){
                // prints once for the 2 insitances of marvel characters
                if(x == 0){
                    System.out.println("   Marvel Characters");
                }
                // prints once for the 2 insitances of DC characters
                if(x == 2){
                    System.out.println("   DC Characters");
                }
                // prints the string of allternating hero,villan'
                if (dcCounter(chars, line) == 0 &&  x == 2){
                    // literally only one instance of it
                }
                else{
                    System.out.printf("      %s Stats:\n",littleHV[x]);
                }
                // varaibles needed for the for inner for loop
                double[] AVG = new double [5];
                int counter = 0;
                int npc = 0;
                int sup = 0;
                ArrayList<String> ListOfPowers = new ArrayList<>();
                //Marvel characters
                for( int i = 0; i < Character.getNumCharacters(); i++){
                    // characters that match both the universe and team that needed to printed for that instance of x
                    if(chars.get(i).getUniverse().equals(mDC[x]) && (chars.get(i).getTeam().equals(HV[x]))){
                        AVG[0] += chars.get(i).getS().getIntelligence();
                        AVG[1] += chars.get(i).getS().getStrength();
                        AVG[2] += chars.get(i).getS().getStamina();
                        AVG[3] += chars.get(i).getS().getSpeed();
                        AVG[4] += chars.get(i).getS().getSkills();
                        counter += 1;
                        // if the specific character is a super hero
                        if(chars.get(i)  instanceof SuperHV){
                            // adds all there powers and adds the count of it too
                            ListOfPowers.addAll(((SuperHV) chars.get(i)).getPowers());
                            sup +=1;
                        }
                        else{// npc counter
                            npc +=1;
                        }
                        }

                        }// there are no dc characters so there is no need to printnull
                        if (dcCounter(chars, line) == 0 &&  x == 2){
                            System.out.println("      There are currently no DC characters in the system.\n");
                            break;
                        }// there are no dc characters so there is no need to printnull, i dont think this is an instance at all
                        else if(marvelCounter(chars, line) == 0 && (x == 0 || x == 1)){
                            System.out.println("      There are currently no Marvel characters in the system.\n");
                            continue;
                        }
                        else{
                            // print statements for all the stats
                            System.out.printf("         Average Intelligence: %.2f\n",AVG[0] / counter);
                            System.out.printf("         Average Strength:     %.2f\n",AVG[1] / counter);
                            System.out.printf("         Average Stamina:      %.2f\n",AVG[2] / counter);
                            System.out.printf("         Average Speed:        %.2f\n",AVG[3] / counter);
                            System.out.printf("         Average Skill:        %.2f\n",AVG[4] / counter);
                            System.out.printf("      Number of Normal-Person %s:    %d\n",HV[x],npc);
                            System.out.printf("      Number of %s with Superpowers: %d\n",HV[x],sup);
                            // if the super counter is not 0 than the lines with superpowers wil print
                            if(sup != 0){
                                System.out.println("      Aggregate Superpowers:");
                                // blank string to cacatanate to
                                String s = "         ";
                                //sorting the the list of powers alphabetically before making it into a string
                                Collections.sort(ListOfPowers);
                                // loop over the size of of the lsit of powers
                                for(int j = 0; j < ListOfPowers.size();j++){
                                    // if the string doesnt already have the power than the new power gets added
                                    if (!s.contains(ListOfPowers.get(j))){
                                        s += ListOfPowers.get(j) + ", ";
                                    }
                                }
                                // so the last comma doesnt get printed
                                s = s.substring(0, s.length()-2);
                                System.out.println(s + "\n");
                            }

                        }

                    }
                }

            }
    
    // counter for the instance that all of marvel class is empty so display stats prints nothing (only made this incase it wasn't just dc)
    public static int marvelCounter(ArrayList<Character> chars, String [] line){
        int count = 0;
        for( int i = 0; i < Character.getNumCharacters(); i++){
            if(chars.get(i).getUniverse().equals("Marvel")){
                count +=1;     
        }
        }
        return count;
    }
    
    // counter for the instance that all of dc class is empty so display stats prints nothing
    public static int dcCounter(ArrayList<Character> chars, String [] line){
        int count = 0;
        for( int i = 0; i < Character.getNumCharacters(); i++){
            if(chars.get(i).getUniverse().equals("DC")){
                count +=1;     
        }
        }
        return count;
    }
    
    // System.out.print(competitors[indexOfID].toString());
    public static void main(String[] args) {
        // beginning arrays and arraylists for the whole program
        Scanner in = new Scanner(System.in);
        String [] line; // array of information being saved into line
        // an array list of character refrences called chars
        ArrayList<Character> chars = new ArrayList<>();

        // Switch case statement for the whole program
        OUTER:
        while (true) {
            line = in.nextLine().split(",");// is the user choice and split by commas

            
            // usesr wants to add a character 
            switch (line[0]) {
                case "ADDCHARACTER":
                    // if the sentence at index 1 equals superhv the character has super powers and 
                    // needs a different add method
                    if (line[1].equalsIgnoreCase("superhv"))
                        addSuperHero(chars,line);
                    else{ // just a npc without superpowers
                        addNPC(chars, line);
                    }
                    break;
                    // user wants to search for a character
                case "SEARCHCHARACTER":
                    searchCharacter(chars, line);
                    break;
                    // user wants to add power to one of the characters
                case "ADDPOWER":
                    addPower(chars, line);
                    break;
                    // user wants to have the characters fight
                case "FIGHT":
                    fight(chars, line);
                    break;
                    // user wants to display all the heroes
                case "DISPLAYHEROES":
                    displayHeroes(chars, line);
                    break;
                    // user wants to display all the villans
                case "DISPLAYVILLAINS":
                    displayVillans(chars, line);
                    break;
                    // user wants to display all the marvel characters
                case "DISPLAYMARVEL":
                    displayMarvel(chars, line);
                    break;
                    // user wants to display all the dc characters
                case "DISPLAYDC":
                    displayDC(chars, line);
                    break;
                    // user wants to display all the statistics off all the characters
                case "DISPLAYSTATS":
                    displayStats(chars, line);
                    break;
                default:
                    // if (userChoice == 9) {
                    // user wants to exit the system
                    System.out.println("\nGoodbye!");
                    break OUTER;
            } // end switch

    }
    
}// end of main function
}// end of class
