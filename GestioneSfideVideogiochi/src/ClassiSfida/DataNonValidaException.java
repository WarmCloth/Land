package ClassiSfida;

public class DataNonValidaException extends Exception {
	
	public DataNonValidaException() {
		super("Errore: data non valida, la sfida pu� avvenire oggi o un giorno successivo.");
	}

}
