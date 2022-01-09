package lab1Zad4;

public class lab1Zad4 {

    public static String toUpper(String word){
        String text = word;
        String parsed = "";
        char[] characters = text.toCharArray();
        for (char c : characters) {
            if (c >=97 && c<=122) {
                parsed += (char) ((int) c - 32);
            }
            else{
                parsed += c;
            }
        }
        return parsed;
    }

    public static String toLower(String word){
        String text = word;
        String parsed = "";
        char[] characters = text.toCharArray();
        for (char c : characters) {
            if (c >=65 && c<=90) {
                parsed += (char) ((int) c + 32);
            }
            else{
                parsed += c;
            }
        }
        return parsed;
    }

    public static void main(String[] args) {
        System.out.println(toUpper("AAaaAAaa"));
        System.out.println(toLower("AAaaAAaa"));
    }
}
