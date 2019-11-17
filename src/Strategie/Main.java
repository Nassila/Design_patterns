package Strategie;

public class Main {

	public static void main(String[] args) {
		//creer un super hero avec comme pouvoir celui de devenir invisible
		SuperHero superhero = new SuperHero(new StrategieInvisible());
		//executer le pouvoir
		superhero.executePouvoir();
		//chager de pouvoir
		superhero.setPouvoir(new StrategieFast());
		//executer le nouveau pouvoir
		superhero.executePouvoir();
	}
}
