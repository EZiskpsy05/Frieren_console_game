import audio.AudioPlayer;
import effects.TypeEffect;
import image.DisplayImage;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Scanner;
import lu.ewelohd.jconsoleimage.*;
import lu.ewelohd.jconsoleimage.core.ConsoleImage;

public class Driver
{
     /*				      =====
      * 				   MAP			N
      * 				  =====		W	+	E
      * 								S
      * 				
      * 					^
      * 					|
      *			https://frieren.fandom.com/wiki/Locations
      *
      * */

     static Watch watch = new Watch();
     static Serie serie = new Serie(
       "Serie",
       "Inside The Continental Magic Association ,you see Serie sitting in a thorn surround by books.\nThis is where you usually find her, and if you have homework due\nthe next day, she's the person to go to!",
       new String[] {
         " In the world of magic, even Heaven and Earth could turn upside down.",
         "I live longer than you!",
         "Oh, are you doing magic? Let�s see it, then.",
         "Only you come visit me?",
         "I'm not letting you copy my magic again!",
         "Would you like to join the Continental Magic Association ?" });

     public static void main(String[] args)
       throws InterruptedException, IOException
     {
          try {
               System.setOut(new PrintStream(System.out, true, "UTF-8"));
          } catch (UnsupportedEncodingException e) {
               System.err.println("Unsupported encoding: " + e.getMessage());
          }
          // This lines of codes are for the Location name
          String entr = colors.BOLD+colors.BRIGHT_WHITE+"\t\t\tThe Royal Capital - Central Land"+colors.RESET;
          // Set up the string for display in Entrance
          // Location params: String name, String desc, Person p, Item a, Item
          // b, Location north, Location south, Location east, Location west
          Location Entrance = new Location(
            entr,
            "You wake up and see yourself at The Royal Capital\nIt is where the Hero Party was tasked with defeating the Demon King and the final destination at the end of their journey.\nAfter the party disbands, Himmel resides in the city until his death.",
            new ArrayList<Person>(),
            new ArrayList<Item>(),
            null,
            null,
            null,
            null);

          Person Heiter = new Person(
            "Heiter",
            "In the outskirts of the city, you see Heiter, the alcohol-loving priest of your Hero Party\n , he is retired now. Heiter was a rather tall and bespectacled Priest with short green hair \nthat he kept slicked back. You see him waking up from his bed.",
            new String[] {
              "Hello there, young student!",
              "Would you care for some sherbet lemons?",
              "It does not do to dwell on dreams and forget to live!",
              "Are you still here? Quit bothering me!",
              "Can't you see I'm busy? Please don't disturb me!",
              "The truth. It is a beautiful and terrible thing, and should therefore be treated with great caution.",
              "Have you seen my hat? I could swear I left it here!",
              "I wasn't feared death, but now I am." });

          Person Fern = new Person(
            "Fern",
            "You see Fern standing inside of the kitchen. She is known for her loyal and skills, a third-class mages!",
            new String[] { "It's been a long time since we met you again, Master Frieren!" });

          ArrayList<Person> StrahlPeople = new ArrayList<Person>();
          StrahlPeople.add(Heiter);
          StrahlPeople.add(Fern);

          Item food = new Item(
            "Food",
            "\n\tOn the tables, you see all sorts of food, from soup to chicken! (eat)",
            new String[] { "eat", "consume" });
			MagicalBooks books = new MagicalBooks(
            "books",
            "In the living room, on a small wooden table, sits the mysterious Magical Books,\r\n still olds, dirty and frayed.(use)",
            new String[] { "learn", "use" });
          ArrayList<Item> StrahlItem = new ArrayList<Item>();
          StrahlItem.add(food);
          StrahlItem.add(books);

          Location Strahl = new Location(
            colors.BOLD+colors.BRIGHT_WHITE+"Strahl - Central Land"+colors.RESET,
            "You are walking up North to Strahl,the city held sacred by adherents of the Goddess of Creation.",
            StrahlPeople,
            StrahlItem,
            null,
            Entrance,
            null,
            null);

          Entrance.north = Strahl;

          Book book = new Book(
            "Book",
            "Nearby, you see a pile of books left by some mages. Some of them seem interesting.\n(read)",
            new String[] { "read" });
          Quill quill = new Quill(
            "Quill",
            "You also spot a beautiful Eagle feather quill, that looks like it cost quite a few gold coins\n(use)!",
            new String[] { "write with", "write", "use" });
          ArrayList<Item> ÄußerstItems = new ArrayList<Item>();
          ÄußerstItems.add(book);
          ÄußerstItems.add(quill);

          Person Lernen = new Person(
            "Lernen",
            "You see your arch nemesis, Draco Malfoy, standing near Hermione. He seems to be up to no good.",
            new String[] {
              "I'm Serie's best assistant.",
              " We're only human. Our time is limited. \n\tThere is no such thing as \"someday\" in our lives." });

          ArrayList<Person> ÄußerstPeople = new ArrayList<Person>();
          ÄußerstPeople.add(serie);
          ÄußerstPeople.add(Lernen);
          Location Äußerst = new Location(
            "Äußerst",
            "Äußerst, the City of Magic, is an island city located in the middle \nof a lake in the Northern Lands.\n\t It is the location of the Northern Continental Magic Association\n\t and is where the First-Class Mage Exam is administered.",
            ÄußerstPeople,
            ÄußerstItems,
            null,
            null,
            Entrance,
            null);

          serie.MyLoc = Äußerst;

          Entrance.west = Äußerst;

          Person Snape = new Person(
            "Snape",
            "Standing in the corner, was the unknown old herbalist.\n She teaches you and Fern about the flora of the region in return for their help in cleaning Himmel's statue \n\tand encourages Fern to communicate her concerns about their extended stay to you.",
            new String[] {
              "You there, it's been a long time since Himmel rescued me from the monster.",
              "Ah, Frieren, I see you've brought your friend.",
              "I can teach you to distinguise between all the flowers in this region,\n as a gift for rescuing me!",
              "Hey!" });
          ArrayList<Person> TurkPeople = new ArrayList<Person>();
          TurkPeople.add(Snape);

          Schiebe schiebe = new Schiebe(
            "Schiebe",
            "On your desk, stands the brand new pewter magic drinks you bought from\nDiagon Alley last week.",
            new String[] { "use" });
          Potion potion = new Potion(
            "Potion",
            "At the back of the class, you spot a flask of some bright violet\npotion! You wonder what would happen if you were to drink it...",
            new String[] { "drink", "use" });
          ArrayList<Item> TurkItems = new ArrayList<Item>();
          TurkItems.add(schiebe);
          TurkItems.add(potion);

          Location Potions = new Location(
            "Turk Region",
            "Down the long passage, You see a village. It's call 'Turk Region'.\nA small village is situated in the region. It has many houses, shops, and an inn, with most of the structures and paths built with brick-like material.\n An herbalist resides in a tall building decorated with plants.",
            TurkPeople,
            TurkItems,
            null,
            null,
            null,
            Entrance);

          Entrance.east = Potions;

          Location curr = Entrance;

          Move move = new Move(curr);
          Look look = new Look(curr);
          Talk talk = new Talk(curr);
          Use use = new Use(curr);
          ArrayList<Polyjuice> poly = new ArrayList<Polyjuice>();
          ArrayList<Invisibility> invis = new ArrayList<Invisibility>();
          Make make = new Make(curr, poly, invis);
          Help help = new Help(curr);
          SpellCommand spellcmd = new SpellCommand(curr);

          Command[] cmds =
            new Command[] { move, look, talk, use, make, help, spellcmd };
          ControlPanel panel = new ControlPanel(cmds, curr);

          AudioPlayer.begin_track();

          DisplayImage.image_1();


          Choice.animation();
          System.out.println("\n");
          Choice.title();;

          String text =
            "\n\"Now a new beginning has begun to be,\r\n" +                
            "And in this land that you protected and kept in safety,\r\n" + 
            "These budding lives are with me on this journey.”\"\r\nSay the title to reveal the map.";
          TypeEffect.delay(text);



          Scanner cin = new Scanner(System.in);

          //		Commented for time being to ease debugging
          for (int i = 1; !cin.nextLine().equalsIgnoreCase("sousou no frieren");
               i++) //
          {
               if (i < 3) {
                    System.out.println(
                      "That's not the right words! Try again.");
               } else if (i == 3) {
                    System.out.println(
                      "OK, fine. The answer is 'sousou no frieren'");
               } else {
                    System.out.println(
                      "WHY!? I GIVE YOU THE PHRASE ISN'T IT? （*゜ー゜*）");
                    System.exit(0);
               }
          }
          AudioPlayer.stop();

          // Display the entrance message after getting the magic phrase right
          // TypeEffect.delay(entranceMessage);

          serie.playerLoc = curr;
          serie.t.start();
          System.out.println("\t\t" + curr.name);
          curr.look();

          System.out.print("\n> ");
          String input = cin.nextLine();

          while (!input.equalsIgnoreCase("quit")) {
               curr = panel.parse(input);
               look.curr = curr;
               use.curr = curr;
               make.curr = curr;
               talk.curr = curr;
               help.curr = curr;
               spellcmd.curr = curr;
               serie.playerLoc = curr;

               System.out.print("> ");
               input = cin.nextLine();
          }

          System.out.println(
            "You are too tired to keep going on...have a nice sleep.");
          cin.close();
          System.exit(0);
     }
}

