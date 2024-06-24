package kata.FizzBuzz;

import static org.assertj.core.api.Assertions.assertThat;

import kata.IsSatorSquare.FizzBuzz;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class FizzBuzzTest {

  @Test
  void test_given_1_then_1() {

    FizzBuzz fizzBuzz = new FizzBuzz();

    String actual = fizzBuzz.execute(1);

    assertThat(actual).isEqualTo("1");
  }

  @Test
  void test_given_3_then_Fizz() {

    FizzBuzz fizzBuzz = new FizzBuzz();

    String actual = fizzBuzz.execute(3);

    assertThat(actual).isEqualTo("1,2,Fizz");
  }


  @Test
  void test_given_5_then_Buzz() {

    FizzBuzz fizzBuzz = new FizzBuzz();

    String actual = fizzBuzz.execute(5);

    assertThat(actual).isEqualTo("1,2,Fizz,4,Buzz");
  }

  @Test
  void test_given_15_then_FizzBuzz() {

    FizzBuzz fizzBuzz = new FizzBuzz();

    String actual = fizzBuzz.execute(15);

    assertThat(actual).isEqualTo("1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz");
  }

  @ParameterizedTest
  @CsvSource(value = {
      "1:1",
      "3:1,2,Fizz",
      "5:1,2,Fizz,4,Buzz",
      "15:1,2,Fizz,4,Buzz,Fizz,7,8,Fizz,Buzz,11,Fizz,13,14,FizzBuzz",
  }, delimiter = ':')
  void test_should_be_successful(Integer input, String expected) {

    FizzBuzz fizzBuzz = new FizzBuzz();

    String actual = fizzBuzz.execute(input);

    assertThat(actual).isEqualTo(expected);
  }
}
