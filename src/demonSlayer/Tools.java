package demonSlayer;

public class Tools {

	public Tools() {
		// TODO Auto-generated constructor stub
	}

	public static int Randomizer(int min, int max) {
		int damage = new java.util.Random().nextInt(max) + min;
		return damage;
	}
	
}
