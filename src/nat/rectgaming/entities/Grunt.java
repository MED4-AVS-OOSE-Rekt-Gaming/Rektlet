package nat.rectgaming.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;

public class Grunt extends Unit {

	@Override
	public String toString(){
		return "The Grunt, who is a "+super.toString();
	}
	
	public Grunt(int spawnX, int spawnY){
		positionX = spawnX;
		positionY = spawnY;
		facingDirection = "down";
		
		health = 3;
		damage = 1;
		isDead = false;
		canAct = true;
		
		try {

			spriteUp = new SpriteSheet(new Image("res/gruntMoveUp.png"),16,16);
			moveUp = new Animation(spriteUp, 300);
			spriteLeft = new SpriteSheet(new Image("res/gruntMoveLeft.png"),16,16);
			moveLeft = new Animation(spriteLeft, 300);
			spriteDown = new SpriteSheet(new Image("res/gruntMoveDown.png"),16,16);
			moveDown = new Animation(spriteDown, 300);
			spriteRight = new SpriteSheet(new Image("res/gruntMoveRight.png"),16,16);
			moveRight = new Animation(spriteRight, 300);

		} catch (SlickException e) {

		}
	}
	
	
}//EOF
