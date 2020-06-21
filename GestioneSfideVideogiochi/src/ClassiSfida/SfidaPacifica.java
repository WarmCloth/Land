package ClassiSfida;

import prog.utili.Data;
import prog.utili.Orario;

public class SfidaPacifica extends Sfida {
	
	public SfidaPacifica(String videogame, String descrizione, String giocatore1, String giocatore2, Data data, Orario orario, Validit‡ validit‡) throws OrarioNonValidoException, DataNonValidaException {
		super(videogame, descrizione, giocatore1, giocatore2, data, orario, validit‡, TipoSfida.PACIFICA);
	}
	
	public SfidaPacifica(int ID, String videogame, String descrizione, String giocatore1, String giocatore2, Data data, Orario orario, Validit‡ validit‡) throws IDGi‡UsatoException, OrarioNonValidoException, DataNonValidaException {
		super(ID, videogame, descrizione, giocatore1, giocatore2, data, orario, validit‡, TipoSfida.PACIFICA);
	}

	@Override
	public int calcolaPunteggio() {
		if(this.validit‡ == Validit‡.CAMPIONATO)
			return 100;
		else
			return 10;
	}

}
