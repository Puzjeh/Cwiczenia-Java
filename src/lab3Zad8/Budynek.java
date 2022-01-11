package lab3Zad8;

public class Budynek {
    private String nazwDom;
    private int lKondygn;
    private double cena;

    public Budynek(String nazwDom, int lKondygn, double cena) {
        this.nazwDom = nazwDom;
        this.lKondygn = lKondygn;
        this.cena = cena;
    }

    public String getNazwDom() {
        return nazwDom;
    }

    public void setNazwDom(String nazwDom) {
        this.nazwDom = nazwDom;
    }

    public int getlKondygn() {
        return lKondygn;
    }

    public void setlKondygn(int lKondygn) {
        this.lKondygn = lKondygn;
    }

    public double getCena() {
        return cena;
    }

    public void setCena(double cena) {
        this.cena = cena;
    }
}
