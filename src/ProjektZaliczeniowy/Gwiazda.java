package ProjektZaliczeniowy;

import java.io.Serializable;


public class Gwiazda implements Serializable {
    private String nazwa;
    private String nazwaKatalogowa;
    private Wspolrzedne1 deklinacja;
    private Wspolrzedne2 rektascensja;
    private double obserwowanaWielkoscGwiazdowa;
    private double absolutnaWielkoscGwiazdowa;
    private double odlegloscwLatachSwietlnych;
    private String gwiazdozbior;
    private String polkula;
    private double temperatura;
    private double masa;
    //konstruktor bezparametrowy na ktorym bazujemy przy dodawaniu nowej gwiazdy
    public Gwiazda() {

    }
    //konstruktor wykorzystywany do wygenerowania podstawowej bazy gwiazd przy pierwszym uruchomieniu programu
    public Gwiazda(String nazwa, int stopnie, int minuty, double sekundy, int godziny, int minutyy, int sekundyy,
                   double obserwowanaWielkoscGwiazdowa, double odlegloscwLatachSwietlnych, String gwiazdozbior,
                   double temperatura, double masa) {
        this.nazwa = nazwa;
        this.deklinacja = new Wspolrzedne1(stopnie, minuty, sekundy);
        this.rektascensja = new Wspolrzedne2(godziny, minutyy, sekundyy);
        this.obserwowanaWielkoscGwiazdowa = obserwowanaWielkoscGwiazdowa;
        this.odlegloscwLatachSwietlnych = odlegloscwLatachSwietlnych;
        this.gwiazdozbior = gwiazdozbior;
        this.temperatura = temperatura;
        this.masa = masa;
        this.absolutnaWielkoscGwiazdowa = setAbsolutnaWielkoscGwiazdowa();
        this.polkula = setPolkula();
    }


    public String getNazwa() {
        return nazwa;
    }

    public void setNazwa(String nazwa) {
        this.nazwa = nazwa;
    }

    public String getNazwaKatalogowa() {
        return nazwaKatalogowa;
    }

    public void setNazwaKatalogowa(String nowaNazwa) {
        this.nazwaKatalogowa = nowaNazwa;
    }

    public Wspolrzedne1 getDeklinacja() {
        return deklinacja;
    }

    public void setDeklinacja(int stopnie, int minuty, double sekundy) {
        this.deklinacja = new Wspolrzedne1(stopnie, minuty, sekundy);
    }

    public Wspolrzedne2 getRektascensja() {
        return rektascensja;
    }

    public void setRektascensja(int godziny, int minutyy, int sekundyy) {
        this.rektascensja = new Wspolrzedne2(godziny, minutyy, sekundyy);
    }

    public double getObserwowanaWielkoscGwiazdowa() {
        return obserwowanaWielkoscGwiazdowa;
    }

    public void setObserwowanaWielkoscGwiazdowa(double obserwowanaWielkoscGwiazdowa) {
        this.obserwowanaWielkoscGwiazdowa = obserwowanaWielkoscGwiazdowa;
    }

    public double getAbsolutnaWielkoscGwiazdowa() {
        return absolutnaWielkoscGwiazdowa;
    }
    //setter ktory na podstawie parametrow obiektu ustala absolutna wielkosc gwiazdowa
    public double setAbsolutnaWielkoscGwiazdowa() {
        double a = obserwowanaWielkoscGwiazdowa - 5*(Math.log10((odlegloscwLatachSwietlnych/3.26)))+5;
        return this.absolutnaWielkoscGwiazdowa = Math.round(a*100.00)/100.00;
    }

    public double getOdlegloscwLatachSwietlnych() {
        return odlegloscwLatachSwietlnych;
    }

    public void setOdlegloscwLatachSwietlnych(double odlegloscwLatachSwietlnych) {
        this.odlegloscwLatachSwietlnych = odlegloscwLatachSwietlnych;

    }

    public String getGwiazdozbior() {
        return gwiazdozbior;
    }

    public void setGwiazdozbior(String gwiazdozbior) {
        this.gwiazdozbior = gwiazdozbior;
    }

    public String getPolkula() {
        return polkula;
    }
    //setter, ktory na podstawie pozostalych parametrow obiektu ustala z ktorej polkuli widoczna jest gwiazda
    public String setPolkula() {
        int stopnie = getDeklinacja().getStopnie();
        int minuty = getDeklinacja().getMinuty();
        double sekundy = getDeklinacja().getSekundy();
        if(stopnie>0){
            this.polkula = "PN";
        }else if(stopnie<0){
            this.polkula = "PD";
        }else{
            if (minuty>0){
                this.polkula = "PN";
            }else if(minuty<0){
                this.polkula = "PD";
            }else{
                if (sekundy>0){
                    this.polkula = "PN";
                }else{
                    this.polkula = "PD";
                }
            }
        }
        return this.polkula;
    }

    public double getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(double temperatura) {
        this.temperatura = temperatura;
    }

    public double getMasa() {
        return masa;
    }

    public void setMasa(double masa) {
        this.masa=masa;
    }
    //nadpisanie metody toString(), ktora pozwala wyswietlic wszystkie informacje o naszej gwiezdzie na konsoli
    @Override
    public String toString() {
        return
                nazwa +
                " " + nazwaKatalogowa +
                " WSPOLRZEDNE:" + deklinacja.toString()+", " + rektascensja.toString() +
                " WIELKOSC OBS.:" + obserwowanaWielkoscGwiazdowa +
                " WIELKOSC ABS.:" + absolutnaWielkoscGwiazdowa +
                " ODLEGLOSC:" + odlegloscwLatachSwietlnych +
                " POLKULA:" + polkula + '\'' +
                " TEMP.:" + temperatura +
                " MASA:" + masa;
    }
}
