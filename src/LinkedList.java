//**********************************************************************************
//******** || Ket-Meng Jimmy Cheng   ~    April 1, 2016   ~  LinkedLists || ********
//******** || ---------------------------------------------------------- || ********
//******** || This program does three things: finds the maximum node     || ********
//******** || in a linked list, returns a new linkedlist with the 1, 3, 5|| ********
//******** || nodes, and returns true if a linked list has a duplicate.  || ********
//**********************************************************************************

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

    // First Assignment:
    private static <E extends Comparable<E>> E max(LinkedListEl<E> head) {
        E value;
        if (head == null || head.next == null) return head.data;
        value = max(head.next);
        if (head.data.compareTo(value) > 0)
            value = head.data;
        return value;
    }

    public E max() {
        return max(head);
    }

    // Second Assignment:
    private static <E> Pair<LinkedListEl<E>, LinkedListEl<E>> everyOther(LinkedListEl<E> head) {
        if (head == null || head.next == null)
            return new Pair<LinkedListEl<E>, LinkedListEl<E>>(null, null);
        Pair<LinkedListEl<E>, LinkedListEl<E>> pair  = everyOther(head.next.next);
        head.next = pair.first;
        return new Pair<LinkedListEl<E>, LinkedListEl<E>>(head, pair.first == null ? head : pair.second);
    }

    public LinkedList<E> everyOther() {
        LinkedList<E> newList = new LinkedList<E>();
        head = everyOther(head).first;
        newList.head = head;
        return newList;
    }

    // Third Assignment:
    private static <E> boolean hasDuplicate(LinkedListEl<E> head) {
        LinkedListEl<E> p;
        if (head == null || head.next == null)
            return false;
        boolean duplicate = hasDuplicate(head.next);
        if (duplicate)
            return true;
        for (p = head.next; p != null; p = p.next) {
            if (head.data.equals(p.data))
                duplicate = true;
        }
        return duplicate;
    }

    public boolean hasDuplicate() {
        return hasDuplicate(head);
    }

    public String toString() {
        String s = "{ ";
        LinkedListEl<E> p;
        for (p = head; p != null; p = p.next)
            s += p.data + " ";
        return s + "}";
    }

    public static void main(String[] args) {
        //Please comment/uncomment for each test.
        LinkedList<Integer> ll = new LinkedList<Integer>();
        ll.addHead(-40);
        ll.addHead(-40);
        ll.addHead(10);
        ll.addHead(-45);
        ll.addHead(-3);
        ll.addHead(-80);
        //System.out.println(ll.max()); //Max method
        System.out.println(ll.everyOther()); //everyOther method
        //System.out.println(ll.hasDuplicate()); //hasDuplicate method

        LinkedList<Character> ll2 = new LinkedList<Character>();
        ll2.addHead('A');
        ll2.addHead('C');
        ll2.addHead('X');
        ll2.addHead('D');
        ll2.addHead('G');
        ll2.addHead('Z');
        //System.out.println(ll2.max());
        System.out.println(ll2.everyOther());
        //System.out.println(ll2.hasDuplicate());
    }

}

