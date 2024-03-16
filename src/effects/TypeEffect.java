package effects;

public class TypeEffect {
	public static void delay(String message) {
	    System.out.print("\033[H\033[2J");
	    System.out.flush();
	    for (int i = 0; i < message.length(); i++) {
	        System.out.printf("%c", message.charAt(i));
	        try {
	            Thread.sleep(25); // 0.05s pause between characters
	        } catch (InterruptedException ex) {
	            Thread.currentThread().interrupt();
	        }
	    }
	}


}
