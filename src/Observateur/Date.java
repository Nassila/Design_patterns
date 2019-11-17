package Observateur;

import java.util.Calendar;

public class Date extends SujetObserve{
	
	public void setDate(){
		
		while(true){
              
			Calendar calendrier = Calendar.getInstance();
			//recuperer les parametres de la date d'aujourd'hui
			int j = calendrier.get(Calendar.DAY_OF_MONTH);
			int m = calendrier.get(Calendar.MONTH);
			int a = calendrier.get(Calendar.YEAR);
			
			int[] date ={j,m,a};
			//notifier les observateurs du changement de la date
			this.notifier(date);
			
			

		}
}
	

}
