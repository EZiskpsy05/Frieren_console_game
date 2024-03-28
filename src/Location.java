import java.util.ArrayList;
import effects.TypeEffect;

public class Location {

    // Name of the location
    String name;
    
    // List of people in the location
    ArrayList<Person> people = new ArrayList<Person>();
    
    // List of items in the location
    ArrayList<Item> items = new ArrayList<Item>();
    
    // Adjacent locations
    Location north, south, east, west;
    
    // Description of the location
    String desc;
    
    // Flag to track if enemy is defeated
    Boolean isEnemyDefeated = false;
    
    // Method to describe the location
    void look() {
        TypeEffect.delay(this.desc);
        // If the location has people, their descriptions get printed too
        for (int i = 0; i < people.size(); i++)
            TypeEffect.delay(people.get(i).desc);
        // If the location has items, their descriptions get printed too
        for (int i = 0; i < items.size(); i++)
            TypeEffect.delay(items.get(i).desc);
    }

    // Method to indicate entering a location
    void enter() {
        TypeEffect.delay("You have entered " + this.name + "\n");
    }

    /**
     * Constructor for Location class.
     *  name Name of the location.
     *  desc Description of the location.
     *  p List of people in the location.
     *  items List of items in the location.
     *  north Location to the north.
     *  south Location to the south.
     *  east Location to the east.
     *  west Location to the west.
     */
    public Location(String name, String desc, ArrayList<Person> p, ArrayList<Item> items, Location north, Location south, Location east, Location west) {
        this.name = name;
        this.people = p;
        this.items = items;
        this.north = north;
        this.south = south;
        this.east = east;
        this.west = west;
        this.desc = desc;
    }
}
