package nat.rectgaming;

import java.io.File;
import java.util.ArrayList;

import nat.rectgaming.Window;
import nat.rectgaming.entities.Ghost;
import nat.rectgaming.entities.Grunt;
import nat.rectgaming.entities.Player;
import nat.rectgaming.entities.Unit;
import nat.rectgaming.entities.rock;
import nat.rectgaming.entities.staticObject;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;

public class GameManager extends BasicGame {
	
	public int GameStates = 0;
	public ArrayList<Unit> entities; 
	public static Player mainPlayer;
	public ArrayList<staticObject> objects;
	
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
		//Resources.getImage("rock").draw();
		
		if(GameStates == 0) {
		
			for(int obj = 0; obj < objects.size(); obj++) {
				staticObject currObject = objects.get(obj);
				currObject.objImage.draw(currObject.positionX, currObject.positionY);
			}
				
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
					case "leftUp":
						currEntity.moveLeftUp.draw(currEntity.positionX,currEntity.positionY);
						break;
					case "leftDown":
						currEntity.moveLeftDown.draw(currEntity.positionX,currEntity.positionY);
						break;
					case "rightUp":
						currEntity.moveRightUp.draw(currEntity.positionX,currEntity.positionY);
						break;
					case "rightDown":
						currEntity.moveRightDown.draw(currEntity.positionX,currEntity.positionY);
						break;
				}
			}
		}
		if(GameStates == 1) {
			g.drawString("Menu", 50, 50);
			g.drawString("Press Right Shift to return to game", 50, 150);
			
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
		objects = new ArrayList<staticObject>();
		
		entities.add(0, mainPlayer = new Player());
		entities.add(new Grunt(32,32));
		entities.add(new Ghost(200,200));
		objects.add(0, new rock(54,54));
	}	


	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		if(GameStates == 0) {
			
			entities.get(0).rect.setLocation(entities.get(0).positionX, entities.get(0).positionY);
			
			entities.get(1).rect.setLocation(entities.get(1).positionX, entities.get(1).positionY);
			
			objects.get(0).rect.setLocation(objects.get(0).positionX, objects.get(0).positionY);
			
			if(entities.get(0).rect.intersects(entities.get(1).rect)) {
				System.out.println("Hit");
			}
			
			if(entities.get(0).rect.intersects(objects.get(0).rect)) {
				System.out.println("Inpassable terrain");
			}
			
			//Read player input
			Input playerInput = gc.getInput();
			
			if(playerInput.isKeyDown(Input.KEY_UP) && playerInput.isKeyDown(Input.KEY_LEFT)){
				entities.get(0).Move("leftUp");
			}
			
			if(playerInput.isKeyDown(Input.KEY_UP) && playerInput.isKeyDown(Input.KEY_RIGHT)){ 
				entities.get(0).Move("rightUp");
			}
			
			if(playerInput.isKeyDown(Input.KEY_DOWN) && playerInput.isKeyDown(Input.KEY_LEFT)){
				entities.get(0).Move("leftDown");
			}
			
			if(playerInput.isKeyDown(Input.KEY_DOWN) && playerInput.isKeyDown(Input.KEY_RIGHT)){
				entities.get(0).Move("rightDown");
			}
			
			if(playerInput.isKeyDown(Input.KEY_UP) && (!playerInput.isKeyDown(Input.KEY_LEFT) && !playerInput.isKeyDown(Input.KEY_RIGHT) && !playerInput.isKeyDown(Input.KEY_DOWN))){
				entities.get(0).Move("up");
			} 
			
			if(playerInput.isKeyDown(Input.KEY_LEFT) && (!playerInput.isKeyDown(Input.KEY_UP) && !playerInput.isKeyDown(Input.KEY_RIGHT) && !playerInput.isKeyDown(Input.KEY_DOWN))){
				entities.get(0).Move("left");
			}
			
			if(playerInput.isKeyDown(Input.KEY_DOWN) && (!playerInput.isKeyDown(Input.KEY_UP) && !playerInput.isKeyDown(Input.KEY_RIGHT) && !playerInput.isKeyDown(Input.KEY_LEFT))){
				entities.get(0).Move("down");
			} 
			
			if(playerInput.isKeyDown(Input.KEY_RIGHT) && (!playerInput.isKeyDown(Input.KEY_UP) && !playerInput.isKeyDown(Input.KEY_LEFT) && !playerInput.isKeyDown(Input.KEY_DOWN))){
				entities.get(0).Move("right");
			}
		}
		
		for(int entity = 1; entity < entities.size(); entity++){
			entities.get(entity).AI();
		}
		
		if(gc.getInput().isKeyPressed(Input.KEY_RETURN)) {
			GameStates = 1;
		}
		if(gc.getInput().isKeyPressed(Input.KEY_RSHIFT)) {
			GameStates = 0;
		}
	}
} //EOF
