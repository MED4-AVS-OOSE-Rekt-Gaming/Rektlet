package nat.rectgaming.entities;


public class Player extends Unit{
	
	@Override
	public String toString(){
		return "The Player, who is a "+super.toString();
	}
	
	public Player(){
		positionX = 0;
		positionY = 0;
	}
	


	
} //EOF
