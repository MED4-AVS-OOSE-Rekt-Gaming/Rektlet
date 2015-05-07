package nat.rectgaming.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.geom.Shape;

public abstract class staticObject extends GameObject {

	public int hp;
	public Image objImage;
	public Shape rect;
	public boolean  isStaticDead;
	
	staticObject() {
		positionX = 0;
		positionY = 0;
		hp = 0;
	}
	public void spawner() {
		
	}
	
	void staticDie(){
		isStaticDead = true;
	}//Die
	
}
