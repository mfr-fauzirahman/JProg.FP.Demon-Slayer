package demonSlayer;

public class World implements Scenario{

	public World() {
	}

public void townGate(){
		System.out.println("You are at the gate of the town.");
		System.out.println("A guard is standing in front of you.");
		System.out.println("");
		System.out.println("What do you want to do?");
		System.out.println("");
		System.out.println("1: Talk to the guard");
		System.out.println("2: Attack the guard");
		System.out.println("3: Leave");
		System.out.println("\n------------------------------------------------------------------\n");

		Game.choice = Game.myScanner.nextInt();
		
		if(Game.choice==1){
			if(Game.greatDemonHeart==1){
				ending();
				System.exit(0);
			}
			else{
				System.out.println("Guard: \"Hello there, stranger. So your name is " + Game.playerName + "? \nSorry but we cannot let stranger enter our town.\"");
				Game.myScanner.nextLine();
				townGate();
			}
			
		}else if(Game.choice==2){
			Game.playerHP = Game.playerHP-1;
			System.out.println("Guard: \"Hey don't be stupid.\n\nThe guard hit you so hard and you gave up.\n(You receive 1 damage)\"\n");
			System.out.println("Your HP: " + Game.playerHP);
			Game.myScanner.nextLine();
			townGate();
		}else if(Game.choice==3){
			crossRoad();
		}else{
			townGate();
		}
	}
	
	public void crossRoad(){
		System.out.println("You are at a crossroad. If you go south, you will go back to the town.\n\n");
		System.out.println("1: Go north");
		System.out.println("2: Go east");
		System.out.println("3: Go south");
		System.out.println("4: Go west");
		System.out.println("\n------------------------------------------------------------------\n");
		
		Game.choice = Game.myScanner.nextInt();
		
		if(Game.choice==1){
			north();
		}
		else if(Game.choice==2){
			east();
		}
		else if(Game.choice==3){
			townGate();
		}
		else if(Game.choice==4){
			west();
		}
		else{
			crossRoad();
		}
	}
	
	public void north(){
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("There is a river. You drink the water and rest at the riverside.");
		System.out.println("Your HP is recovered.");
		if(Game.playerHP < Game.maxHP) {
			Game.playerHP = Game.maxHP;
		}
		System.out.println("Your HP: " + Game.playerHP);
		System.out.println("\n\n1: Go back to the crossroad");
		System.out.println("\n------------------------------------------------------------------\n");
		
		Game.choice = Game.myScanner.nextInt();
		
		if(Game.choice==1){
			crossRoad();
		}
		else{
			north();
		}
	}
	
	public void east(){
		int rareWeapon = Tools.Randomizer(0, 100);
		if(rareWeapon <= 10 && Game.playerWeapon.equals("Long Sword")) {
			System.out.println("You found a rare weapon!");
			Game.playerWeapon = "Lost Sword";
			System.out.println("Your Weapon: "+ Game.playerWeapon);
			
		}else if(Game.playerWeapon.equals("Knife")){
			System.out.println("You walked into a forest and found a Long Sword!");
			Game.playerWeapon = "Long Sword";
			System.out.println("Your Weapon: "+ Game.playerWeapon);
			
		}else {
			Game.monsterType = 2;
			Game.monsterHP = Tools.Randomizer(Game.maxHP/5, Game.maxHP);
			System.out.println("You encounter a bandit!\n");
			System.out.println("1: Fight");
			Game.canRun = Tools.Randomizer(0, 101);
			if(Game.canRun < 50) {
				System.out.println("2: Run");
			}else {
				System.out.println("You cannot run away!");
			}			
			System.out.println("\n------------------------------------------------------------------\n");
			
			
			Game.choice = Game.myScanner.nextInt();
			if(Game.choice==1){
				fight();
			}
			else if(Game.choice==2 && Game.canRun < 50){
				crossRoad();
			}
			else{
				fight();
			}
		}
		System.out.println("\n\n1: Go back to the crossroad");
		System.out.println("\n------------------------------------------------------------------\n");
		
		Game.choice = Game.myScanner.nextInt();
		
		if(Game.choice==1){
			crossRoad();
		}
		else{
			east();
		}
	}
	
