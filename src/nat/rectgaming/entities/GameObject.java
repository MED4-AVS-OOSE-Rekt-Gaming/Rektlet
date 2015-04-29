package nat.rectgaming.entities;

import org.newdawn.slick.Image;

import org.newdawn.slick.Color;

public abstract class GameObject {
	public int positionX;
	public int positionY;
	
	int width;
	int height;
	
	Image sprite; //Sprite of the object
	Color color; //Color wrapper
	
//	public GameObject() { //Constructor

//	}
	

	
	public String toString(){
		return "GameObject at position ("+positionX+","+positionY+")";
	}
	
}
