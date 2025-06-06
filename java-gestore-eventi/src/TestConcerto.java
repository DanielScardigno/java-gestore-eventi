import java.time.LocalTime;
import java.util.Scanner;

public class TestConcerto {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        // Richiesta nome evento
        System.out.println("Inserisci il nome del concerto:");
        String nome;

        while (true) {
            nome = scanner.nextLine();
            
            if (nome.equals("")) {
                System.out.println("Input non valido, inserire almeno un carattere");
            } else {
                break;
            }
        }

        // Richiesta giorno evento
        System.out.println("Inserisci il giorno in numero:");
        int giorno;

        // Controllo giorno evento
        while (true) {
            if (scanner.hasNextInt()) {
                giorno = scanner.nextInt();
                scanner.nextLine();

                if (giorno > 31 || giorno < 1) {
                    System.out.println("Input non valido, riprovare:");
                } else {
                    break;
                }
            } else {
                System.out.println("Input non valido, inserire un numero:");
                scanner.next();
            }
        }

        // Richiesta mese evento
        System.out.println("Inserisci il mese in numero:");
        int mese;

        // Controllo mese evento
        while (true) {
            if (scanner.hasNextInt()) {
                mese = scanner.nextInt();
                scanner.nextLine();

                if (mese > 12 || mese < 1) {
                    System.out.println("Input non valido, riprovare:");
                } else {
                    break;
                }
            } else {
                System.out.println("Input non valido, inserire un numero:");
                scanner.next();
            }
        }

        // Richiesta anno evento
        System.out.println("Inserisci l'anno:");
        int anno;

        // Controllo anno evento
        while (true) {
            if (scanner.hasNextInt()) {
                anno = scanner.nextInt();
                scanner.nextLine();

                // Controllo per date passate già presente nella classe Evento (Unchecked)

                break;
            } else {
                System.out.println("Input non valido, inserire un numero:");
                scanner.next();
            }
        }

        // Richiesta ora
        System.out.println("Inserisci l'ora");
        int ora;

        // Controllo ora
        while (true) {
            if (scanner.hasNextInt()) {
                ora = scanner.nextInt();
                scanner.nextLine();

                if (ora < 0 || ora > 23) {
                    System.out.println("Input non valido, riprovare:");
                } else {
                    break;
                }
            } else {
                System.out.println("Input non valido, inserire un numero:");
                scanner.next();
            }
        }

        // Richiesta minuto
        System.out.println("Inserisci il minuto");
        int minuto;

        // Controllo minuto
        while (true) {
            if (scanner.hasNextInt()) {
                minuto = scanner.nextInt();
                scanner.nextLine();

                if (minuto < 0 || minuto > 59) {
                    System.out.println("Input non valido, riprovare:");
                } else {
                    break;
                }
            } else {
                System.out.println("Input non valido, inserire un numero:");
                scanner.next();
            }
        }

        // Creazione ora
        LocalTime orario = LocalTime.of(ora, minuto);

        // Richiesta posti totali
        System.out.println("Inserisci i posti totali:");
        int postiTotali;

        // Controllo posti totali
        while (true) {
            if (scanner.hasNextInt()) {
                postiTotali = scanner.nextInt();
                scanner.nextLine();

                // Controllo per numeri negativi già presente nella classe Evento (Unchecked)

                break;
            } else {
                System.out.println("Input non valido, inserire un numero:");
                scanner.next();
            }
        }

        //Richiesta prezzo
        System.out.println("Inserisci il prezzo del biglietto");
        double prezzo;

        while (true) {
            if (scanner.hasNextDouble()) {
                prezzo = scanner.nextDouble();
                scanner.nextLine();

                if (prezzo < 0) {
                    System.out.println("Input non valido, riprovare");
                } else {
                    break;
                }
            } else {
                System.out.println("Input non valido, inserire un numero");
                scanner.next();
            }
        }

        // Creazione oggetto Evento
        Concerto nuovoConcerto = new Concerto(nome, giorno, mese, anno, postiTotali, orario, prezzo);

