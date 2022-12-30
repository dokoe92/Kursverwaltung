import java.time.LocalDate;
import java.util.ArrayList;

public class Kurs {
    private final String name;
    private Trainer trainer;
    private final int  maxteilnehmer;
    private final LocalDate  startDate;
    private final LocalDate endDate;
    private ArrayList<Teilnehmer> teilnehmer;
    private int id;

    public static int laufVariable = 0;


    public Kurs(String name, Trainer trainer, int maxteilnehmer, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.trainer = trainer;
        this.maxteilnehmer = maxteilnehmer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.teilnehmer = new ArrayList<>();
        setId();
    }

    public String getName() {
        return name;
    }

    public Trainer getTrainer() {
        return trainer;
    }

    public int getMaxteilnehmer() {
        return maxteilnehmer;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public ArrayList<Teilnehmer> getTeilnehmer() {
        return teilnehmer;
    }

    public int getId() {
        return id;
    }

    private void setId() {
        laufVariable++;
        this.id = laufVariable;
    }



    public void addTeilnehmer(Teilnehmer teilnehmer) {
        if (teilnehmer != null || this.maxteilnehmer + 1 < maxteilnehmer) {
            this.teilnehmer.add(teilnehmer);
        } else {
            System.out.println("Zu viele Teilnehmer!");
        }
    }



    public void printInfos() {
        System.out.println("#############################");
        System.out.println("###########KURSINFO##########");
        System.out.println("#############################");
        System.out.println("Name:      " + this.name);
        System.out.println("Trainer:    " + this.trainer.getVorname() + " " + this.trainer.getNachname());
        System.out.println("Max. Anzahl: " + this.maxteilnehmer);
        System.out.println("Belegung in %: " + belegungInProzent() +"%");
        System.out.println("Frauenanteil in %: " + frauenAnteil() + "%");
        System.out.println("Männeranteil in %: " + maennerAnteil() + "%");
        System.out.println("Divers in %: " + diversAnteil() + "%");
        System.out.println("Durchschnitt Alter: " + avgAlter());
        System.out.println("---------KURSTEILNEHMER-------");
        printTeilnehmer();
    }

    public void printTeilnehmer() {
        for (Teilnehmer teilnehmer: teilnehmer) {
             teilnehmer.printInfo();
        }
    }

    public float belegungInProzent() {
        int teilnehmer = this.teilnehmer.size();
        return ((float) teilnehmer / this.maxteilnehmer) * 100;
    }

    public float frauenAnteil() {
        int anzahlFrauen = 0;
        for (Teilnehmer teilnehmer : teilnehmer) {
            if (teilnehmer.getGeschlecht() == 'w') {
                anzahlFrauen++;
            }
        }
        return ((float) anzahlFrauen / this.getTeilnehmer().size()) * 100;
    }

    public float maennerAnteil() {
        int anzahlMaenner = 0;
        for (Teilnehmer teilnehmer : teilnehmer) {
            if (teilnehmer.getGeschlecht() == 'm') {
                anzahlMaenner++;
            }
        }
        return ((float) anzahlMaenner / this.getTeilnehmer().size()) * 100;
    }

    public float diversAnteil() {
        int anzahlDivers = 0;
        for (Teilnehmer teilnehmer : teilnehmer) {
            if (teilnehmer.getGeschlecht() == 'd') {
                anzahlDivers++;
            }
        }
        return ((float) anzahlDivers / this.getTeilnehmer().size() * 100);
    }

    public float avgAlter() {
        int alter = 0;
        for (Teilnehmer teilnehmer : teilnehmer) {
            alter += teilnehmer.getAlter();
        }
        return ((float) alter / teilnehmer.size());
    }

    public void removeTeilnehmerWithName(String vorname, String nachname) {
        teilnehmer.removeIf(teilnehmer -> teilnehmer.getVorname().equalsIgnoreCase(vorname) || teilnehmer.getNachname().equalsIgnoreCase(nachname));
    }






}
