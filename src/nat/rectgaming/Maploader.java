package nat.rectgaming;

import java.util.ArrayList;



import nat.rectgaming.entities.*;

public class Maploader extends GameManager {

	public static int lvl = 0;
	public static int GameState = 0;
	
	public static ArrayList<Unit> ghosts;
	public static ArrayList<Unit> grunts;
	public static ArrayList<staticObject> Rocks;
	public static ArrayList<staticObject> walls;
	public static ArrayList<staticObject> ghostSpawner;
	public static  Player mainPlayer;

	
	public Maploader() {
		ghosts = new ArrayList<Unit>();
		grunts = new ArrayList<Unit>();
		Rocks = new ArrayList<staticObject>();
		walls = new ArrayList<staticObject>();
		ghostSpawner = new ArrayList<staticObject>();
		mainPlayer = new Player(0, 0);
		LoadMap(0,0);
		
		
	//	System.out.println(ghosts.size());
		//LoadMap(0);
		}
		
	
	public static void LoadMap(int level, int GS) {
		lvl = level;
		GameState = GS;
		
		
		if(lvl == 0 && GameState == 0) {
		grunts.clear();
		Rocks.clear();
		walls.clear();
		ghosts.clear();
		ghostSpawner.clear();
		mainPlayer.positionX = 16;
		mainPlayer.positionY = 16;
		grunts.add(new Grunt(32,32));
		Rocks.add(new rock(64,64));
		walls.add(new Wall(0,0));
		ghosts.add(new Ghost(200,300));
		}
		
		else if(lvl == 1 && GameState == 0) {
		grunts.clear();
		Rocks.clear();
		walls.clear();
		ghosts.clear();
		ghostSpawner.clear();
		mainPlayer.positionX = 80;
		mainPlayer.positionY = 80;
		grunts.add(new Grunt(80,80));
		Rocks.add(new rock(16,16));
		Rocks.add(new rock(32,16));
		walls.add(new Wall(64,64));
		ghosts.add(new Ghost(200,200));
		ghostSpawner.add(new GhostSpawner(100,100));
			
		}
		
		else if(lvl == 2 && GameState == 0) {
		grunts.clear();
		Rocks.clear();
		walls.clear();
		ghosts.clear();
		ghostSpawner.clear();
		mainPlayer.positionX = 200;
		mainPlayer.positionY = 300;
		grunts.add(new Grunt(128,128));
		Rocks.add(new rock(32,32));
		Rocks.add(new rock(32,16));
		walls.add(new Wall(64,64));
		ghosts.add(new Ghost(100,100));
			
		} else if(lvl > 5 && GameState == 0) {
			GameState = 1;
			lvl = -1;
		}
		
		
	}
	
}
