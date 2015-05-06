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
		grunts.add(new Grunt(700,300));
		Rocks.add(new rock(200,600));
		for(int i = 0; i < 800; i+= 16) {
		walls.add(new Wall(i,0));
		walls.add(new Wall(0,i));
		}
		for(int i = 800-16; i > 0; i -= 16) {
		walls.add(new Wall(i,800-16));
		walls.add(new Wall(800-16,i));
		}
		
		for(int i = 400-16; i > 32; i -= 16) {
		walls.add(new Wall(i,288));
		}
		for(int i = 768-64; i > 64; i -= 16) {
			if(i != 288 && i != 128 && i != 320 && i != 336 )
		walls.add(new Wall(i,i));
		}
		
		
		ghosts.add(new Ghost(200,300));
		for(int i = 32; i < 128; i+=32 ){
		ghostSpawner.add(new GhostSpawner(i,400));
		ghostSpawner.add(new GhostSpawner(400,i));
		}
		for(int i = 128; i > 32; i-=32 ){
		ghostSpawner.add(new GhostSpawner(i,400));
		ghostSpawner.add(new GhostSpawner(400,i));
		}
		}
		
		else if(lvl == 1 && GameState == 0) {
		grunts.clear();
		Rocks.clear();
		walls.clear();
		ghosts.clear();
		ghostSpawner.clear();
		mainPlayer.positionX = 80;
		mainPlayer.positionY = 80;
		for(int i = 0; i < 800; i+= 16) {
		walls.add(new Wall(i,0));
		walls.add(new Wall(0,i));
		}
		for(int i = 800-16; i > 0; i -= 16) {
		walls.add(new Wall(i,800-16));
		walls.add(new Wall(800-16,i));
		}
		grunts.add(new Grunt(80,80));
		Rocks.add(new rock(16,16));
		Rocks.add(new rock(32,16));
		walls.add(new Wall(64,64));
		ghosts.add(new Ghost(200,200));
		for(int i = 16*8; i < 16*16; i+=32 ){
		ghostSpawner.add(new GhostSpawner(i,16*16));
		ghostSpawner.add(new GhostSpawner(16*16,i));
		}
		for(int i = 16*16; i > 16*8; i-=32 ){
		ghostSpawner.add(new GhostSpawner(i,16*32));
		ghostSpawner.add(new GhostSpawner(16*32,i));
		}
			
		}
		
		else if(lvl == 2 && GameState == 0) {
		grunts.clear();
		Rocks.clear();
		walls.clear();
		ghosts.clear();
		ghostSpawner.clear();
		mainPlayer.positionX = 200;
		mainPlayer.positionY = 300;
		for(int i = 0; i < 800; i+= 16) {
		walls.add(new Wall(i,0));
		walls.add(new Wall(0,i));
		}
		for(int i = 800-16; i > 0; i -= 16) {
		walls.add(new Wall(i,800-16));
		walls.add(new Wall(800-16,i));
		}
		grunts.add(new Grunt(128,128));
		Rocks.add(new rock(32,32));
		Rocks.add(new rock(32,16));
		walls.add(new Wall(64,64));
		ghosts.add(new Ghost(100,100));
			
		} else if(lvl > 3 && GameState == 0) {
			GameState = 1;
			lvl = -1;
		}
		
		
	}
	
}
