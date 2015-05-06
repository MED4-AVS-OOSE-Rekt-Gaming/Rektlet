package nat.rectgaming.entities;

import nat.rectgaming.Maploader;

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
			
			spriteLeft = new SpriteSheet(new Image("res/images/units/grunt/gruntMoveLeft.png"),16,16);
			moveLeft = new Animation(spriteLeft, 300);
			
			spriteDown = new SpriteSheet(new Image("res/images/units/grunt/gruntMoveDown.png"),16,16);
			moveDown = new Animation(spriteDown, 300);
			
			spriteRight = new SpriteSheet(new Image("res/images/units/grunt/gruntMoveRight.png"),16,16);
			moveRight = new Animation(spriteRight, 300);
			
			moveLeftUp = new Animation(spriteUp,300);
			moveLeftDown = new Animation(spriteDown,300);
			moveRightUp = new Animation(spriteUp,300);
			moveRightDown = new Animation(spriteDown,300);

		} catch (SlickException e) {

		}
	}
	
	@Override
	public void AI(float s ,int deltat){
		if(health > 0){
			if((int)(Maploader.mainPlayer.positionX) > (int)(this.positionX) && (int)(Maploader.mainPlayer.positionY) > (int)(this.positionY)){
				Move("rightDown",s, deltat);
			} else if((int)(Maploader.mainPlayer.positionX) < (int)(this.positionX) && (int)(Maploader.mainPlayer.positionY) > (int)(this.positionY)){
				Move("leftDown",s, deltat);
			} else if((int)(Maploader.mainPlayer.positionX) > (int)(this.positionX) && (int)(Maploader.mainPlayer.positionY) < (int)(this.positionY)){
				Move("rightUp",s, deltat);
			} else if((int)(Maploader.mainPlayer.positionX) < (int)(this.positionX) && (int)(Maploader.mainPlayer.positionY) < (int)(this.positionY)){
				Move("leftUp",s, deltat);
			} else if((int)(Maploader.mainPlayer.positionX) == (int)(this.positionX) && (int)(Maploader.mainPlayer.positionY) > (int)(this.positionY)){
				Move("down",s, deltat);
			} else if((int)(Maploader.mainPlayer.positionX) == (int)(this.positionX) && (int)(Maploader.mainPlayer.positionY) < (int)(this.positionY)){
				Move("up",s, deltat);
			} else if((int)(Maploader.mainPlayer.positionX) > (int)(this.positionX) && (int)(Maploader.mainPlayer.positionY) == (int)(this.positionY)){
				Move("right",s, deltat);
			} else if((int)(Maploader.mainPlayer.positionX) < (int)(this.positionX) && (int)(Maploader.mainPlayer.positionY) == (int)(this.positionY)){
				Move("left",s, deltat);
			}
		} else {
			
		}
	}//AI End
}//EOF
