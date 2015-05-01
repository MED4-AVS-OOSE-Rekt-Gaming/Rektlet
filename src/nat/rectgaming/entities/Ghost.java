package nat.rectgaming.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;

public class Ghost extends Unit {
	
	@Override
	public String toString(){
		return "The Grunt, who is a "+super.toString();
	}
	
	public Ghost(int spawnX, int spawnY){
		positionX = spawnX;
		positionY = spawnY;
		facingDirection = "down";
		
		health = 3;
		damage = 1;
		isDead = false;
		canAct = true;
		
		try { //Override Move

			spriteUp = new SpriteSheet(new Image("res/ghostMoveUp.png"),16,16);
			moveUp = new Animation(spriteUp, 300);
			
			spriteLeft = new SpriteSheet(new Image("res/ghostMoveLeft.png"),16,16);
			moveLeft = new Animation(spriteLeft, 300);
			
			spriteDown = new SpriteSheet(new Image("res/ghostMoveDown.png"),16,16);
			moveDown = new Animation(spriteDown, 300);
			
			spriteRight = new SpriteSheet(new Image("res/ghostMoveRight.png"),16,16);
			moveRight = new Animation(spriteRight, 300);
			
			spriteRightUp = new SpriteSheet(new Image("res/ghostMoveRightUp.png"),16,16);
			moveRight = new Animation(spriteRight, 300);
			
			spriteLeftUp = new SpriteSheet(new Image("res/ghostMoveLeftUp.png"),16,16);
			moveRight = new Animation(spriteRight, 300);
			
			spriteRightDown = new SpriteSheet(new Image("res/ghostMoveRightDown.png"),16,16);
			moveRight = new Animation(spriteRight, 300);
			
			spriteLeftDown = new SpriteSheet(new Image("res/ghostMoveLeftDown.png"),16,16);
			moveRight = new Animation(spriteRight, 300);

		} catch (SlickException e) {

		}
	}
}
