package audios;

import java.io.File;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;

public class AudioLoader {
	
	private String location;

	public AudioLoader(String location) {
		this.location = location;
	}
	
	public void play() {
		try {
			File path = new File(location);
			if(path.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(path);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
			}
			else {
				System.out.println("Cant find file at " + location);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public void loop() {
		try {
			File path = new File(location);
			if(path.exists()) {
				AudioInputStream audioInput = AudioSystem.getAudioInputStream(path);
				Clip clip = AudioSystem.getClip();
				clip.open(audioInput);
				clip.start();
				clip.loop(Clip.LOOP_CONTINUOUSLY);
				FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
				double gain = 0.25;   
				float dB = (float) (Math.log(gain) / Math.log(10.0) * 20.0);
				gainControl.setValue(dB);
			}
			else {
				System.out.println("Cant find file at " + location);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
			System.exit(1);
		}
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
}


