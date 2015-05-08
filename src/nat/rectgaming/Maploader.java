package nat.rectgaming;

import java.util.ArrayList;

import org.newdawn.slick.Music;
import org.newdawn.slick.SlickException;

import nat.rectgaming.entities.*;

public class Maploader extends GameManager {

	public static int lvl = 0;
	public static int GameState = 0;
	
	public static ArrayList<Ghost> ghosts;
	public static ArrayList<Grunt> grunts;
	public static ArrayList<staticObject> Rocks;
	public static ArrayList<staticObject> walls;
	public static ArrayList<GhostSpawner> ghostSpawner;
	public static  Player mainPlayer;
	public static Door ExitDoor;
	
	public Maploader() {
		ghosts = new ArrayList<Ghost>();
		grunts = new ArrayList<Grunt>();
		Rocks = new ArrayList<staticObject>();
		walls = new ArrayList<staticObject>();
		ghostSpawner = new ArrayList<GhostSpawner>();
		mainPlayer = new Player(0, 0, 0.06f);

		LoadMap(0,0);
		
		}//MapLoader
		
	
	public static void LoadMap(int level, int GS) {
		lvl = level;
		GameState = GS;
		if(lvl == 0 && GameState == 0) {
			try {
				musicA = new Music ("res/BGM/SongA.wav");
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			musicA.setVolume(0.5f);
			musicA.loop();
		grunts.clear();
		Rocks.clear();
		walls.clear();
		ghosts.clear();
		ghostSpawner.clear();
		mainPlayer.positionX = 16;
		mainPlayer.positionY = 16;

		for(int i = 0; i < 16*50; i+= 16) {
		walls.add(new Wall(i,0));
		walls.add(new Wall(0,i));
		}
		for(int i = 16*50-16; i > 0; i -= 16) {
		if(i != 16*47 && i != 16*48){
		walls.add(new Wall(i,16*50-16));
		}
		walls.add(new Wall(16*50-16,i));
		}

		for(int i = 16; i < 16*46; i += 64) {
		walls.add(new Wall(i+16*4,16*6));
		walls.add(new Wall(i+16*4,16*10));
		walls.add(new Wall(i+16*4,16*18));
		walls.add(new Wall(i+16*4,16*22));
		walls.add(new Wall(i+16*4,16*30));
		walls.add(new Wall(i+16*4,16*34));
		}
		for(int i = 16*48-16*3; i > 16*3; i -= 16) {
			if(i != 16*18 && i != 16*8 && i != 16*20 && i != 16*21 )
		walls.add(new Wall(i,i));
		}
		for(int i = 16; i < 16*16*48; i += 16) {
			if(i != 16*18 && i != 16*8 && i != 16*20 && i != 16*21 && i != 16*19 && i != 16*9 && i != 16*21 && i != 16*22) {
			walls.add(new Wall(16*50-i,i));
		}
		}
		
		
		ghosts.add(new Ghost(16*13,16*19, 0.03f));
		for(int i = 16*2; i < 16*8; i+=16*2 ){
		ghostSpawner.add(new GhostSpawner(i,16*25));
		ghostSpawner.add(new GhostSpawner(16*39,i+16*16));
		}
		for(int i = 128; i > 32; i-=32 ){
		ghostSpawner.add(new GhostSpawner(i+16*16,16*36));
		ghostSpawner.add(new GhostSpawner(16*27,i));
		}
		ExitDoor = new Door(0,0, true);
		ExitDoor.positionX = 16*48-16;
		ExitDoor.positionY = 16*50-16;
		}
		//level 1 end
		else if(lvl == 1 && GameState == 0) {
			musicA.stop();
			try {
				musicB = new Music ("res/BGM/SongB.wav");
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			musicB.setVolume(0.5f);
			musicB.loop();
		grunts.clear();
		Rocks.clear();
		walls.clear();
		ghosts.clear();
		ghostSpawner.clear();
		mainPlayer.positionX = 16*6;
		mainPlayer.positionY = 16*20;
		for(int i = 0; i < 16*50; i+= 16) {
		walls.add(new Wall(i,0));
		walls.add(new Wall(0,i));
		}
		for(int i = 16*50-16; i > 0; i -= 16) {
		walls.add(new Wall(i,16*50-16));
		if(i != 16*20 && i != 16*19)
		walls.add(new Wall(16*50-16,i));
		}
		
		for(int i = 16*4; i < 16*38; i+= 64) {
			Rocks.add(new rock(i+16*10, 16*4));
			Rocks.add(new rock(i+16*10, 16*8));
			Rocks.add(new rock(i+16*10, 16*12));
			Rocks.add(new rock(i+16*10, 16*16));
			Rocks.add(new rock(i+16*10, 16*20));
			Rocks.add(new rock(i+16*10, 16*24));
			Rocks.add(new rock(i+16*10, 16*28));
			Rocks.add(new rock(i+16*10, 16*32));
			Rocks.add(new rock(i+16*10, 16*36));
			Rocks.add(new rock(i+16*10, 16*40));
			Rocks.add(new rock(i+16*10, 16*44));
		}
		for (int i = 16*4; i < 16*38; i+= 32) {
			Rocks.add(new rock(i+16*10, 16*11));
			Rocks.add(new rock(i+16*10, 16*19));
			Rocks.add(new rock(i+16*10, 16*27));
			Rocks.add(new rock(i+16*10, 16*35));
			Rocks.add(new rock(i+16*10, 16*43));
		}
		for (int i = 16*4; i < 16*38; i+= 80 ) {
			Rocks.add(new rock(i+16*10, 16*5));
			Rocks.add(new rock(i+16*10, 16*21));
			Rocks.add(new rock(i+16*10, 16*37));
		}

		for(int i = 16; i < 16*48; i+=32 ){
		ghostSpawner.add(new GhostSpawner(i,16*2));
		ghostSpawner.add(new GhostSpawner(16*2,i));
		ghosts.add(new Ghost(i, 16*2, 0.03f));
		ghosts.add(new Ghost(16*2,i, 0.03f));
		}
		for(int i = 16*48; i > 16; i-=32 ){
		ghostSpawner.add(new GhostSpawner(i,16*48));
		ghosts.add(new Ghost(i,16*48, 0.03f));
		}
		ExitDoor = new Door(0,0,false);
		ExitDoor.positionX = 16*50-16;
		ExitDoor.positionY = 16*20-16;
			
		}//Level 2 end
		
		else if(lvl == 2 && GameState == 0) {
			musicB.stop();
			try {
				musicC = new Music ("res/BGM/SongC.wav");
			} catch (SlickException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			musicC.setVolume(0.5f);
			musicC.loop();
		grunts.clear();
		Rocks.clear();
		walls.clear();
		ghosts.clear();
		ghostSpawner.clear();
		mainPlayer.positionX = 16*24;
		mainPlayer.positionY = 16*10;
		for(int i = 0; i < 800; i+= 16) {
		walls.add(new Wall(i,0));
		walls.add(new Wall(0,i));
		}
		for(int i = 16*50-16; i > 0; i -= 16) {
			if(i != 16*12 && i != 16*13) {
		walls.add(new Wall(i,16*50-16));
			}
		walls.add(new Wall(16*50-16,i));
		}
		for(int i = 16; i < 16*45; i += 16*4){
		grunts.add(new Grunt(i+16*2,16*4, i+16*6, 16*4, 0.03f));
		grunts.add(new Grunt(i+16*2,16*8, i+16*6, 16*8, 0.03f));
		grunts.add(new Grunt(i+16*2,16*12, i+16*6, 16*12, 0.03f));
		grunts.add(new Grunt(i+16*2,16*16, i+16*6, 16*16, 0.03f));
		grunts.add(new Grunt(i+16*2,16*20, i+16*6, 16*20, 0.03f));
		grunts.add(new Grunt(i+16*2,16*24, i+16*6, 16*24, 0.03f));
		grunts.add(new Grunt(i+16*2,16*28, i+16*6, 16*28, 0.03f));
		grunts.add(new Grunt(i+16*2,16*32, i+16*6, 16*32, 0.03f));
		grunts.add(new Grunt(i+16*2,16*36, i+16*6, 16*36, 0.03f));
		grunts.add(new Grunt(i+16*2,16*40, i+16*6, 16*40, 0.03f));
		grunts.add(new Grunt(i+16*2,16*44, i+16*6, 16*44, 0.03f));
		grunts.add(new Grunt(i+16*2,16*48, i+16*6, 16*48, 0.03f));
		}
		for(int i = 16; i < 16*45; i += 16*4) {
		walls.add(new Wall(i+16*2,16*46));
		walls.add(new Wall(i+16*2,16*42));
		walls.add(new Wall(i+16*2,16*38));
		walls.add(new Wall(i+16*2,16*34));
		walls.add(new Wall(i+16*2,16*30));
		walls.add(new Wall(i+16*2,16*26));
		walls.add(new Wall(i+16*2,16*22));
		walls.add(new Wall(i+16*2,16*18));
		walls.add(new Wall(i+16*2,16*14));
		walls.add(new Wall(i+16*2,16*10));
		walls.add(new Wall(i+16*2,16*6));
		walls.add(new Wall(i+16*2,16*2));
		}
		for(int i = 16; i < 16*48; i+=16) {
		ghosts.add(new Ghost(i,16*2, 0.03f));
		}
		ExitDoor = new Door(0,0, true);
		ExitDoor.positionX = 16*12;
		ExitDoor.positionY = 16*50-16;
		//Level 3 end
		} else if(lvl > 2 && GameState == 0) {
			lvl = -1;
		}//Reset back to first level
		
	}//loadMap
	
}//EOF
