package controle;

import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Som {
	
	File shake = new File("./sound/shake.wav");
	
	public void somJogaPeca(){
		
		Random r = new Random();
		int random = r.nextInt(6);
		File drop = new File("./sound/drop" + random + ".wav"); //chama um efeito sonoro aleatório

        Clip clip;
		try {
			clip = AudioSystem.getClip();
	        AudioInputStream ais = AudioSystem.getAudioInputStream(drop);
	        clip.open(ais);
	        clip.loop(0); //roda o áudio só uma vez
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void somEmbaralha(){
		
		Clip clip;
		try {
	        clip = AudioSystem.getClip();
	        AudioInputStream ais = AudioSystem.getAudioInputStream(shake);
	        clip.open(ais);
	        clip.loop(0); //roda o áudio só uma vez
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}