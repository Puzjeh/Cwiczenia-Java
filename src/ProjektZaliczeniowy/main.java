package ProjektZaliczeniowy;

import java.io.*;
import java.util.ArrayList;

public class main {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<Gwiazda>Gwiazdy;
        try{
            Gwiazdy = ObslugaPlikow.OdczytajBaze();
        }catch (IOException e){
            ObslugaPlikow.GenerujBaze();
            Gwiazdy = ObslugaPlikow.OdczytajBaze();
        }
        for(Gwiazda g : Gwiazdy){
            System.out.println(g.toString());
        }
    }
}
