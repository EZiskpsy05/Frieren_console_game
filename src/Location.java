import java.util.ArrayList;
import effects.TypeEffect;

public class Location
{

	String name;
	ArrayList<Person> p = new ArrayList<Person>();
	ArrayList<Item> items = new ArrayList<Item>();
	Location north, south, east, west;
	String desc;
	Boolean isEnemyDefeated = false;
	
	void look()
	{
		TypeEffect.delay(this.desc);
		//if the location has a person and/or object(s), their descriptions get printed too
		for(int i = 0; i < p.size(); i++)
			TypeEffect.delay(this.p.get(i).desc);

		for(int i = 0; i < items.size(); i++)
			TypeEffect.delay(items.get(i).desc);

	}

	void enter()
	{
		TypeEffect.delay("You have entered "+this.name+"\n");
	}

	public Location(String name, String desc, ArrayList<Person> p, ArrayList<Item> items, Location north, Location south, Location east, Location west)
	{
		this.name = name;
		this.p = p;
		this.items = items;
		this.north = north;
		this.south = south;
		this.east = east;
		this.west = west;
		this.desc = desc;

	}

}
