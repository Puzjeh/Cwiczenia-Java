package lab2Zad4;
import java.util.Arrays;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;


public class lab2Zad4 {
    public static void main(String[] args) {
        Scanner n = new Scanner(System.in);
        System.out.println("Wpisz liczbę elementów tablicy: ");
        double[] randoms = ThreadLocalRandom.current().doubles(n.nextLong(), -5, 5).toArray();
        Arrays.sort(randoms);
        double average = 0;
        for (int i=0; i<randoms.length; i++){
            average += randoms[i];
        }
        average = average/randoms.length;
        System.out.println("Srednia: "+average);
        double median;
        if (randoms.length % 2 == 0)
            median = (randoms[randoms.length/2] + randoms[randoms.length/2 - 1])/2;
        else
            median = randoms[randoms.length/2];
        System.out.println("Mediana: "+median);
        double minElement = randoms[0];
        System.out.println("Element najmniejszy: "+minElement);
        double maxElement = randoms[randoms.length-1];
        System.out.println("Element najwyzszy: "+maxElement);
        double result = 0;
        double x =0;
        for(double rand : randoms){
            if(rand != 0 && rand % 2 == 0){
                result += rand;
                x++;
            }
        }
        result = result/x;
        System.out.println("Srednia dla warunku: "+result);
    }
}
