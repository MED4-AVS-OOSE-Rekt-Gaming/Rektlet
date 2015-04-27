package nat.rectgaming;

import java.io.File;

//import nat.rectgaming.Window; //Missing File
//import nat.rectgaming.states.*; //Missing File
//import nat.rectgaming.states.world.*; //Missing File

import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class GameManager extends StateBasedGame {
	
	public GameManager(){
	super ("Rektlet");	
	}
	
protected int score;
protected int lives;
protected String PlayerName;
protected int pclass = 0; //Default Warrior
protected int gender = 0; //Default Male

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
}

public void PlayerFetch() {
//This function gets all the initial information given by the user and loads them up in PlayerCreator

//This is for display of character and which sprite-set should be loaded according to user choice in the menu

	public struct stats { //Rewrite to Slick2D
 /* The Play creation contains 3 overall stats AGI, STR, INT
  *  AGI Covers, Ranged Attack Damage,  Attack Speed, Movement Speed and Chance to dodge
  *  STR Covers Melee Attack Damage, HP and Chance to Block
  *  INT Covers, Magical Damage and other so called magical related things (This Stat can be removed) 
  *  */
		public int AGI = 0;
		public int STR = 0;
		public int INT = 0;
		};
 


}

public void Initialize() {
	/* Insert Functionality to begin GAME here.... 
	 * This information is general to all play sessions
	 * */
	score = 0;
	lives = 3;
	
}

public void EnemySpawner() { //Rewrite to Slick2D
	if(Initialize() == true && MapID == 1) {
	SkeletonEnemy SkeletonSpawner == true;
	SkeletonSpawner.Amount = 10; //adds 10 skeleton units and no more over course of Delay
	SkeletonSpawner.Delay = 1000; //1 second delay between spawns
	
	ZombieEnemy ZombieSpawner == true;
	ZombieSpawner.Amount = 5;
	ZombieSpawner.Delay = 5000;
	
	// This is the structure i believe we can use for the spawners. The code above is only examples
	}

}

public void EndGame() {
	/* Insert Functionality to end GAME here.... */
	// Simple code to change the scene to Menu or Game Over screen
	
	MapID = 0; //Menu Screen
}



}
