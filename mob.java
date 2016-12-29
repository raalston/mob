import java.util.Random;
import java.util.Scanner;
public class mob implements GameInterface{

	String name = "ryan";
	String type;
	double hp;
	int weapon;
	boolean condition;
	boolean userCondition;
	boolean deadCondition;
	boolean checkCondition;
	int n = 5;
	int dmgDone;
	private int i =0;
	int weapon1, weapon2;
	int[] weaponArray = new int[2];
	int callCount = 0;
	
	

	public mob(String givenName, String givenType, double givenHp, boolean isNPC){
		name = givenName;
		type = givenType;
		hp = givenHp;
		userCondition = isNPC;
	}

	public boolean getCondition(){
		System.out.println(checkCondition);
		return checkCondition;
	}


	public void isUser(boolean userCondition){
		if(userCondition == true){
			System.out.println("npc confirmed");
		}
		//System.out.println(checkCondition);
		if( userCondition == false){
			System.out.println("user confirmed");
		}
	}

	

	public void increaseHp(double inc){
		hp += inc;
	}

	public void decreaseHp(double inc){
		hp -= inc;
	}

	public double getHp(){
		return hp;
	}

	public boolean isDead(){
		deadCondition = false;
		if( hp <= 0.0){
			deadCondition = true;
		}
		System.out.println(deadCondition);
		return deadCondition;
	}
	
	public void weaponDeCoder(int[] weapon){
		for(int i=0; i<2;i++){
			weaponArray[i] = weapon[i];
		}
		
		if(weaponArray[0] == 10){
			String weaponInUse = "Broad Sword";
			System.out.println(weaponInUse);
		}
		if(weaponArray[1] == 11){
			String weaponInUse = "knife";
			System.out.println(weaponInUse);
		}
		if(weaponArray[0] == 20){
			String weaponInUse = "Katana";
			System.out.println(weaponInUse);
		}
		if(weaponArray[1] == 21){
			String weaponInUse = "shurikens";
			System.out.println(weaponInUse);
		}
		if(weaponArray[0] == 30){
			String weaponInUse = "Long Bow";
			System.out.println(weaponInUse);
		}
		if(weaponArray[1] == 31){
			String weaponInUse = "knife";
			System.out.println(weaponInUse);
		}	
	}

	public double hpDeCoder(String type){
		if( type.equals("Hunter")){
			hp = 12.0;
		}
		if(type.equals("Warrior")){
			hp = 17.0;
		}
		if(type.equals("Ninja")){
			hp = 13.5;
		}
		return hp;
	}
	
	/*
	public void getClassType(boolean checkCondition){
		
		if( checkCondition = false){
			System.out.println("Player is of type "+type);

		}else{
			System.out.println("Mob is of type" +type);
		}
		
	}

	*/

	public int typeOffense(String givenType, int useWhichWeapon){
		type = givenType;
		int weaponToUse = useWhichWeapon; // 0 or 1
		weaponArray[0] = 00;// intialized at 00 and 01 for unarmed/ non classes
		weaponArray[1] = 01;
		Random rn = new Random();
		int dmgDone = 0;

	
		if(type.equals("Warrior")){
			weaponArray[0] = 10;
			weaponArray[1] = 11;
			if (weaponToUse == 0){
				String weaponInUse = "Broad Sword";
				dmgDone = rn.nextInt(7);

			}
			if (weaponToUse == 1){
				String weaponInUse = "Knife";
				dmgDone = rn.nextInt(3);
			}
			System.out.println(dmgDone);
		}
		if(type.equals("Ninja")){
			weaponArray[0] = 20;
			weaponArray[1] = 21;
			if (weaponToUse == 0){
				String weaponInUse = "Katana";
				dmgDone = rn.nextInt(9);

			}
			if (weaponToUse == 1){
				String weaponInUse = "Shurikens";
				dmgDone = rn.nextInt(4);
			}
			System.out.println(dmgDone);
		}
		if(type.equals("Hunter")){
			weaponArray[0] = 30;
			weaponArray[1] = 31;
			if (weaponToUse == 0){
				String weaponInUse = "Long Bow";
				dmgDone = rn.nextInt(9);

			}
			if (weaponToUse == 1){
				String weaponInUse = "Knife";
				dmgDone = rn.nextInt(3);
			}
			System.out.println(dmgDone);
		}
		return dmgDone;
	}

	public void typeDefense(){

	}

	/*public void weaponPopulator(String weaponName){
		weapon = weaponName;
		String[] weapon = new String[i];

		
		for(i = 0; i<n; i++){
			weapon[i] = n;
			n++;
		}


	}*/

	public void useHealthPot(){
		increaseHp(10);
		System.out.println("Used HEALTHPOT, health increased by 10");
		getHp();
		System.out.println("Current hp is: "+hp);

	}

	public String getName(){
		System.out.println(name);
		return name;
	}




