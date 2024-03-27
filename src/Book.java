import java.util.Random;

// Book class that extends Item and implements randomizer
public class Book extends Item implements randomizer {

	// Constructor for Book class
	public Book(String name, String desc, String[] verbs) {
		super(name, desc, verbs);
	}

	// Method to generate random dialog related to books
	public void randomDialog() {
		Random r = new Random();
		String[] books = {"The Life and Lies of Albus Percival Wulfric Brian Dumbledore by Rita Skeeter", "Fantastic Beasts and Where to Find Them by Newton Scamander", "Muggle guide to 18th-century ballet by Myra Curio\nYou can now do ballet!"};
		System.out.println(books[r.nextInt(books.length)]);
	}

	// Override use method from Item class
	public Boolean use(String v) {
		
		// Call use method from super class and store its return value
		Boolean ret = super.use(v);
		
		// If the super class use method returned true, then print random dialog
		if(ret) {
			this.randomDialog();
		}
		
		// Return the value returned by the super class use method
		return ret;
	}

}
