package ClassiPratiche;

public class Cliente {
	
	String nome;
	String cognome;
	byte età;
	String codiceFiscale;
	boolean cittadinanzaItaliana;
	
	public Cliente(String nome, String cognome, int età, String codiceFiscale, boolean cittadinanzaItaliana) {
		this.nome = nome;
		this.cognome = cognome;
		this.età = (byte)età;
		this.codiceFiscale = codiceFiscale;
		this.cittadinanzaItaliana = cittadinanzaItaliana;
	}

}
