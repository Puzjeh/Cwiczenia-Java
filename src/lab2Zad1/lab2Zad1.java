package lab2Zad1;

import java.util.Random;

public class lab2Zad1 {
    public static void main(String[] args) {
        int[] characters = new int[10];
        Random ourRandom = new Random();
        String result = "";
        for (int i = 0; i < characters.length; i++) {
            characters[i] = ourRandom.nextInt();
        }
        for (int c : characters){
            result += (char) c;
        }
        System.out.println(result);
    }
}
