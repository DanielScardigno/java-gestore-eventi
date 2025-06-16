import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;

public class ProgrammaEventi {

    public String titolo;
    private List<Evento> eventi;

    public ProgrammaEventi(String titolo) {

        this.titolo = titolo;
        this.eventi = new ArrayList<>();
    }

    // Metodi

    public void addEvento(Evento evento) {
        eventi.add(evento);
    }

    public String getEventiInData(int giorno, int mese, int anno) {

        LocalDate dataCostruita = LocalDate.of(anno, mese, giorno);
        String dataFormattata = dataCostruita.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));

        List<Evento> eventiInData = new ArrayList<>();

        for (Evento evento : this.eventi) {
            if (evento.getData().equals(dataFormattata)) {
                eventiInData.add(evento);
            }
        }

        if (eventiInData.size() == 0) {
            throw new IllegalArgumentException("Non ci sono eventi nella data selezionata");
        } else {
            return (eventiInData.toString());
        }
    }

    public int getNumeroEventi() {
        return this.eventi.size();
    }

    public void deleteEventi() {
        this.eventi.clear();
    }

    public String getEventiOrdinati() {
        
        this.eventi.sort(Comparator.comparing(evento -> LocalDate.parse(evento.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        
        StringBuilder stringBuilder = new StringBuilder();
        
        for (Evento evento : this.eventi) {
            stringBuilder.append(evento.toString()).append("\n");
        }

        return this.titolo + ":\n" + stringBuilder.toString();
    }
}