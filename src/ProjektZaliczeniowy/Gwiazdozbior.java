package ProjektZaliczeniowy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.TreeMap;

public class Gwiazdozbior implements Serializable {
    private String nazwaGwiazdozbioru;
    private ArrayList<Gwiazda> gwiazdywGwiazdozbiorze;

    public String getNazwaGwiazdozbioru() {
        return nazwaGwiazdozbioru;
    }

    public void setNazwaGwiazdozbioru(String nazwaGwiazdozbioru) {
        this.nazwaGwiazdozbioru = nazwaGwiazdozbioru;
    }

    public ArrayList<Gwiazda> getGwiazdywGwiazdozbiorze() {
        return gwiazdywGwiazdozbiorze;
    }

    public void setGwiazdywGwiazdozbiorze(ArrayList<Gwiazda> gwiazdywGwiazdozbiorze) {
        this.gwiazdywGwiazdozbiorze = gwiazdywGwiazdozbiorze;
    }

    public Gwiazdozbior(String nazwaGwiazdozbioru, ArrayList<Gwiazda> gwiazdywGwiazdozbiorze) {
        this.nazwaGwiazdozbioru = nazwaGwiazdozbioru;
        this.gwiazdywGwiazdozbiorze = gwiazdywGwiazdozbiorze;
    }
    private final static TreeMap<Integer, String> map = new TreeMap<Integer, String>();
    static {
        map.put(0, "ALFA");
        map.put(1, "BETA");
        map.put(2, "GAMMA");
        map.put(3, "DELTA");
        map.put(4, "EPSILON");
        map.put(5, "DZETA");
        map.put(6, "ETA");
        map.put(7, "TETA");
        map.put(8, "JOTA");
        map.put(9, "KAPPA");
        map.put(10, "LAMBDA");
        map.put(11, "MI");
        map.put(12, "NI");
        map.put(13, "KSI");
        map.put(14, "OMIKRON");
        map.put(15, "PI");
        map.put(16, "RO");
        map.put(17, "SIGMA");
        map.put(18, "TAU");
        map.put(19, "YPSILON");
        map.put(20, "FI");
        map.put(21, "CHI");
        map.put(22, "PSI");
        map.put(23, "OMEGA");
    }

    public ArrayList<Gwiazda> SortujGwiazdy(){
        ArrayList<Gwiazda> posortowaneNazwy = getGwiazdywGwiazdozbiorze();
        for(int i = 0; i< posortowaneNazwy.size();i++){
            posortowaneNazwy.get(i).setNazwaKatalogowa(map.get(i) + " "+ getNazwaGwiazdozbioru());
        }
        return posortowaneNazwy;
    }
}
