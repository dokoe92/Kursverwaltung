import java.time.LocalDate;
import java.util.ArrayList;

public class Institut {
    public static int laufVariable  = 0;
    private int id;
    private String name;
    private ArrayList<Kurs> kurse;

    public Institut(String name) {
        this.name = name;
        this.kurse = new ArrayList<>();
        setId();
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public ArrayList<Kurs> getKurse() {
        return kurse;
    }




    public void addKurs(Kurs kurs) {
        if(kurs != null && !kursAlreadyInList(kurs)) {
            if(!kursAlreadyInList(kurs.getName())) {
                this.kurse.add(kurs);
                kurs.institut = this;
            }
        }

    }

    public boolean kursAlreadyInList (Kurs kursToAdd) {
        return kurse.contains(kursToAdd);
    }

    public boolean kursAlreadyInList(String kursName) {
        boolean kursInList = false;
        for (Kurs kurs : kurse) {
            if (kurs.getName().equalsIgnoreCase(kursName)) {
                kursInList = true;
                break;
            }
        }
        return kursInList;
    }

    public void showKurse() {
        for (Kurs kurs : kurse) {
            System.out.println("ID: " + kurs.getId() +". Kursname: " + kurs.getName() + "---Institut: " + kurs.getInstitut().getName());
        }
    }

    public void addTeilnehmerToKursWithName(String kursName, Teilnehmer teilnehmer) {
        for (Kurs kurs : kurse) {
            if (kurs.getName().equals(kursName)) {
                kurs.addTeilnehmer(teilnehmer);
            }
        }
    }

    public void printKursWithID(int kursId) {
        for (Kurs kurs : kurse) {
            if (kurs.getId() == kursId) {
                kurs.printInfos();
            }
        }
    }

    public void printKursWithName(String name) {
        boolean search = true;
        int index = 0;
        while (search && index < kurse.size()) {
            if (kurse.get(index).getName().equalsIgnoreCase(name)) {
                kurse.get(index).printInfos();
                search = false;
            }
            index++;
        }
        System.out.println("Kurs nicht gefunden!");
    }

    public ArrayList<Kurs> kurseInZeitraum(LocalDate start, LocalDate end) {
        ArrayList<Kurs> kurseInZeitraum = new ArrayList<>();

        for (Kurs kurs : kurse) {
            if ( (kurs.getStartDate().isEqual(start) || kurs.getStartDate().isAfter(start) ) && (kurs.getEndDate().isEqual(end) || kurs.getEndDate().isBefore(end)) ) {
                kurseInZeitraum.add(kurs);
            }
        }
        return kurseInZeitraum;
    }



    private void setId() {
        laufVariable++;
        this.id = laufVariable;
    }


}
