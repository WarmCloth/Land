package ClassiPratiche;

import prog.utili.Data;

public class PraticaConciliazione extends PraticaLegale {
	
	public PraticaConciliazione(Data dataUdienza, String descrizione, Cliente cliente, StatoPratica stato) {
		super(dataUdienza, descrizione, cliente, stato, TipologiaPratica.CONCILIAZIONE);
	}
	
	@Override
	public float calcolaCosto() {
		return this.orePratica * 100;
	}

}
