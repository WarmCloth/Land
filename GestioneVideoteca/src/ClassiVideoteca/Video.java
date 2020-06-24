package ClassiVideoteca;

import java.text.DecimalFormat;

public class Video implements Comparable<Video>{
	
	public int ID;
	public String titolo;
	public String trama;
	public String regista;
	public int anno;
	public GenereVideo genere;	
	LimitazioniVideo limitazioni;
	int giorniMaxPrestito;
	public boolean disponibile;
	
	private static int IDs = 0;
	
	public Video(String titolo, String trama, String regista, int anno, GenereVideo genere) {
		this.ID = generaID();
		this.titolo = titolo;
		this.trama = trama;
		this.regista = regista;
		this.anno = anno;
		this.genere = genere;
		this.giorniMaxPrestito = 10;
		this.disponibile = true;
		switch (this.genere) {
		case CARTONE_ANIMATO:
		case DOCUMENTARIO:
			this.limitazioni = LimitazioniVideo.BOLLINO_VERDE;
		case FANTASY:
		case FANTASCIENZA:
		case ROMANTICO:
		case AZIONE:
			this.limitazioni = LimitazioniVideo.BOLLINO_GIALLO;
		case THRILLER:
		case HORROR:
			this.limitazioni = LimitazioniVideo.BOLLINO_ROSSO;
		}		
	}
	
	private int generaID() {
		DecimalFormat df = new DecimalFormat("0000");
		return Integer.valueOf(df.format(IDs++));
	}

	public void forzaLimitazioni(LimitazioniVideo limitazione) {
		this.limitazioni = limitazione;
	}

	@Override
	public int compareTo(Video o) {
		return Integer.valueOf(this.anno).compareTo(o.anno);
	}
	
	@Override
	public String toString() {
		String s;
		if(this.disponibile == true)
			s = "si";
		else
			s = "no";
		return ("Titolo: " + this.titolo + " - Trama: " + this.trama + " - Regista: " + this.regista +
				" - Anno: " + this.anno + " - Genere: " + this.genere.toString() + " - Giorni di prestito: " + this.giorniMaxPrestito + 
				" - Disponibile: " + s);
	}	

}









