package lab3Zad4;



public class Pracownik {
    private String imie;
    private String nazwisko;
    private String stanowisko;
    private int stazPracy;
    private double pensja;


    public String getImie() {
        return imie;
    }

    public void setImie(String imie) {
        this.imie = imie;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getStanowisko() {
        return stanowisko;
    }

    public void setStanowisko(String stanowisko) {
        this.stanowisko = stanowisko;
    }

    public int getStazPracy() {
        return stazPracy;
    }

    public void setStazPracy(int stazPracy) {
        this.stazPracy = stazPracy;
    }

    public double getPensja() {
        return pensja;
    }

    public void setPensja(double pensja) {
        this.pensja = pensja;
    }

    public Pracownik(){
        imie = "unknown";
        nazwisko = "unknown";
        stanowisko = "unknown";
        stazPracy = 0;
        pensja = 0;
    }

    public Pracownik(String imie, String nazwisko, String stanowisko, int stazPracy) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.stanowisko = stanowisko;
        this.stazPracy = stazPracy;
        if (stanowisko.equalsIgnoreCase("manager")){
            pensja = 4500 + (150 * stazPracy) + 500;
        }
        else if
        (stanowisko.equalsIgnoreCase("kierownik")){
            pensja = 4500 + (150 * stazPracy) + 1000;
        } else{
            pensja = 4500 + (150 * stazPracy);
        }
    }
    public boolean ZwiekszPensja(double wzrost){
        if(pensja + pensja*wzrost > 10000){
            return false;
        }else {
            pensja += pensja*wzrost;
            return true;
        }
    }

    public void ZwiekszStaz(){
        stazPracy++;
        pensja+=150;
    }
}
