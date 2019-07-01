package com.tvcaxias.testes;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFileFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.UnsupportedAudioFileException;

public class PlayTest {
	
	public static void main(String[] args) {
		
		try {
			
			String endereco = "D:\\Server TV Caxias\\Fabiano Henrique\\Rádio\\Testes/abc.wav";
			File arquivo = new File(endereco);
			
//			AudioFileFormat a = AudioSystem.getAudioFileFormat(arquivo);
//			System.out.println(a.getProperty("name"));
			
			AudioClip a = Applet.newAudioClip(arquivo.toURI().toURL());
			a.play();

			
//			Thread.sleep(2000);
//			
//			do {
//				Thread.sleep(2000);
//			} while (a.);

			System.out.println("...");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}
	
}
