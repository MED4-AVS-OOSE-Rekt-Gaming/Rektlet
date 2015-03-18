
public class GameManager {
protected int score;
protected int lives;
protected String PlayerName;


public void PlayerFetch() {
//This function gets all the initial information given by the user and loads them up

//This is for display of character and which sprite-set should be loaded according to user choice in the menu

//Warrior choice - Male

 PlayerCreation test = new PlayerCreation();
 
 if(test.class == 1 && test.gender == 0) {
 //Create a Male Warrior.. refer to Male warrior sprite set and stats
 
 test.stats.STR = 7;
 test.stats.INT = 2;
 //and so on
 
 test.spriteSet = 1;
//SpriteSet for Warrior 
 }
 if(test.class == 2 && test.gender == 1) {
 //Create a Female Mage.. refer to Female mage sprite set and stats
 
 test.stats.STR = 2;
 test.stats.INT = 7;
 //and so on
 
 test.spriteSet = 2;
 //SpriteSet for Mage
 }

}

public void Initialize() {
	/* Insert Functionality to begin GAME here.... */
	score = 0;
	lives = 3;
	
}

public void EnemySpawner() {
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
}



}
