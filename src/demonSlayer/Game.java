package demonSlayer;
import java.util.Scanner;

public class Game extends World{
	
	public final static Scanner myScanner = new Scanner(System.in);
	public static int maxHP;
	public static int playerHP;
	public static String playerName;
	public static String playerWeapon;
	public static int choice;
	public static int monsterHP = 0;
	public static int monsterType;
	public static int canRun;
	
	static int greatDemonHeart;
		
	public static void main(String[] args) {
		World DemonSlayerGame;
		DemonSlayerGame = new World();	
		
		DemonSlayerGame.intro();
		playerSetUp(); 	
		DemonSlayerGame.crossRoad();
	}
	
	public static void playerSetUp(){
		
		maxHP = Tools.Randomizer(100, 10000);
		playerHP = Tools.Randomizer(1, maxHP);

		playerWeapon = "Knife";

		System.out.println("Your Max HP: "+ maxHP);
		System.out.println("Your HP: "+ playerHP);
		System.out.println("Your Weapon: "+ playerWeapon);
		
		System.out.println("Please enter your name:");
		
		playerName = myScanner.nextLine();
		
	}	
	}