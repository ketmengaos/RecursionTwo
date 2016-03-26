import java.util.*;

public class LinkedList<E extends Comparable<E>> {

    private static class LinkedListEl<E extends Comparable<E>> {
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

    private static <E extends Comparable<E>> E max(LinkedListEl<E> head) {
        //Assumes head != null;
        LinkedListEl<E> p;
        E value = head.data;
        int compar;
        for(p = head; p != null; p = p.next) {
            compar = p.data.compareTo(value);
            if (compar > 0) {
                value = p.data;
            }
        }
        return value;
    }

    public E max() {
        return max(head);
    }

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.addHead(-1);
        ll.addHead(-45);
        ll.addHead(-3);
        ll.addHead(-40);
        ll.addHead(-80);
        System.out.println(ll.max());

        LinkedList<Character> ll2 = new LinkedList<Character>();
        ll2.addHead('A');
        ll2.addHead('C');
        ll2.addHead('X');
        System.out.println(ll2.max());

    }

}

