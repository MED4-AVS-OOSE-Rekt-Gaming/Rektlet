package nat.rectgaming.entities;

public class Grunt extends Unit {

	@Override
	public String toString(){
		return "The Grunt, who is a "+super.toString();
	}
	
	public Grunt(int spawnX, int spawnY){
		positionX = spawnX;
		positionY = spawnY;
		
		health = 3;
		damage = 1;
		isDead = false;
		canAct = true;
	}
	
	
}//EOF
