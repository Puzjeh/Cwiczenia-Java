package lab3Zad5;


import java.io.*;
import java.util.ArrayList;

public class main implements Serializable {

    public static void zapiszFilm(Film film) {
        try {
            String path = "myFilms.obj";
            FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(film);
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("0");
        } catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono scieżki");
        } catch (IOException e) {
            System.out.println("-1");
        }
    }

    public static void zapiszObiekty(Object[] objects) {
        try {
            String path = "myObjects.obj";
            FileOutputStream fileOutputStream = new FileOutputStream(new File(path));
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeInt(objects.length);
            for (Object obj : objects) {
                objectOutputStream.writeObject(obj);
            }
            objectOutputStream.close();
            fileOutputStream.close();
            System.out.println("0");
        }
        catch (FileNotFoundException e){
            System.out.println("Nie znaleziono sciezki");
        } catch (IOException e){
            System.out.println("-1");
        }
    }

    public static void odczytajObiekty(String nazwaPliku) throws IOException {

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


            for(Object obj : obiekty){
                if (obj instanceof Film){
                    Film film = (Film) obj;
                    System.out.println("Film: Tytuł: "+film.tytul+" Rezyser: "+film.rezyser);
                }
                else if (obj instanceof Ksiazka){
                    Ksiazka ksiazka = (Ksiazka) obj;
                    ksiazka.PrzedstawSie();
                }
            }
    }

    public static void main(String[] args) throws IOException {
        Film film1 = new Film("HP i Kamien Filozoficzny", "Chris Columbus", 2001, new String[]{"Daniel Radcliffe", "Rupert Grint", "Emma Watson"});
        Ksiazka ksiazka1 = new Ksiazka("HP i Kamien Filozoficzny", "J.K. Rowling", 1997, 400, "Fantasy");
        film1.PrzedstawSie();
        ksiazka1.PrzedstawSie();

        Object[] objects = new Object[]{ksiazka1, film1};

        zapiszFilm(film1);
        zapiszObiekty(objects);
        odczytajObiekty("myObjects.obj");
    }
}
