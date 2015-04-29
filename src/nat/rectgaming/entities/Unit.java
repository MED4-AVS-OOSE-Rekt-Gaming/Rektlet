package nat.rectgaming.entities;

import org.newdawn.slick.Color;
import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Animation;

public abstract class Unit extends GameObject{
	boolean canAct;
	boolean isDead;
	public int health;
	public int damage;
	
	public SpriteSheet spriteUp;
	public SpriteSheet spriteLeft;
	public SpriteSheet spriteDown;
	public SpriteSheet spriteRight;
	
	public Animation moveUp;
	public Animation moveLeft;
	public Animation moveDown;
	public Animation moveRight;
	
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
	
	public void Move(int directionX, int directionY){
		if(canAct){
			if(true){//TBI: Test for GameObject at space
				positionX += directionX;
				positionY += directionY;
			} else {
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
}
