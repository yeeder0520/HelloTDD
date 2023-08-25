package my.lesson3;


import java.util.*;
import java.util.stream.Collectors;

/**
 * @author YeeDer
 * @since 2023/8/11 PM 04:04
 **/
public class BookStore {

    public double sellBook(String... bookNames) {
        long differenceBookCount = Arrays.stream(bookNames).distinct().count();

        if (differenceBookCount >= 5) {
            differenceBookCount = 5;
        }

        double totalDiscountBookPrice = discountHandler(differenceBookCount) * differenceBookCount * 100;
        double totalNotDiscountBookPrice = (bookNames.length - differenceBookCount) * 100;

        return totalDiscountBookPrice + totalNotDiscountBookPrice;
    }

    /**
     * 根據買幾本不同的書，取出對應的折扣
     *
     * @param differenceBookCount 有幾本不同的書
     *
     * @return 折扣數
     */
    private static double discountHandler(long differenceBookCount) {
        if (differenceBookCount == 2) {
            return 0.95;
        } else if (differenceBookCount == 3) {
            return 0.9;
        } else if (differenceBookCount == 4) {
            return 0.8;
        } else if (differenceBookCount == 5) {
            return 0.75;
        } else {
            return 1;
        }
    }

    /**
     * @param bookNames
     *
     * @return
     */
    public List discountGroup(String... bookNames) {
        // 算出每種書的數量
        // 1: 2 2: 2 3: 1 5: 1
        Map<String, Long> bookCountMap = Arrays.stream(bookNames).collect(Collectors.groupingBy(bookName -> bookName,
                                                                                                Collectors.counting()));
//        long differenceBookCount = Arrays.stream(bookNames).distinct().count();
        System.out.println("collect = " + bookCountMap);
        return null;
    }

    private Queue<String> initBookQueue(String[] bookNames) {
        Queue<String> queue = new LinkedList<>();
        for (String bookName : bookNames) {
            queue.offer(bookName);
        }
        return queue;
    }
}
