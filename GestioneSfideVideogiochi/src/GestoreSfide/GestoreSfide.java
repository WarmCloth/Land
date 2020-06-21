package GestoreSfide;

import java.util.ArrayList;

import ClassiSfida.IDGi‡UsatoException;
import ClassiSfida.OrarioNonValidoException;
import ClassiSfida.Sfida;
import ClassiSfida.SfidaPacifica;
import ClassiSfida.Validit‡;
import prog.utili.Orario;

public class GestoreSfide {
	
	ArrayList<Sfida> listaSfide;
	
	public GestoreSfide() {
		 listaSfide = new ArrayList<Sfida>();
	}
	
	public void addSfidaPacifica(String videogame, String descrizione, String giocatore1, String giocatore2, Orario orario, Validit‡ validit‡) {
		SfidaPacifica sfida;
		try {
			sfida = new SfidaPacifica(videogame, descrizione, giocatore1, giocatore2, orario, validit‡);
		} catch (OrarioNonValidoException e) {
			System.err.println("Errore: l'orario dev'essere compreso tra le 07:00 e le 00:00");
			return;
		}
		listaSfide.add(sfida);
	}
	
	public void addSfidaPacificaConID(int ID, String videogame, String descrizione, String giocatore1, String giocatore2, Orario orario, Validit‡ validit‡) {
		SfidaPacifica sfida;
		try {
			sfida = new SfidaPacifica(ID, videogame, descrizione, giocatore1, giocatore2, orario, validit‡);
		} catch (IDGi‡UsatoException e) {
			System.err.println("Errore: ID gi‡ esistente.");
			return;
		} catch (OrarioNonValidoException e) {
			System.err.println("Errore: l'orario dev'essere compreso tra le 07:00 e le 00:00");
			return;
		}
		listaSfide.add(sfida);
	}
	
	public void stampaSfide() {
		
	}

}