	public void west(){
		int rareMonster = Tools.Randomizer(1, 101);
		if(rareMonster <= 10) {
			Game.monsterType = 1;
			Game.monsterHP = Tools.Randomizer(Game.maxHP * 2, Game.maxHP * 10);
			System.out.println("\n------------------------------------------------------------------\n");
			System.out.println("You encounter a huge demon!\n");
			System.out.println("1: Fight");
			
			Game.canRun = Tools.Randomizer(0, 101);
			if(Game.canRun < 25) {
				System.out.println("2: Run");
			}else {
				System.out.println("You cannot run away!");
			}			
			System.out.println("\n------------------------------------------------------------------\n");
			
			
			Game.choice = Game.myScanner.nextInt();
			if(Game.choice==1){
				fight();
			}
			else if(Game.choice==2 && Game.canRun < 25){
				crossRoad();
			}
			else{
				fight();
			}
		}else {
			Game.monsterType = 0;
			Game.monsterHP = Tools.Randomizer(Game.maxHP / 10, Game.maxHP);
			System.out.println("\n------------------------------------------------------------------\n");
			System.out.println("You encounter a demon!\n");
			System.out.println("1: Fight");
			Game.canRun = Tools.Randomizer(0, 101);
			if(Game.canRun < 45) {
				System.out.println("2: Run");
			}else {
				System.out.println("You cannot run away!");
			}			
			System.out.println("\n------------------------------------------------------------------\n");
			
			
			Game.choice = Game.myScanner.nextInt();
			if(Game.choice==1){
				fight();
			}
			else if(Game.choice==2 && Game.canRun < 45){
				crossRoad();
			}
			else{
				fight();
			}
		}
		
		
		
	}
	
	public void fight(){
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("Your HP: "+ Game.playerHP);
		System.out.println("Enemy HP: " + Game.monsterHP);
		System.out.println("\n1: Attack");

		Game.canRun = Tools.Randomizer(0, 101);
		if(Game.canRun < 50) {
			System.out.println("2: Run");
		}else {
			System.out.println("You cannot run away!");
		}
		
		System.out.println("\n------------------------------------------------------------------\n");
		Game.choice = Game.myScanner.nextInt();
		if(Game.choice==1){
			attack();
		}
		else if(Game.choice==2 && Game.canRun < 50){
			crossRoad();
		}
		else{
			attack();
		}
	}
	
	public void attack(){
		int playerDamage = 0;
		int consumes = 0;
		
		if(Game.playerWeapon.equals("Knife")){
			playerDamage = Tools.Randomizer(Game.maxHP / 100, Game.maxHP / 50); 
		}
		else if(Game.playerWeapon.equals("Long Sword")){
			playerDamage = Tools.Randomizer(Game.maxHP / 50, Game.maxHP / 4); 
		}
		else if(Game.playerWeapon.equals("Lost Sword")){
			playerDamage = Tools.Randomizer(Game.maxHP / 25, Game.maxHP / 2);  
		}
		else if(Game.playerWeapon.equals("Soul Eater")){
			playerDamage = Tools.Randomizer(Game.maxHP / 5, Game.maxHP * 5); 
			consumes = Tools.Randomizer(playerDamage / 25, playerDamage / 10); 

		}
		
		System.out.println("You attacked the enemy and gave " + playerDamage + " damage!");
		 if(Game.playerWeapon.equals("Soul Eater")) {
			
			System.out.println("Soul Eater consumes "+ consumes + " HP!");
			Game.playerHP = Game.playerHP - consumes;
			if(Game.playerHP < 1) {
				Game.playerHP = 0;
				badending();
				System.exit(0);
			}
		 }
		
		
		if(Game.monsterHP > playerDamage) {
			Game.monsterHP = Game.monsterHP - playerDamage;
		}else {
			Game.monsterHP = 0;
		}
		
		System.out.println("Enemy HP: " + Game.monsterHP);
		
		if(Game.monsterHP<1){ win(); } else if(Game.monsterHP>0){
			int monsterDamage = 0;
			if(Game.monsterType == 1) {
				monsterDamage = Tools.Randomizer(Game.maxHP/25, Game.maxHP / 10);
			}else if(Game.monsterType == 0) {
				monsterDamage = Tools.Randomizer(Game.maxHP/50, Game.maxHP  / 20);
			}else {
				monsterDamage = Tools.Randomizer(Game.maxHP/50, Game.maxHP / 25);
			}
			
			
			
			
			System.out.println("Enemy attacked you and gave " + monsterDamage + " damage!");
			
			if(Game.playerHP < monsterDamage) {
				Game.playerHP = 0;
			}else {
				Game.playerHP =  Game.playerHP - monsterDamage;;
			}
			
			System.out.println("Player HP: " + Game.playerHP);
			
			if(Game.playerHP<1){ dead(); System.exit(0);} else if(Game.playerHP>0){
				fight();
			}
		}
		
		
	}
	
