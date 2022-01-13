package ProjektZaliczeniowy;

import java.io.*;
import java.util.ArrayList;

public class ObslugaPlikow {
    public static void GenerujBaze(){
        ArrayList<Object> obiekty = new ArrayList<>();
        obiekty.add(new Gwiazda("EAF1240", 20,2,50,7,0,10,
                9.15,100, "Bliznieta", 5400, 0.2));
        obiekty.add(new Gwiazda("ADE3521", 20,12,35,7,10,20,
                -26.04,300, "Bliznieta", 3400, 0.5));
        obiekty.add(new Gwiazda("OUM5461", 20,8,30,7,5,25,
                3.45,521, "Bliznieta", 15000, 8.2));
        obiekty.add(new Gwiazda("MJK2501", -20,2,50,10,0,10,
                11.3,231, "Hydra", 3600, 1.22));
        obiekty.add(new Gwiazda("NHJ3421", -20,13,4,10,11,34,
                6.8,167, "Hydra", 2900, 4.2));
        obiekty.add(new Gwiazda("LKM5142", -20,54,6,10,15,26,
                7.9,452, "Hydra", 6400, 0.8));
        obiekty.add(new Gwiazda("MJK2501", 20,12,3,8,0,12,
                -12.4,325, "Rak", 8600, 1.23));
        obiekty.add(new Gwiazda("QJD8943", 20,31,10,8,30,5,
                5.8,380, "Rak", 5480, 0.8));
        obiekty.add(new Gwiazda("PJR7621", 20,5,20,8,15,9,
                3.1,390, "Rak", 14000, 3.24));

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("bazaGwiazd.obj");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (Object obiekt : obiekty) {
                objectOutputStream.writeObject(obiekt);
            }
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("0, zapis sie powiodl");
        }
        catch (FileNotFoundException e){
            System.out.println("Nie znaleziono sciezki");
        } catch (IOException e){
            System.out.println(e);
            System.out.println("-1");
        }
    }

    public static ArrayList<Gwiazda> OdczytajBaze() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("bazaGwiazd.obj");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ArrayList<Object> obiekty = new ArrayList<>();
        boolean tip = true;
        while(tip) {
            try {
                Object obiekt = objectInputStream.readObject();
                obiekty.add(obiekt);
            } catch (IOException | ClassNotFoundException e) {
                tip = false;
            }
        }
        objectInputStream.close();
        fileInputStream.close();

        ArrayList<Gwiazda> Gwiazdy = new ArrayList<>();
        for(Object obj : obiekty) {
            if (obj instanceof Gwiazda gwiazda) {
                Gwiazdy.add(gwiazda);
            }
        }
        return Gwiazdy;
    }
}

