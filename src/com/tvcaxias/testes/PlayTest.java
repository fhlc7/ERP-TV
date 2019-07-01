package com.tvcaxias.testes;

import java.io.File;
import java.io.FileInputStream;

import javax.swing.JOptionPane;

import javazoom.jl.player.Player;

public class PlayTest {
	
	public static void main(String[] args) {
		
		try {
			
			//String endereco = "D:\\Server TV Caxias\\Fabiano Henrique\\Rádio\\Testes/abc.mp3";
			//String endereco = "D:\\Server TV Caxias\\Fabiano Henrique\\Rádio\\Testes/Rádio.url_1.mp3";
			//String endereco = "D:\\Server TV Caxias\\Fabiano Henrique\\Rádio\\Testes/abc.wav";
			//String endereco = "D:\\Server TV Caxias\\Fabiano Henrique\\Rádio\\Testes/Rádio.url.wav";
			String endereco = "C:\\abc.mp3";
			File arquivo = new File(endereco);
			
//			AudioFileFormat a = AudioSystem.getAudioFileFormat(arquivo);
//			System.out.println(a.getProperty("duration"));
//			System.out.println(a.properties().isEmpty());
			
			//AudioClip a = Applet.newAudioClip(arquivo.toURI().toURL());
			//a.play();
			//a.loop();
			
			while (true) {
				new Thread() {
					public void run() {
						JOptionPane.showMessageDialog(null, "Esta música vai tocar pra sempre");
					};
				}.start();
				Player p = new Player(new FileInputStream(arquivo));
				p.play();
			}
			
			/*Calendar c = new GregorianCalendar();
			c.setTimeInMillis(a.getFrameLength());
			SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
			System.out.println(sdf.format(c.getTime()));*/
			
			
//			Thread.sleep(2000);
//			
//			do {
//				Thread.sleep(2000);
//			} while (a.);

			//System.out.println("...");
			//JOptionPane.showMessageDialog(null, "Esta música vai tocar pra sempre");
			
		} catch (Exception e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "Erro: " + e.getMessage() + "\n\n************************************************\n\n" + e);
		}
		
		
		
	}
	
}
