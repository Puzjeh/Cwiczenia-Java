package lab1Zad1;

import java.util.Scanner;

public class lab1Zad1 {

    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Podaj liczbe lancuchow: ");
        int liczba = scan.nextInt();
        String[] lancuchy = new String[liczba+1];
        for (int i = 0; i <= liczba; i++){
            System.out.println("Podaj łancuch: ");
            String word = scan.nextLine();
            lancuchy[i] = word;
        }
        int dlugoscNajdluzszego = 0;
        String najduzszy = "";
        for (String x : lancuchy) {
            if (x.length() > dlugoscNajdluzszego){
                dlugoscNajdluzszego = x.length();
                najduzszy = x;
            }
        }
        System.out.println("Najdluższy: "+najduzszy);
        System.out.println("Jego dlugosc: "+dlugoscNajdluzszego);


        System.out.println("Podaj litere:");
        String podanaLitera = scan.nextLine();
        if (podanaLitera.length() != 1) {
            System.out.println("Mozesz podac tylko jedna litere!");
        }
        else{
            System.out.println("Podaj lancuch: ");
            String slowo = scan.nextLine();
            int powtorzenia = 0;
            char litera = podanaLitera.charAt(0);
            char[] litery = new char[slowo.length()];
            for (int i = 0; i<slowo.length(); i++){
                litery[i] = slowo.charAt(i);
            }
            for (char l : litery){
                if (l == litera){
                    powtorzenia++;
                }
            }
            System.out.println("Ilość powtorzeń: "+powtorzenia);
        }

    }
}
