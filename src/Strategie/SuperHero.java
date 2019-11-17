package Strategie;

public class SuperHero {
	
	private StrategiePouvoir stratpouvoir;
	
	//constructeur 1
	public SuperHero(){
		//par defaut un super hero est créé avec une strategie de pouvoir voler
		this.stratpouvoir = new StrategieFly();
	}
	//constructeur 2
	public SuperHero(StrategiePouvoir strategie) {
		//un super hero est créé avec un choix de strategie
		this.stratpouvoir = strategie;
	}
	//utiliser le pouvoir du super hero
	public void executePouvoir() {
		stratpouvoir.execute();
	}
	//changer de pouvoir (changer de strategie)
	public void setPouvoir(StrategiePouvoir strategie) {
		this.stratpouvoir = strategie;
	}
	
	
}
