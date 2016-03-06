package com.phayeh.gamestate;

import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import Entity.Enemy;
import Entity.Player;
import TileMap.Background;
import TileMap.TileMap;

import com.phayeh.game.Board;

public class Level1State extends GameState {

	private TileMap tileMap;
	private Background bg;
	
	private Player player;
	
	private ArrayList<Enemy> enemies;
	
	public Level1State(GameStateManager gsm) {
		this.gsm = gsm;
		init();
	}
	
	public void init() {
		
		tileMap = new TileMap(30);
		tileMap.loadTiles("/images/tilesets/tiles.png");
		tileMap.loadMap("/images/maps/level1-1.map");
		tileMap.setPosition(0, 0);
		tileMap.setTween(1);
		
		bg = new Background("/images/backgrounds/waterBG.jpg", 0.1);
		
		player = new Player(tileMap);
		player.setPosition(100, 100);
		
		
	}
	
	public void update() {
		
		//update player
		player.update();
		tileMap.setPosition(Board.WIDTH / 2 - player.getx(), Board.HEIGHT / 2 - player.gety());
		
		//set background
		bg.setPosition(tileMap.getx(), tileMap.gety());
		
	}
	public void draw(Graphics2D g) {

		//clear screen
		//g.setColor(Color.WHITE);
		//g.fillRect(0, 0, Board.WIDTH, Board.HEIGHT);
		
		//draw bg
		bg.draw(g);
		
		//draw tilemap
		tileMap.draw(g);
		
		//draw player
		player.draw(g);
		
	}
	public void keyPressed(int k) {
		if(k == KeyEvent.VK_LEFT) player.setLeft(true);
		if(k == KeyEvent.VK_RIGHT) player.setRight(true);
		if(k == KeyEvent.VK_UP) player.setUp(true);
		if(k == KeyEvent.VK_DOWN) player.setDown(true);
		if(k == KeyEvent.VK_W) player.setJumping(true);
		if(k == KeyEvent.VK_E) player.setGliding(true);
		if(k == KeyEvent.VK_R) player.setSlapping();
		if(k == KeyEvent.VK_F) player.setInking();

	} 
	public void keyReleased(int k) {
		if(k == KeyEvent.VK_LEFT) player.setLeft(false);
		if(k == KeyEvent.VK_RIGHT) player.setRight(false);
		if(k == KeyEvent.VK_UP) player.setUp(false);
		if(k == KeyEvent.VK_DOWN) player.setDown(false);
		if(k == KeyEvent.VK_W) player.setJumping(false);
		if(k == KeyEvent.VK_E) player.setGliding(false);
	}
	
}
