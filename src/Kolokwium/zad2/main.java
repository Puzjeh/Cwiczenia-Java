package Kolokwium.zad2;


import java.util.Random;


public class main {
    public static void Tablice(int k, int n, int m){

        boolean[] wartosciBool = new boolean[k];
        Random rand = new Random();
        System.out.print("Wartosci tablicy 1d:");
        for(int i = 0; i< wartosciBool.length; i++){
            double liczba = rand.nextDouble();
            if(liczba < 0.75){
                wartosciBool[i] = true;
            }else{
                wartosciBool[i] = false;
            }
            System.out.print(wartosciBool[i] + " ");
        }
        System.out.println(" ");

        if(k == n*m){
            boolean[][] wartosciBool2D = new boolean[n][m];
            int indexWartosci = 0;
            System.out.println("Wartosci tablicy 2d:");
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

    public static void main(String[] args){
        Tablice(10,2,5);
        Tablice(22,3,7);

    }
}
