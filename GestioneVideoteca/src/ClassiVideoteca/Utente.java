package ClassiVideoteca;

import java.text.DecimalFormat;
import java.util.ArrayList;

public abstract class Utente {
	
	public String ID;
	public ArrayList<Video> videoInPrestito;
	
	private static int IDs = 0;
	
	public Utente(char tipoUtente) {
		this.ID = generaID(tipoUtente);
		this.videoInPrestito = new ArrayList<Video>();
	}

	private String generaID(char tipoUtente) {
		DecimalFormat df = new DecimalFormat("00000");
		if(tipoUtente == 'P')
			return "UP" + df.format(IDs++);
		else
			return "UE" + df.format(IDs++);
	}

}
