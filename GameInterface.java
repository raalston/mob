public interface GameInterface{
	
	//pre: none
	//post: if hp == 0 return true if not false
	public boolean isDead();

	// pre:none
	// post: return hp;
	public double getHp();

	//pre:none
	//post:
	public void increaseHp(double inc);

	//pre: none
	//post: prints out the weapon assigned to user or "null" if nothing is assigned
	//public void weaponDeCoder(int[] weapon);

	//pre: none
	//post: increase the hp of hero1 by 10 and prints out the effect and displays value of hp
	public void useHealthPot();

	//pre: none
	//post: none
	//public void getClassType();

	//pre: make a call to getClassType();
	//post: 
	public int typeOffense(String givenType, int useWhichWeapon);

	public void weaponDeCoder(int[] weapon);

	public double hpDeCoder(String type);

	public mob[] spawnZombie(int numberOfZombies);

	public String getName();

	public void getMobHp(mob[] mob, int mobNumber);

	public void mobIncreaseHp(mob[] mob, int mobNumber,double inc);

	public void attack(mob[] mob, int mobElement, int weaponNumber, String characterType,int dmgDone);

	public int findCurrentX(int[][] map);

	public int findCurrentY(int[][] map);

	public void freeCurrentLocation(int[][] map, int tileType);

	public void moveCurrentLocation(int[][] map, int[][] checkMap, int direction, mob[] miniBossObjArray, mob[] bossObjArray,mob[] zombieObjArray, String[] bossNameArray);

	public void atTile(int[][] map, int[][] checkMap, mob[] miniBossObjArray, mob[] bossObjArray, mob[] zombieObjArray);

	public void atChest();
}