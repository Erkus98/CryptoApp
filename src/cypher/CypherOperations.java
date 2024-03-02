package cypher;

import java.util.*;

public class CypherOperations {
    public static final List ALPHABET = Arrays.asList('а', 'б', 'в',
            'г', 'д', 'е', 'ж', 'з', 'и', 'й', 'к', 'л', 'м', 'н', 'о', 'п', 'р', 'с', 'т', 'у',
            'ф', 'х', 'ц', 'ч', 'ш', 'щ', 'ъ', 'ы', 'ь', 'э', 'ю', 'я', '.', ',', '«', '»',
            ':', '!', '?', ' ');
    private static final String[] COMMON_WORDS = {"и", "в", "не", "на", "что", "он", "то", "как", "с", "по","а","но"};



    public static String encrypt(String message, int shiftKey) {
            String updatedString = "";
            var alphabetInArrayList = new ArrayList<>(ALPHABET);
            message = message.toLowerCase();
            for (int i = 0; i < message.length(); i++) {
                if (alphabetInArrayList.contains(message.charAt(i))) {
                    int charPosition = alphabetInArrayList.indexOf(message.charAt(i));
                    char shiftedChar = (char) alphabetInArrayList.get((charPosition + shiftKey) % alphabetInArrayList.size());
                    updatedString += shiftedChar;

                }

            }
            return updatedString;

        }

    public static String decrypt(String message, int shiftKey) {
        String updatedString = "";
        var alphabetInArrayList = new ArrayList<>(ALPHABET);
        for (int i = 0; i < message.length(); i++) {
            if (alphabetInArrayList.contains(message.charAt(i))) {
                int charPosition = alphabetInArrayList.indexOf(message.charAt(i));
                int originalCharPosition = (charPosition - shiftKey) % alphabetInArrayList.size();
                if (originalCharPosition < 0) {
                    originalCharPosition = alphabetInArrayList.size() - (shiftKey - charPosition);
                }
                char originalChar = (char) alphabetInArrayList.get(originalCharPosition);
                updatedString += originalChar;
            }
        }
        return updatedString;
    }

    public static String bruteForce(String source) {
        var alphabetInArrayList = new ArrayList<>(ALPHABET);
        source = source.toLowerCase();
        for (int i = 0; i < alphabetInArrayList.size(); i++) {

            String decryptedText = decrypt(source, i);
            Map<String, Integer> wordCounts = new HashMap<>();
            String[] words = decryptedText.split("\\s+");
            for (String word :
                    words) {
                wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
            }
            int commonWordsCount = 0;
            for (String commonWord :
                    COMMON_WORDS) {
                commonWordsCount += wordCounts.getOrDefault(commonWord, 0);
                if (commonWordsCount >= 2) {
                    return decryptedText;
                }
            }
        }
        return "There were not enough common words to crack this cypher :(";
    }



}