	public void intro(){
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You are a lone wolf who lives as a demon slayer.");
		System.out.println("You needs to find your rival in this city and bring him your worth.");
		System.out.println("Can you finish the quest?");
		System.out.println("\n------------------------------------------------------------------\n");
	}
	
	public void ending(){
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("Guard: \"Oh my god! You cleared that demon nest!?? Great!\"");
		System.out.println("Guard: It seems you are a trustworthy guy. Welcome to our town!\"");
		System.out.println("You walks through the town to find a certain bar.");
		System.out.println("\"Sasuke: So it seems you can get in this town huh?!\"");
		System.out.println(Game.playerName+": \"Luckily though, seems good enough can get through that gate.\"");
		System.out.println("\n\n           THE END                    ");
		System.out.println("\n------------------------------------------------------------------\n");
	}
	
	public void badending(){
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("As you use the Soul Eater...");
		System.out.println("You cannot handle its power...");
		System.out.println("You slowly began to feel pain in every inch of your body...");
		System.out.println("Soul Eater: \"You insolent fool, do you really think you can handle my power?\"");
		System.out.println("As you hear the voice inside your head, your mind started fading away...");
		System.out.println("\n\n           BAD END                    ");
		System.out.println("\n------------------------------------------------------------------\n");
	}
	
	public void dead() {
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You are dead.");
		System.out.println("\n\nGAME OVER");
		System.out.println("\n------------------------------------------------------------------\n");
	}
	
	public void win() {
		System.out.println("\n------------------------------------------------------------------\n");
		System.out.println("You killed the enemy!");
		System.out.println("Your HP: "+Game.playerHP);
		int getItem = Tools.Randomizer(0, 100); 
		if(getItem <= 100 && Game.monsterType == 1) {
			System.out.println("The demon dropped an item!");
			System.out.println("You obtained a great demon heart!\n\n");
			Game.greatDemonHeart = 1;
		}
		
		if(getItem <= 100 && Game.monsterType == 0 && Game.playerWeapon.equals("Soul Eater") == false) {
			System.out.println("The demon dropped a weapon!");
			System.out.println("You obtained Soul Eater!\n\n");
			Game.playerWeapon = "Soul Eater";
			System.out.println("Your Weapon: "+ Game.playerWeapon);
		}
		
		if(getItem <= 100 && Game.monsterType == 2 && Game.playerWeapon.equals("Soul Eater") == false && Game.playerWeapon.equals("Lost Sword") == false) {
			System.out.println("The bandit dropped a weapon!");
			System.out.println("You obtained the lost sword!\n\n");
			Game.playerWeapon = "Lost Sword";
			System.out.println("Your Weapon: "+ Game.playerWeapon);
		}
		System.out.println("1: Go back");
		System.out.println("\n------------------------------------------------------------------\n");

		
		Game.choice = Game.myScanner.nextInt();
		if(Game.choice==1){
			crossRoad();
		}
		else{
			win();
		}
	}
}
