import java.util.*;

public class LinkedList<E extends Comparable<E>> {

    private static class Pair<K, V> {
        K first;
        V second;

        public Pair(K f, V s) {
            this.first = f;
            this.second = s;
        }
    }

    private static class LinkedListEl<E> {
        E data;
        LinkedListEl<E> next;

        public LinkedListEl(E data, LinkedListEl<E> next) {
            this.data = data;
            this.next = next;
        }
    }

    LinkedListEl<E> head = null,
                    tail = null;

    //Add Head Method
    void addHead(E e) {
        head = new LinkedListEl<E>(e, head);
        if (tail == null)
            tail = head;
    }

    //First Assignment:
    private static <E extends Comparable<E>> E max(LinkedListEl<E> head) {
        //Assumes head != null;
        E value;
        if (head == null || head.next == null) return head.data;
        value = max(head.next);
        if(head.data.compareTo(value) > 0)
            value = head.data;
        return value;
    }

    public E max() {
        return max(head);
    }

    // Second Assignment:
    /*private static <E> Pair<LinkedListEl<E>, LinkedListEl<E>> everyOther(LinkedListEl<E> head) {
        if(head == null || head.next == null)
            return new Pair<LinkedListEl<E>, LinkedListEl<E>>(null, null);
        Pair<LinkedListEl<E>, LinkedListEl<E>> pair = everyOther(head.next.next);
        head.next.next = pair.first;
        return new Pair<LinkedListEl<E>, LinkedListEl<E>>(head, pair.second == null ? head : pair.second);
    }

    public LinkedList<E> everyOther() {

    }/*

    // Third Assignment:
    /*private static <E> boolean hasDuplicate(LinkedListEl<E> head) {
        LinkedListEl<E> p;
        if(head == null || head.next == null)
            return false;

    }
    public boolean hasDuplicate() {

    }
    */
    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.addHead(-1);
        ll.addHead(-45);
        ll.addHead(-3);
        ll.addHead(-40);
        ll.addHead(-80);
        System.out.println(ll.max());
        //System.out.println(ll.everyOther());

        LinkedList<Character> ll2 = new LinkedList<Character>();
        ll2.addHead('A');
        ll2.addHead('C');
        ll2.addHead('X');
        System.out.println(ll2.max());

    }

}

