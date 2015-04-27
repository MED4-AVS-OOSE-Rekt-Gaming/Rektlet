package nat.rectgaming.entities;

import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

public class Player extends Unit{
	
	@Override
	public String toString(){
		return "The Player, who is a "+super.toString();
	}
	
	public Player(){
		positionX = 0;
		positionY = 0;
	}
	
	@Override
	public void init() {
	
	}

	@Override
	public void update(GameContainer gc, int delta) {
		//Read player input
		Input playerInput = gc.getInput();
		if(playerInput.isKeyDown(Input.KEY_UP)){
			System.out.println("Up was pressed!");
			Move(0,-1);
		} else if(playerInput.isKeyPressed(Input.KEY_LEFT)){
			Move(-1,0);
			System.out.println();
		} else if(playerInput.isKeyPressed(Input.KEY_DOWN)){
			Move(0,1);
			
		} else if(playerInput.isKeyPressed(Input.KEY_RIGHT)){
			Move(1,0);
		}
	}
} //EOF
