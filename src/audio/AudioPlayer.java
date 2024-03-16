package audio;

import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class AudioPlayer { 

    private static Clip clip;
	private static AudioPlayer audioPlayer; 
    private AudioInputStream audioInputStream; 
    private String filePath; 

    public AudioPlayer(String filePath) 
            throws UnsupportedAudioFileException, 
            IOException, LineUnavailableException { 
        this.filePath = filePath;
        audioInputStream = AudioSystem.getAudioInputStream(new File(filePath).getAbsoluteFile()); 
        clip = AudioSystem.getClip(); 
        clip.open(audioInputStream); 
        clip.loop(Clip.LOOP_CONTINUOUSLY); 
    } 

    public static void play() { 
        clip.start(); 
    } 
	public static void stop(){
		clip.stop();
	}
	public static void begin_track() {
	    try {
	        String filePath = "src\\audio\\Main_theme.wav";
	        AudioPlayer.audioPlayer = new AudioPlayer(filePath);
	        AudioPlayer.play();
	    } catch (Exception ex) {
	        System.out.println("Error with playing sound.");
	        ex.printStackTrace();
	    }
	}

	
	
	
	
}


