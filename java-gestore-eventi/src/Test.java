import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);

        // Richiesta nome evento
        System.out.println("Inserisci il nome dell'evento:");
        String nome = scanner.nextLine();


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

                if (anno < 0) {
                    System.out.println("Input non valido, riprovare:");
                } else {
                    break;
                }
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

                // Controllo per numeri negativi già presente nella classe Evento

                break;
            } else {
                System.out.println("Input non valido, inserire un numero:");
                scanner.next();
            }
        }

        // Creazione oggetto Evento
        Evento nuovoEvento = new Evento(nome, giorno, mese, anno, postiTotali);

        //richiesta prenotazioni
        System.out.println("Evento creato! vuoi prenotare dei posti? [Si/No]");
        String risposta;

        // Controllo prenotazioni
        while (true) {
            risposta = scanner.nextLine().trim().toLowerCase();
                
            if (risposta.equals("si") || risposta.equals("no")) {
                break;
            } else {
                System.out.println("Input non valido, inserire Si o No");
            }
        }

        System.out.println(nuovoEvento.toString()); // solo per prova
        
        scanner.close();
    }
}