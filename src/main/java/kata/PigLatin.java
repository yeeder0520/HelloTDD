package kata;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author YeeDer
 * @since 2023/9/14 AM 10:52
 **/
public class PigLatin {
    private static final Pattern regex = Pattern.compile("[a-zA-Z0-9]*");

    public static String pigIt(String pigLatinIsCool) {
        return Stream.of(pigLatinIsCool.split(" ")).map(word -> {
            if (word.matches(regex.pattern())) {
                word = word.substring(1) + word.charAt(0) + "ay";
            }
            return word;
        }).collect(Collectors.joining(" "));
    }

//    我最喜歡的解法
//    public static String pigIt(String str) {
//        return str.replaceAll("(\\w)(\\w*)", "$2$1ay");
//    }
}
