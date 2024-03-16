
public class SpellCommand implements Command{

	String[] synonyms = new String[]{"zoltraak","doragate","catastravia","mistilziela","shield","sorganeil","erfassen","sus","photo"};
	String[] args;
	Location curr;

	public SpellCommand(Location l) {
		this.curr = l;
	}
	
	Zoltraak atk1 = new Zoltraak();
	Doragate atk2 = new Doragate();
	Catastravia atk3 = new Catastravia();
	Mistilziela def1 = new Mistilziela();
	ExpectoPatronum expat = new ExpectoPatronum();

	public Location execute(String args) {

		if(args.split(" ")[0].equalsIgnoreCase(synonyms[0])) 
			this.atk1.cast();
		else if(args.split(" ")[0].equalsIgnoreCase(synonyms[1])) 
			this.atk2.cast();
		else if(args.split(" ")[0].equalsIgnoreCase(synonyms[2])) 
			this.atk3.cast();
		else if(args.split(" ")[0].equalsIgnoreCase(synonyms[3]))
			this.def1.cast();
		else if(args.split(" ")[0].equalsIgnoreCase(synonyms[4]))
			this.expat.cast();
		else if(args.split(" ")[0].equalsIgnoreCase(synonyms[5]))
			this.expat.cast();
		else if(args.split(" ")[0].equalsIgnoreCase(synonyms[6]))
			this.expat.cast();
		else if(args.split(" ")[0].equalsIgnoreCase(synonyms[7]))
			this.expat.cast();
		else if(args.split(" ")[0].equalsIgnoreCase(synonyms[8]))
			this.expat.cast();
		else if(args.split(" ")[0].equalsIgnoreCase(synonyms[3]))
			this.expat.cast();
		
		
		if(curr.p.size() > 0) {
			if(curr.p.size() > 1)
				System.out.println("You defeated " + curr.p.get(1).name);
			else
				System.out.println("You defeated " + curr.p.get(0).name);
			
			curr.isEnemyDefeated = true;
		}

		return curr;
	}


	public Boolean isSynonym(String cmd)
	{
		for(String s:this.synonyms)
			if(cmd.equalsIgnoreCase(s))
				return true;
		return false;
	}

}
