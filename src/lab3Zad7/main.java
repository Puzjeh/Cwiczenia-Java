package lab3Zad7;


import java.io.*;

public class main {
    public static void GenerateFile(String fileName) throws IOException {
        String numbers = "12.4:9.9:10.8:11.4:22.2:66.6";
        BufferedWriter writer = new BufferedWriter( new FileWriter(fileName));
        writer.write(numbers);
        writer.close();
    }

    public static void ReadFile(String fileName) throws IOException {
        String numbers;
        FileReader fReader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(fReader);
        numbers = reader.readLine();
        reader.close();
        fReader.close();
        System.out.println(numbers);
    }

    public static void ChangeFile(String fileName) throws IOException {
        String numbers;
        String newNumbers = "";
        FileReader fReader = new FileReader(fileName);
        BufferedReader reader = new BufferedReader(fReader);
        numbers = reader.readLine();
        char[] chars = numbers.toCharArray();
        for (char c : chars){
            if (c == '.'){
                c = ',';
                newNumbers += c;
            }
            else if (c == ':'){
                c = ' ';
                newNumbers += c;
            }
            else {
                newNumbers += c;
            }
        }
        reader.close();
        fReader.close();
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        writer.write(newNumbers);
        writer.close();
    }


    public static void main(String[] args) throws IOException {
        GenerateFile("numbers.txt");
        ReadFile("numbers.txt");
        ChangeFile("numbers.txt");
        ReadFile("numbers.txt");
    }
}
