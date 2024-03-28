/**
 * ControlPanel class manages the execution of commands in the game.
 */
public class ControlPanel {
    Command[] commands; // Array of commands available
    Location currentLocation; // Current location in the game

    /**
     * Constructor for ControlPanel class.
     * @param commands Array of commands available.
     * @param location Current location in the game.
     */
    public ControlPanel(Command[] commands, Location location) {
        this.commands = commands;
        this.currentLocation = location;
    }

    /**
     * Parses and executes a command.
     * @param command The command to parse and execute.
     * @return The new location after executing the command.
     */
    public Location parse(String command) {
        String operation = command.split(" ")[0];

        for (int i = 0; i < commands.length; i++) {
            if (commands[i].isSynonym(operation)) {
                return commands[i].execute(command);
            }
        }
        System.out.println("I do not understand that. You could try the help command");
        return currentLocation;
    }
}
