package kata;

import kata.FunWithListsFilter.Node;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

/**
 * <a href="https://www.codewars.com/kata/582041237df353e01d000084/train/java">原文網址</a>
 *
 * @author YeeDer
 * @since 2023/8/22 PM 03:46
 **/
public class FunWithListsFilterTest {

    @Test
    public void basicTests() {
        Assertions.assertNull(FunWithListsFilter.filter(null, __ -> false));
        Assertions.assertEquals( new Node<>(1, new Node<>(2, new Node<>(3))).data,FunWithListsFilter.filter(new Node<>(1, new Node<>(2, new Node<>(3))), x -> true).data);
    }

    @Test
    public void arrayOfInts() {
        Assertions.assertEquals(new Node<>(1).data,FunWithListsFilter.filter(new Node<>(1, new Node<>(2, new Node<>(3))), x -> x == 1).data);
        Assertions.assertEquals(new Node<>(1, new Node<>(2)).data,FunWithListsFilter.filter(new Node<>(1, new Node<>(2, new Node<>(3))), x -> x <= 2).data);
    }


    @Test
    public void predicateTest() {
        Predicate<Integer> predicate2 = num -> num % 2 == 0;
        System.out.println(predicate2.test(3));
        System.out.println(predicate2.test(4));
    }

    @Test
    public void test(){

        String noticeNo = "AAAA";
        String responseStatus = "2";
        String responseCode = "993";

        if (noticeNo.isBlank() || ("2".equals(responseStatus) && "998".equals(responseCode)) || ("2".equals(responseStatus) && "922".equals(responseCode))){
            System.out.println("in");
        }else {
            System.out.println("not in ");
        }

    }


}
