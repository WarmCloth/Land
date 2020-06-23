package ClassiPratiche;

import prog.utili.Data;

public class PraticaPenale extends PraticaLegale{
	
	public GradoGiudizio gradoGiudizio;
	
	public PraticaPenale(Data dataUdienza, String descrizione, Cliente cliente, StatoPratica stato) {
		super(dataUdienza, descrizione, cliente, stato, TipologiaPratica.PENALE);
		this.gradoGiudizio = GradoGiudizio.PRIMO_GRADO;
	}
	
	public void incrementaGradoGiudizio() throws GradoNonAumentabileException {
		this.gradoGiudizio = this.gradoGiudizio.next();
	}
	
	@Override
	public String toString() {
		return super.toString() + " - Grado: " + this.gradoGiudizio;
	}
	
	@Override
	public float calcolaCosto() {
		return this.gradoGiudizio.getGrado() * this.orePratica * 100;
	}

}
