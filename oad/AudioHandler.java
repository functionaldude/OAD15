package oad;

import java.io.FileInputStream;
import java.io.IOException;

import sun.audio.AudioData;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;
import sun.audio.ContinuousAudioDataStream;

public class AudioHandler {
	private AudioPlayer MGP = AudioPlayer.player;
	private AudioStream BGM;
	private AudioData MD;
	private ContinuousAudioDataStream loop = null;
	
	public AudioHandler(){
		
	}
	public void setAudioData(String input){
		try{
			BGM = new AudioStream(new FileInputStream(input));
			MD = BGM.getData();
			loop = new ContinuousAudioDataStream(MD);
		}catch(IOException error){
			System.out.print("file not found");
		}
	}
	public void start(){
		this.MGP.start(loop);
	}
	public void stop(){
		this.MGP.stop(loop);
	}
}
