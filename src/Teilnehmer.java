import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Teilnehmer {
    private String vorname;
    private String nachname;
    private char geschlecht;
    private LocalDate geburtsdatum;
    private int alter;

    public Teilnehmer(String vorname, String nachname, char geschlecht, LocalDate geburtsdatum) {
        this.vorname = vorname;
        this.nachname = nachname;
        this.geschlecht = geschlecht;
        this.geburtsdatum = geburtsdatum;
        calcAge();

    }

    public void calcAge() {
        LocalDate today = LocalDate.now();
        this.alter = (int) ChronoUnit.YEARS.between(geburtsdatum, today);
    }

    public void printInfo() {
        System.out.println("Vorname: " + this.vorname + ", Nachname: " + this.nachname + ", Geburtstad: " + this.geburtsdatum + ", Geschlecht:" + geschlecht);
    }
}
