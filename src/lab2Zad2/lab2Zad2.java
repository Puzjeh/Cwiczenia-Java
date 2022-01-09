package lab2Zad2;

import java.util.Random;

public class lab2Zad2 {
    public static void main(String[] args) {
        int[] randomInts = new int[10];
        Random randomInt = new Random();
        for (int i = 0; i < randomInts.length; i++) {
            randomInts[i] = randomInt.nextInt();
        }
        System.out.println(randomInts[5]);
        System.out.println(randomInts[2]);
    }
}
