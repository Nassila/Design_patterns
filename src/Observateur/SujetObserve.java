package Observateur;

import java.util.ArrayList;

public abstract class SujetObserve {
	
	//liste d'observateurs
	private ArrayList<Observateur> observateurs;
	
	//constructeur
	protected SujetObserve() {
		observateurs = new ArrayList<Observateur>();
	}
	
	//methode d'ajout d'un observateur à la liste d'observateurs
	public void abonner(Observateur o) {
		observateurs.add(o);
		}
	
	//methode de suppression d'un observateur dans la liste d'observateurs
	public void desabonner(Observateur o) {
		observateurs.remove(o);
	}
	
	//methode permettant de notifier les observateur du changement 
	public void notifier(Object arg) {
		for (Observateur o : observateurs) {
			o.mise_a_jour(arg);
		}
	}

}
