package ClassiSfida;

import prog.utili.Orario;

public class SfidaNormale extends Sfida {
	
	String luogoSfida;
	
	public SfidaNormale(String luogoSfida, String videogame, String descrizione, String giocatore1, String giocatore2, Orario orario, Validit‡ validit‡) throws OrarioNonValidoException {
		super(videogame, descrizione, giocatore1, giocatore2, orario, validit‡, TipoSfida.NORMALE);
		this.luogoSfida = luogoSfida;
		
	}
	
	public SfidaNormale(String luogoSfida, int ID, String videogame, String descrizione, String giocatore1, String giocatore2, Orario orario, Validit‡ validit‡) throws IDGi‡UsatoException, OrarioNonValidoException {
		super(ID, videogame, descrizione, giocatore1, giocatore2, orario, validit‡, TipoSfida.NORMALE);
		this.luogoSfida = luogoSfida;
	}

	@Override
	public int calcolaPunteggio() {
		if(this.orario.compareTo(new Orario("12:00")) < 0)
			return 200;
		else
			return 300;
	}

}
