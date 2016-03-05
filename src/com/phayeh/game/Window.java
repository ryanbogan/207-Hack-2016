package com.phayeh.game;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import javax.swing.event.MouseInputListener;
import javax.swing.JFrame;

public class Window extends JFrame {

	private static final long serialVersionUID = 1L;
	
	private JFrame frame;

	public Window() {
		KeyListener kListen = new PhayeHKeyListener();
		MouseInputListener mListen = new PhayeHMouseListener();  
        frame = new JFrame();
		addKeyListener(kListen);
        addMouseListener(mListen);
        addMouseMotionListener(mListen);
        setFocusable(true);
	}
	
}