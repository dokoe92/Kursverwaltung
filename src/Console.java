import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Console {
    private ArrayList<Institut> institute;

    public Console() {
        this.institute = new ArrayList<>();
    }

    public void addInstitut(Institut institut) {
        if (institut != null) {
            institute.add(institut);
        }
    }


    public void printConsole() {
        System.out.println("##########################################");
        System.out.println("##############KURSVERWALTUNG##############");
        System.out.println("##########################################");
        System.out.println("Was möchten Sie tun?");
        System.out.println("1. Institut auswählen");
        System.out.println("2. Neues Institut hinzufügen");
        System.out.println("3. Exit");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        switch (input) {
            case 1:
                browseInstitutes();
                break;
            case 2:
                addNewÍnstitute();
                break;
            case 3:
                System.exit(0);
                break;
        }

    }

/* ---------'INSTUTUT OPTIONEN ---------*/
    public void browseInstitutes() {
        int institutID = getInstitutId();
        int kursID = getKursId(institutID);
        getKursInfo(institutID, kursID);
    }

    public int getInstitutId() {
        System.out.println("---------------------------Registrierte Institute------------------------");
        System.out.println("---------Für Kursdetails geben Sie die jeweilige ID nummer ein-----------");
        for (Institut institut : institute) {
            System.out.println("ID: " + institut.getId() + ". Name:      " + institut.getName());
        }
        int exit = Institut.laufVariable + 1;
        System.out.println(exit + ". Exit");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == exit) {
            System.exit(0);
            return 0;
        } else {
            return input;
        }
    }

    public void addNewÍnstitute() {
        System.out.println("--------Neues Institut hinzufügen--------");
        Scanner scanner = new Scanner(System.in);
        String instutName = scanner.nextLine();
        institute.add(new Institut(instutName));
    }

    public int getKursId(int instutID) {
        System.out.println("----------Folgende Kurse sind in diesem Institut verfügbar-------------");
        for (Institut institut : institute) {
            if (institut.getId() == instutID) {
                institut.showKurse();
            }
        }
        int exit = Kurs.laufVariable +1;
        System.out.println(exit + ". Exit");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == exit) {
            System.exit(0);
            return 0;
        } else {
            return input;
        }
    }

    public void getKursInfo(int institutId, int kursId) {
        Kurs kursMitId = null;
        for (Institut institut : institute) {
            if (institut.getId() == institutId) {
                for (Kurs kurs : institut.getKurse()){
                    if(kursId == kurs.getId()) {
                        kursMitId = kurs;
                        kurs.printInfos();
                    }
                }
            }
        }
        System.out.println("--------Kursteilnehmer hinzufügen oder entfernen-----------");
        System.out.println("1. Hinzufügen");
        System.out.println("2. Entfernen");
        Scanner scanner  = new Scanner(System.in);
        int input = scanner.nextInt();
        scanner.nextLine();
        if (kursMitId != null) {
            switch(input) {
                case 1:
                    System.out.println("-----Teilnehmer hinzufügen------");
                    System.out.println("#################################");
                    System.out.println("Bitte Vornamen eingeben: ");
                    String vorname = scanner.nextLine();
                    System.out.println("Bitte Nachnamen eingeben: ");
                    String nachname = scanner.nextLine();
                    System.out.println("Bitte Geschlecht eingeben: (m, w, d)");
                    String sex = scanner.nextLine();
                    char sexChar = sex.charAt(0);
                    System.out.println("Bitte Geburtstag eingeben: (YYYY-MM-DD");
                    String date = scanner.nextLine();
                    LocalDate birthdate = LocalDate.parse(date);
                    kursMitId.addTeilnehmer(new Teilnehmer(vorname, nachname, sexChar, birthdate));
                    break;

                case 2:
                    System.out.println("----------Teilnehmer löschen-------------");
                    System.out.println("#########################################");
                    System.out.println("Bitte geben Sie Vor und Nachnamen des zu löschenden Teilnehmers ein:");
                    vorname = scanner.nextLine();
                    nachname = scanner.nextLine();
                    kursMitId.removeTeilnehmerWithName("vorname", "nachname");
            }
        }
    }



}
