import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class AllPossibleEnglishWords {
    public static void main(String[] args) throws IOException {

        Set<String> resultWords = new HashSet<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter any word: ");
        String inputWord = scanner.nextLine().toUpperCase();

        Map<Character, Integer> inputWordCountLetters = getLetterCount(inputWord);

        FileReader fileReader = new FileReader("src/test/resources/EnglishDictionary");
        BufferedReader reader = new BufferedReader(fileReader);

        System.out.println("All possible English words from user input: ");

        for (String currentWord = reader.readLine(); currentWord != null; currentWord = reader.readLine()) {

                Map<Character, Integer> countCurrentWord = getLetterCount(currentWord);

                boolean canMakeCurrentWord = true;
                for (Character eachCharacter : countCurrentWord.keySet()) {

                    int currentWordCharCount = countCurrentWord.get(eachCharacter);
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
        scanner.close();
        reader.close();

    }

    public static Map<Character, Integer> getLetterCount(String inputWord){
        Map<Character, Integer> countLetter = new HashMap<>();

        for (int i = 0; i < inputWord.length(); i++) {

            char currentChar = inputWord.charAt(i);

            int count = countLetter.containsKey(currentChar) ? countLetter.get(currentChar) : 0;

            countLetter.put(currentChar, count + 1);
        }

        return countLetter;
    }

}
