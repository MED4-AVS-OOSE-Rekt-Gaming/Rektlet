import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Input;

class Player extends Unit{
	
	@Override
	public String toString(){
		return "The Player, who is a "+super.toString();
	}
	
	public Player(){
		positionX = 0;
		positionY = 0;
	}
	
	public void keyPressed(int key, char c){
		switch(key){
		case Input.KEY_UP:
			Move(0,-1);
			break;
		
		case Input.KEY_LEFT:
			Move(-1, 0);
			break;
			
		case Input.KEY_DOWN:
			Move(0, 1);
			break;
		
		case Input.KEY_RIGHT:
			Move(1, 0);
			break;
		}
	}
	
	public void keyReleased(int key, char c){
		
	}
	
	@Override
	public void init() {
		// TODO Auto-generated method stub	
	}

	@Override
	public void update(GameContainer gc, int delta) {
		
	}
} //EOF