class Choice extends colors
{

     public static void animation() // Animation function
     {
          try {

               final int total = 100; // Total percentage to load

               for (int i = 0; i <= total; i++) {
                    // Calculate the number of equal signs to add to the
                    // progress bar
                    int progressPercentage =
                      (i * 100) / total; // Will run from 0 to 100
                    int equalSigns =
                      (progressPercentage * 30) /
                      100; // Assuming the progress bar is 30 characters wide
                    StringBuilder bar =
                      new StringBuilder(); // Use this function to added up the
                                           // equal sign
                    for (int j = 0; j < equalSigns; j++) {
                         bar.append("=");
                    }
                    for (int j = 0; j < 30 - equalSigns; j++) {
                         bar.append(" ");
                    }

                    // Print the progress bar with the percentage
                    System.out.print("\r                    [" +
                                     bar.toString() + "] " +
                                     i + // Do the interface
                                     "%");
                    Thread.sleep(
                      50); // Sleep for a short period to simulate progress
               }
               Thread.sleep(500);

          } catch (Exception e) {
               // catching the exception
               System.out.println(e);
          }
     }
     public static void title() {
 		BufferedReader r = null;

	    // Use FileInputStream with InputStreamReader specifying UTF-8 encoding
	    try {
			try {
				r = new BufferedReader(new InputStreamReader(new FileInputStream("src\\image\\title.txt"), "UTF-8"));
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	StringBuilder s = new StringBuilder(); // Use StringBuilder for efficiency
	String line = null;
	try {
	    while ((line = r.readLine()) != null) {
	        s.append(line).append(System.lineSeparator()); // Append line and newline
	    }
	} catch (IOException e) {
	    e.printStackTrace();
	} finally {
	    if (r != null) {
	        try {
	            r.close(); // Close the BufferedReader
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
	}
	System.out.print(s.toString());
     }
}
