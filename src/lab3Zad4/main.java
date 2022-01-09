package lab3Zad4;

public class main {
    public static void main(String[] args){
        Pracownik p1 = new Pracownik();
        System.out.println(p1.getImie());
        System.out.println(p1.getPensja());
        Pracownik p2 = new Pracownik("Krzysztof", "Jarzyna ze szczecina", "manager", 5);
        System.out.println(p2.getPensja());
        System.out.println(p2.ZwiekszPensja(0.3));
        System.out.println(p2.getPensja());
        System.out.println(p2.ZwiekszPensja(2));
        System.out.println(p2.getPensja());

        System.out.println(p2.getStazPracy());
        System.out.println(p2.getPensja());
        p2.ZwiekszStaz();
        System.out.println(p2.getStazPracy());
        System.out.println(p2.getPensja());
    }
}
