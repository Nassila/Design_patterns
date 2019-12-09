package singleton;

public class SingletonClass {

	private static SingletonClass instanceClass;

	protected SingletonClass() {
	}

	public static SingletonClass getInstance() {

		// verifie si la classe a d�j� �t� instanci�e ou pas
		if (instanceClass == null) {
			instanceClass = new SingletonClass();

		}

		return instanceClass;
	}

	public static void main(String[] args) {
		SingletonClass singleton = SingletonClass.getInstance();

	}
}
