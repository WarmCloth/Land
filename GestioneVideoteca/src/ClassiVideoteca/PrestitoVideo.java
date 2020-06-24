package ClassiVideoteca;

import java.text.DecimalFormat;

import prog.utili.Data;

public class PrestitoVideo {
	
	public String IDprestito;
	public Video video;
	public Utente utente;
	int giorniDiPrestito;
	
	private static int IDs = 0;
	
	public PrestitoVideo(Utente utente, Video video, int giorniDiPrestito) throws LimiteGiorniPrestitoSuperatoException, LimitazioneVideoException {
		this.IDprestito = generaID();
		this.utente = utente;
		this.video = video;
		if(giorniDiPrestito > video.giorniMaxPrestito)
			throw new LimiteGiorniPrestitoSuperatoException();
		if(utente instanceof UtentePrivato && video.limitazioni.etàMinima > ((UtentePrivato)utente).età)
			throw new LimitazioneVideoException();
		this.giorniDiPrestito = giorniDiPrestito;
	}

	private String generaID() {
		DecimalFormat df = new DecimalFormat("0000");
		DecimalFormat df2 = new DecimalFormat("00");
		Data a = new Data();
		return String.valueOf(df2.format(a.getAnno())) + String.valueOf(df2.format(a.getMese())) + df.format(IDs++);		
	}

}
