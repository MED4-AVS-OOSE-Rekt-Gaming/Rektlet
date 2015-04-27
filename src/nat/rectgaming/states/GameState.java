package nat.rectgaming.states;



import java.util.ArrayList;

import nat.rectgaming.entities.Player;
import nat.rectgaming.Resources;
import nat.rectgaming.entities.Unit;



//import nat.rectgaming.states.world.World;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class GameState extends BasicGameState {
	
	private ArrayList<Unit> entities; 
	
	@Override
	public void init(GameContainer gc, StateBasedGame s) throws SlickException {
		//System.out.println(player1);
		entities = new ArrayList<Unit>();
		
		entities.add(new Player());
		entities.get(0).init();
	}
	
	@Override
	public void render(GameContainer gc, StateBasedGame s, Graphics g) throws SlickException {
		int amount = entities.size();
		for(int i = 0; i <amount; i++ ) {
			entities.get(i).render(gc, g);
		}

	}

	@Override
	public void update(GameContainer gc, StateBasedGame s, int delta) throws SlickException {
		if(gc.getInput().isKeyPressed(Input.KEY_RETURN)){
			s.enterState(States.MENU);
			System.out.println("Escape pressed!");

		}
//		int amount = entities.size();
//		for(int i = 0; i <amount; i++ ) {
//			entities.get(i).update(gc, delta);
//		}
		entities.get(0).update(gc, delta);

		
	}

	@Override
	public int getID() {
		return States.GAME;
	}
}
