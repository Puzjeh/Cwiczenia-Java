package ProjektZaliczeniowy;

import java.io.*;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Gwiazdozbior>gwiazdozbiory;
        try{
            gwiazdozbiory = ObslugaPlikow.OdczytajBaze();
        }catch (IOException e){
            ObslugaPlikow.GenerujBaze();
            gwiazdozbiory = ObslugaPlikow.OdczytajBaze();
        }




        Gwiazdozbior.WyswietlWszystkieGwiazdy(gwiazdozbiory);
        Gwiazdozbior.WyswietlNazwyGwiazdozbiorow(gwiazdozbiory);
        Gwiazdozbior.UsunGwiazde(gwiazdozbiory);
        Gwiazdozbior.WyswietlWszystkieGwiazdy(gwiazdozbiory);
        Gwiazdozbior.UsunGwiazde(gwiazdozbiory);
        Gwiazdozbior.WyswietlWszystkieGwiazdy(gwiazdozbiory);
    }
}
