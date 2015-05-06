package nat.rectgaming;

import java.awt.geom.Point2D;
import java.io.File;
import java.util.ArrayList;

import nat.rectgaming.Window;
import nat.rectgaming.entities.Ghost;
import nat.rectgaming.entities.Grunt;
import nat.rectgaming.entities.Player;
import nat.rectgaming.entities.Projectile;
import nat.rectgaming.entities.Unit;
import nat.rectgaming.entities.rock;
import nat.rectgaming.entities.Wall;
import nat.rectgaming.entities.staticObject;
import nat.rectgaming.entities.GhostSpawner;
import nat.rectgaming.Camera;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
import org.newdawn.slick.ScalableGame;
import org.newdawn.slick.SlickException;

public class GameManager extends BasicGame {
	
	public int GameStates = 0;

	public static ArrayList<Projectile> Projectiles;
	
	//Collision Variables
	public boolean isStaticObject = false;
	public boolean pMLeft = false;
	public boolean pMRight = false;
	public boolean pMUp = false;
	public boolean pMDown = false;
	public boolean pMUpLeft = false;
	public boolean pMUpRight = false;
	public boolean pMDownLeft = false;
	public boolean pMDownRight = false;
	
	public float speed = 0.06f;
	public float ghostSpeed = 0.03f;
	public float gruntSpeed = 0.03f;
	public float cSpeed = speed + 0.0075f;
	
	public int spawns = 0;
	public int delay = 0;
	public boolean canSpawn = true;
	
	//Camera Variables
	public Camera cam = new Camera();
	public boolean posCam = false;
	
	public GameManager(){
		super ("Rektlet");	
	}
	

