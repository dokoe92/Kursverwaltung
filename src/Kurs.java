import java.time.LocalDate;
import java.util.ArrayList;

public class Kurs {
    private final String name;
    private Trainer trainer;
    private final int  maxteilnehmer;
    private LocalDate startDate;
    private LocalDate endDate;
    private ArrayList<Teilnehmer> teilnehmer;


    public Kurs(String name, Trainer trainer, int maxteilnehmer, LocalDate startDate, LocalDate endDate) {
        this.name = name;
        this.trainer = trainer;
        this.maxteilnehmer = maxteilnehmer;
        this.startDate = startDate;
        this.endDate = endDate;
        this.teilnehmer = new ArrayList<>();
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

    public void printInfos() {
        System.out.println("#############################");
        System.out.println("###########KURSINFO##########");
        System.out.println("#############################");
        System.out.println("Name:      " + this.name);
        System.out.println("Trainer:    " + this.trainer.getVorname() + " " + this.trainer.getNachname());
        System.out.println("Max. Anzahl: " + this.maxteilnehmer);
        System.out.println("Belegung in %: ");
        System.out.println("Frauenanteil in %: ");
        System.out.println("Männeranteil in %: ");
        System.out.println("Divers in %: ");
        System.out.println("Durchschnitt Alter: ");
        System.out.println("---------KURSTEILNEHMER-------");
    }

    public void printTeilnehmer() {
        for (Teilnehmer teilnehmer: teilnehmer) {
            teilnehmer.printInfo();
        }
    }

}
