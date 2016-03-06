package com.phayeh.game;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.event.MouseInputListener;

public class PhayeHMouseListener implements MouseInputListener {

	@Override
	public void mouseClicked(MouseEvent e) {
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		System.out.println("Clicked: " + e.getX() + " " + e.getY());
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// Stop action
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// Input "snap-back" method
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// Not sure if this will be used
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// Rotational movement
		
	}

}
