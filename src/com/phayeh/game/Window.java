package com.phayeh.game;

import java.awt.event.KeyListener;
import java.awt.*;
import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.awt.Rectangle;
import javax.swing.JPanel;

public class Window extends JPanel {
	
	public Window() {
		KeyListener listen = new PhayeHKeyListener();
        addKeyListener(listen);
        setFocusable(true);
	}
}
