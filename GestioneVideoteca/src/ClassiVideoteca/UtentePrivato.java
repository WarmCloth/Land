package ClassiVideoteca;

public class UtentePrivato extends Utente {
	
	String nome;
	String cognome;
	int età;
	
	public UtentePrivato(String nome, String cognome, int età) {
		super('P');
		this.nome = nome;
		this.cognome = cognome;
		this.età = età;
	}
	

}
