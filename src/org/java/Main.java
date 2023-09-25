package org.java;

import java.util.Scanner;

import org.java.eventi.Concerto;
import org.java.eventi.evento.Evento;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
//		//chiedo all'utente di inserire il TITOLO e lo salvo in una variabile
//		System.out.print("Inserisci il titolo dell'evento: ");
//		String titolo = sc.nextLine();
//
//		//chiedo all'utente di inserire la DATA e la salvo in una variabile
//		System.out.print("Inserisci la data in questo formato: 'dd-mm-yyyy' ");
//		String dataEvento = sc.nextLine();
//
//		//chiedo all'utente di inserire i POSTI a disposizione e li salvo in una variabile
//		System.out.print("Inserire i  posti a disposizione: ");
//		int postiTotali = Integer.valueOf(sc.nextLine());
//		
//		System.out.println("\n----------------------------------");
//		
//		//istanza di un EVENTO
//		Evento evento = null;
//		try {
//			evento = new Evento(titolo, dataEvento, postiTotali);
//			System.out.println("\n" + evento);
//		} catch (Exception e) {
//			System.err.println("Dato inserito errato: " + e.getMessage());
//		}
//		
//		System.out.println("\n----------------------------------\n");
//		
//		System.out.print("Vuoi effettuare prenotazioni? [Y/n] ");
//		String inputPrenota = sc.nextLine();
//		
//		if(inputPrenota.toLowerCase().equals("y")) {
//			
//			System.out.print("\nQuanti posti vuoi prenotare? ");
//			int postiInseriti = Integer.valueOf(sc.nextLine());
//			
//			//controllo che il numero inserito sia maggiore di 0 e minore dei posti totali disponibili
//			if(postiInseriti > 0 && postiInseriti<= evento.getnPostiTotale()) {
//				//FIXME: se si vuole visualizzare il catch col messaggio di errore bisogna togliere dalla condizione "&& postiInseriti<= evento.getnPostiTotale()"
//				try {
//					for (int i = 0; i < postiInseriti; i++) {
//					evento.prenota(postiInseriti);
//					}
//					evento.ricalcolo(postiInseriti, true);
//					System.out.println("\n" + evento);
//				} catch (Exception e) {
//					System.err.println(e.getMessage());
//				}
//			} else {
//				System.err.println("hai inserito un numero non valido");
//			}
//			
//		} else {
//			System.out.println("\n" + evento);
//		}
//		
//		System.out.println("\n----------------------------------\n");
//		
//		System.out.print("Vuoi disdire una prenotazione? [Y/n] ");
//		String inputDisdici = sc.nextLine();
//		
//		if(inputDisdici.toLowerCase().equals("y")) {
//			
//			System.out.print("\nQuanti posti vuoi disdire? ");
//			int postiInseriti = Integer.valueOf(sc.nextLine());
//			
//			if(postiInseriti >= 0 && postiInseriti<= evento.getnPostiPrenotati()) {
//				try {
//					for (int i = 0; i < postiInseriti; i++) {
//						evento.disdici(postiInseriti);
//					}
//					evento.ricalcolo(postiInseriti, false);
//					System.out.println("\n" + evento);
//				}catch (Exception e) {
//					System.err.println(e.getMessage());
//				}
//			} else {
//				System.err.println("hai inserito un numero non valido");
//			}
//			
//			
//		}else {
//			System.out.println("\nNessuna disdetta, questo sarà l'evento ↓\n" + evento);
//		}
		

		/**
		 * Milestone 3
		 */
		
		System.out.print("Inserisci il titolo dell'evento: ");
		String titolo = sc.nextLine();

		System.out.print("Inserisci la data in questo formato: 'dd-mm-yyyy' ");
		String dataEvento = sc.nextLine();

		System.out.print("Inserire i  posti a disposizione: ");
		int postiTotali = Integer.valueOf(sc.nextLine());
		
		System.out.print("Inserisci l'ora in questo formato: 'HH:mm' ");
		String ora = sc.nextLine();
		
		System.out.print("Inserisci il prezzo: ");
		double prezzo = Double.valueOf(sc.nextLine());
		
		System.out.println("\n----------------------------------");
		
		Concerto concerto = null;
		try {
			concerto = new Concerto(titolo, dataEvento, postiTotali, ora, prezzo);
			System.out.println("\n" + concerto);
		} catch (Exception e) {
			System.err.println("Dato inserito errato: " + e.getMessage());
		}
		
		System.out.println("\n----------------------------------\n");
		
		System.out.print("Vuoi effettuare prenotazioni? [Y/n] ");
		String inputPrenota = sc.nextLine();
		
		if(inputPrenota.toLowerCase().equals("y")) {
			
			System.out.print("\nQuanti posti vuoi prenotare? ");
			int postiInseriti = Integer.valueOf(sc.nextLine());
			
			if(postiInseriti > 0 && postiInseriti<= concerto.getnPostiTotale()) {
				try {
					for (int i = 0; i < postiInseriti; i++) {
						concerto.prenota(postiInseriti);
					}
					concerto.ricalcolo(postiInseriti, true);
					System.out.println("\n" + concerto);
				} catch (Exception e) {
					System.err.println(e.getMessage());
				}
			} else {
				System.err.println("hai inserito un numero non valido");
			}
			
		} else {
			System.out.println("\n" + concerto);
		}
		
		System.out.println("\n----------------------------------\n");
		
		System.out.print("Vuoi disdire una prenotazione? [Y/n] ");
		String inputDisdici = sc.nextLine();
		
		if(inputDisdici.toLowerCase().equals("y")) {
			
			System.out.print("\nQuanti posti vuoi disdire? ");
			int postiInseriti = Integer.valueOf(sc.nextLine());
			
			if(postiInseriti >= 0 && postiInseriti<= concerto.getnPostiPrenotati()) {
				try {
					for (int i = 0; i < postiInseriti; i++) {
						concerto.disdici(postiInseriti);
					}
					concerto.ricalcolo(postiInseriti, false);
					System.out.println("\n" + concerto);
				}catch (Exception e) {
					System.err.println(e.getMessage());
				}
			} else {
				System.err.println("hai inserito un numero non valido");
			}
			
		}else {
			System.out.println("\nNessuna disdetta, questo sarà l'evento ↓\n" + concerto);
		}

		
	}

}
