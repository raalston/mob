import java.util.Random;
import java.util.Scanner;
public class mob implements GameInterface{

	String name = "ryan";
	String type;
	String boss;
	String characterClass;
	String givenName;
	int givenHp;
	String givenType;
	boolean isNPC;
	double hp;
	String useWeapon;
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
	String[] bossNameArray ={"BOSS 1","BOSS 2","BOSS 3"};
	String[] zombieNameArray ={"ZOMBIE 1", "ZOMBIE 2", "ZOMBIE 3"};
	mob[] hero1;




	
	

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

	public void getMobHp(mob[] mob, int mobNumber){
		mob[] mobObjArray = new mob[mob.length];
		for(int i =0; i<mob.length; i++){
			mobObjArray[i] = mob[i];
			double currentHp = mobObjArray[i].getHp();
		}
		double currentHp = mobObjArray[mobNumber].getHp();
		System.out.println("Mob has has "+currentHp+" hp left");

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


	public void moveCurrentLocation(int[][] map, int[][] checkMap, int direction, mob[] miniBossObjArray,mob[] bossObjArray ,mob[] zombieObjArray , String[] bossNameArray){
		int k =0;
		int xPos = 0;
		int yPos = 0;
		xPos = findCurrentX(map);
		yPos = findCurrentY(map);
	
		if( direction == 1){
			if(checkMap[yPos+1][xPos] == 0){
				System.out.println("");
				System.out.println("You cant go this way!");
				
	
			}else{
				System.out.println("");
				//System.out.println("Entered the else statement gg");
				map[yPos+1][xPos] = 5;
				int yNewPos = yPos+1;
				//System.out.println("Set "+xPos+", "+yNewPos+" as current location");
				if (checkMap[yNewPos][xPos] ==7){
					System.out.println("You are on the path...");
				}
				if(checkMap[yNewPos][xPos] == 0){
					System.out.println("You cant go this way!");
				}

				if(checkMap[yNewPos][xPos] == 2){ 
					System.out.println("You have discovered a chest!");
					atChest();
					resetTile(checkMap, xPos, yNewPos);

				}
				if(checkMap[yNewPos][xPos] == 3){
					System.out.println("You have discovered a boss!");
					atBoss(checkMap,xPos, yNewPos,bossObjArray,bossNameArray);
				}
				if(checkMap[yNewPos][xPos] == 4){
					System.out.println("You have discovered a mini-boss");
					atMiniBoss(checkMap,xPos,yNewPos, miniBossObjArray);
				}
				if(checkMap[yNewPos][xPos] ==1){
					System.out.println("You are attacked by zombies...");
					atZombie(checkMap,xPos,yNewPos, zombieObjArray);
				}
				if(checkMap[yNewPos][xPos]  == 5){
					System.out.println("You are back at the start.");
					resetTile(checkMap,xPos,yNewPos);
				}
				
				map[yPos][xPos] = 7;
				
		
			}
			
			
		}
		if( direction == 2 ){
			if(checkMap[yPos-1][xPos] == 0){
				System.out.println("");
				System.out.println("You cant go this way!");
				
			}else{
				System.out.println("");
				//System.out.println("Entered the else statement gg");
				map[yPos-1][xPos] = 5;
				int yNewPos = yPos-1;
				//System.out.println("Set "+xPos+", "+yNewPos+" as current location");
				if (checkMap[yNewPos][xPos] ==7){
					System.out.println("You are on the path...");
				}
				if(checkMap[yNewPos][xPos] == 0){
					System.out.println("You cant go this way!");
				}

				if(checkMap[yNewPos][xPos] == 2){ 
					System.out.println("You have discovered a chest!");
					atChest();
					resetTile(checkMap, xPos, yNewPos);

				}
				if(checkMap[yNewPos][xPos] == 3){
					System.out.println("You have discovered a boss!");
					atBoss(checkMap,xPos, yNewPos,bossObjArray,bossNameArray);
				}
				if(checkMap[yNewPos][xPos] == 4){
					System.out.println("You have discovered a mini-boss");
					atMiniBoss(checkMap, xPos, yNewPos, miniBossObjArray);
				}
				if(checkMap[yNewPos][xPos] ==1){
					System.out.println("You are attacked by zombies...");
					atZombie(checkMap,xPos,yNewPos,zombieObjArray);
				}
				if(checkMap[yNewPos][xPos]  == 5){
					System.out.println("You are back at the start.");
					resetTile(checkMap,xPos,yNewPos);
				}
				

				
				map[yPos][xPos] = 7;
				
				
			}


		}
		if( direction == 3 ){
			if(checkMap[yPos][xPos+1] == 0){
				System.out.println("");
				System.out.println("You cant go this way!");
				
			}else{
				System.out.println("");
				//System.out.println("Entered the else statement gg");
				map[yPos][xPos+1] = 5;
				int xNewPos = xPos+1;
				System.out.println("Set "+xNewPos+", "+yPos+" as current location");
				if (checkMap[yPos][xNewPos] ==7){
					System.out.println("You are on the path...");
				}
				if(checkMap[yPos][xNewPos] == 0){
					System.out.println("You cant go this way!");
				}

				if(checkMap[yPos][xNewPos] == 2){ 
					System.out.println("You have discovered a chest!");
					atChest();
					resetTile(checkMap, xNewPos, yPos);

				}
				if(checkMap[yPos][xNewPos] == 3){
					System.out.println("You have discovered a boss!");
					atBoss(checkMap,xNewPos, yPos,bossObjArray,bossNameArray);
				}
				if(checkMap[yPos][xNewPos] == 4){
					System.out.println("You have discovered a mini-boss");
					atMiniBoss(checkMap, xNewPos, yPos,miniBossObjArray);
				}
				if(checkMap[yPos][xNewPos] ==1){
					System.out.println("You are attacked by zombies...");
					atZombie(checkMap,xNewPos,yPos,zombieObjArray);
				}
				if(checkMap[yPos][xNewPos]  == 5){
					System.out.println("You are back at the start.");
					resetTile(checkMap,xNewPos,yPos);
				}
				

				
				map[yPos][xPos] = 7;
				
			}

		}
		if( direction == 4){
			System.out.println("");
			if(checkMap[yPos][xPos-1] == 0){
				System.out.println("You cant go this way!");
				
			}else{
				System.out.println("");
				//System.out.println("Entered the else statement gg");
				map[yPos][xPos-1] = 5;
				int xNewPos = xPos-1;
				//System.out.println("Set "+xNewPos+", "+yPos+" as current location");
				
				if (checkMap[yPos][xNewPos] ==7){
					System.out.println("You are on the path...");
				}
				if(checkMap[yPos][xNewPos] == 0){
					System.out.println("You cant go this way!");
				}

				if(checkMap[yPos][xNewPos] == 2){ 
					System.out.println("You have discovered a chest!");
					atChest();
					resetTile(checkMap, xNewPos, yPos);

				}
				if(checkMap[yPos][xNewPos] == 3){
					System.out.println("You have discovered a boss!");
					atBoss(checkMap,xNewPos, yPos,bossObjArray,bossNameArray);
				}
				if(checkMap[yPos][xNewPos] == 4){
					System.out.println("You have discovered a mini-boss");
					atMiniBoss(checkMap, xNewPos, yPos,miniBossObjArray);
				}
				if(checkMap[yPos][xNewPos] ==1){
					System.out.println("You are attacked by zombies...");
					atZombie(checkMap,xNewPos,yPos,zombieObjArray);
				}
				if(checkMap[yPos][xNewPos]  == 5){
					System.out.println("You are back at the start.");
					resetTile(checkMap,xNewPos,yPos);
				}
				

				
				map[yPos][xPos] = 7;
				
			}

		}
		if( direction == 5){
			getUserHp(hero1);
		}

		if(direction == 6){
			printMap(checkMap);
		}
		//else{
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
		for(int k=0;k<15;k++){
			for(int j = 0;j<10;j++){
				if(map[j][k] == 5){
					yPos = j;
					xPos = k;
				}
			}
		}
		return xPos;
	}

	public int findCurrentY(int[][] map){
		int xPos = 0;
		int yPos = 0;
		for(int k=0;k<15;k++){
			for(int j = 0;j<10;j++){
				if(map[j][k] == 5){
					yPos = j;
					xPos = k;
				}
			}
		}
		return yPos;
	}		

	public void atTile(int[][] map, int[][] checkMap, mob[] miniBossObjArray, mob[] bossObjArray, mob[] zombieObjArray){
		Scanner in = new Scanner(System.in);
		int yPos=findCurrentY(map);
		int xPos=findCurrentX(map);
		if(checkMap[7][10] == 1 && checkMap[7][3] == 1 && checkMap[1][14] == 1){
			System.out.println("YOU HAVE WON!");
			endGame();
		}
		System.out.println("You are at tile "+xPos+","+yPos);
		System.out.println("Type the direction you want to go: ");
		System.out.println("1: up, 2: down, 3: right, 4: left, 5: hp, 6: map");
		int direction = in.nextInt();

		
		
		

		moveCurrentLocation(map, checkMap, direction,miniBossObjArray,bossObjArray,zombieObjArray, bossNameArray);
		atTile(map, checkMap,miniBossObjArray,bossObjArray,zombieObjArray);

	}

	public void checkCurrentTile(int[][] map, int[][] checkMap, mob[] miniBossObjArray,mob[] bossObjArray, mob[] zombieObjArray){
		int xPos = findCurrentX(map);
		int yPos = findCurrentY(map);
		Random rn = new Random();
		//int numberOfZombies = rn.nextInt(1);
		System.out.println("Checking for things on tile "+xPos+", "+yPos);

		if(checkMap[yPos][xPos] == 0){
			System.out.println("You cant go this way!");
		}

		if(checkMap[yPos][xPos] == 2){ 
			System.out.println("You have discovered a chest!");
			atChest();
			resetTile(checkMap, xPos, yPos);

		}
		if(checkMap[yPos][xPos] == 3){
			System.out.println("You have discovered a boss!");
			atBoss(checkMap, xPos,yPos, bossObjArray,bossNameArray);
		}
		if(checkMap[yPos][xPos] == 4){
			System.out.println("You have discovered a mini-boss");
			atMiniBoss(checkMap,xPos,yPos, miniBossObjArray);
		}

		if(checkMap[yPos][xPos] == 1){
			System.out.println("You have discovered a zombie!");
			atZombie(checkMap,xPos,yPos, zombieObjArray);

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

	public void resetTile(int[][] checkMap, int xPos, int yPos){
		int xLoc = xPos;
		int yLoc = yPos;
		checkMap[yLoc][xLoc] = 7;
	}

	

	public int atMiniBoss(int[][] checkMap, int xPos, int yPos,mob[] miniBossObjArray ){
		boolean isThere = false;
		int mobNumber = 0;
		System.out.println("You have found a mini dungeon");
		if(yPos == 2 && xPos == 1){
			System.out.println("You have entered BOSS1's lair.");
			mobNumber = 0;
			battleMiniBoss(checkMap,xPos, yPos, miniBossObjArray,mobNumber);
			System.out.println("YOU HAVE SUCCESFULLY DEFEATED THE FIRST MINI BOSS");
			resetTile(checkMap,xPos,yPos);
			return mobNumber;
		}
		if(yPos == 6 && xPos == 8){
			System.out.println("You have entered BOSS2's lair.");
			mobNumber = 1;
			battleMiniBoss(checkMap,xPos, yPos, miniBossObjArray,mobNumber );
			System.out.println("YOU HAVE SUCCESFULLY DEFEATED THE SECOND MINI BOSS");
			resetTile(checkMap,xPos,yPos);
			return mobNumber;
		}
		return mobNumber;

	}

	public void miniBossDialogue(){
		System.out.println();
	}

	public mob[] spawnMiniBoss(int numberOfMiniBosses){//must be 2
		int numOf = numberOfMiniBosses;
		numOf = 2;

		String bossType;
		double bossHp;
		boolean nPCcondition;

		mob[] miniBossObjArray = new mob[numOf]; 
		String [] miniBossNameArray = {"miniBoss1", "miniBoss2"};
		
		for(int k = 0; k<numOf; k++){
			miniBossObjArray[k] = new mob(miniBossNameArray[k], "mini boss", 30.0, true);
		}
		return miniBossObjArray;
	}


	public void battleMiniBoss(int[][] checkMap, int xPos, int yPos, mob[] miniBossObjArray, int mobNumber){
		Scanner in = new Scanner(System.in);
		characterClass = "Warrior";
		Random rn = new Random();
		int dmgTaken= rn.nextInt(4);
						
			while(miniBossObjArray[mobNumber].getHp()>0){
					System.out.println("Choose which weapon you wish to use by typing 0 for main or 1 for secondary");
					int weapon = in.nextInt();
					dmgDone = typeOffense(type,weapon);
					System.out.println("The dmgDone variable will pass through this value: "+dmgDone);
					miniBossObjArray[mobNumber].attack(miniBossObjArray,mobNumber,weapon, characterClass,dmgDone);
					dmgUser(hero1,dmgTaken);
					getMobHp(miniBossObjArray,mobNumber);
				}
		
	}

	public void bossDialogue(){

	}

	public mob[] spawnBoss(int numberOfBosses){ //must be 3
		Scanner in = new Scanner(System.in);
		int numOf = 3;

		String bossType;
		double bossHp;
		boolean nPCcondition;

		mob[] bossObjArray = new mob[numOf];

		for(int k=0;k<numOf;k++){
			bossObjArray[k]= new mob(bossNameArray[k], "boss", 50.0, true);
		}
		return bossObjArray;

	}

	public int atBoss(int[][] checkMap, int xPos, int yPos,mob[] bossObjArray,String[] bossNameArray ){
		boolean isThere = false;
		int mobNumber = 0;
		int endCounter = 0;
		System.out.println("You have found a dungeon");
		if(yPos == 1 && xPos == 14){
			System.out.println("You have entered "+bossNameArray[0]+" lair.");
			mobNumber = 0;
			battleBoss(checkMap,xPos, yPos, bossObjArray,mobNumber);
			System.out.println("YOU HAVE SUCCESFULLY DEFEATED "+bossNameArray[0]);
			endCounter++;
			resetTile(checkMap,xPos,yPos);
			return mobNumber;
		}
		if(yPos == 7 && xPos == 3){
			System.out.println("You have entered "+bossNameArray[1]+" lair.");
			mobNumber = 1;
			battleBoss(checkMap,xPos, yPos, bossObjArray,mobNumber );
			System.out.println("YOU HAVE SUCCESFULLY DEFEATED "+bossNameArray[1]);
			endCounter++;
			resetTile(checkMap,xPos,yPos);
			return mobNumber;
		}
		if(yPos == 7 && xPos == 10){
			System.out.println("You have entered "+bossNameArray[2]+" lair.");
			mobNumber = 2;
			battleBoss(checkMap,xPos, yPos, bossObjArray,mobNumber );
			System.out.println("YOU HAVE SUCCESFULLY DEFEATED "+bossNameArray[2]);
			endCounter++;
			resetTile(checkMap,xPos,yPos);
			return mobNumber;
		}
		return mobNumber;

	}

	public void battleBoss(int[][] checkMap, int xPos, int yPos, mob[] bossObjArray, int mobNumber){
		Scanner in = new Scanner(System.in);
		characterClass = "Warrior";
		Random rn = new Random();
		int dmgTaken = rn.nextInt(5);
						
			while(bossObjArray[mobNumber].getHp()>0){
					System.out.println("Choose which weapon you wish to use by typing 0 for main or 1 for secondary");
					int weapon = in.nextInt();
					dmgDone = typeOffense(type,weapon);
					System.out.println("The dmgDone variable will pass through this value: "+dmgDone);
					bossObjArray[mobNumber].attack(bossObjArray,mobNumber,weapon, characterClass,dmgDone);
					dmgUser(hero1,dmgTaken);
					getMobHp(bossObjArray,mobNumber);
				}
		
	}

	public mob[] spawnZombie(int numberOfZombies){//must be less than or equal to 3
		int numOf = numberOfZombies;
		numOf = 1;

		String zombieType;
		double zombieHp;
		boolean nPCcondition;

		mob[] zombieObjArray = new mob[numOf]; 
		
		for(int k = 0; k<numOf; k++){
			zombieObjArray[k] = new mob(zombieNameArray[k], "Zombie", 5.0, true);
		}
		return zombieObjArray;
	}

	public int atZombie(int[][] checkMap, int xPos, int yPos,mob[] zombieObjArray ){
		int mobNumber = 0;
		System.out.println("before if......");
		System.out.println("xPos should be 10... it is " +xPos);
		System.out.println("yPos should be 4... it is "+yPos);
		System.out.println("This value is supposed to be 1.... it is actually: "+checkMap[yPos][xPos]);
		if(checkMap[yPos][xPos] == 1){
			System.out.println("just inside if......");
			mobNumber = 1;
			battleZombie(checkMap,xPos, yPos, zombieObjArray,mobNumber );
			System.out.println("YOU HAVE SUCCESFULLY DEFEATED THE ZOMBIE");
			while(zombieObjArray[0].getHp()!= 5.0){
				zombieObjArray[0].increaseHp(1);
			}
			System.out.println("");

			resetTile(checkMap,xPos,yPos);
			return mobNumber;
		}
		return mobNumber;

	}

	public void battleZombie(int[][] checkMap, int xPos, int yPos, mob[] zombieObjArray, int mobNumber){
		Scanner in = new Scanner(System.in);
		characterClass = "Warrior";
		Random rn =new Random();
		int dmgTaken = rn.nextInt(2);
						
			while(zombieObjArray[0].getHp()>0){
					System.out.println("Choose which weapon you wish to use by typing 0 for main or 1 for secondary");
					int weapon = in.nextInt();
					dmgDone = typeOffense(type,weapon);
					System.out.println("");
					System.out.println("You strike for: "+dmgDone+" damage.");
					zombieObjArray[0].attack(zombieObjArray,0,weapon, characterClass,dmgDone);
					dmgUser(hero1,dmgTaken);

					getMobHp(zombieObjArray,0);
					System.out.println("");
				}
		
	}




	public void endGame(){
		System.exit(0);
	}

	public double getUserHp( mob[] hero1){
		System.out.println(hp);
		return hp;
	}

	public double dmgUser( mob[] hero1, int dmgTaken){
		hp = hp-dmgTaken;
		System.out.println("The user is hurt for "+dmgTaken+" hp.");
		return hp;
	}

	public void printMap(int[][] checkMap){
		for(int p=0;p<11;p++){
			System.out.println("");
			for (int q=0;q<15;q++){
				System.out.print(checkMap[p][q]+" ");
			}
		}
		System.out.println("");
	}


	
}