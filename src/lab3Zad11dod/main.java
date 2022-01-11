package lab3Zad11dod;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class main {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> lista = new ArrayList<>();
        int przedzialMin = 1;
        int przedzialMax = 10;
        for(int i = przedzialMin; i<=przedzialMax; i++){
            lista.add(i);
        }

        BufferedWriter writer = new BufferedWriter( new FileWriter("liczby.txt"));

        for(int num : lista){
            writer.write("Kwadrat liczby "+num+" wynosi "+num*num+"\n");
        }
        writer.close();
    }
}
