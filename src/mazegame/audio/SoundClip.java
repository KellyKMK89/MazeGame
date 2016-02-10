package mazegame.audio;

import javax.sound.sampled.*;
import java.io.*;

public class SoundClip {

	private boolean looping = false;
	private AudioInputStream sample;
	private int repeat = 0;
	private String filename = "";
	private Clip clip;
	

	public SoundClip() {
		try {
			clip = AudioSystem.getClip();
		} 
		catch (LineUnavailableException e) { }
	}
	
	public SoundClip(String audiofile) {
		this(); 
		load(audiofile); 
	}
	
	public boolean load(String audiofile) {
		try {
			setFilename(audiofile);
			sample = AudioSystem.getAudioInputStream(SoundClip.class.getResource(audiofile));
			clip.open(sample); //load the audio file
			return true;
			} catch (IOException e) {
			return false;
			} catch (UnsupportedAudioFileException e) {
			return false;
			} catch (LineUnavailableException e) {
			return false;
		}
	}
	
	public void play() {
		if (!isLoaded()) return;
		clip.setFramePosition(0); 		//reset the sound clip
		if (looping)
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		else
			clip.loop(repeat);
	}
	
	public void stop() {
		clip.stop();
	}
	
	public boolean isLoaded() {
		return (boolean)(sample != null);
	}
	
	public void setLooping(boolean _looping) { 
		looping = _looping; 
	}
	
	public boolean getLooping() {
		return looping; 
	}
	
	public void setRepeat(int _repeat) {
		repeat = _repeat; 
	}
	
	public int getRepeat() {
		return repeat; 
	}
	
	public Clip getClip(){
		return clip;
	}
	
	public void setFilename(String _filename) {
		filename = _filename; 
	}
	
	public String getFilename() {
		return filename; 
	}
	

}
