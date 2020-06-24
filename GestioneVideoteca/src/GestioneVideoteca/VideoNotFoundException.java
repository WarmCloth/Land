package GestioneVideoteca;

public class VideoNotFoundException extends Exception {
	
	public VideoNotFoundException() {
		super("Errore: Video non trovato.");
	}

}
