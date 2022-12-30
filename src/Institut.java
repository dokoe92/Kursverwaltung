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
        if(kurs != null) {
            this.kurse.add(kurs);
        }
    }

    public void showKurse() {
        for (Kurs kurs : kurse) {
            System.out.println("ID: " + kurs.getId() +". Kursname: " + kurs.getName());
        }
    }

    private void setId() {
        laufVariable++;
        this.id = laufVariable;
    }


}
