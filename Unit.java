
public class Unit extends GameObject{
	boolean canAct;
	boolean isDead;
	public int health;
	public int damage;
	
	Unit(){
		positionX = 0;
		positionY = 0;
		isDead = false;
		canAct = true;
	}
	
	Unit(int startX, int startY){
		positionX = startX;
		positionY = startY;
		isDead = false;
		canAct = true;
	}
	
	public String toString(){
		return health+"/"+damage+" unit at position ("+positionX+","+positionY+")";
	}
	
	public void Move(String direction){
		if(canAct){
			if(true){//TBI: Test for GameObject at space
				switch (direction) {
					case "up":
						positionY=-1;
						break;
						
					case "left":
						positionX=-1;
						break;
					
					case "down":
						positionY=+1;
						break;
					
					case "right":
						positionX=+1;
						break;
				}
			} else {
				if(true){ //TBI: Is enemy?
					Attack();
				}
			}//else
		}//if(canAct) 
	}//Move()
	
	protected void Attack(){
		
	}//Attack()
	
	void Die(){
		isDead = true;
		
	}//Die()
}
