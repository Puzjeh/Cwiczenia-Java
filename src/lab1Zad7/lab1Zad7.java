package lab1Zad7;

import java.util.Scanner;

public class lab1Zad7 {
    public static void main(String[] args) {
        System.out.println("Podaj lancuch: ");
        Scanner scan = new Scanner(System.in);
        String lancuch = scan.nextLine();
        int score = 0;
        char[] tablica = new char[lancuch.length()];
        char[] tablica2 = new char[lancuch.length()];
        int j = lancuch.length();
        for (int i=0; i < lancuch.length(); i++){
            tablica[i] = lancuch.charAt(i);
        }

        for (int i = 0; i < lancuch.length(); i++) {
            tablica2[j - 1] = tablica[i];
            j--;
        }

        for (int i = 0; i < lancuch.length(); i++) {
            if (tablica2[i] != tablica[i]){
                score++;
            }
        }


        if (score == 0){
            System.out.println("Jest palindromem");
        }
        else{
            System.out.println("Nie jest palindromem");
        }

    }
}
