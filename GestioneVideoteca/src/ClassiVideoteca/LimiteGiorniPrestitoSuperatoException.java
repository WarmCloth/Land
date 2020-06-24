package ClassiVideoteca;

public class LimiteGiorniPrestitoSuperatoException extends Exception {
	
	public LimiteGiorniPrestitoSuperatoException() {
		super("Errore: Giorni di prestito oltre il limite consentito.");
	}

}
