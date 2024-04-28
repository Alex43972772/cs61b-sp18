public class LinkedListDeque<T> implements Deque<T> {
    private static class Node<T> {
        private T val;
        private Node<T> prev;
        private Node<T> next;
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
    private Node<T> sentinel;
    private int size;
    public LinkedListDeque() {
        size = 0;
        sentinel = new Node<T>();
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }
    @Override
    public void addFirst(T item) {
        Node<T> added = new Node<>(item);
        added.next = sentinel.next;
        sentinel.next = added;
        added.next.prev = added;
        added.prev = sentinel;
        size++;
    }
    @Override
    public void addLast(T item) {
        Node<T> added = new Node<>(item);
        added.prev = sentinel.prev;
        sentinel.prev = added;
        added.prev.next = added;
        added.next = sentinel;
        size++;
    }
    @Override
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public int size() {
        return size;
    }
    @Override
    public void printDeque() {
        Node<T> curr = sentinel.next;
        for (int i = 0; i < size - 1; i++) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }
        System.out.print(curr.val);
    }
    @Override
    public T removeFirst() {
        if (size == 0) {
            return null;
        }
        Node<T> curr = sentinel.next;
        sentinel.next = curr.next;
        curr.next.prev = sentinel;
        size--;
        return curr.val;
    }
    @Override
    public T removeLast() {
        if (size == 0) {
            return null;
        }
        Node<T> curr = sentinel.prev;
        sentinel.prev = curr.prev;
        curr.prev.next = sentinel;
        size--;
        return curr.val;
    }
    @Override
    public T get(int index) {
        if (index >= size) {
            return null;
        }
        Node<T> curr = sentinel.next;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr.val;
    }
    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        return getNode(index).val;
    }
    private Node<T> getNode(int index) {
        if (index == 0) {
            return sentinel.next;
        }
        return getNode(index - 1).next;
    }
}
