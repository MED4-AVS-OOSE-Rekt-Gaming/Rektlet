package nat.rectgaming.entities;

import nat.rectgaming.Maploader;
import nat.rectgaming.GameManager;
import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class GhostSpawner extends staticObject {

//	public static boolean canSpawn;
	public static int spawns;
	public static int delay;
	public GhostSpawner(int spawnX, int spawnY) {
		positionX = spawnX;
		positionY = spawnY;
		width = 16;
		height = 16;
		rect = new Rectangle (positionX, positionY, width, height);
//		canSpawn = false;
		spawner(0,0,false);
		try {
			objImage = new Image("res/images/objects/ghostSpawner.png");
		} catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void spawner (int sp, int del , boolean canSp) {
		//boolean canSpawn = true;
			//delay++;
		if(canSp == true && sp < 4) {
			//spawns++;
			for(int i = 0; i < Maploader.ghostSpawner.size(); i++) {
				float spawnPosX = Maploader.ghostSpawner.get(i).positionX+16;
				float spawnPosY = Maploader.ghostSpawner.get(i).positionY+0;
				Maploader.ghosts.add(new Ghost((int)(spawnPosX), (int)(spawnPosY)));
			
				}

		}		
		
	}
	
	
}
