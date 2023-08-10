package kata;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://www.codewars.com/kata/6397b0d461067e0030d1315e/train/java">原文網址</a>
 *
 * @author YeeDer
 * @since 2023/8/10 AM 11:56
 **/
public class DecimalTimeConversionTest {

    @DisplayName("測試數字轉時間")
    @ParameterizedTest
    @CsvSource({
            "0.33,0:20",
            "1.75,1:45",
            "1.50,1:30",
            "53.07,53:04"
    })
    void toNormal_test(double input, String output) {
        //When
        String actual = DecimalTimeConversion.toNormal(input);
        //Then
        assertEquals(output, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "0:03,0.05",
            "0:04,0.07",
            "1:45,1.75",
            "1:30,1.50"
    })
    void toIndustrial_test_input_string(String input, double output) {
        //When
        double actual = DecimalTimeConversion.toIndustrial(input);
        //Then
        assertEquals(output, actual);
    }

    @ParameterizedTest
    @CsvSource({
            "1,0.02",
            "2,0.03",
            "105,1.75"
    })
    void toIndustrial_test_input_int(int input, double output) {
        //When
        double actual = DecimalTimeConversion.toIndustrial(input);
        //Then
        assertEquals(output, actual);
    }
}
