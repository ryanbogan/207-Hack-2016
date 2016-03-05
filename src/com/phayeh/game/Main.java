package com.phayeh.game;

import javax.swing.JFrame;

public class Main {
	public static void main(String args[]) {
		JFrame window = new Window();
		window.setResizable(false);
		window.setVisible(true);
		window.setSize(800,450);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
