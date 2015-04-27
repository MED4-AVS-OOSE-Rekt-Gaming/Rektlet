public abstract class Unit extends GameObject{
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
	
	@Override
	public String toString(){
		return health+"/"+damage+" Unit, a "+super.toString();
	}
	
	public void Move(int directionX, int directionY){
		if(canAct){
			if(true){//TBI: Test for GameObject at space
				positionX += directionX;
				positionY += directionY;
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
