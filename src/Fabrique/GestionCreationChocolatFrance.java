package Fabrique;

public class GestionCreationChocolatFrance implements GestionCreationChocolat {

	@Override
	public Chocolat creer(TypeChocolat type) {
		if (type == TypeChocolat.Lait) {
			return new ChocolatAuLaitFrance();
		} else {
			return new ChocolatNoirFrance();
		}
	}

}