	public mob[] spawnZombie(int numberOfZombies){//must be less than or equal to 3
		int numOf = numberOfZombies;
		numOf = 3;

		String zombieType;
		double zombieHp;
		boolean nPCcondition;

		mob[] zombieObjArray = new mob[numOf]; 
		String [] zombieNameArray = {"zombie 0", "zombie1", "zombie2"};
		
		for(int k = 0; k<numOf; k++){
			zombieObjArray[k] = new mob(zombieNameArray[k], "Zombie", 5.0, true);
		}
		return zombieObjArray;
	}

	public void getMobHp(mob[] mob){
		mob[] mobObjArray = new mob[mob.length];
		for(int i =0; i<mob.length; i++){
			mobObjArray[i] = mob[i];
			double currentHp = mobObjArray[i].getHp();
			System.out.println("Zombie number "+i+" has "+currentHp+" left");
		}
	}

	public void attack(mob[] mob, int mobElement,int weaponNumber,String characterType,int damageDone){
		int mobNum = mobElement;
		int dmgDone = damageDone;
		int weapNumb = weaponNumber;
		String type = characterType;
			

		typeOffense(type, weaponNumber);// returns array
		System.out.println("The amount of damage you are about to do is eqal to: "+dmgDone);

		if (weaponNumber == 0){
			mob[mobNum].decreaseHp(dmgDone);
		}
		if (weaponNumber == 1){
			mob[mobNum].decreaseHp(dmgDone);
		}



	}


	public void mobIncreaseHp(mob[] mob, int mobNumber, double inc){
		double hpChange = inc;
		mob[mobNumber].increaseHp(inc);
		System.out.println("The new hp for mob "+mobNumber+" is "+hp);
	}


	public void moveCurrentLocation(int[][] map, int[][] checkMap, int direction){
		int k =0;
		int xPos = 0;
		int yPos = 0;
		xPos = findCurrentX(map);
		yPos = findCurrentY(map);
	
		if( direction == 1){
			map[xPos][yPos+1] = 5;
			checkCurrentTile(map,checkMap);
			map[xPos][yPos] = 1;
		}
		if( direction == 2 ){
			map[xPos][yPos-1] = 5;
			checkCurrentTile(map,checkMap);
			map[xPos][yPos] = 1;

		}
		if( direction == 3 ){
			map[xPos+1][yPos] =5;
			checkCurrentTile(map,checkMap);
			map[xPos][yPos] =1;

		}
		if( direction == 4){
			map[xPos-1][yPos] =5;
			checkCurrentTile(map,checkMap);
			map[xPos][yPos] =1;

		}//else{
		//	System.out.println("Error: can only move one unit in one of the 4 directions.");
		//}


	}


	public void freeCurrentLocation(int[][] map,int tileType){
		int xPos = findCurrentX(map);
		int yPos = findCurrentY(map);
		System.out.println(map[xPos][yPos]);
		map[xPos][yPos] = tileType;

	}

	public int findCurrentX(int[][] map){
		int xPos = 0;
		int yPos = 0;
		for(int k=0;k<14;k++){
			for(int j = 0;j<9;j++){
				if(map[j][k] == 5){
					xPos = j;
					yPos = k;
				}
			}
		}
		return xPos;
	}

	public int findCurrentY(int[][] map){
		int xPos = 0;
		int yPos = 0;
		for(int k=0;k<14;k++){
			for(int j = 0;j<9;j++){
				if(map[j][k] == 5){
					xPos = j;
					yPos = k;
				}
			}
		}
		return yPos;
	}		

	public void atTile(int[][] map, int[][] checkMap){
		Scanner in = new Scanner(System.in);
		int yPos=findCurrentY(map);
		int xPos=findCurrentX(map);
		System.out.println("You are at tile "+xPos+","+yPos);
		System.out.println("Type the direction you want to go: ");
		System.out.println("1: up, 2: down, 3: right, 4: left");
		int direction = in.nextInt();

		moveCurrentLocation(map, checkMap, direction);
		atTile(map, checkMap);

	}

	public void checkCurrentTile(int[][] map, int[][] checkMap){
		int xPos = findCurrentX(map);
		int yPos = findCurrentY(map);

		if(checkMap[xPos][yPos] == 2){ 
			System.out.println("You have discovered a chest!");
			atChest();

		}
		if(checkMap[xPos][yPos] == 3){
			System.out.println("You have discovered a boss!");
		}
		if(checkMap[xPos][yPos] == 4){
			System.out.println("You have dsicovered a mini-boss");
		}
	}


	public void atChest(){
		Random rn = new Random();
		int chestItem = rn.nextInt(3);
		if(chestItem == 0){
			increaseHp(2);
			System.out.println("Found Potion!  Increased hp by 2.");
			getHp();
		}
		if(chestItem == 1){
			increaseHp(4);
			System.out.println("Found Potion!  Increased hp by 4.");
			getHp();
		}
		if(chestItem == 2){
			increaseHp(6);
			System.out.println("Found Potion!  Increased hp by 6.");
			getHp();
		}
	}



	
}