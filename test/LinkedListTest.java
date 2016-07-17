import org.junit.Test;

import java.util.NoSuchElementException;

import static org.junit.Assert.*;

/**
 * Created by Oleg on 17.07.2016.
 */
public class LinkedListTest {

    @Test
    public void push() throws Exception {
        LinkedList ll = new LinkedList();
        ll.push("a");
        ll.push("s");
        ll.push("d");
        String actual = "";
        for (Object s : ll) {
            actual = actual + s;
        }
        assertEquals("asd", actual);
    }

    @Test
    public void pushHead() throws Exception {
        LinkedList ll = new LinkedList();
        ll.push("a");
        ll.push("s");
        ll.push("d");
        assertEquals("a", ll.head.getItem());
    }

    @Test
    public void pushTail() throws Exception {
        LinkedList ll = new LinkedList();
        ll.push("a");
        ll.push("s");
        ll.push("d");
        assertEquals("d", ll.tail.getItem());
    }

    @Test
    public void getFirst() throws Exception {
        LinkedList ll = new LinkedList();
        ll.push("a");
        ll.push("s");
        ll.push("d");
        assertEquals("a", ll.getFirst());
    }

    @Test
    public void getLast() throws Exception {
        LinkedList ll = new LinkedList();
        ll.push("a");
        ll.push("s");
        ll.push("d");
        assertEquals("d", ll.getLast());
    }

    @Test
    public void pullFirstOneNode() throws Exception {
        LinkedList ll = new LinkedList();
        ll.push("a");
        ll.pullFirst();
        String actual = "";
        for (Object s : ll) {
            actual = actual + s;
        }
        assertEquals("", actual);
    }

    @Test
    public void pullFirstManyNodes() throws Exception {
        LinkedList ll = new LinkedList();
        ll.push("a");
        ll.push("s");
        ll.push("d");
        ll.pullFirst();
        String actual = "";
        for (Object s : ll) {
            actual = actual + s;
        }
        assertEquals("sd", actual);
    }

    @Test
    public void pullLastOneNode() throws Exception {
        LinkedList ll = new LinkedList();
        ll.push("a");
        ll.pullLast();
        String actual = "";
        for (Object s : ll) {
            actual = actual + s;
        }
        assertEquals("", actual);
    }

    @Test
    public void pullLastManyNodes() throws Exception {
        LinkedList ll = new LinkedList();
        ll.push("a");
        ll.push("s");
        ll.push("d");
        ll.pullLast();
        String actual = "";
        for (Object s : ll) {
            actual = actual + s;
        }
        assertEquals("as", actual);
    }

    @Test
    public void getFirstByIndex() throws Exception {
        LinkedList ll = new LinkedList();
        ll.push("a");
        ll.push("s");
        ll.push("d");
        assertEquals("a", ll.get(0));
    }

    @Test
    public void getMiddleByIndex() throws Exception {
        LinkedList ll = new LinkedList();
        ll.push("a");
        ll.push("s");
        ll.push("d");
        assertEquals("s", ll.get(1));
    }

    @Test
    public void getLastByIndex() throws Exception {
        LinkedList ll = new LinkedList();
        ll.push("a");
        ll.push("s");
        ll.push("d");
        assertEquals("d", ll.get(2));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void getExceptionByIndex() throws Exception {
        LinkedList ll = new LinkedList();
        ll.push("a");
        ll.push("s");
        ll.push("d");
        String s = (String) ll.get(3);
    }

    @Test
    public void getFirstByItem() throws Exception {
        LinkedList ll = new LinkedList();
        ll.push("a");
        ll.push("s");
        ll.push("d");
        assertEquals("a", ll.get("a"));
    }

    @Test
    public void getMiddleByItem() throws Exception {
        LinkedList ll = new LinkedList();
        ll.push("a");
        ll.push("s");
        ll.push("d");
        assertEquals("s", ll.get("s"));
    }

    @Test
    public void getLastMyItem() throws Exception {
        LinkedList ll = new LinkedList();
        ll.push("a");
        ll.push("s");
        ll.push("d");
        assertEquals("d", ll.get("d"));
    }

    @Test(expected = NoSuchElementException.class)
    public void getExceptionByItem() throws Exception {
        LinkedList ll = new LinkedList();
        ll.push("a");
        ll.push("s");
        ll.push("d");
        String s = (String) ll.get("e");
    }

    @Test
    public void removeFirstByIndex() throws Exception {
        LinkedList ll = new LinkedList();
        ll.push("a");
        ll.push("s");
        ll.push("d");
        ll.remove(0);
        String actual = "";
        for (Object s : ll) {
            actual = actual + s;
        }
        assertEquals("ssdd", ll.head.getItem() + actual + ll.tail.getItem());
    }

    @Test
    public void removeMiddleByIndex() throws Exception {
        LinkedList ll = new LinkedList();
        ll.push("a");
        ll.push("s");
        ll.push("d");
        ll.remove(1);
        String actual = "";
        for (Object s : ll) {
            actual = actual + s;
        }
        assertEquals("aadd", ll.head.getItem() + actual + ll.tail.getItem());
    }

    @Test
    public void removeLastByIndex() throws Exception {
        LinkedList ll = new LinkedList();
        ll.push("a");
        ll.push("s");
        ll.push("d");
        ll.remove(2);
        String actual = "";
        for (Object s : ll) {
            actual = actual + s;
        }
        assertEquals("aass", ll.head.getItem() + actual + ll.tail.getItem());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeExceptionByIndex() throws Exception {
        LinkedList ll = new LinkedList();
        ll.push("a");
        ll.push("s");
        ll.push("d");
        ll.remove(3);
    }

    @Test
    public void removeFirstByItem() throws Exception {
        LinkedList ll = new LinkedList();
        ll.push("a");
        ll.push("s");
        ll.push("d");
        ll.remove("a");
        String actual = "";
        for (Object s : ll) {
            actual = actual + s;
        }
        assertEquals("ssdd", ll.head.getItem() + actual + ll.tail.getItem());
    }

    @Test
    public void removeMiddleByItem() throws Exception {
        LinkedList ll = new LinkedList();
        ll.push("a");
        ll.push("s");
        ll.push("d");
        ll.remove("s");
        String actual = "";
        for (Object s : ll) {
            actual = actual + s;
        }
        assertEquals("aadd", ll.head.getItem() + actual + ll.tail.getItem());
    }

    @Test
    public void removeLastByItem() throws Exception {
        LinkedList ll = new LinkedList();
        ll.push("a");
        ll.push("s");
        ll.push("d");
        ll.remove("d");
        String actual = "";
        for (Object s : ll) {
            actual = actual + s;
        }
        assertEquals("aass", ll.head.getItem() + actual + ll.tail.getItem());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void removeExceptionByItem() throws Exception {
        LinkedList ll = new LinkedList();
        ll.push("a");
        ll.push("s");
        ll.push("d");
        ll.remove("e");
    }
}