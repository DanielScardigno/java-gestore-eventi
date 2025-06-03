import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Evento {

    private String titolo;
    private LocalDate data;
    private int postiTotali;
    private int postiPrenotati;

    public Evento(String titolo, int giorno, int mese, int anno, int postiTotali) {

        this.titolo = titolo;

        LocalDate dataCostruita = LocalDate.of(anno, mese, giorno);

        if (dataCostruita.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Impossibile creare l'evento: La data selezionata é già passata.");
        } else {
            this.data = dataCostruita;
        }

        if (postiTotali < 0) {
            throw new IllegalArgumentException("Impossibile creare l'evento: Il numero di posti totali non può essere inferiore a 0.");
        } else {
            this.postiTotali = postiTotali;
        }

        this.postiPrenotati = 0;
    }

    // Getter e Setter

    public String getTitolo() {
        return this.titolo;
    }

    public void setTitolo(String titolo) {
        if (titolo.equals("")) {
            throw new IllegalArgumentException("Impossibile aggiornare il titolo: Inserire almeno un carattere");
        } else {
            this.titolo = titolo;
        }
    }

    public String getData() {
        return this.data.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    }

    public void setData(int giorno, int mese, int anno) {
        LocalDate dataCostruita = LocalDate.of(anno, mese, giorno);
        if (dataCostruita.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("Impossibile aggiornare la data: La data selezionata é già passata.");
        } else {
            this.data = dataCostruita;
        }
    }

    public int getPostiTotali() {
        return this.postiTotali;
    }

    public int getPostiPrenotati() {
        return this.postiPrenotati;
    }

    // Metodi

    public void prenota() {
        if (this.postiTotali == 0 ) {
            throw new IllegalStateException("Spiacenti, non ci sono posti disponibili.");
        } else if (this.postiPrenotati >= this.postiTotali) {
            throw new IllegalStateException("Spiacenti, il numero di posti prenotati supera quello dei posti disponibili");
        } else {
            this.postiPrenotati++;
        }
    }

    public void disdici() {
        if (this.postiTotali == 0 || this.postiPrenotati == 0) {
            throw new IllegalStateException("Non ci sono prenotazioni da disdire.");
        } else {
            this.postiPrenotati--;
        }
    }

    @Override
    public String toString() {
        String dataFormattata = this.getData();
        String messaggio = dataFormattata + "-" + this.getTitolo();
        return messaggio.replaceAll(" ", "-");
    }
}