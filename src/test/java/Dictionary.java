import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Dictionary {

    public static boolean isEnglishWord(String str) throws IOException {

        str = str.toUpperCase();

        boolean isEnlgishWord = false;
        Set<String> resultWords = new HashSet<>();

        Map<Character, Integer> inputWordCountLetters = getLettersCount(str);

        FileReader fileReader = new FileReader("src/test/resources/EnglishDictionary");
        BufferedReader reader = new BufferedReader(fileReader);

        for (String currentWord = reader.readLine(); currentWord != null; currentWord = reader.readLine()) {

            if (str.equalsIgnoreCase(currentWord)) {
                isEnlgishWord = true;
            }

            Map<Character, Integer> countCurrentWordLetters = getLettersCount(currentWord);

            boolean canMakeCurrentWord = true;

            for (Character eachCharacter : countCurrentWordLetters.keySet()) {

                int currentWordCharCount = countCurrentWordLetters.get(eachCharacter);
                int inputLettersCharCount = inputWordCountLetters.containsKey(eachCharacter) ? inputWordCountLetters.get(eachCharacter) : 0;

                if (currentWordCharCount > inputLettersCharCount) {
                    canMakeCurrentWord = false;
                    break;
                }
            }

            if (canMakeCurrentWord) {
                resultWords.add(currentWord);
            }
        }

        System.out.println(resultWords);
        System.out.println();
        System.out.print("Is user input English word: ");

        return isEnlgishWord;
    }

    public static Map<Character, Integer> getLettersCount(String inputWord){
        Map<Character, Integer> countLetter = new HashMap<>();

        for (int i = 0; i < inputWord.length(); i++) {

            char currentChar = inputWord.charAt(i);

            int count = countLetter.containsKey(currentChar) ? countLetter.get(currentChar) : 0;

            countLetter.put(currentChar, count + 1);
        }

        return countLetter;
    }
}