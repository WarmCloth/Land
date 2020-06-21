package ClassiSfida;

public class OrarioNonValidoException extends Exception {
	
	public OrarioNonValidoException() {
		super("Errore: l'orario dev'essere compreso tra le 7:00 e le 00:00");
	}
}
