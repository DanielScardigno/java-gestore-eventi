import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class Concerto extends Evento{

    private LocalTime ora;
    private double prezzo;

    public Concerto(String titolo, int giorno, int mese, int anno, int postiTotali, LocalTime ora, double prezzo) {

        super(titolo, giorno, mese, anno, postiTotali);

        if (LocalDate.parse(this.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy")).equals(LocalDate.now()) && ora.isBefore(LocalTime.now())) {
            throw new IllegalArgumentException("Impossibile aggiornare l'ora: L'ora selezionata é già passata.");
        } else {
            this.ora = ora;
        }

        this.prezzo = prezzo;
    }

    // Getter e Setter

    public LocalTime getOra() {
        return this.ora;
    }

    public void setOra(LocalTime ora) {
        if (LocalDate.parse(this.getData(), DateTimeFormatter.ofPattern("dd/MM/yyyy")).equals(LocalDate.now()) && ora.isBefore(LocalTime.now())) {
            throw new IllegalArgumentException("Impossibile aggiornare l'ora: L'ora selezionata é già passata.");
        } else {
            this.ora = ora;
        }
    }

    public double getPrezzo() {
        return this.prezzo;
    }

    public void setPrezzo(double prezzo) {
        this.prezzo = prezzo;
    }

    // Metodi

    public String getDataCompleta() {
        return this.getData() + " " + this.ora.format(DateTimeFormatter.ofPattern("HH:mm"));
    }

    public String getPrezzoFormattato() {
        return String.format(Locale.ITALY, "%,.2f$", this.prezzo);
    }

    @Override
    public String toString() {
        String messaggio = this.getDataCompleta() + "-" + this.getTitolo() + "-" + this.getPrezzoFormattato();
        return messaggio.replaceAll(" ", "-");
    }
}