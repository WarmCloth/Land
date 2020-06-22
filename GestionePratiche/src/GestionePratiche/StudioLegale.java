package GestionePratiche;

import java.util.ArrayList;
import java.util.Collections;

import ClassiPratiche.Cliente;
import ClassiPratiche.PraticaCivile;
import ClassiPratiche.PraticaConciliazione;
import ClassiPratiche.PraticaLegale;
import ClassiPratiche.PraticaPenale;
import ClassiPratiche.StatoPratica;
import prog.utili.Data;

public class StudioLegale {
	
	ArrayList<PraticaLegale> pratiche;
	
	public StudioLegale() {
		pratiche = new ArrayList<PraticaLegale>();
	}
	
	public void addPraticaPenale(Data dataUdienza, String descrizione, Cliente cliente, StatoPratica stato) {
		PraticaLegale pratica = new PraticaPenale(dataUdienza, descrizione, cliente, stato);
		this.pratiche.add(pratica);
	}
	
	public void addPraticaCivile(Data dataUdienza, String descrizione, Cliente cliente, StatoPratica stato) {
		PraticaLegale pratica = new PraticaCivile(dataUdienza, descrizione, cliente, stato);
		this.pratiche.add(pratica);
	}
	
	public void addPraticaConciliazione(Data dataUdienza, String descrizione, Cliente cliente, StatoPratica stato) {
		PraticaLegale pratica = new PraticaConciliazione(dataUdienza, descrizione, cliente, stato);
		this.pratiche.add(pratica);
	}
	
	public void sortPriorit�() {
		boolean ordinato = true;
		do {
			ordinato = true;
			for(int i=0; i<this.pratiche.size()-1; i++) {
				if(this.pratiche.get(i).calcolaPriorit�() > this.pratiche.get(i+1).calcolaPriorit�()) {
					Collections.swap(this.pratiche, i, i+1);
					ordinato = false;
				}
			}
		}while(!ordinato);
	}
	
	public void stampaPerCosto() {
		Collections.sort(this.pratiche);
		for(PraticaLegale p: this.pratiche) {
			System.out.println(p);
		}
	}
	
	public void stampaPerPriorit�() {
		this.sortPriorit�();
		for(PraticaLegale p: this.pratiche) {
			System.out.println(p);
		}
	}
	
	public void stampaArchiviatePerCosto() {
		Collections.sort(this.pratiche);
		for(PraticaLegale p: this.pratiche) {
			if(p.stato == StatoPratica.ARCHIVIATA)
				System.out.println(p);
		}
	}
	
	public void addOreLavoro(int ore, String ID) {
		for(PraticaLegale p: this.pratiche) {
			if(p.ID.equals(ID)) {
				p.addOreLavoro(ore);
			}
		}
	}
	
	public static void main(String[] args) {
		
		StudioLegale santaniello = new StudioLegale();
		santaniello.addPraticaCivile(new Data("20.08.2020"), "Divorzio", new Cliente("Stefano", "Masserini", 27, "SFNMSN93H60A246Q", true), StatoPratica.IN_CORSO);
		santaniello.addPraticaPenale(new Data(), "Divorzio", new Cliente("Stefano", "Masserini", 27, "SFNMSN93H60A246Q", true), StatoPratica.IN_CORSO);;
		santaniello.addPraticaConciliazione(new Data("20.08.2020"), "Divorzio", new Cliente("Stefano", "Masserini", 27, "SFNMSN93H60A246Q", true), StatoPratica.ARCHIVIATA);
		santaniello.addOreLavoro(10, "CV0");
		santaniello.stampaPerCosto();
		System.out.println();
		santaniello.stampaArchiviatePerCosto();
		System.out.println();
		santaniello.stampaPerPriorit�();
		System.out.println();
		
	} //sistemare i vari metodi come ho fatto con addorelavoro ma per cambio gradogiudizio e statopratica + caricamento da file
	

}























