public class Move implements Command {

    // Array of synonyms for the move command
    String[] synonyms = new String[]{"move","go","walk","proceed","advance"};
    String[] args;
    Location curr;

    // Constructor to initialize the current location
    public Move(Location l) {
        this.curr = l;
    }

    // Method to check if the given command is a synonym for move
    public Boolean isSynonym(String cmd) {
        for (String s : this.synonyms)
            if (cmd.equalsIgnoreCase(s))
                return true;
        return false;
    }

    // Method to execute the move command
    public Location execute(String arg) {
        this.args = arg.split(" ");

        // Check if the argument contains a direction and if the direction is valid, move to the new location
        if (arg.toLowerCase().contains("north") && curr.north != null) {
            curr = curr.north;
            curr.enter(); // Enter the new location and display its description
        } else if(arg.toLowerCase().contains("south") && curr.south != null) {
            curr = curr.south;
            curr.enter();
        } else if(arg.toLowerCase().contains("east") && curr.east != null) {
            curr = curr.east;
            curr.enter();
        } else if(arg.toLowerCase().contains("west") && curr.west != null) {
            curr = curr.west;
            curr.enter();
        } else {
            System.out.println("You cannot go there!"); // If the direction is not valid, display a message
        }
        return curr; // Return the current location
    }
}
