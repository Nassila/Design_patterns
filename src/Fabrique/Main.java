package Fabrique;

public class Main {

	public static void main(String[] args) {

		GestionCreationChocolat gestion = new GestionCreationChocolatFrance();
		UsineDeChocolat usine = new UsineDeChocolat(gestion);

		usine.creer(TypeChocolat.Lait);
		usine.creer(TypeChocolat.Noir);
	}

}
