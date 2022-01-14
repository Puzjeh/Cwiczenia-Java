package ProjektZaliczeniowy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
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
            if(wybor.toCharArray()[0] == '0'){
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

    public static void UsunGwiazde(ArrayList<Gwiazdozbior> gwiazdozbiory){

        boolean deleteLoop = true;
        while(deleteLoop){
            System.out.println("Podaj nazwe katalogowa gwiazdy ktora chcesz usunac z bazy");
            System.out.println("0--Wroc");
            Scanner scanner = new Scanner(System.in);
            String gwiazda = scanner.nextLine();
            boolean tmp = true;
            if(gwiazda.toCharArray()[0] == '0'){
                break;
            }else{
                Gwiazda doUsuniecia = new Gwiazda();
                for(Gwiazdozbior g : gwiazdozbiory) {
                    for (Gwiazda gw : g.getGwiazdywGwiazdozbiorze()) {
                        if (gw.getNazwaKatalogowa().equals(gwiazda.toUpperCase())) {
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

    public static void Wyswietl(ArrayList<Gwiazdozbior> gwiazdozbiory){
        boolean showLoop = true;
        while(showLoop) {
            System.out.println("1--Wyswietl wszystkie gwiazdy");
            System.out.println("2--Wyswietl gwiazdozbiory");
            System.out.println("3--Wyswietl gwiazdy w wybranym gwiazdozbiorze");
            System.out.println("4--Wyswietl gwiazdy w zadanej odleglosci");
            System.out.println("5--Wyswietl gwiazdy z przedziału temperatury");
            System.out.println("6--Wyswietl gwiazdy z przedzialu obserwowanej wielkosci gwiazdowej");
            System.out.println("0--Wroc");
            Scanner scanner = new Scanner(System.in);
            int wyswietl = scanner.nextInt();
            switch (wyswietl) {
                case 1 -> Gwiazdozbior.WyswietlWszystkieGwiazdy(gwiazdozbiory);
                case 2 -> Gwiazdozbior.WyswietlNazwyGwiazdozbiorow(gwiazdozbiory);
                case 3 -> Gwiazdozbior.WyswietlGwiazdywGwiazdozbiorze(gwiazdozbiory);
                case 4 -> Gwiazdozbior.WyswietlGwiazdywOdleglosci(gwiazdozbiory);
                case 5 -> Gwiazdozbior.WyswietlGwiazdywPrzedzialeTemperatury(gwiazdozbiory);
                case 6 -> Gwiazdozbior.WyswietlGwiazdywPrzedzialeWielkosci(gwiazdozbiory);
                case 0 -> showLoop = false;
                default -> System.out.println("Nie ma takiej funkcji");
            }
        }
    }
}
