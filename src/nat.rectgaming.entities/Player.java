import org.newdawn.slick.GameContainer;

class Player extends Unit{
	
	@Override
	public String toString(){
		return "The Player, who is a "+super.toString();
	}
	
	//Input parameters
	public void PlayerInput(){
		if (input.isKeyPressed(Input.KEY_UP)){
			Move(0, -1);
		} else {
			if (input.isKeyPressed(Input.KEY_LEFT)){
				Move(-1, 0);
			} else { 
				if (input.isKeyPressed(Input.KEY_DOWN)){
					Move(0, 1);
				} else { 
					if (input.isKeyPressed(Input.KEY_RIGHT)){
						Move(1, 0);
					}
				}
			}
		}
	}

	@Override
	public void init() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(GameContainer gc, int delta) {
		// TODO Auto-generated method stub
		
	}
} //EOF
