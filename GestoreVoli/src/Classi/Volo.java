package Classi;

import java.text.DecimalFormat;
import java.util.ArrayList;

import Eccezioni.IDnonDiponibileException;
import prog.utili.Data;
import prog.utili.Orario;

public class Volo {
	
	String ID;
	String origine;
	String destinazione; //3 lettere maiuscole
	Data data;
	Orario orarioPartenza;
	int numMaxPasseggeri;
	
	private static int IDs = 0;
	private static ArrayList<String> listaIDvoli = new ArrayList<String>();
	
	public Volo(String origine, String destinazione, String data, String orarioPartenza, int numMaxPasseggeri) {
		this.origine = origine;
		this.destinazione = destinazione;
		this.data = new Data(data);
		this.orarioPartenza = new Orario(orarioPartenza);
		this.numMaxPasseggeri = numMaxPasseggeri;
		this.ID = generaID();
		listaIDvoli.add(this.ID);
	}
	
	public Volo(String ID, String origine, String destinazione, String data, String orarioPartenza, int numMaxPasseggeri) {
		this.origine = origine;
		this.destinazione = destinazione;
		this.data = new Data(data);
		this.orarioPartenza = new Orario(orarioPartenza);
		this.numMaxPasseggeri = numMaxPasseggeri;
		try {			
			this.ID = checkID(ID);
			listaIDvoli.add(this.ID);
		} catch (IDnonDiponibileException e) {
			System.err.println("Errore: ID non disponibile.");
		}
		
	}

	private static String checkID(String ID) throws IDnonDiponibileException {
		DecimalFormat df = new DecimalFormat("00000");		
		for(String s: Volo.listaIDvoli) {
			if(s.equals(df.format(Integer.valueOf(ID))))
				throw new IDnonDiponibileException();
		}
		return df.format(Integer.valueOf(ID));
	}

	private String generaID() {
		DecimalFormat df = new DecimalFormat("00000");		
		IDs++;
		String ID = String.valueOf(IDs);
		for(String s: this.listaIDvoli) {
			if(s.equals(df.format(IDs))) {
				ID = this.generaID(); 
			}
		}
		return df.format(Integer.valueOf(ID));
	}
	
	

}
