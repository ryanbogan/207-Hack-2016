package com.phayeh.game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.swing.JPanel;

import com.phayeh.gamestate.GameStateManager;

public class GamePanel extends JPanel implements KeyListener, Runnable{

	private Thread thread;
private boolean running;
private int FPS = 60;
private long targetTime = 1000 / FPS;

private BufferedImage image;
private Graphics2D g;

//game state manager
private GameStateManager gsm;

	public GamePanel() {
		super();
		setFocusable(true);
		requestFocus();
		//ImageIcon i = new ImageIcon(path to background image);
		//img = i.getImage();
	}
	
	public void addNotify() {
		super.addNotify();
		if(thread == null) {
			thread = new Thread(this);
			addKeyListener(this);
			thread.start(); 
		}
	}
	
	private void init() {
		
		image= new BufferedImage(WIDTH, HEIGHT, BufferedImage.TYPE_INT_RGB);
	
		g = (Graphics2D) g;
		
		running = true;
		
		gsm = new GameStateManager();
	}
	
	public void run() {
		init();
		
		long start;
		long elapsed;
		long wait;
		
		//game loop
		while(running) {
			
			start = System.nanoTime();
			
			update();
			draw();
			drawToScreen();
			
			elapsed = System.nanoTime() - start;
			
			wait = targetTime - elapsed / 1000000;
					
			try {
				Thread.sleep(wait);
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	private void update() {
		gsm.update();
	}
	private void draw() {
		gsm.draw(g);
	}
	private void drawToScreen(){
		Graphics g2 = getGraphics();
		g2.drawImage(image, 0, 0, null);
		g2.dispose();
	}
	
	public void keyTyped(KeyEvent key) {}
	public void keyPressed(KeyEvent key) {
		gsm.keyPressed(key.getKeyCode());
	}
	public void keyReleased(KeyEvent key) {
		gsm.keyReleased(key.getKeyCode());
	}
}
