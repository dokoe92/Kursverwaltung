import java.util.ArrayList;

public class Institut {
    private String name;
    private ArrayList<Kurs> kurse;

    public Institut(String name) {
        this.name = name;
        this.kurse = new ArrayList<>();
    }

    public String getName() {
        return name;
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
            System.out.println(kurs.getName());
        }
    }
}
