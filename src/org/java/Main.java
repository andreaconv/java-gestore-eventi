package org.java;

import java.util.Scanner;

import org.java.eventi.Evento;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		//chiedo all'utente di inserire il TITOLO e lo salvo in una variabile
		System.out.print("Inserisci il titolo dell'evento: ");
		String titolo = sc.nextLine();

		//chiedo all'utente di inserire la DATA e la salvo in una variabile
		System.out.println("Inserisci la data in questo formato: 'dd-mm-yyyy' ");
		String dataEvento = sc.nextLine();

		//chiedo all'utente di inserire i POSTI a disposizione e li salvo in una variabile
		System.out.println("Inserire i  posti a disposizione: ");
		int postiTotali = Integer.valueOf(sc.nextLine());
		
		//inizializzo un EVENTO
		Evento evento = null;
		try {
			evento = new Evento(titolo, dataEvento, postiTotali);
			System.out.println(evento);
		} catch (Exception e) {
			System.err.println("Dato inserito errato: " + e.getMessage());
		}
		
	}

}
