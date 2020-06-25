package Classi;

import prog.utili.Data;
import prog.utili.Orario;

public class Volo {
	
	int ID;
	String origine;
	String destinazione; //3 lettere maiuscole
	Data data;
	Orario orarioPartenza;
	int numMaxPasseggeri;
	
	private static int IDs = 0;
	
	public Volo(String origine, String destinazione, String data, String orarioPartenza, int numMaxPasseggeri) {
		this.origine = origine;
		this.destinazione = destinazione;
		this.data = new Data(data);
		this.orarioPartenza = new Orario(orarioPartenza);
		
	}

}
