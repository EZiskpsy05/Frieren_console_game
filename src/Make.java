import java.util.ArrayList;

public class Make implements Command {

    // Array of synonyms for the make command
    String[] synonyms = new String[]{"make","brew","prepare"};
    String[] args;
    Location curr;
    ArrayList<Polyjuice> poly; // List to store Polyjuice potions
    ArrayList<Invisibility> invis; // List to store Invisibility potions

    // Constructor to initialize the current location and potion lists
    public Make(Location l, ArrayList<Polyjuice> p, ArrayList<Invisibility> i) {
        this.curr = l;
        this.poly = p;
        this.invis = i;
    }

    // Method to check if the given command is a synonym for make
    public Boolean isSynonym(String cmd) {
        for (String s : this.synonyms)
            if (cmd.equalsIgnoreCase(s))
                return true;
        return false;
    }

    // Method to execute the make command
    public Location execute(String arg) {
        this.args = arg.split(" ");

        // Check if the player is in the Potions Classroom
        if (!curr.name.equals("The Potions Classroom")) {
            System.out.println("You are not in the Potions Classroom!");
            return curr;
        }

        // Check if the enemy in the current location is defeated
        if (!curr.isEnemyDefeated) {
            System.out.println("You must defeat "+ curr.p.get(0).name+" first!");
            return curr;
        }

        // Check if the argument contains "polyjuice" to make a Polyjuice Potion
        if (arg.toLowerCase().contains("polyjuice")) {
            Polyjuice p = new Polyjuice();
            p.prepareRecipe();
            System.out.println("Potion is ready!");
            poly.add(p); // Add the potion to the Polyjuice list
            System.out.println("You now have "+poly.size()+" flasks of Polyjuice Potion!");
        }
        // Check if the argument contains "invisibility" to make an Invisibility Potion
        else if(arg.toLowerCase().contains("invisibility")) {
            Invisibility p2 = new Invisibility();
            p2.prepareRecipe();
            System.out.println("Potion is ready!");
            invis.add(p2); // Add the potion to the Invisibility list
            System.out.println("You now have "+invis.size()+" flasks of Invisibility Potion!");
        }
        else {
            System.out.println("Cannot make that!"); // If the potion cannot be made, display a message
        }
        return curr; // Return the current location
    }
}
