package com.phayeh.game;

import javax.swing.JFrame;

public class Main {
	private static final int HEIGHT = 450;
	private static final int WIDTH = 800;
	
	public static void main(String args[]) {
		JFrame window = new Window();
		window.setResizable(false);
		window.setVisible(true);
		window.setSize(WIDTH, HEIGHT);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static double getAngle(int x, int y) {
		int dx = WIDTH/2 - x;
		int dy = HEIGHT/2 - y;
		
		double retAngle = Math.toRadians(Math.atan((double)(dy)/(double)(dx)));
		return retAngle;
	}
}
