import java.util.ArrayList;
import java.util.Iterator;
import java.util.NoSuchElementException;


public class LinkedList<Type> implements Iterable<Type> {

    public Node<Type> head;
    public Node<Type> tail;

    public void push(Type item) {
        if (head == null) {
            head = new Node<>(item, null);
            tail = head;
        } else {
            tail.next = new Node<>(item, tail);
            tail = tail.next;
        }
    }

    public Type getFirst() {
        if (head == null) throw new NoSuchElementException();
        return head.item;
    }

    public Type getLast() {
        if (tail == null) throw new NoSuchElementException();
        return tail.item;
    }

    public Type pullFirst() {
        if (head == null) throw new NoSuchElementException();
        Node<Type> cur = head;
        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }
        return cur.item;
    }

    public Type pullLast() {
        if (tail == null) throw new NoSuchElementException();
        Node<Type> cur = tail;
        if (tail == head) {
            tail = head = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }
        return cur.item;
    }

    public Type get(int index) {
        if (index < 0) throw new IndexOutOfBoundsException();
        int pos = 0;
        Node<Type> cur = head;
        while (cur != null && pos != index) {
            cur = cur.next;
            pos++;
        }
        if (cur == null) throw new IndexOutOfBoundsException();
        return cur.item;
    }

    public Type get(Type item) {
        Node<Type> cur = head;
        while (cur != null && !cur.item.equals(item)) {
            cur = cur.next;
        }
        if (cur == null) throw new NoSuchElementException();
        return cur.item;
    }

    public Type remove(int index) {
        if (index < 0) throw new IndexOutOfBoundsException();
        int pos = 0;
        Node<Type> cur = head;
        Node<Type> prev = head.prev;
        while (cur != null && pos != index) {
            prev = cur;
            cur = cur.next;
            pos++;
        }
        setValues(cur, prev);
        return cur.item;

    }

    public Type remove(Type item) {
        Node<Type> cur = head;
        Node<Type> prev = head.prev;
        while (cur != null && !cur.item.equals(item)) {
            prev = cur;
            cur = cur.next;
        }
        setValues(cur, prev);
        return cur.item;

    }

    private void setValues(Node<Type> cur, Node<Type> prev) {
        if (cur == head) {
            head = head.next;
            head.prev = null;
        } else if (cur == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            if (cur == null) throw new IndexOutOfBoundsException();
            prev.next = cur.next;
            cur.next.prev = prev;
        }
    }

    static class Node<Type> {
        private Type item;
        private Node<Type> next;
        private Node<Type> prev;

        public Node(Type item, Node<Type> prev) {
            this.item = item;
            this.prev = prev;
        }

        public Type getItem() {
            return item;
        }
    }

    @Override
    public Iterator<Type> iterator() {
        return new MyIterator(head);
    }

    private final class MyIterator implements Iterator<Type> {
        private Node<Type> cur;

        public MyIterator(Node<Type> head) {
            this.cur = head;
        }

        @Override
        public boolean hasNext() {
            return cur != null;
        }

        @Override
        public Type next() {
            Type item = cur.item;
            cur = cur.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

    }

    public static void main(String[] args) {
        LinkedList ll = new LinkedList();
        ll.push("a");
        ll.push("s");
        ll.push("d");
        ll.push("f");
        ll.push("g");
        ll.push("h");
        ll.push("j");
        ll.push("k");

        print(ll, "Start linked list: ");
        System.out.println("getFirst: " + ll.getFirst());
        System.out.println("getLast: " + ll.getLast());
        System.out.println("get(1): " + ll.get(1));
        System.out.println("get(" + "d" + "): " + ll.get("d"));


        ll.pullFirst();
        print(ll, "After pull first: ");

        ll.pullLast();
        print(ll, "After pull last: ");

        ll.remove(0);
        print(ll, "After remove(0): ");

        ll.remove("d");
        print(ll, "After remove(" + "d" + "): ");

    }

    public static void print(LinkedList<Node> ll, String message) {
        System.out.print(message);
        for (Object it : ll) {
            System.out.print(it);
        }
        System.out.println();
    }

}
