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
		System.out.print("Inserisci la data in questo formato: 'dd-mm-yyyy' ");
		String dataEvento = sc.nextLine();

		//chiedo all'utente di inserire i POSTI a disposizione e li salvo in una variabile
		System.out.print("Inserire i  posti a disposizione: ");
		int postiTotali = Integer.valueOf(sc.nextLine());
		
		System.out.println("\n----------------------------------");
		
		//istanza di un EVENTO
		Evento evento = null;
		try {
			evento = new Evento(titolo, dataEvento, postiTotali);
			System.out.println("\n" + evento);
		} catch (Exception e) {
			System.err.println("Dato inserito errato: " + e.getMessage());
		}
		
		System.out.println("\n----------------------------------\n");
		
		System.out.print("Vuoi effettuare prenotazioni? [Y/n] ");
		String input = sc.nextLine();
		
		if(input.toLowerCase().equals("y")) {
			
			System.out.print("\nQuanti posti vuoi prenotare? ");
			int postiInseriti = Integer.valueOf(sc.nextLine());
			
			//controllo che il numero inserito sia maggiore di 0 e minore dei posti totali disponibili
			if(postiInseriti > 0 && postiInseriti<= evento.getnPostiTotale()) {
				//FIXME: se si vuole visualizzare il catch col messaggio di errore bisogna togliere dalla condizione "&& postiInseriti<= evento.getnPostiTotale()"
				try {
					for (int i = 0; i < postiInseriti; i++) {
					evento.prenota(postiInseriti);
					}
					evento.ricalcolo(postiInseriti);
					System.out.println("\n" + evento);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			} else {
				System.err.println("hai inserito un numero non valido");
			}
			
		} else {
			System.out.println("\n" + evento);
		}
		
		
		
		
	}

}
