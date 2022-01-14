package ProjektZaliczeniowy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void WyswietlMenu(){
        System.out.println("1--Wyswietl");
        System.out.println("2--Usun gwiazde");
        System.out.println("3--Dodaj gwiazde");
        System.out.println("0--Zapisz i zakoncz program");
    }
    public static void Start() throws IOException {
        ArrayList<Gwiazdozbior> gwiazdozbiory;
        try{
            gwiazdozbiory = ObslugaPlikow.OdczytajBaze();
        }catch (IOException e){
            ObslugaPlikow.GenerujBaze();
            gwiazdozbiory = ObslugaPlikow.OdczytajBaze();
        }
        Scanner scanner = new Scanner(System.in);



        boolean menu = true;
        while(menu){
            WyswietlMenu();
            int wybor = scanner.nextInt();
            switch (wybor) {
                case 1 -> Gwiazdozbior.Wyswietl(gwiazdozbiory);
                case 2 -> Gwiazdozbior.UsunGwiazde(gwiazdozbiory);
                //case 3 ->
                case 0 -> menu=false;
                default -> System.out.println("Nie ma takiej funkcji");
            }
        }

    }
}
