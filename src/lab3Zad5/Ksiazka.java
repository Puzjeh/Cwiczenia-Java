package lab3Zad5;

import java.io.Serializable;

public class Ksiazka implements Serializable {
    public String tytul;
    public String autor;
    public int rokWydania;
    public int liczbaStron;
    public String gatunek;

    public Ksiazka() {
        tytul = "unknown";
        autor = "unknown";
        rokWydania = 0;
        liczbaStron = 0;
        gatunek = "unknown";
    }

    public Ksiazka(String tytul, String autor, int rokWydania, int liczbaStron, String gatunek) {
        this.tytul = tytul;
        this.autor = autor;
        this.rokWydania = rokWydania;
        this.liczbaStron = liczbaStron;
        this.gatunek = gatunek;
    }

    public Ksiazka(Ksiazka ksiazka){
        this.tytul = ksiazka.tytul;
        this.rokWydania = ksiazka.rokWydania;
        this.autor = ksiazka.autor;
        this.liczbaStron = ksiazka.liczbaStron;
        this.gatunek = ksiazka.gatunek;
    }

    @Override
    public String toString() {
        return "Ksiazka: " +
                "tytul= '" + tytul + '\'' +
                ", autor= " + autor +
                ", rokWydania= " + rokWydania +
                ", liczbaStron= " + liczbaStron +
                ", gatunek= " + gatunek;
    }

    public void PrzedstawSie(){
        System.out.println(this.toString());
    }
}
