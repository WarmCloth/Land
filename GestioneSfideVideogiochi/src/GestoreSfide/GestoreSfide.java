package GestoreSfide;

import java.util.ArrayList;
import java.util.Collections;

import ClassiSfida.DataNonValidaException;
import ClassiSfida.IDGiàUsatoException;
import ClassiSfida.OrarioNonValidoException;
import ClassiSfida.PunteggioGiocoNonValidoException;
import ClassiSfida.Sfida;
import ClassiSfida.SfidaCompetitiva;
import ClassiSfida.SfidaNormale;
import ClassiSfida.SfidaPacifica;
import ClassiSfida.Validità;
import prog.io.FileInputManager;
import prog.utili.Data;
import prog.utili.Orario;

public class GestoreSfide {
	
	ArrayList<Sfida> listaSfide;
	
	public GestoreSfide() {
		 listaSfide = new ArrayList<Sfida>();
	}
	
	public void addSfidaPacifica(String videogame, String descrizione, String giocatore1, String giocatore2, Data data, Orario orario, Validità validità) {
		SfidaPacifica sfida;
		try {
			sfida = new SfidaPacifica(videogame, descrizione, giocatore1, giocatore2, data, orario, validità);
		} catch (OrarioNonValidoException e) {
			System.err.println("Errore: l'orario dev'essere compreso tra le 07:00 e le 00:00");
			return;
		} catch (DataNonValidaException e) {
			System.err.println("Errore: data non valida, la sfida può avvenire oggi o un giorno successivo.");
			return;
		}
		listaSfide.add(sfida);
	}
	
	public void addSfidaPacificaConID(int ID, String videogame, String descrizione, String giocatore1, String giocatore2, Data data, Orario orario, Validità validità) {
		SfidaPacifica sfida;
		try {
			sfida = new SfidaPacifica(ID, videogame, descrizione, giocatore1, giocatore2, data, orario, validità);
		} catch (IDGiàUsatoException e) {
			System.err.println("Errore: ID già esistente.");
			return;
		} catch (OrarioNonValidoException e) {
			System.err.println("Errore: l'orario dev'essere compreso tra le 07:00 e le 00:00");
			return;
		} catch (DataNonValidaException e) {
			System.err.println("Errore: data non valida, la sfida può avvenire oggi o un giorno successivo.");
			return;
		}
		listaSfide.add(sfida);
	}
	
	public void addSfidaNormale(String luogoSfida, String videogame, String descrizione, String giocatore1, String giocatore2, Data data, Orario orario, Validità validità) {
		SfidaNormale sfida = null;
		try {
			sfida = new SfidaNormale(luogoSfida, videogame, descrizione, giocatore1, giocatore2, data, orario, validità);
		} catch (OrarioNonValidoException e) {
			System.err.println("Errore: l'orario dev'essere compreso tra le 07:00 e le 00:00");
			return;
		} catch (DataNonValidaException e) {
			System.err.println("Errore: data non valida, la sfida può avvenire oggi o un giorno successivo.");
			return;
		}
		listaSfide.add(sfida);
	}
	
	public void addSfidaNormaleConID(String luogoSfida, int ID, String videogame, String descrizione, String giocatore1, String giocatore2, Data data, Orario orario, Validità validità) {
		SfidaNormale sfida;
		try {
			sfida = new SfidaNormale(luogoSfida, ID, videogame, descrizione, giocatore1, giocatore2, data, orario, validità);
		} catch (IDGiàUsatoException e) {
			System.err.println("Errore: ID già esistente.");
			return;
		} catch (OrarioNonValidoException e) {
			System.err.println("Errore: l'orario dev'essere compreso tra le 07:00 e le 00:00");
			return;
		} catch (DataNonValidaException e) {
			System.err.println("Errore: data non valida, la sfida può avvenire oggi o un giorno successivo.");
			return;
		}
		listaSfide.add(sfida);
	}
	
	public void addSfidaCompetitiva(int punteggioGioco, String videogame, String descrizione, String giocatore1, String giocatore2, Data data, Orario orario, Validità validità) {
		SfidaCompetitiva sfida;
		try {
			sfida = new SfidaCompetitiva(punteggioGioco, videogame, descrizione, giocatore1, giocatore2, data, orario, validità);
		} catch (OrarioNonValidoException e) {
			System.err.println("Errore: l'orario dev'essere compreso tra le 07:00 e le 00:00");
			return;
		} catch (DataNonValidaException e) {
			System.err.println("Errore: data non valida, la sfida può avvenire oggi o un giorno successivo.");
			return;
		} catch (PunteggioGiocoNonValidoException e) {
			System.err.println("Errore: Errore: il punteggio del gioco dev'essere compreso tra 1 e 10.");
			return;
		}
		listaSfide.add(sfida);
	}
	
