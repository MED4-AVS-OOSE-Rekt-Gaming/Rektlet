package nat.rectgaming.entities;

import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Animation;
import org.newdawn.slick.geom.Shape;

public abstract class Unit extends GameObject{

	public boolean isDead;
	public int health;
	public float localSpeed;
	public Shape rect;
	
	protected SpriteSheet spriteUp;
	protected SpriteSheet spriteLeft;
	protected SpriteSheet spriteDown;
	protected SpriteSheet spriteRight;
	protected SpriteSheet spriteRightUp;
	protected SpriteSheet spriteLeftUp;
	protected SpriteSheet spriteLeftDown;
	protected SpriteSheet spriteRightDown;
	
	public Animation moveUp;
	public Animation moveLeft;
	public Animation moveDown;
	public Animation moveRight;
	public Animation moveLeftUp;
	public Animation moveLeftDown;
	public Animation moveRightUp;
	public Animation moveRightDown;
	
	public String facingDirection;
	
	Unit(){
		positionX = 0;
		positionY = 0;
		isDead = false;
	}
	
	@Override
	public String toString(){
		return health+" health Unit, a "+super.toString();
	}
	
		public void Move(String direction, int delta){
			
				switch(direction){
					case "up":
						facingDirection = "up";
						positionY-= localSpeed * delta ;
						break;
					case "left":
						facingDirection = "left";
						positionX-= localSpeed * delta;
						break;
					case "down":
						facingDirection = "down";
						positionY+= localSpeed * delta;
						break;
					case "right":
						facingDirection = "right";
						positionX+= localSpeed * delta;
						break;
						
					case "leftUp":
						facingDirection = "leftUp";
						positionX-= localSpeed * delta;
						positionY-= localSpeed * delta;
						break;		
					case "leftDown":
						facingDirection = "leftDown";
						positionX-= localSpeed * delta;
						positionY+= localSpeed * delta;
						break;
					case "rightDown":
						facingDirection = "rightDown";
						positionX+= localSpeed * delta;
						positionY+= localSpeed * delta;
						break;
					case "rightUp":
						facingDirection = "rightUp";
						positionX+= localSpeed * delta;
						positionY-= localSpeed * delta;
						break;
					default:
						System.out.println("Invalid direction was called!");
						break;
			}
	}//Move()
}//EOF
