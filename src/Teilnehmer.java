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

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public char getGeschlecht() {
        return geschlecht;
    }

    public LocalDate getGeburtsdatum() {
        return geburtsdatum;
    }

    public int getAlter() {
        return alter;
    }

    public void calcAge() {
        LocalDate today = LocalDate.now();
        this.alter = (int) ChronoUnit.YEARS.between(geburtsdatum, today);
    }

    public void printInfo() {
        System.out.println("Vorname: " + this.vorname + ", Nachname: " + this.nachname + ", Geburtstag: " + this.geburtsdatum + ", Geschlecht:" + geschlecht + ", Alter: " + this.alter);
    }
}
