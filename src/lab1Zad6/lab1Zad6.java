package lab1Zad6;
import java.util.ArrayList;

public class lab1Zad6 {

    public static void main(String[] args) {
        char[] znaki = {'-', ','};
        String lancuch = "how,to-java-begginer,guide";
        char[] lancuchy = lancuch.toCharArray();
        String word = "";
        ArrayList<String> mySplit = new ArrayList<>();

        for (int i = 0; i < lancuchy.length; i++){
            if (lancuchy[i] == znaki[0] || lancuchy[i] == znaki[1]){
                mySplit.add(word);
                word = "";
            }
            else{
                word = word + lancuchy[i];
            }
        }
        mySplit.add(word);


        System.out.println(mySplit);
    }
}
