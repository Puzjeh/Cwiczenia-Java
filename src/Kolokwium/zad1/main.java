package Kolokwium.zad1;
public class main {
    public static void main(String[] args){
        String[]egzaminy1 = new String[]{"Matematyka", "Programowanie", "Statystyka", "Sieci"};
        String[]terminy1 = new String[]{"20220115", "20220117", "20220119", "20220121"};
        Sesja sesja1 = new Sesja(egzaminy1, terminy1);
        System.out.println(sesja1.IleDoKonca("20220118"));
        System.out.println(sesja1.IleDoKonca("20220110"));
        System.out.println(sesja1.IleDoKonca("20220122"));
    }
}