package my.lesson3;


import java.util.Arrays;

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

}
