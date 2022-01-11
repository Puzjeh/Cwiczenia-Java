package lab3Zad13dod;

import java.io.*;
import java.util.ArrayList;

public class main {


    public static void zapiszObiekty(Object[] objects, String path) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeInt(objects.length);
            for (Object obj : objects) {
                objectOutputStream.writeObject(obj);
            }
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("0, zapis sie powiodl");
        }
        catch (FileNotFoundException e){
            System.out.println("Nie znaleziono sciezki");
        } catch (IOException e){
            System.out.println("-1");
        }
    }

    public static Lista[] odczytajObiekty(String nazwaPliku) throws IOException {

        FileInputStream fileInputStream = new FileInputStream(nazwaPliku);
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        ArrayList<Object> obiekty = new ArrayList<>();
        int liczbaObiektow = objectInputStream.readInt();
        for (int i = 0; i < liczbaObiektow; i++) {
            try {
                Object obiekt = objectInputStream.readObject();
                obiekty.add(obiekt);
            } catch (IOException | ClassNotFoundException e) {
                System.out.println(e);
            }
        }
        objectInputStream.close();
        fileInputStream.close();

        Lista[] loadedList = new Lista[liczbaObiektow];
        for(int i = 0; i < liczbaObiektow; i++){
            if (obiekty.get(i) instanceof Lista){
                Lista listaa = new Lista((Lista) obiekty.get(i));
                loadedList[i] = listaa;
            }
            else{
                System.out.println("nie znam");
            }
        }
        return loadedList;
    }

    public static void main(String[] args) throws IOException {
        Lista list1 = new Lista(new int[] {1,2,3}, 5);
        System.out.println(list1.getRozmiar());
        System.out.println(list1.getPojemnosc());
        list1.DodajElement(4);
        list1.DodajElement(5);
        list1.DodajElement(6);
        System.out.println(list1.getRozmiar());

        Lista list2 = new Lista(new int[]{10, 9, 8, 7, 6, 5}, 8);

        Lista[] listArr = new Lista[]{list1, list2};
        list1.ZapiszDoPliku("f.txt");
        zapiszObiekty(listArr, "myLists.obj");
        Lista[] loadedList = odczytajObiekty("myLists.obj");
        for(Lista c : loadedList){
            int[] arr = c.getLiczby();
            for(int d : arr){
                System.out.print(d + " ");
            }
            System.out.println(" ");
        }
    }
}
