import java.sql.Array;
import java.sql.SQLOutput;
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
        while (true) {
            System.out.println("##########################################");
            System.out.println("##############KURSVERWALTUNG##############");
            System.out.println("##########################################");
            System.out.println("Was möchten Sie tun?");
            System.out.println("1. Institut auswählen");
            System.out.println("2. Kurse durchsuchen");
            System.out.println("3. Exit");
            Scanner scanner = new Scanner(System.in);
            int input = scanner.nextInt();
            switch (input) {
                case 1 -> browseInstitutes();
                case 2 -> brosweKurse();
                case 3 -> System.exit(0);
            }

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
        int addInstitute = Institut.laufVariable + 1;
        int returnButton = Institut.laufVariable +2;
        int exit = Institut.laufVariable + 3;
        System.out.println(addInstitute + ". Institut hinzufügen");
        System.out.println(returnButton + ". Return");
        System.out.println(exit + ". Exit");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == exit) {
            System.exit(0);
            return 0;
        } else if (input == returnButton) {
            printConsole();
            return 0;
        } else if (input == addInstitute) {
            addNewÍnstitute();
            return 0;
        }
        else {
            return input;
        }
    }

    public void addNewÍnstitute() {
        System.out.println("----------------Neues Institut hinzufügen--------");
        System.out.println("-----Bitte den Nanem des neuen Instituts eingeben------");
        System.out.println("\n");
        System.out.println("Optionen:");
        System.out.println("1. Return");
        System.out.println("2. Exit");
        Scanner scanner = new Scanner(System.in);
        String instutName = scanner.nextLine();
        try {
            int input = Integer.parseInt(instutName);
            if (input == 1) {
                getInstitutId();
            } else if (input == 2) {
                System.exit(0);
            }
        } catch(Exception e) {
            institute.add(new Institut(instutName));
            getInstitutId();
        }
    }

    public int getKursId(int instutID) {
        System.out.println("----------Folgende Kurse sind in diesem Institut verfügbar-------------");
        for (Institut institut : institute) {
            if (institut.getId() == instutID) {
                institut.showKurse();
            }
        }
        int addKurs = Kurs.laufVariable + 1;
        int returnButton = Kurs.laufVariable + 2;
        int exit = Kurs.laufVariable + 3;
        System.out.println(addKurs + ". Kurs hinzufügen");
        System.out.println(returnButton + ". Return");
        System.out.println(exit + ". Exit");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == exit) {
            System.exit(0);
            return 0;
        } else if (input == returnButton) {
            getInstitutId();
            return 0;
        } else if (input == addKurs) {
            addKursToInstitut(instutID);
            return 0;
        }else {
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
        System.out.println("3. Return");
        System.out.println("4. Exit");
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
                    try {
                        LocalDate birthdate = LocalDate.parse(date);
                        kursMitId.addTeilnehmer(new Teilnehmer(vorname, nachname, sexChar, birthdate));
                    } catch(Exception e) {
                        System.out.println("Falsches Datum FORMAT YYYY-MM-DD");
                        getKursInfo(institutId, kursId);
                    }

                    browseInstitutes();
                    break;

                case 2:
                    System.out.println("----------Teilnehmer löschen-------------");
                    System.out.println("#########################################");
                    System.out.println("Bitte geben Sie den Vornamen des zu löschenden Teilnehmers ein:");
                    vorname = scanner.nextLine();
                    System.out.println("Bitte geben Sie den Nachnamen des zu löschenden Teilnehmers ein:");
                    nachname = scanner.nextLine();
                    kursMitId.removeTeilnehmerWithName(vorname, nachname);
                    browseInstitutes();
                case 3:
                    getKursId(kursId);
                case 4:
                    System.exit(0);


            }
        }
    }

    public void addKursToInstitut(int institutId) {
        System.out.println("----------Kurs hinzufügen------------");
        System.out.println("-Bitte Kursnamen eingeben:");
        Scanner scanner = new Scanner(System.in);
        String kursname = scanner.nextLine();
        System.out.println("-Bitte den Vornamen des Trainers eingeben: ");
        String trainerVorname = scanner.nextLine();
        System.out.println("-Bitte den Nachnamen des Trainers eingeben: ");
        String trainerNachname = scanner.nextLine();
        Trainer newTrainer = new Trainer(trainerVorname, trainerNachname);
        System.out.println("-Bitte die maximale Teilnehmeranzahl eingeben: ");
        int maxTeilnehmer = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Bitte den Startdatum eingeben: YYYY-MM-DD");
        String start = scanner.nextLine();
        System.out.println("Bitte das Enddatum eingeben: YYYY-MM-DD");
        String end = scanner.nextLine();


        try {
             LocalDate startDate = LocalDate.parse(start);
             LocalDate endDate = LocalDate.parse(end);

            for (Institut institut : institute) {
                if (institut.getId() == institutId) {
                    institut.addKurs(new Kurs(kursname,newTrainer, maxTeilnehmer, startDate, endDate));
                }
            }
            getKursId(institutId);

        } catch(Exception e) {
            System.out.println("Falsches Datum FORMAT YYYY-MM-DD!");
            addKursToInstitut(institutId);
        }

    }

    // --------------KURSE--------------------------
    public int brosweKurse() {
        System.out.println("-----------Liste aller verfügbarer Kurse (alle Institute)-----------");
        System.out.println("---------------------Für Kurs bitte ID eingeben---------------------");
        for (Institut institut : institute) {
            institut.showKurse();
        }
          int filtern = Kurs.laufVariable + 1;
        int returnButton = Kurs.laufVariable + 2;
        int exit = Kurs.laufVariable + 3;
        System.out.println(filtern + ". Filter");
        System.out.println(returnButton + ". Return");
        System.out.println(exit + ". Exit");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == returnButton) {
            printConsole();
            return 0;
        } else if (input == exit) {
            System.exit(0);
            return 0;
        } else if (input == filtern) {
            kurseFilter();
            return 0;
        } else {
            return input;
        }
    }

    public void kurseFilter() {
        System.out.println("-------------Kurse filtern-----------");
        System.out.println("1. Kurs nach namen suchen");
        System.out.println("2. Kurs nach Zeitraum suchen");
        System.out.println("3. Return");
        System.out.println("4. Exit");

        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        switch (input) {
            case 1 -> searchKursByName();
            case 2 -> searchKursByTime();
            case 3 -> brosweKurse();
            case 4 -> System.exit(0);
        }
    }

    public void searchKursByName() {
        System.out.println("--------Bitte Kursnamen eingeben------------");
        Scanner scanner = new Scanner(System.in);
        String kursname = scanner.nextLine();
        System.out.println("\n");
        System.out.println("1. Return");
        System.out.println("2. Exit");

        try {
            int input = Integer.parseInt(kursname);
            if (input == 1) {
                kurseFilter();
            } else if (input == 2) {
                System.exit(0);
            }
        } catch(Exception e) {
            for (Institut institut : institute) {
                institut.printKursWithName(kursname);
            }
        }
    }

    public void searchKursByTime() {
        System.out.println("-------------Kurse in Zeitraum----------------");
        System.out.println("-----------Bitte Startdatum eingeben----------");
        System.out.println("-------------Format: YYYY-MM-DD---------------");
        Scanner scanner = new Scanner(System.in);
        String start = scanner.nextLine();
        System.out.println("-----------Bitte Enddatum eingeben------------");
        System.out.println("--------------Format: YYYY-MM-DD--------------");
        String end = scanner.nextLine();
        try {
            LocalDate startDate = LocalDate.parse(start);
            LocalDate endDate = LocalDate.parse(end);

            for(Institut institut : institute) {
                ArrayList<Kurs> kurseInZeitraum = institut.kurseInZeitraum(startDate, endDate);
                for (Kurs kurs : kurseInZeitraum) {
                    kurs.printInfos();
                }
            }

        } catch(Exception e) {
            System.out.println("Falsches Format!");
            searchKursByTime();
        }


    }







}
