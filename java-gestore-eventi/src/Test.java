import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        // Richiesta nome evento
        System.out.println("Inserisci il nome dell'evento:");
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

        // Creazione oggetto Evento
        Evento nuovoEvento = new Evento(nome, giorno, mese, anno, postiTotali);

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
                            nuovoEvento.prenota();
                        }

                        if (postiPrenotati == 1) {
                            System.out.println("Hai prenotato " + postiPrenotati + " posto");
                        } else {
                            System.out.println("Hai prenotato " + postiPrenotati + " posti");
                        }

                        System.out.println("posti ancora disponibili: " + (nuovoEvento.getPostiTotali() - nuovoEvento.getPostiPrenotati()));
                        break;
                    }
                } else {
                    System.out.println("Input non valido, inserire solo caratteri numerici");
                    scanner.next();
                }
            }   
        } else {
            System.out.println("posti ancora disponibili: " + (nuovoEvento.getPostiTotali() - nuovoEvento.getPostiPrenotati()));
        }

        // scelta disdette
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
                            nuovoEvento.disdici();
                        }

                        if (postiDisdetti == 1) {
                            System.out.println("Hai disdetto " + postiDisdetti + " posto");
                        } else {
                            System.out.println("Hai disdetto " + postiDisdetti + " posti");
                        }

                        System.out.println("posti ancora disponibili: " + (nuovoEvento.getPostiTotali() - nuovoEvento.getPostiPrenotati()));
                        break;
                    }
                } else {
                    System.out.println("Input non valido, inserire solo caratteri numerici");
                    scanner.next();
                }
            }   
        } else {
            System.out.println("posti ancora disponibili: " + (nuovoEvento.getPostiTotali() - nuovoEvento.getPostiPrenotati()));
        }

        System.out.println("Codice evento: " + nuovoEvento.toString());
        
        scanner.close();
    }
}