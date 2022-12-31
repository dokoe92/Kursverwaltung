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

    public void vornameCheck(String vorname){
        if (vorname.isBlank() || vorname == null) {
            this.vorname = "invalid";
        } else {
            this.vorname = vorname;
        }
    }

    public void nachnameCheck(String nachname) {
        if (nachname.isBlank() || nachname == null) {
            this.nachname = "invalid";
        } else {
            this.nachname = nachname;
        }
    }

    public void geschlechtCheck(char sex) {
        if (sex == 'w' || sex == 'm' ||sex == 'd') {
            this.geschlecht = sex;
        } else {
            this.geschlecht = '-';
        }
    }

    public void geburtsdatumCheck(LocalDate geburtsdatum) {
        if (geburtsdatum.isAfter(LocalDate.of(1920,1,1))) {
            this.geburtsdatum = geburtsdatum;
        } else {
            this.geburtsdatum = LocalDate.of(2100,11,11);
        }
    }

    public void calcAge() {
        LocalDate today = LocalDate.now();
        this.alter = (int) ChronoUnit.YEARS.between(geburtsdatum, today);
    }

    public void printInfo() {
        System.out.println("Vorname: " + this.vorname + ", Nachname: " + this.nachname + ", Geburtstag: " + this.geburtsdatum + ", Geschlecht:" + geschlecht + ", Alter: " + this.alter);
    }
}
