package nat.rectgaming;

import java.util.HashMap;
import java.util.Map;

import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.SpriteSheet;

public class Resources {

	private static Map<String, Image> images;


	public Resources() {
		images = new HashMap<String, Image>();
		
		try {
			images.put("lvl0", loadImage("res/images/levels/lvl0.png"));
			images.put("lvl1", loadImage("res/images/levels/lvl1.png"));
			images.put("lvl2", loadImage("res/images/levels/lvl2.png"));
		} catch (SlickException e) {
			e.printStackTrace();
		}

	}

	public static Image loadImage(String path) throws SlickException {
		return new Image(path, false, Image.FILTER_NEAREST);
	}

	public static SpriteSheet loadSprite(String path, int tw, int th)
			throws SlickException {
		return new SpriteSheet(loadImage(path), tw, th);
	}

	public static Image getImage(String getter) {
		return images.get(getter);
	}

}
