package lab3Zad2i3;


public class main {
    public static void main(String[] args) {
        Lancuch string1 = new Lancuch("abceghtuut");
        System.out.println(string1.getLancuch());
        System.out.println(string1.getPierwszaLitera());
        System.out.println(string1.getKoncowka());

        Lancuch string2 = new Lancuch("abc");
        System.out.println(string2.getLancuch());
        System.out.println(string2.getKoncowka());
        System.out.println(string2.getPierwszaLitera());

        System.out.println(string1.Merge(string2));

        System.out.println(string1.IleASCII());
    }
}
