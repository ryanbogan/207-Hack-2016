package Entity;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Player extends MapObject {
	
	// player stuff
	private int health;
	private int maxHealth;
	private int ink;
	private int maxInk;
	private boolean dead;
	private boolean flinching;
	private long flinchTime;
	
	// ink
	private boolean firing;
	private int inkCost;
	private int inkBlastDamage;
	//private ArrayList<inkBlast> inkBlasts;
	
	//slap
	private boolean slapping;
	private int slapDamage;
	private int slapRange;
	
	//gliding
	private boolean gliding;
	
	//animations
	private ArrayList<BufferedImage[]> sprites;
	private final int[] numFrames {
		
	}
	
	//animation actions
	private static final int IDLE = 0;
	private static final int WALKING = 1;
	private static final int JUMPING = 2;
	private static final int FALLING = 3;
	private static final int GLIDING = 4;
	private static final int INKBLAST = 5;
	private static final int SLAPPING = 6;
	
}
