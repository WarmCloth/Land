package ClassiSfida;

import prog.utili.Data;
import prog.utili.Orario;

public class SfidaCompetitiva extends Sfida {
	
	int punteggioGioco;
	
	public SfidaCompetitiva(int punteggioGioco, String videogame, String descrizione, String giocatore1, String giocatore2, Data data, Orario orario, Validit‡ validit‡) throws PunteggioGiocoNonValidoException, OrarioNonValidoException, DataNonValidaException {
		super(videogame, descrizione, giocatore1, giocatore2, data, orario, validit‡, TipoSfida.COMPETIZIONE);
		if(punteggioGioco < 1 || punteggioGioco > 10)
			throw new PunteggioGiocoNonValidoException();
		this.punteggioGioco = punteggioGioco;
		
	}
	
	public SfidaCompetitiva(int punteggioGioco, int ID, String videogame, String descrizione, String giocatore1, String giocatore2, Data data, Orario orario, Validit‡ validit‡) throws IDGi‡UsatoException, PunteggioGiocoNonValidoException, OrarioNonValidoException, DataNonValidaException {
		super(ID, videogame, descrizione, giocatore1, giocatore2, data, orario, validit‡, TipoSfida.COMPETIZIONE);
		if(punteggioGioco < 1 || punteggioGioco > 10)
			throw new PunteggioGiocoNonValidoException();
		this.punteggioGioco = punteggioGioco;
	}

	@Override
	public int calcolaPunteggio() {
		return (1000 + (this.punteggioGioco * 500));
	}

}


