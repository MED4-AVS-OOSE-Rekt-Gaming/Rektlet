package nat.rectgaming;

import java.io.File;
import java.util.ArrayList;

import nat.rectgaming.Window;
import nat.rectgaming.entities.Player;
import nat.rectgaming.entities.Unit;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class GameManager extends BasicGame {
	
	private ArrayList<Unit> entities; 
	
	public GameManager(){
	super ("Rektlet");	
	}
	

public static void main(String[] args) {
	
	File f = new File("natives");
	if(f.exists()) System.setProperty("org.lwjgl.librarypath", f.getAbsolutePath());
	
	try {
		AppGameContainer game = new AppGameContainer(new GameManager());
	game.setDisplayMode(Window.WIDTH, Window.HEIGHT, false);
	game.start();
	} catch (SlickException e) {
		e.printStackTrace();
	}
}


@Override
public void render(GameContainer gc, Graphics g) throws SlickException {

	Resources.getImage("testMap").draw();
	
	
	entities.get(0).moveDown.draw(entities.get(0).positionX*16, entities.get(0).positionY*16);

}


@Override
public void init(GameContainer gc) throws SlickException {

	gc.setMaximumLogicUpdateInterval(60);
	gc.setTargetFrameRate(60);
	gc.setAlwaysRender(true);
	gc.setShowFPS(false);
	gc.setVSync(true);
	
	new Resources();
	
	entities = new ArrayList<Unit>();
	
	entities.add(0, new Player());
}	


@Override
public void update(GameContainer gc, int delta) throws SlickException {

	//Read player input
	Input playerInput = gc.getInput();
	if(playerInput.isKeyPressed(Input.KEY_UP)){
		System.out.println("Up was pressed!");
		entities.get(0).Move(0,-1);
		System.out.println(entities.get(0).toString());
	} if(playerInput.isKeyPressed(Input.KEY_LEFT)){
		System.out.println("Left was pressed!");
		entities.get(0).Move(-1,0);
		System.out.println(entities.get(0).toString());
		//System.out.println();
	} if(playerInput.isKeyPressed(Input.KEY_DOWN)){
		System.out.println("Down was pressed!");
		entities.get(0).Move(0,1);
		System.out.println(entities.get(0).toString());
	} if(playerInput.isKeyPressed(Input.KEY_RIGHT)){
		System.out.println("Right was pressed!");
		entities.get(0).Move(1,0);
		System.out.println(entities.get(0).toString());
	}
	
}

}
