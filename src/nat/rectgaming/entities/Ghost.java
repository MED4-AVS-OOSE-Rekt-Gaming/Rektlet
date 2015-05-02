package nat.rectgaming.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import nat.rectgaming.GameManager;

public class Ghost extends Unit {
	
	@Override
	public String toString(){
		return "The Ghost, who is a "+super.toString();
	}
	
	public Ghost(int spawnX, int spawnY){
		positionX = spawnX;
		positionY = spawnY;
		facingDirection = "down";
		
		health = 3;
		damage = 1;
		isDead = false;
		canAct = true;
		
		try { 
			spriteUp = new SpriteSheet(new Image("res/images/units/ghost/ghostMoveUp.png"),16,16);
			moveUp = new Animation(spriteUp, 300);
			
			spriteLeft = new SpriteSheet(new Image("res/images/units/ghost/ghostMoveLeft.png"),16,16);
			moveLeft = new Animation(spriteLeft, 300);
			
			spriteDown = new SpriteSheet(new Image("res/images/units/ghost/ghostMoveDown.png"),16,16);
			moveDown = new Animation(spriteDown, 300);
			
			spriteRight = new SpriteSheet(new Image("res/images/units/ghost/ghostMoveRight.png"),16,16);
			moveRight = new Animation(spriteRight, 300);
			
			spriteRightUp = new SpriteSheet(new Image("res/images/units/ghost/ghostMoveRightUp.png"),16,16);
			moveRightUp = new Animation(spriteRightUp, 300);
			
			spriteLeftUp = new SpriteSheet(new Image("res/images/units/ghost/ghostMoveLeftUp.png"),16,16);
			moveLeftUp = new Animation(spriteLeftUp, 300);
			
			spriteRightDown = new SpriteSheet(new Image("res/images/units/ghost/ghostMoveRightDown.png"),16,16);
			moveRightDown = new Animation(spriteRightDown, 300);
			
			spriteLeftDown = new SpriteSheet(new Image("res/images/units/ghost/ghostMoveLeftDown.png"),16,16);
			moveLeftDown = new Animation(spriteLeftDown, 300);

		} catch (SlickException e) {

		}
	}
	
	@Override
	public void AI(){
		if(GameManager.mainPlayer.positionX > this.positionX && GameManager.mainPlayer.positionY > this.positionY){
			Move("rightDown");
		} else if(GameManager.mainPlayer.positionX < this.positionX && GameManager.mainPlayer.positionY > this.positionY){
			Move("leftDown");
		} else if(GameManager.mainPlayer.positionX > this.positionX && GameManager.mainPlayer.positionY < this.positionY){
			Move("rightUp");
		} else if(GameManager.mainPlayer.positionX < this.positionX && GameManager.mainPlayer.positionY < this.positionY){
			Move("leftUp");
		} else if(GameManager.mainPlayer.positionX == this.positionX && GameManager.mainPlayer.positionY > this.positionY){
			Move("down");
		} else if(GameManager.mainPlayer.positionX == this.positionX && GameManager.mainPlayer.positionY < this.positionY){
			Move("up");
		} else if(GameManager.mainPlayer.positionX > this.positionX && GameManager.mainPlayer.positionY == this.positionY){
			Move("right");
		} else if(GameManager.mainPlayer.positionX < this.positionX && GameManager.mainPlayer.positionY == this.positionY){
			Move("left");
		}
	}
}
