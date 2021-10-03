import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Dictionary {

    public static boolean isEnglishWord(String str) throws IOException {

        FileReader fileReader = new FileReader("src/test/resources/EnglishDictionary");
        BufferedReader reader = new BufferedReader(fileReader);

        for (String eachCurrentWord = reader.readLine(); eachCurrentWord != null; eachCurrentWord = reader.readLine()) {

            if (str.equalsIgnoreCase(eachCurrentWord)) {
                return true;
            }

        }
        return false;
    }
}
