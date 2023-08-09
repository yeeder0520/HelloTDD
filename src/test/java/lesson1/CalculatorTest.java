package lesson1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

/**
 * 計算機測試個案
 *
 * @author YeeDer
 * @since 2023/8/9 PM 04:53
 **/
public class CalculatorTest {

    @ParameterizedTest
    @CsvSource({"1,1,2","2,3,5","6,3,9"})
    void plus_test(int number1, int number2, int except) {
        //Given
        Calculator calculator = new Calculator();

        //When
        int actual = calculator.plus(number1, number2);

        //Then
        Assertions.assertEquals(except, actual);
    }

}
