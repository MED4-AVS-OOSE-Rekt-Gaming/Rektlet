package nat.rectgaming;

import java.io.File;

import nat.rectgaming.Window;
import nat.rectgaming.states.*;
import nat.rectgaming.states.world.*;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class GameManager extends StateBasedGame {
	
	public GameManager(){
		super ("Rektlet");	
	}

	public static void main(String[] args) {
		
		File f = new File("natives");
		if(f.exists()) System.setProperty("org.lwjgl.librarypath", f.getAbsolutePath());
		
		try {
			AppGameContainer game = new AppGameContainer(new GameManager());
		game.setDisplayMode(Window.WIDTH, Window.HEIGHT, false); //Missing Window
		game.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
		
	}
	
	@Override
	public void initStatesList(GameContainer gc) throws SlickException {
		gc.setMaximumLogicUpdateInterval(60);
		gc.setTargetFrameRate(60);
		gc.setAlwaysRender(true);
		gc.setShowFPS(false);
		gc.setVSync(true);
		
		new Resources();
		
		this.addState(new MenuState());
		this.addState(new GameState());
	}
} //EOF
