package ClassiVideoteca;

public class UtentePrivato extends Utente {
	
	String nome;
	String cognome;
	int et�;
	
	public UtentePrivato(String nome, String cognome, int et�) {
		super('P');
		this.nome = nome;
		this.cognome = cognome;
		this.et� = et�;
	}
	

}
