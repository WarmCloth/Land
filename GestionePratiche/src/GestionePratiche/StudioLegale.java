package GestionePratiche;

import java.util.ArrayList;
import java.util.Collections;

import ClassiPratiche.Cliente;
import ClassiPratiche.GradoNonAumentabileException;
import ClassiPratiche.PraticaCivile;
import ClassiPratiche.PraticaConciliazione;
import ClassiPratiche.PraticaLegale;
import ClassiPratiche.PraticaPenale;
import ClassiPratiche.StatoPratica;
import prog.io.FileInputManager;
import prog.io.FileNonPresenteException;
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
	
	public void sortPriorità() {
		boolean ordinato = true;
		do {
			ordinato = true;
			for(int i=0; i<this.pratiche.size()-1; i++) {
				if(this.pratiche.get(i).calcolaPriorità() > this.pratiche.get(i+1).calcolaPriorità()) {
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
	
	public void stampaPerPriorità() {
		this.sortPriorità();
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
	
	public void incrementaGradoGudizio(String ID) {
		for(PraticaLegale p: this.pratiche) {
			try {
				if(p instanceof PraticaPenale && p.ID.equals(ID)) {
					((PraticaPenale)p).gradoGiudizio = ((PraticaPenale)p).gradoGiudizio.next();
				}
				if(p instanceof PraticaCivile && p.ID.equals(ID)) {
					((PraticaCivile)p).gradoGiudizio = ((PraticaCivile)p).gradoGiudizio.next();
				}
			} catch (GradoNonAumentabileException e) {
				System.err.println("Errore: grado non aumentabile");
			}
		}
	}
	
	public void changeStatoPratica(String ID, StatoPratica nuovoStato) {
		for(PraticaLegale p: this.pratiche) {
			if(p.ID.equals(ID)) {
				p.changeStatoPratica(nuovoStato);
				return;
			}
		}
		System.err.println("Errore: ID pratica non trovato.");
	}
	
	public void praticheDaFile() {
		if(FileInputManager.exists("pratiche.txt")) {
			FileInputManager fin = new FileInputManager("pratiche.txt");
			String riga;
			String[] dati;
			StatoPratica stato;
			while((riga = fin.readLine()) != null) {
				dati = riga.split(";");
				Cliente cliente = creaCliente(dati);
				Data data;
				if(dati[1].equalsIgnoreCase("oggi"))
					data = new Data();
				else
					data = new Data(dati[1]);
				PraticaLegale pratica;
				if(dati[8].equalsIgnoreCase("incorso"))
					stato = StatoPratica.IN_CORSO;
				else if(dati[8].equalsIgnoreCase("archiviata"))
					stato = StatoPratica.ARCHIVIATA;
				else
					stato = StatoPratica.CHIUSA;
				switch (dati[0]) {
				case "PN":
					pratica = new PraticaPenale(data, dati[2], cliente, stato);
					this.pratiche.add(pratica);
					break;
				case "CV":
					pratica = new PraticaCivile(data, dati[2], cliente, stato);
					this.pratiche.add(pratica);
					break;
				case "CN":
					pratica = new PraticaCivile(data, dati[2], cliente, stato);
					this.pratiche.add(pratica);
				}
				
			}
		}else
			throw new FileNonPresenteException("Errore: file non trovato");
	}
	
	private static Cliente creaCliente(String[] dati) {
		if(dati[7].equalsIgnoreCase("si"))
			return new Cliente(dati[3], dati[4], Integer.valueOf(dati[5]), dati[6], true);
		else
			return new Cliente(dati[3], dati[4], Integer.valueOf(dati[5]), dati[6], false);
	}
	
	public static void main(String[] args) {
		
		StudioLegale santaniello = new StudioLegale();
		santaniello.addPraticaCivile(new Data("20.08.2020"), "Divorzio", new Cliente("Stefano", "Masserini", 27, "SFNMSN93H60A246Q", true), StatoPratica.IN_CORSO);
		santaniello.addPraticaPenale(new Data(), "Divorzio", new Cliente("Stefano", "Masserini", 27, "SFNMSN93H60A246Q", true), StatoPratica.IN_CORSO);;
		santaniello.addPraticaConciliazione(new Data("20.08.2020"), "Divorzio", new Cliente("Stefano", "Masserini", 27, "SFNMSN93H60A246Q", true), StatoPratica.ARCHIVIATA);
		santaniello.addOreLavoro(10, "CV0");
		santaniello.stampaPerCosto();
		santaniello.incrementaGradoGudizio("CV0");
		santaniello.incrementaGradoGudizio("CV0");
		santaniello.changeStatoPratica("CV0", StatoPratica.CHIUSA);
		System.out.println();
		santaniello.stampaArchiviatePerCosto();
		System.out.println();
		santaniello.stampaPerPriorità();
		System.out.println();
		
		santaniello.praticheDaFile();
		santaniello.incrementaGradoGudizio("PN4");
		santaniello.stampaPerPriorità();
		
		
	} 
	

}























