package ClassiPratiche;

public class Cliente {
	
	String nome;
	String cognome;
	byte et�;
	String codiceFiscale;
	boolean cittadinanzaItaliana;
	
	public Cliente(String nome, String cognome, int et�, String codiceFiscale, boolean cittadinanzaItaliana) {
		this.nome = nome;
		this.cognome = cognome;
		this.et� = (byte)et�;
		this.codiceFiscale = codiceFiscale;
		this.cittadinanzaItaliana = cittadinanzaItaliana;
	}

}
