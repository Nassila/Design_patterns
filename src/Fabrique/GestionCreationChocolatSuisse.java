package Fabrique;

public class GestionCreationChocolatSuisse implements GestionCreationChocolat {

	@Override
	public Chocolat creer(TypeChocolat type) {
		if (type == TypeChocolat.Lait) {
			return new ChocolatAuLaitSuisse();
		} else {
			return new ChocolatNoirSuisse();
		}
	}

}
