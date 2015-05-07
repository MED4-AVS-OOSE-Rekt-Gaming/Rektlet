package nat.rectgaming.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.Animation;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

import nat.rectgaming.GameManager;
public class Player extends Unit{
	
	@Override
	public String toString(){
		return "The Player, who is a "+super.toString();
	}
	
	public Player(int spawnX, int spawnY){
		positionX = spawnX;
		positionY = spawnY;
		width = 16;
		height = 16;
		rect = new Rectangle(positionX,positionY,width,height);
		facingDirection = "down";
		health = 3;
		
		try {
			spriteUp = new SpriteSheet(new Image("res/images/units/babarian/babarianMoveUp.png"),16,16);
			moveUp = new Animation(spriteUp, 300);
			spriteLeft = new SpriteSheet(new Image("res/images/units/babarian/babarianMoveLeft.png"),16,16);
			moveLeft = new Animation(spriteLeft, 300);
			spriteDown = new SpriteSheet(new Image("res/images/units/babarian/babarianMoveDown.png"),16,16);
			moveDown = new Animation(spriteDown, 300);
			spriteRight = new SpriteSheet(new Image("res/images/units/babarian/babarianMoveRight.png"),16,16);
			moveRight = new Animation(spriteRight, 300);
			
			moveLeftUp = new Animation(spriteUp,300);
			moveLeftDown = new Animation(spriteDown,300);
			moveRightUp = new Animation(spriteUp,300);
			moveRightDown = new Animation(spriteDown,300);
			
		} catch (SlickException e) {
			System.err.println("Missing SpriteSheet");
		}
	}
	
	public void Shoot(){
		Projectile shot = new Projectile();
		
		switch(facingDirection){
			case "up":
				shot.positionX = this.positionX+4;
				shot.positionY = this.positionY-16;
				break;
			case "left":
				shot.positionX = this.positionX-16;
				shot.positionY = this.positionY+4;
				break;
			case "down":
				shot.positionX = this.positionX+4;
				shot.positionY = this.positionY+16;
				break;
			case "right":
				shot.positionX = this.positionX+16;
				shot.positionY = this.positionY+4;
				break;
				
			case "leftUp":
				shot.positionX = this.positionX-16;
				shot.positionY = this.positionY-16;
				break;
			case "leftDown":
				shot.positionX = this.positionX-16;
				shot.positionY = this.positionY+16;
				break;
			case "rightUp":
				shot.positionX = this.positionX+16;
				shot.positionY = this.positionY-16;
				break;
			case "rightDown":
				shot.positionX = this.positionX+16;
				shot.positionY = this.positionY+16;
				break;
		}
		
		shot.flyingDirection = facingDirection;
		GameManager.Projectiles.add(shot);
	}
} //EOF
