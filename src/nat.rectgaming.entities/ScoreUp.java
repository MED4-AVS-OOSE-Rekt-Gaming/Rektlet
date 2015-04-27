
public class ScoreUp extends PowerUp{

	public int ScoreBoost = 1;
	
	ScoreUp(){
		positionX = 0;
		positionY = 0;
	}
	
	ScoreUp(int startX, int startY){
		positionX = startX;
		positionY = startY;
			
		if (PickUp() == true) {
			GameManager.score = GameManager.score + ScoreBoost;
		}	
	}
	
	public String toString(){
		return "ScoreUp "+ScoreBoost+" unit at position ("+positionX+","+positionY+")";
	}
}
}
