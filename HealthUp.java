public class HealthUp extends PowerUp{

	public int HealthBoost = 1;
	
	HealthUp(){
		positionX = 0;
		positionY = 0;
	}
		
	HealthUp (int startX, int startY){
		positionX = startX;
		positionY = startY;
			
		if (PickUp() == true) {
			health = health + HealthBoost;
		}	
	}
			
	public String toString(){
		return "HealthUp "+HealthBoost+" unit at position ("+positionX+","+positionY+")";
	}
}
