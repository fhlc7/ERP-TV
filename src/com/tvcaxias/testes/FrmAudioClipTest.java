package com.tvcaxias.testes;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class FrmAudioClipTest extends JFrame {

	String endereco;
	File arquivo;
	AudioClip a;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FrmAudioClipTest frame = new FrmAudioClipTest();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FrmAudioClipTest() {
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowOpened(WindowEvent arg0) {
				initialize();
			}
		});
		setTitle("Teste");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.setMnemonic('p');
		btnPlay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				executar("play");
			}
		});
		btnPlay.setBounds(52, 170, 89, 23);
		contentPane.add(btnPlay);
		
		JButton btnStop = new JButton("Stop");
		btnStop.setMnemonic('s');
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				executar("stop");
			}
		});
		btnStop.setBounds(275, 170, 89, 23);
		contentPane.add(btnStop);
		
		JButton btnLoop = new JButton("Loop");
		btnLoop.setMnemonic('l');
		btnLoop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				executar("loop");
			}
		});
		btnLoop.setBounds(165, 170, 89, 23);
		contentPane.add(btnLoop);
	}
	
	private void initialize() {
		try {
			//endereco = "D:\\Server TV Caxias\\Fabiano Henrique\\Rádio\\Testes/abc.wav";
			endereco = "D:\\Server TV Caxias\\Fabiano Henrique\\Rádio\\Testes/Rádio.url.wav";
			arquivo = new File(endereco);
			a = Applet.newAudioClip(arquivo.toURI().toURL());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void executar(String cmd) {
		try {
			
//			AudioFileFormat a = AudioSystem.getAudioFileFormat(arquivo);
//			System.out.println(a.getProperty("name"));
			
			if (cmd.equals("play")) {
				a.play();
			} else if (cmd.equals("loop")) {
				a.loop();
			} if (cmd.equals("stop")) {
				a.stop();
			}
			
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
