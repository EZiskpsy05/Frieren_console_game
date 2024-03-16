package image;

public class DisplayImage {
	public static void image_1() {
        try {
            // Command to open the image. Adjust according to your OS and viewer.
            // This example uses the default viewer on Windows.
            String imagePath = "src\\image\\title.png";
            String command = "cmd /c start " + imagePath;

            // Execute the command to open the image
            @SuppressWarnings("deprecation")
			Process process = Runtime.getRuntime().exec(command);

            // Wait for 5 seconds
            Thread.sleep(5000);

            // Closing the viewer is not covered here due to the complexity and variability
            // between different operating systems and viewers.

        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}
