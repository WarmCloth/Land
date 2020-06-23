package ClassiPratiche;

import prog.utili.Data;

public class PraticaCivile extends PraticaLegale {
	
	public GradoGiudizio gradoGiudizio;
	
	public PraticaCivile(Data dataUdienza, String descrizione, Cliente cliente, StatoPratica stato) {
		super(dataUdienza, descrizione, cliente, stato, TipologiaPratica.CIVILE);
		this.gradoGiudizio = GradoGiudizio.PRIMO_GRADO;
	}	
	
	@Override
	public String toString() {
		return super.toString() + " - Grado: " + this.gradoGiudizio;
	}
	
	@Override
	public float calcolaCosto() {
		return this.gradoGiudizio.getGrado() * this.orePratica * 100;
	}
	
	public void incrementaGradoGiudizio() throws GradoNonAumentabileException {
		this.gradoGiudizio = this.gradoGiudizio.next();
	}

}
