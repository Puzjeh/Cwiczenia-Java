package lab1Zad5;

public class lab1Zad5 {
    public static String Caesar(String word, int code){
        String text = word;
        String parsed = "";
        char[] characters = text.toCharArray();
        for (char c : characters) {
            if(c != ' ') {
                int oldCharPos = c - 'a';
                int newCharPos = (oldCharPos + code) % 26;
                char newChar = (char) ('a' + newCharPos);
                parsed += newChar;
            }
            else{
                parsed += c;
            }
        }
        return parsed;
    }
    public static void main(String[] args) {
        System.out.println(Caesar("java jest okej", 20));
    }
}
