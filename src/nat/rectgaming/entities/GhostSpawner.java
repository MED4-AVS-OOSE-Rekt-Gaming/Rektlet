package nat.rectgaming.entities;

import nat.rectgaming.Maploader;
import nat.rectgaming.GameManager;
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
		rect = new Rectangle (positionX, positionY, width, height);

		try {
			objImage = new Image("res/images/objects/ghostSpawner.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void spawner() {
		if(hp > 0) {
		//boolean canSpawn = true;
			//delay++;
			float posX = positionX;
			float posY = positionY;
			//spawns++;
			//for(int i = 0; i < Maploader.ghostSpawner.size(); i++) {
				Maploader.ghosts.add(new Ghost((int)(posX+16), (int)(posY)));
				//}
		
		
	} else if( hp < 1) {
		isStaticDead = true;
	}
	
	} 
	
	
}
