package Entity;

import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import TileMap.TileMap;

public class Player extends MapObject {
	
	// player stuff
	private int health;
	private int maxHealth;
	private int ink;
	private int maxInk;
	private boolean dead;
	private boolean flinching;
	private long flinchTimer;
	private boolean facingRight;
	
	// ink
	private boolean inking;
	private int inkCost;
	private int inkBlastDamage;
	private ArrayList<InkBlast> inkBlasts;
	
	//slap
	private boolean slapping;
	private int slapDamage;
	private int slapRange;
	
	//gliding
	private boolean gliding;
	
	//animations
	private ArrayList<BufferedImage[]> sprites;
	private final int[] numFrames = {2, 8, 1, 2, 4, 2, 5};
	private final Animation animation;
	
	//animation actions
	private static final int IDLE = 0;
	private static final int WALKING = 1;
	private static final int JUMPING = 2;
	private static final int FALLING = 3;
	private static final int GLIDING = 4;
	private static final int INKBLAST = 5;
	private static final int SLAPPING = 6;
	
	public Player(TileMap tm) {
		
		super(tm);
		
		width = 30;
		height = 30;
		cwidth = 20;
		cheight = 20;
		
		moveSpeed = 0.3;
		maxSpeed = 1.6;
		stopSpeed = 0.4;
		fallSpeed = 0.15;
		maxFallSpeed = 4.0;
		jumpStart = -4.8;
		stopJumpSpeed = 0.3;
		
		facingRight = true;
		
		health= maxHealth = 5;
		ink = maxInk = 2500;
		
		inkCost = 200;
		inkBlastDamage = 5;
		inkBlasts = new ArrayList<InkBlast>();
		
		slapDamage = 8;
		slapRange = 40;
		
		//load sprites
		try {
			
			BufferedImage spritesheet = ImageIO.read(getClass().getResourceAsStream("/images/sprites/player_sprites.png"));
			
			sprites = new ArrayList<BufferedImage[]>();
			for(int i = 0; i < 7; i++) {
				BufferedImage[] bi = new BufferedImage[numFrames[i]];
				for(int j = 0; j < numFrames[i]; j++) {
					if(i != SLAPPING) {
						bi[j] = spritesheet.getSubimage(j * width, i * height, width, height);
					}
					else {
						bi[j] = spritesheet.getSubimage(j * width * 2, i * height, width * 2, height);
					} 
				}
				
				sprites.add(bi);
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		animation = new Animation();
		currentAction = IDLE;
		animation.setFrames(sprites.get(IDLE));
		animation.setDelay(400);
	}
	
	public int getHealth() { return health; }
	public int getMaxHealth() { return maxHealth; }
	public int getInk() { return ink; }
	public int getMaxInk() { return maxInk; }
	
	public void setInking() {
		inking = true;
	}
	
	public void setSlapping() {
		slapping = true;
	}
	
	public void setGliding(boolean b) {
		gliding = b;
	}
	
	private void getNextPosition() {
		
		//movement
		if(left) {
			dx -= moveSpeed;
			if(dx < -maxSpeed) {
				dx = -maxSpeed;
			}
		}
		else if(right) {
			dx += moveSpeed;
			if(dx > maxSpeed) {
				dx = maxSpeed;
			}
		}
		else {
			if(dx > 0) {
				dx -= stopSpeed;
				if(dx < 0) {
					dx = 0;
				}
			}
			else if(dx < 0) {
				dx += stopSpeed;
				if(dx > 0) {
					dx = 0;
				}
			}
		}
		
		//cannot move while attacking unless in air 
		if((currentAction == SLAPPING || currentAction == INKBLAST) && !(jumping || falling)) {
			dx = 0;
		}
		
		//jumping
		if(jumping && !falling) {
			dy = jumpStart;
			falling = true;
		}
		
		//falling
		if(falling) {
			
			if(dy > 0 && gliding) dy += fallSpeed * 0.1;
			else dy += fallSpeed;
			
			if(dy > 0) jumping = false;
			if(dy < 0 && !jumping) dy += stopJumpSpeed;
			
			if(dy > maxFallSpeed) dy = maxFallSpeed;
			
		}
		
	}
	
	public void update() {
		
		//update position
		getNextPosition();
		checkTileMapCollision();
		setPosition(xtemp, ytemp);
		
		//check attack has stopped
		if(currentAction == SLAPPING) {
			if(animation.hasPlayedOnce()) slapping = false;
		}
		if(currentAction == INKBLAST) {
			if(animation.hasPlayedOnce()) inking = false;
		}
		
		//inkblast attack
		ink += 1;
		if(ink > maxInk) ink = maxInk;
		if(inking && currentAction != INKBLAST) {
			if(ink > inkCost) {
				ink -= inkCost;
				InkBlast ib = new InkBlast(tileMap, facingRight);
				ib.setPosition(x, y);
				inkBlasts.add(ib);
				
			}
		}
		
		//update inkblasts
		for(int i = 0; i < inkBlasts.size(); i++) {
			inkBlasts.get(i).update();
			if(inkBlasts.get(i).shouldRemove()) {
				inkBlasts.remove(i);
				i--;
			}
		}
		
		//set animation
		if(slapping) {
			if(currentAction != SLAPPING) {
				currentAction = SLAPPING;
				animation.setFrames(sprites.get(SLAPPING));
				animation.setDelay(50);
				width = 60;
			}
		}
		else if(inking) {
			if(currentAction != INKBLAST) {
				currentAction = INKBLAST;
				animation.setFrames(sprites.get(INKBLAST));
				animation.setDelay(100);
				width = 30;
			}
		}
		else if(dy > 0) {
			if(gliding) {
				if(currentAction != GLIDING) {
					currentAction = GLIDING;
					animation.setFrames(sprites.get(GLIDING));
					animation.setDelay(100);
					width = 30;
				}
				else if(currentAction != FALLING) {
					currentAction = FALLING;
					animation.setFrames(sprites.get(FALLING));
					animation.setDelay(100);
					width = 30;
				}
			}
		}
		else if(dy < 0) {
			if(currentAction != JUMPING) {
				currentAction = JUMPING;
				animation.setFrames(sprites.get(JUMPING));
				animation.setDelay(-1);
				width = 30;
			}
		}
		else if(left || right)  {
			if(currentAction != WALKING) {
				currentAction = WALKING;
				animation.setFrames(sprites.get(WALKING));
				animation.setDelay(40);
				width = 30;
			}
		}
		else {
			if(currentAction != IDLE) {
				currentAction = IDLE;
				animation.setFrames(sprites.get(IDLE));
				animation.setDelay(400);
				width = 30;
			}
		}
		
		animation.update();
		
		//set direction
		if(currentAction != SLAPPING && currentAction != INKBLAST) {
			if(right) facingRight = true;
			if(left) facingRight = false;
		}
	}	
		public void draw(Graphics2D g) {
			
			setMapPosition();
			
			//draw inkblasts
			for(int i = 0; i < inkBlasts.size(); i++) {
				inkBlasts.get(i).draw(g);
			}
			
			//draw player
			if(flinching) {
				long elapsed = (System.nanoTime() - flinchTimer) / 1000000;
				if(elapsed / 100 % 2 == 0) {
					return;
				}
			}
			
			super.draw(g);
			
		}
	}
