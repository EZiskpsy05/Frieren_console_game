
public class Help implements Command{

	// Arrays for access help menu
	String[] synonyms = new String[]{"help"};
	String[] args;
	// Configure String and simplify
	String a = colors.BOLD;
	String b = colors.RESET;
	// Create arrays to use for names
	String[] attack = {a+"Zoltraak: "+b,a+"Doragate: "+b,a+"Catastravia: "+b};
	String[] defense = {a+"Mistilziela: "+b,a+"Shield 「防御魔法 Bōgyo mahō」: "+b};
	String[] support = {a+"Sorganeil: "+b,a+"Erfassen: "+b};
	String[] fun = {a+"Sus: "+b,a+"Photo: "+b};
	// Description for each spells
	String[] attack_description = {"A simple spell that shoots either a large blast or multiple smaller blasts of concentrated mana\n\t",
			"Change rocks into bullets\n\t",
			"Numerous arrows of light are directed at the target.\n\t\tUpon contact, they form a barrage of large explosions\n\t"};
	String[] defense_description = {"A primitive magic that reflects any magic that is perceived to be a \"curse\" ",
			"Magic that generates a protective barrier that can defend specific locations or encircle the caster. "};
	String[] support_description = {"Completely prevents someone from moving or accessing their mana \n\t\t to cast spells while their full body is within the user’s vision.",
			"Generates a suitable weapon and imitates the action and fighting style of an individual."};
	String[] fun_description = {"Allows the caster to see through what is recognized as articles of clothing,\n\t revealing details such as weapons hidden under.",
			"Takes a photograph using magic which can then presumably be conjured or printed out.\n\t The photo-taking interface appears as a hologram."};
	Location curr;
	
	public Help(Location l) {
		this.curr = l;
	}

	public Boolean isSynonym(String cmd)
	{
		for(String s:this.synonyms)
			if(cmd.equalsIgnoreCase(s))
				return true;
		return false;
	}
	
	public Location execute(String arg)
	{

		System.out.println(a+colors.BRIGHT_WHITE+"Usage:"+b+"\n\tlook|observe|see|watch\tProvides short description about the location\n\t\t\t\tand characters present\n\n\tmove|go|walk|proceed|advance {north|south|east|west}\n\t\t\t\tMoves the user to a different location using\n\t\t\t\tthe direction argument\n\ttalk|speak|chat character-name\tTalk to the character present\n\t\t\t\tin current location\n\n");
		String abc  = a+colors.BRIGHT_GREEN+"SPELLS GUIDE\n\t\t"
				+a+colors.RED+"Offense Spells:\n\t"+b
				+attack[0]+attack_description[0]
				+attack[1]+attack_description[1]
				+attack[2]+attack_description[2]
				+a+colors.CYAN+"Defense Spells\n\t"+b
				+defense[0]+defense_description[0]
				+defense[1]+defense_description[1]
				+a+colors.YELLOW+"Support Spells\n\t"+b
				+support[0]+support_description[0]
				+support[1]+support_description[1]
				+a+colors.BRIGHT_MAGENTA+"Fun Spells\n\t"+b
				+fun[0]+fun_description[0]
				+fun[1]+fun_description[1];
		
		System.out.println(abc);
		return curr;
	}


}
