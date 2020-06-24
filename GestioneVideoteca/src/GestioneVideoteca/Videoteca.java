package GestioneVideoteca;

import java.util.ArrayList;
import java.util.Collections;

import ClassiVideoteca.GenereVideo;
import ClassiVideoteca.LimitazioneVideoException;
import ClassiVideoteca.LimiteGiorniPrestitoSuperatoException;
import ClassiVideoteca.PrestitoVideo;
import ClassiVideoteca.Utente;
import ClassiVideoteca.UtenteEnte;
import ClassiVideoteca.UtentePrivato;
import ClassiVideoteca.Video;

public class Videoteca {
	
	ArrayList<PrestitoVideo> listaPrestiti;
	ArrayList<Utente> listaUtenti;
	ArrayList<Video> listaVideo;
	
	public Videoteca() {
		listaPrestiti = new ArrayList<PrestitoVideo>();
		listaUtenti = new ArrayList<Utente>();
		listaVideo = new ArrayList<Video>();
	}
	
	public void registraUtentePrivato(String nome, String cognome, int età) {
		UtentePrivato utente = new UtentePrivato(nome, cognome, età);
		this.listaUtenti.add(utente);
	}
	
	public void registraUtenteEnte(String nomeEnte) {
		UtenteEnte utente = new UtenteEnte(nomeEnte);
		this.listaUtenti.add(utente);
	}
	
	public void addVideo(String titolo, String trama, String regista, int anno, GenereVideo genere) {
		Video video = new Video(titolo, trama, regista, anno, genere);
		this.listaVideo.add(video);
	}
	
	public void stampaVideo() {
		Collections.sort(this.listaVideo);
		System.out.println("==================================================================================================================================================================");
		for(Video v: this.listaVideo) {
			System.out.println(v);
			System.out.println("==================================================================================================================================================================");
		}
	}
	
	public void cercaVideo(String key) {
		key = key.toLowerCase();
		System.out.println("==================================================================================================================================================================");
		for(Video v: this.listaVideo) {
			if(v.titolo.toLowerCase().contains(key) || v.trama.toLowerCase().contains(key) || v.regista.toLowerCase().contains(key) ||
			   String.valueOf(v.anno).contains(key) || v.genere.toString().contains(key)) {
				System.out.println(v);
				System.out.println("==================================================================================================================================================================");
			}
		}
	}
	
	public String getVideoID(String titolo, String regista) throws VideoNotFoundException {
		for(Video v: this.listaVideo) {
			if(v.titolo.toLowerCase().contains(titolo.toLowerCase()) && v.regista.toLowerCase().contains(regista.toLowerCase())) {
				return String.valueOf(v.ID);
			}
		}
		throw new VideoNotFoundException();
	}
	
	public void restituzionePrestito(String IDprestito) {
		for(PrestitoVideo p: this.listaPrestiti) {
			if(p.IDprestito.equals(IDprestito)) {
				p.video.disponibile = true;
				this.listaPrestiti.remove(p);
				return;
			}
		}
		System.err.println("Errore: Prestito non trovato.");
	}
	
	public void nuovoPrestito(String IDutente, String IDvideo, int giorniDiPrestito) {
		if(this.controlloDati(IDutente, IDvideo)) {
			for(Utente u: this.listaUtenti) {
				if(u.ID.equals(IDutente)) {
					for(Video v: this.listaVideo) {
						if(v.ID == Integer.valueOf(IDvideo)) {
							try {
								PrestitoVideo prestito = new PrestitoVideo(u, v, giorniDiPrestito);
								listaPrestiti.add(prestito);
								v.disponibile = false;
								u.videoInPrestito.add(v);
							} catch (LimiteGiorniPrestitoSuperatoException e) {
								System.err.println("Errore: Giorni di prestito oltre il limite consentito.");
							} catch (LimitazioneVideoException e) {
								System.err.println("Errore: Video proibito per utenti di età inferiore a quella consentita.");
							} finally {
								System.out.println("Prestito elaborato.");
							}
						}
					}
				}
				for(Video vi: u.videoInPrestito) {
					if(vi.ID == Integer.valueOf(IDvideo)) {
						u.videoInPrestito.remove(u);
					}
				}
			}
		}
	}
	
	private boolean controlloDati(String IDutente, String IDvideo) {
		for(Utente u: this.listaUtenti) {
			if(u.ID.equals(IDutente)) {
				for(Video v: this.listaVideo) {
					if(v.ID == Integer.valueOf(IDvideo)) {
						if(v.disponibile) {
							return true;
						}
					}
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		Videoteca v = new Videoteca();
		v.addVideo("the last samurai", "Samurai e cannoni", "stokoso", 2010, GenereVideo.AZIONE);
		v.registraUtentePrivato("Marco", "Martinelli", 27);
		v.nuovoPrestito("UP00000", "0000", 5);
		v.stampaVideo();
		v.restituzionePrestito("2020060000");
		v.stampaVideo();
		v.nuovoPrestito("UP00000", "0000", 5);
		for(PrestitoVideo pv: v.listaPrestiti)
			System.out.println(pv.IDprestito);
	}

}
