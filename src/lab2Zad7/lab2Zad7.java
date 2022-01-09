package lab2Zad7;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class lab2Zad7 {
    public static void main(String[] args) {
        int[][] tab1 = new int[4][4];
        int[][] tab2 = new int[4][4];
        int[][] wynik = new int[4][4];
        int przedzialMin;
        int przedzialMax;
        Scanner n = new Scanner(System.in);
        System.out.println("podaj poczatek przedzialu dla 1 tablicy: ");
        przedzialMin = n.nextInt();
        System.out.println("podaj koniec przedzialu dla 1 tablicy: ");
        przedzialMax = n.nextInt()+1;
        for (int i = 0; i<4; i++) {
            for (int j = 0; j < 4; j++) {
                int random = ThreadLocalRandom.current().nextInt(przedzialMin,przedzialMax);
                tab1[i][j] = random;
                System.out.print(tab1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("podaj poczatek przedzialu dla 2 tablicy: ");
        przedzialMin = n.nextInt();
        System.out.println("podaj koniec przedzialu dla 2 tablicy: ");
        przedzialMax = n.nextInt()+1;
        for (int i = 0; i<4; i++) {
            for (int j = 0; j < 4; j++) {
                int random = ThreadLocalRandom.current().nextInt(przedzialMin,przedzialMax);
                tab2[i][j] = random;
                System.out.print(tab2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("suma tablic:");
        System.out.println();
        for (int i = 0; i<4; i++) {
            for (int j = 0; j < 4; j++) {
                wynik[i][j] = tab1[i][j] + tab2[i][j];
                System.out.print(wynik[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("koniec podzadania 1.");
        //---------------------------------------------------------------
        int m;
        System.out.println("podaj n");
        m = n.nextInt();
        char[] samogloskiTab = new char[]{'a','e','u','o','i','y'};
        char[] spolgloskiTab = new char[]{'q','w','r','t','p','s','d','f','g','h','j','k','l','z','x','c','v','b','n','m'};
        String samogloski = "";
        String spolgloski = "";
        char[][] tab = new char[m][m];
        for (int i = 0; i < tab.length; i++) {
            for (int j = 0; j<tab[i].length; j++){
                int random2 = ThreadLocalRandom.current().nextInt(97,123);
                tab[i][j] = (char) random2;
                System.out.print(tab[i][j] + " ");
                for (char c : samogloskiTab) {
                    if (tab[i][j] == c) {
                        samogloski += tab[i][j];
                    }
                }
                for (char c : spolgloskiTab) {
                    if (tab[i][j] == c) {
                        spolgloski += tab[i][j];
                    }
                }
            }
            System.out.println();
        }
        System.out.println(samogloski);
        System.out.println(spolgloski);
        System.out.println("koniec podzadania 2");
        //------------------------------------------------------
        double[][] doubleTab1 = new double[4][4];
        double[][] doubleTab2 = new double[4][4];
        double[][] dzielenie = new double[4][4];
        double przedzialDoubleMin;
        double przedzialDoubleMax;
        System.out.println("podaj poczatek przedzialu dla 1 tablicy: ");
        przedzialDoubleMin = n.nextDouble();
        System.out.println("podaj koniec przedzialu dla 1 tablicy: ");
        przedzialDoubleMax = n.nextDouble();
        for (int i = 0; i<4; i++) {
            for (int j = 0; j < 4; j++) {
                double randomDouble = ThreadLocalRandom.current().nextDouble(przedzialDoubleMin,przedzialDoubleMax);
                double rounded = Math.round(randomDouble*100.0)/100.0;
                doubleTab1[i][j] = rounded;
                System.out.print(doubleTab1[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("podaj poczatek przedzialu dla 2 tablicy: ");
        przedzialDoubleMin = n.nextDouble();
        System.out.println("podaj koniec przedzialu dla 2 tablicy: ");
        przedzialDoubleMax = n.nextDouble();
        for (int i = 0; i<4; i++) {
            for (int j = 0; j < 4; j++) {
                double randomDouble = ThreadLocalRandom.current().nextDouble(przedzialDoubleMin,przedzialDoubleMax);
                double rounded = Math.round(randomDouble*100.0)/100.0;
                doubleTab2[i][j] = rounded;
                System.out.print(doubleTab2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("podzielone tablice:");
        System.out.println();
        for (int i = 0; i<4; i++) {
            for (int j = 0; j < 4; j++) {
                if (doubleTab1[i][j]!=0 && doubleTab2[i][j]!=0){
                    dzielenie[i][j] = doubleTab1[i][j] / doubleTab2[i][j];
                    dzielenie[i][j] = Math.round(dzielenie[i][j]*100.0)/100.0;
                    System.out.print(dzielenie[i][j] + " ");
                }
                else{
                    System.out.println("nie dzielimy przez 0");
                }
            }
            System.out.println();
        }
        System.out.println("koniec podzadania 4.");
        //----------------------------------------------------------
        //Niestety nie rozumiem polecenia podzadania 3.
    }
}
