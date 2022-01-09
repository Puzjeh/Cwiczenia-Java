package lab3Zad5;

import java.io.Serializable;
import java.util.Arrays;

public class Film implements Serializable {

    public String tytul;
    public String rezyser;
    public int rokProdukcji;
    public String[] aktorzy;

    public Film() {
        tytul = "unknown";
        rezyser = "unknown";
        rokProdukcji = 0;
        aktorzy = new String[]{};
    }

    public Film(String tytul, String rezyser, int rokProdukcji, String[] aktorzy) {
        this.tytul = tytul;
        this.rezyser = rezyser;
        this.rokProdukcji = rokProdukcji;
        this.aktorzy = aktorzy;
    }

    public Film(Film film) {
        this.tytul = film.tytul;
        this.rezyser = film.rezyser;
        this.rokProdukcji = film.rokProdukcji;
        this.aktorzy = film.aktorzy;
    }

    @Override
    public String toString() {
        return "Film: " +
                "tytul= '" + tytul + '\'' +
                ", rezyser= " + rezyser +
                ", rokProdukcji= " + rokProdukcji +
                ", aktorzy= " + Arrays.toString(aktorzy);
    }

    public void PrzedstawSie(){
        System.out.println(this.toString());
    }

}