        // scelta prenotazioni
        System.out.println("Evento creato! vuoi prenotare dei posti? [Si/No]");
        String rispostaPrenotazione;

        // Controllo scelta prenotazioni
        while (true) {
            rispostaPrenotazione = scanner.nextLine().trim().toLowerCase();
                
            if (rispostaPrenotazione.equals("si") || rispostaPrenotazione.equals("no")) {
                break;
            } else {
                System.out.println("Input non valido, inserire Si o No");
            }
        }

        // Effettuazione prenotazioni
        int postiPrenotati;

        if (rispostaPrenotazione.equals("si")) {
            System.out.println("Quanti posti vuoi prenotare?");

            // Controllo Prenotazioni
            while (true) {
                if (scanner.hasNextInt()) {
                    postiPrenotati = scanner.nextInt();
                    scanner.nextLine();

                    //Controllo per posti prenotati superiori a quelli disponibili già presente nella classe Evento (Unchecked)

                    if (postiPrenotati == 0) {
                        System.out.println("Input non valido, inserire almeno un posto");
                    } else if (postiPrenotati < 0) {
                    System.out.println("Input non valido, Riprovare");
                    } else {
                        
                        for (int i = 0; i < postiPrenotati; i++) {
                            nuovoConcerto.prenota();
                        }

                        if (postiPrenotati == 1) {
                            System.out.println("Hai prenotato " + postiPrenotati + " posto");
                        } else {
                            System.out.println("Hai prenotato " + postiPrenotati + " posti");
                        }

                        System.out.println("posti ancora disponibili: " + (nuovoConcerto.getPostiTotali() - nuovoConcerto.getPostiPrenotati()));
                        break;
                    }
                } else {
                    System.out.println("Input non valido, inserire solo caratteri numerici");
                    scanner.next();
                }
            }   
        } else {
            System.out.println("posti ancora disponibili: " + (nuovoConcerto.getPostiTotali() - nuovoConcerto.getPostiPrenotati()));
        }

        // richiesta scelta disdette
        System.out.println("Vuoi disdire dei posti? [Si/No]");
        String rispostaDisdetta;

        // Controllo scelta disdette
        while (true) {
            rispostaDisdetta = scanner.nextLine().trim().toLowerCase();
                
            if (rispostaDisdetta.equals("si") || rispostaDisdetta.equals("no")) {
                break;
            } else {
                System.out.println("Input non valido, inserire Si o No");
            }
        }

        // Effettuazione disdette
        int postiDisdetti;

        if (rispostaDisdetta.equals("si")) {
            System.out.println("Quanti posti vuoi disdire?");

            // Controllo disdette
            while (true) {
                if (scanner.hasNextInt()) {
                    postiDisdetti = scanner.nextInt();
                    scanner.nextLine();

                    //Controllo per posti prenotati assenti già presente nella classe Evento (Unchecked)

                    if (postiDisdetti == 0) {
                        System.out.println("Input non valido, inserire almeno un posto");
                    } else if (postiDisdetti < 0) {
                    System.out.println("Input non valido, Riprovare");
                    } else {
                        
                        for (int i = 0; i < postiDisdetti; i++) {
                            nuovoConcerto.disdici();
                        }

                        if (postiDisdetti == 1) {
                            System.out.println("Hai disdetto " + postiDisdetti + " posto");
                        } else {
                            System.out.println("Hai disdetto " + postiDisdetti + " posti");
                        }

                        System.out.println("posti ancora disponibili: " + (nuovoConcerto.getPostiTotali() - nuovoConcerto.getPostiPrenotati()));
                        break;
                    }
                } else {
                    System.out.println("Input non valido, inserire solo caratteri numerici");
                    scanner.next();
                }
            }   
        } else {
            System.out.println("posti ancora disponibili: " + (nuovoConcerto.getPostiTotali() - nuovoConcerto.getPostiPrenotati()));
        }

        System.out.println("Codice evento: " + nuovoConcerto.toString());
        
        scanner.close();
    }
}