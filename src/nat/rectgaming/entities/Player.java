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
	Move(10,10);
	}

	@Override
	public void update(GameContainer gc, int delta) {
		//Read player input
		Input playerInput = gc.getInput();
		if(playerInput.isKeyPressed(Input.KEY_UP)){
			System.out.println("Up was pressed!");
			Move(0,-1);
			System.out.println(super.toString());
		} if(playerInput.isKeyPressed(Input.KEY_LEFT)){
			System.out.println("Left was pressed!");
			Move(-1,0);
			//System.out.println();
		} if(playerInput.isKeyPressed(Input.KEY_DOWN)){
			System.out.println("Down was pressed!");
			Move(0,1);
			
		} if(playerInput.isKeyPressed(Input.KEY_RIGHT)){
			System.out.println("Right was pressed!");
			Move(1,0);
		}
	}
	

	
} //EOF
