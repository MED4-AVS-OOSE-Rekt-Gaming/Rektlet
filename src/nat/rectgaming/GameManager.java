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
		
		
		for(int entity = 0; entity < entities.size(); entity++){
			Unit currEntity = entities.get(entity);
			
			switch(currEntity.facingDirection){
				case "up":
					currEntity.moveUp.draw(currEntity.positionX,currEntity.positionY);
					break;
				case "left":
					currEntity.moveLeft.draw(currEntity.positionX,currEntity.positionY);
					break;
				case "down":
					currEntity.moveDown.draw(currEntity.positionX,currEntity.positionY);
					break;
				case "right":
					currEntity.moveRight.draw(currEntity.positionX,currEntity.positionY);
					break;
			}
		}
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
		
		if(playerInput.isKeyDown(Input.KEY_UP) && playerInput.isKeyDown(Input.KEY_LEFT)){
			entities.get(0).Move("leftUp");
			System.out.println(entities.get(0).toString());
		}
		
		if(playerInput.isKeyDown(Input.KEY_UP) && playerInput.isKeyDown(Input.KEY_RIGHT)){ 
			entities.get(0).Move("rightUp");
			System.out.println(entities.get(0).toString());
		}
		
		if(playerInput.isKeyDown(Input.KEY_DOWN) && playerInput.isKeyDown(Input.KEY_LEFT)){
			entities.get(0).Move("leftDown");
			System.out.println(entities.get(0).toString());
		}
		
		if(playerInput.isKeyDown(Input.KEY_DOWN) && playerInput.isKeyDown(Input.KEY_RIGHT)){
			entities.get(0).Move("rightDown");
			System.out.println(entities.get(0).toString());
		}
		
		if(playerInput.isKeyDown(Input.KEY_UP) && (!playerInput.isKeyDown(Input.KEY_LEFT) && !playerInput.isKeyDown(Input.KEY_RIGHT) && !playerInput.isKeyDown(Input.KEY_DOWN))){
			entities.get(0).Move("up");
			System.out.println(entities.get(0).toString());
		} 
		
		if(playerInput.isKeyDown(Input.KEY_LEFT) && (!playerInput.isKeyDown(Input.KEY_UP) && !playerInput.isKeyDown(Input.KEY_RIGHT) && !playerInput.isKeyDown(Input.KEY_DOWN))){
			entities.get(0).Move("left");
			System.out.println(entities.get(0).toString());	
		}
		
		if(playerInput.isKeyDown(Input.KEY_DOWN) && (!playerInput.isKeyDown(Input.KEY_UP) && !playerInput.isKeyDown(Input.KEY_RIGHT) && !playerInput.isKeyDown(Input.KEY_LEFT))){
			entities.get(0).Move("down");
			System.out.println(entities.get(0).toString());
		} 
		
		if(playerInput.isKeyDown(Input.KEY_RIGHT) && (!playerInput.isKeyDown(Input.KEY_UP) && !playerInput.isKeyDown(Input.KEY_LEFT) && !playerInput.isKeyDown(Input.KEY_DOWN))){
			entities.get(0).Move("right");
			System.out.println(entities.get(0).toString());
		}
	}
} //EOF
