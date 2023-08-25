package kata;

import org.junit.jupiter.api.Test;

/**
 * <a href="https://www.codewars.com/kata/582041237df353e01d000084/train/java">原文網址</a>
 *
 * @author YeeDer
 * @since 2023/8/22 PM 03:46
 **/
public class FunWithListsFilterTest {

    @Test
    public void basicTests() {
        FunWithListsFilter.testFilter(null, x -> false, null);
        FunWithListsFilter.testFilter(new FunWithListsFilter.Node<>(1,
                                                                    new FunWithListsFilter.Node<>(2,
                                                                                                  new FunWithListsFilter.Node<>(
                                                                                                          3))),
                                      x -> true,
                                      new FunWithListsFilter.Node<>(1,
                                                                    new FunWithListsFilter.Node<>(2,
                                                                                                  new FunWithListsFilter.Node<>(
                                                                                                          3))));
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
