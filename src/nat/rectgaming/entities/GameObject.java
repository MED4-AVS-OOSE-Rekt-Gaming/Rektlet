package nat.rectgaming.entities;

public abstract class GameObject {
	public int positionX;
	public int positionY;
	
	int width;
	int height;
	
    public GameObject() { //Constructor

	}
	
	public String toString(){
		return "GameObject at position ("+positionX+","+positionY+")";
	}
	
}
