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
        long notDiscountBookCount = bookNames.length - differenceBookCount;
        double discount = discountHandler(differenceBookCount) * differenceBookCount * 100;
        double notDiscount = notDiscountBookCount * 100;
        return discount + notDiscount;
    }

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
