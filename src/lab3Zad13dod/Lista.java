package lab3Zad13dod;


import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;

public class Lista implements Serializable {
    private int[]liczby;
    private int pojemnosc;
    private int rozmiar;

    public Lista(int[] liczby, int pojemnosc) {
        this.liczby = liczby;
        this.pojemnosc = pojemnosc;
    }

    public Lista(Lista lista){
        this.liczby = lista.getLiczby();
        this.pojemnosc = lista.getPojemnosc();
    }

    public int[] getLiczby() {
        return liczby;
    }

    public int getPojemnosc() {
        return pojemnosc;
    }

    public int getRozmiar() {
        return liczby.length;
    }

    public void setLiczby(int[] liczby) {
        this.liczby = liczby;
    }

    public void DodajElement(int el){
        if(getLiczby().length < getPojemnosc()){
            int[] newLiczby = new int[getLiczby().length+1];
            for(int i =0; i<getLiczby().length;i++){
                newLiczby[i] = getLiczby()[i];
            }
            newLiczby[newLiczby.length-1] = el;
            setLiczby(newLiczby);
        }else{
            System.out.println("Nie ma miejsca na liscie");
        }
    }

    public void ZapiszDoPliku(String f) throws IOException {
        FileWriter fi = new FileWriter((f));
        for(int i : getLiczby()){
            fi.write(Integer.toString(i));
        }
        fi.close();
    }
}
