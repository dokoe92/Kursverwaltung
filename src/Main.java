import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        Institut institut = new Institut("Codersbay");
        institut.addKurs(new Kurs("Java", new Trainer("Micahel", "Fischlemayer"), 10, LocalDate.of(2022,9,5), LocalDate.of(2023,07,29)));

        institut.addTeilnehmerToKursWithName("Java", new Teilnehmer("Dominik", "Köberl", 'm', LocalDate.of(1992,07,28)));

        Console console = new Console();
        console.addInstitut(institut);
        console.printConsole();





    }
}