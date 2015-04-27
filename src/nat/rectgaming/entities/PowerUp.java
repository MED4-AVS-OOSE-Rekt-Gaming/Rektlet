package nat.rectgaming.entities;

public class PowerUp extends GameObject {
	
	PowerUp(){
	}
	
	PowerUp(int x, int y){
		positionX = x;
		positionY = y;
	}
	
	public boolean PickUp(){
		if (this.positionX == player.positionX && this.positionY == player.positionY && isPlayer == true) {		
			return true;		
		} else{	
			return false;	
		}
	}
	
	public String toString(){
		return "PowerUp at position ("+positionX+","+positionY+")";
	}
}
