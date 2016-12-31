import java.util.Scanner;
import java.io.*;
import java.util.Random;

public class gameClientTest{

	public static void main(String[] args){

		/*
		
		String name = "Ryan";
		String type = "Hunteas";
		String type1 = "Spider";
		String name1 = "Your mom";
		boolean heroCondition = false;
		boolean npcCondition = true;
		double hp = 14.0;
		double hp1 = 7.0;
		int[] weaponArray;
		boolean userCondition;
		
		mob hero1 = new mob(name,type,hp, heroCondition);

		mob mob1 = new mob(name1,type1,hp1, npcCondition);

		hero1.getCondition();
		mob1.getCondition();


		hero1.isDead();
		hero1.getHp();
		hero1.increaseHp(3.5);
		hero1.getHp();
		hero1.typeOffense(type);
		
		hero1.weaponDeCoder(weapon1, 01);
		hero1.useHealthPot();
		
		hero1.getHp();
		

		hero1.typeOffense(type);

		

		mob1.typeOffense(type);

		System.out.println();

		mob1.isUser(npcCondition);
		mob1.getCondition();
		mob1.isUser(heroCondition);



		hero1.weaponDeCoder(weaponArray);

		*/

		
		//===================================
		// CHARACTER CREATION
		//===================================
		Scanner in = new Scanner(System.in);

		System.out.println("THE ADVENTURE GAME!");
		System.out.println("made by ryan alston");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println("Choose your difficulty!");
		System.out.println("noob = 1, novice = 2, expert = 3");
		int difficultyLevel = in.nextInt();
		System.out.println("you chose level " +difficultyLevel);
		System.out.println("");

		System.out.println("Before you start your adventure you must create your Hero!");
		System.out.println("Every piece of data you enter into the System should follow these formating rules:\n");
		System.out.println("The first letter must be capitalized.");
		System.out.println("");

		System.out.println("To start: you must choose a name, and a character class.");
		System.out.println("The possible character classes to choose from are:\nHunter\nNinja\nWarrior");
		System.out.println("");


		System.out.println("You have chosen the path of: ");
		String characterClass = in.next();
		//System.out.print(characterClass);

		
		
		System.out.println("Now name your character: ");
		String characterName = in.next();
		System.out.println("");

		System.out.println("You have chosen to create a "+characterClass+ " named "+characterName);
		System.out.println("");


		//==============================
		// DETERMINES HP FROM CLASS
		//==============================
		double hp = 0;

		if( characterClass.equals("Hunter")){
			hp = 12.0;
		}
		if(characterClass.equals("Warrior")){
			hp = 17.0;
		}
		if(characterClass.equals("Ninja")){
			hp = 13.5;
		}
		

		//======================================
		// DETERMINES isNPC from characterClass
		//======================================

		boolean typeCondition = false; // intialzed to false for no reason

		if( characterClass.equals("Hunter")){
			typeCondition = false;
		}
		if( characterClass.equals("Ninja")){
			typeCondition = false;
		}
		if( characterClass.equals("Warrior")){
			typeCondition = false;
		}
		if( characterClass.equals("Skeleton")){
			typeCondition = true;
		}
		if( characterClass.equals("Bear")){
			typeCondition = true;
		}
		if( characterClass.equals("Spider")){
			typeCondition = true;
		}
		if( characterClass.equals("mini Boss")){
			typeCondition = true;
		}


		mob heroG = new mob("Admin", "Hunter", 999, true);
		mob hero1 = new mob(characterName, characterClass, hp, typeCondition);
		hero1.getHp();
		

		//================================
		//ENTITY DECLARATION  
		//================================

		int[] weaponArray = new int[2];
		mob[] zombieObjArray = hero1.spawnZombie(1);

		mob[] miniBossObjArray = heroG.spawnMiniBoss(2);
		mob[] bossObjArray = heroG.spawnBoss(3);

		

		int dmgDone;


		
		//////////////////////////////
		// fighting loop 
		//////////////////////////////
/*
		for(int k=0;k<3;k++){
			while(zombieArray[k].getHp()>0){
				System.out.println("Choose which weapon you wish to use by typing 0 for main or 1 for secondary");
				int weaponChoice = in.nextInt();
				dmgDone = hero1.typeOffense(characterClass,1);
				System.out.println("The dmgDone variable will pass through this value: "+dmgDone);
				zombieArray[k].attack(zombieArray,k,weaponChoice, characterClass,dmgDone);
				hero1.getMobHp(zombieArray);
			}
		}
*/


		
		/////////////////////////////
		// traversing the map
		/////////////////////////////   1= free space, 2 = chest,3 = b0ss 4= mini b0ss, 5 = current position, 0 = cant go on.
		int [][] map = {
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,1,1,1,1,0,2,1,3,0},
			{0,4,1,1,1,2,0,2,0,1,1,1,0,1,0,0},
			{0,0,2,0,1,0,0,0,0,1,1,1,1,1,0,0},
			{0,0,0,1,1,1,5,1,1,1,1,1,2,0,0,0},
			{0,0,0,0,0,0,1,0,0,1,1,1,0,0,0,0},
			{0,0,0,0,0,0,1,0,4,1,2,0,0,0,0,0},
			{0,0,0,3,1,1,1,1,1,0,3,0,0,0,0,0},
			{0,0,0,0,1,0,1,0,1,0,0,0,0,0,0,0},
			{0,0,2,1,1,1,2,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
		};

		int [][] checkMap = {
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,1,1,1,1,0,2,1,3,0},
			{0,4,1,1,1,2,0,2,0,1,1,1,0,1,0,0},
			{0,0,2,0,1,0,0,0,0,1,1,1,1,1,0,0},
			{0,0,0,1,1,1,5,1,1,1,1,1,2,0,0,0},
			{0,0,0,0,0,0,1,0,0,1,1,1,0,0,0,0},
			{0,0,0,0,0,0,1,0,4,1,2,0,0,0,0,0},
			{0,0,0,3,1,1,1,1,1,0,3,0,0,0,0,0},
			{0,0,0,0,1,0,1,0,1,0,0,0,0,0,0,0},
			{0,0,2,1,1,1,2,0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}
		};
		System.out.println(checkMap[4][11]);
		heroG.printMap(checkMap);
		heroG.atTile(map, checkMap, miniBossObjArray,bossObjArray,zombieObjArray);
	}
}


		

