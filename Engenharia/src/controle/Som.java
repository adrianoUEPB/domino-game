package controle;

import java.io.File;
import java.util.Random;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

public class Som {
	
	public void somJogaPeca(){
		
		Random r = new Random();
		int random = r.nextInt(5);
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
	
	public void somPegaUma(){

		File take = new File("./sound/take.wav");
        Clip clip;
		try {
			clip = AudioSystem.getClip();
	        AudioInputStream ais = AudioSystem.getAudioInputStream(take);
	        clip.open(ais);
	        clip.loop(0); //roda o áudio só uma vez
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void somEmbaralha(){
		
		File shake = new File("./sound/shake.wav");
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
	
	public void somClick(){

		File click = new File("./sound/click.wav");
		Clip clip;
		try {
	        clip = AudioSystem.getClip();
	        AudioInputStream ais = AudioSystem.getAudioInputStream(click);
	        clip.open(ais);
	        clip.loop(0); //roda o áudio só uma vez
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void somPassouVez(){

		File passouVez = new File("./sound/passouVez.wav");
		Clip clip;
		try {
	        clip = AudioSystem.getClip();
	        AudioInputStream ais = AudioSystem.getAudioInputStream(passouVez);
	        clip.open(ais);
	        clip.loop(0); //roda o áudio só uma vez
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void somVenceuPartida(){

		File venceuPartida = new File("./sound/venceuPartida.wav");
		Clip clip;
		try {
	        clip = AudioSystem.getClip();
	        AudioInputStream ais = AudioSystem.getAudioInputStream(venceuPartida);
	        clip.open(ais);
	        clip.loop(0); //roda o áudio só uma vez
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void somPerdeuPartida(){

		File perdeuPartida = new File("./sound/perdeuPartida.wav");
		Clip clip;
		try {
	        clip = AudioSystem.getClip();
	        AudioInputStream ais = AudioSystem.getAudioInputStream(perdeuPartida);
	        clip.open(ais);
	        clip.loop(0); //roda o áudio só uma vez
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void somVenceuRodada(){

		File venceuRodada = new File("./sound/venceuRodada.wav");
		Clip clip;
		try {
	        clip = AudioSystem.getClip();
	        AudioInputStream ais = AudioSystem.getAudioInputStream(venceuRodada);
	        clip.open(ais);
	        clip.loop(0); //roda o áudio só uma vez
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
}