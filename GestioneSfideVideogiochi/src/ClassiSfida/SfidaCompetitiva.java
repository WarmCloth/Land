package ClassiSfida;

import prog.utili.Orario;

public class SfidaCompetitiva extends Sfida {
	
	int punteggioGioco;
	
	public SfidaCompetitiva(int punteggioGioco, String videogame, String descrizione, String giocatore1, String giocatore2, Orario orario, Validit‡ validit‡) throws PunteggioGiocoNonValidoException, OrarioNonValidoException {
		super(videogame, descrizione, giocatore1, giocatore2, orario, validit‡, TipoSfida.NORMALE);
		if(punteggioGioco < 1 || punteggioGioco > 10)
			throw new PunteggioGiocoNonValidoException();
		this.punteggioGioco = punteggioGioco;
		
	}
	
	public SfidaCompetitiva(int punteggioGioco, int ID, String videogame, String descrizione, String giocatore1, String giocatore2, Orario orario, Validit‡ validit‡) throws IDGi‡UsatoException, PunteggioGiocoNonValidoException, OrarioNonValidoException {
		super(ID, videogame, descrizione, giocatore1, giocatore2, orario, validit‡, TipoSfida.NORMALE);
		if(punteggioGioco < 1 || punteggioGioco > 10)
			throw new PunteggioGiocoNonValidoException();
		this.punteggioGioco = punteggioGioco;
	}

	@Override
	public int calcolaPunteggio() {
		return (1000 + (this.punteggioGioco * 500));
	}

}

class PunteggioGiocoNonValidoException extends Exception {
	
	public PunteggioGiocoNonValidoException() {
		super("Errore: il punteggio del gioco dev'essere compreso tra 1 e 10");
	}
}
