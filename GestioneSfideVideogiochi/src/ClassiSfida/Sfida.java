package ClassiSfida;

import java.util.ArrayList;

import prog.utili.Orario;

public abstract class Sfida implements Comparable<Sfida> {
	
	String ID;
	String videogame;
	String descrizione;
	Orario orario;
	String giocatore1;
	String giocatore2;
	Validit‡ validit‡;
		
	private static int IDs = 0;
	ArrayList<String> listaID = new ArrayList<String>();
	
	public Sfida(String videogame, String descrizione, String giocatore1, String giocatore2, Orario orario, Validit‡ validit‡, TipoSfida tipo) throws OrarioNonValidoException {
		this.videogame = videogame; 
		this.descrizione = descrizione;
		this.giocatore1 = giocatore1;
		this.giocatore2 = giocatore2;
		if(orario.compareTo(new Orario("07:00")) < 0 || orario.compareTo(new Orario("00:00")) > 0)
			throw new OrarioNonValidoException();
		this.orario = orario;
		this.validit‡ = validit‡;
		this.ID = generaID(tipo);
		listaID.add(this.ID);
	}
	
	public Sfida(int ID, String videogame, String descrizione, String giocatore1, String giocatore2, Orario orario, Validit‡ validit‡, TipoSfida tipo) throws IDGi‡UsatoException, OrarioNonValidoException {
		this(videogame, descrizione, giocatore1, giocatore2, orario, validit‡, TipoSfida.PACIFICA);
		this.ID = generaID(tipo, ID);
		listaID.add(this.ID);
	}
	
	public abstract int calcolaPunteggio();

	private String generaID(TipoSfida tipo) {
		for(int i=0; i<listaID.size(); i++) {
			if(listaID.get(i).substring(1).equals(String.valueOf(IDs+1))) {
				IDs++;
				i=0;
			}
		}
		switch (tipo) {
		case PACIFICA:
			return "P" + IDs++;
		case NORMALE:
			return "N" + IDs++;
		case COMPETIZIONE:
			return "C" + IDs++;
		}
		return null;
	}
	
	private String generaID(TipoSfida tipo, int ID) throws IDGi‡UsatoException {
		for(String s: listaID) {
			if(s.substring(1).equals(String.valueOf(ID)))
				throw new IDGi‡UsatoException();
		}
		switch (tipo) {
		case PACIFICA:
			return "P" + ID;
		case NORMALE:
			return "N" + ID;
		case COMPETIZIONE:
			return "C" + ID;
		}
		return null;
	}

}




