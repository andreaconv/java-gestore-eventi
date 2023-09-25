package org.java.eventi;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

	private String titolo;
	private LocalDate dataEvento;
	private int nPostiTotale;
	private int nPostiPrenotati = 0;
	//dichiaro la formattazione che voglio avere
	private final DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy");
	
	//COSTRUTTORE
	public Evento(String titolo, String data, int nPostiTotale) throws Exception {
		setTitolo(titolo);
		setData(data);
		setnPostiTotale(nPostiTotale);
	}
	
	
	//TITOLO
	public String getTitolo() {
		return titolo;
	}
	public void setTitolo(String titolo) throws Exception {
		if (titolo.isBlank())
			throw new Exception("Il titolo non può essere vuoto");
		this.titolo = titolo;
	}
	
	//DATA
	public LocalDate getData() {
		return dataEvento;
	}
	public void setData(String data) throws Exception {
		//creo un oggetto LocalDate che prende valore dalla stringa "data" fornita dal imput e convertita a oggetto LocalDate col metodo `parse()` 
		LocalDate locDate = LocalDate.parse(data, myFormatObj);
		
		//TODO aggiungere il messaggio throw new Exception "formato data inserito sbagliato"

		//controllo che la data non sia già passata
		if(locDate.isBefore(LocalDate.now()))
		{
			throw new Exception("La data non può essere passata");
		}
		this.dataEvento = locDate;
	}
	
	//POSTI TOTALI
	public int getnPostiTotale() {
		return nPostiTotale;
	}
	private void setnPostiTotale(int nPostiTotale) throws Exception {
		//controllo che il numero di posti totali sia positivo
		if (nPostiTotale <= 0)
			throw new Exception("Il numero dei posti totale non può essere 0 o minore");
		this.nPostiTotale = nPostiTotale;
	}
	
	//POSTI PRENOTATI
	public int getnPostiPrenotati() {
		return nPostiPrenotati;
	}
	private void setnPostiPrenotati(int nPostiPrenotati) {
		this.nPostiPrenotati = nPostiPrenotati;
	}
	
	//metodo PRENOTA
	public void prenota(int postiInseriti) throws Exception {
		
//		if(getData().isBefore(LocalDate.now()))
//		{
//			throw new Exception("Evento non più disponibile");
//		}

		if(postiInseriti > getnPostiTotale())
		{
			throw new Exception("Posti non disponibili");
		}else {			
			setnPostiPrenotati(getnPostiPrenotati() + 1);
		}
		
	}
	//metodo RICALCOLO totale posti 
	public void ricalcolo(int postiInseriti, boolean add) throws Exception {
		if(add == true) {
			setnPostiTotale(getnPostiTotale() - postiInseriti);	
		} else {
			setnPostiTotale(getnPostiTotale() + postiInseriti);
		}
	}
	
	//metodo DISDICI
	public void disdici(int postiInseriti) throws Exception {
//		if(getData().isBefore(LocalDate.now()))
//		{
//			throw new Exception("Evento non più disponibile");
//		}
		
		if(postiInseriti > getnPostiPrenotati())
		{
			throw new Exception("Stai provando a disdire più posti di quanti ne hai prenotati");
		}else {			
			setnPostiPrenotati(getnPostiPrenotati() - 1);
		}
	}
	
	@Override
	public String toString() {
		return "Titolo: " + getTitolo() + " | Data: " + getData().format(myFormatObj) + " | Posti totali: " + getnPostiTotale() + " | Posti prenotati: " + getnPostiPrenotati();
	}




}
