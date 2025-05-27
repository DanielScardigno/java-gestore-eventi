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
            throw new IllegalArgumentException("La data selezionata é già passata.");
        } else {
            this.data = dataCostruita;
        }

        if (postiTotali < 0) {
            throw new IllegalArgumentException("Il numero di posti totali non può essere inferiore a 0.");
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
        this.titolo = titolo;
    }

    public String getData() {
        return this.data.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
    }

    public void setData(int giorno, int mese, int anno) {
        LocalDate dataCostruita = LocalDate.of(anno, mese, giorno);
        if (dataCostruita.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("La data selezionata é già passata.");
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

    public void prenota() throws Exception {
        if (this.postiTotali == 0 || this.postiTotali == this.postiPrenotati) {
            throw new Exception("Spiacenti, non ci sono posti disponibili.");
        } else {
            this.postiPrenotati++;
        }
    }

    public void disdici() throws Exception {
        if (this.postiTotali == 0 || this.postiPrenotati == 0) {
            throw new Exception("Non ci sono prenotazioni da disdire.");
        } else {
            this.postiPrenotati--;
        }
    }

    @Override
    public String toString() {
        DateTimeFormatter formatData = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        String dataFormattata = this.data.format(formatData);
        String messaggio = dataFormattata + "-" + titolo;
        return messaggio.replaceAll(" ", "-");
    }
}