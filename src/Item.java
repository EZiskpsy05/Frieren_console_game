public class Item {
    String name;
    String desc;
    String[] verbs;

    // Constructor to initialize the item with name, description, and verbs
    public Item(String name, String desc, String[] verbs) {
        this.name = name;
        this.desc = desc;
        this.verbs = verbs;
    }

    // Empty constructor for convenience
    public Item() {}

    // Method to convert a verb to its past tense form
    String toPast(String v) {
        // Handle specific verbs
        if (v.equalsIgnoreCase("eat")) return "ate";
        if (v.equalsIgnoreCase("consume")) return "consumed";
        if (v.equalsIgnoreCase("wear")) return "wore";
        if (v.equalsIgnoreCase("read")) return "read";
        if (v.equalsIgnoreCase("write")) return "wrote with";
        if (v.equalsIgnoreCase("craft")) return "crafted";
        if (v.equalsIgnoreCase("make")) return "made";
        if (v.equalsIgnoreCase("drink")) return "drank";

        // If the verb is not in the specific list, add "ed" if it doesn't already end in "e"
        return v + (v.charAt(v.length() - 1) == 'e' ? "d" : "ed");
    }

    // Method to use the item with a specific verb
    Boolean use(String v) {
        for (int i = 0; i < this.verbs.length; i++) {
            if (verbs[i].equalsIgnoreCase(v)) {
                System.out.println("You " + toPast(v) + " the " + this.name + "!");
                return true;
            }
        }
        System.out.println("You cannot " + v + " the " + this.name + "!");
        return false;
    }
}
