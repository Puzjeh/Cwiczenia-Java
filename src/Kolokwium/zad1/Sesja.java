package Kolokwium.zad1;
public class Sesja {
    private String[] egzaminy;
    private int zdane;
    private int niezdane;
    private int pozostale;
    private String[] terminy;

    public Sesja(String[] egzaminy,  String[] terminy) {
        this.egzaminy = egzaminy;
        this.zdane = 0;
        this.niezdane = 0;
        this.pozostale = egzaminy.length;
        this.terminy = terminy;
    }

    public Sesja(){
        this.egzaminy = new String[10];
        this.zdane = 0;
        this.niezdane = 0;
        this.pozostale = 10;
        this.terminy = new String[10];
    }

    public Sesja(Sesja obiekt){
        this.egzaminy = obiekt.getEgzaminy();
        this.zdane = obiekt.getZdane();
        this.niezdane = obiekt.getNiezdane();
        this.pozostale = obiekt.getPozostale();
        this.terminy = obiekt.getTerminy();
    }

    public Sesja(String nazwa1, String termin1, String nazwa2, String termin2, String nazwa3, String termin3){
        this.egzaminy = new String[]{nazwa1, nazwa2, nazwa3};
        this.zdane = 0;
        this.niezdane = 0;
        this.pozostale = 3;
        this.terminy = new String[]{termin1, termin2, termin3};
    }

    public String[] getEgzaminy() {
        return egzaminy;
    }

    public void setEgzaminy(String[] egzaminy) {
        this.egzaminy = egzaminy;
    }

    public int getZdane() {
        return zdane;
    }

    public void setZdane(int zdane) {
        this.zdane = zdane;
    }

    public int getNiezdane() {
        return niezdane;
    }

    public void setNiezdane(int niezdane) {
        this.niezdane = niezdane;
    }

    public int getPozostale() {
        return pozostale;
    }

    public void setPozostale(int pozostale) {
        this.pozostale = pozostale;
    }

    public String[] getTerminy() {
        return terminy;
    }

    public void setTerminy(String[] terminy) {
        this.terminy = terminy;
    }

    public int IleDoKonca(String dzien){

        int ilePozostalo = 0;
        int podanaData = Integer.parseInt(dzien);
        for(String termin : this.getTerminy()){
            int terminData = Integer.parseInt(termin);
            if(terminData>podanaData){
                ilePozostalo++;
            }
        }
        return ilePozostalo;
    }
}