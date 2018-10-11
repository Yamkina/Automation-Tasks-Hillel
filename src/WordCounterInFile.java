import java.io.*;
import java.util.HashMap;
import java.util.Scanner;

public class WordCounterInFile {
    public static void main(String[] args) throws IOException {

        FileReader textFile = new FileReader("fileText.txt");
        Scanner scanner = new Scanner(textFile);

        String string = scanner.nextLine();
        String[] words = string.split("\\s+");

        HashMap<String, Integer> wordsCount = new HashMap<>();
        for (String word : words) {
            if (!wordsCount.containsKey(word)) {
                wordsCount.put(word, 0);
            }
            wordsCount.put(word, wordsCount.get(word) + 1);
        }
        for (String word : wordsCount.keySet()) {
            System.out.println("Text contains words: " + word + " - times: " + wordsCount.get(word));
        }
    }
}
