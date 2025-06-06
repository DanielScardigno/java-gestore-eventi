public class TestBonus {
    public static void main(String[] args) {

        // Istanzio il programma eventi
        ProgrammaEventi programma = new ProgrammaEventi("Programma eventi futuri");

        // Creo gli eventi
        Evento evento1 = new Evento("Evento 1", 30, 6, 2025, 10);
        Evento evento2 = new Evento("Evento 2", 2, 11, 2044, 100);
        Evento evento3 = new Evento("Evento 3", 12, 10, 3000, 100000);
        Evento evento4 = new Evento("Evento 4", 25, 9, 2026, 6);
        Evento evento5 = new Evento("Evento 5", 2, 11, 2044, 30);

        // Aggiungo gli eventi
        programma.addEvento(evento1);
        programma.addEvento(evento2);
        programma.addEvento(evento3);
        programma.addEvento(evento4);
        programma.addEvento(evento5);

        // Mostro gli eventi in data 02/11/2044
        System.out.println(programma.getEventiInData(2, 11, 2044));

        // Mostro il numero di eventi nel programma
        System.out.println("Numero eventi: " + programma.getNumeroEventi());

        // Elimino tutti gli eventi
        programma.deleteEventi();

        // Mostro nuovamente il numero di eventi nel programma
        System.out.println("Numero eventi: " +  programma.getNumeroEventi());

        // Aggiungo nuovamente gli eventi
        programma.addEvento(evento1);
        programma.addEvento(evento2);
        programma.addEvento(evento3);
        programma.addEvento(evento4);
        programma.addEvento(evento5);

        // Mostro la lista di eventi ordinati per data
        System.out.println(programma.getEventiOrdinati());
    }
}