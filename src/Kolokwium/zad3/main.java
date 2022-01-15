package Kolokwium.zad3;

public class main {
    public static boolean SprawdzPodzielnosc(long liczba){
        boolean tmp = true;
        long naszaLiczba = liczba;
        int poZsumowaniu = 0;
        while(tmp){
            String pomocnicze = Long.toString(naszaLiczba);
            char[] cyfry = pomocnicze.toCharArray();
            long suma = 0;
            for(char c : cyfry){
                suma += Integer.parseInt(String.valueOf(c));
            }
            System.out.print(suma + " ");
            if(suma >9){
                naszaLiczba = suma;
            }else{
                poZsumowaniu = (int) suma;
                tmp = false;
            }
        }
        if(poZsumowaniu == 0 || poZsumowaniu == 3|| poZsumowaniu == 6 || poZsumowaniu == 9){
            return true;
        }else{
            return  false;
        }
    }
    public static void main(String[] args){
        System.out.println(SprawdzPodzielnosc(123454));
        System.out.println(SprawdzPodzielnosc(123453));
    }
}
