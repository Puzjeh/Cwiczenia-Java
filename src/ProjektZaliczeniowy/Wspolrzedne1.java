package ProjektZaliczeniowy;

import java.io.Serializable;
//klasa pomocnicza w naszym projekcie
//sluzy do przechowywania parametrow wspolrzednych dla deklinacji
public class Wspolrzedne1 implements Serializable {
    private int stopnie;
    private int minuty;
    private double sekundy;

    public Wspolrzedne1(int stopnie, int minuty, double sekundy) {
        this.stopnie = stopnie;
        this.minuty = minuty;
        this.sekundy = sekundy;
    }

    public int getStopnie() {
        return stopnie;
    }

    public int getMinuty() {
        return minuty;
    }

    public double getSekundy() {
        return sekundy;
    }

    public void setStopnie(int stopnie) {
        this.stopnie = stopnie;
    }

    public void setMinuty(int minuty) {
        this.minuty = minuty;
    }

    public void setSekundy(double sekundy) {
        this.sekundy = sekundy;
    }

    @Override
    public String toString() {
        return stopnie+"*"+minuty+"'"+sekundy+"''";
    }
}
