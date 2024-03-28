import java.util.Random;

public class Person {
    
    // Name of the person
    String name;
    
    // Description of the person
    String desc;
    
    // Dialogues of the person
    String[] dialog;
    
    // Method for the person to talk
    void talk(Location curr) {
        Random r = new Random();
        System.out.println("\"" + this.dialog[r.nextInt(this.dialog.length)] + "\"");
        if (this.name.equals("Dumbledore") || this.name.equals("Snape") || this.name.equals("Hermione")) {
            for (int i = 0; i < curr.items.size(); i++) {
                if (i == 0)
                    System.out.print("You can ");
                System.out.print(curr.items.get(i).verbs[0] + " the " + curr.items.get(i).name);
                if (i != curr.items.size() - 1)
                    System.out.print(" or ");
                if (i == curr.items.size() - 1)
                    System.out.println(".");
            }
        }
    }

    /**
     * Constructor for Person class.
     *  name Name of the person.
     *  desc Description of the person.
     *  dialog Dialogues of the person.
     */
    public Person(String name, String desc, String[] dialog) {
        this.name = name;
        this.desc = desc;
        this.dialog = dialog;
    }

    // Empty constructor
    public Person() {}
}
