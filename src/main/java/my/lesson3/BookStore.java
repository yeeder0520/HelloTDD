package my.lesson3;


import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
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
     * 112235
     *
     * @param bookNames
     * @return
     */
    public List discountGroup(String... bookNames) {
        // 算出每種書的數量
        // 1: 2 2: 2 3: 1 5: 1
        Map<Object, Long> bookCountMap = Arrays.stream(bookNames)
                .collect(Collectors.groupingBy(bookName -> bookName, Collectors.counting()));


//        long differenceBookCount = Arrays.stream(bookNames).distinct().count();


        System.out.println("collect = " + bookCountMap);

//         key 4: 1 2: 1
//         key 3: 1 2: 1
//         key 2: 3
//         有這些組合 key: 折扣種類 value: 這個折扣出現幾次
        Map<Object, Long> resultActualMap = new HashMap<>();
        if (bookCountMap.entrySet().stream()
                .filter(e -> e.getValue() > 1).count() > 0) {
            resultActualMap.put(bookCountMap.keySet().stream()
                    .distinct()
                    .count(), 1L);
        }
        Map<Object, Long> lonely_book1_lonely_book2_lonely_book3 = new HashMap<>();
        lonely_book1_lonely_book2_lonely_book3.put(1L, Long.valueOf(bookNames.length));

        Map<Object, Long> combineBook1Book2_lonely_book3 = new HashMap<>();
        combineBook1Book2_lonely_book3.put(bookCountMap.keySet().stream()
                .distinct()
                .count() - 1, 1L);
        combineBook1Book2_lonely_book3.put(1L, 1L);

        // 可能的結果
        List<Map<Object, Long>> probabilityList = new ArrayList<>();
        probabilityList.add(lonely_book1_lonely_book2_lonely_book3);
        probabilityList.add(combineBook1Book2_lonely_book3);
        return probabilityList;
    }

    public Object getBook(Object target, Map<Object, Long> bookCountMap) {
        List<Object> bookNameList = bookCountMap.entrySet().stream()
                .filter(e -> e.getValue() > 0)
                .map(e -> e.getKey())
                .collect(Collectors.toList());
        for (Object bookName : bookNameList) {
            if (!bookName.equals(target)) {
                long remaining = bookCountMap.get(bookName) - 1;
                bookCountMap.put(bookName, remaining);
                return bookName;
            }
        }
        return null;
    }


    public long discountGroup2(String... bookNames) {


        Queue<String> bookQueue = initBookQueue(bookNames);

        HashMap<String, Integer> discountGroup = new HashMap<>();

        AtomicInteger atomicInteger = new AtomicInteger();

        HashSet<String> discountGroupSet = new HashSet<>();
        String previousBook = "";
        // 获取并移除队首元素
        while (!bookQueue.isEmpty()) {

            String currentBook = bookQueue.poll();
            System.out.println("Current book: " + currentBook);

            if (!previousBook.isBlank() && previousBook.equals(currentBook)) {
                System.out.println("Same as previous: " + currentBook);
                bookQueue.offer(currentBook);
                continue;
            }
            discountGroupSet.add(currentBook + ",");
            System.out.println("previousBook = " + previousBook);
            previousBook = currentBook;
        }


        String[] strings = {"a", "b", "c", "d", "e"};

        // |a|b|c|d|e , the initial | join is not what we want
        String reduce = Arrays.stream(strings).reduce("", (a, b) -> a + "|" + b);
        System.out.println("reduce = " + reduce);


//        System.out.println("Queue Elements:");
//        for (String element : queue) {
//            System.out.println(element);
//        }

        return 3L;
    }

    private Queue<String> initBookQueue(String[] bookNames) {
        Queue<String> queue = new LinkedList<>();
        for (String bookName : bookNames) {
            queue.offer(bookName);
        }
        return queue;
    }
}
