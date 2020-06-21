package ClassiSfida;

import java.util.ArrayList;

import prog.utili.Data;
import prog.utili.Orario;

public abstract class Sfida implements Comparable<Sfida> {
	
	String ID;
	String videogame;
	String descrizione;
	Data data;
	Orario orario;
	public String giocatore1;
	public String giocatore2;
	Validit‡ validit‡;
		
	private static int IDsP = 0;
	private static int IDsN = 0;
	private static int IDsC = 0;
	public static ArrayList<String> listaID = new ArrayList<String>();
	
	public Sfida(String videogame, String descrizione, String giocatore1, String giocatore2, Data data, Orario orario, Validit‡ validit‡, TipoSfida tipo) throws OrarioNonValidoException, DataNonValidaException {
		this.videogame = videogame; 
		this.descrizione = descrizione;
		this.giocatore1 = giocatore1;
		this.giocatore2 = giocatore2;
		if(orario.compareTo(new Orario("07:00")) < 0 || orario.compareTo(new Orario("24:00")) > 0)
			throw new OrarioNonValidoException();
		this.orario = orario;
		if(data.quantoManca(new Data()) > 0)
			throw new DataNonValidaException();
		this.data = data;
		this.validit‡ = validit‡;
		this.ID = generaID(tipo);
		listaID.add(this.ID);
	}
	
	public Sfida(int ID, String videogame, String descrizione, String giocatore1, String giocatore2, Data data, Orario orario, Validit‡ validit‡, TipoSfida tipo) throws IDGi‡UsatoException, OrarioNonValidoException, DataNonValidaException {
		this(videogame, descrizione, giocatore1, giocatore2, data, orario, validit‡, TipoSfida.PACIFICA);
		this.ID = generaID(tipo, ID);
		listaID.add(this.ID);
	}
	
	public abstract int calcolaPunteggio();

	private String generaID(TipoSfida tipo) {
		switch (tipo) {
		case PACIFICA:
			for(int i=0; i<listaID.size(); i++) {
				if(listaID.get(i).substring(1).equals(String.valueOf(IDsP)) && listaID.get(i).substring(0, 1).equals("P")) {
					IDsP++;
					i=0;
				}
			}
			return "P" + IDsP++;			
		case NORMALE:
			for(int i=0; i<listaID.size(); i++) {
				if(listaID.get(i).substring(1).equals(String.valueOf(IDsN)) && listaID.get(i).substring(0, 1).equals("N")) {
					IDsN++;
					i=0;
				}
			}
			return "N" + IDsN++;
		case COMPETIZIONE:
			for(int i=0; i<listaID.size(); i++) {
				if(listaID.get(i).substring(1).equals(String.valueOf(IDsC)) && listaID.get(i).substring(0, 1).equals("C")) {
					IDsC++;
					i=0;
				}
			}
			return "C" + IDsC++;
		}
		return null;
	}
	
	private String generaID(TipoSfida tipo, int ID) throws IDGi‡UsatoException {
		
		switch (tipo) {
		case PACIFICA:
			for(String s: listaID) {
				if(s.substring(1).equals(String.valueOf(ID)) && s.substring(0, 1).equals("P"))
					throw new IDGi‡UsatoException();
			}
			return "P" + ID;
		case NORMALE:
			for(String s: listaID) {
				if(s.substring(1).equals(String.valueOf(ID)) && s.substring(0, 1).equals("N"))
					throw new IDGi‡UsatoException();
			}
			return "N" + ID;
		case COMPETIZIONE:
			for(String s: listaID) {
				if(s.substring(1).equals(String.valueOf(ID)) && s.substring(0, 1).equals("C"))
					throw new IDGi‡UsatoException();
			}
			return "C" + ID;
		}
		return null;
	}
	
	public String getID() {
		return this.ID;
	}
	
	@Override
	public String toString() {
		return ("|" + this.ID + "\t|" + this.data + "\t|" + this.orario + "\t" +
				String.format("|%-119s|", (this.descrizione + " - Validit‡: " + this.validit‡.toString() + " - Giocatore1: "+ this.giocatore1 + " - Giocatore2: " + this.giocatore2)) + this.calcolaPunteggio() + "\t\t|");
	}
	
	@Override
	public int compareTo(Sfida o) {
		int cmd = this.data.compareTo(o.data);
		if(cmd == 0) {
			return this.orario.compareTo(o.orario);
		}else
			return cmd;
	}

}




