package ClassiVideoteca;

public class LimitazioneVideoException extends Exception {
	
	public LimitazioneVideoException() {
		super("Errore: Video proibito per utenti di et� inferiore a quella consentita.");
	}

}
