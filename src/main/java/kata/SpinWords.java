package kata;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SpinWords {

    public static final String SPACE = " ";

    public String spinWords(String input) {
        List<String> inputString = Arrays.stream(input.split(SPACE)).collect(Collectors.toList());
        StringBuilder result = new StringBuilder();
        for (String letter : inputString) {
            if (isLetterGreaterThanFive(letter)) {
                revertString(letter, result);
            } else {
                result.append(letter);
            }
            result.append(SPACE);
        }
        return result.toString().trim();
    }

    private void revertString(String letter, StringBuilder stringBuffer) {
        for (int i = letter.length() - 1; i >= 0; i--) {
            stringBuffer.append(letter.charAt(i));
        }
    }

    private boolean isLetterGreaterThanFive(String letter) {
        return letter.length() >= 5;
    }

      //我最喜歡的寫法
//    public String spinWords(String sentence) {
//        return Arrays.stream(sentence.split(" "))
//                .map(i -> i.length() > 4 ? new StringBuilder(i).reverse().toString() : i)
//                .collect(Collectors.joining(" "));
//    }
}
