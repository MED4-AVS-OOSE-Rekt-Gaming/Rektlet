class Player extends Unit{
	
	@Override
	public String toString(){
		return "The Player, who is a "+super.toString();
	}
	
	//input code should work with slick2D
	/*public void Input(){
		if (input.isKeyPressed(Input.KEY_UP)){
			Move("up");
		} else {
			if (input.isKeyPressed(Input.KEY_LEFT)){
				Move("left");
			} else { 
				if (input.isKeyPressed(Input.KEY_DOWN)){
					Move("down");
				} else { 
					if (input.isKeyPressed(Input.KEY_RIGHT)){
						Move("right");
					}
				}
			}
		}
	}*/
}//EOF