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
	public ArrayList<Unit> Grunts;
	public ArrayList<Unit> Ghosts;
	public static Player mainPlayer;
	public ArrayList<staticObject> rocks;
	public ArrayList<staticObject> trees;
	
	//Collision Test Booleans
	public boolean isStaticObject = false;
	public boolean pMLeft = false;
	public boolean pMRight = false;
	public boolean pMUp = false;
	public boolean pMDown = false;
	public boolean pMUpLeft = false;
	public boolean pMUpRight = false;
	public boolean pMDownLeft = false;
	public boolean pMDownRight = false;
	public float speed = 0.1f;
	public float cSpeed = speed + 0.075f;
	
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
		
		for(int obj = 0; obj < rocks.size(); obj++) {
			staticObject currObject = rocks.get(obj);
			currObject.objImage.draw(currObject.positionX, currObject.positionY);
		}
			
		for(int entity = 0; entity < Grunts.size(); entity++){
			Unit currEntity = Grunts.get(entity);
			
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
				case "rightUp":
					currEntity.moveRightUp.draw(currEntity.positionX,currEntity.positionY);
					break;
				case "rightDown":
					currEntity.moveRightDown.draw(currEntity.positionX,currEntity.positionY);
					break;	
				case "leftUp":
					currEntity.moveLeftUp.draw(currEntity.positionX,currEntity.positionY);
					break;	
				case "leftDown":
					currEntity.moveLeftDown.draw(currEntity.positionX,currEntity.positionY);
					break;	
			}
		}
		for(int entity = 0; entity < Ghosts.size(); entity++){
			Unit currEntity = Ghosts.get(entity);
			
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
				case "rightUp":
					currEntity.moveRightUp.draw(currEntity.positionX,currEntity.positionY);
					break;
				case "rightDown":
					currEntity.moveRightDown.draw(currEntity.positionX,currEntity.positionY);
					break;	
				case "leftUp":
					currEntity.moveLeftUp.draw(currEntity.positionX,currEntity.positionY);
					break;	
				case "leftDown":
					currEntity.moveLeftDown.draw(currEntity.positionX,currEntity.positionY);
					break;	
			}
		}
		
			
			switch(mainPlayer.facingDirection){
				case "up":
					mainPlayer.moveUp.draw(mainPlayer.positionX,mainPlayer.positionY);
					break;
				case "left":
					mainPlayer.moveLeft.draw(mainPlayer.positionX,mainPlayer.positionY);
					break;
				case "down":
					mainPlayer.moveDown.draw(mainPlayer.positionX,mainPlayer.positionY);
					break;
				case "right":
					mainPlayer.moveRight.draw(mainPlayer.positionX,mainPlayer.positionY);
					break;
				case "rightUp":
					mainPlayer.moveRightUp.draw(mainPlayer.positionX,mainPlayer.positionY);
					break;
				case "rightDown":
					mainPlayer.moveRightDown.draw(mainPlayer.positionX,mainPlayer.positionY);
					break;	
				case "leftUp":
					mainPlayer.moveLeftUp.draw(mainPlayer.positionX,mainPlayer.positionY);
					break;	
				case "leftDown":
					mainPlayer.moveLeftDown.draw(mainPlayer.positionX,mainPlayer.positionY);
					break;	
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
		gc.setShowFPS(true);
		gc.setVSync(true);
		
		new Resources();
		
		Grunts = new ArrayList<Unit>();
		Ghosts = new ArrayList<Unit>();
		rocks = new ArrayList<staticObject>();
		
		
		mainPlayer = new Player(5,5);
		Grunts.add(0, new Grunt(32,32));
		Ghosts.add(0, new Ghost(200,200));
		rocks.add(0, new rock(54,54));
	}	


	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
	if(GameStates == 0) {
		isStaticObject = false;
		mainPlayer.rect.setLocation(mainPlayer.positionX, mainPlayer.positionY);
		
		//entities.get(1).rect.setLocation(entities.get(1).positionX, entities.get(1).positionY);
		
		
		rocks.get(0).rect.setLocation(rocks.get(0).positionX, rocks.get(0).positionY);
		
		for(int i = 1; i<Grunts.size(); i++) {
			Grunts.get(i).rect.setLocation(Grunts.get(i).positionX, Grunts.get(i).positionY);
			
			if(Grunts.get(i).rect.intersects(mainPlayer.rect)) {
				System.out.println("hit");
				
			}
		}
		
		for(int j = 0; j<rocks.size(); j++) {
			rocks.get(j).rect.setLocation(rocks.get(j).positionX, rocks.get(j).positionY);
			
			int a = 0;
			for(int i = 0; i<Grunts.size(); i++) {
				a=i;
			}
			if(rocks.get(j).rect.intersects(Grunts.get(a).rect)) {
				System.out.println("Grunt hit an inpassable object");
			}
			if(rocks.get(j).rect.intersects(mainPlayer.rect)) {
				System.out.println("You Hit an inpassable object");
				isStaticObject = true;
			}
		}
		
		if(isStaticObject == true && mainPlayer.facingDirection == "up") {
			pMUp = true;

		} else if(isStaticObject == true && mainPlayer.facingDirection == "down") {
			pMDown = true;

		} else if(isStaticObject == true && mainPlayer.facingDirection == "left") {
			pMLeft = true;

		} else if(isStaticObject == true && mainPlayer.facingDirection == "right") {
			pMRight = true;

		} else if(isStaticObject == true && mainPlayer.facingDirection == "leftUp") {
			pMUpLeft = true;
			
		} else if(isStaticObject == true && mainPlayer.facingDirection == "rightUp") {
			pMUpRight = true;
			
		} else if(isStaticObject == true && mainPlayer.facingDirection == "leftDown") {
			pMDownLeft = true;
			
		} else if(isStaticObject == true && mainPlayer.facingDirection == "rightDown") {
			pMDownRight = true;
			
		}
		
		else {
			isStaticObject = false;
			pMUp = false;
			pMDown = false;
			pMRight = false;
			pMLeft = false;
			pMUpLeft = false;
			pMUpRight = false;
			pMDownRight = false;
			pMDownLeft = false;
		}
		
		if(pMUp == true) {
			mainPlayer.Move("down",cSpeed, delta);
			System.out.println("Up = "+pMUp);
			pMDown = false;
		}
		
		if(pMDown == true) {
			mainPlayer.Move("up",cSpeed, delta);
			System.out.println("Down = "+pMDown);
			pMUp = false;
		}
		
		if(pMLeft == true) {
			mainPlayer.Move("right",cSpeed, delta);
			System.out.println("Left = "+pMLeft);
			pMRight = false;
		}
		
		if(pMRight == true) {
			mainPlayer.Move("left",cSpeed, delta);
			System.out.println("Right = "+pMRight);
			pMLeft = false;
		}
		
		if(pMUpLeft == true) {
			mainPlayer.Move("rightDown",cSpeed,delta);
			pMDownRight = false;
		}
		
		if(pMUpRight == true) {
			mainPlayer.Move("leftDown",cSpeed,delta);
			pMDownLeft = false;
		}
		
		if(pMDownLeft == true) {
			mainPlayer.Move("rightUp",cSpeed,delta);
			pMUpRight = false;
			
		}
		
		if(pMDownRight == true) {
			mainPlayer.Move("leftUp",cSpeed,delta);
			pMUpLeft = false;
			
		}
		/*if(entities.get(0).rect.intersects(entities.get(1).rect)) {
			System.out.println("Hit");
		}
		*/
		/*if(entities.get(0).rect.intersects(objects.get(0).rect)) {
			System.out.println("Inpassable terrain");
		}*/
		//Gonna Rewrite this section to allow booleans to trigger toggle movement on/off during collision and Attack!
		//Read player input
		if(isStaticObject == false) {
		Input playerInput = gc.getInput();
		
		if(playerInput.isKeyDown(Input.KEY_W) && playerInput.isKeyDown(Input.KEY_A)){
			mainPlayer.Move("leftUp",speed, delta);
			System.out.println(mainPlayer.toString());
		}
		
		else if(playerInput.isKeyDown(Input.KEY_W) && playerInput.isKeyDown(Input.KEY_D)){ 
			mainPlayer.Move("rightUp",speed, delta);
			System.out.println(mainPlayer.toString());
		}
		
		else if(playerInput.isKeyDown(Input.KEY_S) && playerInput.isKeyDown(Input.KEY_A)){
			mainPlayer.Move("leftDown",speed, delta);
			System.out.println(mainPlayer.toString());
		}
		
		else if(playerInput.isKeyDown(Input.KEY_S) && playerInput.isKeyDown(Input.KEY_D)){
			mainPlayer.Move("rightDown",speed, delta);
			System.out.println(mainPlayer.toString());
		}
		
		else if(playerInput.isKeyDown(Input.KEY_W) && (!playerInput.isKeyDown(Input.KEY_A) && !playerInput.isKeyDown(Input.KEY_D) && !playerInput.isKeyDown(Input.KEY_S))){
			mainPlayer.Move("up",speed, delta);
			System.out.println(mainPlayer.toString());
		} 
		
		else if(playerInput.isKeyDown(Input.KEY_A) && (!playerInput.isKeyDown(Input.KEY_W) && !playerInput.isKeyDown(Input.KEY_D) && !playerInput.isKeyDown(Input.KEY_S))){
			mainPlayer.Move("left",speed, delta);
			System.out.println(mainPlayer.toString());	
		}
		
		else if(playerInput.isKeyDown(Input.KEY_S) && (!playerInput.isKeyDown(Input.KEY_W) && !playerInput.isKeyDown(Input.KEY_D) && !playerInput.isKeyDown(Input.KEY_A))){
			mainPlayer.Move("down",speed, delta);
			System.out.println(mainPlayer.toString());
		} 
		
		else if(playerInput.isKeyDown(Input.KEY_D) && (!playerInput.isKeyDown(Input.KEY_W) && !playerInput.isKeyDown(Input.KEY_A) && !playerInput.isKeyDown(Input.KEY_S))){
			mainPlayer.Move("right",speed, delta);
			System.out.println(mainPlayer.toString());
		}
		}
	}
	
	for(int entity = 0; entity < Ghosts.size(); entity++){
		Ghosts.get(entity).AI(speed,delta);
	}
	
	
	if(gc.getInput().isKeyPressed(Input.KEY_RETURN)) {
		GameStates = 1;
	}
	if(gc.getInput().isKeyPressed(Input.KEY_RSHIFT)) {
		GameStates = 0;
	}
	}
} //EOF
