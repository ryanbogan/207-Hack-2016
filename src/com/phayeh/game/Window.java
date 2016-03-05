package com.phayeh.game;

import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.PointerInfo;
import java.awt.event.KeyListener;
<<<<<<< HEAD

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;
=======
>>>>>>> origin/master

import javax.swing.JFrame;

public class Window extends JFrame {
	

	private static final long serialVersionUID = 1L;

	public Window() {
		KeyListener kListen = new PhayeHKeyListener();
		MouseInputListener mListen = new PhayeHMouseListener();  
        addKeyListener(kListen);
        addMouseListener(mListen);
        addMouseMotionListener(mListen);
        setFocusable(true);
        
        PointerInfo a = MouseInfo.getPointerInfo();
        Point b = a.getLocation();
        int x = (int) b.getX();
        int y = (int) b.getY();
        System.out.print(y + "jjjjjjjjj");
        System.out.print(x);
	}
	
	
}