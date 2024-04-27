import java.util.Iterator;

public class LinkedListDeque<T> {

    private static class Node<T> {
        T val;
        Node<T> prev;
        Node<T> next;
        public Node() {
            this.val = null;
        }
        public Node(T val) {
            this.val = val;
        }
        public Node(T val, Node<T> prev, Node<T> next) {
            this.val = val;
            this.prev = prev;
            this.next = next;
        }
    }

    Node<T> sentinel;
    int size;
    public LinkedListDeque() {
        size = 0;
        sentinel = new Node<T>();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public void addFirst(T item) {
        Node<T> added = new Node<>(item);
        added.next = sentinel.next;
        sentinel.next = added;
        added.next.prev = added;
        added.prev = sentinel;
        size++;
    }

    public void addLast(T item) {
        Node<T> added = new Node<>(item);
        added.prev = sentinel.prev;
        sentinel.prev = added;
        added.prev.next = added;
        added.next = sentinel;
        size++;
    }

    public boolean isEmpty() {return size == 0;}

    public int size() {return size;}

    public void printDeque() {
        Node<T> curr = sentinel.next;
        for (int i = 0; i < size - 1; i++) {
            System.out.print(curr.val );
            curr = curr.next;
        }
        System.out.print(curr.val);
    }

    public T removeFirst() {
        Node<T> curr = sentinel.next;
        sentinel.next = curr.next;
        curr.next.prev = sentinel;
        size--;
        return curr.val;
    }

    public T removeLast() {
        Node<T> curr = sentinel.prev;
        sentinel.prev = curr.prev;
        curr.prev.next = sentinel;
        size--;
        return curr.val;
    }

    public T get(int index) {
        Node<T> curr = sentinel.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }

    public T getRecursive(int index) {
        return getNode(index).val;
    }

    private Node<T> getNode(int index) {
        if (index == 0) return sentinel.next;
        return getNode(index - 1).next;
    }


}
