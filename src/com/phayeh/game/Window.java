package com.phayeh.game;

import java.awt.event.KeyListener;

import javax.swing.JFrame;

public class Window extends JFrame {
	
	public Window() {
		KeyListener listen = new PhayeHKeyListener();
        addKeyListener(listen);
        setFocusable(true);
	}
	
	
}