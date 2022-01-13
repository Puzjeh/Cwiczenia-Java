package ProjektZaliczeniowy;

import java.io.Serializable;

public class Wspolrzedne2 implements Serializable {
    private int godziny;
    private int minuty;
    private int sekundy;

    public Wspolrzedne2(int godziny, int minuty, int sekundy) {
        this.godziny = godziny;
        this.minuty = minuty;
        this.sekundy = sekundy;
    }

    public int getGodziny() {
        return godziny;
    }

    public void setGodziny(int godziny) {
        this.godziny = godziny;
    }

    public int getMinuty() {
        return minuty;
    }

    public void setMinuty(int minuty) {
        this.minuty = minuty;
    }

    public int getSekundy() {
        return sekundy;
    }

    public void setSekundy(int sekundy) {
        this.sekundy = sekundy;
    }

    @Override
    public String toString() {
        return godziny+"h " + minuty+"m "+ sekundy+"s";
    }
}
