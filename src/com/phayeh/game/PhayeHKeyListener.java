package com.phayeh.game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PhayeHKeyListener implements KeyListener {

	private boolean moveLeft = false;
	private  boolean moveRight = false;
	private  boolean moveDown = false;
	private  boolean moveUp = false;
	
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyPressed(KeyEvent e) {
    	System.out.println("keyTyped="+KeyEvent.getKeyText(e.getKeyCode()));
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_LEFT) {
            moveLeft = true;
        }

        if (key == KeyEvent.VK_RIGHT) {
            moveRight = true;
        }

        if (key == KeyEvent.VK_UP) {
            moveUp = true;
        }

        if (key == KeyEvent.VK_DOWN) {
            moveDown = true;
        }
	}

	@Override
	public void keyReleased(KeyEvent e) {
		System.out.println("keyReleased="+KeyEvent.getKeyText(e.getKeyCode()));
		int key = e.getKeyCode();
		
		if (key == KeyEvent.VK_LEFT) {
            moveLeft = true;
        }

        if (key == KeyEvent.VK_RIGHT) {
            moveRight = true;
        }

        if (key == KeyEvent.VK_UP) {
            moveUp = true;
        }

        if (key == KeyEvent.VK_DOWN) {
            moveDown = true;
        }
	}

}
