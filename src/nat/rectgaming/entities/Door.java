package nat.rectgaming.entities;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.geom.Rectangle;

public class Door extends staticObject {
public boolean isW = false;
public boolean isH = false;
public boolean isOpen = false;
	
	public Door(int spawnX, int spawnY, boolean WORH) {

		positionX = spawnX;
		positionY = spawnY;
		health = 2;
		if(WORH == true) {
			isW = true;
			isH = false;
		} else if (WORH == false) {
			isH = true;
			isW = false;
		}

		if(isW == true) {
			width = 32;
			height = 16;
			try {
				objImage = new Image("res/images/objects/doorClosedW.png");
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	
		}//if end
		if(health > 0 && isH == true) {
			width = 16;
			height = 32;

			try {
				objImage = new Image("res/images/objects/doorClosedH.png");
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} //if end
		rect = new Rectangle (positionX, positionY, width, height);
	}//Door
	
	
	public void CheckIfOpen(boolean open) {
		
		if(open == true && isW == true) {
			try {
				objImage = new Image("res/images/objects/doorOpenW.png");
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			isOpen = true;
		}//if end
		
		if(open == true && isH == true) {
			try {
				objImage = new Image("res/images/objects/doorOpenH.png");
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			isOpen = true;
		}//if end
		
	}//CheckIfOpen end
}//EOF
