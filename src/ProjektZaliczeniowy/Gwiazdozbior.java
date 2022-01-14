package ProjektZaliczeniowy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.TreeMap;

public class Gwiazdozbior implements Serializable {
    private String nazwaGwiazdozbioru;
    private ArrayList<Gwiazda> gwiazdywGwiazdozbiorze;

    public Gwiazdozbior() {
    }

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
    private final static TreeMap<Integer, String> map = new TreeMap<>();
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
            posortowaneNazwy.get(i).setNazwaKatalogowa(map.get(i).toUpperCase() + " "+ getNazwaGwiazdozbioru().toUpperCase());
        }
        return posortowaneNazwy;
    }

    public static void WyswietlWszystkieGwiazdy(ArrayList<Gwiazdozbior> gwiazdozbiory){
        for(Gwiazdozbior g : gwiazdozbiory){
            for(Gwiazda gw : g.getGwiazdywGwiazdozbiorze()){
                System.out.println(gw.toString());
            }

        }
    }

    public static void WyswietlGwiazdywOdleglosci(ArrayList<Gwiazdozbior> gwiazdozbiory){
        boolean tmp = true;
        boolean czyJestGwiazda = false;
        while(tmp){
            System.out.println("Podaj odleglosc w parsekach (1 parsek to 3.26 roku swietlnego)");
            System.out.println("0--Wroc");
            try{
                Scanner scanner = new Scanner(System.in);
                double parseki = scanner.nextDouble();
                if(parseki == 0){
                    break;
                }else{
                    for (Gwiazdozbior g : gwiazdozbiory){
                        for(Gwiazda gw : g.getGwiazdywGwiazdozbiorze()){
                            if(gw.getOdlegloscwLatachSwietlnych()<=parseki/3.26){
                                System.out.println(gw.toString());
                                tmp=false;
                                czyJestGwiazda = true;
                            }
                        }
                    }
                }
                if(!czyJestGwiazda){
                    System.out.println("Nie ma gwiazd w podanej odleglosci");
                }
            }catch (InputMismatchException e){
                System.out.println("Podales liczbe w zlym formacie");
            }

        }
    }

    public static void WyswietlGwiazdywPrzedzialeTemperatury(ArrayList<Gwiazdozbior> gwiazdozbiory){
        boolean tmp = true;
        boolean czyJestGwiazda = false;
        while(tmp){
            System.out.println("Podaj minimalna temperature, zatwierdz, nastepnie podaj maksymalna temperature");
            System.out.println("Minimalna temperatura gwiazd wynosi 2000 stopni celsjusza");
            System.out.println("0--Wroc");
            try{
                Scanner scanner = new Scanner(System.in);
                double tempMin = scanner.nextDouble();
                double tempMax = scanner.nextDouble();
                if(tempMin == 0 || tempMax ==0){
                    break;
                }else{
                    for (Gwiazdozbior g : gwiazdozbiory){
                        for(Gwiazda gw : g.getGwiazdywGwiazdozbiorze()){
                            if(gw.getTemperatura()>=tempMin && gw.getTemperatura()<=tempMax){
                                System.out.println(gw.toString());
                                tmp = false;
                                czyJestGwiazda = true;
                            }
                        }
                    }
                }
                if(!czyJestGwiazda){
                    System.out.println("Nie ma gwiazd w podanym przedziale temperatur");
                }
            }catch (InputMismatchException e){
                System.out.println("Podales liczbe w zlym formacie");
            }

        }
    }

    public static void WyswietlGwiazdywPrzedzialeWielkosci(ArrayList<Gwiazdozbior> gwiazdozbiory){
        boolean tmp = true;
        boolean czyJestGwiazda = false;
        while(tmp){
            System.out.println("Podaj minimalna obserwowana wielkosc gwiazdowa, zatwierdz, nastepnie podaj maksymalna wielkosc");
            System.out.println("Minimalna obserwowana wielkosc gwiazdowa wynosi -26.74, natomiast maksymalna 15.0");
            System.out.println("Cyfry oddzielamy przecinkiem, nie kropką");
            System.out.println("0--Wroc");
            try{
                Scanner scanner = new Scanner(System.in);
                double wielkoscMin = scanner.nextDouble();
                double wielkoscMax = scanner.nextDouble();
                if(wielkoscMin == 0 || wielkoscMax ==0){
                    break;
                }else{
                    for (Gwiazdozbior g : gwiazdozbiory){
                        for(Gwiazda gw : g.getGwiazdywGwiazdozbiorze()){
                            if(gw.getObserwowanaWielkoscGwiazdowa()>=wielkoscMin && gw.getObserwowanaWielkoscGwiazdowa()<=wielkoscMax){
                                System.out.println(gw.toString());
                                tmp = false;
                                czyJestGwiazda = true;
                            }
                        }
                    }
                }
                if(!czyJestGwiazda){
                    System.out.println("Nie ma gwiazd w podanym przedziale wielkosci");
                }
            }catch (InputMismatchException e){
                System.out.println("Podales liczbe w zlym formacie");
            }

        }
    }

    public static void WyswietlGwiazdyWedlugPolkuli(ArrayList<Gwiazdozbior> gwiazdozbiory){
        boolean tmp = true;
        boolean czyJestGwiazda = false;
        while(tmp){
            System.out.println("Wybierz polkule, z ktorej gwiazda jest widoczna (PN/PD)");
            System.out.println("0--Wroc");
            try{
                Scanner scanner = new Scanner(System.in);
                String polkula = scanner.nextLine();
                if(polkula.equalsIgnoreCase("0")){
                    break;
                }else if(polkula.equalsIgnoreCase("PN") || polkula.equalsIgnoreCase("PD")){
                    for (Gwiazdozbior g : gwiazdozbiory){
                        for(Gwiazda gw : g.getGwiazdywGwiazdozbiorze()){
                            if(gw.getPolkula().equalsIgnoreCase(polkula)){
                                System.out.println(gw.toString());
                                tmp = false;
                                czyJestGwiazda = true;
                            }
                        }
                    }
                }else{
                    System.out.println("Nie ma takiej polkuli");
                }
                if(!czyJestGwiazda){
                    System.out.println("Nie ma gwiazd widocznych z tej polkuli");
                }
            }catch (InputMismatchException e){
                System.out.println("Podales wartosc w zlym formacie");
            }

        }
    }

    public static void WyswietlNazwyGwiazdozbiorow(ArrayList<Gwiazdozbior> gwiazdozbiory){
        System.out.println("Gwiazdozbiory w bazie:");
        for(Gwiazdozbior g : gwiazdozbiory){
            System.out.println(g.getNazwaGwiazdozbioru());
        }
    }

    public static void WyswietlGwiazdywGwiazdozbiorze(ArrayList<Gwiazdozbior> gwiazdozbiory){
        boolean tmp = true;
        boolean czyJestGwiazdozbior = false;
        while(tmp){
            WyswietlNazwyGwiazdozbiorow(gwiazdozbiory);
            System.out.println("Wpisz nazwe gwiazdozbioru do wyswietlenia");
            System.out.println("0--Wroc");
            Scanner scanner = new Scanner(System.in);
            String wybor = scanner.nextLine();
            if(wybor.equalsIgnoreCase("0")){
                break;
            }else{
                for(Gwiazdozbior g : gwiazdozbiory){
                    if (g.getNazwaGwiazdozbioru().equalsIgnoreCase(wybor)){
                        for(Gwiazda gw : g.getGwiazdywGwiazdozbiorze()){
                            System.out.println(gw.toString());
                            tmp=false;
                            czyJestGwiazdozbior = true;
                        }
                    }
                }
            }
            if(!czyJestGwiazdozbior){
                System.out.println("Nie ma takiego gwiazdozbioru");
            }
        }
    }

    public static void WyswietlSupernowe(ArrayList<Gwiazdozbior> gwiazdozbiory){
        int ileGwiazd = 0;
        for(Gwiazdozbior g : gwiazdozbiory){
            for(Gwiazda gw : g.getGwiazdywGwiazdozbiorze()){
                if(gw.getMasa()>1.44){
                    System.out.println(gw);
                    ileGwiazd++;
                }
            }
        }
        if(ileGwiazd == 0){
            System.out.println("W bazie nie ma potencjalnych supernow");
        }
    }

    public static void UsunGwiazde(ArrayList<Gwiazdozbior> gwiazdozbiory){

        boolean deleteLoop = true;
        while(deleteLoop){
            System.out.println("Podaj nazwe katalogowa gwiazdy ktora chcesz usunac z bazy");
            System.out.println("0--Wroc");
            Scanner scanner = new Scanner(System.in);
            String gwiazda = scanner.nextLine();
            boolean tmp = true;
            if(gwiazda.equalsIgnoreCase("0")){
                break;
            }else{
                Gwiazda doUsuniecia = new Gwiazda();
                for(Gwiazdozbior g : gwiazdozbiory) {
                    for (Gwiazda gw : g.getGwiazdywGwiazdozbiorze()) {
                        if (gw.getNazwaKatalogowa().equalsIgnoreCase(gwiazda)) {
                            doUsuniecia = gw;
                        }
                    }
                    if(g.getGwiazdywGwiazdozbiorze().remove(doUsuniecia)){
                        tmp = false;
                        deleteLoop = false;
                    }
                    g.setGwiazdywGwiazdozbiorze(g.SortujGwiazdy());
                }
                if(!tmp){
                    System.out.println("Gwiazda zostala usunieta");
                }else{
                    System.out.println("Nie znaleziono takiej gwiazdy");
                    UsunGwiazde(gwiazdozbiory);
                }
            }

        }
    }

    public static void DodajGwiazdozbior(ArrayList<Gwiazdozbior> gwiazdozbiory, String nazwa, ArrayList<Gwiazda> gwiazdy){
        Gwiazdozbior nowyGwiazdozbior = new Gwiazdozbior();
        nowyGwiazdozbior.setNazwaGwiazdozbioru(nazwa);
        nowyGwiazdozbior.setGwiazdywGwiazdozbiorze(gwiazdy);
        gwiazdozbiory.add(nowyGwiazdozbior);
    }

    public static void DodajGwiazde(ArrayList<Gwiazdozbior> gwiazdozbiory) {
        try {
            boolean addLoop = true;
            while (addLoop) {
                Gwiazda nowaGwiazda = new Gwiazda();
                Scanner scanner = new Scanner(System.in);
                System.out.println("1--Wybierz gwiazdozbior z bazy");
                System.out.println("2--Stworz nowy gwiazdozbior");
                System.out.println("0--Wroc do menu");
                int wybor = scanner.nextInt();
                if (wybor == 0) {
                    addLoop = false;
                } else if (wybor == 1) {
                    WyswietlNazwyGwiazdozbiorow(gwiazdozbiory);
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Podaj nazwe gwiazdozbioru");
                    String nazwaGwiazdozbioru = scanner1.nextLine();
                    int czyJestGwiazdozbior = 0;
                    for (Gwiazdozbior g : gwiazdozbiory) {
                        if (g.getNazwaGwiazdozbioru().contains(nazwaGwiazdozbioru.toUpperCase())) {
                            czyJestGwiazdozbior++;
                            boolean tmp = false;
                            while (!tmp) {
                                System.out.println("Nazwa gwiazdy powinna skladac sie z 3 duzych liter i 4 cyfr");
                                System.out.println("Podaj nazwe gwiazdy");
                                String nazwa = scanner1.nextLine();
                                char[] znaki = nazwa.toCharArray();
                                int ileLiter = 0;
                                int ileCyfr = 0;
                                for (char c : znaki) {
                                    if (c >= 48 && c <= 57) {
                                        ileCyfr++;
                                    } else if (c >= 65 && c <= 90) {
                                        ileLiter++;
                                    }
                                }
                                if (ileLiter != 3 || ileCyfr != 4) {
                                    System.out.println("Błedna nazwa");
                                } else {
                                    nowaGwiazda.setNazwa(nazwa);
                                    tmp = true;
                                }
                            }

                            tmp = false;

                            while (!tmp) {

                                System.out.println("Podaj deklinacje (stopnie, minuty, sekundy");
                                System.out.println("Kazda wartosc zatwierdz");
                                System.out.println("Cyfry oddzielamy przecinkiem, nie kropką");
                                int stopnie = scanner.nextInt();
                                int minuty = scanner1.nextInt();
                                double sekundy = scanner1.nextDouble();
                                if (stopnie >= -90 && stopnie <= 90 && minuty >= -60 && minuty <= 60 &&
                                        sekundy >= -60 && sekundy <= 60) {
                                    nowaGwiazda.setDeklinacja(stopnie, minuty, sekundy);
                                    tmp = true;
                                } else {
                                    System.out.println("Niepoprawne wartosci wspolrzednej");
                                }

                            }
                            tmp = false;

                            while (!tmp) {

                                System.out.println("Podaj rektascensje (godziny, minuty, sekundy");
                                int godziny = scanner.nextInt();
                                int minuty = scanner1.nextInt();
                                int sekundy = scanner1.nextInt();
                                if (godziny >= 0 && godziny <= 24 && minuty >= 0 && minuty <= 60 && sekundy >= 0 && sekundy <= 60) {
                                    nowaGwiazda.setRektascensja(godziny, minuty, sekundy);
                                    tmp = true;
                                } else {
                                    System.out.println("Niepoprawne wartosci wspolrzednej");
                                }

                            }
                            tmp = false;

                            while (!tmp) {

                                System.out.println("Obserwowana wielkosc gwiazdowa przyjmuje wartosci od -26.74 do 15.0");
                                System.out.println("Cyfry oddzielamy przecinkiem, nie kropką");
                                System.out.println("Podaj obserwowana wielkosc gwiazdowa");
                                double wielkosc = scanner1.nextDouble();
                                if (wielkosc >= -26.74 && wielkosc <= 15.00) {
                                    nowaGwiazda.setObserwowanaWielkoscGwiazdowa(wielkosc);
                                    tmp = true;
                                } else {
                                    System.out.println("Wartosc spoza zakresu");
                                }

                            }
                            tmp = false;

                            while (!tmp) {
                                System.out.println("Cyfry oddzielamy przecinkiem, nie kropką");
                                System.out.println("Podaj odleglosc w latach swietlnych");
                                double odleglosc = scanner1.nextDouble();
                                if (odleglosc > 0) {
                                    nowaGwiazda.setOdlegloscwLatachSwietlnych(odleglosc);
                                    tmp = true;
                                } else {
                                    System.out.println("Odleglosc nie moze byc wartoscia ujemna");
                                }

                            }
                            tmp = false;
                            nowaGwiazda.setGwiazdozbior(nazwaGwiazdozbioru.toUpperCase());
                            while (!tmp) {

                                System.out.println("Podaj temperature. Temperatura minimalna to 2000 (stopni celsjusza)");
                                double temperatura = scanner1.nextDouble();
                                if (temperatura >= 2000) {
                                    nowaGwiazda.setTemperatura(temperatura);
                                    tmp = true;
                                } else {
                                    System.out.println("Temperatura gwiazdy nie moze byc nizsza niz 2000*C");
                                }

                            }
                            tmp = false;

                            while (!tmp) {
                                System.out.println("Cyfry oddzielamy przecinkiem, nie kropką");
                                System.out.println("Podaj mase gwiazdy w odniesieniu do masy slonca.");
                                System.out.println("Minimalna masa wynosi 0.1, maksymalna 15");
                                double masa = scanner1.nextDouble();
                                if (masa < 0.1) {
                                    System.out.println("Minimalna masa to 0.1");
                                } else if (masa > 50) {
                                    System.out.println("Maksymalna masa to 50");
                                } else {
                                    nowaGwiazda.setMasa(masa);
                                    tmp = true;
                                }

                            }
                            nowaGwiazda.setAbsolutnaWielkoscGwiazdowa();
                            nowaGwiazda.setPolkula();

                            g.getGwiazdywGwiazdozbiorze().add(nowaGwiazda);
                            g.SortujGwiazdy();
                        }
                    }
                    if (czyJestGwiazdozbior == 0) {
                        System.out.println("Nie znaleziono gwiazdozbioru o nazwie: " + nazwaGwiazdozbioru);
                    }
                } else if (wybor == 2) {
                    Scanner scanner1 = new Scanner(System.in);
                    System.out.println("Podaj nazwe gwiazdozbioru");
                    String nazwa = scanner1.nextLine();
                    ArrayList<Gwiazda> gwiazdy = new ArrayList<>();
                    DodajGwiazdozbior(gwiazdozbiory, nazwa.toUpperCase(), gwiazdy);
                } else {
                    System.out.println("Nie ma takiej funkcji");
                }
            }


        } catch (InputMismatchException e) {
            System.out.println("Bledny format danych");
        }
    }


    public static void Wyswietl(ArrayList<Gwiazdozbior> gwiazdozbiory){
        boolean showLoop = true;
        while(showLoop) {
            System.out.println("1--Wyswietl wszystkie gwiazdy");
            System.out.println("2--Wyswietl gwiazdozbiory");
            System.out.println("3--Wyswietl gwiazdy w wybranym gwiazdozbiorze");
            System.out.println("4--Wyswietl gwiazdy w zadanej odleglosci");
            System.out.println("5--Wyswietl gwiazdy z przedziału temperatury");
            System.out.println("6--Wyswietl gwiazdy z przedzialu obserwowanej wielkosci gwiazdowej");
            System.out.println("7--Wyswietl gwiazdy widoczne z danej polkuli");
            System.out.println("8--Wyswietl potencjalne supernowe");
            System.out.println("0--Wroc");
            Scanner scanner = new Scanner(System.in);
            int wyswietl = scanner.nextInt();
            switch (wyswietl) {
                case 1 -> WyswietlWszystkieGwiazdy(gwiazdozbiory);
                case 2 -> WyswietlNazwyGwiazdozbiorow(gwiazdozbiory);
                case 3 -> WyswietlGwiazdywGwiazdozbiorze(gwiazdozbiory);
                case 4 -> WyswietlGwiazdywOdleglosci(gwiazdozbiory);
                case 5 -> WyswietlGwiazdywPrzedzialeTemperatury(gwiazdozbiory);
                case 6 -> WyswietlGwiazdywPrzedzialeWielkosci(gwiazdozbiory);
                case 7 -> WyswietlGwiazdyWedlugPolkuli(gwiazdozbiory);
                case 8 -> WyswietlSupernowe(gwiazdozbiory);
                case 0 -> showLoop = false;
                default -> System.out.println("Nie ma takiej funkcji");
            }
        }
    }
}
