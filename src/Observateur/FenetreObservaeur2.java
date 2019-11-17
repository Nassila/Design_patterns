package Observateur;


import javax.swing.JFrame;
import javax.swing.JLabel;

public class FenetreObservaeur2 extends JFrame implements Observateur{
	private JLabel label;

	public FenetreObservaeur2() {
		//taille de la fenetre
		setSize(260, 100);
		//centrer l'apparition de la fenetre
		setLocationRelativeTo(this);
		//rendre la fenetre visible
		setVisible(true);
		//titre de la fenetre
		setTitle("Observateur 2");
		//arreter l'execution à la fermeture de la fenetre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ajout d'un label à la fentre pour pouvoir affichier l'heure dans le fenetre
		label=new JLabel("");
		add(label);
	}

	@Override
	public void mise_a_jour(Object arg) {

		int[] d = (int[]) arg;

		String date = d[0]+"/"+d[1]+"/"+d[2];

		label.setText("la date acctuelle : "+ date);
	}



}
