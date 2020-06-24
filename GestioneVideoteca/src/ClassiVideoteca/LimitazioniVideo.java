package ClassiVideoteca;

public enum LimitazioniVideo {
	
	BOLLINO_VERDE(0), BOLLINO_GIALLO(14), BOLLINO_ROSSO(18);
	
	int et‡Minima;
	
	private LimitazioniVideo(int i) {
		this.et‡Minima = i;
	}

}
