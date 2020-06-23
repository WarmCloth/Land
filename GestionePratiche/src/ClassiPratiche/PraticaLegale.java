package ClassiPratiche;

import prog.utili.Data;

public abstract class PraticaLegale implements Comparable<PraticaLegale>{
	
	public String ID;
	Data dataUdienza;
	String descrizione;
	Cliente cliente;
	public StatoPratica stato;
	int orePratica = 0;
	int prioritą;
	
	private static int IDsPN = 0;
	private static int IDsCV = 0;
	private static int IDsCN = 0;
	
	public PraticaLegale(Data dataUdienza, String descrizione, Cliente cliente, StatoPratica stato, TipologiaPratica tipologia) {
		this.dataUdienza = dataUdienza;
		this.descrizione = descrizione;
		this.cliente = cliente;
		this.stato = stato;
		this.ID = GeneraID(tipologia);
	}
	
	@Override
	public int compareTo(PraticaLegale o) {
		return Float.valueOf(this.calcolaCosto()).compareTo(o.calcolaCosto());
	}
	
	@Override
	public String toString() {
		return "Pratica " + this.ID + " - Descrizione: " + this.descrizione + " Cliente: " + this.cliente.nome + " " + this.cliente.cognome + " - Stato: " + this.stato.toString() + " - Prioritą: " + this.calcolaPrioritą() + " - Costo: " + this.calcolaCosto();
	}

	private String GeneraID(TipologiaPratica tipologia) {
		switch (tipologia) {
		case PENALE:
			return "PN" + IDsPN++;
		case CIVILE:
			return "CV" + IDsCV++;
		case CONCILIAZIONE:
			return "CN" + IDsCN++;
		}
		return null;
	}
	
	public void addOreLavoro(int ore) {
		this.orePratica += ore;
	}
	
	public void changeStatoPratica(StatoPratica nuovoStato) {
		this.stato = nuovoStato;
	}
	
	public int calcolaPrioritą() {
		if(this.stato == StatoPratica.CHIUSA || this.stato == StatoPratica.ARCHIVIATA) {
			this.prioritą = 1000;
			return 1000;
		}
		Data oggi = new Data();
		if(oggi.quantoManca(this.dataUdienza) < 0) {
			this.prioritą = Integer.MAX_VALUE;
			return this.prioritą;
		}else {
			this.prioritą = oggi.quantoManca(this.dataUdienza);
			return this.prioritą;
		}		
	}
	
	public abstract float calcolaCosto();

}
