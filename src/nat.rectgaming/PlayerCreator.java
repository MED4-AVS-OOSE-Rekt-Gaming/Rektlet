
public class PlayerCreator extends GameManager {

	//This class will contain all the code,packages and sprites necessary to create a character

	PlayerFetch character = new PlayerFetch();
	//Function to Fetch Sprite Packages out from initial/input values
	public void spriteLoader() {
		
		
	}
	
		
			if(character.pclass == 0 && character.gender == 0) {
			 //Create a Male Warrior.. refer to Male warrior sprite set and stats

			 character.stats.STR = 7;
			 character.stats.INT = 2;
			 character.stats.AGI = 5;
			 //and so on
			 
			 character.spriteSet = 0;
			//SpriteSet for Warrior 
			 }
			 if(character.pclass == 1 && character.gender == 1) {
			 //Create a Female Mage.. refer to Female mage sprite set and stats
			 
			 character.stats.STR = 2;
			 character.stats.INT = 7;
			 character.stats.AGI = 3;
			 //and so on
			 
			 character.spriteSet = 1;
			 //SpriteSet for Mage
			 }
			 if(character.pclass == 3 && character.gender == 0) {
			 //Create a Male Rogue.. refer to Male Rogue sprite set and stats
			 
			 character.stats.STR = 4;
			 character.stats.INT = 3;
			 character.stats.AGI = 7;
			 //and so on
			 
			 character.spriteSet = 2;
			 //SpriteSet for Rogue
			 }
		
	}

}
