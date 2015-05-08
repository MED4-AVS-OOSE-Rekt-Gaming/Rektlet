package nat.rectgaming.entities;

import org.newdawn.slick.Animation;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;
import org.newdawn.slick.geom.Rectangle;
import org.newdawn.slick.geom.Shape;

public class Projectile extends GameObject {
	String flyingDirection;
	SpriteSheet ProjectileSprites;
	public Animation projectileAnimation;
	
	public float projectileSpeed;
	public Shape rect;
	
	@Override
	public String toString(){
		return "A projectile flying "+flyingDirection+", which is a "+super.toString();
	}
	
	public Projectile(){
		projectileSpeed = 0.2f;
		rect = new Rectangle(positionX,positionY,8,8);
		try {
			projectileAnimation = new Animation(new SpriteSheet(new Image("res/images/units/babarian/playerProjectile.png"),8,8),150);
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}//Projectile
	
	public void Fly(int delta){
		switch(flyingDirection){
			case "up":
				positionY -= projectileSpeed * delta;
				break;
			case "left":
				positionX -= projectileSpeed * delta;
				break;
			case "down":
				positionY += projectileSpeed * delta;
				break;
			case "right":
				positionX += projectileSpeed * delta;
				break;
			
			case "leftUp":
				positionX -= projectileSpeed * delta;
				positionY -= projectileSpeed * delta;
				break;
			case "leftDown":
				positionX -= projectileSpeed * delta;
				positionY += projectileSpeed * delta;
				break;
			case "rightUp":
				positionX += projectileSpeed * delta;
				positionY -= projectileSpeed * delta;
				break;
			case "rightDown":
				positionX += projectileSpeed * delta;
				positionY += projectileSpeed * delta;
				break;
		}
	}//Fly()
}//EOF
