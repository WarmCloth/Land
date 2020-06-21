package ClassiSfida;

public class PunteggioGiocoNonValidoException extends Exception {
	
	public PunteggioGiocoNonValidoException() {
		super("Errore: il punteggio del gioco dev'essere compreso tra 1 e 10.");
	}
}