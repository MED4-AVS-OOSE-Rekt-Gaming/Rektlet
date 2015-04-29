package nat.rectgaming.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;

public class Player extends Unit{
	
	@Override
	public String toString(){
		return "The Player, who is a "+super.toString();
	}
	
	public Player(){
		positionX = 0;
		positionY = 0;
		
		try {
			spriteUp = new SpriteSheet(new Image("res/babarianMoveUp.png"),16,16);
			moveUp = new Animation(spriteUp, 300);
			spriteLeft = new SpriteSheet(new Image("res/babarianMoveLeft.png"),16,16);
			moveLeft = new Animation(spriteLeft, 300);
			spriteDown = new SpriteSheet(new Image("res/babarianMoveDown.png"),16,16);
			moveDown = new Animation(spriteDown, 300);
			spriteRight = new SpriteSheet(new Image("res/babarianMoveRight.png"),16,16);
			moveRight = new Animation(spriteRight, 300);
		} catch (SlickException e) {

		}
	}
	


	
} //EOF
