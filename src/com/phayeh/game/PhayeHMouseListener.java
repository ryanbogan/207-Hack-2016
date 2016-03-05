package com.phayeh.game;

import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputListener;

public class PhayeHMouseListener implements MouseInputListener {

	@Override
	public void mouseClicked(MouseEvent e) {
	
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int x = e.getX();
		int y = e.getY();
		System.out.println(x + " " + y);
		System.out.println(Main.getAngle(x, y));
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// Stop action
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// Focus on screen?
		
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
