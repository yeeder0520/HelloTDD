package my.lesson3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * TDD練習 - 哈利波特書店
 * 個案:
 * 1.買一本書，價格是100
 * 2.買兩本一樣的書，價格是200 => ok
 * 3.買兩本不同的書，價格是190 => ok
 * 4.買三本不同的書，價格是270 => ok
 * 5.買四本不同的書，價格是320 => ok
 * 6.買五本不同的書，價格是375 => ok
 * 7.買1+5本不同的書，價格是100+375 => ok
 * 8.買2+5本不同的書，價格是575 => ok
 * 9.買兩本一樣的書 + 一本不一樣的書，價格是290
 *
 * @author YeeDer
 * @since 2023/8/11 PM 03:54
 **/
public class BookStoreTest {


    List<String> harryPorterBooks;

    @BeforeEach
    void init() {
        harryPorterBooks = Arrays.asList("哈利波特-神秘的魔法石",
                                         "哈利波特-消失的密室",
                                         "哈利波特-阿茲卡班的逃犯",
                                         "哈利波特-火盃的考驗",
                                         "哈利波特-鳳凰會的密令");
    }

    @Test
    void test_buy_1_book_when_discount_then_price_is_100() {
        //Given
        BookStore bookStore = new BookStore();

        //When
        double bookPrice = bookStore.sellBook("哈利波特-神秘的魔法石");

        //Then
        assertThat(bookPrice).isEqualTo(100);
    }

    @Test
    void test_buy_2_different_book_when_discount_then_price_is_190() {
        //Given
        BookStore bookStore = new BookStore();

        String book1 = "哈利波特-神秘的魔法石";
        String book2 = "哈利波特-消失的密室";

        //When
        double bookPrice = bookStore.sellBook(book1, book2);

        //Then
        assertThat(bookPrice).isEqualTo(190);
    }

    @Test
    void test_buy_3_different_book_when_discount_then_price_is_270() {
        //Given
        BookStore bookStore = new BookStore();

        String book1 = "哈利波特-神秘的魔法石";
        String book2 = "哈利波特-消失的密室";
        String book3 = "哈利波特-阿茲卡班的逃犯";

        //When
        double bookPrice = bookStore.sellBook(book1, book2, book3);

        //Then
        assertThat(bookPrice).isEqualTo(270);
    }

    @Test
    void test_buy_4_different_book_when_discount_then_price_is_320() {
        //Given
        BookStore bookStore = new BookStore();

        String book1 = "哈利波特-神秘的魔法石";
        String book2 = "哈利波特-消失的密室";
        String book3 = "哈利波特-阿茲卡班的逃犯";
        String book4 = "哈利波特-火盃的考驗";

        //When
        double bookPrice = bookStore.sellBook(book1, book2, book3, book4);

        //Then
        assertThat(bookPrice).isEqualTo(320);
    }

    @Test
    void test_buy_5_different_book_when_discount_then_price_is_375() {
        //Given
        BookStore bookStore = new BookStore();

        String book1 = "哈利波特-神秘的魔法石";
        String book2 = "哈利波特-消失的密室";
        String book3 = "哈利波特-阿茲卡班的逃犯";
        String book4 = "哈利波特-火盃的考驗";
        String book5 = "哈利波特-鳳凰會的密令";

        //When
        double bookPrice = bookStore.sellBook(book1, book2, book3, book4, book5);

        //Then
        assertThat(bookPrice).isEqualTo(375);
    }

    @Test
    void test_buy_6_different_book_when_discount_then_price_is_475() {
        //Given
        BookStore bookStore = new BookStore();

        String book1 = "哈利波特-神秘的魔法石";
        String book2 = "哈利波特-消失的密室";
        String book3 = "哈利波特-阿茲卡班的逃犯";
        String book4 = "哈利波特-火盃的考驗";
        String book5 = "哈利波特-鳳凰會的密令";
        String book6 = "哈利波特-混血王子的背叛";

        //When
        double bookPrice = bookStore.sellBook(book1, book2, book3, book4, book5, book6);

        //Then
        assertThat(bookPrice).isEqualTo(475);
    }

    @Test
    void test_buy_7_different_book_when_discount_then_price_is_575() {
        //Given
        BookStore bookStore = new BookStore();

        String book1 = "哈利波特-神秘的魔法石";
        String book2 = "哈利波特-消失的密室";
        String book3 = "哈利波特-阿茲卡班的逃犯";
        String book4 = "哈利波特-火盃的考驗";
        String book5 = "哈利波特-鳳凰會的密令";
        String book6 = "哈利波特-混血王子的背叛";
        String book7 = "哈利波特-死神的聖物I";

        //When
        double bookPrice = bookStore.sellBook(book1, book2, book3, book4, book5, book6, book7);

        //Then
        assertThat(bookPrice).isEqualTo(575);
    }

    @Test
    void test_buy_2_same_book_when_discount_then_price_is_200() {
        //Given
        BookStore bookStore = new BookStore();

        String book1 = "哈利波特-神秘的魔法石";
        String book2 = "哈利波特-神秘的魔法石";

        //When
        double bookPrice = bookStore.sellBook(book1, book2);

        //Then
        assertThat(bookPrice).isEqualTo(200);
    }


    /**
     * 隨機買書
     *
     * @return 書名
     */
    private String randomBuyBook(int buyBookCount) {
        Random random = new Random();

        for (int i = 0; i < buyBookCount; i++) {
            //TODO 重構這邊要繼續完成 => 要可以隨機買書，然後把買好的很多本書，丟給測試去跑
        }

        return harryPorterBooks.get(random.nextInt(8));
    }

    @Test
    void test_find_buy_3_books_when_discount_group_123_is_3() {
        //Given
        BookStore bookStore = new BookStore();
        String book1 = "哈利波特-神秘的魔法石";
        String book2 = "哈利波特-消失的密室";
        String book3 = "哈利波特-阿茲卡班的逃犯";
        List<Map<Object, Long>> list = new ArrayList<>();
        Map<Object, Long> map1 = new HashMap<>();
        map1.put(3L, 1L);
        Map<Object, Long> map2 = new HashMap<>();
        map2.put(1L, 3L);
        Map<Object, Long> map3 = new HashMap<>();
        map3.put(2L, 1L);
        map3.put(1L, 1L);

        //When
        List discountGroup = bookStore.discountGroup(book1, book2, book3);

        //Then
        assertThat(discountGroup).hasSize(3).contains(map1, map2);

    }

    @Test
    void test_find_buy_3_books_when_discount_group_112_is_3() {
        //Given
        BookStore bookStore = new BookStore();
        String book1 = "哈利波特-神秘的魔法石";
        String book2 = "哈利波特-消失的密室";
        String book3 = "哈利波特-消失的密室";

        Map<Object, Long> map1 = new HashMap<>();
        map1.put(2L, 1L);
        map1.put(1L, 1L);
        Map<Object, Long> map2 = new HashMap<>();
        map2.put(1L, 3L);

        //When
        List discountGroup = bookStore.discountGroup(book1, book2, book3);
        System.out.println(discountGroup);
        //Then
        assertThat(discountGroup).hasSize(3).contains(map1, map2);

    }
}
