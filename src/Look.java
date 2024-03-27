public class Look implements Command {

    // Array of synonyms for the look command
    String[] synonyms = new String[]{"look around","look","observe","see","watch"};
    String[] args;
    Location curr;

    // Constructor to initialize the current location
    public Look(Location l) {
        this.curr = l;
    }

    // Method to check if the given command is a synonym for look
    public Boolean isSynonym(String cmd) {
        for (String s : this.synonyms)
            if (cmd.equalsIgnoreCase(s))
                return true;
        return false;
    }

    // Method to execute the look command
    public Location execute(String arg) {
        this.args = arg.split(" ");
        if(args.length == 1) // Look at location
        {
            System.out.println("\n\t\t"+ curr.name);
            curr.look(); // Display information about the current location
        }
        else // Look at item
        {
            Boolean validItem = false;

            for(int i = 0; i < curr.items.size(); i++) {
                // Check if the argument contains the name of an item in the current location
                if(arg.toLowerCase().contains(curr.items.get(i).name.toLowerCase())) {
                    System.out.println(curr.items.get(i).desc); // Display the description of the item
                    validItem = true;
                }
            }

            if(!validItem)
                System.out.println("You see no such thing!"); // If the item is not found, display a message
        }
        return curr; // Return the current location
    }
}
