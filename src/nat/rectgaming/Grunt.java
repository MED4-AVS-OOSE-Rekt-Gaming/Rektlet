package nat.rectgaming.entities;

public class Grunt extends Unit {

	@Override
	public String toString(){
		return "The Grunt, who is a "+super.toString();
	}
	
	public Grunt(){
		positionX = 0;
		positionY = 0;
	}
	
}//EOF
