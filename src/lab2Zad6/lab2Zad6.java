package lab2Zad6;

public class lab2Zad6 {
    public static void main(String[] args) {
        int [][] nieregularna = new int[3][];
        nieregularna[0] = new int[]{1,2,3};
        nieregularna[1] = new int[]{4,5,6};
        nieregularna[2] = new int[]{7,8,9};
        int [] tab = new int[3];
        for (int i = 0;i< nieregularna.length;i++){
            if (i%2 == 0){
                tab[i]=nieregularna[i][0];
                for (int x = 0;x< nieregularna[i].length;x++){
                    if (nieregularna[i][x]>tab[i]){
                        tab[i] = nieregularna[i][x];
                    }
                    else{
                        tab[i] = tab[i];
                    }
                }
            }
            else{
                tab[i]=nieregularna[i][0];
                for (int x = 0;x< nieregularna[i].length;x++){
                    if (nieregularna[i][x]<tab[i]){
                        tab[i] = nieregularna[i][x];
                    }
                    else{
                        tab[i] = tab[i];
                    }
                }
            }
        }
        for (int c=0; c< nieregularna.length;c++) {
            for (int v = 0; v < nieregularna[c].length; v++) {
                System.out.print(nieregularna[c][v] + " ");
            }
            System.out.println();
        }
        for (int t=0; t< tab.length; t++){
            System.out.println(tab[t]);
        }
    }
}
