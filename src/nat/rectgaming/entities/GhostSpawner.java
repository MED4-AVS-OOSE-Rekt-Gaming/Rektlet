package nat.rectgaming.entities;

import nat.rectgaming.Maploader;
import nat.rectgaming.entities.Ghost;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class GhostSpawner extends staticObject {

	public GhostSpawner(int spawnX, int spawnY) {
		positionX = spawnX;
		positionY = spawnY;
		width = 16;
		height = 16;
		health = 3;
		rect = new Rectangle (positionX, positionY, width, height);

		try {
			objImage = new Image("res/images/objects/ghostSpawner.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}//GhostSpawner
	
	public void spawner() {
		if(health > 0) {
			float posX = positionX;
			float posY = positionY;
			Maploader.ghosts.add(new Ghost((int)(posX+16), (int)(posY),0.03f));
	} else if( health < 1) {
		isStaticDead = true;
	}
	
	} //spawner
	
}//EOF
