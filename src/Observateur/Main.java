package Observateur;

public class Main {
	public static void main(String[] args) throws InterruptedException {
		MyThread thread =new MyThread();//create the thread thread
		thread.start();//start the thread thread

		Horloge horloge =new Horloge(); 
		FenetreObservateur1 ob1 = new FenetreObservateur1();

		horloge.abonner(ob1);

		while (true){
			Thread.sleep(1000);//sleep 1000 ms=1 second
			horloge.setHeure();
		}
	}

}

class MyThread extends Thread {
	@Override
	public void run() {

		while (true){

			Date date = new Date();
			FenetreObservaeur2 ob2 = new FenetreObservaeur2();
			date.abonner(ob2);


			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}

			date.setDate();

		}


	}

}
