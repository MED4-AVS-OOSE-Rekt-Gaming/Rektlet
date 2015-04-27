import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Image;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Color;

public abstract class GameObject {
	int positionX;
	int positionY;
	
	int width;
	int height;
	
	Image sprite; //Sprite of the object
	Color color; //Color wrapper
	
	public GameObject() { //Constructor
		init();
	}
	
	public abstract void init();  //initialize method
	
	public void render(GameContainer gc, Graphics g) { //render method
		if(sprite != null) {
			sprite.draw(positionX,positionY,width,height,color);
		}
	}
	
	public abstract void update(GameContainer gc, int delta); //update method
	
	public String toString(){
		return "GameObject at position ("+positionX+","+positionY+")";
	}
	
}
