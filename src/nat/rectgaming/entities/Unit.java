package nat.rectgaming.entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Animation;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public abstract class Unit extends GameObject{
	boolean canAct;
	boolean isDead;
	public int health;
	public int damage;
	public Shape rect;
	
	public SpriteSheet spriteUp;
	public SpriteSheet spriteLeft;
	public SpriteSheet spriteDown;
	public SpriteSheet spriteRight;
	public SpriteSheet spriteRightUp;
	public SpriteSheet spriteLeftUp;
	public SpriteSheet spriteLeftDown;
	public SpriteSheet spriteRightDown;
	
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
		canAct = true;
	}
	
	@Override
	public String toString(){
		return health+"/"+damage+" Unit, a "+super.toString();
	}
	
		public void Move(String direction, float speedOverride, int delta){
			if(canAct){
				if(true){//TBI: Test for GameObject at space
					switch(direction){
						case "up":
							facingDirection = "up";
							positionY-= speedOverride * delta ;
							break;
						case "left":
							facingDirection = "left";
							positionX-= speedOverride * delta;
							break;
						case "down":
							facingDirection = "down";
							positionY+= speedOverride * delta;
							break;
						case "right":
							facingDirection = "right";
							positionX+= speedOverride * delta;
							break;
							
						case "leftUp":
							facingDirection = "leftUp";
							positionX-= speedOverride * delta;
							positionY-= speedOverride * delta;
							break;
							
						case "leftDown":
							facingDirection = "leftDown";
							positionX-= speedOverride * delta;
							positionY+= speedOverride * delta;
							break;
							
						case "rightDown":
							facingDirection = "rightDown";
							positionX+= speedOverride * delta;
							positionY+= speedOverride * delta;
							break;
						
						case "rightUp":
							facingDirection = "rightUp";
							positionX+= speedOverride * delta;
							positionY-= speedOverride * delta;
							break;
						default:
							System.out.println("Invalid direction was called!");
							break;
					}
				}
			else {
				if(true){ //TBI: Is enemy?
					Attack();
				}
			}//else
		}//if(canAct) 
	}//Move()

	protected void Attack(){
		
	}//Attack()
	
	void Die(){
		isDead = true;
		
	}//Die()
	
	public void AI(float speed,int delta){
		//Placeholder AI for overriding.
	}
}
