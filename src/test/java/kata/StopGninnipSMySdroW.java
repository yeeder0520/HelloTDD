package kata;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StopGninnipSMySdroW {

    @ParameterizedTest
    @CsvSource({
            "emocleW,Welcome",
            "Hey wollef sroirraw,Hey fellow warriors",
            "A B C D E,A B C D E",
            "AAAB BCABB CCCAC,AAAB BBACB CACCC",
    })
    public void test(String input, String except) {
        assertEquals(except, new SpinWords().spinWords(input));
    }

}
