package ClassiSfida;

public class IDGi‡UsatoException extends Exception { //da gestire nell'inserimento di una nuova sfida nel gestore
	
	public IDGi‡UsatoException() {
		super("Errore: ID gi‡ utilizzato, provare di nuovo.");
	}
}