package ProjektZaliczeniowy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    public static void WyswietlMenu(){
        System.out.println("1--Wyswietl");
        System.out.println("2--Usun gwiazde");
        System.out.println("3--Dodaj gwiazde");
        System.out.println("4--Zapisz wszystkie gwiazdy do pliku .txt");
        System.out.println("0--Zapisz i zakoncz program");
    }
    public static void Start() throws IOException {
        //Start calego programu. Do listy gwiazdozbiory wczytujemy baze gwiazdozbiorow z gwiazdami
        //W przypadku, gdy baza nie istnieje(nie ma pliku obiektowego w folderze projektu) jest on generowany
        ArrayList<Gwiazdozbior> gwiazdozbiory;
        try{
            gwiazdozbiory = ObslugaPlikow.OdczytajBaze();
        }catch (IOException e){
            ObslugaPlikow.GenerujBaze();
            gwiazdozbiory = ObslugaPlikow.OdczytajBaze();
        }
        Scanner scanner = new Scanner(System.in);


        //Glowne menu wyboru dla uzytkownika
        boolean menu = true;
        while(menu){
            WyswietlMenu();
            int wybor = scanner.nextInt();
            switch (wybor) {
                case 1 -> Gwiazdozbior.Wyswietl(gwiazdozbiory);//przejscie do funkcji wyswietl
                case 2 -> Gwiazdozbior.UsunGwiazde(gwiazdozbiory);//przejscie do funkcji usuwania gwiazd
                case 3 -> Gwiazdozbior.DodajGwiazde(gwiazdozbiory);//przejscie do funkcji dodawania gwiazd
                case 4 -> ObslugaPlikow.ZapiszDoPlikuTXT(gwiazdozbiory);//zapisanie wszystkich gwiazd do pliku .txt
                case 0 -> {
                    ObslugaPlikow.ZapiszZmiany(gwiazdozbiory);//zapisanie wprowadzonych zmian do bazy i zamkniecie programu
                    menu=false;
                }
                default -> System.out.println("Nie ma takiej funkcji");
            }
        }

    }
}
