package lab1Zad2;

public class lab1Zad2 {
    public static int stringCompare(String word1, String word2){
        String text = word1;
        String text2 = word2;
        int parsed1 = 0;
        int parsed2 = 0;
        char[] characters = text.toCharArray();
        char[] characters2 = text2.toCharArray();
        for (char c : characters) {
            parsed1 += c;
        }
        for (char c : characters2) {
            parsed2 += c;
        }

        if ( parsed1 == parsed2){
            return 0;
        }
        else if ( parsed1 > parsed2){
            return 1;
        }
        else{
            return -1;
        }
    }

    public static boolean endssWith(String word ,String suffix){
        char[] characters = word.toCharArray();
        int lastIndex = word.length()-1;
        char[] ourSuffix = suffix.toCharArray();
        int suffixLength = suffix.length();
        int startSearchIndex = word.length()-suffixLength;
        int result = 0;
        int j = 0;
        for (int i = startSearchIndex; i <= lastIndex; i++){
            if (characters[i] != ourSuffix[j]){
                result += 1;
                j++;
            }
            else{
                result +=0;
                j++;
            }
        }
        if (result != 0){
            return false;
        }
        else{return true;}
    }

    public static int indexxOf(String str, String substring){
        char[] ourString = str.toCharArray();
        char[] ourSubstring = substring.toCharArray();
        int ourIndex = -1;
        int counter = 0;
        int j = 0;
        for(int i = 0; i < str.length(); i++){
            if (ourString[i] == ourSubstring[j]){
                counter++;
                j++;
                if (counter == substring.length()){
                    ourIndex = i - substring.length()+1;
                    break;
                }
            }
            else{
                counter = 0;
                j=0;
            }
        }
        if (counter == substring.length()){
            return ourIndex;
        }
        else{
            return -1;
        }
    }

    public static String replace(String word, char oldChar, char newChar){
        char[] characters = word.toCharArray();
        String result = "";
        for ( char c: characters){
            if (c == oldChar){
                c = newChar;
            }
            else{
                c = c;
            }
            result += c;
        }
        return result;
    }

    public static String subssString(String word, int beginIndex){
        char[] characters = word.toCharArray();
        String result = "";
        for (int i = beginIndex; i< word.length(); i++){
            result += characters[i];
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(stringCompare("aab", "aaa"));
        System.out.println(endssWith("abba", "bba"));
        System.out.println(indexxOf("javajestokej", "okej"));
        System.out.println(replace("javajestokej", 'j', 't'));
        System.out.println(subssString("javajestokej", 4));
    }
}
