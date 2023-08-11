package my.lesson2;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * AssertjTest的練習題目
 *
 * @author YeeDer
 * @since 2023/8/11 PM 02:17
 **/
public class AssertjTest {

    @ParameterizedTest
//    @CsvSource({"CA230I11I0", "CA23081100"})
    @CsvSource({"CA230811I0"})
    public void test_valid_id_success(String actual) {
        assertThat(actual)
                .hasSize(10)
                .startsWith("CA")
                .doesNotContain("id")
                .doesNotContainAnyWhitespaces()
                .containsOnlyOnce("I");
    }

    @Test
    void test_valid_name_list_success() {
        ArrayList<String> actual = Lists.newArrayList("David", "John", "Mary", "Amy");
        assertThat(actual)
                .hasSize(4)
                .containsAnyOf("John", "David")
                .doesNotContain("Peter")
                .filteredOn(name -> name.length() > 5)
                .isEmpty();
    }

    @Test
    void test_valid_name_list_fail() {
        ArrayList<String> actual = Lists.newArrayList("David", "John", "Mary", "Johnson");
        assertThat(actual)
                .hasSize(4)
                .containsAnyOf("John", "David")
                .doesNotContain("Peter")
                .filteredOn(name -> name.length() > 5)
                .isNotEmpty();
    }
}
