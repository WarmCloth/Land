package ClassiPratiche;

import prog.utili.Data;

public class PraticaPenale extends PraticaLegale{
	
	GradoGiudizio gradoGiudizio;
	
	public PraticaPenale(Data dataUdienza, String descrizione, Cliente cliente, StatoPratica stato) {
		super(dataUdienza, descrizione, cliente, stato, TipologiaPratica.PENALE);
		this.gradoGiudizio = GradoGiudizio.PRIMO_GRADO;
	}
	
	public void aumentaGradoGiudizio() {
		if(this.gradoGiudizio == GradoGiudizio.PRIMO_GRADO) {
			this.gradoGiudizio = GradoGiudizio.APPELLO;
		}else if(this.gradoGiudizio == GradoGiudizio.APPELLO) {
			this.gradoGiudizio = GradoGiudizio.CASSAZIONE;
		}else
			System.err.println("Errore: il grado di giudizio è al massimo");
	}
	
	@Override
	public float calcolaCosto() {
		return this.gradoGiudizio.getGrado() * this.orePratica * 100;
	}

}