	public void addSfidaCompetitivaConID(int punteggioGioco, int ID, String videogame, String descrizione, String giocatore1, String giocatore2, Data data, Orario orario, Validità validità) {
		SfidaCompetitiva sfida;
		try {
			sfida = new SfidaCompetitiva(punteggioGioco, ID, videogame, descrizione, giocatore1, giocatore2, data, orario, validità);
		} catch (IDGiàUsatoException e) {
			System.err.println("Errore: ID già esistente.");
			return;
		} catch (OrarioNonValidoException e) {
			System.err.println("Errore: l'orario dev'essere compreso tra le 07:00 e le 00:00");
			return;
		} catch (DataNonValidaException e) {
			System.err.println("Errore: data non valida, la sfida può avvenire oggi o un giorno successivo.");
			return;
		} catch (PunteggioGiocoNonValidoException e) {
			System.err.println("Errore: Errore: il punteggio del gioco dev'essere compreso tra 1 e 10.");
			return;
		}
		listaSfide.add(sfida);
	}
	
	//se esiste più di una sfida con il giocatore cercato, ritorna quella che temporalmente si svolge per prima
	public Sfida cercaSfida(String giocatore) {
		Collections.sort(listaSfide);
		for(Sfida sf: listaSfide) {
			if(sf.giocatore1.equalsIgnoreCase(giocatore) || sf.giocatore2.equalsIgnoreCase(giocatore)) {
				return sf;
			}
		}
		return null;
	}
	
	public void stampaSfide() {
		Collections.sort(listaSfide);
		System.out.println("|ID\t|DATA\t\t|ORA\t|DESCRIZIONE\t\t\t\t\t\t\t\t\t\t\t\t\t\t|PUNTEGGIO\t|");
		for(Sfida sf: listaSfide) {
			System.out.println("=========================================================================================================================================================================");
			System.out.println(sf);
		}
		System.out.println("=========================================================================================================================================================================");
	}
	
	public void stampaSfidePerPunteggio() {
		this.sortPunteggio();
		System.out.println("|ID\t|DATA\t\t|ORA\t|DESCRIZIONE\t\t\t\t\t\t\t\t\t\t\t\t\t\t|PUNTEGGIO\t|");
		for(Sfida sf: listaSfide) {
			System.out.println("=========================================================================================================================================================================");
			System.out.println(sf);
		}
		System.out.println("=========================================================================================================================================================================");
	}
	
	private void sortPunteggio() {
		boolean ordinato = true;
		do {
			ordinato = true;
			for(int i=0; i<listaSfide.size()-1; i++) {
				if(listaSfide.get(i).calcolaPunteggio() < listaSfide.get(i+1).calcolaPunteggio()) {
					Collections.swap(listaSfide, i, i+1);
					ordinato = false;
				}
			}
		}while(!ordinato);		
	}
	
	public void sfideDaFile(){
		if(FileInputManager.exists("sfide.txt")) {
			FileInputManager fin = new FileInputManager("sfide.txt");
			String riga;
			String[] dati;
			while((riga = fin.readLine()) != null ) {
				dati = riga.split(";");
				Validità validità = null;
				if(dati[7].equalsIgnoreCase("amichevole"))
					validità = Validità.AMICHEVOLE;
				else if(dati[7].equalsIgnoreCase("campionato"))
					validità = Validità.CAMPIONATO;
				else
					throw new RuntimeException("Errore: validità sfida non corretta.");				
				switch (dati[0]) {
				case "P":
					if(dati[5].equalsIgnoreCase("oggi"))
						this.addSfidaPacifica(dati[1], dati[2], dati[3], dati[4], new Data(), new Orario(dati[6]), validità);
					else
						this.addSfidaPacifica(dati[1], dati[2], dati[3], dati[4], new Data(dati[5]), new Orario(dati[6]), validità);
					break;
				case "N":
					if(dati[5].equalsIgnoreCase("oggi"))
						this.addSfidaNormale(dati[8], dati[1], dati[2], dati[3], dati[4], new Data(), new Orario(dati[6]), validità);
					else
						this.addSfidaNormale(dati[8], dati[1], dati[2], dati[3], dati[4], new Data(dati[5]), new Orario(dati[6]), validità);
					break;
				case "C":
					if(dati[5].equalsIgnoreCase("oggi"))
						this.addSfidaCompetitiva(Integer.parseInt(dati[8]), dati[1], dati[2], dati[3], dati[4], new Data(), new Orario(dati[6]), validità);
					else
						this.addSfidaCompetitiva(Integer.parseInt(dati[8]), dati[1], dati[2], dati[3], dati[4], new Data(dati[5]), new Orario(dati[6]), validità);
					break;					
				}
			}
		}
		
	}

