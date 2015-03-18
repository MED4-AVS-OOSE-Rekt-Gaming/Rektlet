public class DmgUp extends PowerUp{

	public int DmgBoost = 1;
	
	DmgUp(){
		positionX = 0;
		positionY = 0;
	}
	
	DmgUp(int startX, int startY){
		positionX = startX;
		positionY = startY;
			
		if (PickUp() == true) {
			damage = damage + DmgBoost;
		}	
	}
	
	public String toString(){
		return "DmgUp "+DmgBoost+" unit at position ("+positionX+","+positionY+")";
	}
}