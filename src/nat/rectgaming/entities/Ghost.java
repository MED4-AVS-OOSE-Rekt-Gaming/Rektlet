package nat.rectgaming.entities;

import nat.rectgaming.Maploader;

import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Ghost extends Unit {
	
	
	@Override
	public String toString(){
		return "The Ghost, who is a "+super.toString();
	}
	
	public Ghost(int spawnX, int spawnY, float speed){
		positionX = spawnX;
		positionY = spawnY;
		localSpeed = speed;
		width = 16;
		height = 16;
		rect = new Rectangle(positionX, positionY, width, height);
		facingDirection = "down";
		health = 3;
		isDead = false;
		
		
		try { //Override Move

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
	}// Ghost
	
	public void AI(int deltat){
		if(health > 0){
			if((int)(Maploader.mainPlayer.positionX) > (int)(this.positionX) && (int)(Maploader.mainPlayer.positionY) > (int)(this.positionY)){
				Move("rightDown", deltat);
			} else if((int)(Maploader.mainPlayer.positionX) < (int)(this.positionX) && (int)(Maploader.mainPlayer.positionY) > (int)(this.positionY)){
				Move("leftDown", deltat);
			} else if((int)(Maploader.mainPlayer.positionX) > (int)(this.positionX) && (int)(Maploader.mainPlayer.positionY) < (int)(this.positionY)){
				Move("rightUp", deltat);
			} else if((int)(Maploader.mainPlayer.positionX) < (int)(this.positionX) && (int)(Maploader.mainPlayer.positionY) < (int)(this.positionY)){
				Move("leftUp", deltat);
			} else if((int)(Maploader.mainPlayer.positionX) == (int)(this.positionX) && (int)(Maploader.mainPlayer.positionY) > (int)(this.positionY)){
				Move("down", deltat);
			} else if((int)(Maploader.mainPlayer.positionX) == (int)(this.positionX) && (int)(Maploader.mainPlayer.positionY) < (int)(this.positionY)){
				Move("up", deltat);
			} else if((int)(Maploader.mainPlayer.positionX) > (int)(this.positionX) && (int)(Maploader.mainPlayer.positionY) == (int)(this.positionY)){
				Move("right", deltat);
			} else if((int)(Maploader.mainPlayer.positionX) < (int)(this.positionX) && (int)(Maploader.mainPlayer.positionY) == (int)(this.positionY)){
				Move("left", deltat);
			}
		} else {
			isDead = true;
		}
	}//AI

}//EOF
