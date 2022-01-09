package lab3Zad2i3;

public class Lancuch {
    private String lancuch;
    private String koncowka;
    private char pierwszaLitera;

    public String getLancuch() {
        return lancuch;
    }

    public String getKoncowka() {
        return koncowka;
    }

    public char getPierwszaLitera() {
        return pierwszaLitera;
    }

    public Lancuch(){
        lancuch = "abcdefghij";
        koncowka = "hij";
        pierwszaLitera = 'a';
    }

    public Lancuch(String lancuch){
        if (lancuch.length() >= 5){
            this.lancuch = lancuch;
            koncowka = "";
            char[] ourString = lancuch.toCharArray();
            for(int i = 3; i>0; i--){
                koncowka += ourString[ourString.length-i];
            }
            pierwszaLitera = ourString[0];
        } else {
            char[] ourString = lancuch.toCharArray();
            int[] newString = new int[5];
            for (int i = 0; i<newString.length; i++){
                if (i< ourString.length){
                    newString[i] = ourString[i];
                }
                else {
                    if(newString[i-1] == 122){
                        newString[i] = 97;
                    }
                    else if(newString[i-1] == 92){
                        newString[i] = 65;
                    }
                    else{
                        newString[i] =  newString[i-1] + 1;
                    }
                }

            }
            this.lancuch = "";
            for (int c : newString){
                this.lancuch += (char) c;
            }
            koncowka = "";

            for(int i = 3; i>0; i--){
                koncowka += (char) newString[newString.length-i];
            }

            pierwszaLitera = (char) newString[0];
        }
    }

    public String Merge(Lancuch someString){
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < this.lancuch.length() || i < someString.lancuch.length(); i++) {

            if (i < this.lancuch.length())
                result.append(this.lancuch.charAt(i));

            if (i < someString.lancuch.length())
                result.append(someString.lancuch.charAt(i));
        }

        return this.lancuch = result.toString();
    }
    public int IleASCII(){
        char[] ourString = lancuch.toCharArray();
        int ourASCIIResult = 0;
        for (char c : ourString){
            ourASCIIResult += c;
        }
        return ourASCIIResult;
    }
}
