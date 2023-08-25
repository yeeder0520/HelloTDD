package kata;

import java.util.function.Predicate;

/**
 * https://www.codewars.com/kata/582041237df353e01d000084
 *
 * @author YeeDer
 * @since 2023/8/22 PM 03:45
 **/
public class FunWithListsFilter {


    static <T> Node testFilter(Node input_list_head, Predicate<T> predicate, Node expected_list_head) {
        return null;
    }

    static class Node<T> {
        public T data;
        public Node<T> next;

        Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

        Node(T data) {
            this(data, null);
        }
    }

}
