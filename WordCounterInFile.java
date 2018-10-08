import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WordCounterInFile {
    public static void main(String[] args) throws FileNotFoundException {
        File textFile = new File("C:\\Users\\Alexandra\\IdeaProjects\\Automation_homework\\fileText.txt");
        Scanner scanner = new Scanner(new FileInputStream(textFile));

        int wordCount = 0;
        while(scanner.hasNext()){
            scanner.next();
            wordCount++;
        }
        System.out.println("Words number:" + wordCount);


    }
}
