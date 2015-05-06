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
import nat.rectgaming.Camera;

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Image;
import org.newdawn.slick.Input;
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
			AppGameContainer game = new AppGameContainer(new GameManager());
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
		if(gc.getInput().isKeyPressed(Input.KEY_ENTER)) {
		//	MapLoader = true;
			Maploader.LoadMap(Maploader.lvl+=1, 0);
			posCam = true;
			
		}


		if(posCam == true) {
			cam.cameraX = -Maploader.mainPlayer.positionX+300;
			cam.cameraY = -Maploader.mainPlayer.positionY+300; 
			posCam = false;
		}



			isStaticObject = false;

			Maploader.mainPlayer.rect.setLocation(cam.cameraX+Maploader.mainPlayer.positionX, cam.cameraY+Maploader.mainPlayer.positionY);
	

	
			for(int i = 0; i<Maploader.walls.size(); i++) {
				Maploader.walls.get(i).rect.setLocation(cam.cameraX+Maploader.walls.get(i).positionX, cam.cameraY+Maploader.walls.get(i).positionY);
				
				int a = 0;
				for(int j = 0; j<Maploader.grunts.size(); j++) {
					a=j;
				}
				if(Maploader.walls.get(i).rect.intersects(Maploader.grunts.get(a).rect)) {
					System.out.println("Grunt hit a wall");
				}
				
				if(Maploader.walls.get(i).rect.intersects(Maploader.mainPlayer.rect)) {
					System.out.println("You hit a Wall");
					isStaticObject = true;
				}
				
			}

			for(int i = 0; i<Maploader.grunts.size(); i++) {
				Maploader.grunts.get(i).rect.setLocation(cam.cameraX+Maploader.grunts.get(i).positionX, cam.cameraY+Maploader.grunts.get(i).positionY);
				
				if(Maploader.grunts.get(i).rect.intersects(Maploader.mainPlayer.rect)) {
					System.out.println("hit");
					
				}
			}
			
			for(int j = 0; j<Maploader.Rocks.size(); j++) {
				Maploader.Rocks.get(j).rect.setLocation(cam.cameraX+Maploader.Rocks.get(j).positionX, cam.cameraY+Maploader.Rocks.get(j).positionY);
				
				int a = 0;
				for(int i = 0; i<Maploader.grunts.size(); i++) {
					a=i;
				}
				if(Maploader.Rocks.get(j).rect.intersects(Maploader.grunts.get(a).rect)) {
					System.out.println("Grunt hit a rock");
				}
				if(Maploader.Rocks.get(j).rect.intersects(Maploader.mainPlayer.rect)) {
					System.out.println("You Hit a rock");
					isStaticObject = true;
				}
			}
			
			if(isStaticObject == true && Maploader.mainPlayer.facingDirection == "up") {
				pMUp = true;
	
			} else if(isStaticObject == true && Maploader.mainPlayer.facingDirection == "down") {
				pMDown = true;
	
			} else if(isStaticObject == true && Maploader.mainPlayer.facingDirection == "left") {
				pMLeft = true;
	
			} else if(isStaticObject == true && Maploader.mainPlayer.facingDirection == "right") {
				pMRight = true;
	
			} else if(isStaticObject == true && Maploader.mainPlayer.facingDirection == "leftUp") {
				pMUpLeft = true;
				
			} else if(isStaticObject == true && Maploader.mainPlayer.facingDirection == "rightUp") {
				pMUpRight = true;
				
			} else if(isStaticObject == true && Maploader.mainPlayer.facingDirection == "leftDown") {
				pMDownLeft = true;
				
			} else if(isStaticObject == true && Maploader.mainPlayer.facingDirection == "rightDown") {
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
				Maploader.mainPlayer.Move("down",cSpeed, delta);
				cam.cameraY-= cSpeed * delta;
				System.out.println("Up = "+pMUp);
				pMDown = false;
			}
			
			if(pMDown == true) {
				Maploader.mainPlayer.Move("up",cSpeed, delta);
				System.out.println("Down = "+pMDown);
				cam.cameraY+= cSpeed * delta;
				pMUp = false;
			}
			
			if(pMLeft == true) {
				Maploader.mainPlayer.Move("right",cSpeed, delta);
				System.out.println("Left = "+pMLeft);
				cam.cameraX-= cSpeed * delta;
				pMRight = false;
			}
			
			if(pMRight == true) {
				Maploader.mainPlayer.Move("left",cSpeed, delta);
				System.out.println("Right = "+pMRight);
				cam.cameraX+= cSpeed * delta;
				pMLeft = false;
			}
			
			if(pMUpLeft == true) {
				Maploader.mainPlayer.Move("rightDown",cSpeed,delta);
				cam.cameraX-= cSpeed * delta;
				cam.cameraY-= cSpeed * delta;
				pMDownRight = false;
	
			}
			
			if(pMUpRight == true) {
				Maploader.mainPlayer.Move("leftDown",cSpeed,delta);
				cam.cameraX+= cSpeed * delta;
				cam.cameraY-= cSpeed * delta;
				pMDownLeft = false;
			}
			
			if(pMDownLeft == true) {
				Maploader.mainPlayer.Move("rightUp",cSpeed,delta);
				cam.cameraX-= cSpeed * delta;
				cam.cameraY+= cSpeed * delta;
				pMUpRight = false;
				
			}
			
			if(pMDownRight == true) {
				Maploader.mainPlayer.Move("leftUp",cSpeed,delta);
				cam.cameraX+= cSpeed * delta;
				cam.cameraY+= cSpeed * delta;
				pMUpLeft = false;
			}
			
			
			//Read player input
			if(isStaticObject == false) {
				Input playerInput = gc.getInput();
				
				if(playerInput.isKeyDown(Input.KEY_W) && playerInput.isKeyDown(Input.KEY_A)){
					Maploader.mainPlayer.Move("leftUp",speed, delta);
					cam.cameraX += speed*delta;
					cam.cameraY += speed*delta;
					
					System.out.println(Maploader.mainPlayer.toString());
				}
				
				else if(playerInput.isKeyDown(Input.KEY_W) && playerInput.isKeyDown(Input.KEY_D)){ 
					Maploader.mainPlayer.Move("rightUp",speed, delta);
					cam.cameraX -= speed*delta;
					cam.cameraY += speed*delta;
					System.out.println(Maploader.mainPlayer.toString());
				}
				
				else if(playerInput.isKeyDown(Input.KEY_S) && playerInput.isKeyDown(Input.KEY_A)){
					Maploader.mainPlayer.Move("leftDown",speed, delta);
					cam.cameraX += speed*delta;
					cam.cameraY -= speed*delta;
					System.out.println(Maploader.mainPlayer.toString());
				}
				
				else if(playerInput.isKeyDown(Input.KEY_S) && playerInput.isKeyDown(Input.KEY_D)){
					Maploader.mainPlayer.Move("rightDown",speed, delta);
					cam.cameraX -= speed*delta;
					cam.cameraY -= speed*delta;
					System.out.println(Maploader.mainPlayer.toString());
				}
				
				else if(playerInput.isKeyDown(Input.KEY_W) && (!playerInput.isKeyDown(Input.KEY_A) && !playerInput.isKeyDown(Input.KEY_D) && !playerInput.isKeyDown(Input.KEY_S))){
					Maploader.mainPlayer.Move("up",speed, delta);
					cam.cameraY += speed*delta;
					System.out.println(Maploader.mainPlayer.toString());
				} 
				
				else if(playerInput.isKeyDown(Input.KEY_A) && (!playerInput.isKeyDown(Input.KEY_W) && !playerInput.isKeyDown(Input.KEY_D) && !playerInput.isKeyDown(Input.KEY_S))){
					Maploader.mainPlayer.Move("left",speed, delta);
					cam.cameraX += speed*delta;
					System.out.println(Maploader.mainPlayer.toString());	
				}
				
				else if(playerInput.isKeyDown(Input.KEY_S) && (!playerInput.isKeyDown(Input.KEY_W) && !playerInput.isKeyDown(Input.KEY_D) && !playerInput.isKeyDown(Input.KEY_A))){
					Maploader.mainPlayer.Move("down",speed, delta);
					cam.cameraY -= speed*delta;
					System.out.println(Maploader.mainPlayer.toString());
				} 
				
				else if(playerInput.isKeyDown(Input.KEY_D) && (!playerInput.isKeyDown(Input.KEY_W) && !playerInput.isKeyDown(Input.KEY_A) && !playerInput.isKeyDown(Input.KEY_S))){
					Maploader.mainPlayer.Move("right",speed, delta);
					cam.cameraX -= speed*delta;
					System.out.println(Maploader.mainPlayer.toString());
				}
				
				if(playerInput.isKeyPressed(Input.KEY_SPACE)){
					Maploader.mainPlayer.Shoot();
				}
			}//Player Input End
			
			for(int projectile = 0; projectile < Projectiles.size(); projectile++){
				//Check if projectile is within bounds
				if(Projectiles.get(projectile).positionX > Maploader.mainPlayer.positionX-Window.WIDTH/2 && Projectiles.get(projectile).positionX < Maploader.mainPlayer.positionX+Window.WIDTH/2 && Projectiles.get(projectile).positionY > Maploader.mainPlayer.positionY-Window.HEIGHT/2 && Projectiles.get(projectile).positionY < Maploader.mainPlayer.positionY+Window.HEIGHT/2){
					Projectiles.get(projectile).Fly(delta);
					System.out.println(Projectiles.get(projectile));
				} else {
					Projectiles.get(projectile).Die();
					Projectiles.remove(projectile);
				}
			}
			
			for(int entity = 0; entity < Maploader.ghosts.size(); entity++){
				Maploader.ghosts.get(entity).AI(ghostSpeed,delta);
			}
			
			for(int entity = 0; entity < Maploader.grunts.size(); entity++){
				Maploader.grunts.get(entity).AI(gruntSpeed,delta);
			}
		
		//These will be updated to fit the new Maploader so they actually work as a menu
		if(gc.getInput().isKeyPressed(Input.KEY_ESCAPE)) {
			Maploader.GameState = 1;
		}
		if(gc.getInput().isKeyPressed(Input.KEY_RSHIFT)) { 
			Maploader.GameState = 0;
		}
	}//Update End
} //EOF
