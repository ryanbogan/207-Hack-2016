package com.phayeh.gamestate;

import java.awt.Color;
import java.awt.Graphics2D;

import Entity.Player;
import TileMap.Background;
import TileMap.TileMap;

import com.phayeh.game.Board;

public class Level1State extends GameState {

	private TileMap tileMap;
	private Background bg;
	
	private Player player;
	
	public Level1State(GameStateManager gsm) {
		this.gsm = gsm;
		init();
	}
	
	public void init() {
		
		tileMap = new TileMap(30);
		tileMap.loadTiles("/images/tilesets/grasstileset.gif");
		tileMap.loadMap("/images/maps/level1-1.map");
		tileMap.setPosition(0, 0);
		
		bg = new Background("/images/backgrounds/grassbg1.gif", 0.1);
		
		player = new Player(tileMap);
		
	}
	
	public void update() {
		
		//update player
		player.update();
		
	}
	public void draw(Graphics2D g) {
		
		//clear screen
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, Board.WIDTH, Board.HEIGHT);
		
		//draw bg
		bg.draw(g);
		
		//draw tilemap
		tileMap.draw(g);
		
		//draw player
		player.draw(g);
		
	}
	public void keyPressed(int k) {}
	public void keyReleased(int k) {}
	
}
