package ProjektZaliczeniowy;

import java.io.*;
import java.util.ArrayList;

public class ObslugaPlikow {
    public static void GenerujBaze(){
        ArrayList<Object> gwiazdozbiory = new ArrayList<>();
        ArrayList<Gwiazda> bliznietaList = new ArrayList<>();
        ArrayList<Gwiazda> hydraList = new ArrayList<>();
        ArrayList<Gwiazda> rakList = new ArrayList<>();


        bliznietaList.add(new Gwiazda("EAF1240", 20,2,50,7,0,10,
                9.15,100, "BLIZNIETA", 5400, 0.2));
        bliznietaList.add(new Gwiazda("ADE3521", 20,12,35,7,10,20,
                -26.04,300, "BLIZNIETA", 3400, 0.5));
        bliznietaList.add(new Gwiazda("OUM5461", 20,8,30,7,5,25,
                3.45,521, "BLIZNIETA", 15000, 8.2));

        Gwiazdozbior bliznieta = new Gwiazdozbior("BLIZNIETA", bliznietaList);

        hydraList.add(new Gwiazda("MJK2501", -20,2,50,10,0,10,
                11.3,231, "HYDRA", 3600, 1.22));
        hydraList.add(new Gwiazda("NHJ3421", -20,13,4,10,11,34,
                6.8,167, "HYDRA", 2900, 4.2));
        hydraList.add(new Gwiazda("LKM5142", -20,54,6,10,15,26,
                7.9,452, "HYDRA", 6400, 0.8));

        Gwiazdozbior hydra = new Gwiazdozbior("HYDRA", hydraList);

        rakList.add(new Gwiazda("MJK2501", 20,12,3,8,0,12,
                -12.4,325, "RAK", 8600, 1.23));
        rakList.add(new Gwiazda("QJD8943", 20,31,10,8,30,5,
                5.8,380, "RAK", 5480, 0.8));
        rakList.add(new Gwiazda("PJR7621", 20,5,20,8,15,9,
                3.1,390, "RAK", 14000, 3.24));

        Gwiazdozbior rak = new Gwiazdozbior("RAK", rakList);

        gwiazdozbiory.add(bliznieta);
        gwiazdozbiory.add(hydra);
        gwiazdozbiory.add(rak);

        try {
            FileOutputStream fileOutputStream = new FileOutputStream("bazaGwiazd.obj");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (Object obiekt : gwiazdozbiory) {
                objectOutputStream.writeObject(obiekt);
            }
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("0, Baza zostala wygenerowana");
        }
        catch (FileNotFoundException e){
            System.out.println("Nie znaleziono sciezki");
        } catch (IOException e){
            System.out.println("-1");
        }
    }

    public static ArrayList<Gwiazdozbior> OdczytajBaze() throws IOException {
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

        ArrayList<Gwiazdozbior> gwiazdozbiory = new ArrayList<>();
        for(Object obj : obiekty) {
            if (obj instanceof Gwiazdozbior gwiazdozbior) {
                gwiazdozbiory.add(gwiazdozbior);
            }
        }
        for(Gwiazdozbior g : gwiazdozbiory){
            g.setGwiazdywGwiazdozbiorze(g.SortujGwiazdy());
        }
        System.out.println("Baza zostala odczytana");
        return gwiazdozbiory;
    }

    public static void ZapiszZmiany(ArrayList<Gwiazdozbior> gwiazdozbiory){
        try {
            FileOutputStream fileOutputStream = new FileOutputStream("bazaGwiazd.obj");
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            for (Object obiekt : gwiazdozbiory) {
                objectOutputStream.writeObject(obiekt);
            }
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("Zapisano zmiany");
        }
        catch (FileNotFoundException e){
            System.out.println("Nie znaleziono sciezki");
        } catch (IOException e){
            System.out.println("-1");
        }
    }

    public static void ZapiszDoPlikuTXT(ArrayList<Gwiazdozbior> gwiazdozbiory) throws IOException {
        FileWriter fi = new FileWriter(("Gwiazdy.txt"));
        for (Gwiazdozbior g : gwiazdozbiory) {
            for (Gwiazda gw : g.getGwiazdywGwiazdozbiorze()) {
                fi.write(gw.toString() + "\n");
            }
        }
        fi.close();
        System.out.println("Gwiazdy zapisano do pliku Gwiazdy.txt");
    }
}

