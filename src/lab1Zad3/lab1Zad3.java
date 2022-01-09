package lab1Zad3;

import java.util.Scanner;

public class lab1Zad3 {
    public static void main(String[] args) {
        System.out.println("Podaj lancuch: ");
        Scanner scan = new Scanner(System.in);
        String lancuch = scan.nextLine();
        System.out.println(lancuch);
        char[] tablica = new char[lancuch.length()];
        char[] tablica2 = new char[lancuch.length()];
        for (int i=0; i < lancuch.length(); i++){
            tablica[i] = lancuch.charAt(i);
        }
        tablica2[0] = tablica[0];
        int j = 1;

        for (int i =0; i< tablica.length-1; i++){
            if (tablica[i] != tablica[i+1]){
                tablica2[j] = tablica[i+1];
                j++;
            }
        }

        String wynik = new String(tablica2);
        System.out.println(wynik);
    }
}
