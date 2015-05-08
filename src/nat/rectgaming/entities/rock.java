package nat.rectgaming.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class rock extends staticObject {

	public rock(int spawnX, int spawnY) {
		positionX = spawnX;
		positionY = spawnY;
		width = 16;
		height = 16;
		rect = new Rectangle (positionX, positionY, width, height);
		
		try {

			objImage = new Image("res/images/objects/rock.png");

		} catch (SlickException e) {

		}
	}//rock
	
}//EOF
