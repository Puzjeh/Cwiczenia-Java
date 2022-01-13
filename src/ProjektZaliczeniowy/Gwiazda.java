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

    public Gwiazda() {

    }

    public Gwiazda(String nazwa, int stopnie, int minuty, double sekundy, int godziny, int minutyy, int sekundyy,
                   double obserwowanaWielkoscGwiazdowa, double odlegloscwLatachSwietlnych, String gwiazdozbior,
                   double temperatura, double masa) {
        this.nazwa = nazwa;
        this.deklinacja = setDeklinacja(stopnie, minuty, sekundy);
        this.rektascensja = setRektascensja(godziny, minutyy, sekundyy);
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
        char[] znaki = nazwa.toCharArray();
        int ileLiter = 0;
        int ileCyfr = 0;
        for(char c : znaki){
            if(c>=48 && c<=57){
                ileCyfr++;
            }
            else if(c>=65 && c<=90){
                ileLiter++;
            }
        }
        if(ileLiter != 3 || ileCyfr != 4){
            System.out.println("Błedna nazwa");
        }
        else{
            this.nazwa = nazwa;
        }
    }

    public String getNazwaKatalogowa() {
        return nazwaKatalogowa;
    }

    public String setNazwaKatalogowa(String nowaNazwa) {
        return this.nazwaKatalogowa = nowaNazwa;
    }

    public Wspolrzedne1 getDeklinacja() {
        return deklinacja;
    }

    public Wspolrzedne1 setDeklinacja(int stopnie, int minuty, double sekundy) {
        if(stopnie >=-90 && stopnie <=90 && minuty >=-60 && minuty <=60 &&
                sekundy >=-60 && sekundy <=60){
            this.deklinacja = new Wspolrzedne1(stopnie, minuty, sekundy);
        }else{
            System.out.println("Niepoprawne wartosci wspolrzednej");
        }
        return this.deklinacja;
    }

    public Wspolrzedne2 getRektascensja() {
        return rektascensja;
    }

    public Wspolrzedne2 setRektascensja(int godziny, int minutyy, int sekundyy) {
        if(godziny>=0 && godziny <=24 && minutyy>=0 && minutyy<=60 && sekundyy>=0&&sekundyy<=60){
            this.rektascensja = new Wspolrzedne2(godziny, minutyy, sekundyy);
        }else{
            System.out.println("Niepoprawne wartosci wspolrzednej");
        }
        return this.rektascensja;
    }

    public double getObserwowanaWielkoscGwiazdowa() {
        return obserwowanaWielkoscGwiazdowa;
    }

    public void setObserwowanaWielkoscGwiazdowa(double obserwowanaWielkoscGwiazdowa) {
        if(obserwowanaWielkoscGwiazdowa>=-26.74 && obserwowanaWielkoscGwiazdowa<=15.00){
            this.obserwowanaWielkoscGwiazdowa = obserwowanaWielkoscGwiazdowa;
        }else{
            System.out.println("Wartosc spoza zakresu");
        }
    }

    public double getAbsolutnaWielkoscGwiazdowa() {
        return absolutnaWielkoscGwiazdowa;
    }

    public double setAbsolutnaWielkoscGwiazdowa() {
        double a = obserwowanaWielkoscGwiazdowa - 5*(Math.log10((odlegloscwLatachSwietlnych/3.26)))+5;
        return this.absolutnaWielkoscGwiazdowa = Math.round(a*100.00)/100.00;
    }

    public double getOdlegloscwLatachSwietlnych() {
        return odlegloscwLatachSwietlnych;
    }

    public void setOdlegloscwLatachSwietlnych(double odlegloscwLatachSwietlnych) {
        if(odlegloscwLatachSwietlnych>0){
            this.odlegloscwLatachSwietlnych = odlegloscwLatachSwietlnych;
        }else{
            System.out.println("Odleglosc nie moze byc wartoscia ujemna");
        }

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
        if(temperatura>=2000){
            this.temperatura = temperatura;
        }else{
            System.out.println("Temperatura gwiazdy nie moze byc nizsza niz 2000*C");
        }

    }

    public double getMasa() {
        return masa;
    }

    public void setMasa(double masa) {
        if(masa<0.1){
            System.out.println("Minimalna masa to 0.1");
        }else if(masa >50){
            System.out.println("Maksymalna masa to 50");
        }else{
            this.masa = masa;
        }
    }

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
