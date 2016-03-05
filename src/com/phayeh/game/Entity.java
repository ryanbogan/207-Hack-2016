package com.phayeh.game;

import java.awt.event.KeyEvent;

public class Entity {
int x, dx, y, dy, speed, jump_height;
//Image still;

public Entity() {
	//ImageIcon i = new ImageIcon(path to character image);
	//still = i.getImage();
	x = 10;
	y = 172;
}

public void move(){
	x += dx;
	y += dy;
}

public int getX(){
	return x;
}

public int getY(){
	return y;
}

//public Image getImage(){
//	return still;
//}

public void keyPressed(KeyEvent e){
	int key = e.getKeyCode();
	
	if(key == KeyEvent.VK_LEFT){
		dx = -1 * speed;
	}
	
	if(key == KeyEvent.VK_RIGHT){
		dx = speed;
	}
}

public void keyReleased(KeyEvent e){
	int key = e.getKeyCode();
	
	if(key == KeyEvent.VK_LEFT){
		dx = 0;
	}
	
	if(key == KeyEvent.VK_RIGHT){
		dx = 0;
	}
}
}
