package lab3Zad6;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Random;

public class main {

    public static void GenerateNumbers(RandomAccessFile fileName, int[] intTab) throws IOException {
        Random rand = new Random();
        fileName.seek(0);
        for(int i=0; i<intTab.length; i++){
            intTab[i] = rand.nextInt(50,151);
            fileName.writeInt(intTab[i]);
        }
    }

    public static void ReadNumbers(RandomAccessFile fileName) throws IOException {
        fileName.seek(0);
        System.out.println("Nasze liczby to:");
        for(int i = 0; i< fileName.length()/4; i++){
            fileName.seek(i*4);
            System.out.println(fileName.readInt());
        }
    }

    public static void ChangeNumbers(RandomAccessFile fileName) throws IOException {
        for(int i = 0; i < fileName.length()/4; i++){
            fileName.seek(i*4);
            int number = fileName.readInt();
            if(number == 150){
                number = number-1;
            }else {
                number = number + 1;
            }
            fileName.seek(i*4);
            fileName.writeInt(number);
        }
    }

    public static void main(String[] args) throws IOException {

        int[] myNumbers = new int[10];
        RandomAccessFile myFile = new RandomAccessFile(new File("myNumbers.txt"), "rw");

        GenerateNumbers(myFile, myNumbers);
        ReadNumbers(myFile);
        ChangeNumbers(myFile);
        ReadNumbers(myFile);
    }
}
