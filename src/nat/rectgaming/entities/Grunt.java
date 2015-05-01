package nat.rectgaming.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Grunt extends Unit {

	@Override
	public String toString(){
		return "The Grunt, who is a "+super.toString();
	}
	
	public Grunt(int spawnX, int spawnY){
		positionX = spawnX;
		positionY = spawnY;
		facingDirection = "down";
		width = 16;
		height = 16;
		rect = new Rectangle(positionX, positionY, width,height);
		health = 3;
		damage = 1;
		isDead = false;
		canAct = true;
		
		try {

			spriteUp = new SpriteSheet(new Image("res/images/units/grunt/gruntMoveUp.png"),16,16);
			moveUp = new Animation(spriteUp, 300);
			
			spriteLeft = new SpriteSheet(new Image("res/images/units/gruntgruntMoveLeft.png"),16,16);
			moveLeft = new Animation(spriteLeft, 300);
			
			spriteDown = new SpriteSheet(new Image("res/images/units/gruntgruntMoveDown.png"),16,16);
			moveDown = new Animation(spriteDown, 300);
			
			spriteRight = new SpriteSheet(new Image("res/images/units/gruntgruntMoveRight.png"),16,16);
			moveRight = new Animation(spriteRight, 300);
			
			spriteRightUp = new SpriteSheet(new Image("res/images/units/gruntgruntMoveUp.png"),16,16);
			moveRight = new Animation(spriteRight, 300);
			
			spriteLeftUp = new SpriteSheet(new Image("res/images/units/gruntgruntMoveUp.png"),16,16);
			moveRight = new Animation(spriteRight, 300);
			
			spriteRightDown = new SpriteSheet(new Image("res/images/units/gruntgruntMoveDown.png"),16,16);
			moveRight = new Animation(spriteRight, 300);
			
			spriteLeftDown = new SpriteSheet(new Image("res/images/units/gruntgruntMoveDown.png"),16,16);
			moveRight = new Animation(spriteRight, 300);

		} catch (SlickException e) {

		}
	}
	
	
}//EOF
