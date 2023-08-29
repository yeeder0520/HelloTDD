package kata;

import java.util.function.Predicate;

/**
 * https://www.codewars.com/kata/582041237df353e01d000084
 *
 * @author YeeDer
 * @since 2023/8/22 PM 03:45
 **/
public class FunWithListsFilter {

    public static <T> Node<T> filter(Node<T> inputNode, Predicate<T> predicate) {
        Node<T> newHead = null;
        Node<T> tail = null;

        while (inputNode != null) {
            if (predicate.test(inputNode.data)) {
                Node<T> newNode = new Node<>(inputNode.data);
                if (newHead == null) {
                    newHead = newNode;
                } else {
                    tail.next = newNode;
                }
                tail = newNode;
            }
            inputNode = inputNode.next;
        }
        return newHead;
    }

    static class Node<T> {
        public T data;
        public Node<T> next;

        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }

        Node(T data) {
            this(data, null);
        }
    }
}
