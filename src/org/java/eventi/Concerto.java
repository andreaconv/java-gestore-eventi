package org.java.eventi;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import org.java.eventi.evento.Evento;

public class Concerto extends Evento{
	
	private LocalTime ora;
	private BigDecimal prezzo;
	//dichiaro la formattazione che voglio avere
	private final DateTimeFormatter myFormatHour = DateTimeFormatter.ofPattern("HH:mm");

	//COSTRUTTORE
	public Concerto(
			String titolo, String data, int nPostiTotale,
			String ora, double prezzo) throws Exception {
		super(titolo, data, nPostiTotale);
		setOra(ora);
		setPrezzo(prezzo);
	}

	//ORA
	public LocalTime getOra() {
		return ora;
	}
	public void setOra(String ora) {
		LocalTime hour = LocalTime.parse(ora, myFormatHour);
		this.ora = hour;
	}

	//PREZZO
	public BigDecimal getPrezzo() {
		return prezzo;
	}
	public void setPrezzo(double costo) {
		BigDecimal prezzo = new BigDecimal(costo).setScale(2, RoundingMode.HALF_DOWN);
		this.prezzo = prezzo;
	}

	@Override
	public String toString() {
//		return super.toString() + " | ora: " + getOra() + " | prezzo: " + getPrezzo();
//		return super.toString() + " | ora: " + getOra().format(myFormatHour) + " | Prezzo: " + getPrezzo().setScale(2).toPlainString() + "€";
		return "Titolo: " + getTitolo() + " | Data: " + getDataFormatted() + " | Ora: " + getOra().format(myFormatHour) + " | Posti totali: " + getnPostiTotale() + " | Posti prenotati: " + getnPostiPrenotati() + " | Prezzo: " + getPrezzo().setScale(2).toPlainString() + "€";
	}
}
