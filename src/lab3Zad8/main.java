package lab3Zad8;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

public class main {

    public static void GenerateFile(String fileNamee, Budynek[] budynkiTab) throws IOException {
        RandomAccessFile fileName = new RandomAccessFile(fileNamee, "rw");
        fileName.seek(0);

        for(Budynek b : budynkiTab){
            fileName.writeChars(b.getNazwDom());
            fileName.writeInt(b.getlKondygn());
            fileName.writeDouble(b.getCena());
        }
    }

    public static void ReadFile(String fileNamee) throws IOException {
        RandomAccessFile fileName = new RandomAccessFile(fileNamee, "rw");
        ArrayList<Budynek> budynki = new ArrayList<>();
        fileName.seek(0);
        long i = 0;
        String nazwa = "";
        int kondygnacje = 0;
        double cena = 0;
        long rozmiarPliku = fileName.length();
        char temp;
        while (i < rozmiarPliku) {
            fileName.seek(i);
            if ((fileName.readChar() >= 32) && (fileName.readChar() <= 126)){
                fileName.seek(i);
                temp = fileName.readChar();
                nazwa += temp;
                i += 2;
            }
            else{
                fileName.seek(i);
                kondygnacje = fileName.readInt();
                cena = fileName.readDouble();
                i += 4 + 8;
                budynki.add(new Budynek(nazwa, kondygnacje, cena));
                nazwa = "";
            }
        }
        for (Budynek b : budynki){
            System.out.println(b.getNazwDom() + " " + b.getlKondygn() + " " + b.getCena());
        }
    }


    public static String ObnizkaCeny(String fileNamee) throws IOException {
        RandomAccessFile fileName = new RandomAccessFile(fileNamee, "rw");
        fileName.seek(0);
        long i = 0;
        String nazwa = "";
        String highestBuild = "";
        int maxKondygnacje = 0;
        int kondygnacje;
        double cena;
        long rozmiarPliku = fileName.length();
        char temp;
        while (i < rozmiarPliku) {
            fileName.seek(i);
            if ((fileName.readChar() >= 32) && (fileName.readChar() <= 126)){
                fileName.seek(i);
                temp = fileName.readChar();
                nazwa += temp;
                i += 2;
            }
            else{
                fileName.seek(i);
                kondygnacje = fileName.readInt();
                cena = fileName.readDouble();
                i += 4 + 8;
                if(kondygnacje == 1){
                    cena = cena - (cena*0.1);
                    fileName.seek(i-8);
                    fileName.writeDouble(cena);
                }
                if(kondygnacje > maxKondygnacje){
                    highestBuild = nazwa;
                    maxKondygnacje = kondygnacje;
                }
                nazwa = "";
            }
        }
        return highestBuild;
    }

    public static void main(String[] args) throws IOException {
        Budynek b1 = new Budynek("Parterowy z poddaszem", 2, 300000.30);
        Budynek b2 = new Budynek("Dwupietrowy z poddaszem", 3, 600000.50);
        Budynek b3 = new Budynek("Ziemianka", 1, 5000.80);
        Budynek b4 = new Budynek("Parterowy", 1, 200000.90);
        Budynek[] budynki = new Budynek[]{b1, b2, b3, b4};

        GenerateFile("myBudynki.txt", budynki);
        ReadFile("myBudynki.txt");
        System.out.println("Najwyzszy budynek: "+ObnizkaCeny("myBudynki.txt"));
        ReadFile("myBudynki.txt");
    }
}