	public static void main(String[] args) {
		
		File f = new File("natives");
		if(f.exists()) System.setProperty("org.lwjgl.librarypath", f.getAbsolutePath());
		
		try {
			AppGameContainer game = new AppGameContainer(new ScalableGame(new GameManager(),300,300));
		game.setDisplayMode(Window.WIDTH, Window.HEIGHT, false);
		game.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	} //Main end
	
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {


		if(Maploader.GameState == 0 && Maploader.lvl == 0) {
			Resources.getImage("testMap").draw(cam.cameraX,cam.cameraY);
		} 
		
		if (Maploader.GameState == 0 && Maploader.lvl == 2) {
			Resources.getImage("testMap").draw(cam.cameraX,cam.cameraY);	
		}
		
		if(Maploader.GameState == 0 && Maploader.lvl < 5){
			for(int obj = 0; obj < Maploader.Rocks.size(); obj++) {
				staticObject currObject = Maploader.Rocks.get(obj);
				currObject.objImage.draw(cam.cameraX+currObject.positionX, cam.cameraY+currObject.positionY);
			}
			
			for(int obj = 0; obj < Maploader.walls.size(); obj++) {
				staticObject currObject = Maploader.walls.get(obj);
				currObject.objImage.draw(cam.cameraX+currObject.positionX, cam.cameraY+currObject.positionY);
			}
			
			for(int obj = 0; obj < Maploader.ghostSpawner.size(); obj++) {
				staticObject currObject = Maploader.ghostSpawner.get(obj);
				currObject.objImage.draw(cam.cameraX+currObject.positionX, cam.cameraY+currObject.positionY);
			}
			
			for(int entity = 0; entity < Maploader.grunts.size(); entity++){
				Unit currEntity = Maploader.grunts.get(entity);
				
				switch(currEntity.facingDirection){
					case "up":
						currEntity.moveUp.draw(cam.cameraX+currEntity.positionX,cam.cameraY+currEntity.positionY);
						break;
					case "left":
						currEntity.moveLeft.draw(cam.cameraX+currEntity.positionX,cam.cameraY+currEntity.positionY);
						break;
					case "down":
						currEntity.moveDown.draw(cam.cameraX+currEntity.positionX,cam.cameraY+currEntity.positionY);
						break;
					case "right":
						currEntity.moveRight.draw(cam.cameraX+currEntity.positionX,cam.cameraY+currEntity.positionY);
						break;
					case "rightUp":
						currEntity.moveRightUp.draw(cam.cameraX+currEntity.positionX,cam.cameraY+currEntity.positionY);
						break;
					case "rightDown":
						currEntity.moveRightDown.draw(cam.cameraX+currEntity.positionX,cam.cameraY+currEntity.positionY);
						break;	
					case "leftUp":
						currEntity.moveLeftUp.draw(cam.cameraX+currEntity.positionX,cam.cameraY+currEntity.positionY);
						break;	
					case "leftDown":
						currEntity.moveLeftDown.draw(cam.cameraX+currEntity.positionX,cam.cameraY+currEntity.positionY);
						break;	
				}
			}
			for(int entity = 0; entity < Maploader.ghosts.size(); entity++){
				Unit currEntity = Maploader.ghosts.get(entity);
				
				switch(currEntity.facingDirection){
					case "up":
						currEntity.moveUp.draw(cam.cameraX+currEntity.positionX,cam.cameraY+currEntity.positionY);
						break;
					case "left":
						currEntity.moveLeft.draw(cam.cameraX+currEntity.positionX,cam.cameraY+currEntity.positionY);
						break;
					case "down":
						currEntity.moveDown.draw(cam.cameraX+currEntity.positionX,cam.cameraY+currEntity.positionY);
						break;
					case "right":
						currEntity.moveRight.draw(cam.cameraX+currEntity.positionX,cam.cameraY+currEntity.positionY);
						break;
					case "rightUp":
						currEntity.moveRightUp.draw(cam.cameraX+currEntity.positionX,cam.cameraY+currEntity.positionY);
						break;
					case "rightDown":
						currEntity.moveRightDown.draw(cam.cameraX+currEntity.positionX,cam.cameraY+currEntity.positionY);
						break;	
					case "leftUp":
						currEntity.moveLeftUp.draw(cam.cameraX+currEntity.positionX,cam.cameraY+currEntity.positionY);
						break;	
					case "leftDown":
						currEntity.moveLeftDown.draw(cam.cameraX+currEntity.positionX,cam.cameraY+currEntity.positionY);
						break;	
				}
			}
			
				
			switch(Maploader.mainPlayer.facingDirection){
				case "up":
					Maploader.mainPlayer.moveUp.draw(cam.cameraX+Maploader.mainPlayer.positionX,cam.cameraY+Maploader.mainPlayer.positionY);
					break;
				case "left":
					Maploader.mainPlayer.moveLeft.draw(cam.cameraX+Maploader.mainPlayer.positionX,cam.cameraY+Maploader.mainPlayer.positionY);
					break;
				case "down":
					Maploader.mainPlayer.moveDown.draw(cam.cameraX+Maploader.mainPlayer.positionX,cam.cameraY+Maploader.mainPlayer.positionY);
					break;
				case "right":
					Maploader.mainPlayer.moveRight.draw(cam.cameraX+Maploader.mainPlayer.positionX,cam.cameraY+Maploader.mainPlayer.positionY);
					break;
				case "rightUp":
					Maploader.mainPlayer.moveRightUp.draw(cam.cameraX+Maploader.mainPlayer.positionX,cam.cameraY+Maploader.mainPlayer.positionY);
					break;
				case "rightDown":
					Maploader.mainPlayer.moveRightDown.draw(cam.cameraX+Maploader.mainPlayer.positionX,cam.cameraY+Maploader.mainPlayer.positionY);
					break;	
				case "leftUp":
					Maploader.mainPlayer.moveLeftUp.draw(cam.cameraX+Maploader.mainPlayer.positionX,cam.cameraY+Maploader.mainPlayer.positionY);
					break;	
				case "leftDown":
					Maploader.mainPlayer.moveLeftDown.draw(cam.cameraX+Maploader.mainPlayer.positionX,cam.cameraY+Maploader.mainPlayer.positionY);
					break;	
			}
			
			for(int projectile = 0; projectile < Projectiles.size(); projectile++){
				Projectiles.get(projectile).projectileAnimation.draw(cam.cameraX+Projectiles.get(projectile).positionX,cam.cameraY+Projectiles.get(projectile).positionY);
			}
		}
		
		if(Maploader.GameState == 1) {
			g.drawString("Menu", 50, 50);
			g.drawString("Press Right Shift to return to game", 50, 150);
		}
		

	
	}//Render End
	
	
	@Override
	public void init(GameContainer gc) throws SlickException {
	
		gc.setMaximumLogicUpdateInterval(60);
		//gc.setMinimumLogicUpdateInterval(30);
		gc.setTargetFrameRate(60);
		gc.setAlwaysRender(true);
		gc.setShowFPS(false);
		gc.setVSync(true);
		
		new Resources();
		new Maploader();
		

		Projectiles = new ArrayList<Projectile>();
		




		posCam = true;

	}//Init End	


	@Override
	public void update(GameContainer gc, int delta) throws SlickException {
		deadUnitCleanup();
		
		if(gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
		//	MapLoader = true;
			Maploader.LoadMap(Maploader.lvl+=1, 0);
			posCam = true;
			
		}
		

		if(posCam == true) {
			cam.cameraX = -Maploader.mainPlayer.positionX+150;
			cam.cameraY = -Maploader.mainPlayer.positionY+150; 
			posCam = false;
		}



			isStaticObject = false;

			Maploader.mainPlayer.rect.setLocation(cam.cameraX+Maploader.mainPlayer.positionX, cam.cameraY+Maploader.mainPlayer.positionY);
	

	
			for(int i = 0; i<Maploader.walls.size(); i++) {
				Maploader.walls.get(i).rect.setLocation(cam.cameraX+Maploader.walls.get(i).positionX, cam.cameraY+Maploader.walls.get(i).positionY);
			}
			
			for(int i = 0; i<Maploader.Rocks.size(); i++) {
				Maploader.Rocks.get(i).rect.setLocation(cam.cameraX+Maploader.Rocks.get(i).positionX, cam.cameraY+Maploader.Rocks.get(i).positionY);
			}

			for(int i = 0; i<Maploader.grunts.size(); i++) {
				Maploader.grunts.get(i).rect.setLocation(cam.cameraX+Maploader.grunts.get(i).positionX, cam.cameraY+Maploader.grunts.get(i).positionY);
				
				if(Maploader.grunts.get(i).rect.intersects(Maploader.mainPlayer.rect)) {
					System.out.println("hit");
				}
			}
			
			for(int i = 0; i<Maploader.ghosts.size(); i++) {
				Maploader.ghosts.get(i).rect.setLocation(cam.cameraX+Maploader.ghosts.get(i).positionX, cam.cameraY+Maploader.ghosts.get(i).positionY);
				
				if(Maploader.ghosts.get(i).rect.intersects(Maploader.mainPlayer.rect)) {
					System.out.println("hit");
				}
			}
			
			//Projectile Collision
			for(int i = 0; i<Projectiles.size(); i++) {
				Projectiles.get(i).rect.setLocation(cam.cameraX+Projectiles.get(i).positionX, cam.cameraY+Projectiles.get(i).positionY);
				boolean toBeRemoved = false;
				
				//Checks if projectile hits Grunt
				for(int j = 0; j<Maploader.grunts.size(); j++){
					if(Projectiles.get(i).rect.intersects(Maploader.grunts.get(j).rect)) {
						toBeRemoved = true;
						Maploader.grunts.get(j).health--;
					}
				}
				
				//Checks if projectile hits Ghost
				for(int j = 0; j<Maploader.ghosts.size(); j++){
					if(Projectiles.get(i).rect.intersects(Maploader.ghosts.get(j).rect)) {
						toBeRemoved = true;
						Maploader.ghosts.get(j).health--;
					}
				}
				
				//Removes projectile if it has hit something
				if(toBeRemoved)
					Projectiles.remove(i);
			}
			
			//Read player input
			if(Maploader.mainPlayer.canAct) {
				Input playerInput = gc.getInput();
				
				if(playerInput.isKeyDown(Input.KEY_W) && playerInput.isKeyDown(Input.KEY_A)){
					if(!playerCollisionTest(-1,-1)){
						Maploader.mainPlayer.Move("leftUp",speed, delta);
						cam.cameraX += speed*delta;
						cam.cameraY += speed*delta;
					}
				}
				
				else if(playerInput.isKeyDown(Input.KEY_W) && playerInput.isKeyDown(Input.KEY_D)){ 
					if(!playerCollisionTest(1,-1)){
						Maploader.mainPlayer.Move("rightUp",speed, delta);
						cam.cameraX -= speed*delta;
						cam.cameraY += speed*delta;
					}
				}
				
				else if(playerInput.isKeyDown(Input.KEY_S) && playerInput.isKeyDown(Input.KEY_A)){
					if(!playerCollisionTest(-1,1)){
						Maploader.mainPlayer.Move("leftDown",speed, delta);
						cam.cameraX += speed*delta;
						cam.cameraY -= speed*delta;
					}
				}
				
				else if(playerInput.isKeyDown(Input.KEY_S) && playerInput.isKeyDown(Input.KEY_D)){
					if(!playerCollisionTest(1,1)){
						Maploader.mainPlayer.Move("rightDown",speed, delta);
						cam.cameraX -= speed*delta;
						cam.cameraY -= speed*delta;
					}
				}
				
				else if(playerInput.isKeyDown(Input.KEY_W) && (!playerInput.isKeyDown(Input.KEY_A) && !playerInput.isKeyDown(Input.KEY_D) && !playerInput.isKeyDown(Input.KEY_S))){
					if(!playerCollisionTest(0,-1)){
						Maploader.mainPlayer.Move("up",speed, delta);
						cam.cameraY += speed*delta;
					}
				} 
				
				else if(playerInput.isKeyDown(Input.KEY_A) && (!playerInput.isKeyDown(Input.KEY_W) && !playerInput.isKeyDown(Input.KEY_D) && !playerInput.isKeyDown(Input.KEY_S))){
					if(!playerCollisionTest(-1,0)){
						Maploader.mainPlayer.Move("left",speed, delta);
						cam.cameraX += speed*delta;	
					}
				}
				
				else if(playerInput.isKeyDown(Input.KEY_S) && (!playerInput.isKeyDown(Input.KEY_W) && !playerInput.isKeyDown(Input.KEY_D) && !playerInput.isKeyDown(Input.KEY_A))){
					if(!playerCollisionTest(0,1)){
						Maploader.mainPlayer.Move("down",speed, delta);
						cam.cameraY -= speed*delta;
					} 
				}
				else if(playerInput.isKeyDown(Input.KEY_D) && (!playerInput.isKeyDown(Input.KEY_W) && !playerInput.isKeyDown(Input.KEY_A) && !playerInput.isKeyDown(Input.KEY_S))){
					if(!playerCollisionTest(1,0)){
						Maploader.mainPlayer.Move("right",speed, delta);
						cam.cameraX -= speed*delta;	
					}
				}
				
				if(playerInput.isKeyPressed(Input.KEY_SPACE)){
					Maploader.mainPlayer.Shoot();
				}
			}//Player Input End
			
			for(int projectile = 0; projectile < Projectiles.size(); projectile++){
				//Check if projectile is within bounds
				if(Projectiles.get(projectile).positionX > Maploader.mainPlayer.positionX-150 && Projectiles.get(projectile).positionX < Maploader.mainPlayer.positionX+150 && Projectiles.get(projectile).positionY > Maploader.mainPlayer.positionY-150 && Projectiles.get(projectile).positionY < Maploader.mainPlayer.positionY+150){
					Projectiles.get(projectile).Fly(delta);
				} else {
					Projectiles.remove(projectile);
				}
			}
			
			for(int entity = 0; entity < Maploader.ghosts.size(); entity++){
				Maploader.ghosts.get(entity).AI(ghostSpeed,delta);
			}
			for(int entity = 0; entity < Maploader.grunts.size(); entity++){
				Maploader.grunts.get(entity).AI(gruntSpeed,delta);
			}
			if(canSpawn == true && Maploader.lvl == 1) {
				delay++;
				if(delay > 500) {
					spawns++;
					for(int obj = 0; obj < Maploader.ghostSpawner.size(); obj++) {
						Maploader.ghostSpawner.get(obj).spawner(spawns, delay, canSpawn);
						
					}
					delay = 0;
				}
				
				if(canSpawn == true && Maploader.lvl !=1) {
					spawns = 0;
				}
			}
			//spawns++;
			
		
		//These will be updated to fit the new Maploader so they actually work as a menu
		if(gc.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
			Maploader.GameState = 1;
		}
		
		if(gc.getInput().isKeyPressed(Input.KEY_RSHIFT)) { 
			Maploader.GameState = 0;
		}
	}//Update End
	
	private void deadUnitCleanup(){
		//A function used to remove all dead units from the game
		
		//Remove Grunts
		for(int currGrunt = 0; currGrunt < Maploader.grunts.size(); currGrunt++){
			if(Maploader.grunts.get(currGrunt).isDead)
				Maploader.grunts.remove(currGrunt);
		}
		
		//Remove Ghosts
		for(int currGhost = 0; currGhost < Maploader.ghosts.size(); currGhost++){
			if(Maploader.ghosts.get(currGhost).isDead)
				Maploader.ghosts.remove(currGhost);
		}
	}
	
	private boolean playerCollisionTest(float testPosX, float testPosY){
		//A function used to determine whether the player will collide with a staticObject, were his position the same as the given arguments
		Maploader.mainPlayer.rect.setLocation(cam.cameraX+Maploader.mainPlayer.positionX+testPosX,cam.cameraY+Maploader.mainPlayer.positionY+testPosY);
		
		//Test for collision with walls
		for(int object = 0; object < Maploader.walls.size(); object++){
			if(Maploader.mainPlayer.rect.intersects(Maploader.walls.get(object).rect)){
				Maploader.mainPlayer.rect.setLocation(cam.cameraX+Maploader.mainPlayer.positionX,cam.cameraY+Maploader.mainPlayer.positionY);
				return true;
			}
		}
		
		//Test for collision with rocks
		for(int object = 0; object < Maploader.Rocks.size(); object++){
			if(Maploader.mainPlayer.rect.intersects(Maploader.Rocks.get(object).rect)){
				Maploader.mainPlayer.rect.setLocation(cam.cameraX+Maploader.mainPlayer.positionX,cam.cameraY+Maploader.mainPlayer.positionY);
				return true;
			}
		}
		
		return false;
	}
	
} //EOF
