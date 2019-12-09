package Fabrique;

public class UsineDeChocolat {

	GestionCreationChocolat gestion;

	public UsineDeChocolat(GestionCreationChocolat gestion) {
		this.gestion = gestion;
	}

	public Chocolat creer(TypeChocolat type) {

		return gestion.creer(type);

	}
}
