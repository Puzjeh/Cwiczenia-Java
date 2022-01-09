package lab2Zad5;

import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class lab2Zad5 {
    public static void main(String[] args) {
        int[][] tabliczkaMnozenia = new int[10][10];
        for (int i = 0; i<10; i++){
            for (int j = 0; j<10; j++){
                tabliczkaMnozenia[j][i] = (i+1)*(j+1);
                System.out.print(tabliczkaMnozenia[j][i] + " ");
            }
            System.out.println();
        }
        System.out.println("koniec podzadania 1");
        //-------------------------------------------------------
        int[][] tabela10x5 = new int[10][5];
        int rowSum = 0;
        for (int i = 0; i<10; i++){
            for (int j = 0; j<5; j++){
                Random randomInt = new Random();
                tabela10x5[i][j] = randomInt.nextInt(0,21);
                System.out.print(tabela10x5[i][j] + " ");
                rowSum += tabela10x5[i][j];
            }
            System.out.print("suma: "+rowSum);
            rowSum=0;
            System.out.println();
        }
        System.out.println("koniec podzadania 2");
        //--------------------------------------------------------
        double[][] randomTable = new double[10][10];
        for (int i = 0; i<10; i++) {
            for (int j = 0; j < 5; j++) {
                double randomDouble = ThreadLocalRandom.current().nextDouble(-0.5,0.5);
                double rounded = Math.round(randomDouble*100.0)/100.0;
                randomTable[i][j] = rounded;
                System.out.print(randomTable[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("------------------------------------------");
        String wybor;
        Scanner n = new Scanner(System.in);
        System.out.println("wyzeruj: ujemne/dodatnie u/d:");
        wybor = n.nextLine();
        if (Objects.equals(wybor, "u")){
            for (int i = 0; i<10; i++) {
                for (int j = 0; j < 5; j++) {
                    if (randomTable[i][j] < 0) {
                        randomTable[i][j] = 0;
                    }
                }
            }
            for (int i = 0; i<10; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.print(randomTable[i][j] + " ");
                }
                System.out.println();
            }
        }
        else if (Objects.equals(wybor, "d")) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 5; j++) {
                    if (randomTable[i][j] > 0) {
                        randomTable[i][j] = 0;
                    }
                }
            }
            for (int i = 0; i<10; i++) {
                for (int j = 0; j < 5; j++) {
                    System.out.print(randomTable[i][j] + " ");
                }
                System.out.println();
            }
        }
        else{
            System.out.println("wybierz u lub d");
        }
        System.out.println("koniec podzadania 3");
        //-------------------------------------------------
        int[][] kwadratowa = new int[3][3];
        double suma = 0;
        double sumaNaPrzekatnej = 0;
        for (int i = 0; i<3; i++) {
            for (int j = 0; j < 3; j++) {
                Random randomInt = new Random();
                kwadratowa[i][j] = randomInt.nextInt(1, 10);
                suma += kwadratowa[i][j];
                System.out.print(kwadratowa[i][j] + " ");
            }
            System.out.println();
        }
        for (int i = 0; i<3; i++){
            sumaNaPrzekatnej += kwadratowa[i][i];
        }
        double srednia = suma / 9;
        System.out.println("srednia arytmetyczna: "+srednia);
        System.out.println("suma na przekatnej: "+sumaNaPrzekatnej);
        System.out.println("koniec podzadania 4");
    }
}