	public static void main(String[] args) {
		
		GestoreSfide gestore = new GestoreSfide();
		gestore.addSfidaPacifica("WoW", "Arena 1v1", "Rexal", "Souldead", new Data(), new Orario("08:00"), Validità.AMICHEVOLE);
		gestore.addSfidaPacifica("WoW", "Arena 1v1", "Rexal", "Souldead", new Data(), new Orario("12:00"), Validità.AMICHEVOLE);
		gestore.addSfidaPacifica("WoW", "Arena 1v1", "Rexal", "Souldead", new Data(), new Orario("10:00"), Validità.AMICHEVOLE);
		gestore.addSfidaPacifica("WoW", "Arena 1v1", "Rexal", "Souldead", new Data(), new Orario("15:00"), Validità.AMICHEVOLE);
		gestore.addSfidaPacifica("WoW", "Arena 1v1", "Rexal", "Souldead", new Data("24.08.2020"), new Orario("18:00"), Validità.AMICHEVOLE);
		gestore.addSfidaPacifica("WoW", "Arena 1v1", "Rexal", "Souldead", new Data("24.08.2020"), new Orario("15:00"), Validità.AMICHEVOLE);
		gestore.addSfidaPacifica("WoW", "Arena 1v1", "Rexal", "Souldead", new Data("24.08.2020"), new Orario("18:00"), Validità.AMICHEVOLE);
		gestore.addSfidaNormale("EsportPalace", "WoW", "Arena 1v1", "Nosferatu", "Souldead", new Data("20.07.2020"), new Orario("09:00"), Validità.CAMPIONATO);
		gestore.addSfidaNormale("EsportPalace", "WoW", "Arena 1v1", "Rexal", "Souldead", new Data("20.07.2020"), new Orario("10:00"), Validità.CAMPIONATO);
		gestore.addSfidaNormale("EsportPalace", "WoW", "Arena 1v1", "Rexal", "Souldead", new Data("20.07.2020"), new Orario("14:00"), Validità.CAMPIONATO);
		gestore.addSfidaNormale("EsportPalace", "WoW", "Arena 1v1", "Rexal", "Souldead", new Data("20.07.2020"), new Orario("18:00"), Validità.CAMPIONATO);
		gestore.addSfidaNormale("EsportPalace", "WoW", "Arena 1v1", "Rexal", "Souldead", new Data("21.07.2020"), new Orario("09:00"), Validità.CAMPIONATO);
		gestore.addSfidaNormale("EsportPalace", "WoW", "Arena 1v1", "Rexal", "Souldead", new Data("21.07.2020"), new Orario("10:00"), Validità.CAMPIONATO);
		gestore.addSfidaNormale("EsportPalace", "WoW", "Arena 1v1", "Rexal", "Souldead", new Data("21.07.2020"), new Orario("14:00"), Validità.CAMPIONATO);
		gestore.addSfidaNormaleConID("EsportPalace", 9, "WoW", "Arena 1v1", "Rexal", "Souldead", new Data(), new Orario("08:00"), Validità.AMICHEVOLE);
		gestore.addSfidaNormale("EsportPalace", "WoW", "Arena 1v1", "Meowth", "Souldead", new Data("21.07.2020"), new Orario("14:00"), Validità.CAMPIONATO);
		gestore.addSfidaNormale("EsportPalace", "WoW", "Arena 1v1", "Meowth", "Souldead", new Data("21.07.2020"), new Orario("14:00"), Validità.CAMPIONATO);
		gestore.addSfidaNormale("EsportPalace", "WoW", "Arena 1v1", "Meowth", "Souldead", new Data("21.07.2020"), new Orario("14:00"), Validità.CAMPIONATO);
		gestore.stampaSfide();
		System.out.println();
		System.out.println();
		System.out.println();
		gestore.stampaSfidePerPunteggio();
		System.out.println();
		System.out.println("Cerco sfide...");
		System.out.println(gestore.cercaSfida("nosferatu"));
		System.out.println(gestore.cercaSfida("souldead"));
		System.out.println();
		System.out.println();
		System.out.println("Da file...");
		
		
		GestoreSfide gestore2 = new GestoreSfide();
		gestore2.sfideDaFile();
		gestore2.addSfidaCompetitiva(4, "WoW", "Arena 1v1", "Nosferatu", "Souldead", new Data("20.07.2020"), new Orario("09:00"), Validità.CAMPIONATO);
		gestore2.stampaSfide();
		System.out.println();
		System.out.println();
		System.out.println();
		gestore2.stampaSfidePerPunteggio();
		
		
		
		
	}

}
