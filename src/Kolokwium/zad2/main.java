package Kolokwium.zad2;


import java.util.Random;
import java.util.Scanner;

public class main {
    public static void main(String[] args){
        System.out.println("Podaj k");
        Scanner scanner = new Scanner(System.in);
        int k=scanner.nextInt();
        boolean[] wartosciBool = new boolean[k];
        Random rand = new Random();
        for(int i = 0; i< wartosciBool.length; i++){
            double liczba = rand.nextDouble();
            if(liczba < 0.75){
                wartosciBool[i] = true;
                System.out.println(wartosciBool[i]);
            }else{
                wartosciBool[i] = false;
                System.out.println(wartosciBool[i]);
            }
        }
        System.out.println("Podaj n");
        int n = scanner.nextInt();
        System.out.println("Podaj m");
        int m = scanner.nextInt();

        if(k == n*m){
            boolean[][] wartosciBool2D = new boolean[n][m];
            int indexWartosci = 0;
            for(int i = 0; i<n;i++){
                for(int y = 0; y<m; y++){
                    wartosciBool2D[i][y] = wartosciBool[indexWartosci];
                    indexWartosci++;
                    System.out.print(wartosciBool2D[i][y] + " ");
                }
                System.out.println(" ");
            }
        }else{
            System.out.println("n*m nie jest rowne k");
        }

    }
}
