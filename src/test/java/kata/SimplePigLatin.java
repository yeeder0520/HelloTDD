package kata;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * @author YeeDer
 * @since 2023/9/14 AM 10:51
 */
public class SimplePigLatin {

    @ParameterizedTest
    @CsvSource({
            "igPay atinlay siay oolcay,Pig latin is cool",
            "hisTay siay ymay tringsay,This is my string",
            "elloHay orldWay,Hello World",
            "elloHay orldway !,Hello world !",
            "!@#$%,!@#$%",
            "231ay xczay ### %%% %$%$,123 zxc ### %%% %$%$",
            "oratay oay oresmay ![],tora o mores ![]",
            "psosiay ustodescay ?[],ipsos custodes ?[]",
            "psosiay ustodescay [],ipsos custodes []"
    })
    public void FixedTests(String expected, String actual) {
        assertEquals(expected, PigLatin.pigIt(actual));
    }
}
