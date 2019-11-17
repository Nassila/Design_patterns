package Observateur;

import java.util.Calendar;

@SuppressWarnings("deprecation")
public class Horloge extends SujetObserve{
	
	public void setHeure(){
		while(true){

			Calendar calendrier = Calendar.getInstance();
			//recuperer les parametres de l'heure actuelle
			int h = calendrier.get(Calendar.HOUR_OF_DAY);
			int m = calendrier.get(Calendar.MINUTE);
			int s = calendrier.get(Calendar.SECOND);
			
			int[] heure ={h,m,s};
			//notifier les observateurs du changement d'heure
			this.notifier(heure);

		}
	}


}
