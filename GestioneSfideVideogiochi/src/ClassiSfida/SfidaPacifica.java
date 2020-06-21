package ClassiSfida;

import prog.utili.Orario;

public class SfidaPacifica extends Sfida {
	
	public SfidaPacifica(String videogame, String descrizione, String giocatore1, String giocatore2, Orario orario, Validit‡ validit‡) throws OrarioNonValidoException {
		super(videogame, descrizione, giocatore1, giocatore2, orario, validit‡, TipoSfida.PACIFICA);
	}
	
	public SfidaPacifica(int ID, String videogame, String descrizione, String giocatore1, String giocatore2, Orario orario, Validit‡ validit‡) throws IDGi‡UsatoException, OrarioNonValidoException {
		super(ID, videogame, descrizione, giocatore1, giocatore2, orario, validit‡, TipoSfida.PACIFICA);
	}

	@Override
	public int calcolaPunteggio() {
		if(this.validit‡ == Validit‡.CAMPIONATO)
			return 100;
		else
			return 10;
	}

	@Override
	public int compareTo(Sfida o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
