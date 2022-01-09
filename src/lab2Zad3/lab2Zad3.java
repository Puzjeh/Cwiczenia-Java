package lab2Zad3;

import java.math.BigDecimal;

public class lab2Zad3 {
    public static void main(String[] args) {
        BigDecimal[] fibbo = new BigDecimal[100];
        fibbo[0] = BigDecimal.valueOf(1);
        fibbo[1] = BigDecimal.valueOf(1);
        for(int i = 2; i < fibbo.length; i++){
            fibbo[i] = fibbo[i-1].add(fibbo[i-2]);
        }
        for(int i = 0; i< fibbo.length; i++){
            System.out.println(i+1 + ". " + fibbo[i]);
        }
    }
}
