public class ControlPanel {
	Command [] cmds;
	Location curr;
	
	// Constructor for ControlPanel class
	public ControlPanel(Command [] cmds, Location l) {
		this.cmds = cmds;
		this.curr = l;
	}
	
	// Method to parse and execute commands
	public Location parse(String cmd){

		String op = cmd.split(" ")[0];
		
		for(int i = 0; i < cmds.length; i++)
		{
			if(cmds[i].isSynonym(op)) {
				return cmds[i].execute(cmd);
			}
		}
		System.out.println("I do not understand that. You could try the help command");
		return curr;
	}
}
