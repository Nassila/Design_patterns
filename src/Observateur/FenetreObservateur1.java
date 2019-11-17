package Observateur;


import javax.swing.JFrame;
import javax.swing.JLabel;

public class FenetreObservateur1 extends JFrame implements Observateur{
	private JLabel label;

	public FenetreObservateur1() {
		//taille de la fenetre
		setSize(260,100);
		//centrer l'apparition de la fenetre
		setLocationRelativeTo(this);
		//rendre la fenetre visible
		setVisible(true);
		//titre de la fenetre
		setTitle("Observateur 1");
		//arreter l'execution à la fermeture de la fenetre
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//ajout d'un label à la fentre pour pouvoir affichier l'heure dans le fenetre
		label=new JLabel("");
		add(label);
	}

	public void mise_a_jour(Object arg) {

		int[] h = (int[]) arg;

		String heure = h[0]+":"+h[1]+":"+h[2];

		label.setText("l'heure acctuelle : "+ heure);
	}



}
