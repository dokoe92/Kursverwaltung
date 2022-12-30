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

    public void consoleInstitutes(){
        System.out.println("--------Institute-----------");
        getInstitutNames();

    }

    public void browseInstitutes() {
        int institutInput = getInstitutNames();
        getKursNames(institutInput);
    }

    public int getInstitutNames() {
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

    public void getKursNames(int instutID) {
        System.out.println("----------Folgende Kurse sind in diesem Institut verfügbar-------------");
        for (Institut institut : institute) {
            if (institut.getId() == instutID) {
                institut.showKurse();
            }
        }
    }
}
